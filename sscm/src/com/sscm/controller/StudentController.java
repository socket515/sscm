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

import com.sscm.entity.DatatablesViewPage;
import com.sscm.service.StudentService;
import com.sscm.entity.Student;
@Controller
public class StudentController {
	
	private static Logger logger = Logger.getLogger(StudentController.class);
	
	@Resource
	private StudentService studentService;
	
	@RequestMapping(value="/queryStudents", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Student> querStudents(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length"));  
        String state = request.getParameter("state");
        List<Student> list = null;
        int num = 0;
        if (state.equals("0")){
        	list = studentService.getStudents(start, length);
        	num = studentService.getStudentsNum();
        } else if (state.equals("1")) {
			list = studentService.getStudentsBySno(request.getParameter("sno"));
			num = 1;
		}else if (state.equals("2")) {
			String sdept = request.getParameter("sdept");
			String sname = request.getParameter("sname");
			String sdate = request.getParameter("sdate");
			String edate = request.getParameter("edate");
			num = studentService.getStudentsByNum(sdept, sname, sdate, edate);
			list = studentService.getStudentsByArg(start, length, sdept, sname, sdate, edate);
		}else {
			return null;
		}
		DatatablesViewPage<Student> view = new DatatablesViewPage<Student>();
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;
	}
	
	@RequestMapping(value="/deleteStudents", method=RequestMethod.POST)
	public void deleteStudents(String sno,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(sno==null||sno.equals("")){
				out.print("false");
			}else {
				studentService.delete(sno);
			}	
		} catch (Exception e) {
			logger.info("deleteStudents 出错了！",e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/updateStudents", method=RequestMethod.POST)
	public void updateStudents(Student student,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(student==null){
				out.print("false");
			}else {
				studentService.update(student);
			}	
		} catch (Exception e) {
			logger.info("updateStudents 出错了！",e);
			out.print("false");
		}
	}
	
	@RequestMapping(value="/addStudents", method=RequestMethod.POST)
	public void addStudents(Student student,HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		try {
			if(student==null){
				out.print("false");
			}else {
				studentService.add(student);
			}	
		} catch (Exception e) {
			logger.info("addStudents 出错了！",e);
			out.print("false");
		}
	}
	
	
}
