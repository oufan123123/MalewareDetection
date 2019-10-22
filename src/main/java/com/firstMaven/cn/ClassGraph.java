package com.firstMaven.cn;

import java.util.*;
import java.io.*;

public class ClassGraph {

	
	private List<ClassVertex> classVertexList;
	private List<ClassEdge> classEdgeList;
	private List<MethodVertex> methodVertexList;
	private List<MethodGraph> methodGraphList;//��ʱ����!!!!
	private Features features;
	private int isPacked;//ʲôʱ��ʲô����ӣ�һ���ɱΣ�������
	
	
	
	

	
	

	public int getIsPacked() {
		return isPacked;
	}
	public void setIsPacked(int isPacked) {
		this.isPacked = isPacked;
	}
	public List<MethodVertex> getMethodVertexList() {
		return methodVertexList;
	}
	public void setMethodVertexList(List<MethodVertex> methodVertexList) {
		this.methodVertexList = methodVertexList;
	}
	public Features getFeatures() {
		return features;
	}
	public void setFeatures(Features features) {
		this.features = features;
	}
	public List<MethodGraph> getMethodGraphList() {
		return methodGraphList;
	}
	public void setMethodGraphList(List<MethodGraph> methodGraphList) {
		this.methodGraphList = methodGraphList;
	}
	public List<ClassVertex> getClassVertexList() {
		return classVertexList;
	}
	public void setClassVertexList(List<ClassVertex> classVertexList) {
		this.classVertexList = classVertexList;
	}
	public List<ClassEdge> getClassEdgeList() {
		return classEdgeList;
	}
	public void setClassEdgeList(List<ClassEdge> classEdgeList) {
		this.classEdgeList = classEdgeList;
	}
	
	
	 

	public void gen_MCG(List<ClassGraph> classGraphList,AllMethodDependence allMethodDependence){
		List<MethodGraph> methodGraphList=new ArrayList();
		List<MethodVertex> methodVertexList=allMethodDependence.getMethodVertexList();
		if(methodVertexList==null) {
			System.out.println("apk�޺������");
			return;
		}
		for(int i=0;i<methodVertexList.size();i++) {
			MethodVertex methodVertex=methodVertexList.get(i);
			ClassGraph belongClassGraph=findBelongClassGraph(classGraphList,methodVertex);
			if(belongClassGraph==null)
				continue;
			else {
				List<MethodVertex> thisMethodVertexList=belongClassGraph.getMethodVertexList();
				if(thisMethodVertexList==null) {
					List<MethodVertex> newMethodVertexList=new ArrayList();
					newMethodVertexList.add(methodVertex);
					belongClassGraph.setMethodVertexList(newMethodVertexList);
				}
				else {
				thisMethodVertexList.add(methodVertex);	
				}
			}
		}
	}
	
	public List<ClassGraph> gen_CDG(AllClassDependence allClassDependence){
		List<ClassGraph> classGraphList=new ArrayList();
		List<ClassVertex> allClassVertex=allClassDependence.getClassVertexList();
		List<ClassEdge> allClassEdge=allClassDependence.getClassEdgeList();
		Stack<ClassVertex> stack=new Stack<ClassVertex>();
	    for(int i=0;i<allClassVertex.size();i++) {
	    	if(allClassVertex.get(i).isVisited()==true)
	    		continue;
	    	ClassGraph classGraph=new ClassGraph();
	    	List<ClassVertex> classVertexList=new ArrayList();//�������CDG�ĵ�洢
	    	List<ClassEdge> classEdgeList=new ArrayList();//�������CDG�ıߴ洢
	    	ClassVertex firstClassVertex=allClassVertex.get(i);
	    	firstClassVertex.setVisited(true);
	    	classVertexList.add(firstClassVertex);
	    	stack.push(firstClassVertex);
	    	while(!stack.empty()) {//
	    		ClassVertex classVertex=stack.peek();
	    		int flag=0;
	    		for(int j=0;j<allClassEdge.size();j++) {
	    			ClassVertex findClassVertex=checkEdge(allClassEdge.get(j),classVertex);
	    			if(findClassVertex!=null) {
	    				findClassVertex.setVisited(true);
	    				classVertexList.add(findClassVertex);
	    				classEdgeList.add(allClassEdge.get(j));
	    				stack.push(findClassVertex);
	    				flag++;
	    				break;
	    			}
	    		}
	    		if(flag==0) {
	    			ClassVertex outClassVertex=stack.pop();	
	    		}
	    	}
	    	classGraph.setClassVertexList(classVertexList);
	    	classGraph.setClassEdgeList(classEdgeList);
	    	classGraphList.add(classGraph);
	    }
	    return classGraphList;
	}
	

	
	public ClassVertex checkEdge(ClassEdge classEdge,ClassVertex classVertex) {
		ClassVertex classVertex1=classEdge.getClassVertex1();
		ClassVertex classVertex2=classEdge.getClassVertex2();
		if(classVertex1.getClassName().equals(classVertex.getClassName())&&classVertex2.isVisited()==false) {
			return classVertex2;
		}
		else if(classVertex2.getClassName().equals(classVertex.getClassName())&&classVertex1.isVisited()==false) {
			return classVertex1;
		}
		else 
			return null;
	}
	
	public ClassGraph findBelongClassGraph(List<ClassGraph> classGraphList,MethodVertex methodVertex) {
		for(int i=0;i<classGraphList.size();i++) {
			ClassGraph classGraph=classGraphList.get(i);
			List<ClassVertex> classVertexList=classGraph.getClassVertexList();
			for(int j=0;j<classVertexList.size();j++) {
				if(classVertexList.get(j).getClassName().equals(methodVertex.getBelongClass()))
					return classGraph;
			}
		}
		return null;
	}
	
}
