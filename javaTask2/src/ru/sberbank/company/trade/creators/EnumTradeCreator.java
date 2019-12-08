package ru.sberbank.company.trade.creators;

import ru.sberbank.company.trade.TradeCreator;
import ru.sberbank.company.trade.TradeData;
import ru.sberbank.company.trade.TradeEnum;
import ru.sberbank.company.trade.TradeType;

public class EnumTradeCreator implements TradeCreator {
    @Override
    public TradeType createTrade(TradeData tradeData) {
        return TradeEnum.valueOf(tradeData.getType()).createTrade(tradeData.getPrice());
    }
}
