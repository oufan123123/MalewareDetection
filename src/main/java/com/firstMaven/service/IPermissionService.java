package com.firstMaven.service;

import com.firstMaven.cn.ClassGraph;
import com.firstMaven.pojo.Permission;

import java.util.List;

public interface IPermissionService {

    /*
    处理对权限的查询任务
     */
    public String[] getAllPermission();

    /*
    处理查询apk分区中权限信息
     */
    public int[] getAllPermissionFromApk(ClassGraph classGraph,String[] permissionList);
}
