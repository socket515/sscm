package com.sscm.controller;

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
		logger.info("request Teacher");
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
}
