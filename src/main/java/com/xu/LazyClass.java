package com.xu;

import java.util.LinkedList;

public class LazyClass {
    public static void main(String[] args) {
        System.out.println(12%5);
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        for (Object o : linkedList.subList(1,5)) {
            System.out.println(o);
        }
//        0,501

    }
}
