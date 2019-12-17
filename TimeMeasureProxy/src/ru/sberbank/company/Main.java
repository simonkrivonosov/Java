package ru.sberbank.company;

public class Main {

    public static void main(String[] args) {
        Calculable calculator = TimeMeasureProxy.create(new Calculator());
        calculator.calculate();
    }
}
