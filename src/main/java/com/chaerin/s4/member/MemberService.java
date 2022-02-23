package com.chaerin.s4.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO mypage(MemberDTO memberDTO) throws Exception{
	      return memberDAO.mypage(memberDTO);
	   }
	
	public int join(MemberDTO memberDTO) throws Exception{
			return memberDAO.join(memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}

}
