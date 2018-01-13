package com.sscm.service.impl;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sscm.dao.NoticeDao;
import com.sscm.entity.Notice;
import com.sscm.service.NoticeService;
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Resource
	private NoticeDao noticeDao;
	
	private  SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ); 
	@Override
	public void add(String creator, String content) {
		String dt = sdf.format(new Date());
		noticeDao.add(new Notice(dt, creator, content));
	}

	@Override
	public List<Notice> query() {
		return noticeDao.query();
	}

	@Override
	public List<Notice> query2(int start, int end) {
		return noticeDao.query2(start, end);
	}

	@Override
	public int count() {
		return noticeDao.count();
	}

	@Override
	public void delete(int id) {
		noticeDao.delete(id);
	}

}
