# PriorityQueue in Java

## 1. What Is a PriorityQueue?

A `PriorityQueue` is a collection that processes elements according to their priority rather than insertion order.

Java's `PriorityQueue` is implemented using a **heap**.

By default, Java uses a **min-priority queue**, meaning the smallest element is at the head of the queue.

```java
import java.util.PriorityQueue;

PriorityQueue<Integer> pq = new PriorityQueue<>();
```

### Example

```java
pq.offer(30);
pq.offer(10);
pq.offer(20);

System.out.println(pq.poll()); // 10
System.out.println(pq.poll()); // 20
System.out.println(pq.poll()); // 30
```

Insertion order:

```text
30 → 10 → 20
```

Removal order:

```text
10 → 20 → 30
```

**Important:** A `PriorityQueue` does not guarantee FIFO ordering.

---

## 2. Queue vs PriorityQueue

| Feature | Queue | PriorityQueue |
|---|---|---|
| Processing rule | FIFO | Priority-based |
| First element removed | Earliest inserted | Highest-priority element |
| Default ordering | Insertion order | Natural ordering |
| Duplicates | Allowed | Allowed |
| Typical implementation | LinkedList, ArrayDeque | Heap-based PriorityQueue |

### Normal Queue

```java
Queue<Integer> queue = new LinkedList<>();

queue.offer(30);
queue.offer(10);
queue.offer(20);

System.out.println(queue.poll()); // 30
```

### PriorityQueue

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(30);
pq.offer(10);
pq.offer(20);

System.out.println(pq.poll()); // 10
```

---

## 3. Creating a PriorityQueue

### Integer PriorityQueue

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
```

Smallest integer has the highest priority.

### String PriorityQueue

```java
PriorityQueue<String> pq = new PriorityQueue<>();

pq.offer("C");
pq.offer("A");
pq.offer("B");

System.out.println(pq.poll()); // A
```

Strings use their natural ordering, which is lexicographical ordering.

### Custom Objects

A custom object must be comparable using its natural ordering or a supplied `Comparator`.

```java
PriorityQueue<Task> pq =
    new PriorityQueue<>(
        Comparator.comparingInt(Task::getPriority)
    );
```

This orders tasks by ascending priority value. A smaller number comes first.

---

## 4. Core Methods

### `offer(element)`

Adds an element to the PriorityQueue.

```java
pq.offer(30);
pq.offer(10);
pq.offer(20);
```

Expected time complexity: **O(log n)**.

### `peek()`

Returns the highest-priority element without removing it.

```java
int x = pq.peek();
```

For a default `PriorityQueue<Integer>`, this returns the smallest integer.

Expected time complexity: **O(1)**.

If the queue is empty, `peek()` returns `null`.

### `poll()`

Removes and returns the highest-priority element.

```java
int x = pq.poll();
```

For a default `PriorityQueue<Integer>`, this removes the smallest integer.

Expected time complexity: **O(log n)**.

If the queue is empty, `poll()` returns `null`.

### `size()`

Returns the number of elements.

```java
int count = pq.size();
```

Time complexity: **O(1)**.

### `isEmpty()`

Checks whether the queue contains any elements.

```java
boolean empty = pq.isEmpty();
```

Time complexity: **O(1)**.

### `clear()`

Removes all elements.

```java
pq.clear();
```

---

## 5. Min-Heap vs Max-Heap

### Min-Heap

The default PriorityQueue.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(10);
pq.offer(30);
pq.offer(20);

System.out.println(pq.poll()); // 10
```

Removal order:

```text
10 → 20 → 30
```

### Max-Heap

Use `Collections.reverseOrder()` to reverse the natural ordering.

```java
import java.util.Collections;
import java.util.PriorityQueue;

PriorityQueue<Integer> pq =
    new PriorityQueue<>(Collections.reverseOrder());

pq.offer(10);
pq.offer(30);
pq.offer(20);

