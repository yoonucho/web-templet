package com.hw.shop.pr.ca.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hw.shop.pr.ca.vo.PRCAVo;
import com.hw.shop.util.BaseDAO;

@Repository
public class PRCADao extends BaseDAO{

	public List PRCA010Q(Map vo){
		return getSqlSession().selectList("BD.PRCA010Q", vo);
	}
	public List PRCA011Q(){
		return getSqlSession().selectList("BD.PRCA011Q");
	}
	
	
	public int PRCA010CNTQ(Map vo){
		return (Integer)getSqlSession().selectOne("BD.PRCA010CNTQ",vo);
	}
	
	public int PRCA020T(PRCAVo vo){
		return getSqlSession().insert("BD.PRCA020T",vo);
	}
	
	public Map PRCA030Q(PRCAVo vo){
		return (Map)getSqlSession().selectOne("BD.PRCA030Q",vo);
	}
	public int PRCA030T(PRCAVo vo){
		return getSqlSession().update("BD.PRCA030T",vo);
	}
}
