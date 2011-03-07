package com.hw.shop.bd.ma.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.bd.ma.service.BDMAService;
import com.hw.shop.util.PaginationInfo;
import com.hw.shop.util.SMCommonUtil;

@Controller
@RequestMapping("/bd/ma/*")
public class BDMAController {

	private final String FILE_PATH= "/bd/ma";
	@Autowired
	private BDMAService service;

	/**
	 * 목록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView BDMA010Q(Map vo) {

		ModelAndView mav = new ModelAndView();
		PaginationInfo paginationInfo = new PaginationInfo();
		int currnetPageNo = vo.get("currentpageno")==null?1:(Integer)vo.get("currentpageno");
		paginationInfo.setCurrentPageNo(currnetPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		
		int iTotalCnt = service.BDMA010CNTQ(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		
		if(iTotalCnt>0){
			paginationInfo.setList(service.BDMA010Q(vo));
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
	public ModelAndView BDMA020Q(Map vo) {

		ModelAndView mav = new ModelAndView();
		return mav; 
	}
	
	/**
	 * 등록 프로세스
	 * @param vo
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping
	public ModelAndView BDMA030T(Map vo, MultipartHttpServletRequest mRqst) throws IllegalStateException, IOException {

		MultiValueMap mulitFileMap = mRqst.getMultiFileMap();
		SMCommonUtil util = new SMCommonUtil();
		String[] files = {"file1","file2","file3"};
		Map fileMap = util.getFileInfo(mulitFileMap, mRqst.getSession().getServletContext().getRealPath(""),FILE_PATH,true, files);
		
		String brdSeq = service.BDMA030Q(vo);
		
		System.out.println(1);
		

		ModelAndView mav = new ModelAndView("redirect:/bd/ma/BDMA010Q.do");
		return mav; 
	}
	
	/**
	 * 수정
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView BDMA040Q(Map vo) {

		ModelAndView mav = new ModelAndView();
		return mav; 
	}
	
	/**
	 * 수정 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView BDMA050T(Map vo) {

		ModelAndView mav = new ModelAndView();
		return mav; 
	}
	
	/**
	 * 삭제 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView BDMA060T(Map vo) {

		ModelAndView mav = new ModelAndView();
		return mav; 
	}
}
