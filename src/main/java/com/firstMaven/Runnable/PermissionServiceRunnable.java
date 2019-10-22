package com.firstMaven.Runnable;

import com.firstMaven.cn.ClassGraph;
import com.firstMaven.service.IPermissionService;

public class PermissionServiceRunnable implements Runnable{


    private String threadName;
    private ClassGraph classGraph;
    private String[] allPermissionArray;
    private int[] permissionArray;
    private IPermissionService iPermissionService;

    public PermissionServiceRunnable(String threadName,ClassGraph classGraph,String[] allPermissionArray){
        this.threadName=threadName;
        this.classGraph=classGraph;
        this.allPermissionArray=allPermissionArray;
    }

    public void run(){
        try{
            permissionArray=iPermissionService.getAllPermissionFromApk(classGraph,allPermissionArray);
        } catch(Exception e){
            System.out.println("permissionArray或者classGraph为空，问题出在PermissionServiceRunnable上面");
            e.printStackTrace();
        }

    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public ClassGraph getClassGraph() {
        return classGraph;
    }

    public void setClassGraph(ClassGraph classGraph) {
        this.classGraph = classGraph;
    }

    public String[] getAllPermissionArray() {
        return allPermissionArray;
    }

    public void setAllPermissionArray(String[] allPermissionArray) {
        this.allPermissionArray = allPermissionArray;
    }

    public int[] getPermissionArray() {
        return permissionArray;
    }

    public void setPermissionArray(int[] permissionArray) {
        this.permissionArray = permissionArray;
    }

    public IPermissionService getiPermissionService() {
        return iPermissionService;
    }

    public void setiPermissionService(IPermissionService iPermissionService) {
        this.iPermissionService = iPermissionService;
    }
}
