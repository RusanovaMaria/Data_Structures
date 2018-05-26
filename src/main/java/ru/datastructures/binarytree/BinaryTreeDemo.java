package ru.datastructures.binarytree;

public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        int[] a = {5, 2, 3, 9, 1, 10, 12, 6, 7};
        for (int i = 0; i < a.length; i++) {
            tree.addElement(a[i]);
        }
        BinaryTreeBypass bypass = new BinaryTreeBypass(tree);
        tree.removeElement(7);
        tree.removeElement(5);
        tree.removeElement(6);
        System.out.println();
        bypass.preOrder();
        System.out.println();
        bypass.inOrder();
        System.out.println();
        bypass.postOrder();
    }
}
