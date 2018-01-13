package com.sscm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sscm.entity.Course;
import com.sscm.entity.DatatablesViewPage;
import com.sscm.service.CourseService;

@Controller
public class CourseController {
	
	private static Logger logger = Logger.getLogger(CourseController.class);
	@Resource
	private CourseService courseService;
	
	@RequestMapping(value="/admin/queryCourse", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Course> queryCourse(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		logger.info("have request");
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));  
        String state = request.getParameter("state");
        List<Course> list = null;
        int num = 0;
        if (state.equals("0")){
        	list = courseService.getCourse(start, length);
        	num = courseService.getNum();
        } else if (state.equals("1")) {
			list = courseService.getByNum(request.getParameter("cno"));
			num = 1;
		}else if (state.equals("2")) {
			String cname = request.getParameter("cname");
			String type = request.getParameter("ctype");
			num = courseService.getByArgNum(cname, type);
			System.out.println(num);
			list = courseService.getByArg(start, length, cname, type);
		}else {
			return null;
		}
        DatatablesViewPage<Course> view = new DatatablesViewPage<Course>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
		
	}
	
	@RequestMapping(value="/teacher/queryCourse", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Course> queryCourseByTeacher(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		logger.info("have request");
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));  
        String state = request.getParameter("state");
        List<Course> list = null;
        int num = 0;
        if (state.equals("0")){
        	list = courseService.getCourse(start, length);
        	num = courseService.getNum();
        } else if (state.equals("1")) {
			list = courseService.getByNum(request.getParameter("cno"));
			num = 1;
		}else if (state.equals("2")) {
			String cname = request.getParameter("cname");
			String type = request.getParameter("ctype");
			num = courseService.getByArgNum(cname, type);
			System.out.println(num);
			list = courseService.getByArg(start, length, cname, type);
		}else {
			return null;
		}
        DatatablesViewPage<Course> view = new DatatablesViewPage<Course>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
		
	}
	
	@RequestMapping(value="/admin/deleteCourse", method=RequestMethod.POST)
	public void  deleteCourse(String cno,HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(cno==null||cno.equals("")){
				out.print("false");
			}else {
				courseService.delete(cno);
				out.print("true");
			}	
		} catch (Exception e) {
			logger.info("deleteCourse 出错了！",e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/admin/updateCourse", method=RequestMethod.POST)
	public void  updateCourse(Course course,HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(course==null){
				out.print("false");
			}else {
				courseService.update(course);
				out.print("true");
			}	
		} catch (Exception e) {
			logger.info("updateCourse 出错了！",e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/admin/addCourse", method=RequestMethod.POST)
	public void  addCourse(Course course,HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(course==null){
				out.print("false");
			}else {
				courseService.add(course);
				out.print("true");
			}	
		} catch (Exception e) {
			logger.info("addCourse 出错了！",e);
			out.print("false");
		}
	}

}
