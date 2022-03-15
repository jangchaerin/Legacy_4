package com.chaerin.s4.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chaerin.s4.member.MemberDTO;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		
		boolean check = true;	
		
		if(memberDTO==null) {
			check=false;		//login이 안됐기 때문에 통과 x			
			//1. foward 형식 - servlet 문법 사용 spring문법 x
			request.setAttribute("message", "로그인이 필요합니다.");
			request.setAttribute("path", "../member/login");
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
			//2. redirect  엘러창없이 바로 login창으로 이동
			//response.sendRedirect("../member/login");
		}
		
		return check;
	}
}
