package com.sscm.dao;

import java.util.List;

import com.sscm.entity.Notice;

public interface NoticeDao {
	public void add(Notice notice);
	public List<Notice> query();
	public List<Notice> query2(int start, int end);
	public int count();
	public void delete(int id);
}
