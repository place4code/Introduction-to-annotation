package com.company;

import java.lang.annotation.*;
import java.lang.reflect.*;



@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String str();
    int val();
}

public class Main {


    @MyAnnotation(str = "String from annotation header", val = 100)
    public static void myMethod(String test, int number) {
        Main main = new Main();

        try {

            Class c = main.getClass();

            Method method = c.getMethod("myMethod", String.class, int.class);

            MyAnnotation anno = method.getAnnotation(MyAnnotation.class);

            System.out.println("From annotation : " + anno.str() + ", " + anno.val());
            System.out.println("From method: " + test + ", " + number);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        myMethod("String", 111);

    }
}
