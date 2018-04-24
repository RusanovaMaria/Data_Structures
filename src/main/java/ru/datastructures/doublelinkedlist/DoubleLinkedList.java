package ru.datastructures.doublelinkedlist;

public class DoubleLinkedList {

    private ListElement head;
    private ListElement tail;

    public DoubleLinkedList() {

        head = null;
        tail = null;
    }

    public void addFirst(int data) {

        ListElement a = new ListElement(data);

        a.next = head;
        head = a;

        if (tail == null) {
            tail = a;
        }
    }

    public ListElement removeFirst() {

        ListElement a = head;
        head = head.next;

        if (head == null) {

            tail = null;

        } else {

            head.previous = null;
        }

        return a;
    }

    public void addLast(int data) {

        ListElement a = new ListElement(data);

        if (tail == null) {

            head = a;
            tail = a;

        } else {

            tail.next = a;
            a.previous = tail;
            tail = a;
        }
    }

    public ListElement removeLast() {

        ListElement a = tail;

        tail = tail.previous;

        if (tail == null) {

            head = null;

        } else {

            tail.next = null;
        }

        return a;
    }
}
