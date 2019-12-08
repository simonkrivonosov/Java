package ru.sberbank.company;


import ru.sberbank.company.trade.TradeCreator;
import ru.sberbank.company.trade.TradeData;
import ru.sberbank.company.trade.TradeDataParser;
import ru.sberbank.company.trade.TradeType;
import ru.sberbank.company.trade.creators.EnumTradeCreator;
import ru.sberbank.company.trade.creators.SwitchCaseTradeCreator;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // может получить данные с любого inputStream, например с файла или консоли
        //InputStream inputStream = System.in;
        InputStream inputStream = new FileInputStream("data/test1.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        TradeDataParser dataParser = new TradeDataParser();
        TradeData tradeData = dataParser.parseTrade(reader);

        // 1 var
        TradeCreator tradeCreator1 = new SwitchCaseTradeCreator();
        TradeType trade1 = tradeCreator1.createTrade(tradeData);
        System.out.println(trade1);

        //2 var
        TradeCreator tradeCreator2 = new EnumTradeCreator();
        TradeType trade2 = tradeCreator2.createTrade(tradeData);
        System.out.println(trade2);

    }
}
