package com.hw.shop.cm.ma.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.cm.ma.service.CMMAService;
import com.hw.shop.us.ma.vo.USMAVo;
import com.hw.shop.util.SessionCookUtil;

@Controller
@RequestMapping("/cm/ma/*")
public class CMMAController {
	@Autowired
	private CMMAService service;

	Logger log = Logger.getLogger(CMMAController.class);
	
	/**
	 * 로그인창
	 * @param vo
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping
	public ModelAndView CMMA010Q(@ModelAttribute("frmChk")USMAVo vo,HttpServletRequest req, HttpServletResponse res) throws Exception {
//		SessionCookUtil scUtil= new SessionCookUtil(req,res);
//		Map dd = scUtil.getUserInfo();
//		if(dd!=null)
//			log.debug(dd.toString());
		
		
		ModelAndView mav = new ModelAndView();
		return mav;
		
	}
	
	@RequestMapping
	public ModelAndView CMMA020Q(@ModelAttribute("frmChk")USMAVo vo,HttpServletRequest req, HttpServletResponse res) throws Exception {

		ModelAndView mav = null;
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
}
