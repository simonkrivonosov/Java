package ru.sberbank.company.serializer.formatters;

import ru.sberbank.company.serializer.SerializationFormatter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.sberbank.company.serializer.SerializationUtils.shiftBlock;
import static ru.sberbank.company.serializer.SerializationUtils.shiftBlockPartially;


public class JSONSerializationFormatter implements SerializationFormatter {

    private static final int INDENT = 4;


    @Override
    public String formatMap(Map<String, String> keyToElement) {
        List<String> mapElements = keyToElement.entrySet()
                .stream()
                .map(entry -> shiftBlock(combineKeyValue(entry.getKey(), entry.getValue()), INDENT))
                .collect(Collectors.toList());
        return "{\n" + String.join(",\n", mapElements) + "\n}";
    }

    @Override
    public String formatList(List<String> elements) {
        String delimiter = ",\n ";
        List<String> shiftedElements = elements.stream()
                .map(e -> shiftBlockPartially(e, 1))
                .collect(Collectors.toList());
        return "[" +
                String.join(delimiter, shiftedElements) +
                "]";
    }

    @Override
    public String formatPrimitive(Object obj) {
        if (obj == null) {
            return "null";
        } else {
            String s = obj.toString();
            if (obj instanceof Number || obj instanceof Boolean) {
                return s;
            } else {
                return "\"" + s + "\"";
            }
        }
    }

    @Override
    public String getFormatBody(Object obj, String body) {
        return body;
    }


    private String combineKeyValue(String key, String value) {
        String jsonKey = "\"" + key + "\": ";
        return jsonKey + shiftBlockPartially(value, jsonKey.length());
    }
}