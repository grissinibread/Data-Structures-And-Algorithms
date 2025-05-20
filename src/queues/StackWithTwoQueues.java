package queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    Queue<Integer> first = new ArrayDeque<>();
    Queue<Integer> second = new ArrayDeque<>();

    //push
    public void push(int element) {
        first.add(element);
    }

    //pop
    public int pop() {
        if(second.isEmpty()) {
            while(first.size() != 1)
                second.add(first.remove());

            return first.remove();
        }
        while(second.size() != 1)
            first.add(second.remove());

        return second.remove();
    }

    //peek
    public int peek() {
        int removed;

            if(second.isEmpty()) {
                while(first.size() != 1)
                    second.add(first.remove());

                removed = first.remove();

                second.add(removed);

                return removed;
            }
            while(second.size() != 1)
                first.add(second.remove());

            removed = first.remove();

            second.add(removed);

            return removed;
    }

    //size
    private int size() {
        return 0; // placeholder
    }

    //isEmpty
    private boolean isEmpty() {
        return first.isEmpty() || second.isEmpty();
    }
}