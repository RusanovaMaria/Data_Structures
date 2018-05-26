package ru.datastructures.binarytree;

public class BinaryTreeBypass {

    private BinaryTree tree;

    public BinaryTreeBypass(BinaryTree tree) {
        this.tree = tree;
    }

    public void preOrder() {
        if (tree.root == null) {
            return;
        }
        preOrderPrint(tree.root);
    }

    private void preOrderPrint(BinaryTreeElement element) {
        System.out.println(element.value);
        if (element.left != null) {
            preOrderPrint(element.left);
        }
        if (element.right != null) {
            preOrderPrint(element.right);
        }
    }

    public void inOrder() {
        if (tree.root == null) {
            return;
        }
        inOrderPrint(tree.root);
    }

    private void inOrderPrint(BinaryTreeElement element) {
        if (element.left != null) {
            inOrderPrint(element.left);
        }
            System.out.println(element.value);

        if (element.right != null) {
            inOrderPrint(element.right);
        }
    }

    public void postOrder() {
        if (tree.root == null) {
            return;
        }
        postOrderPrint(tree.root);
    }

    private void postOrderPrint(BinaryTreeElement element) {
        if (element.left != null) {
            postOrderPrint(element.left);
        }
        if (element.right != null) {
            postOrderPrint(element.right);
        }
        System.out.println(element.value);
    }
}
