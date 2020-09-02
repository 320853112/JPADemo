package com.xu.observeDesign.observerImpl;

import com.xu.observeDesign.Observer;

public class ObserverWater implements Observer {
    @Override
    public void notify(String word) {
        if(word != null && word.contains("water")){
            System.out.println("waterObserver get "+word);
        }
    }
}
