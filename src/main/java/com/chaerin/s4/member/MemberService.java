package com.chaerin.s4.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chaerin.s4.util.FileManager;



@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;
	
	public MemberDTO mypage(MemberDTO memberDTO) throws Exception{
	      return memberDAO.mypage(memberDTO);
	   }
	
	public int join(MemberDTO memberDTO, MultipartFile photo) throws Exception{
			//1. 파일을 hdd에 저장
		
			//2. 정보를 db에 저장
			fileManager.save(photo, "resources/upload/member");
		
			return memberDAO.join(memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}

}
