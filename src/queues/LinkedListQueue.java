package queues;

import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> items = new LinkedList<>();

    //enqueue
    public void enqueue(int element){
        if(items.isEmpty())
            items.addFirst(element);

        else
            items.add(element);
    }

    //dequeue
    public void dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        else
            items.remove(items.getFirst());
    }

    //peek
    public int peak(){
        return items.getFirst();
    }

    //size
    public int size(){
        return items.size();
    }

    //isEmpty
    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public String toString(){
        return items.toString();
    }
}