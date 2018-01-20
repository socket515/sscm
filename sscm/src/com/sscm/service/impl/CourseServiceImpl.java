package com.sscm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.sscm.dao.CourseDao;
import com.sscm.entity.Course;
import com.sscm.service.CourseService;
@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	@Resource
	private CourseDao courseDao;

	@Override
	public void delete(String cno) {
		courseDao.delete(cno);
	}

	@Override
	public void update(Course course) {
		courseDao.update(course);
	}

	@Override
	public void add(Course course) throws DuplicateKeyException {
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
				return courseDao.getByArgNum(cname, 1);
			}
			return courseDao.getByArgNum(cname, 0);
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
				return courseDao.getByArg(start, end, cname, 1);
			}
			return courseDao.getByArg(start, end, cname, 0);
		}
	}

	@Override
	public List<Course> getByNum(String cno) {
		return courseDao.getByNum(cno);
	}

}
