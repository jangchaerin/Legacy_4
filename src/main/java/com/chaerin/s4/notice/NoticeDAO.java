
package com.chaerin.s4.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.prac.s1.notice.NoticeDAO.";

	// list
	public List<NoticeDTO> list() throws Exception{
      return sqlSession.selectList(NAMESPACE+"list");
   }
}