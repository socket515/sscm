package com.sscm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sscm.dao.ArrangeDao;
import com.sscm.dao.StudentDao;
import com.sscm.entity.DatatablesViewPage;
import com.sscm.entity.Excel;
import com.sscm.entity.Student;
import com.sscm.service.StudentService;

import javax.annotation.Resource;


import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentDao studentDao;
	@Resource
	private ArrangeDao arrangeDao;
	
	private  SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd" ); 
	
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
	public void add(Student student) throws DuplicateKeyException {
		student.setPassword(student.getSno());
		String dt = student.getDt();
		if(dt==null||dt.equals("")){
			student.setDt(sdf.format(new Date()));
		}
		studentDao.add(student);
	}

	@Override
	public void changepassword(String sno, String password) {
		studentDao.changepassword(sno, password);
	}

	@Override
	public DatatablesViewPage<Student> querySelectStudent(int id, int start,
			int end) {
		List<Student> list = studentDao.querySelectStudent(id, start, end);
		DatatablesViewPage<Student> view = new DatatablesViewPage<Student>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(arrangeDao.selectNum(id));
		view.setiTotalRecords(5);
		return view;
	}

	@Override
	public Excel getStudentFile(int id) {
		String[] headr = {"学号","姓名","性别","年龄","专业","院系"};
		Excel excel = new Excel("学生名单", headr);
		excel.setContent(studentDao.querySelectAllStudent(id));
		return excel;
	}


}
