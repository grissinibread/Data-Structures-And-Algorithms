package trees;

import java.util.ArrayList;

public class Tree {
    private class Node {
        int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    // insert(value)
    public void insert(int value) {
        var node = new Node(value);

        if (this.root == null) {
            this.root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if(current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if(current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current =current.rightChild;
            }
        }
    }

    // find(value) : boolean
    public boolean find(int value) {
        var current = this.root;

        while(current != null) {
            if(value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else
                return true;
        }

        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if(root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostorder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }

    // O(log n)
    public int minValue() {
        if(root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while(current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    // O(n)
    public int minValue(Node root) {
        if(isLeaf(root))
            return root.value;

        var left = minValue(root.leftChild);
        var right = minValue(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Tree tree) {
        if(tree == null)
            return false;

        return equals(this.root, tree.root);
    }

    private boolean equals(Node leftRoot, Node rightRoot) {
        if(leftRoot == null && rightRoot == null)
            return true;

        if(leftRoot != null && rightRoot != null)
            return leftRoot.value == rightRoot.value &&
                    equals(leftRoot.leftChild, rightRoot.leftChild) &&
                    equals(leftRoot.rightChild, rightRoot.rightChild);

        return false;
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if(root == null)
            return true;

        if(root.value <= min || root.value >= max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if(root == null)
            return;

        if(distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traversalOrder() {
        for(var i = 0; i <= height(); i++) {
            for(var value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if(root == null)
            return 0;

        return size(root.leftChild) + size(root.rightChild) + 1;
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if(root == null)
            return 0;
        else if(isLeaf(root))
            return 1;

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max() {
        return max(root);
    }


    private int max(Node root) {
        if(isLeaf(root))
            return root.value;

        int left = max(root.leftChild);
        int right = max(root.rightChild);

        return Math.max(Math.max(left, right), root.value);
    }

    public boolean contains(int target) {
        return contains(root, target);
    }

    private boolean contains(Node root, int target) {
        if(root == null)
            return false;

        if (root.value == target)
            return true;

        return contains(root.leftChild, target) || contains(root.rightChild, target);
    }

    public boolean areSiblings(int first, int second) {
        return areSiblings(root, first, second);
    }

    private boolean areSiblings(Node root, int first, int second) {
        if(root == null)
            return false;

        int leftValue = root.leftChild.value;
        int rightValue = root.rightChild.value;

        if(leftValue == first && rightValue == second || rightValue == first && leftValue == second)
            return true;

        return areSiblings(root.leftChild, first, second) || areSiblings(root.rightChild, first, second);
    }
}