package com.hw.shop.brd.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/brd/*")
public class brdController {

	// jdbc 설정
	@Resource(name = "jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@RequestMapping
	public ModelAndView LIST010Q(Map vo) {

		ModelAndView mav = new ModelAndView();
		
		StringBuffer sbQry = new StringBuffer("select 1 as cnt ");
		
		int c = jdbcTemplate.queryForInt(sbQry.toString());
		System.out.println(c);
		mav.addObject("CNT",c);
		
		return mav; 
	}
}
