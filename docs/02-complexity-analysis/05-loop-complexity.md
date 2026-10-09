# Loop Complexity

## 1. Introduction

Loop Complexity analyzes how many times a loop body executes as the input size grows.

The two main questions are:

1. How many iterations execute? This helps determine time complexity.
2. What memory remains allocated during execution? This helps determine auxiliary space complexity.

Do not infer space complexity from the number of loops alone.

---

## 2. Constant-Time Loop

```java
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}
```

The loop always runs 10 times, regardless of `n`.

Time Complexity: `O(1)`

Auxiliary Space: `O(1)`

A fixed iteration count is constant with respect to the input size.

---

## 3. Linear Loop

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Iterations: `n`

Time Complexity: `O(n)`

Auxiliary Space: `O(1)`

The loop counter is a fixed amount of additional memory.

---

## 4. Sequential Loops

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}

for (int j = 0; j < n; j++) {
    System.out.println(j);
}
```

First loop: `O(n)`

Second loop: `O(n)`

Total:

`O(n) + O(n) = O(2n) = O(n)`

Sequential loops are added, not multiplied.

### Different bounds

```java
for (int i = 0; i < n; i++) {
    // O(n)
}

for (int j = 0; j < n * n; j++) {
    // O(n²)
}
```

Total:

`O(n) + O(n²) = O(n²)`

Keep the dominant term.

---

## 5. Nested Loops with Equal Bounds

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

The outer loop executes `n` times.

The inner loop executes `n` times for each outer iteration.

Total:

`n × n = n²`

Time Complexity: `O(n²)`

Auxiliary Space: `O(1)`

The nested structure does not itself require an `n × n` array.

---

## 6. Nested Loops with a Constant Inner Bound

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < 10; j++) {
        System.out.println(j);
    }
}
```

The outer loop executes `n` times.

The inner loop executes 10 times per outer iteration.

Total:

`n × 10 = 10n`

Time Complexity: `O(n)`

Auxiliary Space: `O(1)`

A constant bound such as 10 does not grow with `n`.

---

## 7. Three Nested Loops

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

This result assumes all three loops have bounds proportional to `n`.

---

## 8. Variable Inner Bound

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
        System.out.println(j);
    }
}
```

The number of inner iterations changes with `i`.

| Outer `i` | Inner iterations |
|---:|---:|
| 0 | 0 |
| 1 | 1 |
| 2 | 2 |
| 3 | 3 |
| ... | ... |
| `n - 1` | `n - 1` |

Total:

`0 + 1 + 2 + ... + (n - 1)`

The sum of the first `n - 1` non-negative integers is:

`n(n - 1) / 2`

Expanding:

`(n² - n) / 2`

Ignoring constants and lower-order terms:

Time Complexity: `O(n²)`

Auxiliary Space: `O(1)`

### Important distinction

For the last outer iteration, `i = n - 1`.

The inner loop's largest possible `j` is `n - 2`, but it performs `n - 1` iterations: from `0` through `n - 2`.

The maximum value of a loop variable and the number of iterations are not the same thing.

---

## 9. Another Variable-Bound Pattern

```java
for (int i = 1; i < n; i *= 2) {
    System.out.println(i);
}
```

Values approximately double:

```text
1, 2, 4, 8, 16, ...
```

After `k` iterations, `i` is approximately `2ᵏ`.

The loop stops when `2ᵏ` reaches `n`.

Therefore:

`k = O(log n)`

Time Complexity: `O(log n)`

Auxiliary Space: `O(1)`

This is different from a loop that increments `i` by 1.

---

## 10. Nested Loops That Divide the Input

```java
for (int i = 0; i < n; i++) {
    int j = n;

    while (j > 1) {
        j /= 2;
    }
}
```

The outer loop executes `n` times.

The inner loop takes `O(log n)` time.

Total:

`O(n) × O(log n) = O(n log n)`

Auxiliary Space: `O(1)`

---

## 11. Loop Complexity Does Not Automatically Determine Space

### Example A: No growing structure

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

Time: `O(n²)`

Auxiliary Space: `O(1)`

### Example B: Growing structure

```java
int[] result = new int[n];

for (int i = 0; i < n; i++) {
    result[i] = i;
}
```

Time: `O(n)`

Auxiliary Space: `O(n)`

### Example C: Temporary structure

```java
for (int i = 0; i < n; i++) {
    int[] temp = new int[n];
    temp[0] = i;
}
```

Assuming old temporary arrays are no longer reachable and nothing retains them, the peak space for the temporary arrays is `O(n)`, not `O(n²)`.

Garbage collection timing does not itself determine asymptotic live space; what matters is which objects remain reachable and retained. Actual JVM heap occupancy can temporarily be higher.

---

## 12. Mixed Loop Example

```java
int[] result = new int[n];

for (int i = 0; i < n; i++) {
    result[i] = i;
}

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(result[i] + result[j]);
    }
}
```

Time:

- First loop: `O(n)`
- Nested loops: `O(n²)`

Total:

`O(n) + O(n²) = O(n²)`

Auxiliary Space:

- `result`: `O(n)`

Final:

- Time: `O(n²)`
- Auxiliary Space: `O(n)`

---

## 13. Loop Analysis Checklist

For each loop:

1. Identify its starting value.
2. Identify its termination condition.
3. Determine how the loop variable changes.
4. Calculate the number of iterations.
5. Analyze nested loops using their actual bounds.
6. Add sequential work.
7. Simplify the final expression.
8. Analyze memory separately.

## Common Mistakes

- Multiplying sequential loops.
- Assuming a constant inner bound is proportional to `n`.
- Treating `j < i` as `n` inner iterations on every pass.
- Confusing the largest loop-variable value with the iteration count.
- Assuming nested loops automatically require quadratic space.
- Ignoring loops whose variables double or halve.

## Key Takeaway

**Count the iterations first; simplify to Big-O second.** Then perform a separate space analysis.