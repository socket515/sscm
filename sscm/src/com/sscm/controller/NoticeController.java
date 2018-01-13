package com.sscm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.sscm.entity.DatatablesViewPage;
import com.sscm.entity.Notice;
import com.sscm.service.NoticeService;

@Controller
public class NoticeController {
	
	private static Logger logger = Logger.getLogger(NoticeController.class);
	
	@Resource
	private NoticeService noticeService;
	
	@RequestMapping(value="/queryNotice",method=RequestMethod.GET)
	@ResponseBody
	public List<Notice> queryNotice(){
		return noticeService.query();
	}
	
	@RequestMapping(value="/admin/queryNotice", method=RequestMethod.GET)
	@ResponseBody
	public DatatablesViewPage<Notice> queryNotices(HttpServletRequest request,HttpServletResponse response){
		int start =Integer.parseInt(request.getParameter("start"));    
        int length = Integer.parseInt(request.getParameter("length")); 
        List<Notice> list = noticeService.query2(start, length);
        int num = noticeService.count();
        DatatablesViewPage<Notice> view = new DatatablesViewPage<Notice>();
        view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		view.setAaData(list); 
		return view;  
	}
	@RequestMapping(value="/admin/delNotice", method=RequestMethod.POST)
	public void delNotice(int id,HttpServletResponse response)throws IOException{
		PrintWriter out = response.getWriter();
		try {
			noticeService.delete(id);
			out.print("true");
		} catch (Exception e) {
			logger.info("delNotice 出错了！",e);
			out.print("false");
		}
	}
	@RequestMapping(value="/admin/addNotice", method=RequestMethod.POST)
	public void addNotice(String content,HttpServletResponse response,HttpServletRequest request)throws IOException{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		try {
			Admin admin = (Admin) session.getAttribute("admin");
			if (admin == null) {
				out.print("false");
				return;
			}
			noticeService.add(admin.getUsername(),content);
			out.print("true");
		} catch (Exception e) {
			logger.info("addNotice 出错了！",e);
			out.print("false");
		}
	}
}
