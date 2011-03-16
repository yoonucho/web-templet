package com.hw.shop.co.ma.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.co.ma.dao.COMADao;
import com.hw.shop.co.ma.vo.COMAVo;

@Service
public class COMAService {
	@Autowired
	public COMADao dao;

	public List COMA010Q(COMAVo vo){
		return dao.COMA010Q(vo);
	}
	
	public int COMA010CNTQ(COMAVo vo){
		return dao.COMA010CNTQ(vo);
	}
	public String COMA020Q(COMAVo vo){
		return dao.COMA020Q(vo);
	}
	
	
	public int COMA020T(COMAVo vo){
//		return 1;
		return dao.COMA020T(vo);
	}
	
	public Map COMA030Q(COMAVo vo){
		return dao.COMA030Q(vo);
	}
	public List COMA031Q(COMAVo vo){
		return dao.COMA031Q(vo);
	}
	
	
	public int COMA030T(COMAVo vo){
		return dao.COMA030T(vo);
	}
	public int COMA040T(COMAVo vo){
		return dao.COMA040T(vo);
	}
	
}
