package com.chaerin.s4.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chaerin.s4.util.Pager;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.chaerin.s4.notice.NoticeDAO.";
	//list
		public List<NoticeDTO> list(Pager pager) throws Exception{
			return sqlSession.selectList(NAMESPACE+"list",pager);
		}
		//total
		public Long total()throws Exception{
			return sqlSession.selectOne(NAMESPACE+"total");
		}
	//detail
		public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception{	
			return sqlSession.selectOne(NAMESPACE+"detail", noticeDTO);
		}
	//insert
		public int add(NoticeDTO noticeDTO) throws Exception {
			return sqlSession.insert(NAMESPACE+"add", noticeDTO);
		}
		
	//delete
		public int delete(NoticeDTO noticeDTO) throws Exception{
			return sqlSession.delete(NAMESPACE+"delete", noticeDTO);
		}
}