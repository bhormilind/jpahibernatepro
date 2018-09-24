package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.*;

@Entity
//@SequenceGenerator(name = "passNo",sequenceName = "passNo",initialValue = 3001)
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNo;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;

    public Passport() {
    }

    public Passport(String passportNo) {
        this.passportNo = passportNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passortNo='" + passportNo + '\'' +
                '}';
    }
}
