package heaps;

public class PriorityQueueWithHeap {
    private Heap heap = new Heap();

    public void add(int item) {
        heap.insert(item);
    }

    public int remove() {
        return heap.remove();
    }

    public Boolean isEmpty() {
        return heap.isEmpty();
    }
}