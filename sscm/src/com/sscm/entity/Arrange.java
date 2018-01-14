package com.sscm.entity;

public class Arrange {
	private String cno;
	private String tno;
	private String cname;
	private String tname;
	private int credit;
	private boolean type;
	private int id;
	private int anum;
	private int maxnum;
	private int atime;
	private int address;
	private String sd;
	public Arrange() {
		
	}
	public Arrange(String cno, String tno, int anum, int maxnum, int atime,
			int address, String sd) {
		super();
		this.cno = cno;
		this.tno = tno;
		this.anum = anum;
		this.maxnum = maxnum;
		this.atime = atime;
		this.address = address;
		this.sd = sd;
	}
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public int getMaxnum() {
		return maxnum;
	}
	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}
	public int getAtime() {
		return atime;
	}
	public void setAtime(int atime) {
		this.atime = atime;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Arrange [cno=" + cno + ", tno=" + tno + ", anum=" + anum
				+ ", maxnum=" + maxnum + ", atime=" + atime + ", address="
				+ address + ", sd=" + sd + "]";
	}
	

}
