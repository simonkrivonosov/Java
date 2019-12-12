package ru.sberbank.company.serializer.formatters;

import ru.sberbank.company.serializer.SerializationFormatter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.sberbank.company.serializer.SerializationUtils.shiftBlock;


public class XMLSerializationFormatter implements SerializationFormatter {
    private static final int INDENT= 4;

    @Override
    public String formatMap(Map<String, String> keyToElement) {
        return keyToElement.entrySet()
                .stream()
                .map(entry -> combineKeyValue(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String formatList(List<String> elements) {
        return elements.stream()
                .map(e -> combineKeyValue("element", e))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String formatPrimitive(Object obj) {
        return obj != null ? obj.toString() : "";
    }

    @Override
    public String getFormatBody(Object obj, String body) {
        return combineKeyValue(obj.getClass().getName(), body);
    }

    private String combineKeyValue(String key, String value) {
        String body;
        if (value.contains("<")) {
            body = "\n" + shiftBlock(value, INDENT) + "\n";
        } else {
            body = value;
        }
        return "<" + key+ ">" + body + "</" + key + ">";
    }

}