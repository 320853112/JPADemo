package com.xu.observeDesign.observerImpl;

import com.xu.observeDesign.Observer;

public class ObserverTree implements Observer {
    @Override
    public void notify(String word) {
        if(word != null && word.contains("tree")){
            System.out.println("treeObserver get "+word);
        }
    }
}
