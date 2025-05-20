import java.util.Arrays;

public class Heap {
    private int[] heap = new int[10];
    private int size = 0;

    public void insert(int value) {
        if(isFull())
            throw new IllegalStateException("Heap is full");

        this.heap[size++] = value;

        bubbleUp();
    }

    public int remove() {
        if(isEmpty())
            throw new IllegalStateException("Heap is empty");

        var root = heap[0];

        heap[0] = heap[--size];

       bubbleDown();

        return root;
    }

    private void bubbleDown() {
        var index = 0;
        while(index <=  size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int largerChildIndex(int index) {
        if(!hasLeftChild(index))
            return index;

        if(!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) : rightChildIndex(index);
    }

    private Boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private Boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private Boolean isValidParent(int index) {
        if(!hasLeftChild(index))
            return true;

        var isValid = heap[index] >= heap[leftChildIndex(index)];

        if(!hasRightChild(index))
            isValid &= heap[index] >= heap[rightChild(index)];

        return isValid;
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private void bubbleUp() {
        int index = size - 1;
        while (heap[index] > this.heap[parent(index)]) {
            swap(index, parent(index));

            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    private Boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.heap);
    }

    public Boolean isFull() {
        return size == heap.length;
    }
}
