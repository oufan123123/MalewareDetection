package com.firstMaven.cn;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.firstMaven.service.IApkService;
import org.apache.commons.lang3.StringUtils;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;




public class APK {

	private String APKName;
	private List<ClassGraph> classGraphList;
	private int Nmali;
	private int Ntotal;
	private String url;
	private int isPacked;
	private IApkService iApkService;
	
	
	
	
	
	
	public int isPacked() {
		return isPacked;
	}
	public void setPacked(int isPacked) {
		this.isPacked = isPacked;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAPKName() {
		return APKName;
	}
	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}
	public List<ClassGraph> getClassGraphList() {
		return classGraphList;
	}
	public void setClassGraphList(List<ClassGraph> classGraphList) {
		this.classGraphList = classGraphList;
	}
	public int getNmali() {
		return Nmali;
	}
	public void setNmali(int nmali) {
		Nmali = nmali;
	}
	public int getNtotal() {
		return Ntotal;
	}
	public void setNtotal(int ntotal) {
		Ntotal = ntotal;
	}
	
	
	public List<APK> getSingleDReginAPK(List<APK> apkList){//������еĵ�������ͼ��apk����������ѵ��������
		
	    List<APK> singleDRegionApkList=new ArrayList();
		for(int i=0;i<apkList.size();i++) {
			APK apk=apkList.get(i);
		    if(apk.getClassGraphList().size()==1) {
			   singleDRegionApkList.add(apk);
		    }
	     }
		return singleDRegionApkList;
	}
	
	public boolean getSingleDReginAPK(APK apk){//获得所有的单个依赖图的apk，并且用于训练分类器
		
		if(apk.getClassGraphList()==null||apk.getClassGraphList().size()!=1) {
			return false;
		}
		   
			return true;
		}
	

	/*
	想想如何做对抗样本
	 */

	

	

	
	public List<APK> getClassGraph(String path,int isPacked) {//������е�apk������ͼ������ɸ�����е�R��
		
		FileRead read=new FileRead();
		List<String> allUrl=read.getAllUrl(path);
		
		List<APK> apkList=getAllApk(allUrl);//�������������apk���apk
		if(apkList==null||apkList.size()==0)
			return null;
		setAllClassGraph(apkList);//�����е�apk����������ͼ
		for(int i=0;i<apkList.size();i++) {//������apk�����Ƿ��ش���ǩ
			apkList.get(i).setPacked(isPacked);
		}
	   
		return apkList;		
		
	}
	
	public APK getClassGraph(String path){
		FileRead read=new FileRead();
		List<String> allUrl=read.getUrl(path);
		List<APK> apkList=getAllApk(allUrl);
		if(apkList==null||apkList.size()==0)
			return null;
		setAllClassGraph(apkList);
	    for(APK apk:apkList) {//��Բ��������ҽ����Ƿ�������Ϊ-1����ʾδ֪
	    	apk.setPacked(-1);
	    }
	    if(apkList!=null&&apkList.size()==1)
	    	return apkList.get(0);
	    else
	    	return null;
	}
	
	public List<APK> getAllApk(List<String> allUrl){//��ȡ���е�apk�ļ���url
		if(allUrl==null||allUrl.size()==0) {
			System.out.println("����smali�ļ�����,Ȼ�����¿�ʼ");
			return null;
		}
		System.out.println(allUrl.size());
		
		List<APK> apkList=new ArrayList();
		APK apk=null;
		for(int i=0;i<allUrl.size();i++) {
			apk=new APK();
			/*System.out.println(allUrl.get(i));*/
			String[] url=StringUtils.split(allUrl.get(i),"\\\\");
			String apkName=url[url.length-2];
			apk.setAPKName(apkName);
			apk.setUrl(allUrl.get(i));
			apkList.add(apk);
		}
		return apkList;
	}
	
	public APK getOneApk(String url) {
		if(url==null) {
			System.out.println("文件不存在，请检查输入");
			return null;
		}
			APK apk=new APK();
			String[] ss=StringUtils.split(url,"\\\\");
			String apkName=ss[ss.length-2];
			apk.setAPKName(apkName);
			apk.setUrl(url);
			return apk;
	}
	
	public void setAllClassGraph(List<APK> apkList) {//��������ֵ������ͼ�ӵ�apk������
		
		for(int i=0;i<apkList.size();i++) {
			APK apk=apkList.get(i);
			String url=apk.getUrl();
			List<ClassGraph> classGraphList=getAllClassGraph(url);
			
			
			setFeatures(classGraphList);
			apk.setClassGraphList(classGraphList);
		}
	}
	
	public List<ClassGraph> getAllClassGraph(String url){//�õ�һ��apk�ľ���ɸѡR�����ͼ
		AllClassDependence allClassDependence=new AllClassDependence();
		AllMethodDependence allMethodDependence=new AllMethodDependence();
		
		allClassDependence=allClassDependence.getAllClassDependence(url);//���������������ϵ
		allMethodDependence=allMethodDependence.getAllMethodDependence(url);//������еķ���������ϵ
		
		ClassGraph classGraph=new ClassGraph();
		List<ClassGraph> classGraphList=classGraph.gen_CDG(allClassDependence);
		classGraph.gen_MCG(classGraphList, allMethodDependence);
		 selectClassGraph(classGraphList);//ɸѡ��R��
		return classGraphList;
	}
	
	public void setFeatures(List<ClassGraph> classGraphList) {//����DRegion������ֵ
		
		for(ClassGraph classGraph:classGraphList) {
			List<MethodVertex> methodVertexList=classGraph.getMethodVertexList();
			for(MethodVertex methodVertex:methodVertexList) {
				//System.out.println(methodVertex.getMethodName());
				List<MethodEdge> methodEdgeList=methodVertex.getMethodEdgeList();
				//if(methodEdgeList==null)
					//System.out.println(0);
			//	else {
				//	System.out.println(methodEdgeList.size());
				//}
			}
		}
		for(int i=0;i<classGraphList.size();i++) {
			Features features=new Features();
			ClassGraph classGraph1=classGraphList.get(i);
			if(classGraph1!=null)
			features=features.getFeatures(classGraph1);
			else
				continue;
			classGraph1.setFeatures(features);
			if(features!=null) {
				
				if(features.getCRrate()!=0) {
					
				/*System.out.println(features.getCRrate());
				System.out.println("num:"+features.getUserActionNum());
				System.out.println("type:"+features.getUserActionType());*/
				}
				
				
			}
		}
	}
	
	public void selectClassGraph(List<ClassGraph> classGraphList) {//��R��ɸѡ��
		   if(classGraphList==null||classGraphList.size()==0)
		     	return;
		  // System.out.println(classGraphList.size());
			for(int j=0;j<classGraphList.size();j++) {
				//System.out.println(classGraphList.get(j).getClassVertexList().get(0).getClassName());
				//System.out.println(classGraphList.get(j).getClassVertexList().size());
				if(classGraphList.get(j).getClassEdgeList().size()>0) {
					
				//	System.out.println("1");
					continue;
				}
				
				classGraphList.remove(j);
				j--;
			}
		
	}
	
	
	
	
}
