package ru.datastructures.queue;

import java.util.Iterator;

public class MyQueue implements Queue {

    private QueueElement head;
    private int size;

    @Override
    public void push(Object o) {
        QueueElement queueElement = new QueueElement(o);
        if (head == null) {
            head = queueElement;
        } else {
            QueueElement a;
            a = head;
            while (a.next != null) {
                a = a.next;
            }
            a.next = queueElement;
        }
        size++;
    }

    @Override
    public Object pull() {
        if (head == null) {
            return null;
        } else {
            QueueElement firstElement = head;
            removeFirstElement();
            return firstElement.value;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {

        Iterator it = new Iterator() {
            QueueElement a = head;

            @Override
            public boolean hasNext() {
                if (a != null) {
                    return true;
                } else return false;
            }

            @Override
            public Object next() {
                QueueElement element = a;
                a = a.next;
                return element.value;
            }
        };
        return it;
    }

    @Override
    public boolean removeElement(Object o) {
        if (!isEmpty()) {
            if (head.value.equals(o)) {
                removeFirstElement();
                return true;
            }
            QueueElement a = head;
            while (a.next != null) {
                if (a.next.value.equals(o)) {
                    remove(a);
                    return true;
                }
                a = a.next;
            }
            return false;
        } else {
            throw new IllegalStateException("Очередь пуста");
        }
    }

    private void removeFirstElement() {
        if (head.next == null) {
            head = null;

        } else {
            head = head.next;
        }
        size--;
    }

    private void remove(QueueElement a) {
       a.next = a.next.next;
    }

    private void removeLastElement(QueueElement a) {
        a = null;
        size--;
    }

    @Override
    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }
}
