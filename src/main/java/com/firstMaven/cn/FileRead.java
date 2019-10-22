package com.firstMaven.cn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
public class FileRead {

		
	public List<String> fileRead(String fileName) {
		String encoding="UTF-8";
		  File file=new File(fileName);
		  
		  BufferedReader reader=null;
		  List<String> line=new ArrayList();
		  
		  int i=0;
		  try {
			  if(!file.exists()||!file.isFile()) {
				  System.out.println(fileName+":�����ļ����ߵ�ǰĿ¼�ļ�������");
			  }
			  else {
			 // InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			  reader=new BufferedReader(new FileReader(fileName));
			  String lineRead=null; 
			
			  while((lineRead=reader.readLine())!=null) {
				
				  line.add(lineRead);
				  i++;
			  }
			  if(line.size()<2) {
				  System.out.println(fileName);
			  }
			  reader.close();
			  
			  }
		  }
		  catch(IOException e) {
			  System.out.println("�ļ���ȡ����");
			  e.printStackTrace();
		  }
		  return line;
	}
	
	public List<String> getAllUrl(String path){
		
		if(path==null){
			return null;
		}
		
		
		List<String> urlList=new ArrayList();
		File file=new File(path);
		File[] fileList=file.listFiles();
		if(fileList==null||fileList.length==0) {
			
			return null;
		}
		for(int i=0;i<fileList.length;i++) {
			File nextFile=new File(fileList[i].getAbsolutePath());
			File[] nextFileList=nextFile.listFiles();
			if(nextFileList==null||nextFileList.length==0) {
				
				continue;
			}
			for(int j=0;j<nextFileList.length;j++) {
				String[] spli=StringUtils.split(nextFileList[j].getAbsolutePath(),"\\\\");
			
				if(spli[spli.length-1].equals("smali")) {
					String url=nextFileList[j].getAbsolutePath();
					
					urlList.add(url);
					break;
				}
					
			}
		}
		return urlList;
		
	}
	
	public List<String> getUrl(String path){
		File file=new File(path);
		File[] fileList=file.listFiles();
		List<String> urlList=new ArrayList<>();
		if(fileList==null||fileList.length==0) {
			
			return null;
		}
		
			for(int j=0;j<fileList.length;j++) {
				String[] spli=StringUtils.split(fileList[j].getAbsolutePath(),"\\\\");
			
				if(spli[spli.length-1].equals("smali")) {
					String url=fileList[j].getAbsolutePath();
					
					urlList.add(url);
					break;
				}
					
			}
		
		return urlList;
		
	}
}
