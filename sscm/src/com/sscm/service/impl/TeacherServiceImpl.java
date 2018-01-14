package com.sscm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sscm.dao.TeacherDao;
import com.sscm.entity.DatatablesViewPage;
import com.sscm.entity.Teacher;
import com.sscm.service.TeacherService;
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
	
	@Resource
	private TeacherDao teacherDao;
	
	private  SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd" );

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

	@Override
	public void add(Teacher teacher) {
		teacher.setTpass(teacher.getTno());
		String dt = teacher.getDt();
		if(dt==null||dt.equals("")){
			teacher.setDt(sdf.format(new Date()));
		}
		teacherDao.add(teacher);
	}

	@Override
	public void update(Teacher teacher) {
		teacherDao.update(teacher);
	}

	@Override
	public void delete(String tno) {
		teacherDao.delete(tno);
	}

	@Override
	public void changepwd(String tno, String pwd) {
		teacherDao.changepwd(tno, pwd);
	}

	@Override
	public DatatablesViewPage<Teacher> queryTeachers(int start, int end,
			String tname, String tdept, String sdate, String edate) {
		List<Teacher> list = teacherDao.queryTeacherByS(start, end, tname, tdept, sdate, edate);
		int num = teacherDao.countByS(tname, tdept, sdate, edate);
		DatatablesViewPage<Teacher> view = new DatatablesViewPage<Teacher>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		return view;
	}

	@Override
	public DatatablesViewPage<Teacher> queryTeachers(String tno) {
		List<Teacher> list = teacherDao.getByNoS(tno);
		DatatablesViewPage<Teacher> view = new DatatablesViewPage<Teacher>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(1);
		view.setiTotalRecords(5);
		return view;
	}

}
