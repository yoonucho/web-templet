package com.hw.shop.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Globals;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

 
/*
 *************************************************************************
 * @source  : TvingUtil.java
 * @desc    : 공통 유틸 정의
 *----------------------------------------------------------
 * CJ제일제당 시스템
 * Copyright(c) 2010 CJ Systems,  All rights reserved.
 *----------------------------------------------------------
 * VER  DATE         AUTHOR      DESCRIPTION
 * ---  -----------  ----------  ------------------------------
 * 1.0  2011. 1. 18.       김형욱            최초 작성
 *************************************************************************
 */
public class SessionCookUtil {
	
	private HttpServletRequest req=null;
	private HttpServletResponse res=null;
	
	public SessionCookUtil(HttpServletRequest req, HttpServletResponse res){
		this.req = req;
		this.res = res;
	}
	
	/**
	 * 세션에서 사용자 정보 가져오기
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public Map getUserInfo() throws Exception {
		HashMap useInfo = (HashMap) req.getSession().getAttribute("userInfo");
		return useInfo;
	}
	
	/**
	 * 문자열의 숫자를 integer로 변환하여 준다 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public static int parseInt(String obj)

	{

		int ival=0;
		if (obj == null)return 0;

		else if(obj != null && obj.toString().equals(""))return 0;

		else {
			try {
				ival=Integer.parseInt(obj.toString());
			}
			catch (NumberFormatException e) {
				ival=0;
			}
		}
			
		return ival;	

	}
	
	/**
	 * 오늘 날짜를 알려 준다.
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public String getToDay() {
		Calendar calendar= Calendar.getInstance ( );
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMdd");
		String sToday=""+dataFormat.format(calendar.getTime());
		return sToday;
	}
	
	/**
	 * 세션 사용자 정보 설정하기
	 * @param req
	 * @param userInfo
	 * @throws Exception
	 */
	public void setUserInfo(Map userInfo) throws Exception {
		req.getSession().setAttribute("userInfo", userInfo);
	}
	
	/**
	 * 세션 삭제
	 * @param req
	 * @throws Exception
	 */
	public void invalidate() throws Exception {
		req.getSession().invalidate();
	}
	
	private Map cookieMap = new java.util.HashMap();
	

	// 쿠키를 클래스(모듈화)시켜 관리하기 위한 클래스...
	public void CookieBox() { // 웹에서 서버로 요청하면..
		
		Cookie[] cookies = req.getCookies(); // 쿠키값을 배열에 저장..
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
				// 맵에 쿠키의 이름값(찾을 속성값(키값))으로.. 쿠키값을 저장..
			}
		}
	}

	// 여러가지 형태의 쿠키생성 함수오버로딩 구현..
	public Cookie createCookie(String name, String value) // 이름과 값으로 쿠키를
															// 만드는 함수..
			throws IOException {

		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));

		cookie.setMaxAge(60 * 60 * 24 * 15); // c.setMacAge(초 단위으 쿠키 유효시간 값);
		cookie.setPath("/"); // 쿠키가 유효한 디렉토리 정보 설정 cookie.setPath("유효 디렉토리");,
								// "/"일경우 해당 도메인에 모든 페이지에서 유효

		res.addCookie(cookie);
		return cookie; // 값을 한글형태로
						// 인코딩시켜서
						// 쿠키생성
	}

	public Cookie createCookie(String name, String value, String path,
			int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}

	public Cookie createCookie(String name, String value, String domain,
			String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public void deleteCookie(String name) {
		Cookie killCookie = new Cookie(name, "0");
		killCookie.setMaxAge(0);
		res.addCookie(killCookie);
	}

	public Cookie getCookie(String name) { // 해당(name)쿠키값을 리턴..
		return (Cookie) cookieMap.get(name);

		// 맵의 키값으로 설정해둔 name값을 찾아서 cookie객체로 변환해서 반환..
	}

	public String getValue(String name) throws IOException {
		Cookie cookie = (Cookie) cookieMap.get(name);
		if (cookie == null)
			return null;
		return URLDecoder.decode(cookie.getValue(), "UTF-8");
	}

	public boolean exists(String name) { // 해당(name)쿠키가 존재하는지 여부를 boolean값으로
											// 리턴..
		return cookieMap.get(name) != null;
	}

}
