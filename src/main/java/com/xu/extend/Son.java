package com.xu.extend;

public class Son extends Father{
    @Override
    public void method() {
        System.out.println("son");
    }

    public Son() {
        System.out.println("son create");
    }
}
