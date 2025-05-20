package queues;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    Stack<Integer> stack = new Stack<>();

    public void reverse(int k, Queue<Integer> queue) {
        for(int i = 0; i <= k; i++)
            stack.push(queue.remove());

        while(!stack.isEmpty())
            queue.add(stack.pop());

        for(int i = 0; i < (queue.size() - k - 1); i++)
            queue.add(queue.remove());
    }
}