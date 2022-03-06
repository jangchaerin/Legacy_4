package com.chaerin.s4.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaerin.s4.MyJunitTest;
import com.chaerin.s4.qna.QnaDTO;
import com.chaerin.s4.util.Pager;

public class qnaTest extends MyJunitTest{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void addtest() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		
		for(int i=1; i<100 ;i++) {
			qnaDTO.setTitle("Title"+i);
			qnaDTO.setContents("Contents"+i);
			qnaDTO.setWriter("Writer"+i);
			qnaDTO.setHit("5");
			qnaDTO.setRef(0L);
			qnaDTO.setStep(0L);
			qnaDTO.setDepth(0L);
			
			int result=qnaDAO.add(qnaDTO);
			
		}
	}
	
	//list
	//@Test
	  public void listTest(Pager pager) throws Exception {
	      List<QnaDTO> ar =qnaDAO.list(pager);
	      assertNotEquals(0, ar.size());
	   }
	
}
