package com.xu.observePattern.observerImpl;

import com.xu.observePattern.Observer;

public class ObserverTree implements Observer {
    @Override
    public void notify(String word) {
        if(word != null && word.contains("tree")){
            System.out.println("treeObserver get "+word);
        }
    }
}
