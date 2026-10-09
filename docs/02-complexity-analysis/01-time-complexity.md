# 📌 Java DSA — Collections Revision & Time Complexity

![Java](https://img.shields.io/badge/Language-Java-orange?logo=openjdk)
![Topic](https://img.shields.io/badge/Topic-DSA-blue)
![Level](https://img.shields.io/badge/Level-Beginner-green)
![Status](https://img.shields.io/badge/Time%20Complexity-In%20Progress-yellow)

## ❓ 1. Learning Objectives

This document revises the Java Collections foundation and Time Complexity concepts covered during interactive learning.

By the end of this revision, you should be able to:

- Choose a suitable Java Collection based on a problem requirement.
- Understand input size `n`.
- Estimate how the number of operations grows.
- Recognize `O(1)`, `O(log n)`, `O(n)`, `O(n log n)`, `O(n²)` and `O(n³)`.
- Analyze sequential and nested loops.
- Simplify complexity expressions.
- Distinguish best-case, average-case and worst-case complexity.

**Learning status**

- Java fundamentals needed for DSA: Completed at foundation level.
- Seven core Java Collections: Completed at foundation level.
- Collection selection practice: Completed.
- Time Complexity: Core concepts introduced; further practice pending.
- Space Complexity: Not started.

---

# Part A — Java Collections

## 🧠 2. Collections Overview

Java Collections provide data structures for storing, organizing and processing data.

Different structures solve different problems. The best choice depends on how data needs to be accessed, inserted, removed or searched.

| Collection | Primary purpose | Important property |
|---|---|---|
| `ArrayList` | Store a sequence of elements | Index-based access |
| `HashMap` | Associate keys with values | Key-value lookup |
| `HashSet` | Store unique elements | No duplicate elements |
| `Queue` | Process elements in FIFO order | First in, first out |
| `Deque` | Operate on both ends | Double-ended queue |
| `Stack` | Process the most recent element first | LIFO |
| `PriorityQueue` | Process elements by priority | Head determined by ordering |

## 3. ArrayList

### Purpose

Use `ArrayList` when you need an ordered sequence and frequent index-based access.

```java
import java.util.ArrayList;
import java.util.List;

List<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers.get(1)); // 20
```

### Important properties

- Maintains insertion order.
- Allows duplicate values.
- Supports index-based access.
- Can grow dynamically.
- Allows `null` elements.

### Common operations

| Operation | Typical time complexity |
|---|---:|
| `get(index)` | `O(1)` |
| `set(index, value)` | `O(1)` |
| `add(value)` at end | Amortized `O(1)` |
| Insert at a specified position | `O(n)` |
| Remove by index | `O(n)` in general |
| `contains(value)` | `O(n)` |

The cost of insertion or removal in the middle generally comes from shifting elements.

## 4. HashMap

### Purpose

Use `HashMap` when you need to associate a key with a value.

```java
import java.util.HashMap;
import java.util.Map;

Map<Integer, String> users = new HashMap<>();

users.put(101, "Amit");
users.put(102, "Priya");
users.put(103, "Rahul");

System.out.println(users.get(102)); // Priya
```

### Important properties

- Keys are unique.
- Values can be duplicated.
- Adding an existing key replaces its associated value.
- Does not guarantee iteration order.
- Allows one `null` key and multiple `null` values.
- Uses hashing to organize entries.

### Common operations

| Operation | Expected/typical complexity |
|---|---:|
| `put(key, value)` | `O(1)` |
| `get(key)` | `O(1)` |
| `containsKey(key)` | `O(1)` |
| `remove(key)` | `O(1)` |

These are expected or average-case costs under normal hashing assumptions, not unconditional worst-case guarantees.

### Frequency counting

```java
int[] arr = {4, 2, 7, 2, 9, 4, 1};

Map<Integer, Integer> frequency = new HashMap<>();

for (int value : arr) {
    frequency.put(
        value,
        frequency.getOrDefault(value, 0) + 1
    );
}
```

The resulting frequencies are:

```text
4 → 2
2 → 2
7 → 1
9 → 1
1 → 1
```

This pattern is fundamental to DSA problems involving frequencies, duplicates and counting.

## 5. HashSet

### Purpose

Use `HashSet` when you need to store unique elements or efficiently check whether an element has been encountered.

```java
import java.util.HashSet;
import java.util.Set;

Set<Integer> numbers = new HashSet<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);

System.out.println(numbers.size()); // 2
System.out.println(numbers.contains(20)); // true
```

### Important properties

- Does not allow duplicate elements.
- Does not guarantee iteration order.
- Allows one `null` element.
- Uses hashing.
- `add()` returns `false` if the element already exists.

### Common operations

| Operation | Expected complexity |
|---|---:|
| `add(value)` | `O(1)` |
| `contains(value)` | `O(1)` |
| `remove(value)` | `O(1)` |

### Duplicate detection

```java
Set<Integer> seen = new HashSet<>();

for (int value : arr) {
    if (!seen.add(value)) {
        System.out.println("Duplicate: " + value);
    }
}
```

A `HashSet` is useful when the question is about membership or uniqueness. A `HashMap` is useful when you also need to associate information with each value, such as its frequency.

## 6. Queue

### Purpose

Use a queue when elements should generally be processed in arrival order.

FIFO means **First In, First Out**.

```java
import java.util.ArrayDeque;
import java.util.Queue;

Queue<Integer> queue = new ArrayDeque<>();

queue.offer(10);
queue.offer(20);
queue.offer(30);

System.out.println(queue.poll()); // 10
System.out.println(queue.poll()); // 20
```

### Important operations

| Method | Behavior |
|---|---|
| `offer(value)` | Adds an element |
| `poll()` | Removes and returns the head, or `null` if empty |
| `peek()` | Returns the head without removing it, or `null` if empty |

Queues can support duplicate values. `ArrayDeque` does not allow `null` elements.

## 7. Deque

`Deque` means **Double-Ended Queue**.

It supports insertion and removal at both the front and back.

```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> deque = new ArrayDeque<>();

deque.offerFirst(20);
deque.offerLast(30);
deque.offerFirst(10);

System.out.println(deque); // [10, 20, 30]

System.out.println(deque.pollFirst()); // 10
System.out.println(deque.pollLast());  // 30
```

Common operations:

- `offerFirst()`
- `offerLast()`
- `pollFirst()`
- `pollLast()`
- `peekFirst()`
- `peekLast()`

A `Deque` can implement both stack-like and queue-like behavior.

## 8. Stack

### Purpose

Use a stack when the most recently added element should be processed first.

LIFO means **Last In, First Out**.

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop());  // 30
System.out.println(stack.peek()); // 20
```

Important methods:

| Method | Behavior |
|---|---|
| `push(value)` | Adds to the top |
| `pop()` | Removes and returns the top |
| `peek()` | Returns the top without removing it |
| `empty()` | Checks whether the stack is empty |

Calling `pop()` on an empty `Stack` throws `EmptyStackException`.

For modern Java code, `Deque` implemented by `ArrayDeque` is generally preferred for stack operations.

## 9. PriorityQueue

### Purpose

Use `PriorityQueue` when the next element must be determined by priority rather than arrival order.

By default, Java's `PriorityQueue<Integer>` is a min-priority queue.

```java
import java.util.PriorityQueue;
import java.util.Queue;

Queue<Integer> pq = new PriorityQueue<>();

pq.offer(30);
pq.offer(10);
pq.offer(20);

System.out.println(pq.peek()); // 10
System.out.println(pq.poll()); // 10
System.out.println(pq.poll()); // 20
```

Important properties:

- Duplicates are allowed.
- The head is determined by the ordering.
- Iterating over a `PriorityQueue` does not guarantee sorted order.
- The default ordering for integers places the smallest element at the head.
- A comparator can define a different ordering.

Typical complexities:

| Operation | Complexity |
|---|---:|
| `peek()` | `O(1)` |
| `offer()` | `O(log n)` |
| `poll()` | `O(log n)` |
| Build heap from a collection | `O(n)` |

For a max-priority queue:

```java
PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>((a, b) -> Integer.compare(b, a));
```

The comparator defines the ordering; it is not necessary to store only integers. A `PriorityQueue` can store objects when a suitable ordering is provided.

## 10. Collection Selection Cheat Sheet

| Requirement | Suitable structure |
|---|---|
| Access an element by index | `ArrayList` |
| Map an ID to a user | `HashMap` |
| Store unique values | `HashSet` |
| Process requests in arrival order | `Queue` |
| Add/remove at both ends | `Deque` |
| Undo the latest action | `Stack` or `Deque` |
| Retrieve the smallest element repeatedly | `PriorityQueue` |
| Count occurrences | `HashMap` |
| Detect duplicates | `HashSet` |
| Maintain sorted keys | `TreeMap` |
| Maintain insertion-ordered map entries | `LinkedHashMap` |

**Scope note:** `LinkedList`, `LinkedHashMap`, `LinkedHashSet`, `TreeMap` and `TreeSet` have not been covered in depth. They remain available for later study when a problem requires them.

---

# Part B — Time Complexity

## 11. What Is Time Complexity?

Time Complexity describes how the amount of computational work performed by an algorithm grows as the input size increases.

It does not directly measure elapsed seconds. Actual runtime also depends on hardware, implementation, language runtime and other factors.

Consider searching an array for a target.

```text
[10, 20, 30, 40, 50]
```

A linear search may inspect every element.

For an input containing one million elements, it may need up to one million comparisons.

The important question is:

**How does the amount of work grow when the input becomes larger?**

That is the central idea of time complexity.

## 12. What Does `n` Mean?

In complexity analysis, `n` commonly represents input size.

Examples:

- Array: number of elements.
- String: number of characters.
- Linked list: number of nodes.
- Tree: number of nodes.
- Graph: commonly use `V` for vertices and `E` for edges.

For an array containing five elements:

```text
arr = [10, 20, 30, 40, 50]

n = 5
```

If the array contains one thousand elements:

```text
n = 1000
```

The meaning of `n` depends on the input being analyzed.

## 13. What Is Big-O Notation?

Big-O notation describes an asymptotic upper bound on growth. In introductory algorithm analysis, it is commonly used to communicate an algorithm's worst-case growth when that is the case being analyzed.

Examples:

```text
O(1)        Constant
O(log n)    Logarithmic
O(n)        Linear
O(n log n)  Linearithmic
O(n²)       Quadratic
O(n³)       Cubic
```

These expressions describe how work scales as input size increases.

## 14. O(1) — Constant Time

The amount of work does not grow with `n`.

```java
int[] arr = {10, 20, 30, 40, 50};

int x = arr[0];
```

Direct array access takes constant time.

Whether the array contains 10 elements or one million elements, accessing a known valid index takes `O(1)` time under the usual RAM model.

Other examples include basic assignments and arithmetic operations on fixed-size primitive values.

**Important:** `O(1)` does not mean one second or necessarily one machine instruction. It means constant growth.

## 15. O(n) — Linear Time

Consider:

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

The loop body executes `n` times.

```text
n = 10       → 10 iterations
n = 100      → 100 iterations
n = 1000     → 1000 iterations
```

The amount of work grows proportionally to input size.

Therefore:

```text
Time Complexity = O(n)
```

## 16. Sequential Loops

Consider:

```java
for (int i = 0; i < n; i++) {
    // Work
}

for (int j = 0; j < n; j++) {
    // Work
}
```

The first loop performs approximately `n` iterations, and the second performs approximately `n` iterations.

Total work:

```text
n + n = 2n
```

We ignore the constant factor:

```text
O(2n) = O(n)
```

Three sequential loops also remain linear:

```text
n + n + n = 3n

O(3n) = O(n)
```

**Rule:** Sequential sections are analyzed by adding their work.

## 17. O(n²) — Quadratic Time

Consider:

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // Work
    }
}
```

For each outer-loop iteration, the inner loop runs `n` times.

Total iterations:

```text
n × n = n²
```

If `n = 10`, the inner statement executes 100 times.

If `n = 100`, it executes 10,000 times.

Therefore:

```text
Time Complexity = O(n²)
```

**Rule:** When an inner loop runs `n` times for every one of `n` outer iterations, multiply the counts.

### Three nested loops

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
            // Work
        }
    }
}
```

Total work:

```text
n × n × n = n³
```

Therefore:

```text
Time Complexity = O(n³)
```

When `n = 10`, the innermost statement executes 1,000 times.

**Important:** Three sequential loops are `O(n)`, not `O(n³)`. Nesting determines how loop counts combine.

## 18. Simplifying Complexity Expressions

### Rule 1 — Ignore constant factors

```text
O(2n)   → O(n)
O(3n)   → O(n)
O(100n) → O(n)
```

The constant factor does not change the asymptotic growth category.

### Rule 2 — Keep the dominant term

Consider:

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // Work
    }
}

for (int k = 0; k < n; k++) {
    // Work
}
```

