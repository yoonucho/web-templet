package com.hw.shop.de.ma.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hw.shop.de.ma.vo.DELIREQVo;
import com.hw.shop.de.ma.vo.DEMAVo;
import com.hw.shop.util.BaseDAO;
@Repository
public class DEMADao extends BaseDAO{

	public List DEMA010Q(DEMAVo vo){
		return getSqlSession().selectList("BD.DEMA010Q",vo);
	}
	
	public List DEMA011Q(Map vo){
		return getSqlSession().selectList("BD.DEMA011Q",vo);
	}
	
	public int DEMA010CNTQ(DEMAVo vo){
		return (Integer)getSqlSession().selectOne("BD.DEMA010CNTQ",vo);
	}

	public String DEMA020Q(DEMAVo vo){
		return Integer.toString((Integer)getSqlSession().selectOne("BD.DEMA020Q",vo));
	}
	
	public int DEMA020T(DEMAVo vo){
		return getSqlSession().insert("BD.DEMA020T",vo);
	}
	
	public Map DEMA030Q(DEMAVo vo){
		return (Map)getSqlSession().selectOne("BD.DEMA030Q",vo);
	}
	public List DEMA031Q(DEMAVo vo){
		return getSqlSession().selectList("BD.DEMA031Q",vo);
	}
	
	public int DEMA030T(DEMAVo vo){
		return getSqlSession().update("BD.DEMA030T",vo);
	}
	public int DEMA040T(DEMAVo vo){
		return getSqlSession().update("BD.DEMA040T",vo);
	}
	
	public List DEMA050Q(DELIREQVo vo){
		return getSqlSession().selectList("BD.DEMA050Q",vo);
	}
	
	public int DEMA050T(DEMAVo vo){
		return getSqlSession().update("BD.DEMA050T",vo);
	}
	//제품 수량 등록
	public int DEMA050_1T(DEMAVo vo){
		return getSqlSession().update("BD.DEMA050_1T",vo);
	}
	public long DEMA050_2Q(){
		return (Long) getSqlSession().selectOne("BD.DEMA050_2Q");
	}
	
	
}
