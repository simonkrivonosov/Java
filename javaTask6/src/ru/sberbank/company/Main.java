package ru.sberbank.company;

import ru.sberbank.company.serializer.ObjectSerializer;
import ru.sberbank.company.serializer.formatters.JSONSerializationFormatter;
import ru.sberbank.company.serializer.formatters.XMLSerializationFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;




public class Main {

    public static void main(String[] args) {

        List<Hand> hands = Arrays.asList(new Hand("left"), new Hand("right"));
        Doctor doctor3 = new Doctor("Richard", 3, null, null, null, hands);
        Doctor doctor2 = new Doctor("John", 2, null, Arrays.asList("1wdcsadcsadc", "2asdcasdcasdc", "3casdcasdcasc"), Map.of(doctor3, doctor3), hands);
        Doctor doctor = new Doctor("Alex", 4, null, Arrays.asList(1, 2, 3), null, hands);

        Serializer jsonRecursiveSerializer = new ObjectSerializer(new JSONSerializationFormatter());
        System.out.println(jsonRecursiveSerializer.serialize(doctor2));

        Serializer xmlRecursiveSerializer = new ObjectSerializer(new XMLSerializationFormatter());
        System.out.println(xmlRecursiveSerializer.serialize(doctor));
    }
}
class Hand {
    private final String type;

    Hand(String type) {
        this.type = type;
    }

}
