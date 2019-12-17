package ru.sberbank.company;

import ru.sberbank.company.serializer.ObjectSerializer;
import ru.sberbank.company.serializer.formatters.JSONSerializationFormatter;
import ru.sberbank.company.serializer.formatters.XMLSerializationFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;




public class Main {

    public static void main(String[] args) {

        List<String> phoneNumbers = new ArrayList<>(Arrays.asList("89115002030", "89155678090"));
        Person person = new Person("Semen", "Petrov", 10, new Address("Moscow", "100111"), phoneNumbers);

//        Serializer jsonSerializer = new ObjectSerializer(new JSONSerializationFormatter());
//        jsonSerializer.serialize(person);
        Serializer xmlSerializer = new ObjectSerializer(new XMLSerializationFormatter());
        System.out.println(xmlSerializer.serialize(person));
    }

}
