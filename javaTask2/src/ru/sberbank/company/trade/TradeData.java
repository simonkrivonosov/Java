package ru.sberbank.company.trade;

public class TradeData {
    private final double price;
    private final String type;

    public TradeData(double price, String type) {
        this.price = price;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

}
