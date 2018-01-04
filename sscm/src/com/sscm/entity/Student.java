package com.sscm.entity;

public class Student {
	private String sno;
	private String sname;
	private String password;
	private boolean ssex;
	private int sage;
	private String sdept;
	public Student() {
	
	}
	public Student(String sno, String sname, String password, boolean ssex,
			int sage, String sdept) {
		this.sno = sno;
		this.sname = sname;
		this.password = password;
		this.ssex = ssex;
		this.sage = sage;
		this.sdept = sdept;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSsex() {
		return ssex;
	}
	public void setSsex(boolean ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", password="
				+ password + ", ssex=" + ssex + ", sage=" + sage + ", sdept="
				+ sdept + "]";
	}
	
	
}