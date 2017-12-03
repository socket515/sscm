package com.sscm.dao;

import com.sscm.model.Student;

/**
 * Created by Administrator on 2017-12-03.
 */
public interface StudentDao {
    public Student login(String sno,String password);
}
