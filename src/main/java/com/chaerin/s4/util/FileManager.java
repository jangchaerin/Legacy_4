package com.chaerin.s4.util;


import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
   @Autowired
   private ServletContext servletContext;
   
   public boolean remove(String path, String fileName) throws Exception{
	   //파일을 HDD에서 삭제
	   //저장된 폴더명, 저장된 파일명
	   path = servletContext.getRealPath(path); //path에 실제경로를 받아옴
	   
	   File file = new File(path, fileName);
	   
	   return file.delete();	   
	   
   }
   
   public String save(MultipartFile multipartFile,String path) throws Exception{//HDD에 저장하는곳
      //파일 저장은 tomcat이 아니라 os에 저장
      //path= /resources/upload/member
      String realPath =servletContext.getRealPath(path);
      System.out.println(realPath);
      
      File file =new File(realPath);
      
      if(!file.exists()) {
    	  //file.mkdir();
    	  file.mkdirs();
      }
      //1. 시간
      Calendar ca = Calendar.getInstance();
      long l = ca.getTimeInMillis();
      System.out.println("time : "+l);
      String oriName= multipartFile.getOriginalFilename(); //iu1.jpg
      
      String fileName=l+"_"+oriName;
      System.out.println("fileName : "+fileName);
      
      //2. UUID
      fileName = UUID.randomUUID().toString();
      fileName = fileName +"_"+oriName;
      System.out.println("UUID : "+fileName);
      
      //file HDD에 저장
      //1. MultipartFile 클래스의 transferTo 메소드 사용
      
//      file = new File(realPath, fileName);
//      file=new File(file,fileName);
//      multipartFile.transferTo(file);
      
      //2. FileCopyUtils
      file = new File(file, fileName);
      FileCopyUtils.copy(multipartFile.getBytes(), file);
      
      return fileName;
   }
}
