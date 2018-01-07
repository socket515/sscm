package com.sscm.entity;

public class Teacher {
	private String tno;
	private String tname;
	private String tpass;
	private String tdept;
	private String dt;
	private String tcomment;
	public Teacher() {
		
	}
	public Teacher(String tno, String tname, String tpass, String tdept,
			String dt,String tcomment) {
		this.tno = tno;
		this.tname = tname;
		this.tpass = tpass;
		this.tdept = tdept;
		this.dt = dt;
		this.tcomment = tcomment;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTpass() {
		return tpass;
	}
	public void setTpass(String tpass) {
		this.tpass = tpass;
	}
	public String getTdept() {
		return tdept;
	}
	public void setTdept(String tdept) {
		this.tdept = tdept;
	}
	public String getTcomment() {
		return tcomment;
	}
	public void setTcomment(String tcomment) {
		this.tcomment = tcomment;
	}
	
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", tpass=" + tpass
				+ ", tdept=" + tdept + ", dt=" + dt + ", tcomment=" + tcomment
				+ "]";
	}
	
	
	
	
}
