package ru.datastructures.binarytree;

public class BinaryTree {

    private class BinaryTreeElement {
        int value;
        BinaryTreeElement right;
        BinaryTreeElement left;

        BinaryTreeElement(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    private BinaryTreeElement root;

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
           addToLeftOrPass(value, parent);
        } else {
           addToTheRightOrPass(value, parent);
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

    private void addToTheRightOrPass(int value, BinaryTreeElement parent) {
        if (parent.right == null) {
            BinaryTreeElement element = new BinaryTreeElement(value);
            parent.right = element;
        } else {
            add(value, parent.right);
        }
    }

    private void removeElement(int value) {
        BinaryTreeElement removableElement = root;
        BinaryTreeElement parentOfRemovableElement = root;

        while(removableElement.value != value) {
            parentOfRemovableElement = removableElement;
            removableElement = (removableElement.value < value) ? removableElement.left : removableElement.right;
        }
        remove(parentOfRemovableElement, removableElement);
    }

    private void remove(BinaryTreeElement parent, BinaryTreeElement element) {
        if (element.equals(root)) {
            removeElementWithTwoSubtrees(element);
        } else {
            if (isLeaf(element)) {
                removeList(parent, element);
            } else if(isElementWithOneSubtree(element)) {
                removeElementWithOneSubtree(parent, element);
            } else if(isElementWithTwoSubtrees(element)) {
                removeElementWithTwoSubtrees(element);
            }
        }
    }

    private void removeList(BinaryTreeElement parent, BinaryTreeElement element) {
        if (parent.left.value == element.value) {
            parent.left = null;
        } else {
            parent.right = null;
        }
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

    private void removeElementWithTwoSubtrees(BinaryTreeElement element) {
        BinaryTreeElement leftmostElement = searchLeftmostElementInRightSubtree(element);

        if (isLeftmostElementInRightSubtreeLeaf(element)) {
            element = leftmostElement;
        } else {
            BinaryTreeElement parentLeftmostElement = searchParentLeftmostElementInRightSubtree(element);
            removeElementWithOneSubtree(parentLeftmostElement, leftmostElement);
            element = leftmostElement;
        }
    }

    private boolean isLeftmostElementInRightSubtreeLeaf(BinaryTreeElement element) {
        BinaryTreeElement leftmostElement = searchLeftmostElementInRightSubtree(element);

            if(isLeaf(leftmostElement)) {
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
            parentLeftmostElement = element.right.left;
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
        if((isElementWithLeftSubtree(element)) || (isElementWithRightSubtree(element))) {
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
