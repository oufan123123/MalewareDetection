package com.firstMaven.cn;

import java.util.*;

import org.apache.commons.lang3.StringUtils;



import java.io.*;
public class AllClassDependence {

	private List<ClassVertex> classVertexList;
	private List<ClassEdge> classEdgeList;
	
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
	
	public AllClassDependence getAllClassDependence(String url) {
		
		AllClassDependence allClassDependence=new AllClassDependence();
		List<ClassVertex> classVertexList1=new ArrayList();
		List<ClassEdge> classEdgeList1=new ArrayList();
		Queue<String> DectoryFileList=new LinkedList();
		
		
		DectoryFileList.offer(url);
		FileRead read=new FileRead();
		int num=0;
		while(!DectoryFileList.isEmpty()) {
			  
			  String DectoryName=DectoryFileList.poll();
			  File file=new File(DectoryName);
			  File[] fileList=file.listFiles();//���·�����ļ����г�
			  
			  for(int i=0;i<fileList.length;i++) {//����������Lcom/android/iop����������Landroid/...�����ʣ���֪���Ƿ�ȥ����android��
				  
				  if(fileList[i].isFile()) {//���һ��samli�ļ������е���ͱ�
					 // System.out.println(fileList[i].getAbsolutePath());
					  List<String> instructionList=read.fileRead(fileList[i].getAbsolutePath());
					  addClassDependece(classEdgeList1,classVertexList1,instructionList);
					  num++;
				  }
				  if(fileList[i].isDirectory()) {
					 // System.out.println(fileList[i].getAbsolutePath());
					  String[] a=StringUtils.split(fileList[i].getAbsolutePath(),"\\\\");
						String d="java";
				    	String g="javax";
				    	String e="android";
				    	String h="org";
					 
			            if((a[a.length-1].equals(d)||a[a.length-1].equals(g)||a[a.length-1].equals(e)||a[a.length-1].equals(h))&&a[a.length-2].equals("smali"))
			            	continue;
			            else {
			            	DectoryFileList.offer(fileList[i].getAbsolutePath());
			            	//System.out.println(fileList[i].getAbsolutePath());
			            }
				  }
			  }
		
		
		}
		System.out.println("读取smali文件数目"+num);
		allClassDependence.setClassVertexList(classVertexList1);
		
		if(classVertexList!=null&&classVertexList.size()>0){
		 for(int i=0;i<classVertexList.size();i++){
			if(classVertexList.get(i).getClassName().contains("Landroid")){
				System.out.println("vertex:    "+classVertexList.get(i).getClassName());
			}
		 }
		}
		
		allClassDependence.setClassEdgeList(classEdgeList1);
		
		if(classEdgeList!=null&&classEdgeList.size()>0){
		for(int i=0;i<classEdgeList.size();i++){
			ClassVertex c1=classEdgeList.get(i).getClassVertex1();
			ClassVertex c2=classEdgeList.get(i).getClassVertex2();
			if(c1.getClassName().contains("Landroid")){
				System.out.println("edge:      "+c1.getClassName());
			}
			
			if(c2.getClassName().contains("Landroid")){
				System.out.println("edge:      "+c2.getClassName());
			}
		}
		}
		return allClassDependence;
	}
	
	public  void addClassDependece(List<ClassEdge> classEdgeList2,List<ClassVertex> classVertexList2,List<String> instructionList) {//��ȡָ��������

		if(instructionList.size()<2) {
			System.out.println("文件头两行缺失异常");
			return;
			
		}
	    String firstClass=getFirstClass(classVertexList2,instructionList.get(0),instructionList.get(1));//����ֻ�Ƿ�������Ϊ�����ұ߷��񣬶������Ӳ��ӵ��������Ѿ�����������ﴦ����
	  //  System.out.println("�����smali�ļ�"+firstClass);
		if(firstClass==null) {
			System.out.println("文件头类名异常");
			return;
		}
		String likeIntentClass=null;
	    for(int i=2;i<instructionList.size();i++) {
			if(instructionList.get(i).equals(""))
				continue;
			String[] a=StringUtils.split(instructionList.get(i)," |;|:|,");
			
			if(a[0].equals("const-class")) {//���ȴ��intent���ܵĵ��÷���
				for(int j=0;j<a.length;j++) {
					if(a[j].charAt(0)=='L') {
						likeIntentClass=a[j];
					}
				}
			}
			if(a[0].indexOf("invoke-")==0) {
				String b=getDependenceClass(classVertexList2,a,firstClass,likeIntentClass);
				//System.out.println("invoke����"+b);
				if(b!=null&&!checkClassEdge(classEdgeList2,firstClass,b)) {
					//System.out.println("���ñ�"+b);
					ClassEdge classEdge=new ClassEdge();
					ClassVertex firstClassVertex=findClassVertex(classVertexList2,firstClass);
					ClassVertex lastClassVertex=findClassVertex(classVertexList2,b);
                    //System.out.println(firstClassVertex.getClassName());
					if(firstClassVertex!=null&&lastClassVertex!=null) {
						//System.out.println("����"+firstClassVertex.getClassName());
						classEdge.setClassVertex1(firstClassVertex);
						classEdge.setClassVertex2(lastClassVertex);
						classEdgeList2.add(classEdge);
					}
				}
			}
			
			if(a[0].indexOf("iget-")==0||a[0].indexOf("iput-")==0||a[0].indexOf("sget-")==0||a[0].indexOf("sput-")==0) {
				String b=getDependenceClass(classVertexList2,a,firstClass,likeIntentClass);
				//System.out.println("i����s"+b);
				if(b!=null&&!checkClassEdge(classEdgeList2,firstClass,b)) {
					//System.out.println("���ñ�"+b);
					ClassEdge classEdge=new ClassEdge();
					ClassVertex firstClassVertex=findClassVertex(classVertexList2,firstClass);
					ClassVertex lastClassVertex=findClassVertex(classVertexList2,b);
					if(firstClassVertex!=null&&lastClassVertex!=null) {
						classEdge.setClassVertex1(firstClassVertex);
						classEdge.setClassVertex2(lastClassVertex);
						classEdgeList2.add(classEdge);
					}
				}
			}
		  }
		
		
	}
	
