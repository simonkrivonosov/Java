package ru.sberbank.company.trade.types;

import ru.sberbank.company.trade.TradeType;

public class FxSpot implements TradeType {
    private final double price;

    public FxSpot(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String toString() {
        return "FX_SPOT{price = " + this.price + "}";
    }
}
