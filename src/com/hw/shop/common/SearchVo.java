package com.hw.shop.common;

import com.hw.shop.util.PaginationInfo;

public class SearchVo extends PaginationInfo {
	//제목검색
	private String src_title;
	
	//우편번호 검색
	private String dong;
	

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getSrc_title() {
		return src_title;
	}

	public void setSrc_title(String src_title) {
		this.src_title = src_title;
	}
	
	
}
