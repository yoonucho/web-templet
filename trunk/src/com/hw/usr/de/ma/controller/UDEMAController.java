package com.hw.usr.de.ma.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.de.ma.service.DEMAService;
import com.hw.shop.de.ma.vo.DELIREQVo;
import com.hw.shop.de.ma.vo.DEMAVo;

@Controller
@SessionAttributes("userInfo")
@RequestMapping("/usr/de/ma/*")
public class UDEMAController {

	@Autowired
	private DEMAService service;

	Logger log = Logger.getLogger(getClass());
	
	/**
	 * 상품 보여주고 결제페이지 호출 전 화면
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView DEMA050Q(DELIREQVo vo) {
		
		ModelAndView mav = new ModelAndView();
		String dd[] = {"",""};
		
		List prdSeq = new ArrayList();
		for(int i=0; i< vo.getPrd_seq_no().length;i++){
			Map map = new HashMap();
			map.put("prd_seq_no", vo.getPrd_seq_no()[i]);
			map.put("del_cnt", vo.getDel_cnt()[i]);
			prdSeq.add(map);
//			prdSeq.add( vo.getPrd_seq_no()[i]);
		}
		vo.setPrd_seq_no_list(prdSeq);
		
		List list = service.DEMA050Q(vo);
		mav.addObject("list", list);
		return mav;
		
	}
	
	/**
	 * 한곳으로 배송 결제
	 * @param vo
	 * @return
	 */
	
	@RequestMapping
	public ModelAndView DEMA050T(@ModelAttribute("userInfo")Map userInfo,DEMAVo vo) {
		log.debug(userInfo);
		ModelAndView mav = new ModelAndView("redirect:/de/ma/DEMA030Q.do");
		vo.setReg_id((String)userInfo.get("usr_id"));
		vo.setReg_nm((String)userInfo.get("name"));
		vo.setUsr_id((String)userInfo.get("usr_id"));
		service.DEMA050T(vo);
		
		return mav;
		
	}
}
