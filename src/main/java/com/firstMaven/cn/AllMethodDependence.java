package com.firstMaven.cn;

import java.io.*;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
public class AllMethodDependence {

	
	private List<MethodVertex> methodVertexList;

	
	public List<MethodVertex> getMethodVertexList() {
		return methodVertexList;
	}
	public void setMethodVertexList(List<MethodVertex> methodVertexList) {
		this.methodVertexList = methodVertexList;
	}

	
	public AllMethodDependence getAllMethodDependence(String url) {
		AllMethodDependence allMethodDependence=new AllMethodDependence();
		List<MethodVertex> methodVertexList1=new ArrayList();
		Queue<String> DectoryList=new LinkedList();
		FileRead read=new FileRead();
		DectoryList.offer(url);
		
		while(!DectoryList.isEmpty()) {
			String fileUrl=DectoryList.poll();
			File file=new File(fileUrl);
			File[] fileList=file.listFiles();
			for(int i=0;i<fileList.length;i++) {
				if(fileList[i].isFile()) {
					List<String> instructionList=read.fileRead(fileList[i].getAbsolutePath());
					//System.out.println(instructionList.size());
					addMethodDependence(methodVertexList1,instructionList);
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
			            	DectoryList.offer(fileList[i].getAbsolutePath());
			            	//System.out.println(fileList[i].getAbsolutePath());
			            }
				 }
			}
		}
		
		allMethodDependence.setMethodVertexList(methodVertexList1);
		
