package ru.sberbank.company;

public class Main {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(4);
        for (int i = 0; i < 20; ++i) {
            new Thread(() -> {
                long id = Thread.currentThread().getId();
                semaphore.lock();
                System.out.println(id);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.unlock();
            }).start();
        }

        final Barrier barrier = new Barrier(4);
        for (int i = 0; i < 4; ++i) {
            new Thread(() -> {
                long id = Thread.currentThread().getId();
                System.out.println("firstly id = " + id);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                barrier.await();
                System.out.println("in the end id = " + id);
            }).start();
        }


    }
}
