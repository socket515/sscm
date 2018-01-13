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

import com.sscm.entity.Arrange;
import com.sscm.entity.Teacher;
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

}