		if(methodVertexList1!=null&&methodVertexList1.size()>0){
		
		
	    for(int i=0;i<methodVertexList1.size();i++){
	    	if(methodVertexList1.get(i).getMethodName().contains("releaseWakeLockIfNeeded")){
	    		List<MethodEdge> mvl=methodVertexList1.get(i).getMethodEdgeList();
	    		if(mvl!=null&&mvl.size()>0){
	    			for(int j=0;j<mvl.size();j++){
	    				MethodEdge m=mvl.get(j);
	    				System.out.println("releaseWakeLockIfNeeded"+m.getNextMethodName());
	    			}
	    				
	    		}
	    	}
	    	
	    	if(methodVertexList1.get(i).getMethodName().contains("getSubscriberId")){
	    		List<MethodEdge> mvl=methodVertexList1.get(i).getMethodEdgeList();
	    		if(mvl!=null&&mvl.size()>0){
	    			for(int j=0;j<mvl.size();j++){
	    				MethodEdge m=mvl.get(j);
	    				System.out.println("getSubscriberId"+m.getNextMethodName());
	    			}
	    				
	    		}
	    	}
	    }
		}
		
		
		return allMethodDependence;
	}
	
	public void addMethodDependence(List<MethodVertex> methodVertexList2,List<String> instructionList) {
		if(instructionList.size()<2) {
			System.out.println("�ļ�ͷ����ȱʧ�쳣");
			return;
			
		}
	    String firstClass=getFirstClass(instructionList.get(0),instructionList.get(1));//����ֻ�Ƿ�������Ϊ�����ұ߷��񣬶������Ӳ��ӵ��������Ѿ�����������ﴦ����
	  //  System.out.println("�����smali�ļ�"+firstClass);
		if(firstClass==null) {
			System.out.println("�ļ�ͷ�����쳣");
			return;
		}
		int flag=0; 
		int start=0;
		int end=0;
		for(int i=2;i<instructionList.size();i++) {
			if(instructionList.get(i).equals(""))
				continue;
			String[] a=StringUtils.split(instructionList.get(i)," |;|:|,");
			if(a[0].equals(".method")) {
				start=i;
				
			}
			if(a[0].indexOf("invoke-")==0) {
				flag++;
			}
			if(a[0].equals(".end")&&a[1].equals("method")) {
				end=i;
				//System.out.println("1");
				if(flag!=0) {
					
					//System.out.println("2");
				addOneMethodDependence(methodVertexList2,firstClass,start,end,instructionList);
				flag=0;
				}
			}
		}
		
	}
	
	public void addOneMethodDependence(List<MethodVertex> methodVertexList3,String firstClass,int start,int end,List<String> instructionList) {
		//System.out.println("startֵ��"+start);
		String is=instructionList.get(start);
	
		String[] a=StringUtils.split(is," |;|:|,|)");
		String[] d=StringUtils.split(is," |,");
		String firstMethod=getFirstMethodName(a);
		String firstMethodContent=getFirstMethodContent(d);
		
		firstMethodContent=firstClass+";->"+firstMethodContent;
		//if(firstClass.equals("Lcom/gau/go/launcherex/theme/iphone5GoLauncherEx/Base64"))
			//System.out.println(firstMethodContent);
		
		//if(firstMethod.equals("getDeviceId")) {
		//	System.out.println("getDeviceId��"+firstClass);
		//}
			
		if(firstMethod==null) {
			//System.out.println("����.method�޷��������");
			return;
		}
		int position=checkMethodVertex(methodVertexList3,firstMethodContent);
		if(position==-1) {
			//System.out.println("����ͷ����"+firstMethod);
			//System.out.println("ͷ����"+firstClass);
			//int type=distinguish(firstMethidVertex);
			int type=distinguish(firstMethod);
			int typeFlag=0;
			if(type==0){
				typeFlag=distinguishType(firstMethod);
			}
		    MethodVertex firstMethodVertex=new MethodVertex();
			firstMethodVertex.setMethodName(firstMethod);
			firstMethodVertex.setBelongClass(firstClass);
			firstMethodVertex.setContent(firstMethodContent);
			firstMethodVertex.setVisited(false);
	        firstMethodVertex.setType(type);
	        firstMethodVertex.setTypeFlag(typeFlag);
			methodVertexList3.add(firstMethodVertex);
		}
		List<MethodEdge> methodEdgeList=new ArrayList();
	
		for(int i=start;i<end;i++) {
			if(instructionList.get(i).equals(""))
				continue;
			String instruction=instructionList.get(i);
			String[] b=StringUtils.split(instruction," |;|:|,|[");
			String[] c=StringUtils.split(instruction," |,");
			if(b[0].indexOf("invoke-")==0) {
				String nextMethod=getNextMethodName(b);
				String nextClass=getNextClassName(b);
				String content=getContent(c);
				//System.out.println(nextMethod);
				//System.out.println(nextClass);
				if(nextMethod==null||nextClass==null||content==null) {
					//System.out.println(firstClass);
					//System.out.println(nextMethod);
					//System.out.println(nextClass);
					//System.out.println("�Ҳ������÷����������");
					continue;
				}
				int nextPosition=checkMethodVertex(methodVertexList3,content);
				if(nextPosition==-1) {
				//	if(nextMethod.equals("getDeviceId")) {
					//System.out.println("���˱����÷���"+firstMethod);
					//System.out.println("����������"+firstClass);
				//	System.out.println(content);
					//}
					int typeFlag=0;
					int type=distinguish(nextMethod);
					if(type==0){
						typeFlag=distinguishType(firstMethod);
					}
					MethodVertex nextMethodVertex=new MethodVertex();
					nextMethodVertex.setMethodName(nextMethod);
					nextMethodVertex.setBelongClass(nextClass);
					nextMethodVertex.setContent(content);
					nextMethodVertex.setVisited(false);
				    nextMethodVertex.setType(type);
				    nextMethodVertex.setTypeFlag(typeFlag);
					methodVertexList3.add(nextMethodVertex);
				}
				if(!checkMethodEdge(methodEdgeList,firstMethodContent,content)) {
					
					
					
					
					int type=distinguish(nextMethod);
					MethodEdge methodEdge=new MethodEdge();
					methodEdge.setNextClassName(nextClass);
					methodEdge.setNextMethodName(nextMethod);
					methodEdge.setContent(content);
					methodEdge.setVisited(false);
					methodEdge.setType(type);
					//if(firstMethod.equals("navigateInBackground"))
						//System.out.println(nextMethod);
					methodEdgeList.add(methodEdge);
				}
			}
		}
		//if(firstMethod.equals("a")&&firstClass.equals("Lcom/tencent/bugly/legu/proguard/a"))
			//System.out.println(methodEdgeList.size());
		MethodVertex firstMethodVertex=findMethodVertex(methodVertexList3,firstMethodContent);
		if(firstMethodVertex!=null) {
			//System.out.println(firstMethodVertex.getMethodName());
			//System.out.println(firstMethodVertex.getContent());
		       firstMethodVertex.setMethodEdgeList(methodEdgeList);
		      // if(methodEdgeList==null)
				//	System.out.println(0);
				//else {
					//System.out.println(methodEdgeList.size());
				//}
		       
		}
	//	System.out.println("end");
		
		   /*
		         �����ظ������ģ��
		         ������޸ĺ��ģ�鶪��
		   
		   if(position!=-1) {
			   MethodVertex firstMethodVertex=findMethodVertex(methodVertexList3,firstMethod,firstClass);
			   List<MethodEdge> firstEdgeList=firstMethodVertex.getMethodEdgeList();
			   List<MethodEdge> newEdgeList=new ArrayList();
			   if(methodEdgeList.size()>0) {
			   if(firstEdgeList!=null&&firstEdgeList.size()!=0) { 
				  
			   int y=firstEdgeList.size();
			   int x=methodEdgeList.size();
			   int iop=0;
			   for(int i=0;i<x;i++) {
				   MethodEdge methodEdge1=methodEdgeList.get(i);
				   MethodEdge methodEdge2=isSameMethodEdge(methodEdge1,firstEdgeList);
				   if(methodEdge2!=null)
					   newEdgeList.add(methodEdge2);
			   }
			   boolean op;
			   op=firstEdgeList.addAll(newEdgeList);
			   firstMethodVertex.setMethodEdgeList(newEdgeList);
			  
			   }
			   else {
				   firstMethodVertex.setMethodEdgeList(methodEdgeList);
				   
			   }  
		   }
		   }
		   else {
			   MethodVertex thisMethodVertex=findMethodVertex(methodVertexList3,firstMethod,firstClass);
			   thisMethodVertex.setMethodEdgeList(methodEdgeList);
			   
		   }
		   */
		   
		/*MethodVertex firstMethodVertex=findMethodVertex(methodVertexList3,firstMethod,firstClass);
		firstMethodVertex.setMethodEdgeList(methodEdgeList);
		   if(firstMethodVertex.getMethodName().equals("navigateInBackground")) {
			   System.out.println("���ҵķ�����Ŀ"+methodEdgeList.size());
			   if(firstMethodVertex.getMethodEdgeList()!=null&&firstMethodVertex.getMethodEdgeList().size()!=0)
			   System.out.println("ԭʼ������"+firstMethodVertex.getMethodEdgeList().size());
			   else
				   System.out.println("0");
				   
		   }//���м�������Ҷ��Ҷ��ˣ�����û�мӶԣ�����������������������������������������������
		*/
	}

	public String getFirstClass(String instruction1,String instruction2) {
        String thisClassName=null;
		
		String[] a=StringUtils.split(instruction1," |;");
		String[] b=StringUtils.split(instruction2," |;");
		for(int i=0;i<a.length;i++) {//���ҵ�һ�е�����
			if(a[i].charAt(0)=='L') {
				thisClassName=a[i];
				return thisClassName;
			}
		}
		if(b[0].charAt(0)!='.') {
			for(int i=0;i<b.length;i++) {
				if(b[i].charAt(0)=='L') {
					thisClassName=b[i];
				    return thisClassName;
				}
			}
		}
		return null;
	}
	
	 public String getFirstMethodName(String[] a) {
	    	for(int i=0;i<a.length;i++) {
	    		char[] b=a[i].toCharArray();
	    		for(int j=0;j<b.length;j++) {
	    			if(b[j]=='(') {
	    				String c=a[i].substring(0,j);
	    				String[] d=StringUtils.split(c,"<|>");
	    				//System.out.println(d[0]);
	    				return d[0];
	    				
	    			}
	    				
	    		}
	    	}
	    	return null;
	    }
	 
	 public String getNextMethodName(String[] a) {
	    	if(a.length==0)
	    		return null;
	    	for(int i=0;i<a.length;i++) {
	    		
	    		if(a[i].charAt(0)=='-') {
	    			//System.out.println(a[i]);
	    			String[] b=StringUtils.split(a[i]," |<|>|(");
	    			//System.out.println(b[1]);
	    			return b[1];
	    			
	    		}
	    			
	    	}
	    	return null;
	    }
	    
	    public String getNextClassName(String[] a) {
	    	if(a.length==0)
	    		return null;
	    	for(int i=0;i<a.length;i++) {
	    		if(a[i].charAt(0)=='L') {
	    			return a[i];
	    		}
	    	}
	    	return null;
	    }
	    
	    public String getContent(String[] a) {
	    	if(a.length==0)
	    		return null;
	    	for(int i=0;i<a.length;i++) {
	    		if(a[i].charAt(0)=='L') {
	    			return a[i];
	    		}
	    			
	    	}
	    	return null;
	    }
	    
	    public String getFirstMethodContent(String[] a) {
	    	if(a.length==0)
	    		return null;
	    	return a[a.length-1];
	    }
	 
	    public int distinguish(String methodName) {//群分方法类和非方法类
	    	 String m1="onClick";
	    	 String m2="onCreateContextMenu";
	         String m3="onFocusChange";
	    	 String m4="onLongClick";
	    	 String m5="onKey";
	    	 String m6="onTouchClick";
	    	 String m7="onKeyDown";
	    	 String m8="onKeyLongPress";
	    	 String m9="onKeyShortcut";
	    	 String m10="onKeyUp";
	    	 String m11="onTouchEvent";
	    	 String m12="onTrackballEvent";
	    	 
	    	 if(methodName.equals(m1)||methodName.equals(m2)||methodName.equals(m3)||methodName.equals(m4)||
	    		 methodName.equals(m5)||methodName.equals(m6)||methodName.equals(m7)||methodName.equals(m8)||
	    		 methodName.equals(m9)||methodName.equals(m10)||methodName.equals(m11)||methodName.equals(m12)) {
	    		 return 0;
	    	 }
	    	 return 1;
	     }
     
 
	 
  public int distinguishType(String methodName) {//Ⱥ�ַ�����ͷǷ�����
 	 String m1="onClick";
 	 String m2="onCreateContextMenu";
     String m3="onFocusChange";
 	 String m4="onLongClick";
 	 String m5="onKey";
 	 String m6="onTouchClick";
 	 String m7="onKeyDown";
 	 String m8="onKeyLongPress";
 	 String m9="onKeyShortcut";
 	 String m10="onKeyUp";
 	 String m11="onTouchEvent";
 	 String m12="onTrackballEvent";
 	 int typeFlag=0;
 	 switch(methodName) {
 	       case "onClick":
 		        typeFlag=1;break;
 	       case "onCreateContextMenu":
 	    	   typeFlag=2;break;
 	       case "onFocusChange":
	    	   typeFlag=3;break;
 	       case "onLongClick":
	    	   typeFlag=4;break;
 	       case "onKey":
	    	   typeFlag=5;break;
 	       case "onTouchClick":
	    	   typeFlag=6;break;
 	       case "onKeyDown":
    	       typeFlag=7;break;
 	       case "onKeyLongPress":
   	           typeFlag=8;break;
 	       case "onKeyShortcut":
  	           typeFlag=9;break;
 	       case "onKeyUp":
  	           typeFlag=10;break;
 	       case "onTouchEvent":
 	           typeFlag=11;break;
 	       case "onTrackballEvent":
	           typeFlag=12;break;
 	 
  
 		 
 	 }
 	 
 	/* System.out.println("oooooooooooooooooooooo"+methodName+typeFlag);*/
 	 return typeFlag;
 	
  }
	    
	    
	 public MethodVertex findMethodVertex(List<MethodVertex> methodVertexList5,String firstMethodContent) {
		 for(int i=0;i<methodVertexList5.size();i++) {
			 String fmc=methodVertexList5.get(i).getContent();
			 if(fmc.equals(firstMethodContent))
				 return methodVertexList5.get(i);
		 }
		 return null;
	 }
	 public boolean checkMethodEdge(List<MethodEdge> methodEdgeList4,String firstMethodContent,String nextMethodContent) {
		 
		 if(firstMethodContent.equals(nextMethodContent))
			 return true;
		 for(int i=0;i<methodEdgeList4.size();i++) {
			 String nmc=methodEdgeList4.get(i).getContent();
			 if(nmc.equals(nextMethodContent)) 
			     return true;	 
			
		 }
		 return false;
	 }
	 public int checkMethodVertex(List<MethodVertex> methodVertexList4,String MethodContent) {
		
		 for(int i=0;i<methodVertexList4.size();i++) {
			 String nmc=methodVertexList4.get(i).getContent();
			 if(nmc.equals(MethodContent))
				 return i;
		 }
		 return -1;
	 }
	 
	/* public MethodEdge isSameMethodEdge(MethodEdge methodEdge,List<MethodEdge> methodEdgeList) {
		 String mn=methodEdge.getNextMethodName();
		 
		 String cn=methodEdge.getNextClassName();
		 String content=methodEdge.getContent();
		 for(int i=0;i<methodEdgeList.size();i++) {
			 if(mn.equals(methodEdgeList.get(i).getNextMethodName())&&cn.equals(methodEdgeList.get(i)))
				 return null;			
		 }
		 MethodEdge methodEdge1=new MethodEdge();
		 methodEdge1.setNextMethodName(mn);
		 methodEdge1.setNextClassName(cn);
		 methodEdge1.setContent(content);
		 return methodEdge1;
	 }*/
	
	
}
