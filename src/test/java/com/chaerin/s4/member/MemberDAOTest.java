package com.chaerin.s4.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaerin.s4.MyJunitTest;

public class MemberDAOTest extends MyJunitTest{

	@Autowired
	private MemberDAO memberDAO;
	
	//@Test
	public void joinTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("id2");
		memberDTO.setPw("pw2");
		memberDTO.setName("name2");
		memberDTO.setPhone("01022222222");
		memberDTO.setEmail("d@naver.com");
		int result = memberDAO.join(memberDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void loginTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId("id3");
		memberDTO.setPw("pw3");
		
		memberDTO=memberDAO.login(memberDTO);
		
		assertNotNull(memberDTO);
	}

}
