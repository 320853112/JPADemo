package com.xu;

import com.xu.extend.Father;
import com.xu.suger.MyResource1;
import com.xu.suger.MyResource2;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) throws NoSuchMethodException {
        Father a = new Father();
        Father b = new Father();
        String name = (String)a.name;
        b.name = name;

        ArrayList<Object> objects = new ArrayList<>();
//
//
//        Class<Demo> demoClass = Demo.class;
//        Method method = demoClass.getMethod("");
//        Annotation annotation = method.getAnnotation(Override.class);
//        Runnable r = () ->{
//            System.out.println(123);
//        };
//        Thread t = new Thread(r);
    }
}

