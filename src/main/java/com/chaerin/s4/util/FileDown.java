package com.chaerin.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.chaerin.s4.file.FileDTO;
import com.chaerin.s4.member.MemberFileDTO;

@Component
public class FileDown extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("File Down 실행");
		
		FileDTO fileDTO = (FileDTO)model.get("file");
		System.out.println(fileDTO.getFileName());
		System.out.println(fileDTO.getOriName());
		
		String board = (String)model.get("board");
		
		String path="/resources/upload/"+board+"/";
		
		//내장객체는 다른 영역의 내장객체를 불러올수있음
		//단, 좁은 영역에서 큰영역으로 가능. 반대는 불가능
		//page->request->session->application(ServletContext)
		//getRealPath 메소드는 application이 가지고 있음
		//매개변수에 request가 있음
		ServletContext sc = request.getSession().getServletContext();
		
		path=sc.getRealPath(path);
		
		File file = new File(path, fileDTO.getFileName());
		System.out.println(file.exists());
		System.out.println(file.isFile());
		
		//encoding 처리
		response.setCharacterEncoding("UTF-8");
		
		//총파일의크기
		response.setContentLength((int)file.length());
		
		//다운시 파일의 이름을 인코딩
		String fileName=URLEncoder.encode(fileDTO.getOriName(),"UTF-8");
		
		//Hearder 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//HDD에서 파일을 읽어서 Client로 전송
		FileInputStream f1 = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		//최종전송
		FileCopyUtils.copy(f1, os);
		
		//연결끊기
		os.close();
		f1.close();
		
		
		
		
	}
	
}
