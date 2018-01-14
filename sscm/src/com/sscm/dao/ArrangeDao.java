package com.sscm.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DuplicateKeyException;

import com.sscm.entity.Arrange;

public interface ArrangeDao {
	public void add(Arrange arrange) throws DuplicateKeyException;
	public List<Arrange> queryByTeacher(@Param("start")int start,@Param("end")int end,@Param("tno")String tno);
	public int countByTeacher(String tno);
	public List<Arrange> queryByStudent(@Param("start")int start,@Param("end")int end,
			@Param("cno")String cno,@Param("cname")String cname,@Param("type")Boolean type,
			@Param("tname")String tname, @Param("atime")Integer atime, @Param("address") Integer address);
	public int countByStudent(@Param("cno")String cno,@Param("cname")String cname,@Param("type")Boolean type,
			@Param("tname")String tname, @Param("atime")Integer atime, @Param("address") Integer address);
	public int selected(@Param("sno")String sno, @Param("atime")int atime);
	public void selectCourse(@Param("id")int id,@Param("sno")String sno);
	public void selectArrange(int id);
	public int queryCount(int id);
}
