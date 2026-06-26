# Arrays & Strings

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|----------------|
| 1 | Find Closest Number to Zero | Easy | [Find Closest Number To Zero](https://leetcode.com/problems/find-closest-number-to-zero/) |
| 2 | Is Subsequence | Easy | [Is Subsequence](https://leetcode.com/problems/is-subsequence/) |
| 3 | Summary Ranges | Easy | [Summary Ranges](https://leetcode.com/problems/summary-ranges/) |
| 4 | Longest Common Prefix | Easy | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) |
| 5 | Best Time to Buy & Sell Stock | Easy | [Best Time To Buy And Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) |

## Approach

**Find Closest Number to Zero** — Brute force does a linear scan tracking the
minimum absolute value, breaking ties on the fly. The optimal version is the
same single O(n) pass, just with the tie-break (positive wins) made explicit
and clean so it's obviously correct for the tricky edge case of equal
absolute values.

**Is Subsequence** — Brute force re-scans the target string `t` from a saved
checkpoint for every character of `s`, which degrades toward O(n*m) on
adversarial input. The optimal solution uses two independent pointers that
each only move forward, giving a single combined O(n+m) pass.

**Summary Ranges** — Brute force re-verifies consecutiveness for every
candidate range by re-checking all pairs inside it, which is quadratic. The
optimal solution keeps a single `start` pointer and only checks the
adjacent-element gap once per index, giving a linear pass.

**Longest Common Prefix** — Brute force compares every string against a
running prefix character by character. The optimal trick is to sort the
array lexicographically first — the common prefix of the whole array then
equals the common prefix of just the first and last (lexicographically most
different) strings.

**Best Time to Buy & Sell Stock** — Brute force checks every buy/sell pair of
days. The optimal solution tracks the minimum price seen so far while
scanning once, updating max profit as it goes — no need to look backward.

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---|---|---|---|---|
| Find Closest Number to Zero | O(n) | O(1) | O(n) | O(1) |
| Is Subsequence | O(n*m) | O(1) | O(n+m) | O(1) |
| Summary Ranges | O(n^2) | O(n) | O(n) | O(n) |
| Longest Common Prefix | O(n*m) | O(1) | O(n log n) | O(1) |
| Best Time to Buy & Sell Stock | O(n^2) | O(1) | O(n) | O(1) |

## How to Run

```bash
javac FileName.java && java FileName
```

Example:

```bash
javac FindClosestNumberToZeroBrute.java && java FindClosestNumberToZeroBrute
javac FindClosestNumberToZeroOptimal.java && java FindClosestNumberToZeroOptimal
```
