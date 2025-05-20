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

    public void remove() {
        if(isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        } else if (this.size == 1) {
            heap[0] = 0;
            this.size--;
        } else {
            heap[0] = heap[this.size - 1];
            heap[this.size - 1] = 0;

            // bubble down
            bubbleDown();

            this.size--;
        }
    }

    private void bubbleDown() {
        int index = 0;
        while (!isValidParent(index)) {
            if(heap[index] < heap[leftChild(index)])
                swap(index, leftChild(index));
            else if (heap[index] < heap[rightChild(index)])
                swap(index, (rightChild(index)));

            index++;
        }
    }

    private Boolean isValidParent(int index) {
        return heap[index] >= heap[leftChild(index)] &&
                heap[index] >= heap[rightChild(index)];
    }

    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    private int rightChild(int index) {
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
