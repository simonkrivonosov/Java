package ru.sberbank.company;

public class Semaphore {

    private final int maxThreadCount;
    private int currentThreadCount;

    public Semaphore(int maxThreadCount) {
        this.currentThreadCount = 0;
        this.maxThreadCount = maxThreadCount;
    }

    public synchronized void lock() {
        while (this.currentThreadCount >= this.maxThreadCount) {
            await();
        }
        this.currentThreadCount++;
    }

    public synchronized void unlock() {
        this.currentThreadCount--;
        this.notify();
    }

    private void await() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
