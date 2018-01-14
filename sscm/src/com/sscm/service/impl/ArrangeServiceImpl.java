package com.sscm.service.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sscm.dao.ArrangeDao;
import com.sscm.dao.CourseDao;
import com.sscm.entity.Arrange;
import com.sscm.entity.DatatablesViewPage;
import com.sscm.exception.ZeroException;
import com.sscm.service.ArrangeService;
@Service("arrangeService")
public class ArrangeServiceImpl implements ArrangeService {
	
	@Resource
	private CourseDao courseDao;
	
	@Resource
	private ArrangeDao arrangeDao;

	@Override
	public void add1(Arrange arrange) throws DuplicateKeyException {
		arrange.setAnum(arrange.getMaxnum());
		arrangeDao.add(arrange);
	}

	@Override
	public void add2(Arrange arrange) throws DuplicateKeyException {
		arrange.setAnum(arrange.getMaxnum());
		arrangeDao.add(arrange);
		courseDao.changestate(arrange.getCno());
	}

	@Override
	public DatatablesViewPage<Arrange> getViewPage(int start, int end,
			String tno) {
		List<Arrange> list = arrangeDao.queryByTeacher(start, end, tno);
		DatatablesViewPage<Arrange> view = new DatatablesViewPage<Arrange>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(arrangeDao.countByTeacher(tno));
		view.setiTotalRecords(5);
		return view;
	}

	@Override
	public DatatablesViewPage<Arrange> getViewS(int start, int end, String cno,
			String cname, String type, String tname, String atime,
			String address) {
		Boolean p1=null;
		Integer p2=null,p3=null;
		if(type!=null){
			if (type.equals("1")) {
				p1 = new Boolean(true);
			}else if (type.equals("0")) {
				p1 = new Boolean(false);
			}
		}
		if(atime!=null){
			p2 = new Integer(atime);
		}
		if(address!=null){
			p3 = new Integer(address);
		}
		List<Arrange> list = arrangeDao.queryByStudent(start, end, cno, cname, p1, tname, p2, p3);
		int num = arrangeDao.countByStudent(cno, cname, p1, tname, p2, p3);
		DatatablesViewPage<Arrange> view = new DatatablesViewPage<Arrange>();
		view.setAaData(list);
		view.setiTotalDisplayRecords(num);
		view.setiTotalRecords(5);
		return view;
	}

	@Override
	@Transactional
	public void arrangeCourse(int id, String sno) throws ZeroException {
		int num = arrangeDao.queryCount(id);
		if(num<=0) throw new ZeroException();
		arrangeDao.selectArrange(id);
		arrangeDao.selectCourse(id, sno);
		
	}

	@Override
	public boolean selected(String sno, int time) {
		int num = arrangeDao.selected(sno, time);
		if(num!=0) return false;
		return true;
	}

}
