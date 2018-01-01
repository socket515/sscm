package com.sscm.service.impl;

import com.sscm.dao.StudentDao;
import com.sscm.entity.Student;
import com.sscm.service.StudentService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentDao studentDao;
	
	@Override
	public Student login(String username, String password) {
		return studentDao.loginStudent(username, password);
	}

}
