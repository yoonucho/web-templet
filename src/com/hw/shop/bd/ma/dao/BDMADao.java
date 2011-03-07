package com.hw.shop.bd.ma.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hw.shop.util.BaseDAO;

@Repository
public class BDMADao extends BaseDAO  {
	
//	@Autowired
//	private SqlSessionFactory session1;
//	
//	public BDMADao() {
//		// TODO Auto-generated constructor stub
//		setSqlSessionFactory(session1);
//	}

	public List BDMA010Q(Map vo){
		return getSqlSession().selectList("BD.BDMA010Q", vo);
	}
	public int BDMA010CNTQ(Map vo){
		int  i =  (Integer) getSqlSession().selectOne("BD.BDMA010CNTQ",vo);
		return i;
	}
	
	public String BDMA030Q(Map vo){
		return (String) getSqlSession().selectOne("BD.BDMA030Q",vo);
	}

	public int BDMA030T(Map vo){
 		return (Integer) getSqlSession().insert("BD.BDMA030T",vo);
	}
	public int BDMA030FILET(Map vo){
		return (Integer) getSqlSession().insert("BD.BDMA030FILET",vo);
	}
	
}
