package com.sscm.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

import com.sscm.entity.Arrange;
import com.sscm.entity.DatatablesViewPage;
import com.sscm.entity.Teacher;
import com.sscm.entity.Student;
import com.sscm.exception.ZeroException;
import com.sscm.service.ArrangeService;

@Controller
public class ArrangeController {
	
	private static Logger logger = Logger.getLogger(ArrangeController.class);
	
	@Resource
	private ArrangeService arrangeService;
	
	@RequestMapping(value="/teacher/addArrange1", method=RequestMethod.POST)
	public void  addArrange1(Arrange arrange,HttpServletRequest request,HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			if(arrange==null){
				out.print("false");
			}else {
				Teacher teacher = (Teacher)session.getAttribute("teacher");
				if (teacher==null) {
					out.print("false");
				}
				arrange.setTno(teacher.getTno());
				arrangeService.add1(arrange);
				out.print("true");
			}	
		} catch(DuplicateKeyException e){
			out.print("wrong");
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info("addArrange1 出错了！",e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/teacher/addArrange2", method=RequestMethod.POST)
	public void  addArrange2(Arrange arrange,HttpServletRequest request,HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			if(arrange==null){
				out.print("false");
				return;
			}else {
				System.out.println(arrange);
				Teacher teacher = (Teacher)session.getAttribute("teacher");
				if (teacher==null) {
					out.print("false");
					return;
				}
				System.out.println(teacher);
				arrange.setTno(teacher.getTno());
				arrangeService.add1(arrange);
				out.print("true");
			}	
		} catch(DuplicateKeyException e){
			out.print("wrong");
		}
		catch (Exception e) {
			e.printStackTrace();
			logger.info("addArrange2 出错了！",e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/teacher/getArrange", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Arrange>  getArrangeByTeacher(HttpServletRequest request,HttpServletResponse response){
		response.reset();
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        if(teacher==null){
        	return null;
        }
        try {
        	int start =Integer.parseInt(request.getParameter("start"));    
            int length = Integer.parseInt(request.getParameter("length"));  
            DatatablesViewPage<Arrange> view = arrangeService.getViewPage(start, length, teacher.getTno());
            return view;
		} catch (Exception e) {
			logger.info("getArrangeByTeacher 出错了！",e);
			return null;
		}
        
	}
	
	@RequestMapping(value="/student/getArrange", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Arrange>  getArrangeByStudent(HttpServletRequest request,HttpServletResponse response){
		response.reset();
        try {
        	int start =Integer.parseInt(request.getParameter("start"));    
            int length = Integer.parseInt(request.getParameter("length"));  
            DatatablesViewPage<Arrange> view = arrangeService.getViewS(start, length, request.getParameter("cno"), 
            		request.getParameter("cname"), request.getParameter("type"), request.getParameter("tname"), 
            		request.getParameter("atime"), request.getParameter("address"));
            return view;
		} catch (Exception e) {
			logger.info("getArrangeByStudent 出错了！",e);
			return null;
		}
        
	}
	
	@RequestMapping(value="/student/getPersonalCourse", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Arrange> getPersonalCourse(int start, int length, HttpServletRequest request,HttpServletResponse response){
		response.reset();
		HttpSession session = request.getSession();
		Student student = (Student)session.getAttribute("student");
		if(student==null) return null;
		System.out.println(start+","+length+","+student.getSno());
		return arrangeService.getViewSP(start, length, student.getSno());
	}
	
	@RequestMapping(value="/student/selectCourse", method=RequestMethod.POST)
	public void selectCourse(int id,int time,HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			Student student = (Student) session.getAttribute("student");
			if(student==null){
				out.print("err");
				return;
			}
			if (arrangeService.selected(student.getSno(), time)) {
				arrangeService.arrangeCourse(id, student.getSno());
			}else {
				out.print("wrong");
				return;
			}
			out.print("true");
		} catch(ZeroException e){
			logger.info(e);
			out.print("fail");
		}
		catch (Exception e) {
			logger.info("selectCourse",e);
			out.print("err");
		}
	}
	
	@RequestMapping(value="/student/cancleCourse", method=RequestMethod.POST)
	public void cancleCourse(int id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			Student student = (Student) session.getAttribute("student");
			arrangeService.cancleCourse(id, student.getSno());
			out.print("true");
		} catch(ZeroException e){
			logger.info(e);
			out.print("fail");
		}
		catch (Exception e) {
			logger.info("cancleCourse",e);
			out.print("err");
		}
	}

}
