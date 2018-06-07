package ru.datastructures.queue;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void push() {
    }

    @Test
    public void pull_whenQueueIsNotEmpty_returnFirstElement() {
        MyQueue queue = new MyQueue();
        queue.push("Mary");
        queue.push("Ann");
        queue.push("Kate");
        Object result = queue.pull();
        assertEquals("Mary", result);

    }

    @Test
    public void pull_whenQueueIsEmpty_returnNull() {
        MyQueue queue = new MyQueue();
        Object result = queue.pull();
        assertNull(result);
    }

    @Test
    public void pull_whenTestRemoveFirstElement_returnFalse() {
        MyQueue queue = new MyQueue();
        queue.push("Mary");
        queue.push("Ann");
        queue.push("Kate");
        Object element = queue.pull();
        boolean result = queue.removeElement("Mary");
        assertFalse(result);
    }

    @Test
    public void size() {
        MyQueue queue = new MyQueue();
        queue.push("Mary");
        queue.push("Ann");
        queue.push("Kate");
        queue.removeElement("Ann");
        int size = queue.size();
        assertEquals(2, size);
    }

    @Test
    public void iterator_whenIterateToLastElement_returnLAstElement() {
        MyQueue queue = new MyQueue();
        Object result = null;
        queue.push("Kate");
        queue.push("Mary");
        queue.push("Ann");
        queue.removeElement("Ann");

        Iterator iterator = queue.iterator();
        while(iterator.hasNext()) {
            result = iterator.next();
        }
        assertEquals("Mary", result);
    }

    @Test
    public void iterator_whenIterateToFirstElement_returnFirstElement() {
        MyQueue queue = new MyQueue();
        Object result = null;
        queue.push("Kate");
        queue.push("Mary");
        queue.push("Ann");
        queue.removeElement("Ann");

        Iterator iterator = queue.iterator();
        if (iterator.hasNext()) {
            result = iterator.next();
        }
        assertEquals("Kate", result);
    }

    @Test
    public void iterator_whenIterateToMiddleElement_returnMiddleElement() {
        MyQueue queue = new MyQueue();
        Object result = null;
        queue.push("Kate");
        queue.push("Mary");
        queue.push("Ann");
        queue.removeElement("Ann");

        Iterator iterator = queue.iterator();
        for (int i = 0; i<2; i++) {
            if (iterator.hasNext()) {
                result = iterator.next();
            }
        }
        assertEquals("Mary", result);
    }

    @Test
    public void iterator_whenIterateToOutSizeElement_returnLastElement() {
        MyQueue queue = new MyQueue();
        Object result = null;
        queue.push("Kate");
        queue.push("Mary");
        queue.push("Ann");

        Iterator iterator = queue.iterator();
        for (int i = 0; i<7; i++) {
            if (iterator.hasNext()) {
                result = iterator.next();
            }
        }
        assertEquals("Ann", result);
    }

    @Test (expected = IllegalStateException.class)
    public void removeElement_whenQueueIsEmpty_returnException() {
        MyQueue queue = new MyQueue();
        boolean result = queue.removeElement("Kate");
    }

    @Test
    public void removeFirstElement_whenQueueIsEmpty_returnTrue() {
        MyQueue queue = new MyQueue();
        queue.push("Kate");
        queue.push("Mary");
        queue.push("Ann");
        boolean result = queue.removeElement("Kate");
        assertTrue(result);
    }

    @Test
    public void removeLastElement_whenQueueIsEmpty_returnTrue() {
        MyQueue queue = new MyQueue();
        queue.push("Kate");
        queue.push("Mary");
        queue.push("Ann");
        boolean result = queue.removeElement("Ann");
        assertTrue(result);
    }

    @Test
    public void removeMiddleElement_whenQueueIsEmpty_returnTrue() {
        MyQueue queue = new MyQueue();
        queue.push("Kate");
        queue.push("Mary");
        queue.push("Ann");
        boolean result = queue.removeElement("Mary");
        assertTrue(result);
    }

    @Test
    public void isEmpty() {
        MyQueue queue = new MyQueue();
        queue.push("Kate");
        queue.removeElement("Kate");
        boolean result = queue.isEmpty();
        assertTrue(result);
    }
}