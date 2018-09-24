package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="studSeq",sequenceName = "studName",initialValue = 2001)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "studSeq")
    private Long id;
    private String studName;

    @OneToOne
    private Passport passport;

    public Student() {
    }

    public Student(String studName) {
        this.studName = studName;
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
