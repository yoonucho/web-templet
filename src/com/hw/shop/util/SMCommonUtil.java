package com.hw.shop.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/*
 *************************************************************************
 * @source  : SMCommonUtil.java
 * @desc    : 사이트관리 공통 유틸
 *----------------------------------------------------------
 * CJ제일제당 시스템
 * Copyright(c) 2010 CJ Systems,  All rights reserved.
 *----------------------------------------------------------
 * VER  DATE         AUTHOR      DESCRIPTION
 * ---  -----------  ----------  ------------------------------
 * 1.0  2010. 12. 16.       김형욱            최초 작성
 *************************************************************************
 */
public class SMCommonUtil {

	
	/**
	 * 파일 업로드 된 자료를 map으로 리턴
	 * 
	 * @param map
	 * @param filePath
	 * @param upMooPath
	 * @param rename	-이미지 파일 이외의 파일을 올릴때 다름이름으로 변경해서 저장하는 옵션
	 * @return			-저장된 파일과 실제 파일명을 리턴
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public Map<String, String> getFileInfo(MultiValueMap map,String filePath, String upMooPath, boolean rename,String[] files) throws IllegalStateException, IOException{

		String urlFilePath = upMooPath.replaceAll("\\\\", "/");
		
		
		Date time = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = formatter.format(time);
		
		Map returnMap = new HashMap();
		
//		Iterator<String> iterator = map.keySet().iterator();
		
		for(int i=0; i< files.length ; i++){
//			String key = iterator.next();
			LinkedList df = (LinkedList) map.get(files[i]);
			CommonsMultipartFile fileInfo = (CommonsMultipartFile) df.getFirst();
			
			if(fileInfo.getSize()>0){
				int idx = fileInfo.getOriginalFilename().lastIndexOf(".");
				
				String extName = "";
				if( idx != -1 ) { 
					extName = fileInfo.getOriginalFilename().substring( idx, fileInfo.getOriginalFilename().length() ); 
				} 
				File fDir = new File(filePath+upMooPath);
				if(!fDir.exists()){
					fDir.mkdirs();
				}
				if(rename){
					File file1 = new File(filePath+upMooPath+formatDate);
					fileInfo.transferTo(file1);
					
					returnMap.put(files[i], urlFilePath+formatDate);
					returnMap.put(files[i]+"_nm", fileInfo.getOriginalFilename());
					
				}else{
					File file1 = new File(filePath+upMooPath+formatDate+fileInfo.getName()+extName);
					fileInfo.transferTo(file1);
					returnMap.put(files[i], urlFilePath+formatDate+fileInfo.getName()+extName);
					returnMap.put(files[i]+"_nm", fileInfo.getOriginalFilename());
				}
			}
		}
		
//		while(iterator.hasNext()){
//			
//			String key = iterator.next();
//			LinkedList df = (LinkedList) map.get(key);
//			CommonsMultipartFile fileInfo = (CommonsMultipartFile) df.getFirst();
//			
//			if(fileInfo.getSize()>0){
//				int idx = fileInfo.getOriginalFilename().lastIndexOf(".");
//				
//				String extName = "";
//				if( idx != -1 ) { 
//					extName = fileInfo.getOriginalFilename().substring( idx, fileInfo.getOriginalFilename().length() ); 
//				} 
////				File fDir = new File(filePath+upMooPath);
//				File fDir = new File(upMooPath);
//				if(!fDir.exists()){
//					fDir.mkdirs();
//				}
//				if(rename){
//					File file1 = new File(upMooPath+formatDate);
////					File file1 = new File(filePath+upMooPath+formatDate);
//					fileInfo.transferTo(file1);
//					
//					returnMap.put(key, urlFilePath.replaceAll("/upload/upload/","/upload/")+formatDate);
//					returnMap.put(key+"_nm", fileInfo.getOriginalFilename());
//					
//				}else{
////					File file1 = new File(filePath+upMooPath+formatDate+fileInfo.getName()+extName);
//					File file1 = new File(upMooPath+formatDate+fileInfo.getName()+extName);
//					fileInfo.transferTo(file1);
//					returnMap.put(key, urlFilePath.replaceAll("/upload/upload/","/upload/")+formatDate+fileInfo.getName()+extName);
//					returnMap.put(key+"_nm", fileInfo.getOriginalFilename());
//				}
//			}
//		}
		
		
		return returnMap;
	}
	/**
	 * 파일 업로드 된 자료를 map으로 리턴
	 * 보안 파일명 등록 기능 추가 되어야함.. 
	 * @param map
	 * @param filePath
	 * @param upMooPath
	 * @return			-저장된 파일명 리턴
	 * @throws IllegalStateException
	 * @throws IOException
	 */
//	public Map<String, String> getFileInfo(MultiValueMap map,String filePath, String upMooPath) throws IllegalStateException, IOException{
//		return getFileInfo(map,filePath,upMooPath,false);
//	}

