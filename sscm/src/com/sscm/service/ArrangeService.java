package com.sscm.service;



import org.springframework.dao.DuplicateKeyException;

import com.sscm.entity.Arrange;
import com.sscm.entity.DatatablesViewPage;

public interface ArrangeService {
	public void add1(Arrange arrange) throws DuplicateKeyException;
	public void add2(Arrange arrange)throws DuplicateKeyException;
	public DatatablesViewPage<Arrange> getViewPage(int start,int end,String tno);
}
