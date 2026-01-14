package org.javaproject.studentregistrationsystem.geofrey.model;



public class Student {
    private String name;
    private String regNo;
    private String course;

    public Student(String name, String regNo, String course) {
        this.name = name;
        this.regNo = regNo;
        this.course = course;
    }
    public String getName() { return name; }
    public String getRegNo() { return regNo; }
    public String getCourse() { return course; }
}
