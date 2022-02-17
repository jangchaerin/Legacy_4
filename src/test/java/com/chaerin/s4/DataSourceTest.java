package com.chaerin.s4;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class DataSourceTest extends MyJunitTest {
	   @Autowired
	   private DataSource datasource;
	   
	   @Autowired
	   private SqlSession session;
	   
	   @Test
	   public void connectionTest() throws Exception{
	      assertNotNull(datasource.getConnection());
	   }
	   @Test
	   public void sessionTest() {
		   assertNotNull(session);
	   }

	}
