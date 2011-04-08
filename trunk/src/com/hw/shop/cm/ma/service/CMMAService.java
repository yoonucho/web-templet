package com.hw.shop.cm.ma.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.cm.ma.dao.CMMADao;
import com.hw.shop.common.SearchVo;
import com.hw.shop.us.ma.vo.USMAVo;
@Service
public class CMMAService {
	@Autowired
	public CMMADao dao;
	
	public Map CMMA020Q(USMAVo vo){
		return dao.CMMA020Q(vo);
	}
	
	public List CMMA030Q(SearchVo vo){
		return dao.CMMA030Q(vo);
	}
	
}
