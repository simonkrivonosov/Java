package ru.sberbank.company.serializer;

import ru.sberbank.company.Serializer;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import static ru.sberbank.company.serializer.SerializationUtils.getDeclaredFields;


public class ObjectSerializer implements Serializer {

    private final SerializationFormatter formatter;

    public ObjectSerializer(SerializationFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String serialize(Object obj) {
        return formatter.getFormatBody(obj, serializeMap(getDeclaredFields(obj)));
    }

    private String serializeCollection(Collection<?> collection) {
        List<String> serializedCollectionElements = collection
                .stream()
                .map(this::serializeObject)
                .collect(Collectors.toList());

        return formatter.formatList(serializedCollectionElements);
    }

    private String serializeMap(Map<?, ?> map) {
        Map<String, String> serializedMapElements = map.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        entry -> serializeObject(entry.getValue())));

        return formatter.formatMap(serializedMapElements);
    }

    private String serializeObject(Object obj) {
        if (obj == null) {
            return formatter.formatPrimitive(null);
        }
        Class<?> clazz = obj.getClass();

        if (Collection.class.isAssignableFrom(clazz)) {
            return serializeCollection((Collection<?>) obj);
        } else if (Map.class.isAssignableFrom(clazz)) {
            return serializeMap((Map<?, ?>) obj);
        } else if (isSimple(clazz)) {
            return formatter.formatPrimitive(obj);
        } else {
            return serializeMap(getDeclaredFields(obj));
        }

        // we cant use Strategy or ChainOfResponsibility here but it seems that no other variants could appear
    }

    private boolean isSimple(Class<?> type) {
        return type.isPrimitive() || Serializable.class.isAssignableFrom(type);
    }
}

