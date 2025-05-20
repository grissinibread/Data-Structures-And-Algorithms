package linkedLists;

import java.util.NoSuchElementException;

public class LinkedList {
    private static class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    // addFirst
    public void addFirst(int value) {
        // no existing list
        var newNode = new Node(value);

        if (isEmpty())
            this.first = this.last = newNode;
        else {
            newNode.next = this.first;
            this.first = newNode;
        }

        this.size++;
    }

    // addLast
    public void addLast(int value) {
        var newNode = new Node(value);

        // no existing list
        if (isEmpty())
            this.first = this.last = newNode;
        else {
            this.last.next = newNode;
            this.last = newNode;
        }

        this.size++;
    }

    // deleteFirst
    public void deleteFirst() {
        // no existing list
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (this.first == this.last) {
            this.first = this.last = null;
        } else {
            var temp = this.first;
            this.first = this.first.next;
            temp.next = null;
        }

        this.size--;
    }

    // deleteLast
    public void deleteLast() {
        // no existing list
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (this.first == this.last) {
            this.first = this.last = null;
        } else {
            var previous = getPrevious(this.last);
            this.last = previous;
            this.last.next = null;
        }

        this.size--;
    }

    // contains
    public Boolean contains(int value) {
        return indexOf(value) != -1;
    }

    // indexOf
    public int indexOf(int value) {
        int index = 0;
        var traverse = this.first;

        while (traverse.next != null) {
            if (traverse.value == value)
                return index;

            traverse = traverse.next;
            index++;
        }

        return -1;
    }

    public void print() {
        var traverse = this.first;

        while(traverse != null) {
            System.out.println(traverse.value);
            traverse = traverse.next;
        }
    }

    private boolean isEmpty() {
        return this.first == null;
    }

    private Node getPrevious(Node node) {
        var temp = this.first;

        while (temp != null) {
            if(temp.next == node)
                return temp;
            temp = temp.next;
        }

        return null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;

        while(current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public int size() {
        return this.size;
    }

    public void reverse() {
        if(isEmpty())
            return;

        var left = this.first;
        var middle = this.first.next;

        while(middle != null) {
            var right = middle.next;

            middle.next = left;
            left = middle;
            middle = right;
        }

        this.last = first;
        this.last.next = null;

        this.first = left;
    }

    public int getKthFromTheEnd(int Kth) {
        if(isEmpty())
            throw new IllegalStateException();
        var left = this.first;
        var right = this.first;

        for(int i = 0; i < (Kth - 1); i++) {
            right = right.next;
            if(right == null)
                throw new IllegalArgumentException();
        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }


        return left.value;
    }

    public void printMiddle() {
        if(isEmpty())
            throw new IllegalStateException();

        var left = this.first;
        var right = this.first;

        while(right != this.last && right.next != this.last) {
            right = right.next.next;
            left = left.next;
        }

        System.out.println(left.value);
    }

    // Floyd's Cycle-finding Algorithm
    public Boolean hasLoop() {
        if(isEmpty())
            return Boolean.FALSE;

        var slow = this.first;
        var fast = this.first;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}