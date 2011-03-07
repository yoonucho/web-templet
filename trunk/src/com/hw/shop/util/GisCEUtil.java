package com.hw.shop.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Class Name	:	GisCEUtil.java
 * Description	:	공통 유틸 설정	
 * Modification Information 
 * 
 * 		수  정  일			수정자		수정내용
 * 	  --------------   --------    ---------------------------------------------
 * 		2010. 8. 3.	김형욱		최초생성
 * 
 * 
 * @author		:	김형욱
 * @since		:	2010. 8. 3.
 * @version		:	1.0
 */
public class GisCEUtil {

	/**
	 * 파일 맵을 가져오는 유틸
	 * @param request
	 * @param response
	 * @param FILE_PATH
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public HashMap getFileMap(HttpServletRequest request,
			HttpServletResponse response, String FILE_PATH) throws IllegalStateException, IOException {


		response.setContentType("text/plain");
		if (!(request instanceof MultipartHttpServletRequest)) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST,
					"Expected multipart request");

			return null;
		}

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map fileMap = multipartRequest.getFileMap();

		Date time = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String formatDate = formatter.format(time);

		HashMap mapFiles = new HashMap();
		
		int fileCnt = 1;
		
		for(int i=1; i<= fileMap.size();i++){
			CommonsMultipartFile file =  (CommonsMultipartFile) fileMap.get("file"+i);
			if(file.getSize()!=0){
				File newFile = new File(FILE_PATH + ConstConfig.getDIR_SEPARATOR() +  formatDate + "_"+fileCnt);
				file.transferTo(newFile);
				
				HashMap newMapFile = new HashMap();
				
				newMapFile.put("save_file_name", file.getFileItem().getName().substring(file.getFileItem().getName().lastIndexOf(ConstConfig.getDIR_SEPARATOR()) + 1));
				newMapFile.put("real_file_name", formatDate + "_"+fileCnt);
				
				mapFiles.put("file"+fileCnt, newMapFile);
				fileCnt++;
			}
		}
		
		return mapFiles;
	}
}
