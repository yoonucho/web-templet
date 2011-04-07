package com.hw.usr.pr.ma.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.pr.ca.service.PRCAService;
import com.hw.shop.pr.ma.service.PRMAService;
import com.hw.shop.pr.ma.vo.PRMACMMTVo;
import com.hw.shop.pr.ma.vo.PRMAVo;
import com.hw.shop.util.PaginationInfo;

@Controller
@SessionAttributes("userInfo")
@RequestMapping("/usr/pr/ma/*")
public class UPRMAController {
	private final String FILE_PATH= "/pr/ma";
	
	@Autowired
	private PRMAService service;

	@Autowired
	private PRCAService cateService;

	Logger log = Logger.getLogger(UPRMAController.class);
	

	/**
	 * 목록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView PRMA010Q(Map vo) {

		ModelAndView mav = new ModelAndView();
		PaginationInfo paginationInfo = new PaginationInfo();
		int currnetPageNo = vo.get("currentpageno")==null?1:(Integer)vo.get("currentpageno");
		paginationInfo.setCurrentPageNo(currnetPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		if(vo.get("")!=null && !"".equals(vo.get("src_title"))){
			vo.put("src_title","%"+vo.get("src_title")+"%");
		}
		
		int iTotalCnt = service.PRMA010CNTQ(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		
		if(iTotalCnt>0){
			paginationInfo.setList(service.PRMA010Q(vo));
		}
		mav.addObject("paginationInfo", paginationInfo);
		return mav;
	}
	
	
	/**
	 * 상세조회
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView PRMA030Q(PRMAVo vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map",service.PRMA030Q(vo));
		
		return mav;
		
	}
	

	/**
	 * 상품평 가져오기
	 * @param vo
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping
	public ModelAndView PRMA050Q(PRMACMMTVo vo) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		ModelAndView mav = new ModelAndView("jsonView");
		PaginationInfo paginationInfo = new PaginationInfo(vo);
		vo.setRecordCountPerPage(5);
		int iTotalCnt = service.PRMA051Q(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		
		if(iTotalCnt>0){
			paginationInfo.setList(service.PRMA050Q(vo));
		}
		//log.debug(paginationInfo.getPrameter());
		HashMap map = new HashMap();
		map.put("list", paginationInfo.getList());
		map.put("paging", paginationInfo.getList());
		mav.addObject("map", map);
		
		return mav;
	}
	

	/**
	 * 상품평등록
	 * @param vo
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView PRMA050T(@ModelAttribute("userInfo")Map userInfo, PRMACMMTVo vo) {
		
		if(userInfo!=null){
			vo.setReg_id((String)userInfo.get("usr_id"));
			vo.setReg_nm((String)userInfo.get("name"));
			vo.setUdt_id((String)userInfo.get("usr_id"));
			vo.setUdt_nm((String)userInfo.get("name"));
		}

		ModelAndView mav = new ModelAndView("jsonView");
		
		Map map = new HashMap();
		map.put("cnt", service.PRMA050T(vo));
		mav.addObject("map", map);
		
		
		System.out.println( mav.getModelMap().get("userInfo"));
		
		return mav;
	}
	
	/**
	 * 상품평 삭제
	 * @param vo
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView PRMA051T(PRMACMMTVo vo) {
		ModelAndView mav = new ModelAndView("jsonView");
		Map map = new HashMap();
		map.put("cnt", service.PRMA051T(vo));
		mav.addObject("map", map);
		return mav;
	}
	/**
	 * 상품평 수정
	 * @param vo
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView PRMA052T(PRMACMMTVo vo) {
		ModelAndView mav = new ModelAndView("jsonView");
		Map map = new HashMap();
		map.put("cnt", service.PRMA052T(vo));
		mav.addObject("map", map);
		return mav;
	}
	
}
