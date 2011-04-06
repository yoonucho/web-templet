package com.hw.usr.bd.ma.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.bd.ma.service.BDMAService;
import com.hw.shop.bd.ma.vo.BDMAVo;
import com.hw.shop.common.SearchVo;
import com.hw.shop.util.PaginationInfo;

@Controller
@RequestMapping("/usr/bd/ma/*")
public class UBDMAController {
	@Autowired
	private BDMAService service;
	
	Logger log = Logger.getLogger(getClass());
	
	/**
	 * 목록
	 * @param vo
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping
	public ModelAndView BDMA010Q(SearchVo vo) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		if(log.isDebugEnabled()){
			log.debug(vo);
			log.debug("asfasf");			
		}

		ModelAndView mav = new ModelAndView();
		PaginationInfo paginationInfo = new PaginationInfo(vo);
		if(vo.getSrc_title()!=null && !vo.getSrc_title().equals("")){
			vo.setSrc_title("%"+vo.getSrc_title()+"%");
		}
		int iTotalCnt = service.BDMA010CNTQ(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		log.debug(paginationInfo.getPrameter());
		if(iTotalCnt>0){
			paginationInfo.setList(service.BDMA010Q(vo));
		}
		log.debug(paginationInfo.getPrameter());
		mav.addObject("paginationInfo", paginationInfo);
		
		return mav; 
	}
	
	@RequestMapping
	public ModelAndView BDMA070Q(BDMAVo vo,HttpServletRequest req) {
		log.debug(req.getParameterMap().toString());

		ModelAndView mav = new ModelAndView();
		mav.addObject("map",service.BDMA070Q(vo));
		mav.addObject("filList",service.BDMA071Q(vo));
		return mav; 
	}
	

}
