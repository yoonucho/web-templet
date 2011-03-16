package com.hw.shop.pr.ca.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.pr.ca.dao.PRCADao;
import com.hw.shop.pr.ca.vo.PRCAVo;

@Service
public class PRCAService {
	@Autowired
	public PRCADao dao;

	public List PRCA010Q(Map vo){
		return dao.PRCA010Q(vo);
	}
	public List PRCA011Q(){
		return dao.PRCA011Q();
	}
	
	public int PRCA010CNTQ(Map vo){
		return dao.PRCA010CNTQ(vo);
	}
	
	public int PRCA020T(PRCAVo vo){
		return dao.PRCA020T(vo);
	}
	
	public Map PRCA030Q(PRCAVo vo){
		return dao.PRCA030Q(vo);
	}
	
	public int PRCA030T(PRCAVo vo){
		return dao.PRCA030T(vo);
	}
}
