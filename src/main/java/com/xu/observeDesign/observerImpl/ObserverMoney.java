package com.xu.observeDesign.observerImpl;

import com.xu.observeDesign.Observer;

public class ObserverMoney implements Observer {
    @Override
    public void notify(String word) {
        if(word != null && word.contains("money")){
            System.out.println("moneyObserver get "+word);
        }
    }
}
