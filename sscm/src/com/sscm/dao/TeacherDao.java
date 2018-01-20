package com.sscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import com.sscm.entity.Teacher;

public interface TeacherDao {
	public Teacher loginTeacher(String username,String password);
	public int getNum();
	public int getNumByArgs(@Param("tname")String tname,@Param("tdept")String tdept,
			@Param("sdate")String sdate,@Param("edate")String edate);
	public int countByS(@Param("tname")String tname,@Param("tdept")String tdept,
			@Param("sdate")String sdate,@Param("edate")String edate);
	public List<Teacher> getAll(int start,int end);
	public List<Teacher> getByNo(String tno);
	public List<Teacher> getByArg(@Param("start")int start,@Param("end")int end,
			@Param("tname")String tname,@Param("tdept")String tdept,
			@Param("sdate")String sdate,@Param("edate")String edate);
	public void add(Teacher teacher) throws DuplicateKeyException;
	public void update(Teacher teacher);
	public void delete(String tno);
	public void changepwd(String tno, String pwd);
	public List<Teacher> queryTeacherByS(@Param("start")int start,@Param("end")int end,
			@Param("tname")String tname,@Param("tdept")String tdept,
			@Param("sdate")String sdate,@Param("edate")String edate);
	public List<Teacher> getByNoS(String tno);
	
}