	public String getFirstClass(List<ClassVertex> classVertexList3,String instruction1,String instruction2) {//�ҵ���һ������
		String thisClassName=null;
		
		String[] a=StringUtils.split(instruction1," |;");
		String[] b=StringUtils.split(instruction2," |;");
		for(int i=0;i<a.length;i++) {//���ҵ�һ�е�����
			if(a[i].charAt(0)=='L') {
				thisClassName=a[i];
				if(!checkClassVertex(classVertexList3,thisClassName)) {
					ClassVertex classVertex=new ClassVertex();
					classVertex.setVisited(false);
					classVertex.setClassName(thisClassName);
					classVertexList3.add(classVertex);
					
				}
				return thisClassName;
			}
		}
		if(b[0].charAt(0)!='.') {
			for(int i=0;i<b.length;i++) {
				if(b[i].charAt(0)=='L') {
					thisClassName=b[i];
					if(!checkClassVertex(classVertexList3,thisClassName)) {
						ClassVertex classVertex=new ClassVertex();
						classVertex.setClassName(thisClassName);
						classVertex.setVisited(false);
						classVertexList3.add(classVertex);
					}
				}
				return thisClassName;
				
			}
		}
		return null;
	}
	
	public String getDependenceClass(List<ClassVertex> classVertexList4,String[] a,String className,String likeIntentClass) {
    	String[] b=null;
    	String[] c=null;
    	String[] t=null;
     	String d="Ljava";
    	String g="Ljavax";
    	String e="Landroid";
    	String h="Lorg";
    	String f=null;
    	for(int i=0;i<a.length;i++) {
    		
    		if(a[i].indexOf("->setClass(")==0) {
    			//.out.println(className);
    			//System.out.println("����ɶ"+a[i-1]);
    			if(!a[i-1].equals("Landroid/content/Intent")||likeIntentClass==null) {
    			
    				System.out.println("intent����");
    				return null;
    			}
    			//System.out.println(b[0]);
    			t=StringUtils.split(likeIntentClass,"/");
    			for(int j=0;j<t.length-1;j++) {
    			if(t[j].equals(h)||t[j].equals(g)||t[j].equals(d)||t[j].equals(e)||likeIntentClass.equals(className)) {
    			return null;
    			}
    			}
    			if(!checkClassVertex(classVertexList4,likeIntentClass)) {
					ClassVertex classVertex=new ClassVertex();
					classVertex.setClassName(likeIntentClass);
					classVertex.setVisited(false);
					classVertexList4.add(classVertex);
				}
    			   // System.out.println("intent��"+likeIntentClass);
    				return likeIntentClass;
    			
    		
    	  }
    	}
    	for(int i=0;i<a.length;i++) {
    		//System.out.println(a[i]);
    		
    		if(a[i].charAt(0)=='L') {    			
    			c=StringUtils.split(a[i],"/");//�����Ż�����Ϊ�ָ�L���²�������˺�ѣ�����û�з��������������������Ż����Կ���!!                            
                for(int j=0;j<c.length;j++) {
    			if(c[j].equals(h)||c[j].equals(g)||c[j].equals(d)||c[j].equals(e)||a[i].equals(className)) {
                	//System.out.println(a[i]);
        			//System.out.println(vertex.getClassName());
                	//System.out.println(f);
                	return null;  
                
                }
    		}
                if(!checkClassVertex(classVertexList4,a[i])) {
					ClassVertex classVertex=new ClassVertex();
					classVertex.setClassName(a[i]);
					classVertex.setVisited(false);
					classVertexList4.add(classVertex);
				}
                return a[i];
    		}
    	}
    	return null;//����û��������������е������ֶ�ʹ�õ���û����������
    }
	
	public ClassVertex findClassVertex(List<ClassVertex> classVertexList5,String className) {
		for(int i=0;i<classVertexList5.size();i++) {
			if(classVertexList5.get(i).getClassName().equals(className))
				return classVertexList5.get(i);
		}
		return null;
	}
	
	public boolean checkClassVertex(List<ClassVertex> classVertexList3,String className) {
		for(int i=0;i<classVertexList3.size();i++) {
			if(className.equals(classVertexList3.get(i).getClassName())) 
				return true;
		}
		return false;
	}
	
	public boolean checkClassEdge(List<ClassEdge> classEdgeList3,String firstClass,String lastClass) {
		for(int i=0;i<classEdgeList3.size();i++) {
			String a=classEdgeList3.get(i).getClassVertex1().getClassName();
			String b=classEdgeList3.get(i).getClassVertex2().getClassName();
			if((firstClass.equals(a)&&lastClass.equals(b))||(firstClass.equals(b)&&lastClass.equals(a)))
				return true;
		}
		return false;
	}
	
	
}
