# Stack in Java — DSA Notes

## 1. What Is a Stack?

A **Stack** is a linear data structure that follows **LIFO (Last In, First Out)**.

The last element inserted is the first element removed.

### Real-world example

Think of a stack of plates. You place new plates on top and remove the topmost plate first.

```text
       TOP
        ↓
      ┌────┐
      │ 30 │ ← Last inserted
      ├────┤
      │ 20 │
      ├────┤
      │ 10 │ ← First inserted
      └────┘
```

If we insert `10`, `20`, and `30`, the first element removed is `30`.

## 2. LIFO — Last In, First Out

Consider these operations:

```text
push(10)
push(20)
push(30)
```

Stack state:

```text
TOP → 30
      20
      10
```

Calling `pop()` removes `30` because it was inserted last.

```text
Before pop():

TOP → 30
      20
      10

pop()

After pop():

TOP → 20
      10
```

**Key rule:** In a Stack, insertion and removal happen at the same end, called the top.

---

## 3. Creating a Stack in Java

Java provides a `Stack` class in the `java.util` package.

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
```

Here:

- `Stack` is the class.
- `Integer` is the type of elements stored.
- `stack` is the reference variable.
- `new Stack<>()` creates an empty Stack.

Example:

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);
```

Current stack:

```text
TOP → 30
      20
      10
```

A Stack allows duplicate elements.

```java
stack.push(10);
stack.push(20);
stack.push(10);
```

Conceptually, from top to bottom:

```text
10
20
10
```

The two occurrences of `10` are separate elements.

---

## 4. `push()` — Insert an Element

The `push()` method inserts an element at the top of the Stack.

Syntax:

```java
stack.push(value);
```

Example:

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);
```

Dry run:

```text
push(10) → [10]

push(20) → [10, 20]

push(30) → [10, 20, 30]
```

The rightmost element in the conceptual sequence is the top.

```text
BOTTOM → 10, 20, 30 ← TOP
```

Therefore, `30` is the next element that will be removed.

### Remember

`push()` adds an element to the top. It does not remove existing elements.

---

## 5. `pop()` — Remove and Return the Top Element

The `pop()` method removes and returns the top element.

Syntax:

```java
stack.pop();
```

Example:

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

int x = stack.pop();
```

Result:

```text
x = 30
```

Remaining Stack:

```text
TOP → 20
      10
```

### Important distinction

`pop()` performs two actions:

1. Returns the top element.
2. Removes that element from the Stack.

If you call `pop()` again, it returns `20`.

---

## 6. `peek()` — View the Top Element

The `peek()` method returns the top element **without removing it**.

Syntax:

```java
stack.peek();
```

Example:

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

int x = stack.peek();
```

Result:

```text
x = 30
```

Stack remains unchanged:

```text
TOP → 30
      20
      10
```

### `pop()` vs `peek()`

| Method | Returns top? | Removes top? |
|---|---|---|
| `pop()` | Yes | Yes |
| `peek()` | Yes | No |

Remember:

```text
pop()  → take the top element away
peek() → look at the top element
```

---

## 7. `size()` — Number of Elements

The `size()` method returns the number of elements currently stored.

Example:

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

int size = stack.size();
```

Result:

```text
size = 3
```

After:

```java
stack.pop();
```

the size becomes `2`.

The size counts all elements, including duplicates.

---

## 8. `isEmpty()` — Check Whether the Stack Is Empty

The `isEmpty()` method returns a boolean.

```java
stack.isEmpty();
```

- `true`: the Stack contains no elements.
- `false`: the Stack contains at least one element.

Example:

```java
Stack<Integer> stack = new Stack<>();

System.out.println(stack.isEmpty()); // true

stack.push(10);

System.out.println(stack.isEmpty()); // false
```

After removing every element, `isEmpty()` returns `true` again.

---

## 9. Duplicate Elements

A Stack allows duplicate values.

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(10);
```

Conceptual state:

```text
TOP → 10
      20
      10
```

Calling:

```java
stack.pop();
```

returns the top `10`. The other `10` remains in the Stack.

### Comparison

| Data structure | Duplicates allowed? |
|---|---|
| `ArrayList` | Yes |
| `HashMap` | Duplicate keys are not allowed; duplicate values are allowed |
| `HashSet` | No duplicate elements |
| `Queue` | Yes |
| `Deque` | Yes |
| `Stack` | Yes |

A Stack follows LIFO, not a uniqueness rule.

---

## 10. Empty Stack Behavior

Java's `Stack` throws an `EmptyStackException` when `pop()` or `peek()` is called on an empty Stack.

Example:

```java
Stack<Integer> stack = new Stack<>();

stack.pop();
```

This throws:

```text
EmptyStackException
```

Similarly:

```java
stack.peek();
```

also throws `EmptyStackException` if the Stack is empty.

### Safe usage

Check whether the Stack contains elements before accessing the top:

```java
if (!stack.isEmpty()) {
    int top = stack.peek();
}
```

Or before removing:

```java
if (!stack.isEmpty()) {
    int value = stack.pop();
}
```

This prevents an empty-Stack exception in these examples.

---

## 11. Traversing a Stack

Java's enhanced `for` loop can visit elements in a Stack.

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

for (int x : stack) {
    System.out.println(x);
}
```

For Java's `Stack`, which extends `Vector`, iteration proceeds from the bottom toward the top.

Output:

```text
10
20
30
```

