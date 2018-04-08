package ru.datastructures.stack;

import ru.datastructures.stack.MyStack;

public class MyStackTest {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();

        System.out.println(myStack.empty());

        for (int i = 0; i < 12; i++) {
            myStack.push(0);
        }

        for (int i = 0; i < 3; i++) {
            myStack.push("mary");
        }

        System.out.println(myStack.search("mary"));
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.println(myStack.peek());
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println();

        System.out.println(myStack.empty());
    }
}