Total work:

```text
n² + n
```

Since the quadratic term dominates the linear term as `n` grows:

```text
O(n² + n) = O(n²)
```

Other examples:

```text
O(n³ + n² + n) → O(n³)
O(n² + 5n + 10) → O(n²)
O(20n + 100) → O(n)
```

## 19. Understanding Logarithms From Zero

This was an important part of our learning session.

Before understanding `O(log n)`, we learned what a logarithm means.

### Powers of two

```text
2⁰  = 1
2¹  = 2
2²  = 4
2³  = 8
2⁴  = 16
2⁵  = 32
2⁶  = 64
2⁷  = 128
2⁸  = 256
2⁹  = 512
2¹⁰ = 1024
```

### What does `log₂(64)` mean?

It asks:

**Two raised to what power gives 64?**

We know:

```text
2⁶ = 64
```

Therefore:

```text
log₂(64) = 6
```

The logarithm answers the question of which exponent is needed.

More examples:

```text
log₂(8)  = 3
log₂(16) = 4
log₂(32) = 5
log₂(64) = 6
```

The small `2` is called the base.

## 20. O(log n) — Logarithmic Time

Suppose an algorithm repeatedly halves a problem:

```text
64
 ↓ divide by 2
32
 ↓ divide by 2
16
 ↓ divide by 2
8
 ↓ divide by 2
4
 ↓ divide by 2
2
 ↓ divide by 2
1
```

