package ru.datastructures.stack;

import java.util.Arrays;

public class MyStack {

    private int capacity;
    private Object[] stack;
    private int index;

    public MyStack() {
        capacity = 10;
        stack = new Object[capacity];
        index = 0;
    }

    public boolean empty() {
        if (index == 0) {
            return true;
        } else return false;
    }

    public Object peek() {
        return stack[index - 1];
    }

    public Object pop() {
        Object lastElement = stack[index - 1];
        index--;

        return lastElement;
    }

    public void push(Object object) {
        if (index < capacity) {
            add(object);
        } else {
            capacity = calculateNewCapacity(capacity);
            stack = Arrays.copyOf(stack, capacity);
            add(object);
        }
    }

    public void add(Object object) {
        stack[index] = object;
        index++;
    }

    private int calculateNewCapacity(int oldCapacity) {
        return oldCapacity * 2;
    }

    public int search(Object object) {
        int localIndex = index;

        for (int i = localIndex - 1; i >= 0; i++) {
            if (stack[localIndex] == object) {
                return index - localIndex;
            }
        }
        return -1;
    }
}
