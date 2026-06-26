# Two Pointers

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|----------------|
| 1 | Reverse String | Easy | [Reverse String](https://leetcode.com/problems/reverse-string/) |
| 2 | Valid Palindrome | Easy | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) |
| 3 | Container With Most Water | Medium | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) |

## Approach

**Reverse String** — Brute force builds a second array filled from the back,
then copies it over the original, using O(n) extra space. The optimal
solution swaps characters in-place using two pointers (one at each end)
moving toward the centre, needing O(1) space.

**Valid Palindrome** — Brute force builds a cleaned (lowercase,
alphanumeric-only) string, then builds a second reversed copy and compares
them, using O(n) extra space. The optimal solution uses two pointers
starting at both ends of the original string, skipping non-alphanumeric
characters and comparing in place, with O(1) space.

**Container With Most Water** — Brute force checks every pair of wall
heights to find the maximum area (O(n^2)). The optimal solution uses two
pointers starting at both ends; the pointer at the shorter wall always moves
inward, since the area can never improve by moving the taller wall first.
This gives a single O(n) pass.

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---|---|---|---|---|
| Reverse String | O(n) | O(n) | O(n) | O(1) |
| Valid Palindrome | O(n) | O(n) | O(n) | O(1) |
| Container With Most Water | O(n^2) | O(1) | O(n) | O(1) |

## How to Run

```bash
javac FileName.java && java FileName
```

Example:

```bash
javac ContainerWithMostWaterBrute.java && java ContainerWithMostWaterBrute
javac ContainerWithMostWaterOptimal.java && java ContainerWithMostWaterOptimal
```
