package com.sscm.test;

/**
 * Created by Administrator on 2017-12-03.
 */
import com.sscm.model.Student;
import com.sscm.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class StudentTest {
    @Resource
    private StudentService studentService;

    @Test
    public void test(){
        Student student;
        student = studentService.login("201430340506","123456");
        if(student!=null){
            System.out.println("yes");
            System.out.println(student.toString());        }
        else {
            System.out.println("no");
        }
    }
}
