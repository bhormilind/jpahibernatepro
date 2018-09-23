package com.milind.jpa.hibernate.jpabasics.testcases;


import com.milind.jpa.hibernate.jpabasics.junitdemo.MyArithMaticOperations;
import org.junit.*;

public class MyArithMaticOperationsTest {
    MyArithMaticOperations obj = new MyArithMaticOperations();

    @BeforeClass
    public static void beforeClass(){
        System.out.println("\n Before class test case");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("\n After class test case . . .");
    }

    @Before
    public void beforeTest(){
        System.out.println("\n Before Test Case . . . ");
    }

    @Test
    public void testSumInt(){

        int res = obj.sumInt(1,2,3);
        Assert.assertEquals(6,res);

    }

    @After
    public void afterTest(){
        System.out.println("\n After Test Case");
    }
}
