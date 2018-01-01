package com.sscm.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sscm.entity.Student;
import com.sscm.service.AdminService;
import com.sscm.service.StudentService;
import com.sscm.service.TeacherService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class StudentTest {
	
	@Resource
	private StudentService studentService;
	@Resource
	private TeacherService teacherService;
	@Resource
	private AdminService adminService;
	
	@Test
	public void test(){
		String key = null;
		Object obj = null;
		if(key==null&&obj==null){
			obj =  studentService.login("201430340506", "123456");
			if(obj!=null){
				System.out.println((Student)obj);
			}
		}
		Student student = studentService.login("201430340506", "123456");
		System.out.println(student);
		System.out.println(teacherService.login("s2123", "123456"));
		System.out.println(adminService.login("admin", "admin"));
	}
	

}
