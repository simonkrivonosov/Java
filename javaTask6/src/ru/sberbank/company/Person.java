package ru.sberbank.company;

import java.util.List;

public class Person {

    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;
    private final List<String> phoneNumbers;


    public Person(String firstName, String secondName, int age, Address address, List<String> phoneNumbers) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
        this.phoneNumbers = phoneNumbers;

    }
}
