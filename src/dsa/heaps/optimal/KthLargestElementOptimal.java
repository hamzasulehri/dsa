
package dsa.heaps.optimal;
/*
Problem: Kth Largest Element in Array
Approach: Optimal
Maintain a min-heap of size k. The root of the heap is always the
smallest among the k largest elements seen so far — i.e., the k-th
largest overall. Every offer/poll is O(log k).
Time Complexity: O(n log k)
Space Complexity: O(k)
*/
import java.util.PriorityQueue;

public class KthLargestElementOptimal {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min-heap by default

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // remove the smallest, keeping size == k
            }
        }
        return minHeap.peek(); // root = kth largest
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2)); // expected: 5
    }
}
