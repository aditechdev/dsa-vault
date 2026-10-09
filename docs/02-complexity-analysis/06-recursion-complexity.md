# Recursion Complexity

## 1. What Is Recursion?

Recursion occurs when a method calls itself to solve a smaller version of a problem.

A recursive method generally needs:

1. A base case that stops the recursion.
2. A recursive case that makes progress toward the base case.

Example:

```java
void fun(int n) {
    if (n <= 0) {
        return;
    }

    System.out.println(n);
    fun(n - 1);
}
```

The calls progress as follows:

```text
fun(3)
  ↓
fun(2)
  ↓
fun(1)
  ↓
fun(0)
```

---

## 2. The Call Stack

When a method calls another method, the current method's execution state must be preserved until the called method returns.

Recursive calls create multiple simultaneously active stack frames.

For the previous example:

```text
fun(3)  ← active
  fun(2)  ← active
    fun(1)  ← active
      fun(0)  ← active
```

At the deepest point, four calls are active.

For general input `n`, the maximum depth is proportional to `n`.

Auxiliary Space: `O(n)`

The base-case call also occupies a stack frame while it executes.

---

## 3. Linear Recursion

```java
void fun(int n) {
    if (n <= 1) {
        return;
    }

    fun(n - 1);
}
```

Each call makes one recursive call with an input smaller by 1.

### Time

The number of calls is proportional to `n`.

Time Complexity: `O(n)`

### Space

Maximum recursion depth is proportional to `n`.

Auxiliary Space: `O(n)`

Final:

- Time: `O(n)`
- Auxiliary Space: `O(n)`

---

## 4. Recursion That Halves the Input

```java
void fun(int n) {
    if (n <= 1) {
        return;
    }

    fun(n / 2);
}
```

For positive integer input:

```text
n → n/2 → n/4 → n/8 → ... → 1
```

The input is halved at each step.

### Time

Number of recursive calls: `O(log n)`

Time Complexity: `O(log n)`

### Space

Maximum stack depth: `O(log n)`

Auxiliary Space: `O(log n)`

Final:

- Time: `O(log n)`
- Auxiliary Space: `O(log n)`

---

## 5. Branching Recursion

```java
void fun(int n) {
    if (n <= 1) {
        return;
    }

    fun(n - 1);
    fun(n - 1);
}
```

Each non-base call makes two recursive calls.

### Recursion tree

```text
                    n
                 /     \
              n-1       n-1
             /  \       /  \
          n-2  n-2   n-2  n-2
```

The number of calls grows exponentially.

A simplified recurrence is:

`T(n) = 2T(n - 1) + O(1)`

Therefore:

- Time: `O(2ⁿ)`
- Auxiliary Space: `O(n)`

### Why is space only O(n)?

The method completes one recursive branch before proceeding to the other branch.

The maximum active depth is linear, even though the total number of calls is exponential.

**Total calls determine the total work; maximum simultaneous stack depth helps determine stack space.**

---

## 6. Two Recursive Calls on Half the Input

```java
void fun(int n) {
    if (n <= 1) {
        return;
    }

    fun(n / 2);
    fun(n / 2);
}
```

The recurrence is:

`T(n) = 2T(n/2) + O(1)`

The recursion tree has `O(log n)` levels. The number of calls approximately doubles at each level, while the input size per call halves.

The total number of calls is `O(n)`.

Therefore:

- Time: `O(n)`
- Auxiliary Space: `O(log n)`

Space depends on the maximum active path through the tree, not the total number of nodes in the recursion tree.

---

## 7. Recursion with Additional Arrays

```java
void fun(int n) {
    if (n <= 1) {
        return;
    }

    int[] temp = new int[n];

    fun(n / 2);
}
```

Each active recursive frame retains an array whose size depends on that frame's input.

At the deepest point, the active arrays have sizes approximately:

```text
n + n/2 + n/4 + n/8 + ...
```

This geometric series is less than `2n`.

Therefore:

- Recursion stack: `O(log n)`
- Arrays across active frames: `O(n)`
- Total auxiliary space: `O(n)`

**Important:** Recursion depth alone does not always determine total auxiliary space. Account for memory allocated by every simultaneously active frame.

