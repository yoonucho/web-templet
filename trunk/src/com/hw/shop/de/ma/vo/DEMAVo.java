package com.hw.shop.de.ma.vo;

public class DEMAVo {
	/** 배송고유번호 */ 
	private long del_seq_no;
	
	private long[] del_seq_nos;

	private long[] del_cnts;
	
	//deli_product 변수
	private long del_p_seq_no;
	private long prd_seq_no;
	private long del_cnt;

	private long[] prd_seq_nos;
	
 	/** 배송일자 */ 
	private String reg_dt;

 	/** 사용자 */ 
	private String usr_id;

 	/** 주소1 */ 
	private String addr1;

 	/** 주소2 */ 
	private String addr2;

 	/** 우편번호1 */ 
	private String zip1;

 	/** 우편번호2 */ 
	private String zip2;

 	/** 전화1 */ 
	private String tel1;

 	/** 전화2 */ 
	private String tel2;

 	/** 전화3 */ 
	private String tel3;

 	/** 휴대폰1 */ 
	private String cell1;

 	/** 휴대폰2 */ 
	private String cell2;

 	/** 휴대폰3 */ 
	private String cell3;

 	/** 배송메세지 */ 
	private String del_msg;

 	/** 배송비 */ 
	private long del_pee;

 	/** 가격 */ 
	private long del_pay;

 	/** 상태 */ 
	private String status;

 	/** 받는사람 */ 
	private String to_usr;

 	/** 보낸사람 */ 
	private String from_usr;

 	/** 등록자아이디 */ 
	private String reg_id;

 	/** 등록자 */ 
	private String reg_nm;

 	/** 수정자아이디 */ 
	private String udt_id;

 	/** 수정자명 */ 
	private String udt_nm;

 	/** 수정일 */ 
	private String udt_dt;

	
	
	
 	public long[] getPrd_seq_nos() {
		return prd_seq_nos;
	}
	public void setPrd_seq_nos(long[] prd_seq_nos) {
		this.prd_seq_nos = prd_seq_nos;
	}
	public long getDel_p_seq_no() {
		return del_p_seq_no;
	}
	public void setDel_p_seq_no(long del_p_seq_no) {
		this.del_p_seq_no = del_p_seq_no;
	}
	public long getPrd_seq_no() {
		return prd_seq_no;
	}
	public void setPrd_seq_no(long prd_seq_no) {
		this.prd_seq_no = prd_seq_no;
	}
	public long getDel_cnt() {
		return del_cnt;
	}
	public void setDel_cnt(long del_cnt) {
		this.del_cnt = del_cnt;
	}
	public long[] getDel_seq_nos() {
		return del_seq_nos;
	}
	public void setDel_seq_nos(long[] del_seq_nos) {
		this.del_seq_nos = del_seq_nos;
	}
	public long[] getDel_cnts() {
		return del_cnts;
	}
	public void setDel_cnts(long[] del_cnts) {
		this.del_cnts = del_cnts;
	}
	public void setDel_seq_no(long del_seq_no) { 
		this.del_seq_no = del_seq_no;
	}
	/** 배송고유번호 */ 
	public long getDel_seq_no() { 
		return del_seq_no;
	}

	public void setReg_dt(String reg_dt) { 
		this.reg_dt = reg_dt;
	}
	/** 배송일자 */ 
	public String getReg_dt() { 
		return reg_dt;
	}

	public void setUsr_id(String usr_id) { 
		this.usr_id = usr_id;
	}
	/** 사용자 */ 
	public String getUsr_id() { 
		return usr_id;
	}

	public void setAddr1(String addr1) { 
		this.addr1 = addr1;
	}
	/** 주소1 */ 
	public String getAddr1() { 
		return addr1;
	}

	public void setAddr2(String addr2) { 
		this.addr2 = addr2;
	}
	/** 주소2 */ 
	public String getAddr2() { 
		return addr2;
	}

	public void setZip1(String zip1) { 
		this.zip1 = zip1;
	}
	/** 우편번호1 */ 
	public String getZip1() { 
		return zip1;
	}

	public void setZip2(String zip2) { 
		this.zip2 = zip2;
	}
	/** 우편번호2 */ 
	public String getZip2() { 
		return zip2;
	}

	public void setTel1(String tel1) { 
		this.tel1 = tel1;
	}
	/** 전화1 */ 
	public String getTel1() { 
		return tel1;
	}

	public void setTel2(String tel2) { 
		this.tel2 = tel2;
	}
	/** 전화2 */ 
	public String getTel2() { 
		return tel2;
	}

	public void setTel3(String tel3) { 
		this.tel3 = tel3;
	}
	/** 전화3 */ 
	public String getTel3() { 
		return tel3;
	}

	public void setCell1(String cell1) { 
		this.cell1 = cell1;
	}
	/** 휴대폰1 */ 
	public String getCell1() { 
		return cell1;
	}

	public void setCell2(String cell2) { 
		this.cell2 = cell2;
	}
	/** 휴대폰2 */ 
	public String getCell2() { 
		return cell2;
	}

	public void setCell3(String cell3) { 
		this.cell3 = cell3;
	}
	/** 휴대폰3 */ 
	public String getCell3() { 
		return cell3;
	}

	public void setDel_msg(String del_msg) { 
		this.del_msg = del_msg;
	}
	/** 배송메세지 */ 
	public String getDel_msg() { 
		return del_msg;
	}

	public void setDel_pee(long del_pee) { 
		this.del_pee = del_pee;
	}
	/** 배송비 */ 
	public long getDel_pee() { 
		return del_pee;
	}

	public void setDel_pay(long del_pay) { 
		this.del_pay = del_pay;
	}
	/** 가격 */ 
	public long getDel_pay() { 
		return del_pay;
	}

	public void setStatus(String status) { 
		this.status = status;
	}
	/** 상태 */ 
	public String getStatus() { 
		return status;
	}

	public void setTo_usr(String to_usr) { 
		this.to_usr = to_usr;
	}
	/** 받는사람 */ 
	public String getTo_usr() { 
		return to_usr;
	}

	public void setFrom_usr(String from_usr) { 
		this.from_usr = from_usr;
	}
	/** 보낸사람 */ 
	public String getFrom_usr() { 
		return from_usr;
	}

	public void setReg_id(String reg_id) { 
		this.reg_id = reg_id;
	}
	/** 등록자아이디 */ 
	public String getReg_id() { 
		return reg_id;
	}

	public void setReg_nm(String reg_nm) { 
		this.reg_nm = reg_nm;
	}
	/** 등록자 */ 
	public String getReg_nm() { 
		return reg_nm;
	}

	public void setUdt_id(String udt_id) { 
		this.udt_id = udt_id;
	}
	/** 수정자아이디 */ 
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
