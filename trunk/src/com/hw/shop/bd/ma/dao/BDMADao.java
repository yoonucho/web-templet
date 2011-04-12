package com.hw.shop.bd.ma.dao;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hw.shop.bd.ma.vo.BDMAVo;
import com.hw.shop.common.SearchVo;
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

	public List BDMA010Q(SearchVo vo){
		return getSqlSession().selectList("BD.BDMA010Q", vo);
	}
	public int BDMA010CNTQ(SearchVo vo){
		int  i =  (Integer) getSqlSession().selectOne("BD.BDMA010CNTQ",vo);
		return i;
	}
	
	public String BDMA030Q(BDMAVo vo){
		return (String) getSqlSession().selectOne("BD.BDMA030Q",vo);
	}
	
	public String BDMA070CNTQ(BDMAVo vo){
		return (String) getSqlSession().selectOne("BD.BDMA070CNTQ",vo);
	}
	
	public Map BDMA070Q(BDMAVo vo){
		return (Map)getSqlSession().selectOne("BD.BDMA070Q", vo);
	}
	
	public List BDMA071Q(BDMAVo vo){
		return getSqlSession().selectList("BD.BDMA071Q", vo);
	}
	

	public int BDMA050T(BDMAVo vo){
 		return (Integer) getSqlSession().update("BD.BDMA050T",vo);
	}
	
	public int BDMA051T(Map vo){
		
		StringBuffer sDelPath= new StringBuffer();
		sDelPath.append((String)vo.get("rPath"));
		sDelPath.append((String)getSqlSession().selectOne("BD.BDMA051Q",vo));
		File delFile = new File(sDelPath.toString());
		delFile.delete();
 		return (Integer) getSqlSession().delete("BD.BDMA051T",vo);
	}
	
	
	public int BDMA030T(BDMAVo vo){
 		return (Integer) getSqlSession().insert("BD.BDMA030T",vo);
	}
	public int BDMA030FILET(Map vo){
		return (Integer) getSqlSession().insert("BD.BDMA030FILET",vo);
	}
	
}
