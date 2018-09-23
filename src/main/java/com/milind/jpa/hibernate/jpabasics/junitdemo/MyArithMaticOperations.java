package com.milind.jpa.hibernate.jpabasics.junitdemo;

import java.util.Arrays;

public class MyArithMaticOperations {

    public int sumInt(int...a){
        return Arrays.stream(a).sum();
    }
}
