package com.mylast.domain;

public class studentClass {
    private int studentID;
    private int CourseID;
    private String CourseName;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    @Override
    public String toString() {
        return "studentClass{" +
                "studentID=" + studentID +
                ", CourseID=" + CourseID +
                ", CourseName='" + CourseName + '\'' +
                '}';
    }
}
