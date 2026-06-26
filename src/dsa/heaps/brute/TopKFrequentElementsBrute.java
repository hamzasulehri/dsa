package dsa.heaps.brute;

/*
Problem: Top K Frequent Elements
Approach: Brute Force
Count frequency of each number with a HashMap, then sort all unique
numbers by frequency (descending) and take the first k.
Time Complexity: O(n log n)
Space Complexity: O(n)
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElementsBrute {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        List<Integer> uniqueNums = new ArrayList<>(freq.keySet());
        // sort all unique numbers by frequency, descending - O(n log n)
        Collections.sort(uniqueNums, (a, b) -> freq.get(b) - freq.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = uniqueNums.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(java.util.Arrays.toString(result)); // expected: [1, 2]
    }
}
