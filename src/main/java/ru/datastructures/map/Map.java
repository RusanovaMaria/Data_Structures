package ru.datastructures.map;

public interface Map<K, V> {

    V put(K k, V v);

    boolean isEmpty();

    V get(Object k);

    void clear();

    int size();

    int hashCode();

    boolean equals(Object o);

    boolean containsKey(Object k);

    boolean containsValue(Object v);

    V remove(Object k);
}