There are six halvings.

Since:

```text
log₂(64) = 6
```

the number of halving steps is related to `log₂(n)`.

This gives us the intuition behind logarithmic complexity.

### Java example

```java
int i = n;

while (i > 1) {
    i = i / 2;
}
```

For `n = 16`:

```text
16 → 8 → 4 → 2 → 1
```

The loop executes four times.

Therefore, its time complexity is:

```text
O(log n)
```

For arbitrary positive integer input, integer division and stopping conditions affect the exact number of iterations, but not the logarithmic growth rate.

### Why is logarithmic time efficient?

Consider an input of 1,024 elements:

```text
2¹⁰ = 1024

log₂(1024) = 10
```

An algorithm that halves the remaining search space each step needs roughly ten halving steps rather than checking every element individually.

Binary search is the classic example of this idea when applied to a sorted array.

### Why do we usually write `O(log n)` instead of `O(log₂ n)`?

The base of a logarithm changes its value only by a constant factor:

```text
logₐ(n) = logᵦ(n) / logᵦ(a)
```

For standard asymptotic Big-O analysis, that constant factor is ignored. Therefore, logarithm bases are usually omitted.

## 21. O(n log n) — Linearithmic Time

This complexity appears when `n` units of work are combined with approximately `log n` work per unit.

