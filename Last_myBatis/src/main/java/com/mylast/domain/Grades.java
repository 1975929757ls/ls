package com.mylast.domain;

public class Grades {
    private int studentID;
    private int CourseID;
    private String CourseName;
    private int num;
    private String teachername;
    public Grades(){}

    public Grades(int studentID, int courseID, String courseName, int num, String teachername) {
        this.studentID = studentID;
        CourseID = courseID;
        CourseName = courseName;
        this.num = num;
        this.teachername = teachername;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "studentID=" + studentID +
                ", CourseID=" + CourseID +
                ", CourseName='" + CourseName + '\'' +
                ", num=" + num +
                ", techername='" + teachername + '\'' +
                '}';
    }
}
