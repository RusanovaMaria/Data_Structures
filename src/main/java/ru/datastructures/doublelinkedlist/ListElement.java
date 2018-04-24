package ru.datastructures.doublelinkedlist;

public class ListElement {

    int value;
    ListElement next;
    ListElement previous;

    public ListElement() {

        this.next = null;
        this.previous = null;
    }

    public ListElement(int data) {

        this.next = null;
        this.previous = null;
        this.value = data;
    }
}
