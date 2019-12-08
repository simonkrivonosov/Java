package ru.sberbank.company.trade;

import java.io.BufferedReader;
import java.io.IOException;
import java.rmi.server.ExportException;

public class TradeDataParser {

    public TradeData parseTrade(BufferedReader reader) throws IOException {

            reader.readLine();

            String line = reader.readLine();
            String type = getType(line);

            line = reader.readLine();
            double price = getPrice(line);

            reader.close();

            return new TradeData(price, type);
    }

    private double getPrice(String line) {

        int firstBracket = line.indexOf("{");
        int lastBracket = line.indexOf("}");
        return Double.parseDouble(line.substring(firstBracket + 1, lastBracket));
    }

    private String getType(String line) {

        int firstBracket = line.indexOf("{");
        int lastBracket = line.indexOf("}");
        return line.substring(firstBracket + 1, lastBracket);
    }

}
