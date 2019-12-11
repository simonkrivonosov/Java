package com.company;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        CountMap<String> map = createMap();
        System.out.println(map.getCount("Cat"));
        System.out.println(map.getCount("Turtle"));
        System.out.println(map.remove("Cat"));
        System.out.println(map.size());
        CountMap<String> map2 = createMap();

        map.addAll(map2);

        Map<String, Integer> asMap = map.toMap();

        System.out.println(asMap);
    }

    private static CountMap<String> createMap() {
        CountMap<String> map = new CountMapImpl<>();
        map.add("Dog");
        map.add("Cat");
        map.add("Turtle");
        map.add("Turtle");
        map.add("Cat");
        map.add("Turtle");

        return map;
    }
}
