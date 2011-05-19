package com.hw.shop.de.ma.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.de.ma.dao.DEMADao;
import com.hw.shop.de.ma.vo.DELIREQVo;
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
	
	public List DEMA050Q(DELIREQVo vo) {
		return dao.DEMA050Q(vo);
	}
	
	public int DEMA050T(DEMAVo vo) {
		
		long del_seq_no  = dao.DEMA050_2Q();
		vo.setDel_seq_no(del_seq_no);
		int returnInt = dao.DEMA050T(vo);
		
		for(int i = 0; i < vo.getPrd_seq_nos().length; i++){
			DEMAVo product = new DEMAVo();
			product.setDel_seq_no(del_seq_no);
			product.setPrd_seq_no(vo.getPrd_seq_nos()[i]);
			product.setDel_cnt(vo.getDel_cnts()[i]);
			dao.DEMA050_1T(product);
		}
		return returnInt;
	}
	
}
