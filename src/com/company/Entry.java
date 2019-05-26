package com.company;

import java.util.Objects;

public class Entry {

    private int key;
    private long value;

    public Entry(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() { return key; }

    public void setKey(int key) { this.key = key; }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return key == entry.key &&
                value == entry.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

}


