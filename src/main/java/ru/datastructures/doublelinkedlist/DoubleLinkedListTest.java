package ru.datastructures.doublelinkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    @Test
    public void testAddFirst_whenAddFewElements_returnLastElement() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.addFirst(3);

        assertEquals(2, doubleLinkedList.removeLast().value);
    }

    @Test
    public void testAddFirst_whenAddOneElement_returnLastElement() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(2);

        assertEquals(2, doubleLinkedList.removeLast().value);
    }

    @Test
    public void testAddFirst_whenAddOneElement_returnFirstElement() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(2);

        assertEquals(2, doubleLinkedList.removeFirst().value);
    }

    @Test
    public void testRemoveFirst_whenAddFewElementsFirstAndLast_returnFirstElement() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addLast(5);

        assertEquals(2, doubleLinkedList.removeFirst().value);
    }

    @Test
    public void testRemoveFirst_whenAddOneLastElement_returnFirstElement() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(5);

        assertEquals(5, doubleLinkedList.removeFirst().value);
    }

    @Test
    public void testAddLast_whenAddFewElements_returnLastElement() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(4);

        assertEquals(2, doubleLinkedList.removeLast().value);
    }

    @Test
    public void testAddLast_whenOneLastElement_returnLastElement() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(2);

        assertEquals(2, doubleLinkedList.removeLast().value);
    }

    @Test
    public void testRemoveLast_whenAddFewElementsFirstAndLast_returnLastElement() {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addLast(4);

        assertEquals(4, doubleLinkedList.removeLast().value);

    }
}