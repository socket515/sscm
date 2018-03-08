package com.sscm.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sscm.dao.ArrangeDao;
import com.sscm.entity.Student;
import com.sscm.service.AdminService;
import com.sscm.service.ArrangeService;
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
	@Resource
	private ArrangeService arrangeService;
	
	@Test
	public void test(){
		try {
			arrangeService.cancleCourse(7, "201430340506");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}