Consider:

```java
for (int i = 0; i < n; i++) {

    int x = n;

    while (x > 1) {
        x = x / 2;
    }
}
```

Analyze each part:

```text
Outer loop → O(n)

Inner loop → O(log n)
```

The inner loop executes for every outer iteration.

Total work:

```text
n × log n
```

Therefore:

```text
Time Complexity = O(n log n)
```

This pattern also appears in efficient sorting algorithms such as Merge Sort and Heap Sort, although their full complexity analysis requires understanding their algorithmic structure.

## 22. Complexity Comparison

| Complexity | General pattern | Example |
|---|---|---|
| `O(1)` | Fixed amount of work | `arr[0]` |
| `O(log n)` | Repeatedly reduce problem by a constant factor | Binary search |
| `O(n)` | Process each element once | Linear traversal |
| `O(n log n)` | Linear work across logarithmic levels | Merge Sort |
| `O(n²)` | Compare/process pairs with two nested loops | Simple pairwise comparisons |
| `O(n³)` | Three independent `n`-sized nested loops | Triple enumeration |

For sufficiently large inputs, these common growth rates generally become progressively more expensive as you move down the table.

## 23. Sequential vs Nested — Summary

### Sequential

```java
for (int i = 0; i < n; i++) {
    // O(n)
}

for (int j = 0; j < n; j++) {
    // O(n)
}
```

