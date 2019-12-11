package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        CollectionUtils.add(list, "test");
        System.out.println(list);
    }
}
