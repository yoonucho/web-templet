package com.hw.shop.bd.ma.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.bd.ma.dao.BDMADao;
import com.hw.shop.bd.ma.vo.BDMAVo;
import com.hw.shop.common.SearchVo;

@Service
public class BDMAService {
	@Autowired
	public BDMADao dao;
	
	public List BDMA010Q(SearchVo vo){
		return dao.BDMA010Q(vo);
	}
	
	public int BDMA010CNTQ(SearchVo vo){
		return dao.BDMA010CNTQ(vo);
	}
	
	
	public String BDMA030Q(BDMAVo vo){
		return dao.BDMA030Q(vo);
	}
	
	public String BDMA070CNTQ(BDMAVo vo){
		return dao.BDMA070CNTQ(vo);
	}
	
	
	public int BDMA030T(BDMAVo vo){
		return dao.BDMA030T(vo);
	}
	
	public int BDMA050T(BDMAVo vo){
		return dao.BDMA050T(vo);
	}
	//dbfile 삭제후 물리 파일 삭제
	public int BDMA051T(Map vo){
		return dao.BDMA051T(vo);
	}
	
	
	public Map BDMA070Q(BDMAVo vo){
		return dao.BDMA070Q(vo);
	}
	
	public List BDMA071Q(BDMAVo vo){
		return dao.BDMA071Q(vo);
	}
	
	
	public int BDMA030FILET(Map vo,String[] files){
		int returnVal =0;
		String brd_seq_no = (String)vo.get("brd_seq_no");
		String reg_id = (String)vo.get("reg_id");
		String reg_nm = (String)vo.get("reg_nm");
		
		for(int i=0; i<files.length;i++){
			if(vo.get(files[i])!=null){
				Map pVo = new HashMap();
				pVo.put("brd_seq_no", brd_seq_no);
				pVo.put("m_file_nm", vo.get(files[i]));
				pVo.put("v_file_nm", vo.get(files[i]+"_nm"));
				pVo.put("reg_id", reg_id);
				pVo.put("reg_nm", reg_nm);
				dao.BDMA030FILET(pVo);
				returnVal++;	
			}
		}
		return returnVal;
	}
	
}
