package com.sscm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sscm.entity.Admin;
import com.sscm.entity.BarInfo;
import com.sscm.entity.Student;
import com.sscm.entity.Teacher;
import com.sscm.service.AdminService;
import com.sscm.service.DataService;
import com.sscm.service.StudentService;
import com.sscm.service.TeacherService;

@Controller
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	@Resource
	private StudentService studentService;
	@Resource
	private TeacherService teacherService;
	@Resource
	private AdminService adminService;
	@Resource
	private DataService dataService;
	
	//登录
	@RequestMapping(value="userLogin",method=RequestMethod.POST)
	public void userLogin(String username,String password,int value,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Object obj = null;
		String key = null;
		try {
			if(value==1){
				obj = studentService.login(username, password);
				key = "student";
			}else if (value==2) {
				obj = teacherService.login(username, password);
				key = "teacher";
			}else {
				obj = adminService.login(username, password);
				key = "admin";
			}
		} catch (Exception e) {
			logger.info("userLogin出错！！");
			e.printStackTrace();
		}finally{
			if(key!=null&&obj!=null){
				session.setAttribute(key, obj);
				out.print(key);
			}else {
				out.print("false");
			}
		}
		
	}
	@RequestMapping(value="/admin/changepassword",method=RequestMethod.POST)
	public void adminpwd(String opwd,String npwd,HttpServletRequest request,
			HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin==null){
			out.print("false");
			return;
		}
		if(!admin.getPassword().equals(opwd)){
			out.print("worng");
			return;
		}
		try {
			admin.setPassword(npwd);
			adminService.change(admin);
			out.print("true");
		} catch (Exception e) {
			logger.info("adminpwd出错了！", e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/teacher/changepassword",method=RequestMethod.POST)
	public void teacherpwd(String opwd,String npwd,HttpServletRequest request,
			HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		if(teacher==null){
			out.print("false");
			return;
		}
		if(!teacher.getTpass().equals(opwd)){
			out.print("worng");
			return;
		}
		try {
			teacherService.changepwd(teacher.getTno(), npwd);
			out.print("true");
		} catch (Exception e) {
			logger.info("adminpwd出错了！", e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/student/changepassword",method=RequestMethod.POST)
	public void studentpwd(String opwd,String npwd,HttpServletRequest request,
			HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		if(student==null){
			out.print("false");
			return;
		}
		if(!student.getPassword().equals(opwd)){
			out.print("worng");
			return;
		}
		try {
			studentService.changepassword(student.getSno(), npwd);
			out.print("true");
		} catch (Exception e) {
			logger.info("adminpwd出错了！", e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/admin/getadmin",method=RequestMethod.GET)
	@ResponseBody
	public BarInfo getadmin(HttpServletRequest request){
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		BarInfo bar = dataService.getBar(admin.getUsername());
		return bar;
	}
	
	@RequestMapping(value="/unlogin",method=RequestMethod.POST)
	public void unlogin(HttpServletRequest request){
		System.out.println("t");
		request.getSession().invalidate();
	}
	

}
