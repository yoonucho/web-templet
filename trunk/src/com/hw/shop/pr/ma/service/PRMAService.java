package com.hw.shop.pr.ma.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.pr.ma.dao.PRMADao;
import com.hw.shop.pr.ma.vo.PRMACMMTVo;
import com.hw.shop.pr.ma.vo.PRMAVo;

@Service
public class PRMAService {
	@Autowired
	public PRMADao dao;

	public List PRMA010Q(Map vo){
		return dao.PRMA010Q(vo);
	}
	
	public int PRMA010CNTQ(Map vo){
		return dao.PRMA010CNTQ(vo);
	}
	
	public int PRMA020T(PRMAVo vo){
		return dao.PRMA020T(vo);
	}
	
	public Map PRMA030Q(PRMAVo vo){
		return dao.PRMA030Q(vo);
	}
	
	public int PRMA030T(PRMAVo vo){
		return dao.PRMA030T(vo);
	}
	public List PRMA050Q(PRMACMMTVo vo){
		return dao.PRMA050Q(vo);
	}
	public int PRMA051Q(PRMACMMTVo vo){
		return dao.PRMA051Q(vo);
	}
	public int PRMA050T(PRMACMMTVo vo){
		return dao.PRMA050T(vo);
	}
	public int PRMA051T(PRMACMMTVo vo){
		return dao.PRMA051T(vo);
	}
	public int PRMA052T(PRMACMMTVo vo){
		return dao.PRMA052T(vo);
	}
	
	
}
