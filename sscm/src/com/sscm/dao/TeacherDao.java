package com.sscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sscm.entity.Teacher;

public interface TeacherDao {
	public Teacher loginTeacher(String username,String password);
	public int getNum();
	public int getNumByArgs(@Param("tname")String tname,@Param("tdept")String tdept,
			@Param("sdate")String sdate,@Param("edate")String edate);
	public List<Teacher> getAll(int start,int end);
	public List<Teacher> getByNo(String tno);
	public List<Teacher> getByArg(@Param("start")int start,@Param("end")int end,
			@Param("tname")String tname,@Param("tdept")String tdept,
			@Param("sdate")String sdate,@Param("edate")String edate);
	
}
