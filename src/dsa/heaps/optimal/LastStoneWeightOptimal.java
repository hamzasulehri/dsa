package dsa.heaps.optimal;

/*
Problem: Last Stone Weight
Approach: Optimal
Use a max-heap so the two heaviest stones are always available at the
top in O(log n) time. Java's PriorityQueue is a min-heap by default,
so we negate values to simulate a max-heap.
Time Complexity: O(n log n)
Space Complexity: O(n) for the heap
*/
import java.util.PriorityQueue;

public class LastStoneWeightOptimal {

    public static int lastStoneWeight(int[] stones) {
        // max-heap via negation: smallest negative value = largest original value
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int s : stones) {
            maxHeap.offer(-s);
        }

        while (maxHeap.size() > 1) {
            int y = -maxHeap.poll(); // heaviest
            int x = -maxHeap.poll(); // second heaviest
            int diff = y - x;
            if (diff > 0) {
                maxHeap.offer(-diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : -maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones)); // expected: 1
    }
}
