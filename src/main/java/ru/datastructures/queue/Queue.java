package ru.datastructures.queue;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public interface Queue {

    void push(Object o);

    Object pull();

    int size();

    Iterator iterator();

    boolean removeElement(Object o);

    boolean isEmpty();
}
