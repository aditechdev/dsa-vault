# Queue in Java

## 1. What Is a Queue?

A **Queue** is a linear data structure that follows the **FIFO (First In, First Out)** principle.

The element inserted first is the element removed first.

A real-world example is a queue at a ticket counter: the person who arrives first is served first.

### Example

Insert elements in this order:

```text
10, 20, 30
```

Queue representation:

```text
FRONT                 REAR
  ↓                     ↓
[10] → [20] → [30]
```

When we remove an element, `10` is removed first.

```text
Before: [10, 20, 30]
After:  [20, 30]
```

## 2. Queue in Java

Java provides the `Queue` interface in the Java Collections Framework.

We commonly use `LinkedList` as an implementation when learning the Queue API.

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue);
    }
}
```

Output:

```text
[10, 20, 30]
```

**Important:** `Queue` is an interface, so we instantiate an implementing class such as `LinkedList` or `ArrayDeque`.

For most ordinary FIFO use cases, `ArrayDeque` is generally a good choice when `null` elements are not needed. `LinkedList` is used here to introduce the Queue API.

## 3. Core Queue Operations

### 3.1 `offer()` — Add an Element

Adds an element to the rear of the queue.

```java
queue.offer(10);
queue.offer(20);
queue.offer(30);
```

Queue:

```text
FRONT                 REAR
  ↓                     ↓
[10] → [20] → [30]
```

`offer()` returns:
- `true` if the element is added successfully.
- `false` if insertion cannot be completed, such as when a capacity-restricted queue is full.

### 3.2 `poll()` — Remove the Front Element

Removes and returns the front element.

```java
int value = queue.poll();
```

If the queue is:

```text
[10, 20, 30]
```

After `poll()`:

```text
value = 10
queue = [20, 30]
```

**Important:** If the queue is empty, `poll()` returns `null`.

For a `Queue<Integer>`, use `Integer` rather than primitive `int` when you need to store the result safely from a potentially empty queue:

```java
Integer value = queue.poll();
```

Otherwise, assigning a `null` result to `int` causes a `NullPointerException` through unboxing.

### 3.3 `peek()` — View the Front Element

Returns the front element without removing it.

```java
Integer value = queue.peek();
```

Before:

```text
[10, 20, 30]
```

After `peek()`:

```text
value = 10
queue = [10, 20, 30]
```

If the queue is empty, `peek()` returns `null`.

### Quick Comparison

| Method | Action | Empty Queue |
|---|---|---|
| `offer(x)` | Add at rear | Depends on capacity |
| `poll()` | Remove and return front | Returns `null` |
| `peek()` | Return front without removal | Returns `null` |

## 4. `add()` vs `offer()`

Both methods attempt to add an element to the queue.

```java
queue.add(10);
queue.offer(20);
```

The difference is how they handle insertion failure:

- `add()` throws an exception if the element cannot be inserted.
- `offer()` returns `false` if the element cannot be inserted.

For capacity-restricted queues, `offer()` is often preferable when failure should be handled without an exception.

## 5. `remove()` vs `poll()`

Both remove and return the front element.

```java
queue.remove();
queue.poll();
```

The difference appears when the queue is empty:

| Method | Empty Queue |
|---|---|
| `remove()` | Throws `NoSuchElementException` |
| `poll()` | Returns `null` |

For DSA problems, `poll()` is useful when the queue might be empty.

## 6. `element()` vs `peek()`

Both return the front element without removing it.

| Method | Empty Queue |
|---|---|
| `element()` | Throws `NoSuchElementException` |
| `peek()` | Returns `null` |

For our DSA preparation, focus primarily on `peek()`.

## 7. Queue Allows Duplicate Elements

A Queue generally allows duplicate values.

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(10);
queue.offer(10);
queue.offer(20);
queue.offer(10);

System.out.println(queue);
```

Output:

```text
[10, 10, 20, 10]
```

Each occurrence is a separate queue element.

Unlike `HashSet`, Queue does not enforce uniqueness.

## 8. `size()` and `isEmpty()`

### `size()`

Returns the number of elements currently in the queue.

```java
queue.size();
```

