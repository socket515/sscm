package com.sscm.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import com.sscm.entity.Arrange;

public interface ArrangeDao {
	public void add(Arrange arrange) throws DuplicateKeyException;
	public List<Arrange> queryByTeacher(@Param("start")int start,@Param("end")int end,@Param("tno")String tno);
	public int countByTeacher(String tno);
}
