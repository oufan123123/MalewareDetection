package com.firstMaven.cn;

import java.util.*;
public class MethodVertex {

	private String methodName;
	private String belongClass;
	private String content;
	private List<MethodEdge> methodEdgeList;
	private boolean isVisited;
	private int type;//type=0��ʾ���û�����,type=1��ʾ���û�������������Ҫ�Ľ�ĵ㣬���û������Ƿ��ϸ�֣��Ƿ�������з���Ϊ��ĸ
	private int typeFlag; //Ŀǰ�ҵ���15��
	
	
	
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getBelongClass() {
		return belongClass;
	}
	public void setBelongClass(String belongClass) {
		this.belongClass = belongClass;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public List<MethodEdge> getMethodEdgeList() {
		return methodEdgeList;
	}
	public void setMethodEdgeList(List<MethodEdge> methodEdgeList) {
		this.methodEdgeList = methodEdgeList;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getTypeFlag() {
		return typeFlag;
	}
	public void setTypeFlag(int typeFlag) {
		this.typeFlag = typeFlag;
	}
	
	
	
}
