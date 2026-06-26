package dsa.heaps.optimal;

/*
Problem: Top K Frequent Elements
Approach: Optimal
Count frequencies with a HashMap, then use a min-heap of size k ordered
by frequency. Pushing/popping keeps only the k most frequent elements
without sorting the entire frequency map.
Time Complexity: O(n log k)
Space Complexity: O(n) for the frequency map + O(k) for the heap
*/
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElementsOptimal {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        // min-heap ordered by frequency; root = current lowest frequency among top-k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );

        for (int num : freq.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
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
