package com.firstMaven.cn;

public class MethodEdge {

	private String nextMethodName;
	private String nextClassName;
	private String content;
	private boolean isVisited;
    private int type;//type=0��ʾ���û�����,type=1��ʾ��ϵͳ���з���,type=2��ʾ��ͨ������
    
    
    
	
	

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getNextMethodName() {
		return nextMethodName;
	}
	public void setNextMethodName(String nextMethodName) {
		this.nextMethodName = nextMethodName;
	}
	public String getNextClassName() {
		return nextClassName;
	}
	public void setNextClassName(String nextClassName) {
		this.nextClassName = nextClassName;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
