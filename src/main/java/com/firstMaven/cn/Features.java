package com.firstMaven.cn;

import java.util.*;




public class Features {

	private float CRrate;//���һ��cdg�޷�����Ϊ-1�������޵��ù�ϵ��Ϊ0���е��ù�ϵΪ����0
    private int userActionNum;
    private int userActionType;
    private Integer[] userActionList;
    private int senApiNum;
    private int senApiType;
    
    
    
  
    
     
    
    
    
    
	public float getCRrate() {
		return CRrate;
	}
	public void setCRrate(float cRrate) {
		CRrate = cRrate;
	}
	public int getUserActionNum() {
		return userActionNum;
	}
	public void setUserActionNum(int userActionNum) {
		this.userActionNum = userActionNum;
	}
	public int getUserActionType() {
		return userActionType;
	}
	public void setUserActionType(int userActionType) {
		this.userActionType = userActionType;
	}
	
	
	public Integer[] getUserActionList() {
		return userActionList;
	}
	public void setUserActionList(Integer[] userActionList) {
		this.userActionList = userActionList;
	}
		
	public int getSenApiNum() {
		return senApiNum;
	}
	public void setSenApiNum(int senApiNum) {
		this.senApiNum = senApiNum;
	}
	public int getSenApiType() {
		return senApiType;
	}
	public void setSenApiType(int senApiType) {
		this.senApiType = senApiType;
	}
			/********�������********/
	public Features  getFeatures(ClassGraph classGraph) {//�������ҵ����������Ϊfeatures���󣬴����ϲ�
		Features features=new Features();
		if(classGraph==null) {
			System.out.println("�Ҳ���CDG����");
			return null;
		}
		float CRrate=gen_CRrate(classGraph);
		
		int userActionNum=gen_UserActionNum(classGraph);
		int userActionType=gen_UserActionType(classGraph);
		Integer[] userActionList=gen_UserActionList(classGraph);
	
		
		features.setCRrate(CRrate);
		features.setUserActionNum(userActionNum);
		features.setUserActionType(userActionType);
		features.setUserActionList(userActionList);
	    
	    
	    
	    
	    return features;
	}
	
	
	
	public float gen_CRrate(ClassGraph classGraph) {//生成覆盖率
		float CRrate=0;
		float up=0;
		float down=0;
		List<MethodVertex> methodVertexList=classGraph.getMethodVertexList();
		List<MethodVertex> visitedMethodVertex=new ArrayList();//访问过的点,表示用户方法
		List<MethodEdge> visitedMethodEdge=new ArrayList();//访问过的边，表示被调用方法
		if(methodVertexList==null)
			return 0;
		for(int i=0;i<methodVertexList.size();i++) {
			MethodVertex methodVertex=methodVertexList.get(i);
			if(!checkVertex(visitedMethodVertex,methodVertex)) {
				getCalleeVertexList(visitedMethodEdge,methodVertex);
			}
		}
		float methodNum=getAllMethodNum(methodVertexList,visitedMethodEdge);
		up=visitedMethodEdge.size();
		if(methodNum!=0) {
			if(up!=0) {
				System.out.println(up);
				System.out.println(methodNum);
			}
			CRrate=up/methodNum;
		}
			
		return CRrate;
	}
	
	public int gen_UserActionNum(ClassGraph classGraph) {//生成用户函数的总数
		List<MethodVertex> methodVertexList=classGraph.getMethodVertexList();
		int num=0;
		if(methodVertexList==null)
			return 0;
		for(int i=0;i<methodVertexList.size();i++) {
			if(methodVertexList.get(i).getType()==0)
				num++;
		}
		return num;
	}
	public int gen_UserActionType(ClassGraph classGraph) {//生成用户函数的种类数目
		int[] typeFlag=new int[12];
		for(int i=0;i<12;i++) {
			typeFlag[i]=-1;
		}
		List<MethodVertex> methodVertexList=classGraph.getMethodVertexList();
		int num=0;
		if(methodVertexList==null)
			return 0;
		for(int i=0;i<methodVertexList.size();i++) {
			int type=methodVertexList.get(i).getTypeFlag();
			if(type==0)
				continue;
			if(!checkType(typeFlag,type)) {
				//System.out.println(methodVertexList.get(i).getMethodName());
				num++;
			}

		}
		return num;
	}
	
	
	
