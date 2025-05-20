package stacks;

public class MinStack {
    private int max = 5;

    private int[] stack = new int[max];
    private int[] min = new int[max + 1];

    private int current = -1;
    private int currentMin = -1;

    // push
    public void push(int item) {
        if(isFull())
            throw new StackOverflowError();

        if(isEmpty())
            this.min[++this.currentMin] = item;
        else if (!isEmpty())
            this.min[++this.currentMin] = Math.min(this.min[this.currentMin - 1], item);

        this.stack[++this.current] = item;
    }

    // pop
    public int pop() {
        if(isEmpty())
            throw new IllegalStateException();

        this.min[this.currentMin--] = 0;

        return this.stack[current--] = 0;
    }

    public int min() {
        return this.min[currentMin];
    }

    private boolean isFull() {
        return this.current == this.max;
    }

    private boolean isEmpty() {
        return this.current == -1;
    }
}
