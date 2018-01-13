package com.sscm.entity;

public class Notice {
	private int id;
	private String dt;
	private String creator;
	private String content;
	public Notice() {

	}
	public Notice(int id,String dt, String creator, String content) {
		this.id = id;
		this.dt = dt;
		this.creator = creator;
		this.content = content;
	}
	public Notice(String dt, String creator, String content) {
		this.dt = dt;
		this.creator = creator;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", dt=" + dt + ", creator=" + creator
				+ ", content=" + content + "]";
	}
	
	

}
