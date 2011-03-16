package com.hw.shop.util;

import java.util.ArrayList;
import java.util.List;



/**
 * 페이징 클래스
 * Class Name	:	PaginationInfo.java
 * Description	:	
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
public class PaginationInfo {
	private int currentPageNo=1; // 현재페이지
	private int recordCountPerPage = 10; // 페이지당보여질 레코드갯수
	private int pageSize = 10; // 페이지사이즈
	private int totalRecordCount; // 총레코드갯수
	private int totalPageCount; // 총페이지갯수
	private int firstPageNoOnPageList; // 첫페이지번호
	private int lastPageNoOnPageList;// 마지막페이지번호
	private int firstRecordIndex; // 첫레코드번호
	private int lastRecordIndex; // 마지막레코드번호
	private List list = new ArrayList();

	
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public PaginationInfo() {
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public int getTotalPageCount() {
		totalPageCount = (getTotalRecordCount() - 1) / getRecordCountPerPage()
				+ 1;
		return totalPageCount;
	}

	public int getFirstPageNo() {
		return 1;
	}

	public int getLastPageNo() {
		return getTotalPageCount();
	}

	public int getFirstPageNoOnPageList() {
		firstPageNoOnPageList = ((getCurrentPageNo() - 1) / getPageSize())
				* getPageSize() + 1;
		return firstPageNoOnPageList;
	}

	public int getLastPageNoOnPageList() {
		lastPageNoOnPageList = (getFirstPageNoOnPageList() + getPageSize()) - 1;
		if (lastPageNoOnPageList > getTotalPageCount())
			lastPageNoOnPageList = getTotalPageCount();
		return lastPageNoOnPageList;
	}

	public int getFirstRecordIndex() {
		firstRecordIndex = (getCurrentPageNo() - 1) * getRecordCountPerPage();
		return firstRecordIndex;
	}

	public int getLastRecordIndex() {
		lastRecordIndex = getCurrentPageNo() * getRecordCountPerPage();
		return lastRecordIndex;
	}

}
