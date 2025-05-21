import heaps.Heap;
import heaps.MaxHeap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 1, 2};

        System.out.println(MaxHeap.getKthLargest(numbers, 6));
    }

}