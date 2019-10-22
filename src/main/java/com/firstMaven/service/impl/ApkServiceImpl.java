package com.firstMaven.service.impl;

import brut.directory.DirectoryException;
import com.firstMaven.Runnable.ApiServiceRunnable;
import com.firstMaven.Runnable.PermissionServiceRunnable;
import com.firstMaven.cn.*;
import com.firstMaven.service.IApiService;
import com.firstMaven.service.IApkService;
import com.firstMaven.pojo.Apk;
import com.firstMaven.service.IPermissionService;
import weka.classifiers.Classifier;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import weka.core.DenseInstance;
import weka.core.Instances;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("apkService")
public class ApkServiceImpl implements IApkService {


    @Resource
    private IPermissionService iPermissionService;

    @Override
    public Apk doDetection(String apkUrl){

        System.out.println("1");
        Apk apk=null;
        return apk;
    }

    /*将一个apk的信息录入Instances中去*/
    @Override
    public Instances set_Instances(Instances instances, APK apk){
        List<ClassGraph> list=apk.getClassGraphList();

        if(list==null||list.size()==0){
            return instances;
        }


        ArrayList<String> isPacked=new ArrayList();
        isPacked.add("no");
        isPacked.add("yes");

        /*
        设置线程池的最大值，保证线程数量不能超过这个值
         */
        int Max_Thread=90;
        ExecutorService executorService=Executors.newFixedThreadPool(Max_Thread);
        String[] permissionNameList=iPermissionService.getAllPermission();
        for(int i=0;i<list.size();i++){

            Features features=list.get(i).getFeatures();
            double[] instance=new double[instances.numAttributes()];
            instance[0]=instances.attribute(0).addStringValue(apk.getAPKName());
            instance[1]=features.getCRrate();
            instance[2]=features.getUserActionNum();
            instance[3]=features.getUserActionType();

            Integer[] userActionList=features.getUserActionList();
            Runnable apiServiceRunnable=new ApiServiceRunnable("Runnable"+i,list.get(i));
            Thread apiThread=new Thread(apiServiceRunnable);
            apiThread.start();
            // 搞清楚这里的接口对象为什么不能直接调用实现类的函数，难道如父类对象不能调用子类函数的特有方法一般？？？？
            int[] senApi= ((ApiServiceRunnable) apiServiceRunnable).getSenApiArray();

            executorService.submit(apiThread);

            Runnable permissionServiceRunnable=new PermissionServiceRunnable("Runnable"+i,list.get(i),permissionNameList);
            Thread permissionThread=new Thread(permissionServiceRunnable);
            permissionThread.start();
            int[] perMis=((PermissionServiceRunnable)permissionServiceRunnable).getPermissionArray();

            executorService.submit(apiThread);

            if(senApi==null){
                /*System.out.println("senApi[]==null");*/
                instances.add(new DenseInstance(1.0,instance));
                if(apk.isPacked()==0){
                    instance[instances.numAttributes()-1]=isPacked.indexOf("no");
                } else{
                    instance[instances.numAttributes()-1]=isPacked.indexOf("yes");
                }
                continue;
            }





            instance[4]=senApi[123];
            instance[5]=senApi[124];

            features.setUserActionNum(senApi[123]);
            features.setUserActionType(senApi[124]);



		    /*
		     为用户监督函数设置特征
		     */
            if(userActionList!=null&&userActionList.length>0){
                for(int j=6;j<18;j++){
                    if(userActionList[j-6]>0){
                        instance[j]=1;
                    } else{
                        instance[j]=0;
                    }
                }
            }

            /*为敏感api设置特征*/
            for(int j=18;j<141;j++){
                if(senApi[j-18]>0){
                    instance[j]=1;
                } else{
                    instance[j]=0;
                }
            }

            /*为敏感权限设置特征*/
            for(int j=141;j<instances.numAttributes()-1;j++){
                if(perMis[j-141]>0){
                    instance[j]=1;
                } else{
                    instance[j]=0;
                }

            }




            if(apk.isPacked()==0){
                instance[instances.numAttributes()-1]=isPacked.indexOf("no");
            } else{
                instance[instances.numAttributes()-1]=isPacked.indexOf("yes");
            }

            if(instance[1]==0&&instance[4]==0&&instance[5]==0){
                continue;
            } else if(instance[1]==0&&instance[2]==0&&instance[3]==0){
                continue;
            } else if(instance[2]==0&&instance[3]==0&&instance[4]==0&&instance[5]==0){
                continue;
            }

            instances.add(new DenseInstance(1.0,instance));

        }

        executorService.shutdown();
        return instances;

    }

    @Override
    public String doPractice(String goodUrl,String badUrl){

        Decode decoder=new Decode();
        APK apkFunction=new APK();

        String unzipGoodUrl =null;
        String unzipBadUrl =null;
		/*
		反编译重打包和良性数据集
		 */
		try {
            unzipGoodUrl = decoder.decodeAPK(goodUrl, 0);
           unzipBadUrl = decoder.decodeAPK(badUrl, 1);
        } catch (Exception e){
		    e.printStackTrace();
        }

		/*
		读取所有的解压apk文件目录下的smali文件夹
		 */
        FileRead read=new FileRead();
        List<String> goodUrlList=read.getAllUrl(unzipGoodUrl);
        List<String> badUrlList=read.getAllUrl(unzipBadUrl);

		/*
		构造instances模板变量，训练数据集一个一个往里面添加即可
		*/
        RandomTrees randomTrees=new RandomTrees();
        Instances instances=randomTrees.gen_Instances();


        String result=null;

		/*
		挨个读取所有良性apk目录下的smali文件
		 */
        if(goodUrlList!=null&&goodUrlList.size()>0){

            for(String url:goodUrlList) {
                APK apk=apkFunction.getOneApk(url);
                if(apk==null){
                    continue;
                }

	        	/*
	        	读取所有的apk对应的类图，获取特征并设置
	        	 */
                List<ClassGraph> classGraphList=apkFunction.getAllClassGraph(url);
                apkFunction.setFeatures(classGraphList);
                apk.setClassGraphList(classGraphList);
                apk.setPacked(0);

                /*
                如果是单apk分区，则将apk的instance设置好
                 */
                if(apkFunction.getSingleDReginAPK(apk)){
                    instances=set_Instances(instances,apk);
                }



                apk.setClassGraphList(null);
                apk=null;

            }
        }

        /*
        与上同理，输入恶意apk的所有路径，然后获得所有的单apk分区的恶意样本
         */
        if(badUrlList!=null&&badUrlList.size()>0){
            /*
            读取所有恶意apk
             */
            for(String url:badUrlList) {
                APK apk=apkFunction.getOneApk(url);
                if(apk==null)
                    continue;
                /*
                获得所有的类图特征
                 */
                List<ClassGraph> classGraphList=apkFunction.getAllClassGraph(url);
                apkFunction.setFeatures(classGraphList);
                apk.setClassGraphList(classGraphList);
                apk.setPacked(1);

                /*
                设置instances
                 */
                if(apkFunction.getSingleDReginAPK(apk)) {

                    instances=set_Instances(instances, apk);

                }





                apk.setClassGraphList(null);
                apk=null;
            }
        }







        randomTrees.gen_Arff(instances,"D:/adver_study/newarff/badresult.arff");


        result="run over here";
        return result;
    }


}
