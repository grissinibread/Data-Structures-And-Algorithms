package queues;

import java.util.Arrays;

public class Queue {
    private int[] queue;
    private int front;
    private int rear;
    private int count = 0;

    public Queue(int size) {
        this.queue = new int[size];
    }

    public void enqueue(int item) {
        if(isFull())
            throw new StackOverflowError();

        this.queue[this.rear] = item;
        this.rear = (this.rear + 1) % queue.length;
        count++;
    }

    public int dequeue() {
        var item = this.queue[front];
        this.queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        return item;
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException();

        var access = (this.rear + this.queue.length - 1) % this.queue.length;
        return this.queue[access];
    }

    private boolean isEmpty() {
        return this.count == 0;
    }

    private boolean isFull() {
        return this.count == this.queue.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.queue);
    }
}
