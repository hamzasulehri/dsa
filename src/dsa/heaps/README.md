# Heaps (Priority Queues)

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|----------------|
| 1 | Last Stone Weight | Easy | [Last Stone Weight](https://leetcode.com/problems/last-stone-weight/) |
| 2 | Kth Largest Element in Array | Medium | [Kth Largest Element In An Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) |
| 3 | Top K Frequent Elements | Medium | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) |

## Approach

**Last Stone Weight** — Brute force re-sorts the entire working list on
every iteration just to find the two heaviest stones (O(n^2 log n) overall).
The optimal solution uses a max-heap (simulated in Java via negated values,
since `PriorityQueue` is a min-heap by default), so the two heaviest stones
are always available at the top in O(log n) time each.

**Kth Largest Element in Array** — Brute force sorts the entire array in
descending order and returns index `k-1` (O(n log n), and full sort effort
even when k is small). The optimal solution maintains a min-heap of size k;
the root is always the smallest of the k largest elements seen so far —
exactly the k-th largest overall — giving O(n log k).

**Top K Frequent Elements** — Brute force counts frequencies with a
`HashMap`, then sorts *all* unique elements by frequency just to take the
first k (O(n log n)). The optimal solution counts frequencies the same way,
but then uses a min-heap of size k ordered by frequency, avoiding a full
sort of every unique element — O(n log k).

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---|---|---|---|---|
| Last Stone Weight | O(n^2 log n) | O(n) | O(n log n) | O(n) |
| Kth Largest Element in Array | O(n log n) | O(1) | O(n log k) | O(k) |
| Top K Frequent Elements | O(n log n) | O(n) | O(n log k) | O(n) |

## Worked Example: Kth Largest Element using a Min-Heap

```java
import java.util.PriorityQueue;

public class KthLargestElementOptimal {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }
}
// Time: O(n log k)  Space: O(k)
```

We maintain a min-heap of the k largest elements seen so far. The root is
always the smallest among them — i.e., the k-th largest overall.

## How to Run

```bash
javac FileName.java && java FileName
```

Example:

```bash
javac KthLargestElementBrute.java && java KthLargestElementBrute
javac KthLargestElementOptimal.java && java KthLargestElementOptimal
```
