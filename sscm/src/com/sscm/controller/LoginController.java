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

import com.sscm.entity.Admin;
import com.sscm.service.AdminService;
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
	
	//登录
	@RequestMapping(value="userLogin",method=RequestMethod.POST)
	public void userLogin(String username,String password,int value,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		logger.info("进入登录方法");
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
			logger.info("出错！！");
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
			System.out.println(npwd);
			adminService.change(admin);
			out.print("true");
		} catch (Exception e) {
			logger.info("adminpwd出错了！", e);
			out.print("false");
		}
	}
	
	

}