	/**
	 * hashMap key를 소문자로 변환
	 * @param origin
	 * @return
	 */
	public HashMap toLowerKeyHash(Map origin) {
		HashMap returnMap = new HashMap();

		if(origin==null) return  returnMap;
		Set set = origin.keySet();
		Object[] keys = set.toArray();

		for (int j = 0; j < keys.length; j++) {
			returnMap.put(keys[j].toString().toLowerCase(), origin.get(keys[j]));
		}

		return returnMap;
	}

	/**
	 * map의 value을 bean에 넣어주는 메소드
	 * @param properties
	 * @param bean
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public void mapToBean(java.util.Map properties, java.lang.Object bean)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		if (properties == null) {
			return;
		}
		
		BeanUtils.populate(bean, toLowerKeyHash(properties));
	}

	/**
	 * bean의 value을 map에 넣어주는 메소드
	 * @param bean
	 * @param properties
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public void beanToMap(java.lang.Object bean, java.util.Map properties)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Map map = PropertyUtils.describe(bean);
		map.remove("class");
		properties.putAll(map);
	}

	

	/**
	 * 문자열의 숫자를 integer로 변환하여 준다 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public int parseInt(String obj)

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
	
	public String getToDaytTime() {
		Calendar calendar= Calendar.getInstance ( );
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String sToday=""+dataFormat.format(calendar.getTime());
		return sToday;
	}
	public String NVL(Object obj)
	{
		String result = null;
		
		if(obj == null)
		{
			result = "";
		}
		else if(obj instanceof String)
		{
			if(((String)obj).trim().equals(""))
			{
				result = "";
			}
			else
			{
				result = obj.toString();
			}
		}
		else
		{
			result = ""+obj;
		}
		
		return result;
	}
  
	public String NVL(Object obj, String str)
	{
		String result = null;
		
		if(obj == null)
		{
			result = str;
		}
		else if(obj instanceof String)
		{
			if(((String)obj).trim().equals(""))
			{
				result = str;
			}
			else
			{
				result = obj.toString();
			}
		}
		else
		{
			result = ""+obj;
		}
		
		return result;
	}
	
	

	/**
	 * getDateFormat
	* 날자를 입력한 포맷형식으로 변환한다.
	* <br>예) getDataFormat("20021026", "####.##.##") => return "2002.10.26"
	* <br>예) getDataFormat("20021026", "####-##-##") => return "2002-10-26"
	* @param str_value  날짜
	* @param str_format  형식
	* @return 변환된 날자
	*/

	public  String getDateFormat(String str_value, String str_format)

	{

		if (str_value.length() <= 0 ) return str_value;



		String sign = "";

		if (str_value.substring(0,1).equals("-") || str_value.substring(0,1).equals("+")) {

		  sign      = str_value.substring(0,1);

		  str_value = str_value.substring(1);

		}

		

		str_value = str_value.replaceAll("-", "");

		StringBuffer buf = new StringBuffer(str_value);



		char[] format_char = str_format.toCharArray();

		for (int i = 0; i < format_char.length; i++) {



		  if (format_char[i] == '#')

			continue;

		  else {

			try {

			  if(i < buf.length() -1)

				buf.insert(i, format_char[i]);

			} catch(Exception e) {}

		  }

		}



	  String ret = buf.toString();



	  return sign + ret.substring(0, java.lang.Math.min(str_format.length(), ret.length()));

	}
	
}
