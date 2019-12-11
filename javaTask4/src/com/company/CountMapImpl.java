package com.company;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<K> implements CountMap<K> {

    private Map<K, Integer> map;

    public CountMapImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public void add(K key) {
        if (!this.map.containsKey(key)) {
            this.map.put(key, 0);
        }
        map.put(key, this.map.get(key) + 1);
    }

    private void add(K key, int count) {
        if (!map.containsKey(key)) {
            map.put(key, 0);
        }
        map.put(key, map.get(key) + count);
    }

    @Override
    public int getCount(K key) {
        Integer count = this.map.get(key);
        return count != null  ? count : 0;
    }

    @Override
    public int remove(K key) {
        int count = getCount(key);
        if(count > 1) {
            this.map.put(key, this.map.get(key) - 1);
        }
        else if(count == 1) {
            this.map.remove(key);
        }
        return count;
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public void addAll(CountMap<? extends K> source) {
        Map<? extends K, ? extends Integer> sourceMap = source.toMap();
        for (Map.Entry<? extends K, ? extends Integer> entry : sourceMap.entrySet()) {
            this.map.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
    }

    @Override
    public Map<K, Integer> toMap() {
        return new HashMap<>(this.map);
    }

    @Override
    public void toMap(Map<? super K, ? super Integer> destination) {
        destination.putAll(this.map);
    }

}

