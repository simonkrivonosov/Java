package ru.sberbank.company;

public class Barrier {

    private final int maxThreadCount;
    private int currentThreadCount;

    public Barrier(int maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
        this.currentThreadCount = 0;
    }

    public synchronized void await() {
        this.currentThreadCount++;
        if (this.currentThreadCount >= this.maxThreadCount) {
            notifyAll();
            return;
        }
        while (this.currentThreadCount < this.maxThreadCount) {
            sleep();
        }
    }

    private void sleep() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
