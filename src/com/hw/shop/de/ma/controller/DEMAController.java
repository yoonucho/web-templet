package com.hw.shop.de.ma.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.de.ma.service.DEMAService;
import com.hw.shop.de.ma.vo.DEMAVo;
import com.hw.shop.util.PaginationInfo;

@Controller
@RequestMapping("/de/ma/*")
public class DEMAController {
	@Autowired
	private DEMAService service;

	Logger log = Logger.getLogger(DEMAController.class);
	

	/**
	 * 목록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView DEMA010Q(DEMAVo vo) {

		ModelAndView mav = new ModelAndView();
		PaginationInfo paginationInfo = new PaginationInfo();
		int currnetPageNo = 1;//vo.get("currentpageno")==null?1:(Integer)vo.get("currentpageno");
		paginationInfo.setCurrentPageNo(currnetPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		int iTotalCnt = service.DEMA010CNTQ(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		
		if(iTotalCnt>0){
			List list = service.DEMA010Q(vo);
			List aList = new ArrayList();
			for(int i=0; i < list.size(); i++){
				Map map = (Map) list.get(i);
				map.put("list", service.DEMA011Q(map));
				aList.add(map);
			}
			paginationInfo.setList(aList);
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
	public ModelAndView DEMA020Q(DEMAVo vo) {

		ModelAndView mav = new ModelAndView("jsonView");
		Map map = new HashMap();
		map.put("test", service.DEMA010Q(vo));
		mav.addObject("map", map);
		return mav;
		
	}
	
	/**
	 * 등록 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView DEMA020T(DEMAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/de/ma/DEMA030Q.do?del_seq_no="+vo.getDel_seq_no());
		
		int cnt = service.DEMA020T(vo);
		return mav;
		
	}
	
	/**
	 * 상세조회
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView DEMA030Q(DEMAVo vo) {
		
		ModelAndView mav = new ModelAndView();
		Map dd = service.DEMA030Q(vo);
		mav.addObject("map",service.DEMA030Q(vo));
		mav.addObject("list",service.DEMA031Q(vo));
		
		
		return mav;
		
	}

	
	/**
	 * 수정프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView DEMA030T(DEMAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/de/ma/DEMA030Q.do?del_seq_no="+vo.getDel_seq_no());
		int Cnt = service.DEMA030T(vo); 
		return mav;
		
	}
	
	/**
	 * 회원 삭제 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView DEMA040T(DEMAVo vo) {
		
		ModelAndView mav = new ModelAndView("redirect:/de/ma/DEMA030Q.do?del_seq_no="+vo.getDel_seq_no());
		int cnt = service.DEMA040T(vo);
		return mav;
		
	}
}
