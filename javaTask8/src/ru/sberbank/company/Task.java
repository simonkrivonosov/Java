package ru.sberbank.company;

import java.util.concurrent.Callable;

public class Task<T> {
    private final Callable<? extends T> callable;
    private T result;
    private RuntimeException exception;
    private volatile boolean finished = false;


    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }

    public T get() {
        if(!finished) {
            synchronized (this) {
                if (!finished) {
                    try {
                        result = callable.call();// alien method
                    } catch (Exception e) {
                        exception = new CallableRuntimeException("Exception caused by callable.call()");
                    } finally {
                        finished = true;
                    }
                }
            }
        }
        if(exception != null) throw exception;
        return result;
    }
}
