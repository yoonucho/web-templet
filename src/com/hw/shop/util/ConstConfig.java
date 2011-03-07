package com.hw.shop.util;

/**
 * Class Name	:	ConstConfig.java
 * Description	:	was 환경정보를 담고 있는 Const 파일
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
public class ConstConfig {
	
	
	private static String WAS_REAL_PATH;
	private static String BOARD_PATH;
	private static String DIR_SEPARATOR;
	public static String USER_ID ="chejug";
	

	public static String getDIR_SEPARATOR() {
		return DIR_SEPARATOR;
	}

	protected static void setDIR_SEPARATOR(String dIRSEPARATOR) {
		DIR_SEPARATOR = dIRSEPARATOR;
	}

	public static String getBOARD_PATH() {
		return BOARD_PATH;
	}

	protected static void setBOARD_PATH(String bOARDPATH) {
		BOARD_PATH = bOARDPATH;
	}

	public static String getWAS_REAL_PATH() {
		return WAS_REAL_PATH;
	}

	protected static void setWAS_REAL_PATH(String wASREALPATH) {
		WAS_REAL_PATH = wASREALPATH;
	}
	
	
}
