package com.milind.jpa.hibernate.jpabasics.entities;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee{

    private BigDecimal hourlyWages;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(String name, BigDecimal hourlyWages) {
        super(name);
        this.hourlyWages = hourlyWages;
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "hourlyWages=" + hourlyWages +
                '}';
    }
}
