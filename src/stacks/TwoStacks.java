package stacks;

import java.util.Arrays;

public class TwoStacks {
    private int max = 10;
    private int[] twoStack = new int[this.max];
    private int current1 = 0;
    private int current2 = 9;


    public void push1(int item) {
        if(isFull())
            throw new StackOverflowError();

        this.twoStack[current1++] = item;
    }

    public void push2(int item) {
        if(isFull())
            throw new StackOverflowError();

        this.twoStack[this.current2--] = item;
    }

    public int pop1() {
        if(isEmpty1())
            throw new IllegalStateException();

        return this.twoStack[this.current1--] = 0;
    }

    public int pop2() {
        if(isEmpty2())
            throw new IllegalStateException();

        return this.twoStack[this.current2++] = 0;
    }

    private boolean isFull() {
        return this.current1 - 1 == this.current2;
    }

    private boolean isEmpty1() {
        return current1 == 0;
    }

    private boolean isEmpty2() {
        return current2 == 9;
    }

    public String toString1() {
        var print = Arrays.copyOfRange(twoStack, 0, current1);
        return Arrays.toString(print);
    }

    public String toString2() {
        var print = Arrays.copyOfRange(twoStack, current2 + 1, max);
        return Arrays.toString(print);
    }
}