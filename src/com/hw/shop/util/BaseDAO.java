package com.hw.shop.util;



import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDAO extends SqlSessionDaoSupport {

	@Resource(name = "sqlSessionFactory")
	public void BaseDAO(SqlSessionFactory session) {
		setSqlSessionFactory(session);
	}
}
