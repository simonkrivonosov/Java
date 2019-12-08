package ru.sberbank.company;

public class OpenAddressingHashTable<K, V> {

    private HashTableEntry<K, V>[] container;
    //if we use HashTableEntry<?, ?>[] there is no warning in constructor
    private int size;
    private int capacity;
    final private double loadFactor;
    final private int multiplier;

    private static final  int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_MULTIPLIER = 2;



    public OpenAddressingHashTable(int capacity, double loadFactor, int multiplier) {
        this.size = 0;
        this.capacity = capacity;
        this.container =  (HashTableEntry<K, V>[]) new HashTableEntry[this.capacity];
        this.loadFactor = loadFactor;
        this.multiplier = multiplier;
    }

    public OpenAddressingHashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_MULTIPLIER);
    }

    //линейное пробирование
    V put(K key, V value) {
        int load = (int) (this.loadFactor * this.capacity);
        if(this.size == load){
            resize();
        }
        int index = index(key);
        for(int j = 0; j < this.capacity; j++) {
            if(this.container[(index + j) % this.capacity] == null) {
                this.container[(index + j) % this.capacity] = new HashTableEntry<>(key, value);
                this.size++;
                return null;
            }
            else if(this.container[(index + j) % this.capacity].getKey().equals(key)
                    || this.container[(index + j) % this.capacity].isDeleted()) {
                V previousValue = this.container[(index + j) % this.capacity].getValue();
                this.container[(index + j) % this.capacity].setValue(value);
                return this.container[(index + j) % this.capacity].isDeleted() ? previousValue : null;
            }
        }
        return null;
    }

    public V remove(K key) {
        int index = getIndexNotDeleted(key);
        if (index != -1) {
            this.size--;
            container[index].setDeleted(true);
            return container[index].getValue();
        }
        return null;
    }

    private int getIndexNotDeleted(K key) {
        int index = key.hashCode();
        int j = 0;
        while (this.container[(index + j) % this.capacity] != null && j < this.capacity) {
            if(this.container[(index + j) % this.capacity].getKey().equals(key)
                    && !this.container[(index + j) % this.capacity].isDeleted())
                return (index + j) % this.capacity;
            j++;
        }
        return -1;
    }

    private int index(K key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }


    private void resize() {
        HashTableEntry<K, V>[] tempContainer = this.container.clone();
        this.capacity *= multiplier;
        this.container =  (HashTableEntry<K, V>[]) new HashTableEntry[this.capacity];
        this.size = 0;
        for (HashTableEntry<K, V> entry : tempContainer) {
            if (entry != null && !entry.isDeleted()) {
                put(entry.getKey(), entry.getValue());
            }
        }

    }

    public int size() {
        return this.size;
    }

    public boolean contains(K key) {
        return getIndexNotDeleted(key) != -1;
    }

    public V get(K key) {
        int j = getIndexNotDeleted(key);
        if(j != -1){
            return this.container[j].getValue();
        }
        return null;
    }

}
