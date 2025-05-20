package queues;

import java.util.Arrays;

public class PriorityQueue {
    private int[] queue = new int[5];
    private int count = 0; // = 0

    public void insert(int element) {
        if(isFull())
            throw new IllegalStateException();

        var current = shiftItemsToInsert(element);

        this.queue[current] = element;
        count++;
    }

    private int shiftItemsToInsert(int element) {
        int current;

        for(current = (this.count - 1); current >= 0; current--) {
            if(this.queue[current] > element)
                this.queue[current + 1] = this.queue[current];
            else
                break;
        }
        return current + 1;
    }

    public void dequeue() {
        if(isEmpty())
            throw new IllegalStateException();

        this.queue[--this.count] = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.queue);
    }

    private boolean isEmpty() {
        return this.count == 0;
    }

    private boolean isFull() {
        return this.count == this.queue.length;
    }
}
