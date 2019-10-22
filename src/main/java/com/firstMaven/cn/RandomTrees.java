package com.firstMaven.cn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSink;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.converters.DatabaseLoader;
import weka.filters.supervised.attribute.AddClassification;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.Filter;
import weka.classifiers.*;



public class RandomTrees {

	/*这里生成一个Instances的对象*/
	public Instances gen_Instances(){
		ArrayList<Attribute> attribute=new ArrayList<>();
		//attribute.add(new Attribute("APKName"));�����ĸ�apk��ɲ�������Ϊ��ǩ��������
		attribute.add(new Attribute("ApkName",(ArrayList<String>)null));//ѵ��ʱ��Ҫȥ���������ٹ鵽��Ӧapk����
		attribute.add(new Attribute("CRrate"));
		attribute.add(new Attribute("userNum"));
		attribute.add(new Attribute("userType"));
		attribute.add(new Attribute("senApiNum"));
		attribute.add(new Attribute("senApiType"));
		
		for(int i=1;i<13;i++){
			attribute.add(new Attribute("userAct"+i));
		}
		
		for(int i=1;i<124;i++){
			attribute.add(new Attribute("senApi"+i));
		}
		
		for(int i=1;i<139;i++){
			attribute.add(new Attribute("pers"+i));
		}
		
		
		
		//attribute.add(new Attribute("nfubtNum"));
		//attribute.add(new Attribute("nfubtType"));
		
		
		ArrayList<String> isPacked=new ArrayList();
		isPacked.add("no");
		isPacked.add("yes");
		
		attribute.add(new Attribute("isRepacked",isPacked));
		
		Instances instances=new Instances("DRegions",attribute,0);
		instances.setClassIndex(instances.numAttributes() - 1);
		
		/*System.out.println(instances.numAttributes());*/
		
		return instances;
	}
	

	
	/*将记载的apk信息输出为一个文件*/
	public void gen_Arff(Instances instances,String path) {//����ļ�
		ArffSaver saver=new ArffSaver();
		saver.setInstances(instances);
		
		try {
            saver.setFile(new File(path));
            saver.writeBatch();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


	/*
	输入训练样本，然后10折交叉验证分类效果
	 */

	public String RandomTreeUse(Instances instances) throws Exception {//调用随机森林接口，使用10折交叉验证
     	instances.setClassIndex(instances.numAttributes()-1);		
		
		String[] option=new String[4];
		option[0]="-R";
		option[1]="1";
		option[2]="7";
		option[3]="8";
		Remove rm=new Remove();
		rm.setAttributeIndices("1,7,8");
		rm.setInputFormat(instances);
		Instances instances1=Filter.useFilter(instances, rm);
		
	//	System.out.println(testInstances1);
	//	System.out.println("remove过滤后的实例"+testInstances);
		
		//后面10折交叉验证已经使用了随机数，故我这里就不用再设置随机数
		long seed=12341;
		Instances instances2=new Instances(instances1);
		instances2.randomize(new Random(seed));
	//	System.out.println("随机化之前的数据"+instances1);
     //		System.out.println("随机化后的数据"+instances2);
		
		String className="weka.classifiers.trees.RandomForest";
		String[] options=new String[2];
		options[0]="-I";
		options[1]="100";
		Classifier cf=(Classifier)Utils.forName(Classifier.class, className, options);
		
		
		/*AttributeSelection select=new AttributeSelection();
		CfsSubsetEval eval=new CfsSubsetEval();//评估子集权重
		GreedyStepwise search=new GreedyStepwise();//贪心算法搜索子集
		search.setSearchBackwards(true);
		select.setEvaluator(eval);
		select.setSearch(search);
		select.setInputFormat(testInstances);
		
		Instances newInstances=Filter.useFilter(testInstances, select);
		System.out.println("被处理过的子集"+newInstances);
		*/
		if(instances2.classAttribute().isNominal())
			instances2.stratify(10);
		Evaluation evaluation=new Evaluation(instances2);
	    Instances predict=null;
		for(int i=0;i<10;i++) {//10折交叉验证
			Instances train=instances2.trainCV(10, i);
			Instances test=instances2.testCV(10, i);
			Classifier cfs=AbstractClassifier.makeCopy(cf);
			cfs.buildClassifier(train);
			//System.out.println(cfs.getClass());
			evaluation.evaluateModel(cfs, test);	
		}
		
		/*System.out.println(evaluation.toSummaryString());*/
		String result=evaluation.toSummaryString();
		return result;
		
	}

	/*
	获取训练样本训练好的随机森林分类器
	 */
	public Classifier getRandomTreesClf(Instances instances)throws Exception{
		instances.setClassIndex(instances.numAttributes()-1);




		//	System.out.println(testInstances1);
		//	System.out.println("remove过滤后的实例"+testInstances);

		//后面10折交叉验证已经使用了随机数，故我这里就不用再设置随机数
		long seed=12341;
		Instances instances2=new Instances(instances);
		instances2.randomize(new Random(seed));
		//	System.out.println("随机化之前的数据"+instances1);
		//		System.out.println("随机化后的数据"+instances2);

		String className="weka.classifiers.trees.RandomForest";
		String[] options=new String[2];
		options[0]="-I";
		options[1]="100";
		Classifier cf=(Classifier)Utils.forName(Classifier.class, className, options);


		/*AttributeSelection select=new AttributeSelection();
		CfsSubsetEval eval=new CfsSubsetEval();//评估子集权重
		GreedyStepwise search=new GreedyStepwise();//贪心算法搜索子集
		search.setSearchBackwards(true);
		select.setEvaluator(eval);
		select.setSearch(search);
		select.setInputFormat(testInstances);

		Instances newInstances=Filter.useFilter(testInstances, select);
		System.out.println("被处理过的子集"+newInstances);
		*/
		Classifier cfs=null;
		try {
			Instances predict = null;
			cfs= AbstractClassifier.makeCopy(cf);
			cfs.buildClassifier(instances2);
		} catch (Exception e){
			System.out.println("分类器未正常生成，检查RandomTrees.getRandomTreesclf");
			e.printStackTrace();
		}


		return cfs;
	}
	

	/*
	输入待预测apk，训练数据集的路径和待预测数据集的路径，然后预测apk是否为良性或者恶意
	 */
	public String RandomTreeUse(APK apk,String practiceUrl,String testUrl) throws Exception {     // ֤
		DataSource source=new DataSource(practiceUrl);
		DataSource testSource=new DataSource(testUrl);
		
		Instances instances=source.getDataSet();
		Instances testInstances=testSource.getDataSet();
		instances.setClassIndex(instances.numAttributes()-1);
		testInstances.setClassIndex(testInstances.numAttributes()-1);

		//System.out.println("δ�������ݼ�"+instances);
		
		
		String[] option=new String[2];
		option[0]="-R";
		option[1]="1";
		Remove rm=new Remove();
		rm.setAttributeIndices("1");
		rm.setInputFormat(instances);
		Instances instances1=Filter.useFilter(instances, rm);
		
	    String[] option1=new String[2];
	    option1[0]="-R";
	    option1[1]="1";
		Remove rm1=new Remove();
		rm1.setAttributeIndices("1");
		rm1.setInputFormat(testInstances);
		Instances testInstances1=Filter.useFilter(testInstances, rm1);
		//System.out.println(testInstances1);
		//System.out.println("remove���˺��ʵ��"+testInstances);
		
		//����10�۽�����֤�Ѿ�ʹ����������������Ͳ��������������
		long seed=12341;
		Instances instances2=new Instances(instances1);
		instances2.randomize(new Random(seed));
		//System.out.println("���֮ǰ�����"+instances1);
		//System.out.println("��������"+instances2);
		
		String className="weka.classifiers.functions.SMO";
		String[] options=new String[2];
		options[0]="-C";
		options[1]="1";
		Classifier cf=(Classifier)Utils.forName(Classifier.class, className, options);
		
		
		/*AttributeSelection select=new AttributeSelection();
		CfsSubsetEval eval=new CfsSubsetEval();//�����Ӽ�Ȩ��
		GreedyStepwise search=new GreedyStepwise();//̰���㷨�����Ӽ�
		search.setSearchBackwards(true);
		select.setEvaluator(eval);
		select.setSearch(search);
		select.setInputFormat(testInstances);
		
		Instances newInstances=Filter.useFilter(testInstances, select);
		System.out.println("���������Ӽ�"+newInstances);
		*/
		if(instances2.classAttribute().isNominal())
			instances2.stratify(10);
		Evaluation evaluation=new Evaluation(instances2);
	    Instances predict=null;
	    
		for(int i=0;i<10;i++) {//10�۽�����֤
			Instances train=instances2.trainCV(10, i);
			Instances test=instances2.testCV(10, i);
			Classifier cfs=AbstractClassifier.makeCopy(cf);
			cfs.buildClassifier(train);
			//System.out.println(cfs.getClass());
			evaluation.evaluateModel(cfs, test);
			if(i==9){
			AddClassification filter=new AddClassification();
			filter.setClassifier(cfs);
			filter.setInputFormat(testInstances1);
			filter.setOutputClassification(true);
			Filter.useFilter(instances2, filter);
			Instances pred=Filter.useFilter(testInstances1, filter);
			if(predict==null) {
				predict=new Instances(pred,0);
			}
			for(int j=0;j<pred.numInstances();j++) {
				predict.add(pred.instance(j));
			}
		  }
		}
		String finalPath="D:/adver_study/arff/final"+apk.getAPKName()+".arff";
		DataSink.write(finalPath,predict);
		
		
		/*System.out.println(evaluation.toSummaryString());*/
		//System.out.println(evaluation.areaUnderROC(0));
		return finalPath;
		
	}
	
	public void DecideTreeUse(String path,String testUrl) throws Exception {
		DataSource data=new DataSource(path);
		Instances instances=data.getDataSet();
		instances.setClassIndex(instances.numAttributes()-1);
		String[] options=new String[2];
		options[0]="-R";
		options[1]="1";
		Remove rm=new Remove();
		rm.setOptions(options);
		rm.setInputFormat(instances);
		Instances testInstances=Filter.useFilter(instances, rm);
		J48 j48=new J48();
		j48.buildClassifier(testInstances);
		Evaluation eva=new Evaluation(testInstances);
		eva.evaluateModel(j48, testInstances);
		/*System.out.println(eva.toSummaryString());*/
		
	}
	

	public void setPacked(APK apk,String testPath,String finalPath) throws Exception {
		DataSource testData=new DataSource(testPath);
		DataSource finalData=new DataSource(finalPath);
		Instances testInstances=testData.getDataSet();
		Instances finalInstances=finalData.getDataSet();
	    
		setClassGraphPacked(apk,finalInstances);
		apk.setPacked(0);
		for(int i=0;i<testInstances.numInstances();i++) {
				
			String[] testArray=StringUtils.split(testInstances.instance(i).toString(),",");
			String[] finalArray=StringUtils.split(finalInstances.instance(i).toString(),",");
				
				
			if(testArray[0].equals(apk.getAPKName())
			   &&finalArray[finalArray.length-1].equals("yes")) {
			     apk.setPacked(1);
			     break;
			}
		}
			System.out.println(apk.getAPKName());
			System.out.println(apk.isPacked());
		
	}
	
	public void setClassGraphPacked(APK apk,Instances instances){
		List<ClassGraph> classGraphList=apk.getClassGraphList();
		if(classGraphList==null||classGraphList.size()==0)
			return;
		for(ClassGraph classGraph:classGraphList){
			
			Features features=classGraph.getFeatures();
			for(int i=0;i<instances.numInstances();i++){
			  
			  String[] finalArray=StringUtils.split(instances.instance(i).toString(),",");
			  
			    String CRrate=""+features.getCRrate();
			   int minLength=selectLength(finalArray[0],CRrate);
			   if(minLength>0){
			   finalArray[0]=finalArray[0].substring(0, minLength-1);
			   CRrate=CRrate.substring(0, minLength-1);
			   }
			 
			    String userActionNum=""+features.getUserActionNum();
			    String userActionType=""+features.getUserActionType();
			    String senApiNum=""+features.getSenApiNum();
			    String senApiType=""+features.getSenApiType();
			 
			    if(CRrate.equals(finalArray[0])&&userActionNum.equals(finalArray[1])&&userActionType.equals(finalArray[2])&&senApiNum.equals(finalArray[3])
			    		&&senApiType.equals(finalArray[4])){
			    	System.out.println("why");
			    	System.out.println(finalArray[finalArray.length-1]);
			    	if(finalArray[finalArray.length-1].equals("yes")){
			    		classGraph.setIsPacked(1);
			    		
			    	}
			    	else{
			    		classGraph.setIsPacked(0);
			    	}
			    }
			}
		}
	}
	
	public int selectLength(String a,String b){
		if(a.length()>b.length())
			return b.length();
		else
			return a.length();
	}

	
	public void featureRanker(String path) throws Exception{
		DataSource ds=new DataSource(path);



	    Instances trainIns = ds.getDataSet();

		trainIns.setClassIndex(trainIns.numAttributes()-1);



		Ranker rank = new Ranker();

		InfoGainAttributeEval eval = new InfoGainAttributeEval();


		eval.buildEvaluator(trainIns);

		/*System.out.println(rank.search(eval, trainIns));*/



		int[] attrIndex = rank.search(eval, trainIns);


		StringBuffer attrIndexInfo = new StringBuffer();

		 StringBuffer attrInfoGainInfo = new StringBuffer();

		attrIndexInfo.append("Selected attributes:");

		attrInfoGainInfo.append("Ranked attributes:/n");

		for(int i = 0; i < attrIndex.length; i ++){

		attrIndexInfo.append(attrIndex[i]);

		attrIndexInfo.append(",");


		attrInfoGainInfo.append(eval.evaluateAttribute(attrIndex[i]));

		attrInfoGainInfo.append("/t");

		attrInfoGainInfo.append((trainIns.attribute(attrIndex[i]).name()));

		attrInfoGainInfo.append("/n");



	    System.out.println(attrIndexInfo.toString());

	    System.out.println(attrInfoGainInfo.toString());
	}
	}
	
	
}
