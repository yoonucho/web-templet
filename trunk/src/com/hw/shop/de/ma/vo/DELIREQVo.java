package com.hw.shop.de.ma.vo;

import java.util.List;

public class DELIREQVo {
	/** 배송상품고유번호 */ 
	private long del_p_seq_no;

 	/** 제품고유번호 */ 
	private long prd_seq_no[];

 	/** 제품수량 */ 
	private long del_cnt[];

	private List prd_seq_no_list;
	
	
 	public List getPrd_seq_no_list() {
		return prd_seq_no_list;
	}
	public void setPrd_seq_no_list(List prd_seq_no_list) {
		this.prd_seq_no_list = prd_seq_no_list;
	}
	public long[] getPrd_seq_no() {
		return prd_seq_no;
	}
	public void setPrd_seq_no(long[] prd_seq_no) {
		this.prd_seq_no = prd_seq_no;
	}
	public long[] getDel_cnt() {
		return del_cnt;
	}
	public void setDel_cnt(long[] del_cnt) {
		this.del_cnt = del_cnt;
	}
	/** 배송상품고유번호 설정 */ 
	public void setDel_p_seq_no(long del_p_seq_no) { 
		this.del_p_seq_no = del_p_seq_no;
	}
	/** 배송상품고유번호 가져오기 */ 
	public long getDel_p_seq_no() { 
		return del_p_seq_no;
	}


}
