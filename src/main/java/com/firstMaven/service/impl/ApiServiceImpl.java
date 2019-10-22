package com.firstMaven.service.impl;

import com.firstMaven.dao.SensitiveApiMapper;
import com.firstMaven.pojo.SensitiveApi;
import com.firstMaven.pojo.SensitiveApiExample;
import com.firstMaven.service.IApiService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.firstMaven.cn.MethodVertex;
import com.firstMaven.cn.MethodEdge;
import com.firstMaven.cn.MethodGraph;
import com.firstMaven.cn.ClassGraph;

import java.util.Iterator;
import java.util.List;

@Service("apiService")
public class ApiServiceImpl implements IApiService{

    @Resource
    private SensitiveApiMapper sensitiveApiMapper;


    /*
    此方法使用Runnable封装，用线程一次次的去查询，api查询和permission查询总数不能超过90，低于数据库最大连接100
     */
    @Override
    public int[] getAllApi(ClassGraph classGraph){
        /*多出来的是计算api的数量和总数的*/
        int senApiNum=0;
        int senApiType=0;
        int senApi[];

        List<MethodVertex> methodVertexList=classGraph.getMethodVertexList();

        if(methodVertexList==null||methodVertexList.size()==0)
            return null;

        senApi=new int[125];






        for(MethodVertex methodVertex:methodVertexList) {
            List<MethodEdge> methodEdgeList=methodVertex.getMethodEdgeList();
            if(methodEdgeList==null||methodEdgeList.size()==0)
                continue;
            for(MethodEdge methodEdge:methodEdgeList) {
                String className=methodEdge.getNextClassName();
                String methodName=methodEdge.getNextMethodName();
                String content=methodEdge.getContent();


                String hql="select spt.id from SensitiveApi sp,SenApiType spt where sp.id=spt.senApiId and sp.content='"+content+"'";

                List<SensitiveApi> list=sensitiveApiMapper.selectSenApiId(content);

                //System.out.println(classGraph.getClassVertexList().size());
                if(list.size()==0) {
                    //	System.out.println(sql);
                    continue;
                }
                int cont=0;
                for(SensitiveApi sensitiveApi:list){
                    int id=sensitiveApi.getId();
					/*System.out.println("select sen-api"+id);
					System.out.println(cont);*/
                    cont++;
                    if(senApi[id-1]!=0){
                        senApiNum++;
                    } else{
                        senApiNum++;
                        senApiType++;
                        senApi[id-1]=1;
                    }
                }


            }
        }

        senApi[123]=senApiNum;
        senApi[124]=senApiType;

        return senApi;
    }
}
