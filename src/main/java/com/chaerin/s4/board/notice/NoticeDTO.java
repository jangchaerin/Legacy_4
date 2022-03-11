package com.chaerin.s4.board.notice;

import java.sql.Date;
import java.util.List;

import com.chaerin.s4.board.BoardDTO;

public class NoticeDTO extends BoardDTO{
	
	private List<NoticeFileDTO> fileDTOs;
	// noticedto의 하나의 결과물과 noticefiledto의 여러개의 결과물 즉 1:n
	
	public List<NoticeFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<NoticeFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	

	
	


}