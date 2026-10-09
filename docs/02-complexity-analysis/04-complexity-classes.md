# Complexity Classes

## 1. Overview

Complexity classes describe how an algorithm's resource requirements grow with input size `n`.

This file focuses on common growth rates encountered in DSA interviews.

## 2. Common Complexity Classes

| Complexity | Name | Typical example |
|---|---|---|
| `O(1)` | Constant | Access an array element by index |
| `O(log n)` | Logarithmic | Binary search |
| `O(√n)` | Square-root | Trial division up to the square root |
| `O(n)` | Linear | Traverse an array |
| `O(n log n)` | Linearithmic | Merge sort |
| `O(n²)` | Quadratic | Compare every pair |
| `O(n³)` | Cubic | Examine every triple |
| `O(2ⁿ)` | Exponential | Generate all subsets |
| `O(n!)` | Factorial | Generate all permutations |

These are typical examples, not universal guarantees for every implementation.

---

## 3. O(1) — Constant Time

The operation count remains independent of `n`.

```java
int first = arr[0];
```

Assuming the array is non-empty, accessing an element by index takes constant time.

Time Complexity: `O(1)`

Auxiliary Space: `O(1)`

Another example:

```java
int a = 10;
int b = 20;
int sum = a + b;
```

A fixed number of primitive variables uses `O(1)` auxiliary space.

---

## 4. O(log n) — Logarithmic Time

Logarithmic complexity commonly appears when a problem size is repeatedly divided by a constant factor.

```java
int value = n;

while (value > 1) {
    value /= 2;
}
```

For positive integer `n`, the number of iterations is proportional to `log₂ n`.

Time Complexity: `O(log n)`

Auxiliary Space: `O(1)`

### Why?

The values shrink approximately like this:

```text
n → n/2 → n/4 → n/8 → ... → 1
```

After `k` divisions, the value is approximately:

`n / 2ᵏ`

Set it equal to 1:

`n / 2ᵏ = 1`

Therefore:

`2ᵏ = n`

Taking the logarithm:

`k = log₂ n`

The base of a logarithm does not affect its Big-O class when the base is a fixed constant greater than 1.

---

## 5. O(√n) — Square-Root Time

Example: trial division for checking whether an integer is prime.

```java
boolean isPrime(int n) {
    if (n < 2) {
        return false;
    }

    for (int i = 2; i <= n / i; i++) {
        if (n % i == 0) {
            return false;
        }
    }

    return true;
}
```

In the worst case, the loop checks divisors up to approximately `√n`.

Time Complexity: `O(√n)`

Auxiliary Space: `O(1)`

Why only up to the square root? If `n = a × b`, at least one of the factors must be no greater than `√n`.

---

## 6. O(n) — Linear Time

```java
int sum = 0;

for (int i = 0; i < n; i++) {
    sum += i;
}
```

The loop performs `n` iterations.

Time Complexity: `O(n)`

Auxiliary Space: `O(1)`

Typical examples:
- Traversing an array.
- Finding a maximum.
- Counting occurrences with a single pass.

---

## 7. O(n log n) — Linearithmic Time

A common example is merge sort.

Merge sort divides the array into halves, producing approximately `log₂ n` levels. Across each level, merging processes a total of `O(n)` elements.

Therefore:

`O(n) × O(log n) = O(n log n)`

Typical merge sort complexities:

- Time: `O(n log n)`
- Auxiliary Space for a standard array implementation: `O(n)`

---

## 8. O(n²) — Quadratic Time

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

Total iterations:

`n × n = n²`

Time Complexity: `O(n²)`

Auxiliary Space: `O(1)`

Typical example: comparing every pair of elements.

---

## 9. O(n³) — Cubic Time

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
            System.out.println(i + j + k);
        }
    }
}
```

Total iterations:

`n × n × n = n³`

Time Complexity: `O(n³)`

Auxiliary Space: `O(1)`

Three nested loops do not automatically imply `O(n³)`; their actual bounds must be analyzed.

---

## 10. O(2ⁿ) — Exponential Time

Consider:

```java
void fun(int n) {
    if (n <= 0) {
        return;
    }

    fun(n - 1);
    fun(n - 1);
}
```

Each non-base call produces two recursive calls.

The recurrence is:

`T(n) = 2T(n - 1) + O(1)`

Time Complexity: `O(2ⁿ)`

Auxiliary Space: `O(n)`

The recursion tree has exponentially many calls, but its maximum depth is linear.

This is an important distinction between total work and maximum simultaneous memory.

---

## 11. O(n!) — Factorial Time

Generating every permutation of `n` distinct elements produces `n!` permutations.

For example:

```text
n = 3

ABC
ACB
BAC
BCA
CAB
CBA
```

There are:

`3! = 6` permutations.

The number of permutations grows factorially.

Time is at least `Ω(n!)` just to generate all permutations, and often `O(n × n!)` if each permutation is copied or printed in `O(n)` time.

Space depends on the implementation. A backtracking generator can use `O(n)` auxiliary stack/path space if it emits results without retaining them all; storing every permutation requires `O(n × n!)` output space.

---

## 12. Growth-Rate Intuition

For sufficiently large inputs, common growth rates generally increase in this order:

```text
O(1)
  <
O(log n)
  <
O(√n)
  <
O(n)
  <
O(n log n)
  <
O(n²)
  <
O(n³)
  <
O(2ⁿ)
  <
O(n!)
```

This is a useful general comparison of growth rates, not a promise about runtime for every input size or implementation.

---

## 13. Complexity Class Recognition

| Code pattern | Typical time |
|---|---|
| Fixed number of operations | `O(1)` |
| Repeatedly divide input by 2 | `O(log n)` |
| One pass over `n` elements | `O(n)` |
| One full loop inside another | `O(n²)` |
| Three full nested loops | `O(n³)` |
| `n` work repeated for `log n` levels | `O(n log n)` |
| Two recursive calls on `n - 1` | `O(2ⁿ)` |
| Enumerate all permutations | Factorial growth |

Always examine the actual code or recurrence before assigning a class.

---

## 14. Common Mistakes

- Confusing logarithmic depth with total recursive work.
- Assuming every recursive algorithm is exponential.
- Assuming every nested loop is quadratic or cubic.
- Ignoring output storage in enumeration problems.
- Assuming time and space have the same complexity.
- Forgetting that early returns can improve best-case time without changing worst-case time.

## Key Takeaway

Learn to recognize the growth pattern, then verify it using loop bounds, operation counts, or a recurrence relation.