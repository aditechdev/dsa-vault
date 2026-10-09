# Big-O Notation

## 1. What Is Big-O Notation?

Big-O notation describes how an algorithm's resource requirements grow as the input size increases.

We commonly analyze two resources:

- **Time Complexity:** How the number of operations grows with input size.
- **Space Complexity:** How memory usage grows with input size.

Big-O helps us compare algorithms independently of the computer, programming language, and exact execution time.

### Example

```java
int sum = 0;

for (int i = 0; i < n; i++) {
    sum += i;
}
```

The loop executes `n` times.

- Time Complexity: `O(n)`
- Auxiliary Space: `O(1)`

Here, `n` represents the input size.

---

## 2. Why Do We Need Big-O?

Suppose two algorithms solve the same problem.

| Input size | Algorithm A: `O(n)` | Algorithm B: `O(n²)` |
|---:|---:|---:|
| 10 | 10 | 100 |
| 100 | 100 | 10,000 |
| 1,000 | 1,000 | 1,000,000 |
| 10,000 | 10,000 | 100,000,000 |

These are illustrative operation counts, not measured execution times.

As input grows, an `O(n)` algorithm generally scales much better than an `O(n²)` algorithm.

Big-O helps us reason about scalability.

---

## 3. What Does `n` Mean?

`n` represents the size of the input.

Examples:

- Array: number of elements.
- String: number of characters.
- Matrix: dimensions such as `n × m`.
- Linked list: number of nodes.
- Graph: number of vertices and edges.
- HashMap: number of entries.

Always identify what the input-size variable represents before analyzing complexity.

For a graph, for example, we may need both `V` (vertices) and `E` (edges).

---

## 4. The Formal Definition

A function `f(n)` is `O(g(n))` if there exist positive constants `c` and `n₀` such that:

`0 ≤ f(n) ≤ c · g(n)` for every `n ≥ n₀`.

In simpler terms, beyond a sufficiently large input size, `f(n)` is bounded above by a constant multiple of `g(n)`.

For everyday DSA analysis, we usually identify the dominant growth rate rather than calculate these constants explicitly.

**Important:** Big-O is an asymptotic upper bound. It is often used to express worst-case complexity in interviews, but Big-O itself does not automatically mean worst case.

---

## 5. The Three Simplification Rules

### Rule 1: Ignore Constant Factors

```text
O(2n)   → O(n)
O(5n)   → O(n)
O(100n) → O(n)

O(3n²)  → O(n²)
```

A constant multiplier does not change the asymptotic growth class.

### Rule 2: Keep the Dominant Term

```text
O(n² + n)       → O(n²)
O(n³ + n² + n)  → O(n³)
O(n² + 100n + 5) → O(n²)
```

The fastest-growing term dominates as `n` becomes large.

### Rule 3: Simplify After Combining the Work

Sequential operations are added:

```text
O(n) + O(n) = O(2n) = O(n)
```

Nested loops may multiply their iteration counts:

```text
n × n = n²
```

Always analyze the actual work before simplifying.

---

## 6. Sequential Loops

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}

for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

First loop: `O(n)`

Second loop: `O(n)`

Total:

`O(n) + O(n) = O(n)`

The loops run one after another, not inside each other.

---

## 7. Nested Loops

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

The outer loop runs `n` times.

For each outer iteration, the inner loop runs `n` times.

Total operations:

`n × n = n²`

Time Complexity: `O(n²)`

Nested loops do not always imply `O(n²)`. Their actual bounds determine the number of iterations.

---

## 8. Big-O for Time and Space

These are separate analyses.

```java
int[] result = new int[n];

for (int i = 0; i < n; i++) {
    result[i] = i;
}
```

- Time Complexity: `O(n)`
- Auxiliary Space Complexity: `O(n)`

Compare this example:

```java
int sum = 0;

for (int i = 0; i < n; i++) {
    sum += i;
}
```

- Time Complexity: `O(n)`
- Auxiliary Space Complexity: `O(1)`

The number of iterations determines time, while the extra memory that grows with the input determines auxiliary space.

---

## 9. Big-O and Other Asymptotic Notations

### Big-O: `O(g(n))`

An asymptotic upper bound.

### Big-Omega: `Ω(g(n))`

An asymptotic lower bound.

### Big-Theta: `Θ(g(n))`

A tight asymptotic bound: the function is bounded above and below by constant multiples of `g(n)` for sufficiently large `n`.

Example:

`3n² + 5n + 2 = Θ(n²)`

It is also `O(n²)` and `Ω(n²)`.

---

## 10. Common Mistakes

- Treating `O(2n)` as `O(n²)`.
- Adding sequential loops and incorrectly getting `O(n²)`.
- Ignoring the dominant term.
- Assuming nested loops always have the same complexity.
- Confusing time complexity with space complexity.
- Assuming Big-O always means worst case.
- Treating Big-O as an exact count of operations or seconds.

---

## 11. Interview Checklist

Before stating a complexity:

1. Identify the input size.
2. Count how many times the important operations execute.
3. Combine sequential and nested work correctly.
4. Simplify constants and lower-order terms.
5. Analyze auxiliary space separately.
6. State assumptions when they matter, such as average-case HashMap operations.

## Key Takeaway

Big-O describes asymptotic growth. It helps us understand how an algorithm scales, rather than how many seconds it takes on one particular machine.