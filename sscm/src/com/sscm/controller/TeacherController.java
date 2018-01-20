package com.sscm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sscm.entity.DatatablesViewPage;
import com.sscm.entity.Teacher;
import com.sscm.service.TeacherService;

@Controller
public class TeacherController {
	
	private static Logger logger = Logger.getLogger(TeacherController.class);
	
	@Resource
	private TeacherService teacherService;
	
	@RequestMapping(value="/admin/queryTeacher", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Teacher> queryTeacher(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));  
        String state = request.getParameter("state");
        List<Teacher> list = null;
        int num = 0;
        if (state.equals("0")){
        	list = teacherService.getAll(start, length);
        	num = teacherService.getNum();
        } else if (state.equals("1")) {
			list = teacherService.getByNo(request.getParameter("tno"));
			num = 1;
		}else if (state.equals("2")) {
			String tdept = request.getParameter("tdept");
			String tname = request.getParameter("tname");
			String sdate = request.getParameter("sdate");
			String edate = request.getParameter("edate");
			num = teacherService.getNumByArgs(tdept, tname, sdate, edate);
			list = teacherService.getByArg(start, length, tname, tdept, sdate, edate);
		}else {
			return null;
		}
        DatatablesViewPage<Teacher> view = new DatatablesViewPage<Teacher>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	@RequestMapping(value="/student/queryTeacher", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Teacher> queryTeacherBystudent(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));  
        String state = request.getParameter("state");
        DatatablesViewPage<Teacher> view = new DatatablesViewPage<Teacher>();
        if (state.equals("0")){
        	String tdept = request.getParameter("tdept");
			String tname = request.getParameter("tname");
			String sdate = request.getParameter("sdate");
			String edate = request.getParameter("edate");
			view = teacherService.queryTeachers(start, length, tname, tdept, sdate, edate);
        } else if (state.equals("1")) {
			view = teacherService.queryTeachers(request.getParameter("tno"));
		}else {
			return null;
		}
		return view;
	}
	@RequestMapping(value="/admin/addTeacher", method=RequestMethod.POST)
	public void addTeacher(Teacher teacher,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(teacher==null){
				out.print("false");
			}else {
				teacherService.add(teacher);
				out.print("true");
			}	
		}
		catch (DuplicateKeyException e){
				out.print("key");
		}
	     catch (Exception e) {
			logger.info("addTeacher 出错了！",e);
			out.print("false");
		}
		
	}
	@RequestMapping(value="/admin/delTeacher", method=RequestMethod.POST)
	public void delTeacher(String tno,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(tno==null||tno.equals("")){
				out.print("false");
			}else {
				teacherService.delete(tno);
				out.print("true");
			}	
		} catch (Exception e) {
			logger.info("delTeacher 出错了！",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/admin/changeTeacher", method=RequestMethod.POST)
	public void changeTeacher(Teacher teacher,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(teacher==null){
				out.print("false");
			}else {
				teacherService.update(teacher);
				out.print("true");
			}	
		} catch (Exception e) {
			logger.info("addTeacher 出错了！",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/teacher/getTeacher", method=RequestMethod.GET)
	@ResponseBody
	public Teacher getTeacher(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		HttpSession session = request.getSession();
		return (Teacher)session.getAttribute("teacher");
	}
	@RequestMapping(value="/teacher/changeTeacher", method=RequestMethod.POST)
	public void updateTeacher(Teacher teacher,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(teacher==null){
				out.print("false");
			}else {
				teacherService.update(teacher);
				out.print("true");
			}	
		} catch (Exception e) {
			logger.info("addTeacher 出错了！",e);
			out.print("false");
		}
	}
}
