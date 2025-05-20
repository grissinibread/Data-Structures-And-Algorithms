package queues;

import java.util.Stack;

public class QueueStack {
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public void add(int element) {
        first.add(element);
    }

    public int pop() {
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return second.pop();
    }

    private void moveStack1ToStack2() {
        if(second.isEmpty())
            while(!first.isEmpty())
                second.add(first.pop());
    }

    public int peek() {
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return second.peek();
    }

    @Override
    public String toString() {
        while(!first.isEmpty())
            second.add(first.pop());

        String output = this.second.toString();

        while(!second.isEmpty())
            first.add(second.pop());

        return output;
    }

    private boolean isEmpty() {
        return first.isEmpty() && second.isEmpty();
    }
}
