package com.hw.shop.bd.ma.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.bd.ma.service.BDMAService;
import com.hw.shop.bd.ma.vo.BDMAVo;
import com.hw.shop.common.SearchVo;
import com.hw.shop.util.PaginationInfo;
import com.hw.shop.util.SMCommonUtil;
import com.hw.shop.util.ToJinsu;

@Controller
@RequestMapping("/bd/ma/*")
public class BDMAController {

	private final String FILE_PATH= "/bd/ma";
	@Autowired
	private BDMAService service;

	Logger log = Logger.getLogger(BDMAController.class);
	/**
	 * 목록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView BDMA010Q(SearchVo vo) {

		if(log.isDebugEnabled()){
			log.debug(vo);
			log.debug("asfasf");			
		}

		ModelAndView mav = new ModelAndView();
		PaginationInfo paginationInfo = new PaginationInfo();
		int currnetPageNo = vo.getCurrentPageNo()==0?1:(Integer)vo.getCurrentPageNo();
		paginationInfo.setCurrentPageNo(currnetPageNo);
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(10);
		log.debug(paginationInfo.getFirstRecordIndex());
		log.debug(paginationInfo.getLastRecordIndex());
		if(vo.getSrc_title()!=null && !vo.getSrc_title().equals("")){
			vo.setSrc_title("%"+vo.getSrc_title()+"%");
		}
		
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
	public ModelAndView BDMA030T(BDMAVo vo, MultipartHttpServletRequest mRqst) throws IllegalStateException, IOException {

		Map pVo = mRqst.getParameterMap();
		ToJinsu jin = new ToJinsu();
		
		MultiValueMap mulitFileMap = mRqst.getMultiFileMap();
		SMCommonUtil util = new SMCommonUtil();
		String[] files = {"file1","file2","file3"};
		Map fileMap = util.getFileInfo(mulitFileMap, mRqst.getSession().getServletContext().getRealPath(""),FILE_PATH,false, files);
		
		String brdSeq = service.BDMA030Q(vo);
		long seq= Long.parseLong(brdSeq);
		seq++;
		vo.setBrd_seq_no(jin.getJinsu(Long.toString(seq)));
		vo.setBrd_seq_o(seq);
//		pVo.put("brd_seq_no", jin.jinsuToDec(Integer.toString(seq)) );
//		pVo.put("brd_type", "I" );
		vo.setBrd_type("I") ;
		
		
		fileMap.put("brd_seq_no", vo.getBrd_seq_no());
		fileMap.put("reg_dt", vo.getReg_dt());
		fileMap.put("reg_id", vo.getReg_id() );
		fileMap.put("reg_nm", vo.getReg_nm());
		
		int resultVal  = service.BDMA030T(vo);
		int resultVal1  = service.BDMA030FILET(fileMap,files);

		ModelAndView mav = new ModelAndView("redirect:/bd/ma/BDMA010Q.do");
		return mav; 
	}
	
	/**
	 * 상세조회
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView BDMA070Q(BDMAVo vo) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("map",service.BDMA070Q(vo));
		mav.addObject("filList",service.BDMA071Q(vo));
		return mav; 
	}
	
	/**
	 * 수정
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView BDMA040Q(BDMAVo vo) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("map",service.BDMA070Q(vo));
		mav.addObject("filList",service.BDMA071Q(vo));
		return mav; 
	}
	
	/**
	 * 수정 프로세스
	 * @param vo
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping
	public ModelAndView BDMA050T(BDMAVo vo, MultipartHttpServletRequest mRqst) throws IllegalStateException, IOException {
		Map pVo = mRqst.getParameterMap();
		ToJinsu jin = new ToJinsu();
		
		MultiValueMap mulitFileMap = mRqst.getMultiFileMap();
		SMCommonUtil util = new SMCommonUtil();
		String[] files = {"file1","file2","file3"};
		Map fileMap = util.getFileInfo(mulitFileMap, mRqst.getSession().getServletContext().getRealPath(""),FILE_PATH,false, files);

		
		ModelAndView mav = new ModelAndView("redirect:/bd/ma/BDMA040Q.do?brd_seq_no="+vo.getBrd_seq_no());
		int resultVal  = service.BDMA050T(vo);
		
		
//		파일삭제
		Map fMap = new HashMap();
		fMap.put("rPath", mRqst.getSession().getServletContext().getRealPath(""));
		
		
		if(vo.getDel1() !=null && !vo.getDel1().equals("")){fMap.put("file_seq_no", vo.getDel1());	service.BDMA051T(fMap);}
		if(vo.getDel2() !=null && !vo.getDel2().equals("")){fMap.put("file_seq_no", vo.getDel2());	service.BDMA051T(fMap);}
		if(vo.getDel3() !=null && !vo.getDel3().equals("")){fMap.put("file_seq_no", vo.getDel3());	service.BDMA051T(fMap);}
		if(vo.getDel4() !=null && !vo.getDel4().equals("")){fMap.put("file_seq_no", vo.getDel4());	service.BDMA051T(fMap);}
		if(vo.getDel5() !=null && !vo.getDel5().equals("")){fMap.put("file_seq_no", vo.getDel5());	service.BDMA051T(fMap);}
		if(vo.getDel6() !=null && !vo.getDel6().equals("")){fMap.put("file_seq_no", vo.getDel6());	service.BDMA051T(fMap);}
		if(vo.getDel7() !=null && !vo.getDel7().equals("")){fMap.put("file_seq_no", vo.getDel7());	service.BDMA051T(fMap);}
		if(vo.getDel8() !=null && !vo.getDel8().equals("")){fMap.put("file_seq_no", vo.getDel8());	service.BDMA051T(fMap);}
		if(vo.getDel9() !=null && !vo.getDel9().equals("")){fMap.put("file_seq_no", vo.getDel9());	service.BDMA051T(fMap);}
		if(vo.getDel10() !=null && !vo.getDel10().equals("")){fMap.put("file_seq_no", vo.getDel10());	service.BDMA051T(fMap);}
		
		vo.setFfile1((String)fileMap.get("file1"));
		vo.setFfile2((String)fileMap.get("file2"));
		vo.setFfile3((String)fileMap.get("file3"));
		vo.setFfile4((String)fileMap.get("file4"));
		vo.setFfile5((String)fileMap.get("file5"));
		vo.setFfile6((String)fileMap.get("file6"));
		vo.setFfile7((String)fileMap.get("file7"));
		vo.setFfile8((String)fileMap.get("file8"));
		vo.setFfile9((String)fileMap.get("file9"));
		vo.setFfile10((String)fileMap.get("file10"));
		
		if(vo.getFfile1()!=null&&!vo.getFfile1().equals("") && vo.getFile_name1()!=null&&!vo.getFile_name1().equals("")){fMap.put("file_seq_no", vo.getFile_name1());	service.BDMA051T(fMap);}
		if(vo.getFfile2()!=null&&!vo.getFfile2().equals("") && vo.getFile_name2()!=null&&!vo.getFile_name2().equals("")){fMap.put("file_seq_no", vo.getFile_name2());	service.BDMA051T(fMap);}
		if(vo.getFfile3()!=null&&!vo.getFfile3().equals("") && vo.getFile_name3()!=null&&!vo.getFile_name3().equals("")){fMap.put("file_seq_no", vo.getFile_name3());	service.BDMA051T(fMap);}
		if(vo.getFfile4()!=null&&!vo.getFfile4().equals("") && vo.getFile_name4()!=null&&!vo.getFile_name4().equals("")){fMap.put("file_seq_no", vo.getFile_name4());	service.BDMA051T(fMap);}
		if(vo.getFfile5()!=null&&!vo.getFfile5().equals("") && vo.getFile_name5()!=null&&!vo.getFile_name5().equals("")){fMap.put("file_seq_no", vo.getFile_name5());	service.BDMA051T(fMap);}
		if(vo.getFfile6()!=null&&!vo.getFfile6().equals("") && vo.getFile_name6()!=null&&!vo.getFile_name6().equals("")){fMap.put("file_seq_no", vo.getFile_name6());	service.BDMA051T(fMap);}
		if(vo.getFfile7()!=null&&!vo.getFfile7().equals("") && vo.getFile_name7()!=null&&!vo.getFile_name7().equals("")){fMap.put("file_seq_no", vo.getFile_name7());	service.BDMA051T(fMap);}
		if(vo.getFfile8()!=null&&!vo.getFfile8().equals("") && vo.getFile_name8()!=null&&!vo.getFile_name8().equals("")){fMap.put("file_seq_no", vo.getFile_name8());	service.BDMA051T(fMap);}
		if(vo.getFfile9()!=null&&!vo.getFfile9().equals("") && vo.getFile_name9()!=null&&!vo.getFile_name9().equals("")){fMap.put("file_seq_no", vo.getFile_name9());	service.BDMA051T(fMap);}
		if(vo.getFfile10()!=null&&!vo.getFfile10().equals("") && vo.getFile_name10()!=null&&!vo.getFile_name10().equals("")){fMap.put("file_seq_no", vo.getFile_name10());	service.BDMA051T(fMap);}
		
		fileMap.put("brd_seq_no", vo.getBrd_seq_no());
		fileMap.put("reg_dt", vo.getReg_dt());
		fileMap.put("reg_id", vo.getReg_id() );
		fileMap.put("reg_nm", vo.getReg_nm());
		int resultVal1  = service.BDMA030FILET(fileMap,files);
		
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/downloadFile.do")
	public ModelAndView downloadFile(ModelMap model, HttpServletRequest req)
			throws Exception {

		File downLoadFile = new File(req.getSession().getServletContext().getRealPath("")+File.separator
				+ req.getParameter("m_file_nm"));
		HashMap fileInfo = new HashMap();
		fileInfo.put("downloadFile", downLoadFile);
		fileInfo.put("fileName", req.getParameter("v_file_nm"));

		return new ModelAndView("download", "fileMap", fileInfo);
	}
}
