package com.sscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sscm.entity.Course;

public interface CourseDao {
	public int getNum();
	public int getByArgNum(@Param("cname")String cname,@Param("type")boolean type);
	public int getByNameNum(String cname);
	public List<Course> getCourse(int start,int end);
	public List<Course> getByNum(String cno);
	public List<Course> getByArg(@Param("start")int start,@Param("end")int end,
			@Param("cname")String cname,@Param("type")boolean type);
	public List<Course> getByName(@Param("start")int start,@Param("end")int end,@Param("cname")String cname);
	public void delete(int cno);
	public void update(Course course);
	public void add(Course course);
	

}
