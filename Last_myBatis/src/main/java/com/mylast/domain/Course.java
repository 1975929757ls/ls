package com.mylast.domain;

public class Course {
    private int CourseID;
    private String CourseName;
    private String teacher;
    private String classroom;
    private String info;

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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseID=" + CourseID +
                ", name='" + CourseName + '\'' +
                ", teacher='" + teacher + '\'' +
                ", classroom='" + classroom + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
