package com.hw.shop.util;



import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Class Name	:	InitConfig.java
 * Description	:	servlet 올라올때 초기화 설정파일
 * Modification Information 
 * 
 * 		수  정  일			수정자		수정내용
 * 	  --------------   --------    ---------------------------------------------
 * 		2010. 7. 15.	김형욱		최초생성
 * 
 * 
 * @author		:	김형욱
 * @since		:	2010. 7. 15.
 * @version		:	1.0
 */
public class InitConfig extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * 초기화 설정
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() {


		if(System.getProperty("os.name").toUpperCase().indexOf("WINDOW")>-1){
			ConstConfig.setDIR_SEPARATOR("\\");
		}else{
			ConstConfig.setDIR_SEPARATOR("/");
		}
		
		// 파일 실경로 설정
		ConstConfig.setWAS_REAL_PATH(this.getServletContext().getRealPath(""));
		// Board파일 저장공간 설정
		File dir = new File(ConstConfig.getWAS_REAL_PATH() + ConstConfig.getDIR_SEPARATOR()+ "board_files");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		ConstConfig.setBOARD_PATH(ConstConfig.getWAS_REAL_PATH() + ConstConfig.getDIR_SEPARATOR() +"board_files");
		
		try {
			super.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
