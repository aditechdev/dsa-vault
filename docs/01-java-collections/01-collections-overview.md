# Java Collections — Overview

## 1. What Are Java Collections?

Java Collections provide classes and interfaces for storing and managing groups of objects.

They make it easier to perform common operations such as:

- Adding elements
- Removing elements
- Searching for elements
- Accessing elements
- Managing key-value pairs
- Maintaining unique elements
- Processing elements in different orders

Examples of Java collection types include `ArrayList`, `HashMap`, `HashSet`, `LinkedList`, `Queue`, and `PriorityQueue`.

## 2. Why Do We Need Collections?

We already know Java arrays:

```java
int[] arr = new int[3];
```

This creates an array with a fixed length of three elements.

```java
arr[0] = 10;
arr[1] = 20;
arr[2] = 30;
```

The array cannot automatically grow when we want to add another element.

Collections provide more convenient ways to manage data when we need dynamic sizing or operations such as searching, insertion, and removal.

For example:

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
list.add(40);
```

The `ArrayList` grows as elements are added. We don't need to specify its final size when creating it.

## 3. Array vs ArrayList

| Feature | Array | ArrayList |
|---|---|---|
| Size | Fixed | Dynamically resizable |
| Access an element | `arr[i]` | `list.get(i)` |
| Update an element | `arr[i] = x` | `list.set(i, x)` |
| Add at the end | No dynamic `add()` method | `list.add(x)` |
| Insert at an index | Manual shifting | `list.add(i, x)` |
| Remove an element | Manual shifting | `list.remove(i)` |
| Get number of elements | `arr.length` | `list.size()` |
| Store primitive `int` directly | Yes | No |
| Store objects | Yes | Yes |

Neither structure is universally better. Choose based on the operations and constraints of the problem.

## 4. Important Java Collections Rule: Primitives vs Wrapper Classes

Java collections store objects, not primitive values directly.

Valid:

```java
ArrayList<Integer> numbers = new ArrayList<>();
ArrayList<Double> prices = new ArrayList<>();
ArrayList<String> names = new ArrayList<>();
```

Invalid:

```java
ArrayList<int> numbers = new ArrayList<>(); // Compilation error
```

Java provides wrapper classes for primitive types:

| Primitive | Wrapper class |
|---|---|
| `int` | `Integer` |
| `long` | `Long` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |
| `float` | `Float` |
| `byte` | `Byte` |
| `short` | `Short` |

Java supports autoboxing and unboxing, which often allows primitive values and their corresponding wrapper objects to be converted automatically.

Example:

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);          // int is autoboxed to Integer
int value = numbers.get(0); // Integer is unboxed to int
```

## 5. Main Collection Types in Our Learning Roadmap

### ArrayList
A resizable, array-backed list.

- Maintains element order.
- Supports index-based access.
- Allows duplicate elements.
- Useful when we need a resizable sequence.

Example:

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);
```

### LinkedList
A linked data structure that implements both `List` and `Deque`.

- Can be used as a list or double-ended queue.
- Does not provide constant-time indexed access.
- We will study its structure and operations separately.

### HashMap
Stores key-value pairs.

- Each key is unique.
- Values can be duplicated.
- Useful for fast average-case key lookup and frequency counting.

Example use case: mapping a student's ID to their name.

### HashSet
Stores unique elements.

- Duplicate elements are not retained.
- Useful for membership checks and duplicate detection.

### Stack
Represents a last-in, first-out (LIFO) structure.

- `push()` adds an element.
- `pop()` removes the top element.
- `peek()` examines the top element.

In modern Java, `Deque` is generally preferred for implementing a stack.

### Queue
Represents a first-in, first-out (FIFO) structure in its typical usage.

- `offer()` inserts an element.
- `poll()` retrieves and removes the head.
- `peek()` examines the head.

### Deque
A double-ended queue.

- Supports insertion and removal at both ends.
- Can implement both queue and stack behavior.

### PriorityQueue
Processes elements according to priority rather than ordinary insertion order.

- Java's default `PriorityQueue` behaves as a min-heap.
- `peek()` examines the smallest element.
- `poll()` removes the smallest element.
- A custom comparator can change the priority order.

### Comparable and Comparator
These define ways to compare objects and determine ordering.

- `Comparable` defines a type's natural ordering.
- `Comparator` defines an external or custom ordering.

We will study these after the core collection types.

## 6. ArrayList Operations Covered

We have completed the introductory `ArrayList` lessons.

| Operation | Purpose |
|---|---|
| `add(value)` | Add an element at the end |
| `add(index, value)` | Insert an element at an index |
| `get(index)` | Read an element |
| `set(index, value)` | Replace an element |
| `remove(index)` | Remove the element at an index |
| `remove(Object)` | Remove the first matching element |
| `size()` | Return the number of elements |
| `contains(value)` | Check whether an element exists |
| `isEmpty()` | Check whether the list has no elements |
| `indexOf(value)` | Find the first matching index, or `-1` |
| `clear()` | Remove all elements |

### Important `remove()` distinction

For `ArrayList<Integer>`, the following calls behave differently:

```java
list.remove(1);
```

Removes the element at index `1`.

```java
list.remove(Integer.valueOf(20));
```

Removes the first occurrence of the value `20`.

The distinction matters because Java provides overloaded `remove()` methods.

## 7. Basic ArrayList Time Complexity

These are the core complexities covered in our lessons.

| Operation | Typical complexity |
|---|---|
| `get(index)` | `O(1)` |
| `set(index, value)` | `O(1)` |
| `add(value)` at the end | Amortized `O(1)` |
| `add(index, value)` | `O(n)` in the general case |
| `remove(index)` | `O(n)` in the general case |
| `contains(value)` | `O(n)` |
| `indexOf(value)` | `O(n)` |

Here, `n` represents the number of elements.

The reason for the difference is that index-based access can reach an element directly, while insertion or removal may require shifting elements. Searching may require examining the list element by element.

## 8. When Should We Use ArrayList?

Use `ArrayList` when:

- You need a resizable sequence.
- You need frequent index-based reads.
- You frequently append elements.
- You need convenient insertion, removal, and traversal APIs.

An array may be preferable when a fixed size is sufficient or when primitive storage and lower overhead are important.

## 9. Learning Roadmap

Our planned learning order is:

```text
01. Collections Overview
        |
        v
02. ArrayList                  [Completed]
        |
        v
03. LinkedList
        |
        v
04. HashMap
        |
        v
05. HashSet
        |
        v
06. Stack
        |
        v
07. Queue and Deque
        |
        v
08. PriorityQueue
        |
        v
09. Comparable and Comparator
```

The overview is complete, and the introductory `ArrayList` section is complete. The remaining collection topics have not yet been taught in this learning sequence.

## 10. Connection to DSA

Java Collections are tools for implementing solutions to data-structure and algorithm problems.

Examples:

- `ArrayList`: storing results and maintaining sequences.
- `HashMap`: frequency counting, key-value lookup, and Two Sum-style problems.
- `HashSet`: duplicate detection and membership checks.
- `Stack` / `Deque`: balanced parentheses and monotonic-stack problems.
- `Queue`: breadth-first search (BFS).
- `PriorityQueue`: heap-based problems, top-K elements, and scheduling.

We will learn each collection's API and behavior first, then apply it to actual DSA problems.

## Summary

Java Collections provide reusable structures for managing groups of objects. The main decision is not simply which collection is fastest, but which structure best supports the operations required by a problem.

Our next collection is `LinkedList`, followed by `HashMap` and the remaining structures in the roadmap.
