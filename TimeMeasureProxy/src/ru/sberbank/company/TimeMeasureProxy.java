package ru.sberbank.company;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

public class TimeMeasureProxy implements InvocationHandler {

    private final Object delegate;

    TimeMeasureProxy(Object delegate) {
        this.delegate = delegate;
    }

    public static <T> T create(T delegate) {
        return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                delegate.getClass().getInterfaces(),
                new TimeMeasureProxy(delegate));
    }
    // may be we should add interfaces of all superclasses in some case

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(delegate, objects);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        return result;
    }
}