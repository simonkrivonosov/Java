package com.company;

import java.util.Map;

public interface CountMap<K> {

    void add(K key);

    int getCount(K key);

    int remove(K key);

    int size();

    void addAll(CountMap<? extends K> source);

    Map<K, Integer> toMap();

    public void toMap(Map<? super K, ? super Integer> destination);
}
