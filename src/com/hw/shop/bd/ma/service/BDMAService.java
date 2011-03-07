package com.hw.shop.bd.ma.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.bd.ma.dao.BDMADao;

@Service
public class BDMAService {
	@Autowired
	public BDMADao dao;
	
	public List BDMA010Q(Map vo){
		return dao.BDMA010Q(vo);
	}
	
	public int BDMA010CNTQ(Map vo){
		return dao.BDMA010CNTQ(vo);
	}
	
	
	public String BDMA030Q(Map vo){
		return dao.BDMA030Q(vo);
	}
	
	public int BDMA030T(Map vo){
		return dao.BDMA030T(vo);
	}
	
	
}
