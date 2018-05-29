package ru.datastructures.map;

public class Entry<K, V> {

    K key;
    V value;
    int hash;
    Entry next;

   public Entry(K key, V value, int hash, Entry next) {
       this.key = key;
       this.value = value;
       this.hash = hash;
       this.next = next;
   }

   boolean containsByHashAndKey(Object key, int hash) {
       if (this.hash == hash && (this.key == key || key.equals(this.key))) {
           return true;
       }
       return false;
   }

   boolean containsByValue(Object value) {
       if ((this.value == value) || (this.value.equals(value))) {
           return true;
       }
       return false;
   }

   boolean containsByKey(Object key) {
       if (key.equals(this.key) || (this.key == key)) {
           return true;
       }
       return false;
   }
}
