package ru.sberbank.company;


public class Address {
    private final String postalCode;
    private final String city;

    public Address(String city, String postalCode) {
        this.city = city;
        this.postalCode = postalCode;
    }
}
