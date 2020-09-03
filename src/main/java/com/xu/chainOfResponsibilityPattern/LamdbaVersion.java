package com.xu.chainOfResponsibilityPattern;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LamdbaVersion {
    public static void main(String[] args) {
        UnaryOperator<String>  headerProcessing = (String text) -> "xuhang say " +text;
        UnaryOperator<String>  spellCheckerProcessing = (String text) -> text.replace("123","456");
        Function<String,String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
        String res = pipeline.apply("345+111 = 123");
        System.out.println(res);
        UnaryOperator<Object> identity = UnaryOperator.identity();
    }
}
