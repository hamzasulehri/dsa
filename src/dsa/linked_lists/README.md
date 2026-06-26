# Linked Lists

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|----------------|
| 1 | Remove Duplicates from Sorted List | Easy | [Remove Duplicates From Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) |
| 2 | Linked List Cycle | Easy | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) |
| 3 | Merge Two Sorted Lists | Easy | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) |

## Approach

**Remove Duplicates from Sorted List** — Brute force converts the list to an
`ArrayList`, deduplicates with a `LinkedHashSet`, then rebuilds a brand-new
linked list from scratch. The optimal solution exploits the fact the list is
already sorted: a single pointer skips over duplicate-valued nodes in-place
by re-linking `next` pointers, needing no extra structure.

**Linked List Cycle** — Brute force stores every visited node reference in a
`HashSet`; if a node is seen twice, a cycle exists, but this costs O(n)
space. The optimal solution uses Floyd's fast/slow pointer technique — if a
cycle exists, the fast pointer (2 steps) will eventually lap the slow
pointer (1 step) and they will meet, using O(1) space.

**Merge Two Sorted Lists** — Brute force dumps all values from both lists
into an `ArrayList`, sorts it, then rebuilds a brand-new list (O(n log n)
due to sorting). The optimal solution merges in-place with two pointers,
always attaching the smaller current node directly to the result list — no
new nodes are allocated and no sorting is needed.

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---|---|---|---|---|
| Remove Duplicates from Sorted List | O(n) | O(n) | O(n) | O(1) |
| Linked List Cycle | O(n) | O(n) | O(n) | O(1) |
| Merge Two Sorted Lists | O(n log n) | O(n) | O(n) | O(1) |

## How to Run

```bash
javac FileName.java && java FileName
```

Example:

```bash
javac LinkedListCycleBrute.java && java LinkedListCycleBrute
javac LinkedListCycleOptimal.java && java LinkedListCycleOptimal
```
