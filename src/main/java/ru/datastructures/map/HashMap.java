package ru.datastructures.map;

public class HashMap<K, V> implements Map<K, V> {

    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE / 2;
    private static final int DEFAULT_CAPACITY = 16;
    private double loadFactor;
    private int capacity;
    private int fullBuckets;
    private int size;
    private int threshold;
    private Entry<K, V>[] table;

    public HashMap(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.loadFactor = loadFactor;
        this.threshold = (int) (capacity * loadFactor);
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = (int) (capacity * loadFactor);
    }

    public HashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.table = new Entry[capacity];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = (int) (capacity * loadFactor);
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public V put(K key, V value) {
        resizeIfNecessary();
        size++;

        if (isNullKey(key)) {
            putForNullKey(value);
        } else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, table.length);

            if (isNewBucket(index)) {
                fullBuckets++;
            }

            Entry<K, V> entry = checkExistingEntry(index, hash, key);

            if (!isNullEntry(entry)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            } else {
                addEntry(key, value, hash, index);
            }
        }
        return null;
    }

    private void resizeIfNecessary() {
        if (fullBuckets > threshold) {
            resize(capacity * 2);
        }
    }

    private void resize(int newCapacity) {
        if (table.length == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry<K, V>[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    private void transfer(Entry[] newTable) {
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            if (!(isNullEntry(entry))) {
                int index = indexFor(entry.hash, newTable.length);
                newTable[index] = entry;
            }
        }
    }

    private void putForNullKey(V value) {
        if (isNewBucket(0)) {
            fullBuckets++;
        }
        Entry<K, V> entry = checkExistingEntryWithNullKey();
        if (!isNullEntry(entry)) {
            entry.value = value;
        } else {
            addEntry(null, value, 0, 0);
        }
    }

    private void addEntry(K key, V value, int hash, int index) {
        Entry<K, V> entry = table[index];
        table[index] = new Entry(key, value, hash, entry);
    }

    @Override
    public V get(Object key) {
        Entry<K, V> entry;
        if (isNullKey(key)) {
            entry = checkExistingEntryWithNullKey();
        } else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, table.length);
            entry = checkExistingEntry(index, hash, key);
        }
        if (!isNullEntry(entry)) {
            return entry.value;
        }
        return null;
    }

    private Entry checkExistingEntry(int index, int hash, Object key) {
        Entry<K, V> entry = table[index];

        if (!isNullEntry(entry)) {
            do {
                if (entry.containsByHashAndValue(key, hash)) {
                    return entry;
                }
                entry = entry.next;
            }
            while (entry.next != null);
        }
        return null;
    }

    private Entry checkExistingEntryWithNullKey() {
        Entry<K, V> entry = table[0];

        if (!isNullEntry(entry)) {
            do {
                if (isNullKey(entry.key)) {
                    return entry;
                }
                entry = entry.next;
            }
            while (entry.next != null);
        }
        return null;
    }

    @Override
    public void clear() {
        table = new Entry[DEFAULT_CAPACITY];
        fullBuckets = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V remove(Object key) {
        int index;

        if (isNullKey(key)) {
            index = 0;
        } else {
            int hash = hash(key.hashCode());
            index = indexFor(hash, table.length);
        }
        Entry<K, V> entry = table[index];
        Entry<K, V> previousEntry = null;

        if (!isNullEntry(entry)) {
            size--;

            if (isNullEntry(entry.next)) {
                fullBuckets--;
                V value = entry.value;
                table[index] = null;
                return value;
            }
            do {
                if (entry.containsByKey(key)) {
                    if (isNullEntry(previousEntry)) {
                        table[index] = entry.next;
                    } else {
                        previousEntry.next = entry.next;
                        V value = entry.value;
                        return value;
                    }
                }
                previousEntry = entry;
                entry = entry.next;
            } while (isNullEntry(entry.next));
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        Entry<K, V> entry;
        if (isNullKey(key)) {
            entry = table[0];
        } else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, table.length);
            entry = table[index];
        }

        if (isNullEntry(entry)) {
            return false;
        }

        if (isNullEntry(entry.next)) {
            return (entry.key == key);
        }

        do {
            if (key.equals(entry.key) || (entry.key == key)) {
                return true;
            }
            entry = entry.next;
        } while (!isNullEntry(entry.next));
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < capacity; i++) {
            if (!isNewBucket(i)) {
                Entry<K, V> entry = table[i];

                if (isNullEntry(entry.next)) {
                    if (entry.containsByValue(value)) {
                        return true;
                    }
                }
                do {
                    if (entry.containsByValue(value)) {
                        return true;
                    }
                } while (entry.next != null);
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof HashMap)) {
            return false;
        }
        HashMap map = (HashMap) o;
        return ((map.hashCode() == hashCode()) && (table.equals(map.table)) && (threshold == map.threshold));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(loadFactor);
        result = 31 * result + Integer.hashCode(capacity);
        result = 31 * result + Integer.hashCode(fullBuckets);
        result = 31 * result + Integer.hashCode(threshold);
        result = 31 * result + table.hashCode();
        return result;
    }

    private int indexFor(int hash, int length) {
        return hash % length;
    }

    private int hash(int hashCode) {
        int index = (hashCode & Integer.MAX_VALUE);
        return index;
    }

    private boolean isNullKey(Object key) {
        if (key == null) {
            return true;
        }
        return false;
    }

    private boolean isNullEntry(Entry entry) {
        if (entry == null) {
            return true;
        }
        return false;
    }

    private boolean isNewBucket(int index) {
        if (table[index] == null) {
            return true;
        }
        return false;
    }
}
