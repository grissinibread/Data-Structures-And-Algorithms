import graphs.Graph;
import graphs.WeightedGraph;
import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3};
        var sorter = new SelectionSort();
        sorter.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}