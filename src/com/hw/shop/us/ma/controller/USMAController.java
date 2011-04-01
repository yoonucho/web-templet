package com.hw.shop.us.ma.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.us.ma.service.USMAService;
import com.hw.shop.us.ma.vo.USMAVo;
import com.hw.shop.util.PaginationInfo;
import com.hw.shop.util.SMCommonUtil;

@Controller
@RequestMapping("/us/ma/*")
public class USMAController {
	@Autowired
	private USMAService service;

	Logger log = Logger.getLogger(getClass());
	
	/**
	 * 목록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView USMA010Q(Map vo) {

		ModelAndView mav = new ModelAndView();
		PaginationInfo paginationInfo = new PaginationInfo();
		int currnetPageNo = vo.get("currentpageno")==null?1:(Integer)vo.get("currentpageno");
		paginationInfo.setCurrentPageNo(currnetPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		int iTotalCnt = service.USMA010CNTQ(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		
		if(iTotalCnt>0){
			paginationInfo.setList(service.USMA010Q(vo));
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
	public ModelAndView USMA020Q(@ModelAttribute("frmSave")USMAVo vo) {
		
		ModelAndView mav = new ModelAndView();
		return mav;
		
	}
	
	/**
	 * 등록 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView USMA020T(@ModelAttribute("frmSave")USMAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/us/ma/USMA010Q.do");
		int cnt = service.USMA020T(vo);
		return mav;
		
	}
	
	/**
	 * 상세조회
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView USMA030Q(USMAVo vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",service.USMA030Q(vo));
		
		return mav;
		
	}
	
	/**
	 * 수정
	 * @param vo
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping
	public ModelAndView USMA031Q(USMAVo vo) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		ModelAndView mav = new ModelAndView("/us/ma/USMA020Q");
		Map hm = service.USMA030Q(vo); 
		
		SMCommonUtil util = new SMCommonUtil();
		USMAVo bean = new USMAVo();
		util.mapToBean(hm, bean);
		mav.addObject("frmSave", bean);
		return mav;
		
	}
	
	/**
	 * 수정프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView USMA030T(USMAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/us/ma/USMA030Q.do?usr_id="+vo.getUsr_id());
		int Cnt = service.USMA030T(vo); 
		return mav;
		
	}
	
	/**
	 * 회원 삭제 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView USMA040T(Map vo) {
		
		ModelAndView mav = new ModelAndView();
		return mav;
		
	}
}
