package com.sscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sscm.entity.Student;

public interface StudentDao {
	public Student loginStudent(String username,String password);
	
	public int getStudentsNum();
	
	public int getStudentsByNum(@Param("sdept")String sdept,@Param("sname")String sname,@Param("sdate")String sdate,
			@Param("edate")String edate);
	
	public List<Student> getStudents(int start,int end);
	
	public List<Student> getStudentsBySno(String sno);
	
	public List<Student> getStudentsByArg(@Param("start")int start,@Param("end")int end,
			@Param("sdept")String sdept,@Param("sname")String sname,@Param("sdate")String sdate,
			@Param("edate")String edate);
	
	public List<Student> getAll();
	
	public void delete(String sno);
	
	public void update(Student student);
	
	public void add(Student student);
	
	public void changepassword(String sno,String password);

}
