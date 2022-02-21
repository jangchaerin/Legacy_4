package com.chaerin.s4.member;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//SELECT하려고
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(MemberDTO memberDTO) throws Exception{		//내장객체 리퀘스트, 파라미터와 동일한명, 객체
		memberDTO = memberService.login(memberDTO);
		
		//login 실패 -> 다시 로그인창
		String path = "redirect:./login";//get 방식
		
		//login 성공 -> index       멤버dto가 널이 아니면 로그인성공
		if (memberDTO != null) {
			path="redirect:../"; // index로 가려면 한단께올라가면됨
		}
		return path;
		
		
	}
	
	//FORM으로 이동
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login() throws Exception{
		
	}
	////////////////////////////////////////
	//insert
	@RequestMapping(value = "join", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO)throws Exception{
		int result = memberService.join(memberDTO);		//dao로 가려면 service를 거쳐야함
				
		return "redirect:../";
	}	
	@RequestMapping(value ="join", method=RequestMethod.GET)
	public void join() throws Exception{
	}
	
	
	

}
