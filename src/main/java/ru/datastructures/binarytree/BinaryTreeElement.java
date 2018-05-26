package ru.datastructures.binarytree;

public class BinaryTreeElement {

    int value;
    BinaryTreeElement right;
    BinaryTreeElement left;

    BinaryTreeElement(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
