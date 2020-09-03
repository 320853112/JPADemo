package com.xu.observePattern;

import com.xu.observePattern.observerImpl.ObserverMoney;
import com.xu.observePattern.observerImpl.ObserverTree;
import com.xu.observePattern.observerImpl.ObserverWater;

public class Main {
    public static void main(String[] args) {
        Subject s = new Spokesman();
        Observer o1 = new ObserverMoney();
        Observer o2 = new ObserverTree();
        Observer o3 = new ObserverWater();
        s.registerObserver(o1);
        s.registerObserver(o2);
        s.registerObserver(o3);
        s.notifyObservers("a big tree ");
    }
}
