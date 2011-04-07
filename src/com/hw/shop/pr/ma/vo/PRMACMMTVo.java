package com.hw.shop.pr.ma.vo;

import com.hw.shop.util.PaginationInfo;

public class PRMACMMTVo extends PaginationInfo {
	/** 상품고유번호 */ 
	private long prd_seq_no;

 	/** 고유번호 */ 
	private long seq_no;

 	/** 내용 */ 
	private String content;

 	/** 등록일 */ 
	private String reg_dt;

 	/** 등록자 */ 
	private String reg_nm;

 	/** 등록자ID */ 
	private String reg_id;

 	/** 수정자ID */ 
	private String udt_id;

 	/** 수정자명 */ 
	private String udt_nm;

 	/** 수정일 */ 
	private String udt_dt;

 	public void setPrd_seq_no(long prd_seq_no) { 
		this.prd_seq_no = prd_seq_no;
	}
	/** 상품고유번호 */ 
	public long getPrd_seq_no() { 
		return prd_seq_no;
	}

	public void setSeq_no(long seq_no) { 
		this.seq_no = seq_no;
	}
	/** 고유번호 */ 
	public long getSeq_no() { 
		return seq_no;
	}

	public void setContent(String content) { 
		this.content = content;
	}
	/** 내용 */ 
	public String getContent() { 
		return content;
	}

	public void setReg_dt(String reg_dt) { 
		this.reg_dt = reg_dt;
	}
	/** 등록일 */ 
	public String getReg_dt() { 
		return reg_dt;
	}

	public void setReg_nm(String reg_nm) { 
		this.reg_nm = reg_nm;
	}
	/** 등록자 */ 
	public String getReg_nm() { 
		return reg_nm;
	}

	public void setReg_id(String reg_id) { 
		this.reg_id = reg_id;
	}
	/** 등록자ID */ 
	public String getReg_id() { 
		return reg_id;
	}

	public void setUdt_id(String udt_id) { 
		this.udt_id = udt_id;
	}
	/** 수정자ID */ 
	public String getUdt_id() { 
		return udt_id;
	}

	public void setUdt_nm(String udt_nm) { 
		this.udt_nm = udt_nm;
	}
	/** 수정자명 */ 
	public String getUdt_nm() { 
		return udt_nm;
	}

	public void setUdt_dt(String udt_dt) { 
		this.udt_dt = udt_dt;
	}
	/** 수정일 */ 
	public String getUdt_dt() { 
		return udt_dt;
	}
}
