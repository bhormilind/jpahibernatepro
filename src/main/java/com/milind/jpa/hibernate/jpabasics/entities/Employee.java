package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy =InheritanceType.JOINED )
public class Employee {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    protected Employee(){

    }

    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
