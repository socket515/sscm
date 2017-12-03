package com.sscm.model;

/**
 * Created by Administrator on 2017-12-03.
 */
public class Student {
    private String sno;
    private String sname;
    private String password;
    private boolean ssex;
    private int sage;
    private String dept;
    private Course course;
    private int grade;


    public Student() {

    }

    public Student(String sno, String sname, String password, boolean ssex, int sage, String dept) {
        this.sno = sno;
        this.sname = sname;
        this.password = password;
        this.ssex = ssex;
        this.sage = sage;
        this.dept = dept;
    }

    public Student(String sno, String sname, String password, boolean ssex, int sage, String dept, Course course) {
        this.sno = sno;
        this.sname = sname;
        this.password = password;
        this.ssex = ssex;
        this.sage = sage;
        this.dept = dept;
        this.course = course;
    }

    public String getSno() {
        return sno;
    }

    public String getSname() {
        return sname;
    }

    public String getPassword() {
        return password;
    }

    public boolean getSsex() {
        return ssex;
    }

    public int getSage() {
        return sage;
    }

    public String getDept() {
        return dept;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSsex(boolean ssex) {
        this.ssex = ssex;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
