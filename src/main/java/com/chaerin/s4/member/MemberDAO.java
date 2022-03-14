package com.chaerin.s4.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaerin.s4.bankbook.BankBookDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.chaerin.s4.member.MemberDAO.";
	
	public MemberFileDTO detailFile(MemberFileDTO memberFileDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"detailFile", memberFileDTO);
	}
	
	public int addFile(MemberFileDTO memberFileDTO) throws Exception{
	      return sqlSession.insert(NAMESPACE+"addFile",memberFileDTO);
	}
	
	public MemberDTO mypage(MemberDTO memberDTO)throws Exception{
	      return sqlSession.selectOne(NAMESPACE+"mypage",memberDTO);
	}

	public int join(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"join", memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
	}
	
	
}
