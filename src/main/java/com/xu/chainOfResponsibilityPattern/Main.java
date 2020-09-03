package com.xu.chainOfResponsibilityPattern;

public class Main {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String res = p1.handle("345+111 = 123");
        System.out.println(res);
    }
}
