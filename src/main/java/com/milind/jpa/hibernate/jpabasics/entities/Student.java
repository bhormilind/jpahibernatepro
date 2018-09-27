package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@SequenceGenerator(name="studSeq",sequenceName = "studName",initialValue = 2001)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studName;

    @OneToOne
    private Passport passport;

    @ManyToMany
    @JoinTable(name="STUDENT_COURSE",
        joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String studName) {
        this.studName = studName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course c){
        this.courses.add(c);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studName='" + studName + '\'' +
                ", passport=" + passport +
                '}';
    }
}
