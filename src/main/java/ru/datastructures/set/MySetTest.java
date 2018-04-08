package ru.datastructures.set;

import java.util.Iterator;

public class MySetTest {

    public static void main(String[] args) {

        MySet mySet = new MySet();
        mySet.add(7);
        mySet.addRange("mary", 0, 2);

        MySet newSet = mySet.clone();
        newSet.remove(7);

        Iterator iter = mySet.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println();


        Iterator iter1 = newSet.iterator();

        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
        System.out.println();

        System.out.println(mySet.inclusion(newSet));
        System.out.println(mySet.intersection(newSet));
        System.out.println();

        mySet.difference(newSet);

        Iterator iter2 = mySet.iterator();

        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
        System.out.println();
    }
}

