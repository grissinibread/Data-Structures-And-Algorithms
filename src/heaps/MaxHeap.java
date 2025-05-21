package heaps;

public class MaxHeap {
    public static void heapify(int[] numbers) {
        var lastParentIndex = numbers.length / 2 - 1;
        for(var i = lastParentIndex / 2 - 1; i >= 0; i--) {
            heapify(numbers, i);
        }
    }

    private static void heapify(int[] numbers, int index) {
        var largerIndex = index;

        var leftIndex = (index * 2) + 1;
        if(leftIndex < numbers.length &&
                numbers[leftIndex] > numbers[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = (index * 2) + 2;
        if(rightIndex < numbers.length &&
                numbers[rightIndex] > numbers[largerIndex])
            largerIndex = rightIndex;

        if(index == largerIndex)
            return;

        swap(numbers, index, largerIndex);
        heapify(numbers, largerIndex);
    }

    public static int getKthLargest(int[] numbers, int k) {
        if(k < 1 || k > numbers.length)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for(var number : numbers)
            heap.insert(number);

        for(var i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }

    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}
