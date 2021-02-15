package com.company;

public class TestValue {
@Test(priority = 2)
    public void first(){
    System.out.println("first");
}
    @Test(priority = 6)
    public void second(){
        System.out.println("second");
    }

    @Test(priority = 1)
    public void method2(){
        System.out.println("method2");
    }
    @Test(priority = 8)
    public void method3(){
        System.out.println("method3");
    }
    @BeforeSuite
    public void method4(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public void method5(){
        System.out.println("AfterSuite");
    }
}
