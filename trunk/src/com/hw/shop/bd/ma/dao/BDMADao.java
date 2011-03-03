package com.hw.shop.bd.ma.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hw.shop.common.BaseDao;

@Repository
public class BDMADao extends BaseDao {
	public int BDMA010Q_CNT(Map vo){
		
		return jt.queryForInt("select 1 as cnt");
	}
}
