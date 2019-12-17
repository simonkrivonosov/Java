package ru.sberbank.company;

class Calculator implements Calculable {

    @Override
    public void calculate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Unexpected interruption");
        }
    }
}
