package com.hw.shop.cm.ma.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.validation.Validator;

import com.hw.shop.cm.ma.service.CMMAService;
import com.hw.shop.common.SearchVo;
import com.hw.shop.us.ma.vo.USMAVo;
import com.hw.shop.util.SessionCookUtil;

@Controller
@RequestMapping("/cm/ma/*")
public class CMMAController {
	@Autowired
	private CMMAService service;

	Logger log = Logger.getLogger(getClass());
	
    
//    private VoValidation validator;

    @Autowired  
    private Validator validator;  
      
    public void setValidator(Validator validator) {  
        this.validator = validator;  
    }  
	/**
	 * 로그인창
	 * @param vo
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView CMMA010Q(@ModelAttribute("frmChk")USMAVo vo) throws Exception {

		ModelAndView mav = new ModelAndView();
		return mav;
		
	}
	
	/**
	 * 로그인 프로세스
	 * @param vo
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView CMMA020Q(@ModelAttribute("frmChk") USMAVo vo,BindingResult result,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		ModelAndView mav = null;
		
//		validator = new VoValidation();
//		validator.validate(vo,result);
		validator.validate(vo, result);
        if (result.hasErrors()) { 
        	return new ModelAndView("/cm/ma/CMMA010Q",result.getModel()); 
        } 
		Map usrInfo = service.CMMA020Q(vo);
		if(null ==usrInfo){
			mav = new ModelAndView("redirect:/cm/ma/CMMA010Q.do");
		}else{
			//사용자 세션 등록
			SessionCookUtil scUtil= new SessionCookUtil(req,res);
			scUtil.setUserInfo(usrInfo);
			
			String type=(String) usrInfo.get("type");
			
			if("A".equals(type)){//관리자
				mav = new ModelAndView("redirect:/cm/ma/CMMA010Q.do");
			}else{//사용자
				mav = new ModelAndView("redirect:/cm/ma/CMMA010Q.do");
			}
		}
		return mav;
		
	}

	/**우편번호 조회
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView CMMA030Q(SearchVo vo) throws Exception {

		ModelAndView mav = new ModelAndView();
		
		if(vo.getDong()!=null && !"".equals(vo.getDong())){
			vo.setDong("%"+vo.getDong()+"%");
			mav.addObject("list", service.CMMA030Q(vo));	
		}
		
		return mav;
		
		
	}
}
