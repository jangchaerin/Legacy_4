package com.chaerin.s4.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaerin.s4.MyJunitTest;

public class BankBookDAOTest extends MyJunitTest {
	@Autowired
	private BankBookDAO bankBookDAO;

	@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}
	//list
	@Test
	public void listTest() throws Exception{
		List<BankBookDTO> ar = bankBookDAO.list();
		assertNotEquals(0, ar.size());
	}
	//detail
	//@Test
	public void detailTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(4L);
		bankBookDTO = bankBookDAO.detail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	
	//insert
	//@Test
	public void addTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("t2");
		bankBookDTO.setBookcontents("c2");
		bankBookDTO.setBookRate(3.2);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.add(bankBookDTO);
		
		assertEquals(1, result);
		
	}
	//delete
	//@Test
	public void deleteTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(5L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}
	
	//update
	@Test
	public void updateTest() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookName("t4");
		bankBookDTO.setBookNumber(6L);
		int result = bankBookDAO.update(bankBookDTO);
		assertEquals(1,result);
	}
	
	
	
	
}
