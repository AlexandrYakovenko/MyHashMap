package com.company;

/*
* Class which implements HashMap architecture.
* Is not suited for multithreading environment.
*/
public class MyHashMap {
    private static int mapSize = 100;
    private int currentSize = 0;
    private Entry[] table;
    private float loadCapacity = 0.75f;

    public MyHashMap() {
        table = new Entry[mapSize];
    }

    public MyHashMap(int size) {
        mapSize = size;
        table = new Entry[mapSize];
    }

    public MyHashMap (int size, float loadCapacity) {
        mapSize = size;
        table = new Entry[mapSize];
        this.loadCapacity = loadCapacity;
    }

    /**
     * @param key - key of entry
     * @param value - value of entry
     * @return - true on success
     */
    public boolean put(int key, long value) {
        if (currentSize == (int)(mapSize * loadCapacity)) {
            Entry[] tmpTable = new Entry[mapSize];
            System.arraycopy(table, 0, tmpTable, 0, mapSize);
            mapSize *= 2;
            table = new Entry[mapSize];
            System.arraycopy(tmpTable, 0, table, 0, mapSize / 2);
        }

        int index = new Integer(key).hashCode() % mapSize;
        if (table[index] != null) {
            if (table[index].getKey() == key) {
                table[index].setValue(value);
            } else {
                for (int i = 0; i < mapSize; i++){
                    if (table[i] == null) {
                        Entry entry = new Entry(key, value);
                        table[i] = entry;
                        currentSize++;
                        break;
                    }
                }
            }
        } else {
            Entry entry = new Entry(key, value);
            table[new Integer(key).hashCode() % mapSize] = entry;
            currentSize++;
        }

        return true;
    }

    /**
     * @param entry - Entry object to be inserted
     * @return -  true on success
     */
    public boolean put(Entry entry) {
        return put(entry.getKey(), entry.getValue());
    }

    /**
     * @param key - key of Entry
     * @return - value of Enrtry or null on fail
     */
    public Long get(int key) {
        int index = new Integer(key).hashCode() % mapSize;
        if (table[index].getKey() == key){
            return table[index].getValue();
        } else {
            for (int i = 0; i < mapSize; i++) {
                if (table[i].getKey() == key) {
                    return table[i].getValue();
                }
            }
        }
        return null;
    }

    /**
     * @return - current Size of the HashMap
     */
    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Entry e: table) {
            if (e != null) {
                result.append("[").append(e.getKey()).append(" , ").append(e.getValue()).append("]\n");
            }
        }
        return result.toString();
    }

}
