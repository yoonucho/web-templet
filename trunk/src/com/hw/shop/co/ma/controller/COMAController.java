package com.hw.shop.co.ma.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.co.ma.service.COMAService;
import com.hw.shop.co.ma.vo.COMAVo;
import com.hw.shop.util.PaginationInfo;
import com.hw.shop.util.SMCommonUtil;

@Controller
@RequestMapping("/co/ma/*")
public class COMAController {
	@Autowired
	private COMAService service;

	Logger log = Logger.getLogger(getClass());
	

	/**
	 * 목록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView COMA010Q(COMAVo vo) {

		ModelAndView mav = new ModelAndView();
		PaginationInfo paginationInfo = new PaginationInfo();
		int currnetPageNo = 1;//vo.get("currentpageno")==null?1:(Integer)vo.get("currentpageno");
		paginationInfo.setCurrentPageNo(currnetPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		int iTotalCnt = service.COMA010CNTQ(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		
		if(iTotalCnt>0){
			paginationInfo.setList(service.COMA010Q(vo));
		}
		mav.addObject("paginationInfo", paginationInfo);
		return mav;
	}
	
	/**
	 * 등록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView COMA020Q(COMAVo vo) {

		ModelAndView mav = new ModelAndView("jsonView");
		Map map = new HashMap();
		map.put("test", service.COMA010Q(vo));
		mav.addObject("map", map);
		return mav;
		
	}
	
	/**
	 * 등록 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView COMA020T(COMAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/co/ma/COMA030Q.do?code_seq_no="+vo.getCode_p_seq_no());
		
		
		vo.setCode_order( Long.parseLong( service.COMA020Q(vo)) );
		
		int cnt = service.COMA020T(vo);
		return mav;
		
	}
	
	/**
	 * 상세조회
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView COMA030Q(COMAVo vo) {
		
		ModelAndView mav = new ModelAndView();
		Map dd = service.COMA030Q(vo);
		mav.addObject("map",service.COMA030Q(vo));
		mav.addObject("list",service.COMA031Q(vo));
		
		
		return mav;
		
	}

	
	/**
	 * 수정프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView COMA030T(COMAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/co/ma/COMA030Q.do?code_seq_no="+vo.getCode_p_seq_no());
		int Cnt = service.COMA030T(vo); 
		return mav;
		
	}
	
	/**
	 * 회원 삭제 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView COMA040T(COMAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/co/ma/COMA030Q.do?code_seq_no="+vo.getCode_p_seq_no());
		int cnt = service.COMA040T(vo);
		return mav;
		
	}
}
