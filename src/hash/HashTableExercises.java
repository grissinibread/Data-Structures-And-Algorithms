package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashTableExercises {
    public int mostFrequent(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(var number : numbers)
            map.put(number, map.getOrDefault(number, 0) + 1);

        var mostFrequent = -1;
        int result = numbers[0];
        for(var pair : map.entrySet()) {
            if(pair.getValue() > mostFrequent) {
                mostFrequent = pair.getValue();
                result = pair.getKey();
            }
        }

        return result;
    }

    public int countPairsWithDiff(int[] numbers, int k) {
        Set<Integer> set = new HashSet<>();

        int unique = 0;
        for(var number : numbers)
            set.add(number);

        for(var number : numbers) {
            if(set.contains(number + k))
                unique++;
            if(set.contains(number - k))
                unique++;
            set.remove(number);
        }

        return unique;
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int complement;
        for(int i = 0; i < numbers.length; i++) {
            complement = target - numbers[i];
            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(numbers[i], i);
        }

        return null;
    }
}
