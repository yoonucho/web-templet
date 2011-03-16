package com.hw.shop.us.ma.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hw.shop.us.ma.vo.USMAVo;
import com.hw.shop.util.BaseDAO;

@Repository
public class USMADao extends BaseDAO{


	public List USMA010Q(Map vo){
		return getSqlSession().selectList("BD.USMA010Q", vo);
	}
	public int USMA010CNTQ(Map vo){
		return (Integer)getSqlSession().selectOne("BD.USMA010CNTQ",vo);
	}
	
	public int USMA020T(USMAVo vo){
		return getSqlSession().insert("BD.USMA020T",vo);
	}
	
	public Map USMA030Q(USMAVo vo){
		return (Map)getSqlSession().selectOne("BD.USMA030Q",vo);
	}
	public int USMA030T(USMAVo vo){
		return getSqlSession().update("BD.USMA030T",vo);
	}
	
//	
//	public String USMA030Q(USMAVo vo){
//		return (String) getSqlSession().selectOne("BD.USMA030Q",vo);
//	}
//	
//	public Map USMA070Q(USMAVo vo){
//		return (Map)getSqlSession().selectOne("BD.USMA070Q", vo);
//	}
//	
//	public List USMA071Q(USMAVo vo){
//		return getSqlSession().selectList("BD.USMA071Q", vo);
//	}
//	
//
//	public int USMA050T(USMAVo vo){
// 		return (Integer) getSqlSession().update("BD.USMA050T",vo);
//	}
//	
//	public int USMA051T(Map vo){
//		
//		StringBuffer sDelPath= new StringBuffer();
//		sDelPath.append((String)vo.get("rPath"));
//		sDelPath.append((String)getSqlSession().selectOne("BD.USMA051Q",vo));
//		File delFile = new File(sDelPath.toString());
//		delFile.delete();
// 		return (Integer) getSqlSession().delete("BD.USMA051T",vo);
//	}
//	
//	
//	public int USMA030T(USMAVo vo){
// 		return (Integer) getSqlSession().insert("BD.USMA030T",vo);
//	}
//	public int USMA030FILET(Map vo){
//		return (Integer) getSqlSession().insert("BD.USMA030FILET",vo);
//	}
}
