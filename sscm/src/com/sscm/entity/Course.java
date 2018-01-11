package com.sscm.entity;

public class Course {
	private String cno ;
	private String cname;
	private int credit;
	private boolean type;
	private boolean state;
	private String introduction;
	public Course() {
	}
	public Course(String cno, String cname, int credit, boolean type,
			boolean state, String introduction) {
		this.cno = cno;
		this.cname = cname;
		this.credit = credit;
		this.type = type;
		this.state = state;
		this.introduction = introduction;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
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
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cname=" + cname + ", credit="
				+ credit + ", type=" + type + ", state=" + state
				+ ", introduction=" + introduction + "]";
	}
	
}
