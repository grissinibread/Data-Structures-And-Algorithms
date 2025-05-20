package stacks;

import java.util.Arrays;

public class Stack {
    private int max = 5;
    private int current = -1;
    private int[] stack = new int[max];

    // push
    public void push(int item) {
        if(isFull())
            increaseStackSize();

        this.stack[++current] = item;
    }

    // pop
    public int pop() {
        if(isEmpty()) {
            throw new IllegalStateException();
        }

        return stack[current--] = 0;
    }

    // peek
    public int peek() {
        if(isEmpty())
            throw new IllegalStateException();
        return stack[current];
    }

    private Boolean isEmpty() {
        return current == -1;
    }

    private Boolean isFull() {
        return this.current == (this.max - 1);
    }

    private void increaseStackSize() {
        int[] refactor = new int[this.max * 2];
        for(int i = 0; i < this.max; i++)
            refactor[i] = this.stack[i];

        this.stack = refactor;
    }

    @Override
    public String toString() {
        var print = Arrays.copyOfRange(stack, 0, (current + 1));
        return Arrays.toString(print);
    }
}
