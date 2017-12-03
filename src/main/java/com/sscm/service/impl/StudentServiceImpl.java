package com.sscm.service.impl;

import com.sscm.dao.StudentDao;
import com.sscm.model.Student;
import com.sscm.service.StudentService;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
 * Created by Administrator on 2017-12-03.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student login(String sno, String password){
        return studentDao.login(sno,password);
    }
}
