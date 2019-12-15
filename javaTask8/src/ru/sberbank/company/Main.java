package ru.sberbank.company;

public class Main {
    public void run() {

    }

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        Task<String> task = new Task<>(myCallable);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(task.get());
            }).start();
        }
    }
}
