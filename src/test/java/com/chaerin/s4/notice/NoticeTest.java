
package com.chaerin.s4.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.chaerin.s4.MyJunitTest;

public class NoticeTest extends MyJunitTest {
   @Autowired
   private NoticeDAO noticeDAO;

   @Test
   public void check() {
      assertNotNull(noticeDAO);
   }
 
   //list
   //@Test
   public void listTest() throws Exception{
	   List<NoticeDTO> ar = noticeDAO.list();
	   assertNotEquals(0, ar.size());
   }
   
   //detail
   //@Test
   public void detailTest() throws Exception{
	   NoticeDTO noticeDTO = new NoticeDTO();
	   noticeDTO.setNum(41L);
	   noticeDTO =noticeDAO.detail(noticeDTO);
	   assertNotNull(noticeDTO);
   }
   //insert
   @Test
   public void addTest() throws Exception{
	  for(int i=0;i<5;i++) {
		   NoticeDTO noticeDTO = new NoticeDTO();
		   noticeDTO.setTitle("title"+i);
		   noticeDTO.setContents("contents"+i);
		   noticeDTO.setWriter("writer"+i);
		   noticeDTO.setHit(7);
		   
		   int result = noticeDAO.add(noticeDTO);
	  }
	  System.out.println("insert finish");
   }
	   
   
   @Test
   public void deleteTest() throws Exception{
	   NoticeDTO noticeDTO = new NoticeDTO();
	   noticeDTO.setNum(41L);
	   int result =noticeDAO.delete(noticeDTO);
	   assertEquals(1, result);
	   
	   
	   
	   
   }
   
   
}