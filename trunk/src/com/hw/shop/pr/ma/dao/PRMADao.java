package com.hw.shop.pr.ma.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hw.shop.pr.ma.vo.PRMACMMTVo;
import com.hw.shop.pr.ma.vo.PRMAVo;
import com.hw.shop.util.BaseDAO;
@Repository
public class PRMADao extends BaseDAO{

	public List PRMA010Q(Map vo){
		return getSqlSession().selectList("BD.PRMA010Q", vo);
	}
	public int PRMA010CNTQ(Map vo){
		return (Integer)getSqlSession().selectOne("BD.PRMA010CNTQ",vo);
	}
	
	public int PRMA020T(PRMAVo vo){
		return getSqlSession().insert("BD.PRMA020T",vo);
	}
	
	public Map PRMA030Q(PRMAVo vo){
		return (Map)getSqlSession().selectOne("BD.PRMA030Q",vo);
	}
	public int PRMA030T(PRMAVo vo){
		return getSqlSession().update("BD.PRMA030T",vo);
	}
	
	public List PRMA050Q(PRMACMMTVo vo){
		return getSqlSession().selectList("BD.PRMA050Q",vo);
	}
	
	public int PRMA051Q(PRMACMMTVo vo){
		return (Integer) getSqlSession().selectOne("BD.PRMA051Q",vo);
	}
	public int PRMA050T(PRMACMMTVo vo){
		return (Integer) getSqlSession().insert("BD.PRMA050T",vo);
	}
	public int PRMA051T(PRMACMMTVo vo){
		return (Integer) getSqlSession().delete("BD.PRMA051T",vo);
	}
	public int PRMA052T(PRMACMMTVo vo){
		return (Integer) getSqlSession().update("BD.PRMA052T",vo);
	}
	
	
	
	
	
}
