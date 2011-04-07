package com.hw.shop.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ShopInterceptor extends HandlerInterceptorAdapter {

	Logger log = Logger.getLogger(getClass());

	/*
	 * Controller 실행 전에 전처리를 싱행 한다.<br>
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse res, Object handler) throws Exception {

		// Cache 설정
//		response.setHeader("Pragma", "no-cache");
//		response.setHeader("Cache-Control", "no-store,must-revalidate");
//		response.setDateHeader("Expires", 0);
//		
		req.setAttribute("_uri", req.getRequestURI()); // 로그인 유무 (true/false)
		

		return super.preHandle(req, res, handler);
	}

	/*
	 * Controller 실행 후에 후처리를 실행 한다.<br>
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#postHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);

	}
}
