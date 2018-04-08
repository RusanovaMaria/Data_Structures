package ru.datastructures.set;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.Arrays;
import java.util.Iterator;

public class MySet {

    private Object[] set;
    private int lastIndex;
    private int capacity;

    public MySet() {
        capacity = 10;
        set = new Object[capacity];
    }

    public MySet(int capacity) {
        this.capacity = capacity;
        set = new Object[capacity];
    }

    public void add(Object object) {
        if (!contains(object)) {
            addElement(object);
        } else {
            throw new InvalidDnDOperationException("Данный объект уже присутствует во множестве");
        }
    }

    public void addRange(Object... objects) {
        for (Object object : objects) {
            if (!contains(object)) {
                addElement(object);
            } else {
                throw new InvalidDnDOperationException("Данный объект уже присутствует во множестве");
            }
        }
    }

    public boolean contains(Object object) {
        for (int i = 0; i < lastIndex; i++) {
            if (set[i] == object) return true;
        }
        return false;
    }

    private void addElement(Object object) {
        if (isEnoughtCapacity()) {
            set[lastIndex] = object;
            lastIndex++;
        } else {
            capacity = calculateNewCapacity();
            set = Arrays.copyOf(set, capacity);
            set[lastIndex] = object;
            lastIndex++;
        }
    }

    private boolean isEnoughtCapacity() {
        if (lastIndex < capacity) {
            return true;
        }
        return false;
    }

    private int calculateNewCapacity() {
        return (capacity + 2) * 2;
    }

    public boolean remove(Object object) {
        for (int i = 0; i < lastIndex; i++) {
            if (set[i] == object) {
                for (int j = i; j < lastIndex - 1; j++) {
                    set[j] = set[j + 1];
                }
                lastIndex--;
                return true;
            }
        }

        return false;
    }

    public int size() {
        return lastIndex;
    }

    public boolean isEmpty() {
        if (lastIndex == 0) return true;
        else return false;
    }

    public void clear() {
        capacity = 0;
        set = new Object[capacity];
        lastIndex = 0;
    }

    public MySet clone() {
        MySet newSet = new MySet();

        Iterator iterator = this.iterator();

        while (iterator.hasNext()) {
            newSet.add(iterator.next());
        }
        return newSet;
    }

    public boolean intersection(MySet newSet) {
        boolean isIntersection = false;

        Iterator iterator = newSet.iterator();

        while (iterator.hasNext()) {
            for (Object object : set) {
                if (object == iterator.next()) {
                    isIntersection = true;
                    break;
                }
            }
        }
        return isIntersection;
    }

    public boolean inclusion(MySet newSet) {
        boolean isInclution = true;

        Iterator iterator = newSet.iterator();

        while (iterator.hasNext()) {
            for (Object object : set) {
                if (object != iterator.next()) {
                    isInclution = false;
                    break;
                }
            }
        }
        return isInclution;
    }

    public void difference(MySet newSet) {

        Iterator iterator = newSet.iterator();

        while (iterator.hasNext()) {
            Object object = iterator.next();
            for (int i = 0; i < lastIndex; i++) {
                if (set[i] == object) {
                    this.remove(set[i]);
                }
            }
        }
    }

    public void union(MySet newSet) {

        Iterator iterator = newSet.iterator();

        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
    }

    public Iterator iterator() {

        Iterator it = new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index < lastIndex) {
                    return true;
                } else return false;
            }

            @Override
            public Object next() {
                Object object = set[index];
                index++;

                return object;
            }
        };
        return it;
    }
}
