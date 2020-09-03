package com.xu.chainOfResponsibilityPattern;


public class SpellCheckerProcessing extends ProcessingObject<String>{
    @Override
    protected String handleWork(String text) {
        return text.replace("123","456");
    }
}
