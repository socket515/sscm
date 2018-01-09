package com.sscm.entity;

public class Course {
	private String cno ;
	private String cnamae;
	private int credit;
	private boolean type;
	private boolean state;
	private String introduction;
	public Course() {
	}
	public Course(String cno, String cnamae, int credit, boolean type,
			boolean state, String introduction) {
		this.cno = cno;
		this.cnamae = cnamae;
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
	public String getCnamae() {
		return cnamae;
	}
	public void setCnamae(String cnamae) {
		this.cnamae = cnamae;
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
		return "Course [cno=" + cno + ", cnamae=" + cnamae + ", credit="
				+ credit + ", type=" + type + ", state=" + state
				+ ", introduction=" + introduction + "]";
	}
	
}
