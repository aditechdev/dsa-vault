
# Deque (Double-Ended Queue)

**File:** `06-deque.md`

## ❓ Problem

A normal Queue follows FIFO: elements are added at the rear and removed from the front. Sometimes we need efficient operations at both ends. A Deque solves this problem.

## 📋 Prerequisites

- Java interfaces and implementations
- Generics
- Queue and FIFO
- Enhanced `for` loop
- Basic time complexity

## 🧠 Theory

Deque stands for **Double-Ended Queue**. It allows insertion, removal, and inspection at both the front and rear.

In Java, `Deque<E>` is an interface. `ArrayDeque<E>` is a common implementation.

```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> deque = new ArrayDeque<>();
```

### Core operations

| Operation | Purpose | Typical complexity |
|---|---|---:|
| `addFirst(x)` | Add at front | O(1) amortized |
| `addLast(x)` | Add at rear | O(1) amortized |
| `removeFirst()` | Remove and return front | O(1) |
| `removeLast()` | Remove and return rear | O(1) |
| `peekFirst()` | Inspect front without removing | O(1) |
| `peekLast()` | Inspect rear without removing | O(1) |
| `size()` | Number of elements | O(1) |
| `isEmpty()` | Check whether empty | O(1) |

### 1. `addFirst()`

Adds an element at the front.

```java
deque.addFirst(10);
deque.addFirst(20);
deque.addFirst(30);
```

Result, front to rear: `[30, 20, 10]`.

### 2. `addLast()`

Adds an element at the rear.

```java
deque.addLast(10);
deque.addLast(20);
deque.addLast(30);
```

Result, front to rear: `[10, 20, 30]`.

### 3. `removeFirst()` and `removeLast()`

Both remove and return an element, but from opposite ends.

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.addLast(10);
deque.addLast(20);
deque.addLast(30);

int first = deque.removeFirst(); // 10
int last = deque.removeLast();   // 30
```

Remaining deque: `[20]`.

**Empty behavior:** `removeFirst()` and `removeLast()` throw `NoSuchElementException` when the deque is empty.

### 4. `peekFirst()` and `peekLast()`

Inspect an element without removing it.

```java
Deque<Integer> deque = new ArrayDeque<>();
deque.addLast(10);
deque.addLast(20);
deque.addLast(30);

int first = deque.peekFirst(); // 10
int last = deque.peekLast();   // 30
```

The deque remains `[10, 20, 30]`.

Both peek methods return `null` when the deque is empty.

### 5. Other useful methods

```java
deque.size();
deque.isEmpty();
deque.contains(20);
deque.clear();
deque.pollFirst();
deque.pollLast();
```

`pollFirst()` and `pollLast()` remove and return an element, or return `null` if empty.

`ArrayDeque` does not allow `null` elements.

## 🗺️ Diagram

```text
                 Deque

 FRONT                              REAR
   |                                  |
   v                                  v
 [10] <-> [20] <-> [30] <-> [40]
   ^                                  ^
   |                                  |
addFirst / removeFirst    addLast / removeLast

peekFirst() returns 10
peekLast()  returns 40
```

## 💻 Code

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(30);

        System.out.println(deque);               // [5, 10, 20, 30]
        System.out.println(deque.peekFirst());   // 5
        System.out.println(deque.peekLast());    // 30

        System.out.println(deque.removeFirst()); // 5
        System.out.println(deque.removeLast());  // 30
        System.out.println(deque);               // [10, 20]

        System.out.println(deque.size());         // 2
        System.out.println(deque.isEmpty());      // false
    }
}
```

### Traversal

```java
for (int value : deque) {
    System.out.println(value);
}
```

Enhanced `for` traversal visits elements without removing them. `ArrayDeque` iteration proceeds from front to rear.

## 🏗️ Real Example

Imagine a browser-like history or a processing pipeline where operations are needed at both ends. A Deque supports adding and removing at either end without requiring index-based access.

Common DSA applications include:

- Sliding window maximum/minimum
- Palindrome checking from both ends
- Monotonic deque techniques
- Implementing a Queue or Stack
- Breadth-first search variants that need both-end operations

## 🔍 Deque vs Queue vs Stack

| Structure | Insertion | Removal | Principle |
|---|---|---|---|
| Queue | Rear | Front | FIFO |
| Stack | Top | Top | LIFO |
| Deque | Both ends | Both ends | Flexible |

A Deque can behave like a Queue using `addLast()` and `removeFirst()`. It can behave like a Stack using `addLast()` and `removeLast()`.

## ⚠️ Mistakes / Gotchas

1. `addFirst()` changes the front; repeated calls reverse the insertion order.
2. `addLast()` preserves insertion order when elements are appended.
3. `peekFirst()` and `peekLast()` do not remove elements.
4. `removeFirst()` and `removeLast()` throw an exception on an empty deque; `pollFirst()` and `pollLast()` return `null` instead.
5. Duplicates are allowed. A Deque is not a uniqueness-enforcing structure like `HashSet`.
6. `ArrayDeque` does not support index-based access such as `get(0)`.
7. `ArrayDeque` does not allow `null` elements.
8. End operations are O(1) amortized for `ArrayDeque`; occasional resizing can take O(n).

## 🎯 Interview Questions

**Q1. What does Deque stand for?**

Double-Ended Queue.

**Q2. Can a Deque contain duplicates?**

Yes.

**Q3. Does `peekFirst()` remove the first element?**

No. It returns the front element without removing it.

**Q4. What happens when `removeLast()` is called on an empty Deque?**

It throws `NoSuchElementException`.

**Q5. How can a Deque behave as a Stack?**

Use `addLast()` to push and `removeLast()` to pop. Use `peekLast()` to inspect the top.

**Q6. What is the difference between Queue and Deque?**

A Queue normally inserts at the rear and removes at the front. A Deque supports both ends.

## 🔑 Key Takeaways

- Deque means Double-Ended Queue.
- `addFirst()` / `addLast()` insert at opposite ends.
- `removeFirst()` / `removeLast()` remove from opposite ends.
- `peekFirst()` / `peekLast()` inspect without removing.
- A Deque permits duplicates but `ArrayDeque` prohibits `null` elements.
- `ArrayDeque` is a useful default implementation for Queue- and Stack-style DSA operations.
- End operations are O(1) amortized.

## ⏱️ 60-Second Revision

```text
addFirst(x)    -> insert at front
addLast(x)     -> insert at rear
removeFirst()  -> remove front; throws if empty
removeLast()   -> remove rear; throws if empty
peekFirst()    -> inspect front; null if empty
peekLast()     -> inspect rear; null if empty
pollFirst()    -> remove front; null if empty
pollLast()     -> remove rear; null if empty

Queue behavior -> addLast + removeFirst
Stack behavior -> addLast + removeLast
```
