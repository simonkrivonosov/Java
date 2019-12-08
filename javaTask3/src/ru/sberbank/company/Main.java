package ru.sberbank.company;

public class Main {

    public static void main(String[] args) {
        OpenAddressingHashTable<String, Integer> hashTable = new OpenAddressingHashTable<>();
        hashTable.put("Dog", 2);
        hashTable.put("Dog", 3);
        for (int i = 0; i < 20; i++) {
            hashTable.put("i=" + i, i);
        }
        System.out.println(hashTable.contains("Cat"));
        System.out.println(hashTable.get("Dog"));
        System.out.println(hashTable.size());
    }
}
