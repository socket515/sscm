package com.sscm.dao;

import com.sscm.entity.Student;

public interface StudentDao {
	public Student loginStudent(String username,String password);
}
