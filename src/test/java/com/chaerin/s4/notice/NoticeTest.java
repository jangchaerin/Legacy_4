
package com.chaerin.s4.notice;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.chaerin.s4.MyJunitTest;

public class NoticeTest extends MyJunitTest {
   @Autowired
   private NoticeDAO noticeDAO;

   @Test
   public void check() {
      assertNotNull(noticeDAO);
   }
}