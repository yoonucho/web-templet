package com.hw.shop.de.ma.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.de.ma.dao.DEMADao;
import com.hw.shop.de.ma.vo.DEMAVo;

@Service
public class DEMAService {
	@Autowired
	public DEMADao dao;

	public List DEMA010Q(DEMAVo vo) {
		return dao.DEMA010Q(vo);
	}
	
	public List DEMA011Q(Map vo) {
		return dao.DEMA011Q(vo);
	}
	

	public int DEMA010CNTQ(DEMAVo vo) {
		return dao.DEMA010CNTQ(vo);
	}

	public String DEMA020Q(DEMAVo vo) {
		return dao.DEMA020Q(vo);
	}

	public int DEMA020T(DEMAVo vo) {
		// return 1;
		return dao.DEMA020T(vo);
	}

	public Map DEMA030Q(DEMAVo vo) {
		return dao.DEMA030Q(vo);
	}

	public List DEMA031Q(DEMAVo vo) {
		return dao.DEMA031Q(vo);
	}

	public int DEMA030T(DEMAVo vo) {
		return dao.DEMA030T(vo);
	}

	public int DEMA040T(DEMAVo vo) {
		return dao.DEMA040T(vo);
	}
}
