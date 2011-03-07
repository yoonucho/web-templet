package com.hw.shop.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	public DownloadView() {
		setContentType("application/octet-stream");
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map model, HttpServletRequest arg1,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		HashMap fileMap = (HashMap) model.get("fileMap");
		File file = (File) fileMap.get("downloadFile");

		//파일 없으면
		if(!file.exists()){
			throw new IOException("파일이 없습니다.");
		}
		
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());

		String sFileNM = (String) fileMap.get("fileName");

		String filename2 = new String(sFileNM.getBytes("euc-kr"), "8859_1");

		response.setHeader("Content-Disposition", "attachment; fileName=\""
				+ filename2 + "\";");

		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = response.getOutputStream();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
		}
		out.flush();
		out.close();
	}
}