Total:

```text
n + n = 2n

O(n)
```

### Nested

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // O(1) work
    }
}
```

Total:

```text
n × n = n²

O(n²)
```

### Nested linear and logarithmic loops

```java
for (int i = 0; i < n; i++) {
    int x = n;

    while (x > 1) {
        x /= 2;
    }
}
```

Total:

```text
n × log n

O(n log n)
```

## 24. Best Case, Average Case and Worst Case

These terms describe different input scenarios for the same algorithm.

- **Best case:** The input scenario requiring the least work.
- **Average case:** Expected work under a specified probability distribution of inputs.
- **Worst case:** The input scenario requiring the most work.

### Linear search

```java
static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }

    return -1;
}
```

Consider:

```text
arr = [10, 20, 30, 40, 50]
```

#### Best case

```text
target = 10

Check 10 → found
```

One comparison.

```text
Best-case time = O(1)
```

#### Average case

If the target is guaranteed to be present and each position is equally likely:

```text
Checks = 1, 2, 3, 4, 5

Average = (1 + 2 + 3 + 4 + 5) / 5
        = 3
```

For `n` elements, the average number of checks is `(n + 1) / 2`, which grows linearly.

```text
Average-case time = O(n)
```

This average assumes the target is present and uniformly distributed across positions. Other input distributions can produce different average behavior.

#### Worst case

The target is last or absent:

```text
target = 50
```

or:

```text
target = 99
```

The algorithm checks every element.

```text
Worst-case time = O(n)
```

### Summary

| Case | Linear search |
|---|---|
| Best | `O(1)` |
| Average | `O(n)` under the stated assumptions |
| Worst | `O(n)` |

## 25. Common Mistakes and Gotchas

1. **Confusing loop iterations with memory usage.** A loop can execute `n` times without allocating `n` separate objects.
2. **Assuming all loops are cubic or quadratic.** Sequential loops and nested loops have different growth patterns.
3. **Keeping constant factors in the final Big-O expression.** `O(3n)` simplifies to `O(n)`.
4. **Keeping smaller terms unnecessarily.** `O(n² + n)` simplifies to `O(n²)`.
5. **Thinking `O(log n)` means one exact number of operations.** It describes growth; the exact count depends on the algorithm and input.
6. **Thinking `log₂(64)` means `2⁶`.** The expression `2⁶ = 64` is the power equation; `log₂(64) = 6` is its logarithmic form.
7. **Assuming average-case complexity is always half of worst-case complexity.** This depends on the algorithm and input distribution.
8. **Assuming a `PriorityQueue` iterates in sorted order.** Its head follows its priority ordering, but its iterator does not promise sorted traversal.
9. **Assuming `HashMap` or `HashSet` guarantees constant time in every possible case.** Their `O(1)` operation costs are expected/typical under normal hashing assumptions.
10. **Treating Java `LinkedList` usage as completing the Linked List DSA topic.** The node-based structure and its algorithms remain to be learned.

---

# Part C — Revision Exercises

Try solving these without looking at the answers immediately.

### Question 1

```java
int x = arr[0];
```

What is the time complexity, assuming the index is valid?

### Question 2

```java
for (int i = 0; i < n; i++) {
    // Work
}
```

What is the time complexity?

### Question 3

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        // Work
    }
}
```

