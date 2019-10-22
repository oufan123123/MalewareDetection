package com.firstMaven.Runnable;

import com.firstMaven.cn.ClassGraph;
import com.firstMaven.dao.SensitiveApiMapper;
import com.firstMaven.service.IApiService;

/*

 */

public class ApiServiceRunnable implements Runnable{

    private Thread thread;
    private String threadName;
    private IApiService iApiService;
    private int[] senApiArray;
    private ClassGraph classGraph;

    public ApiServiceRunnable(String threadName,ClassGraph classGraph){
        this.threadName=threadName;
        this.classGraph=classGraph;
    }

    public ApiServiceRunnable(){}

    public void run(){


        try{
            this.senApiArray=iApiService.getAllApi(classGraph);
        } catch(Exception e){
            System.out.println("classGraph为空，发生在ApiServiceRunnable");
            e.printStackTrace();
        }
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public IApiService getiApiService() {
        return iApiService;
    }

    public void setiApiService(IApiService iApiService) {
        this.iApiService = iApiService;
    }

    public int[] getSenApiArray() {
        return senApiArray;
    }

    public void setSenApiArray(int[] senApiArray) {
        this.senApiArray = senApiArray;
    }

    public ClassGraph getClassGraph() {
        return classGraph;
    }

    public void setClassGraph(ClassGraph classGraph) {
        this.classGraph = classGraph;
    }
}
