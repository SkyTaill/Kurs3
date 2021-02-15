package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {


    private static TreeMap<Integer, String> tests = new TreeMap<>(Collections.reverseOrder());
    private static String Before=" ";
    private static String After=" ";
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
	// write your code here
        sort(TestValue.class);
        start();
    }

    private static void sort(Class testValueClass) {
        Method[] methods = testValueClass.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                if (method.getAnnotation(Test.class).testFlag()) {
                    tests.put(method.getAnnotation(Test.class).priority(), method.getName());
                }
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                After=method.getName();
            }
            if (method.getAnnotation(BeforeSuite.class) != null) {
                Before=method.getName();
            }
        }
        if((Before==" " )||(After==" ")){
            throw new RuntimeException();
        }


    }
    public static void start() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        TestValue testValue = new TestValue();
       beforSuit(testValue);
        for(Map.Entry<Integer, String> item : tests.entrySet()) {
            try {
                Method method = TestValue.class.getDeclaredMethod(item.getValue());

                method.invoke(testValue);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        afterSuit(testValue);

    }
    public static void afterSuit(TestValue testValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = TestValue.class.getDeclaredMethod(After);
        method.invoke(testValue);
    }
    public static void beforSuit(TestValue testValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = TestValue.class.getDeclaredMethod(Before);
        method.invoke(testValue);
    }
}
