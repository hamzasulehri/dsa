# dsa

Solutions for the Data Structures & Algorithms (DSA) Programming Assignment.
Every problem is solved twice — first a **Brute Force** approach to
establish correctness, then an **Optimal** approach to improve time/space
complexity. All solutions are written in Java.

## Repository Structure

```
dsa/
├── arrays-strings/
│   ├── brute/
│   └── optimal/
├── hash-tables/
│   ├── brute/
│   └── optimal/
├── two-pointers/
│   ├── brute/
│   └── optimal/
├── binary-trees/
│   ├── brute/
│   └── optimal/
├── linked-lists/
│   ├── brute/
│   └── optimal/
├── heaps/
│   ├── brute/
│   └── optimal/
└── README.md
```

## Topics

| Topic | Problems | README |
|---|---|---|
| Arrays & Strings | 5 | [arrays-strings/README.md](./arrays-strings/README.md) |
| Hash Tables | 5 | [hash-tables/README.md](./hash-tables/README.md) |
| Two Pointers | 3 | [two-pointers/README.md](./two-pointers/README.md) |
| Binary Trees | 7 | [binary-trees/README.md](./binary-trees/README.md) |
| Linked Lists | 3 | [linked-lists/README.md](./linked-lists/README.md) |
| Heaps | 3 | [heaps/README.md](./heaps/README.md) |

Each topic README contains:
- **Problem List** — name, difficulty, LeetCode link
- **Approach** — brute force vs optimal strategy per problem
- **Complexity Table** — time and space complexity for both approaches
- **How to Run** — `javac FileName.java && java FileName`

## File Naming Convention

`ProblemNameBrute.java` / `ProblemNameOptimal.java` — PascalCase matching
the public class name inside the file. Each file contains exactly one
public class with a `main()` method printing output for a sample test case.

## How to Run Any Solution

```bash
javac FileName.java && java FileName
```

Example:

```bash
cd arrays-strings/brute
javac FindClosestNumberToZeroBrute.java && java FindClosestNumberToZeroBrute
```
