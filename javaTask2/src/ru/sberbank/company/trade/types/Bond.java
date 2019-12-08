package ru.sberbank.company.trade.types;

import ru.sberbank.company.trade.TradeType;

public class Bond implements TradeType {
    private final double price;

    public Bond(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String toString() {
        return "BOND{price = " + this.price + "}";
    }
}
