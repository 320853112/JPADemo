package com.xu.chainOfResponsibilityPattern;

public class HeaderTextProcessing extends ProcessingObject<String>{

    @Override
    protected String handleWork(String text) {
        return "xuhang say " +text;
    }
}
