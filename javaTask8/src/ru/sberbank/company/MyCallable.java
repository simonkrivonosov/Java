package ru.sberbank.company;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "OK";
    }
}
