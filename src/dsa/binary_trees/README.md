# Binary Trees

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|----------------|
| 1 | Invert Binary Tree | Easy | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/) |
| 2 | Maximum Depth of Binary Tree | Easy | [Maximum Depth Of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) |
| 3 | Kth Smallest Element in a BST | Medium | [Kth Smallest Element In A Bst](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) |
| 4 | Diameter of Binary Tree | Easy | [Diameter Of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/) |
| 5 | Validate Binary Search Tree | Medium | [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/) |
| 6 | Implement Trie (Prefix Tree) | Medium | [Implement Trie Prefix Tree](https://leetcode.com/problems/implement-trie-prefix-tree/) |
| 7 | Minimum Absolute Difference in BST | Easy | [Minimum Absolute Difference In Bst](https://leetcode.com/problems/minimum-absolute-difference-in-bst/) |

## Approach

**Invert Binary Tree** — Brute force uses an iterative BFS with a queue,
swapping each node's children level by level. The optimal solution uses
recursive DFS: swap a node's children, then recurse into the now-swapped
subtrees — a more elegant O(n) traversal.

**Maximum Depth of Binary Tree** — Brute force uses BFS, counting how many
full levels are processed. The optimal solution uses simple recursive DFS:
`depth = 1 + max(depth(left), depth(right))`.

**Kth Smallest Element in a BST** — Brute force collects every node's value
via a full inorder traversal into a list, then indexes at `k-1`, always
visiting all `n` nodes. The optimal solution performs an iterative inorder
traversal with an explicit stack and stops as soon as the k-th node is
popped, avoiding visiting the rest of the tree.

**Diameter of Binary Tree** — Brute force recomputes subtree height from
scratch at every single node (O(n) work repeated for each of n nodes —
O(n^2) overall). The optimal solution computes height and updates a global
max diameter in one single DFS pass.

**Validate Binary Search Tree** — Brute force does an inorder traversal,
collects all values, and checks the resulting list is strictly increasing.
The optimal solution does a single DFS pass, passing down valid (min, max)
bounds for each node and validating in place — no extra list required.

**Implement Trie (Prefix Tree)** — Brute force stores all words in a flat
list, scanning every stored word for `search`/`startsWith` (cost grows with
number of words stored). The optimal solution builds a true trie where each
node holds a map of children; lookups cost only the length of the word/prefix,
regardless of how many words are stored.

**Minimum Absolute Difference in BST** — Brute force collects all values via
inorder traversal, then compares every pair (O(n^2)). Since inorder
traversal of a BST yields sorted order, the optimal solution only needs to
compare each node to the *previous* node visited (a `prev` pointer), since
the minimum difference must occur between adjacent values in sorted order.

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---|---|---|---|---|
| Invert Binary Tree | O(n) | O(n) | O(n) | O(h) |
| Maximum Depth of Binary Tree | O(n) | O(n) | O(n) | O(h) |
| Kth Smallest Element in a BST | O(n) | O(n) | O(k) | O(k) |
| Diameter of Binary Tree | O(n^2) | O(h) | O(n) | O(h) |
| Validate Binary Search Tree | O(n) | O(n) | O(n) | O(h) |
| Implement Trie | O(n*L) | O(n*L) | O(L) | O(total chars) |
| Minimum Absolute Difference in BST | O(n^2) | O(n) | O(n) | O(h) |

*(n = number of nodes/words, h = tree height, k = target rank, L = word/prefix length)*

## How to Run

```bash
javac FileName.java && java FileName
```

Example:

```bash
javac InvertBinaryTreeBrute.java && java InvertBinaryTreeBrute
javac InvertBinaryTreeOptimal.java && java InvertBinaryTreeOptimal
```
