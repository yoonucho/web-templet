package com.hw.shop.bd.ma.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hw.shop.bd.ma.service.BDMAService;

@Controller
@RequestMapping("/bd/ma/*")
public class BDMAController {

	@Autowired
	private BDMAService bdmaSvc;
	
	/**
	 * 게피판 목록
	 * @param vo
	 * @return
	 */
	@RequestMapping
	public ModelAndView BDMA010Q(Map vo) {

		ModelAndView mav = new ModelAndView();

		System.out.println(bdmaSvc.BDMA010Q_CNT(vo));
		
		int c = 0;//jdbcTemplate.queryForInt(sbQry.toString());
		System.out.println(c);
		mav.addObject("CNT", c);

		return mav;
	}
}
