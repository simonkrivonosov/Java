package ru.sberbank.company.trade.types;

import ru.sberbank.company.trade.TradeType;

public class IrSwap implements TradeType {
    private final double price;

    public IrSwap(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String toString() {
        return "IR_SWAP{price = " + this.price + "}";
    }
}