Example:

```text
Queue: [10, 20, 30]
size = 3
```

### `isEmpty()`

Returns `true` if the queue contains no elements; otherwise, it returns `false`.

```java
queue.isEmpty();
```

Example:

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(10);
queue.poll();

System.out.println(queue.isEmpty());
```

Output:

```text
true
```

## 9. Queue Traversal

We can use the enhanced `for` loop to visit queue elements.

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(10);
queue.offer(20);
queue.offer(30);

for (int value : queue) {
    System.out.println(value);
}
```

Output:

```text
10
20
30
```

Traversal does **not** remove elements from the queue.

After traversal, the queue remains:

```text
[10, 20, 30]
```

### Consuming the Queue

If we want to process and remove every element, use `poll()` repeatedly:

```java
while (!queue.isEmpty()) {
    System.out.println(queue.poll());
}
```

This empties the queue.

## 10. Queue Complexity

For a typical efficient queue implementation such as `ArrayDeque`, the following operations are generally amortized constant time:

| Operation | Typical Complexity |
|---|---:|
| `offer()` | O(1) amortized |
| `poll()` | O(1) |
| `peek()` | O(1) |
| `size()` | O(1) |
| `isEmpty()` | O(1) |
| Full traversal | O(n) |

Complexity depends on the implementation. These are not universal guarantees for every class implementing `Queue`.

## 11. Queue vs ArrayList vs HashSet

| Feature | Queue | ArrayList | HashSet |
|---|---|---|---|
| Main purpose | FIFO processing | Ordered sequence | Unique values |
| Duplicates | Allowed | Allowed | Not allowed |
| Index-based access | No | Yes | No |
| Preserves insertion order | Queue behavior is FIFO; traversal order depends on implementation | Yes | Not guaranteed |
| Efficient membership lookup | Not its primary purpose | Usually O(n) | Expected O(1) |
| Main operations | `offer`, `poll`, `peek` | `add`, `get`, `set` | `add`, `contains`, `remove` |

## 12. Queue vs Stack

These are different processing principles.

### Queue — FIFO

First In, First Out.

```text
Insert: 10, 20, 30
Remove: 10 first
```

### Stack — LIFO

Last In, First Out.

```text
Push: 10, 20, 30
Pop: 30 first
```

We will study Stack separately.

## 13. Common DSA Use Cases

Queues are useful when processing must happen in arrival order.

Common examples include:

- Breadth-First Search (BFS) in graphs and trees.
- Level-order traversal of binary trees.
- Processing tasks in FIFO order.
- Simulating waiting lines.
- Managing work items that are processed in arrival order.

BFS is particularly important because it uses a Queue to process nodes level by level.

## 14. Complete Example

```java
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.peek()); // 10

        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 20

        System.out.println(queue.size());    // 2
        System.out.println(queue.isEmpty()); // false

        System.out.println(queue); // [20, 30]
    }
}
```

Output:

```text
10
10
20
2
false
[20, 30]
```

## 15. Key Takeaways

- Queue follows FIFO: First In, First Out.
- `offer()` adds an element at the rear.
- `poll()` removes and returns the front element.
- `peek()` returns the front element without removing it.
- `poll()` and `peek()` return `null` when the queue is empty.
- Queue allows duplicate elements.
- The `Queue` interface has multiple implementations.
- `ArrayDeque` is a good default for many ordinary in-memory FIFO use cases.
- Queue is a foundational data structure for BFS and level-order traversal.

## 16. Progress

- [x] Understand FIFO.
- [x] Create a Queue in Java.
- [x] Learn `offer()`, `poll()`, and `peek()`.
- [x] Understand empty-queue behavior.
- [x] Compare `add()` with `offer()`.
- [x] Compare `remove()` with `poll()`.
- [x] Compare `element()` with `peek()`.
- [x] Learn `size()` and `isEmpty()`.
- [x] Traverse a Queue.
- [x] Understand duplicate elements.
- [x] Learn basic complexity.
- [x] Compare Queue with ArrayList, HashSet, and Stack.
- [x] Identify common DSA use cases.

**Next topic:** Deque — Double-Ended Queue.
