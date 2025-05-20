import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] numbers = { 5, 3, 10, 1, 4, 2};
        var heap = new Heap();
        for (var number: numbers)
            heap.insert(number);
        for (var i = numbers.length - 1; i >= 0; i--)
            numbers[i] = heap.remove();

        System.out.println(Arrays.toString(numbers));
    }
}