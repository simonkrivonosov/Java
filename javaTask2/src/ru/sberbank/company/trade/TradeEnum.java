package ru.sberbank.company.trade;

import ru.sberbank.company.trade.types.Bond;
import ru.sberbank.company.trade.types.CommoditySpot;
import ru.sberbank.company.trade.types.FxSpot;
import ru.sberbank.company.trade.types.IrSwap;

public enum TradeEnum {

    FX_SPOT {
        public TradeType createTrade(double price) {
            return new FxSpot(price);
        }
    },

    COMMODITY_SPOT {
        @Override
        public TradeType createTrade(double price) {
            return new CommoditySpot(price);
        }
    },

    BOND {
        @Override
        public TradeType createTrade(double price) {
            return new Bond(price);
        }
    },

    IR_SWAP {
        @Override
        public TradeType createTrade(double price) {
            return new IrSwap(price);
        }
    };



    public abstract TradeType createTrade(double price);
}
