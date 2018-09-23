package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.*;

@Entity
@NamedQueries( value = {
        @NamedQuery(name = "find_by_Name_JS",query = "select c from Course c where name like '%JS%'"),
        @NamedQuery(name = "find_All",query = "select c from Course c")
})

public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
