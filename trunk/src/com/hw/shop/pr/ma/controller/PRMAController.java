package com.hw.shop.pr.ma.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.pr.ca.service.PRCAService;
import com.hw.shop.pr.ma.service.PRMAService;
import com.hw.shop.pr.ma.vo.PRMAVo;
import com.hw.shop.util.PaginationInfo;
import com.hw.shop.util.SMCommonUtil;

@Controller
@RequestMapping("/pr/ma/*")
public class PRMAController {
	private final String FILE_PATH= "/pr/ma";
	
	@Autowired
	private PRMAService service;

	@Autowired
	private PRCAService cateService;

	Logger log = Logger.getLogger(PRMAController.class);
	

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
		
		int iTotalCnt = service.PRMA010CNTQ(vo);
		paginationInfo.setTotalRecordCount(iTotalCnt);
		
		if(iTotalCnt>0){
			paginationInfo.setList(service.PRMA010Q(vo));
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
	public ModelAndView PRMA020Q(@ModelAttribute("frmSave")PRMAVo vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cateList",cateService.PRCA011Q());
		
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
	public ModelAndView PRMA020T(@ModelAttribute("frmSave")PRMAVo vo, MultipartHttpServletRequest mRqst) throws IllegalStateException, IOException {
		

		Map pVo = mRqst.getParameterMap();
		
		MultiValueMap mulitFileMap = mRqst.getMultiFileMap();
		SMCommonUtil util = new SMCommonUtil();
		String[] files = {"file1"};
		Map fileMap = util.getFileInfo(mulitFileMap, mRqst.getSession().getServletContext().getRealPath(""),FILE_PATH,false, files);
		
		vo.setPrd_img((String)fileMap.get("file1"));
		
		ModelAndView mav = new ModelAndView("redirect:/pr/ma/PRMA010Q.do");
		int cnt = service.PRMA020T(vo);
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
	 * 수정
	 * @param vo
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@RequestMapping
	public ModelAndView PRMA031Q(PRMAVo vo) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		
		ModelAndView mav = new ModelAndView("/pr/ma/PRMA020Q");
		Map hm = service.PRMA030Q(vo); 
		
		SMCommonUtil util = new SMCommonUtil();
		PRMAVo bean = new PRMAVo();
		util.mapToBean(hm, bean);
		mav.addObject("frmSave", bean);
		mav.addObject("cateList",cateService.PRCA011Q());

		return mav;
		
	}
	
	/**
	 * 수정프로세스
	 * @param vo
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping
	public ModelAndView PRMA030T(PRMAVo vo, MultipartHttpServletRequest mRqst) throws IllegalStateException, IOException {
		
		MultiValueMap mulitFileMap = mRqst.getMultiFileMap();
		SMCommonUtil util = new SMCommonUtil();
		String[] files = {"file1"};
		Map fileMap = util.getFileInfo(mulitFileMap, mRqst.getSession().getServletContext().getRealPath(""),FILE_PATH,false, files);

//		파일삭제
		if(vo.getDel1() !=null && !vo.getDel1().equals("")){File delFile = new File(mRqst.getSession().getServletContext().getRealPath(vo.getDel1()));delFile.delete();	}
		vo.setPrd_img((String)fileMap.get("file1"));
		if(vo.getPrd_img()!=null&&!vo.getPrd_img().equals("") && vo.getFile_name1()!=null&&!vo.getFile_name1().equals("")){File delFile = new File(mRqst.getSession().getServletContext().getRealPath(vo.getFile_name1()));delFile.delete();}
		
		
		ModelAndView mav = new ModelAndView("redirect:/pr/ma/PRMA030Q.do?prd_seq_no="+vo.getPrd_seq_no());
		int Cnt = service.PRMA030T(vo); 
		return mav;
		
	}
	
	/**
	 * 삭제 프로세스
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView PRMA040T(Map vo) {
		
		ModelAndView mav = new ModelAndView();
		return mav;
		
	}
}
