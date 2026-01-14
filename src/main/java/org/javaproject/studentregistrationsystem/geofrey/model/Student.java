package org.javaproject.studentregistrationsystem.geofrey.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "reg_no", nullable = false, unique = true)
    private String regNo;

    @Column(name = "course", nullable = false)
    private String course;

    public Student() {} // Default constructor for Hibernate

    public Student(String name, String regNo, String course) {
        this.name = name;
        this.regNo = regNo;
        this.course = course;
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getRegNo() { return regNo; }
    public String getCourse() { return course; }

    public void setName(String name) { this.name = name; }
    public void setRegNo(String regNo) { this.regNo = regNo; }
    public void setCourse(String course) { this.course = course; }
}
