package com.sscm.service.impl;

import java.util.List;

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

	@Override
	public int getStudentsNum() {
		return studentDao.getStudentsNum();
	}

	@Override
	public int getStudentsByNum(String sdept, String sname, String sdate,
			String edate) {
		return studentDao.getStudentsByNum(sdept, sname, sdate, edate);
	}

	@Override
	public List<Student> getStudents(int start, int end) {
		return studentDao.getStudents(start, end);
	}

	@Override
	public List<Student> getStudentsBySno(String sno) {
		return studentDao.getStudentsBySno(sno);
	}

	@Override
	public List<Student> getStudentsByArg(int start, int end, String sdept,
			String sname, String sdate, String edate) {
		return studentDao.getStudentsByArg(start, end, sdept, sname, sdate, edate);
	}

	@Override
	public List<Student> getAll() {
		return studentDao.getAll();
	}

	@Override
	public void delete(String sno) {
		studentDao.delete(sno);
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
	}

	@Override
	public void add(Student student) {
		studentDao.add(student);
	}

	@Override
	public void changepassword(String sno, String password) {
		studentDao.changepassword(sno, password);
	}

}