System.out.println(pq.poll()); // 30
```

Removal order:

```text
30 → 20 → 10
```

**Remember:**

- Default PriorityQueue → smallest first.
- Reverse-order PriorityQueue → largest first.

---

## 6. PriorityQueue Allows Duplicates

A PriorityQueue does not enforce uniqueness.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(10);
pq.offer(10);
pq.offer(20);

System.out.println(pq.size()); // 3
```

Polling returns:

```text
10
10
20
```

Unlike `HashSet`, duplicate values are retained.

---

## 7. PriorityQueue Does Not Mean a Fully Sorted Collection

A PriorityQueue is heap-based, not a sorted list.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();

pq.offer(30);
pq.offer(10);
pq.offer(20);
pq.offer(5);
```

The important guarantees are:

- `peek()` returns the minimum element by default.
- `poll()` removes the minimum element by default.
- Iteration does not guarantee sorted order.

Do not assume this produces sorted output:

```java
for (int x : pq) {
    System.out.println(x);
}
```

To retrieve elements in priority order, repeatedly poll:

```java
while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}
```

For the default integer PriorityQueue, this prints elements in ascending order.

**Warning:** Repeated polling empties the original queue.

If you need to preserve it, iterate over a copy:

```java
PriorityQueue<Integer> copy = new PriorityQueue<>(pq);

while (!copy.isEmpty()) {
    System.out.println(copy.poll());
}
```

---

## 8. Time Complexity

For Java's heap-based PriorityQueue:

| Operation | Time Complexity |
|---|---:|
| `offer()` | O(log n) |
| `add()` | O(log n) |
| `poll()` | O(log n) |
| `peek()` | O(1) |
| `size()` | O(1) |
| `isEmpty()` | O(1) |
| `contains()` | O(n) |
| `remove(Object)` | O(n) |

Here, `n` is the number of elements in the queue.

Insertion and removal can require the heap to reorganize itself. The root element is accessible in constant time.

---

## 9. PriorityQueue vs Other Collections

| Requirement | Appropriate collection |
|---|---|
| Maintain an index-based sequence | `ArrayList` |
| Map keys to values | `HashMap` |
| Store unique values | `HashSet` |
| Process in FIFO order | `Queue` |
| Operate efficiently at both ends | `Deque` |
| Process in LIFO order | `Stack` or `Deque` |
| Repeatedly retrieve the smallest or largest element | `PriorityQueue` |

Choose a collection based on the operations your problem requires.

---

## 10. Common DSA Use Cases

PriorityQueue is useful when a problem repeatedly asks for the minimum or maximum element.

Common applications include:

1. Finding the Kth largest or smallest element.
2. Finding the top K frequent elements.
3. Merging K sorted lists.
4. Scheduling tasks based on priority.
5. Dijkstra's shortest-path algorithm.
6. Finding the smallest available element repeatedly.
7. Maintaining a running median using two heaps.

These problems rely on heap behavior rather than simply sorting the entire collection.

---

## 11. Important Notes

- Java's default `PriorityQueue` is a min-priority queue.
- `poll()` removes the head; `peek()` does not.
- Duplicates are allowed.
- Empty `poll()` and `peek()` return `null`.
- Iteration order is not guaranteed to be sorted.
- A custom object needs a valid ordering through `Comparable` or `Comparator`.
- PriorityQueue is not synchronized; concurrent access requires appropriate synchronization.
- The heap is an underlying data structure that should be studied separately.

---

## 12. Quick Revision

```text
PriorityQueue<Integer> pq = new PriorityQueue<>();

offer(x)  → insert
peek()    → inspect minimum
poll()    → remove minimum
size()    → number of elements
isEmpty() → check emptiness
```

For a max-priority queue:

```java
PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());
```

### Complexity to Remember

```text
offer() → O(log n)
poll()  → O(log n)
peek()  → O(1)
```

### Final Mental Model

```text
Queue          → FIFO
Stack          → LIFO
PriorityQueue  → Priority-based processing
```

**Key takeaway:** Use a PriorityQueue when you need efficient access to the next element according to a priority rule.