What is the time complexity?

### Question 4

```java
int i = n;

while (i > 1) {
    i /= 2;
}
```

What is the time complexity?

### Question 5

```java
for (int i = 0; i < n; i++) {
    int x = n;

    while (x > 1) {
        x /= 2;
    }
}
```

What is the time complexity?

### Question 6

Simplify:

```text
O(n² + 5n + 10)
```

### Question 7

For linear search, what are the best- and worst-case time complexities?

### Question 8

Which collection would you choose to count occurrences of each integer in an array, and why?

---

## Answer Key

1. `O(1)`
2. `O(n)`
3. `O(n²)`
4. `O(log n)`
5. `O(n log n)`
6. `O(n²)`
7. Best: `O(1)`; worst: `O(n)`
8. `HashMap<Integer, Integer>` because it maps each integer to its frequency.

---

# Part D — What Comes Next?

## 26. Space Complexity — Pending

Space Complexity has **not been taught yet** in this learning checkpoint.

The next lesson starts from the question:

```java
int x = 10;
```

Does the additional memory required by this variable grow with the input size `n`?

Planned progression:

1. What memory means in the context of a program.
2. Input space vs auxiliary space.
3. `O(1)` auxiliary space.
4. `O(n)` auxiliary space.
5. Arrays and collections that allocate additional memory.
6. Multiple arrays and 2D arrays.
7. Space complexity of `ArrayList`, `HashMap` and `HashSet`.
8. Recursion stack space.
9. Analyzing time and space together.
10. Applying both to actual DSA problems.

## 27. Remaining Core DSA Roadmap

```text
Time Complexity
    Core concepts introduced; practice pending
        ↓
Space Complexity
        ↓
Arrays and Array Problems
        ↓
Strings
        ↓
Hashing Patterns
        ↓
Two Pointers
        ↓
Sliding Window
        ↓
Linked List
        ↓
Stack and Queue Problems
        ↓
Binary Search
        ↓
Sorting
        ↓
Recursion
        ↓
Backtracking
        ↓
Trees and Binary Search Trees
        ↓
Heaps
        ↓
Graphs
        ↓
Dynamic Programming
```

These topics remain planned, not completed. We will introduce them progressively, with Java examples, dry runs, questions, edge cases and problem-solving practice.

## 📚 References

- [Java Collections Framework](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/package-summary.html)
- [Java `ArrayList`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html)
- [Java `HashMap`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html)
- [Java `HashSet`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashSet.html)
- [Java `Queue`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Queue.html)
- [Java `Deque`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Deque.html)
- [Java `PriorityQueue`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/PriorityQueue.html)

---

**Revision principle:** Understand the reason behind a complexity instead of memorizing the result. Identify the input size, count the work, determine whether sections are sequential or nested, simplify the expression, and state the relevant case.