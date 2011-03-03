package com.hw.shop.bd.ma.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.bd.ma.dao.BDMADao;

@Service
public class BDMAServiceImpl implements BDMAService {
	
	@Autowired
	private BDMADao dao;
	
	/* (non-Javadoc)
	 * @see com.hw.shop.bd.ma.service.BDMAService#BDMA010Q_CNT(java.util.Map)
	 */
	@Override
	public int BDMA010Q_CNT(Map vo){
		return dao.BDMA010Q_CNT(vo);
	}
}
