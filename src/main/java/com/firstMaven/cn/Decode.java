package com.firstMaven.cn;

import brut.androlib.*;
import brut.directory.DirectoryException;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
public class Decode {
  
	public String decodeAPK(String path,int isPacked) throws  DirectoryException, IOException {//Ҫ����һ��Ŀ¼������һ��ȫ��apk
		
		ApkDecoder apkDecoder=new ApkDecoder();
		String goodString="F:/temp/good_lib";
		String badString="F:/temp/bad_lib";
		if(isPacked<0||isPacked>1) {
			System.out.println("��������������������");
			return null;
		}
		if(isPacked==1) {
			File file=new File(path);
			File[] fileList=file.listFiles();
			  for(int i=0;i<fileList.length;i++) {
					
					
					try {
						apkDecoder.setOutDir(new File(badString+"/"+i));
					} catch (AndrolibException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						continue;
					}
					apkDecoder.setApkFile(fileList[i]);
					try {
						apkDecoder.decode();
					} catch (AndrolibException e) {
						
						e.printStackTrace();
						continue;
					}
				  } 
				  return badString;
		}
		else {
			File file=new File(path);
			File[] fileList=file.listFiles();
			if(fileList.length>0)
			System.out.println(fileList[0].getPath());
			for(int i=0;i<fileList.length;i++) {
				
			
				try {
					apkDecoder.setOutDir(new File(goodString+"/"+i));
					
				} catch (AndrolibException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					continue;
				}
				apkDecoder.setApkFile(fileList[i]);
				
				try {
					apkDecoder.decode();
					
				} catch (AndrolibException e) {
					
					e.printStackTrace();
					continue;
				}
			  } 
				  return goodString;
		}
	}
	
	public String decodeOneApk(String path) throws DirectoryException, IOException{
		ApkDecoder apkDecoder=new ApkDecoder();
		String [] s=StringUtils.split(path,"\\\\|\\.");
		File file=new File(path);
		System.out.println("path正还是反:"+path);
	    String testPath="D:/adver_study/testAPK/"+s[s.length-2];
		try {
			apkDecoder.setOutDir(new File(testPath));
		} catch (AndrolibException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		apkDecoder.setApkFile(file);
		try {
			apkDecoder.decode();
		} catch (AndrolibException e) {
			
			e.printStackTrace();
			
		}
		return testPath;
	}
	
}
	
