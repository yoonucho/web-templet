package com.hw.shop.pr.ca.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.pr.ca.service.PRCAService;
import com.hw.shop.pr.ca.vo.PRCAVo;
import com.hw.shop.util.PaginationInfo;
import com.hw.shop.util.SMCommonUtil;

@Controller
@RequestMapping("/pr/ca/*")
public class PRCAController {
	@Autowired
	private PRCAService service;

	Logger log = Logger.getLogger(PRCAController.class);
	

	/**
	 * 목록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView PRCA010Q(Map vo) {

		ModelAndView mav = new ModelAndView();
		PaginationInfo paginationInfo = new PaginationInfo();
		int currnetPageNo = vo.get("currentpageno")==null?1:(Integer)vo.get("currentpageno");
		paginationInfo.setCurrentPageNo(currnetPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		int iTotalCnt = service.PRCA010CNTQ(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		
		if(iTotalCnt>0){
			paginationInfo.setList(service.PRCA010Q(vo));
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
	public ModelAndView PRCA020Q(@ModelAttribute("frmSave")PRCAVo vo) {
		
		ModelAndView mav = new ModelAndView();
		return mav;
		
	}
	
	/**
	 * 등록 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView PRCA020T(@ModelAttribute("frmSave")PRCAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/pr/ca/PRCA010Q.do");
		int cnt = service.PRCA020T(vo);
		return mav;
		
	}
	
	/**
	 * 상세조회
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView PRCA030Q(PRCAVo vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",service.PRCA030Q(vo));
		
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
	public ModelAndView PRCA031Q(PRCAVo vo) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		ModelAndView mav = new ModelAndView("/pr/ca/PRCA020Q");
		Map hm = service.PRCA030Q(vo); 
		
		SMCommonUtil util = new SMCommonUtil();
		PRCAVo bean = new PRCAVo();
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
	public ModelAndView PRCA030T(PRCAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/pr/ca/PRCA030Q.do?cate_seq_no="+vo.getCate_seq_no() );
		int Cnt = service.PRCA030T(vo); 
		return mav;
		
	}
	
	/**
	 * 회원 삭제 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView PRCA040T(Map vo) {
		
		ModelAndView mav = new ModelAndView();
		return mav;
		
	}
}
