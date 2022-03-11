package com.chaerin.s4.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chaerin.s4.board.BoardDTO;
import com.chaerin.s4.board.BoardService;
import com.chaerin.s4.util.FileManager;
import com.chaerin.s4.util.Pager;
@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		pager.makeNum(noticeDAO.total(pager));
		return noticeDAO.list(pager);
	
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		//long num = noticeDAO.seqNum();
		//boardDTO.setNum(num);

		int result = noticeDAO.add(boardDTO);
		
		//1. HDD에 저장
		for(int i=0;i<files.length;i++) {
			if(files[i].isEmpty()){
				//files[i].getsize()가 0과 같습니까 
				continue;
			}
			String fileName = fileManager.save(files[i], "resources/upload/notice/");
	
		//2. DB에 저장
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setNum(boardDTO.getNum());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriName(files[i].getOriginalFilename());
			
			result=noticeDAO.addFile(noticeFileDTO);
		
		}	
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.delete(boardDTO);
	}
	
	

}