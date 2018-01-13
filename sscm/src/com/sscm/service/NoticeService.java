package com.sscm.service;

import java.util.List;

import com.sscm.entity.Notice;

public interface NoticeService {
	public void add(String creator, String content);
	public List<Notice> query();
	public List<Notice> query2(int start, int end);
	public int count();
	public void delete(int id);
}
