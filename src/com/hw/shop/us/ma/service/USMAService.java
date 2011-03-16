package com.hw.shop.us.ma.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw.shop.us.ma.dao.USMADao;
import com.hw.shop.us.ma.vo.USMAVo;

@Service
public class USMAService {
	@Autowired
	public USMADao dao;

	public List USMA010Q(Map vo){
		return dao.USMA010Q(vo);
	}
	
	public int USMA010CNTQ(Map vo){
		return dao.USMA010CNTQ(vo);
	}
	
	public int USMA020T(USMAVo vo){
		return dao.USMA020T(vo);
	}
	
	public Map USMA030Q(USMAVo vo){
		return dao.USMA030Q(vo);
	}
	
	public int USMA030T(USMAVo vo){
		return dao.USMA030T(vo);
	}
	
	
	
//	
//	public String USMA030Q(USMAVo vo){
//		return dao.USMA030Q(vo);
//	}
//	
//	public int USMA030T(USMAVo vo){
//		return dao.USMA030T(vo);
//	}
//	
//	public int USMA050T(USMAVo vo){
//		return dao.USMA050T(vo);
//	}
//	//dbfile 삭제후 물리 파일 삭제
//	public int USMA051T(Map vo){
//		return dao.USMA051T(vo);
//	}
//	
//	
//	public Map USMA070Q(USMAVo vo){
//		return dao.USMA070Q(vo);
//	}
//	
//	public List USMA071Q(USMAVo vo){
//		return dao.USMA071Q(vo);
//	}
//	
//	
//	public int USMA030FILET(Map vo,String[] files){
//		int returnVal =0;
//		String brd_seq_no = (String)vo.get("brd_seq_no");
//		String reg_id = (String)vo.get("reg_id");
//		String reg_nm = (String)vo.get("reg_nm");
//		
//		for(int i=0; i<files.length;i++){
//			if(vo.get(files[i])!=null){
//				Map pVo = new HashMap();
//				pVo.put("brd_seq_no", brd_seq_no);
//				pVo.put("m_file_nm", vo.get(files[i]));
//				pVo.put("v_file_nm", vo.get(files[i]+"_nm"));
//				pVo.put("reg_id", reg_id);
//				pVo.put("reg_nm", reg_nm);
//				dao.USMA030FILET(pVo);
//				returnVal++;	
//			}
//		}
//		return returnVal;
//	}
}