**Important:** Traversal does not remove elements. The Stack remains unchanged.

### Traversal vs consuming the Stack

Traversal:

```java
for (int x : stack) {
    System.out.println(x);
}
```

The elements remain in the Stack.

Consuming the Stack:

```java
while (!stack.isEmpty()) {
    System.out.println(stack.pop());
}
```

Output:

```text
30
20
10
```

The second approach removes each element until the Stack becomes empty.

---

## 12. Time Complexity

For the core operations of Java's `Stack`:

| Operation | Time complexity |
|---|---|
| `push()` | O(1) amortized |
| `pop()` | O(1) |
| `peek()` | O(1) |
| `size()` | O(1) |
| `isEmpty()` | O(1) |

`push()` is O(1) amortized because the underlying resizable array may occasionally need to grow, which requires additional work.

For our initial DSA analysis, remember that the core Stack operations are generally treated as constant-time operations.

---

## 13. Stack vs Queue

These two data structures differ in removal order.

### Stack — LIFO

```text
push(10)
push(20)
push(30)

pop() → 30
```

The last inserted element is removed first.

### Queue — FIFO

```text
offer(10)
offer(20)
offer(30)

poll() → 10
```

The first inserted element is removed first.

| Feature | Stack | Queue |
|---|---|---|
| Ordering rule | LIFO | FIFO |
| Insert | `push()` | `offer()` |
| Remove | `pop()` | `poll()` |
| Inspect next element | `peek()` | `peek()` |
| Main operation end | Top | Add at back, remove at front |

---

## 14. Stack vs Deque

A Deque (double-ended queue) supports insertion, removal, and inspection at both ends.

It can also provide Stack behavior.

Example:

```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> stack = new ArrayDeque<>();

stack.push(10);
stack.push(20);
stack.push(30);

int top = stack.pop();
```

Result:

```text
top = 30
```

This uses Deque's Stack-style methods.

### Which should you use?

- Learn the `Stack` class because you may encounter it in existing Java code and interview questions.
- For modern Java code that needs Stack behavior, `Deque` with `ArrayDeque` is generally preferred over the legacy `Stack` class.

The essential DSA concept is LIFO, regardless of the Java implementation.

---

## 15. Common DSA Applications of a Stack

Stacks are useful when the most recently added or encountered item must be processed first.

Common applications include:

1. **Balanced parentheses:** Validate expressions such as `({[]})`.
2. **String reversal:** Process characters in reverse order.
3. **Undo operations:** Reverse the most recent action first.
4. **Expression evaluation:** Evaluate postfix expressions and related forms.
5. **Monotonic Stack:** Solve next greater element and next smaller element problems.
6. **Depth-First Search (DFS):** Track nodes to visit in graph traversal.
7. **Backtracking:** Return to a previous state when a choice fails.

We will study these applications when we begin actual DSA patterns.

---

## 16. Common Mistakes

### Mistake 1: Confusing LIFO with FIFO

Incorrect assumption: the first inserted element leaves first.

Correct: the last inserted element leaves first.

### Mistake 2: Confusing `pop()` with `peek()`

- `pop()` removes and returns the top.
- `peek()` returns the top without removing it.

### Mistake 3: Forgetting empty-Stack behavior

Calling `pop()` or `peek()` on an empty Java `Stack` throws `EmptyStackException`.

### Mistake 4: Assuming duplicates are rejected

A Stack permits duplicates. Each occurrence is stored independently.

### Mistake 5: Assuming traversal is popping

A `for-each` loop visits elements without removing them.

### Mistake 6: Confusing display order with removal order

For Java's `Stack`, iteration proceeds from bottom to top, but repeated `pop()` operations return elements from top to bottom.

---

## 17. Quick Revision

```text
Stack
    → LIFO: Last In, First Out

push(x)
    → add x to the top

pop()
    → remove and return the top

peek()
    → return the top without removing it

size()
    → number of elements

isEmpty()
    → whether the Stack is empty

Duplicates
    → allowed

Empty pop()/peek()
    → EmptyStackException

Typical core operation complexity
    → O(1), with push amortized O(1)

Modern Java Stack alternative
    → Deque<Integer> stack = new ArrayDeque<>();
```

## 18. Practice Questions

**Q1.** What does this print?

```java
Stack<Integer> stack = new Stack<>();

stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop());
System.out.println(stack.peek());
System.out.println(stack.size());
```

**Answer:**

```text
30
20
2
```

**Q2.** What remains after the following operations?

```java
stack.push(10);
stack.push(20);
stack.push(30);
stack.pop();
stack.push(40);
```

**Answer — bottom to top:**

```text
10, 20, 40
```

**Q3.** Does `peek()` change the Stack?

**Answer:** No. It returns the top element without removing it.

**Q4.** What happens when `pop()` is called on an empty Java `Stack`?

**Answer:** It throws `EmptyStackException`.

**Q5.** Which data structure follows LIFO?

**Answer:** Stack.

---

## 19. Final Checklist

- [x] What a Stack is
- [x] LIFO principle
- [x] Creating a Java Stack
- [x] `push()`
- [x] `pop()`
- [x] `peek()`
- [x] `size()`
- [x] `isEmpty()`
- [x] Duplicate elements
- [x] Empty-Stack behavior
- [x] Traversal
- [x] Basic time complexity
- [x] Stack vs Queue
- [x] Stack vs Deque
- [x] Common DSA applications
- [x] Common mistakes
