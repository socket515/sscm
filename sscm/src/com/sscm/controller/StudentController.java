package com.sscm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sscm.entity.DatatablesViewPage;
import com.sscm.service.StudentService;
import com.sscm.entity.Student;
@Controller
public class StudentController {
	
	@Resource
	private StudentService studentService;
	
	@RequestMapping(value="/queryStudents", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Student> querStudents(HttpServletRequest request,HttpServletResponse response){
		response.reset();
		int start =Integer.parseInt(request.getParameter("start"));  
        System.out.println(start);  
        int length = Integer.parseInt(request.getParameter("length"));  
        System.out.println(length);  
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
		view.setiTotalDisplayRecords(3);
		view.setiTotalRecords(num);
		view.setAaData(list); 
		return view;
	}
	
	private List<Student> getStudents() {
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student("201430340506","黄少杰",false,18,"数学与信息学院","2014-09-12");
		Student s2 = new Student("201430340506","黄少杰",true,18,"数学与信息学院","2014-09-12");
		Student s3 = new Student("201430340506","黄少杰",true,18,"数学与信息学院","2014-09-12");
		list.add(s1);
		list.add(s2);
		list.add(s3);
		return list;
	}

}
