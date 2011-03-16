package com.hw.shop.co.ma.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hw.shop.co.ma.vo.COMAVo;
import com.hw.shop.util.BaseDAO;

@Repository
public class COMADao extends BaseDAO{

	public List COMA010Q(COMAVo vo){
		return getSqlSession().selectList("BD.COMA010Q");
	}
	public int COMA010CNTQ(COMAVo vo){
		return (Integer)getSqlSession().selectOne("BD.COMA010CNTQ",vo);
	}

	public String COMA020Q(COMAVo vo){
		return Integer.toString((Integer)getSqlSession().selectOne("BD.COMA020Q",vo));
	}
	
	public int COMA020T(COMAVo vo){
		return getSqlSession().insert("BD.COMA020T",vo);
	}
	
	public Map COMA030Q(COMAVo vo){
		return (Map)getSqlSession().selectOne("BD.COMA030Q",vo);
	}
	public List COMA031Q(COMAVo vo){
		return getSqlSession().selectList("BD.COMA031Q",vo);
	}
	
	public int COMA030T(COMAVo vo){
		return getSqlSession().update("BD.COMA030T",vo);
	}
	public int COMA040T(COMAVo vo){
		return getSqlSession().update("BD.COMA040T",vo);
	}
	
	
}
