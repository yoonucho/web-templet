package com.hw.shop.us.ma.vo;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public class USMAVo {
	/**  */ 
	@NotBlank  
    @Length(min=5,max = 12)  
	private String usr_id;

 	/**  */
	private String usr_pw;

 	/**  */ 
	private String name;

 	/**  */ 
	private String ssn1;
	
	private String usr_pw_chk;
	

 	/**  */ 
	private String ssn2;

 	/**  */ 
	private String zip1;

 	/**  */ 
	private String zip2;

 	/**  */ 
	private String addr1;

 	/**  */ 
	private String addr2;

 	/**  */ 
	private String tel1;

 	/**  */ 
	private String tel2;

 	/**  */ 
	private String tel3;

 	/**  */ 
	private String cell1;

 	/**  */ 
	private String cell2;

 	/**  */ 
	private String cell3;

 	/**  */ 
	private String email1;

 	/**  */ 
	private String email2;

 	/**  */ 
	private String mail_agree_yn;

 	/**  */ 
	private String area;

 	/**  */ 
	private String reg_dt;

 	/**  */ 
	private String reg_nm;

 	/**  */ 
	private String reg_id;

 	/**  */ 
	private String udt_id;

 	/**  */ 
	private String udt_nm;

 	/**  */ 
	private String udt_dt;
	private String email_txt;
	

	
 	public String getEmail_txt() {
		return email_txt;
	}
	public void setEmail_txt(String email_txt) {
		this.email_txt = email_txt;
	}
	public String getUsr_pw_chk() {
		return usr_pw_chk;
	}
	public void setUsr_pw_chk(String usr_pw_chk) {
		this.usr_pw_chk = usr_pw_chk;
	}
	public void setUsr_id(String usr_id) { 
		this.usr_id = usr_id;
	}
	/**  */ 
	public String getUsr_id() { 
		return usr_id;
	}

	public void setUsr_pw(String usr_pw) { 
		this.usr_pw = usr_pw;
	}
	/**  */ 
	public String getUsr_pw() { 
		return usr_pw;
	}

	public void setName(String name) { 
		this.name = name;
	}
	/**  */ 
	public String getName() { 
		return name;
	}

	public void setSsn1(String ssn1) { 
		this.ssn1 = ssn1;
	}
	/**  */ 
	public String getSsn1() { 
		return ssn1;
	}

	public void setSsn2(String ssn2) { 
		this.ssn2 = ssn2;
	}
	/**  */ 
	public String getSsn2() { 
		return ssn2;
	}

	public void setZip1(String zip1) { 
		this.zip1 = zip1;
	}
	/**  */ 
	public String getZip1() { 
		return zip1;
	}

	public void setZip2(String zip2) { 
		this.zip2 = zip2;
	}
	/**  */ 
	public String getZip2() { 
		return zip2;
	}

	public void setAddr1(String addr1) { 
		this.addr1 = addr1;
	}
	/**  */ 
	public String getAddr1() { 
		return addr1;
	}

	public void setAddr2(String addr2) { 
		this.addr2 = addr2;
	}
	/**  */ 
	public String getAddr2() { 
		return addr2;
	}

	public void setTel1(String tel1) { 
		this.tel1 = tel1;
	}
	/**  */ 
	public String getTel1() { 
		return tel1;
	}

	public void setTel2(String tel2) { 
		this.tel2 = tel2;
	}
	/**  */ 
	public String getTel2() { 
		return tel2;
	}

	public void setTel3(String tel3) { 
		this.tel3 = tel3;
	}
	/**  */ 
	public String getTel3() { 
		return tel3;
	}

	public void setCell1(String cell1) { 
		this.cell1 = cell1;
	}
	/**  */ 
	public String getCell1() { 
		return cell1;
	}

	public void setCell2(String cell2) { 
		this.cell2 = cell2;
	}
	/**  */ 
	public String getCell2() { 
		return cell2;
	}

	public void setCell3(String cell3) { 
		this.cell3 = cell3;
	}
	/**  */ 
	public String getCell3() { 
		return cell3;
	}

	public void setEmail1(String email1) { 
		this.email1 = email1;
	}
	/**  */ 
	public String getEmail1() { 
		return email1;
	}

	public void setEmail2(String email2) { 
		this.email2 = email2;
	}
	/**  */ 
	public String getEmail2() { 
		return email2;
	}

	public void setMail_agree_yn(String mail_agree_yn) { 
		this.mail_agree_yn = mail_agree_yn;
	}
	/**  */ 
	public String getMail_agree_yn() { 
		return mail_agree_yn;
	}

	public void setArea(String area) { 
		this.area = area;
	}
	/**  */ 
	public String getArea() { 
		return area;
	}

	public void setReg_dt(String reg_dt) { 
		this.reg_dt = reg_dt;
	}
	/**  */ 
	public String getReg_dt() { 
		return reg_dt;
	}

	public void setReg_nm(String reg_nm) { 
		this.reg_nm = reg_nm;
	}
	/**  */ 
	public String getReg_nm() { 
		return reg_nm;
	}

	public void setReg_id(String reg_id) { 
		this.reg_id = reg_id;
	}
	/**  */ 
	public String getReg_id() { 
		return reg_id;
	}

	public void setUdt_id(String udt_id) { 
		this.udt_id = udt_id;
	}
	/**  */ 
	public String getUdt_id() { 
		return udt_id;
	}

	public void setUdt_nm(String udt_nm) { 
		this.udt_nm = udt_nm;
	}
	/**  */ 
	public String getUdt_nm() { 
		return udt_nm;
	}

	public void setUdt_dt(String udt_dt) { 
		this.udt_dt = udt_dt;
	}
	/**  */ 
	public String getUdt_dt() { 
		return udt_dt;
	}
}
