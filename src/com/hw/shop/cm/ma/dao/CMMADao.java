package com.hw.shop.cm.ma.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hw.shop.us.ma.vo.USMAVo;
import com.hw.shop.util.BaseDAO;

@Repository
public class CMMADao extends BaseDAO{

	public Map CMMA020Q(USMAVo vo){
		return (Map) getSqlSession().selectOne("BD.CMMA020Q",vo);
	}
}
