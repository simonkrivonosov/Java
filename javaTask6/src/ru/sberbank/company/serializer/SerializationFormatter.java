package ru.sberbank.company.serializer;

import java.util.List;
import java.util.Map;

public interface SerializationFormatter {

    String formatMap(Map<String, String> keyToElement);

    String formatList(List<String> elements);

    String formatPrimitive(Object obj);

    String getFormatBody(Object obj, String body);
}