	public Integer[] gen_UserActionList(ClassGraph classGraph){
		List<MethodVertex> list=classGraph.getMethodVertexList();
		if(list==null||list.size()==0){
			return null;
		}
		Integer[] userActionList=new Integer[12];
		for(int i=0;i<12;i++){
			userActionList[i]=0;
		}
		for(int i=0;i<list.size();i++){
			MethodVertex methodVertex=list.get(i);
			int id=methodVertex.getTypeFlag();
			if(id<1){
				continue;
			}
			userActionList[id-1]=1;
		}
		
		return userActionList;
	}
	

 
	
	
	
	
	
	              /******具体生成方法******/
	public float getAllMethodNum(List<MethodVertex> methodVertexList,List<MethodEdge> methodEdgeList) {
		float num=methodEdgeList.size();
		for(int i=0;i<methodVertexList.size();i++) {
			if(!checkEdge(methodEdgeList,methodVertexList.get(i)))
				num++;
		}
		return num;
	}
	
	public boolean checkVertex(List<MethodVertex> methodVertexList,MethodVertex methodVertex) {
		if(methodVertex.getType()!=0)
			return true;
		for(int i=0;i<methodVertexList.size();i++) {
			MethodVertex everyVertex=methodVertexList.get(i);
			if(everyVertex.getContent().equals(methodVertex.getContent()))
				return true;
		}

		methodVertexList.add(methodVertex);
		return false;
	}
	
	public boolean checkVertex1(List<MethodVertex> methodVertexList,MethodVertex methodVertex) {
		if(methodVertex.getType()!=1)
			return true;
		for(int i=0;i<methodVertexList.size();i++) {
			MethodVertex everyVertex=methodVertexList.get(i);
			if(everyVertex.getBelongClass().equals(methodVertex.getBelongClass())&&everyVertex.getMethodName().equals(methodVertex.getMethodName()))
				return true;
		}

		methodVertexList.add(methodVertex);
		return false;
	}
	
	public boolean checkVertex2(List<MethodVertex> methodVertexList,MethodVertex methodVertex) {
		if(methodVertex.getType()!=1)
			return true;

		methodVertexList.add(methodVertex);
		return false;
	}
	
	
	public void getCalleeVertexList(List<MethodEdge> visitedMethodEdge,MethodVertex methodVertex) {
		List<MethodEdge> methodEdgeList=methodVertex.getMethodEdgeList();
		if(methodEdgeList==null)
			return;
		for(int i=0;i<methodEdgeList.size();i++) {
			MethodEdge methodEdge=methodEdgeList.get(i);
			boolean iop=checkEdge(visitedMethodEdge,methodEdge);
		}
	}
	
	public boolean checkEdge(List<MethodEdge> visitedMethodEdge,MethodEdge methodEdge) {
		if(methodEdge.getType()==0)//考虑没有把用户交互方法加上去，因为不能体现交互性，要多想想
			return true;
		for(int i=0;i<visitedMethodEdge.size();i++) {
			if(visitedMethodEdge.get(i).getContent().equals(methodEdge.getContent()))
				return true;
		}
		visitedMethodEdge.add(methodEdge);
		return false;
	}
	public boolean checkEdge(List<MethodEdge> visitedMethodEdge,MethodVertex methodVertex) {
		
		for(int i=0;i<visitedMethodEdge.size();i++) {
			if(visitedMethodEdge.get(i).getContent().equals(methodVertex.getContent()))
				return true;
		}
		return false;
	}
	
	public boolean checkType(int[] typeFlag,int type) {
		int i;
		for(i=0;i<12;i++) {
			if(typeFlag[i]==-1)
				break;
			if(type==typeFlag[i])
				return true;
		}
		typeFlag[i]=type;
		return false;
	}
}
