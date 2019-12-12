package ru.sberbank.company.serializer;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SerializationUtils {

    public static Map<String, Object> getDeclaredFields(Object obj) {

        Map<String, Object> declaredFieldsMap = new HashMap<>();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                declaredFieldsMap.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Unable access to field");
            }
        }
        return declaredFieldsMap;
    }

    public static String shiftBlockPartially(String s, int indent) {
        return s.replaceAll("\n", "\n" + " ".repeat(indent));
    }

    public static String shiftBlock(String s, int indent) {
        return " ".repeat(indent) + shiftBlockPartially(s, indent);
    }
}
