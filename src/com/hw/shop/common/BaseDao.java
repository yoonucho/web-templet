package com.hw.shop.common;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


public class BaseDao{
	
	@Resource(name = "jdbcTemplate")
	public JdbcTemplate jt;
	
}
