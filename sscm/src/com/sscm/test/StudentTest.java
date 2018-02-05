package com.sscm.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sscm.entity.Student;
import com.sscm.service.AdminService;
import com.sscm.service.DataService;
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
	@Resource
	private DataService dataService;
	
	
	@Test
	public void test(){
		System.out.println(dataService.getBar("ss"));
	}
	

}
