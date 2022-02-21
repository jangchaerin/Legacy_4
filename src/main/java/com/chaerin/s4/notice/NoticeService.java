package com.chaerin.s4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NoticeService {
	@Autowired
	private NoticeDAO noticeDAO;
	
	//list
	public List<NoticeDTO> list() throws Exception{
		List<NoticeDTO> ar = noticeDAO.list();
		return ar;
	}
	
	//detail 
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.detail(noticeDTO);
	}
	
	//add(insert)
	public int add(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.add(noticeDTO);
	}


}