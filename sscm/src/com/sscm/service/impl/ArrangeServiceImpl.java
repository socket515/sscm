package com.sscm.service.impl;

import javax.annotation.Resource;


import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.sscm.dao.ArrangeDao;
import com.sscm.dao.CourseDao;
import com.sscm.entity.Arrange;
import com.sscm.entity.DatatablesViewPage;
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
		// TODO Auto-generated method stub
		return null;
	}

}
