package com.firstMaven.service;

import com.firstMaven.cn.APK;
import com.firstMaven.pojo.Apk;
import weka.core.Instances;

public interface IApkService {
    /*
    完成对输入apk的检测任务
     */
    public Apk doDetection(String apkUrl);

    /*
    设置apk的instance
     */
    public Instances set_Instances(Instances instances, APK apk);

    /*
     解析所有的apk训练样本,最后将样本的instances存放起来。
     */
    public String doPractice(String goodUrl,String badUrl);


}

