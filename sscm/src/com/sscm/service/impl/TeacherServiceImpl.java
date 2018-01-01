package com.sscm.service.impl;

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

}
