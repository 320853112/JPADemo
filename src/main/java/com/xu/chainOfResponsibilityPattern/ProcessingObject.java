package com.xu.chainOfResponsibilityPattern;

public abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;

    protected void setSuccessor(ProcessingObject<T> successor ){
        this.successor = successor;
    }

    abstract protected T handleWork(T input);

    public T handle (T input){
        T r = handleWork(input);
        if(successor != null){
            return successor.handle(r);
        }
        return r;
    }

}
