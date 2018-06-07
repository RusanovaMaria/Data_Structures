package ru.datastructures.fibonacci;

import java.util.Iterator;

public interface Fibonacci {

    int getMember(int number);

    int getLastMember();

    Iterator iterator();

    int getSize();
}
