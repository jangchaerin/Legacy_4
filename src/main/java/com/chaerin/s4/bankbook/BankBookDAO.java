package com.chaerin.s4.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaerin.s4.util.Pager;

@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.chaerin.s4.bankbook.BankBookDAO."; //변경금지하려고 혹시라도 다른거 쓰지 못하게
	
	//total
	public Long total() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"total");
	}
	
	//list 가지고 올 메소드
	public List<BankBookDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	//detail
	public BankBookDTO detail(BankBookDTO bankBookDTO) throws Exception{	
		return sqlSession.selectOne(NAMESPACE+"detail", bankBookDTO);
	}
	//insert
	public int add(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", bankBookDTO);
	}
	//delete 
	public int delete(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", bankBookDTO);
	}
	//update
	public int update(BankBookDTO bankBookDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update", bankBookDTO);
	}	
}