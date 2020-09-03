package com.xu.observePattern;

import java.util.ArrayList;
import java.util.List;

public class Spokesman implements Subject{

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String word) {
        for (Observer observer : observers) {
            observer.notify(word);
        }
    }
}
