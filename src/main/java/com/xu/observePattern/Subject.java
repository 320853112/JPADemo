package com.xu.observePattern;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String word);
}
