package ru.datastructures.binarytree;

public class BinaryTree {

    BinaryTreeElement root;

    public void addElement(int value) {
        if (root == null) {
            BinaryTreeElement element = new BinaryTreeElement(value);
            root = element;
        } else {
            add(value, root);
        }
    }

    private void add(int value, BinaryTreeElement parent) {
        if (parent.value < value) {
            addToRightOrPass(value, parent);
        } else {
            addToLeftOrPass(value, parent);
        }
    }

    private void addToLeftOrPass(int value, BinaryTreeElement parent) {
        if (parent.left == null) {
            BinaryTreeElement element = new BinaryTreeElement(value);
            parent.left = element;
        } else {
            add(value, parent.left);
        }
    }

    private void addToRightOrPass(int value, BinaryTreeElement parent) {
        if (parent.right == null) {
            BinaryTreeElement element = new BinaryTreeElement(value);
            parent.right = element;
        } else {
            add(value, parent.right);
        }
    }

    public void removeElement(int value) {
        BinaryTreeElement removableElement = this.root;
        BinaryTreeElement parentOfRemovableElement = this.root;

        while (removableElement.value != value) {
            parentOfRemovableElement = removableElement;
            removableElement = (removableElement.value < value) ? removableElement.right : removableElement.left;
        }
        remove(parentOfRemovableElement, removableElement);
    }

    private void remove(BinaryTreeElement parent, BinaryTreeElement element) {
        if (element.equals(root)) {
            removeElementWithTwoSubtrees(parent, element);
        } else {
            if (isLeaf(element)) {
                removeList(parent, element);
            } else if (isElementWithOneSubtree(element)) {
                removeElementWithOneSubtree(parent, element);
            } else if (isElementWithTwoSubtrees(element)) {
                removeElementWithTwoSubtrees(parent, element);
            }
        }
    }

    private void removeList(BinaryTreeElement parent, BinaryTreeElement element) {
        if (isLeftChild(parent, element)) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    private boolean isLeftChild(BinaryTreeElement parent, BinaryTreeElement element) {
        if ((parent.left != null) && (parent.left.equals(element))) {
            return true;
        }
        return false;
    }

    private void removeElementWithOneSubtree(BinaryTreeElement parent, BinaryTreeElement element) {
        if (parent.left.value == element.value) {
            outweighToTheLeft(parent, element);
        } else {
            outweighToTheRight(parent, element);
        }
    }

    private void outweighToTheLeft(BinaryTreeElement parent, BinaryTreeElement element) {
        if (element.left != null) {
            parent.left = element.left;
        } else {
            parent.left = element.right;
        }
    }

    private void outweighToTheRight(BinaryTreeElement parent, BinaryTreeElement element) {
        if (element.left != null) {
            parent.right = element.left;
        } else {
            parent.right = element.right;
        }
    }

    private void removeElementWithTwoSubtrees(BinaryTreeElement parent, BinaryTreeElement element) {
        BinaryTreeElement leftmostElement = searchLeftmostElementInRightSubtree(element);
        BinaryTreeElement parentLeftmostElement = searchParentLeftmostElementInRightSubtree(element);
        if (leftmostElement == null) {
            parent.right = element.right;
            parent.right.left = element.left;
            if (element.value == root.value) {
                root = parent.right;
            }
        } else if (isLeftmostElementInRightSubtreeLeaf(element)) {
            removeList(parentLeftmostElement, leftmostElement);
            element.value = leftmostElement.value;
        } else {
            removeElementWithOneSubtree(parentLeftmostElement, leftmostElement);
            element.value = leftmostElement.value;
        }
    }

    private boolean isLeftmostElementInRightSubtreeLeaf(BinaryTreeElement element) {
        BinaryTreeElement leftmostElement = searchLeftmostElementInRightSubtree(element);

        if (isLeaf(leftmostElement)) {
            return true;
        }
        return false;
    }

    private BinaryTreeElement searchLeftmostElementInRightSubtree(BinaryTreeElement element) {
        BinaryTreeElement leftmostElement = null;
        if (element.right.left != null) {
            leftmostElement = element.right.left;
            while (leftmostElement.left != null) {
                leftmostElement = leftmostElement.left;
            }
        }
        return leftmostElement;
    }

    private BinaryTreeElement searchParentLeftmostElementInRightSubtree(BinaryTreeElement element) {
        BinaryTreeElement leftmostElement = null;
        BinaryTreeElement parentLeftmostElement = null;
        if (element.right.left != null) {
            leftmostElement = element.right.left;
            parentLeftmostElement = element.right;
            while (leftmostElement.left != null) {
                parentLeftmostElement = leftmostElement;
                leftmostElement = leftmostElement.left;
            }
        }
        return parentLeftmostElement;
    }

    private boolean isLeaf(BinaryTreeElement element) {
        if ((element.left == null) && (element.right == null)) {
            return true;
        }
        return false;
    }

    private boolean isElementWithOneSubtree(BinaryTreeElement element) {
        if ((isElementWithLeftSubtree(element)) || (isElementWithRightSubtree(element))) {
            return true;
        }
        return false;
    }

    private boolean isElementWithLeftSubtree(BinaryTreeElement element) {
        if (element.right == null && element.left != null) {
            return true;
        }
        return false;
    }

    private boolean isElementWithRightSubtree(BinaryTreeElement element) {
        if ((element.left == null) && (element.right != null)) {
            return true;
        }
        return false;
    }

    private boolean isElementWithTwoSubtrees(BinaryTreeElement element) {
        if ((element.left != null) && (element.right != null)) {
            return true;
        }
        return false;
    }
}
