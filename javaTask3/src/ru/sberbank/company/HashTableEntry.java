package ru.sberbank.company;

public class HashTableEntry<K, V> {
    private final K key;
    private V value;
    private boolean deleted;

    public HashTableEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
