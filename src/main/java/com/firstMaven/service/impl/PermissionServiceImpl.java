package com.firstMaven.service.impl;

import com.firstMaven.cn.ClassGraph;
import com.firstMaven.cn.MethodVertex;
import com.firstMaven.cn.MethodEdge;
import com.firstMaven.cn.MethodGraph;
import com.firstMaven.dao.PermissionMapper;
import com.firstMaven.pojo.Permission;
import com.firstMaven.pojo.PermissionExample;
import com.firstMaven.service.IPermissionService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService{

    @Resource
    private PermissionMapper permissionMapper;

    /*
    此方法不需要使用线程查询，因为一个apk只用执行一次，
     */
    @Override
    public String[] getAllPermission(){
        PermissionExample permissionExample=new PermissionExample();
        /*
        查询所有的权限，并以字符串的形式返回
         */
        String[] allPermissionArray=new String[138];
        try {
            List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);

            if(permissionList!=null&&permissionList.size()>0) {
                for(int i=0;i<138;i++){
                    allPermissionArray[i]=permissionList.get(i).getName();
                }
            }
        } catch(Exception e){
            System.out.println("problem happen in permissionService");
            e.printStackTrace();
        }
            return allPermissionArray;



    }

    /*
    此方法查询一个apk分区的所有权限，一个查询对应一个Runnable线程，注意控制权限查询和api查询的总数为90
     */
    @Override
    public int[] getAllPermissionFromApk(ClassGraph classGraph, String[] permissionList){

        //这里我考虑每个函数若调用相同的敏感api，对应相同的危险权限，算作多次调用这个权限，也就是说统计重复调用次数
        List<MethodVertex> methodVertexList=classGraph.getMethodVertexList();
        if(methodVertexList==null||methodVertexList.size()==0)
            return null;
        int[] nameNum=new int[138];
        for(MethodVertex methodVertex:methodVertexList) {
            List<MethodEdge> methodEdgeList=methodVertex.getMethodEdgeList();
            if(methodEdgeList==null||methodEdgeList.size()==0)
                continue;
            for(MethodEdge methodEdge:methodEdgeList){
                String className=methodEdge.getNextClassName();
                String methodName=methodEdge.getNextMethodName();
                String content=methodEdge.getContent();

                /*
                调用mybatis查询对应content的权限信息
                 */
                List<Permission> permissionWithContentList=permissionMapper.selectPermissionAndMapping401(content);

                if(permissionWithContentList==null||permissionWithContentList.size()==0)
                    continue;


                String level1="dangerous"; // 对应的level为1
                String level2="signature"; // 对应的level为2
                String level3="system|signature"; // 对应的level为3
                String level4="signature|privileged"; // 对应的level为4
                // 其他的type对应为5
                List<Integer> levelList=new ArrayList();
                List<String> nameList=new ArrayList();


                for(Permission permission:permissionWithContentList) {


                    String level=permission.getLevel();
                    String name=permission.getName();




                    if(name==null||name.equals("DUMP")){
                        break;
                    }

                    nameList.add(name);


                    Integer num=5;
                    if(level==null){

                        levelList.add(num);
                    }  else if(level.equals(level1)){
                        num=1;
                        levelList.add(num);
                    } else if(level.equals(level2)){
                        num=2;
                        levelList.add(num);
                    } else if(level.equals(level3)){
                        num=3;
                        levelList.add(num);
                    } else if(level.equals(level4)){
                        num=4;
                        levelList.add(num);
                    } else{
                        num=5;
                        levelList.add(num);
                    }




                }

                /*System.out.println("-------------------待选"+nameList.size());*/

				/*for(int i=0;i<nameList.size();i++){
					System.out.println(nameList.get(i));
					System.out.println(levelList.get(i));

				}*/

                int id=0;
                if(nameList.size()==0){ // 没有对应权限，跳过
                    continue;
                } else if(nameList.size()==1){ // 对应的权限只找到一个版本的，直接将对应版本的个数加一
                    id=findByName(nameList.get(0),permissionList);
                    nameNum[id]++;
                } else { // 对应的权限不止一个，则要进行比较，将最新版本对应的权限加一
                    int x=findBiggestLevel(levelList);
                    id=findByName(nameList.get(x),permissionList);
                    nameNum[id]++;
                }

                /*System.out.println("-------------------已经选择"+id);*/







            }
        }

        return nameNum;


    }

    public static int findBiggestLevel(List<Integer> levelList){
        if(levelList==null||levelList.size()==0){
            return -1;
        }
        Integer max=levelList.get(0);
        int maxIndex=0;
        for(int i=1;i<levelList.size();i++){
            if(max<levelList.get(i)){
                max=levelList.get(i);
                maxIndex=i;
            }

        }
        return maxIndex;
    }





    public static int findByName(String name,String[] permissionList){
        for(int i=0;i<permissionList.length;i++){
            if(permissionList[i].equals(name))
                return i;
        }
        return -1;
    }




}
