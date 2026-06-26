# Hash Tables

## Problem List

| # | Problem | Difficulty | LeetCode Link |
|---|---------|------------|----------------|
| 1 | Contains Duplicate | Easy | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/) |
| 2 | Two Sum | Easy | [Two Sum](https://leetcode.com/problems/two-sum/) |
| 3 | Maximum Number of Balloons | Easy | [Maximum Number Of Balloons](https://leetcode.com/problems/maximum-number-of-balloons/) |
| 4 | Valid Anagram | Easy | [Valid Anagram](https://leetcode.com/problems/valid-anagram/) |
| 5 | Group Anagrams | Medium | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) |

## Approach

**Contains Duplicate** — Brute force sorts the array and compares adjacent
elements (O(n log n)). The optimal solution uses a `HashSet` to detect a
repeat the moment it's seen, giving O(n) average time at the cost of O(n)
space.

**Two Sum** — Brute force checks every pair of indices (O(n^2)). The optimal
solution stores each number's complement in a `HashMap` as it scans, so a
match can be found in a single O(n) pass.

**Maximum Number of Balloons** — Brute force repeatedly re-counts the whole
string for increasing candidate counts `k` until it fails. The optimal
solution counts each letter's frequency once with a map, then divides by how
many times that letter appears in the word "balloon" (`l` and `o` need 2
each), taking the minimum ratio across all five required letters.

**Valid Anagram** — Brute force sorts both strings and compares them
(O(n log n)). The optimal solution uses a fixed 26-element frequency array,
incrementing for `s` and decrementing for `t` — if all counts return to
zero, the strings are anagrams, in O(n) time.

**Group Anagrams** — Brute force compares every word against every other
word using a character-count equality check (O(n^2 * k)). The optimal
solution sorts each word's characters to build a canonical key, then groups
words sharing a key in a `HashMap`, in O(n * k log k) time.

## Complexity Table

| Problem | Brute Time | Brute Space | Optimal Time | Optimal Space |
|---|---|---|---|---|
| Contains Duplicate | O(n log n) | O(1) | O(n) | O(n) |
| Two Sum | O(n^2) | O(1) | O(n) | O(n) |
| Maximum Number of Balloons | O(n * maxCount) | O(1) | O(n) | O(1) |
| Valid Anagram | O(n log n) | O(n) | O(n) | O(1) |
| Group Anagrams | O(n^2 * k) | O(n*k) | O(n * k log k) | O(n*k) |

## How to Run

```bash
javac FileName.java && java FileName
```

Example:

```bash
javac TwoSumBrute.java && java TwoSumBrute
javac TwoSumOptimal.java && java TwoSumOptimal
```
