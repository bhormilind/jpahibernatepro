package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.*;

@Entity
@NamedQuery(name = "firstTwoRecords",query = "Select p from Passport p where id <= 2")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getPassportNo() {
        return passportNo;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", passportNo='" + passportNo + '\'' +
                '}';
    }
}
