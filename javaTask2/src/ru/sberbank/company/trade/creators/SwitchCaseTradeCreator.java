package ru.sberbank.company.trade.creators;

import ru.sberbank.company.trade.TradeCreator;
import ru.sberbank.company.trade.TradeData;
import ru.sberbank.company.trade.TradeType;
import ru.sberbank.company.trade.types.Bond;
import ru.sberbank.company.trade.types.CommoditySpot;
import ru.sberbank.company.trade.types.FxSpot;
import ru.sberbank.company.trade.types.IrSwap;

public class SwitchCaseTradeCreator implements TradeCreator {

    @Override
    public TradeType createTrade(TradeData tradeData) {
        switch (tradeData.getType()) {
            case ("FX_SPOT"):
                return new FxSpot(tradeData.getPrice());
            case("BOND"):
                return new Bond(tradeData.getPrice());
            case("IR_SWAP"):
                return new IrSwap(tradeData.getPrice());
            case("COMMODITY_SPOT"):
                return new CommoditySpot(tradeData.getPrice());
            default:
                throw new IllegalStateException("Unexpected type of trade" + tradeData.getType());
        }
    }
}
