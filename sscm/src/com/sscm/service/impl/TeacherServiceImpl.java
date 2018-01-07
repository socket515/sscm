package com.sscm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sscm.dao.TeacherDao;
import com.sscm.entity.Teacher;
import com.sscm.service.TeacherService;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	
	@Resource
	private TeacherDao teacherDao;

	@Override
	public Teacher login(String username, String password) {
		return teacherDao.loginTeacher(username, password);
	}

	@Override
	public int getNum() {
		return teacherDao.getNum();
	}

	@Override
	public int getNumByArgs(String tname, String tdept, String sdate,
			String edate) {
		return teacherDao.getNumByArgs(tname, tdept, sdate, edate);
	}

	@Override
	public List<Teacher> getAll(int start, int end) {
		return teacherDao.getAll(start, end);
	}

	@Override
	public List<Teacher> getByNo(String tno) {
		return teacherDao.getByNo(tno);
	}

	@Override
	public List<Teacher> getByArg(int start, int end, String tname,
			String tdept, String sdate, String edate) {
		return teacherDao.getByArg(start, end, tname, tdept, sdate, edate);
	}

}
