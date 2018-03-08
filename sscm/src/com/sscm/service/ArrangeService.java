package com.sscm.service;



import org.springframework.dao.DuplicateKeyException;

import com.sscm.entity.Arrange;
import com.sscm.entity.DatatablesViewPage;
import com.sscm.exception.ZeroException;

public interface ArrangeService {
	public void add1(Arrange arrange) throws DuplicateKeyException;
	public void add2(Arrange arrange)throws DuplicateKeyException;
	public DatatablesViewPage<Arrange> getViewPage(int start,int end,String tno);
	public DatatablesViewPage<Arrange> getViewS(int start,int end,String cno,String cname,
			String type,String tname, String atime, String address);
	public void arrangeCourse(int id,String sno) throws ZeroException;
	public void cancleCourse(int id, String sno) throws ZeroException;
	public boolean selected(String sno,int time);
	public DatatablesViewPage<Arrange> getViewSP(int start,int end,String sno);
}
