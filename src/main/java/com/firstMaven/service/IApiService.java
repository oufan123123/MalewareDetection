package com.firstMaven.service;

import com.firstMaven.cn.ClassGraph;

public interface IApiService {

    /*
    查询所有的接口信息
     */
    public int[] getAllApi(ClassGraph classGraph);
}
