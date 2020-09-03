package com.xu.observePattern.observerImpl;

import com.xu.observePattern.Observer;

public class ObserverMoney implements Observer {
    @Override
    public void notify(String word) {
        if(word != null && word.contains("money")){
            System.out.println("moneyObserver get "+word);
        }
    }
}
