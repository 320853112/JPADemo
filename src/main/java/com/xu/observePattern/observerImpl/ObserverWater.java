package com.xu.observePattern.observerImpl;

import com.xu.observePattern.Observer;

public class ObserverWater implements Observer {
    @Override
    public void notify(String word) {
        if(word != null && word.contains("water")){
            System.out.println("waterObserver get "+word);
        }
    }
}
