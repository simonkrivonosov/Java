package ru.sberbank.company.trade.types;

import ru.sberbank.company.trade.TradeType;

public class CommoditySpot implements TradeType {
    private final double price;

    public CommoditySpot(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String toString() {
        return "COMMODITY_SPOT{price = " + this.price + "}";
    }
}
