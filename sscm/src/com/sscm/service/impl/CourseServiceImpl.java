package com.sscm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sscm.dao.CourseDao;
import com.sscm.entity.Course;
import com.sscm.service.CourseService;
@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	@Resource
	private CourseDao courseDao;

	@Override
	public void delete(int cno) {
		courseDao.delete(cno);
	}

	@Override
	public void update(Course course) {
		courseDao.update(course);
	}

	@Override
	public void add(Course course) {
		courseDao.add(course);
	}

	@Override
	public int getNum() {
		return courseDao.getNum();
	}

	@Override
	public int getByArgNum(String cname, String type) {
		if(type==null||type.equals("")){
			return courseDao.getByNameNum(cname);
		}else {
			if(type.equals("1")){
				return courseDao.getByArgNum(cname, true);
			}
			return courseDao.getByArgNum(cname, false);
		}
	}

	@Override
	public List<Course> getCourse(int start, int end) {
		return courseDao.getCourse(start, end);
	}

	@Override
	public List<Course> getByArg(int start, int end, String cname, String type) {
		if(type==null||type.equals("")){
			return courseDao.getByName(start, end, cname);
		}else {
			if(type.equals("1")){
				return courseDao.getByArg(start, end, cname, true);
			}
			return courseDao.getByArg(start, end, cname, false);
		}
	}

	@Override
	public List<Course> getByNum(String cno) {
		return courseDao.getByNum(cno);
	}

}