---

## 8. Recursion Without Additional Structures

```java
int factorial(int n) {
    if (n <= 1) {
        return 1;
    }

    return n * factorial(n - 1);
}
```

For `n >= 1`, the recursion has linear depth.

- Time: `O(n)`
- Auxiliary Space: `O(n)`

This assumes ordinary recursive execution and counts the call stack.

A mathematically constant-size return value does not eliminate the stack frames.

---

## 9. Recursion with a Loop

```java
void fun(int n) {
    if (n <= 1) {
        return;
    }

    for (int i = 0; i < n; i++) {
        System.out.println(i);
    }

    fun(n / 2);
}
```

The work at each level is approximately:

```text
n + n/2 + n/4 + n/8 + ...
```

The geometric sum is less than `2n`.

Therefore:

- Time: `O(n)`
- Auxiliary Space: `O(log n)`

The loop uses constant extra memory. The recursive stack has logarithmic depth.

---

## 10. Recursion with a Growing Result

```java
void fun(int n, List<Integer> result) {
    if (n <= 0) {
        return;
    }

    result.add(n);
    fun(n - 1, result);
}
```

Assume `result` is created outside the method and passed into the recursion.

The method makes `O(n)` calls and appends `n` values.

- Time: `O(n)` average amortized for appends to a typical ArrayList.
- Result storage: `O(n)`.
- Additional recursion stack: `O(n)`.

If the question asks for auxiliary space of the entire operation, including the newly built result, the space is `O(n)`.

If the interviewer excludes the supplied result/input structure from auxiliary space, state that convention explicitly. The recursion stack is still `O(n)`.

---

## 11. Recursion Complexity Summary

| Recursion pattern | Time | Stack space |
|---|---:|---:|
| `fun(n - 1)` once | `O(n)` | `O(n)` |
| `fun(n / 2)` once | `O(log n)` | `O(log n)` |
| `fun(n - 1)` twice | `O(2ⁿ)` | `O(n)` |
| `fun(n / 2)` twice | `O(n)` | `O(log n)` |
| `fun(n / 2)` plus `O(n)` work per call | `O(n)` | `O(log n)` |

These results assume the shown patterns, constant work per call unless stated otherwise, and no additional growing structures unless stated otherwise.

---

## 12. How to Analyze Recursive Time Complexity

### Step 1: Identify the base case

Determine when recursion stops.

### Step 2: Count recursive calls per invocation

Does each call make one, two, or more recursive calls?

### Step 3: Identify the size reduction

Does the input become:

- `n - 1`
- `n / 2`
- another smaller fraction or subproblem?

### Step 4: Count the work per call

For example, a loop from `0` to `n - 1` contributes `O(n)` work at that level.

### Step 5: Form a recurrence

Examples:

```text
T(n) = T(n - 1) + O(1)
T(n) = T(n / 2) + O(1)
T(n) = 2T(n - 1) + O(1)
T(n) = 2T(n / 2) + O(1)
```

### Step 6: Solve the recurrence

Use expansion, a recursion tree, or an appropriate recurrence-solving method.

### Step 7: Analyze space independently

Determine maximum active stack depth and any additional structures retained by active calls.

---

## 13. Common Mistakes

- Assuming all recursive methods take `O(n)` time.
- Confusing recursion depth with the total number of calls.
- Assuming branching recursion necessarily has exponential space.
- Ignoring arrays or collections allocated in recursive frames.
- Forgetting the base-case call when counting exact stack frames.
- Adding the entire recursion tree's nodes when analyzing stack space.
- Ignoring the memory used by a result that grows during recursion.
- Treating recursion stack space as zero because no explicit array is created.

---

## 14. Interview Checklist

For every recursive method, answer:

1. What is the base case?
2. How many recursive calls does each invocation make?
3. How does the input size change?
4. How much non-recursive work happens per call?
5. What is the total number of calls or total work?
6. What is the maximum recursion depth?
7. What additional memory is retained by each active frame?
8. Does the algorithm build or retain a result structure?

## Key Takeaway

**Recursive time measures total work. Recursive stack space measures simultaneously active calls.** Additional structures created by those calls must be analyzed separately.