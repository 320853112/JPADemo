package com.xu.observeDesign;

public interface Subject {
    void registerObserver(Observer o);
    void notifyObservers(String word);
}
