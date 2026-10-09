# ArrayList in Java

## 1. What is an ArrayList?

An `ArrayList` is a resizable array provided by the Java Collections Framework.

Unlike a regular array, an `ArrayList` can grow or shrink dynamically as elements are added or removed.

```java
import java.util.ArrayList;

ArrayList<Integer> numbers = new ArrayList<>();
```

**Key points:**
- Maintains insertion order.
- Supports duplicate elements.
- Provides index-based access.
- Automatically adjusts its capacity as needed.
- Stores objects, not primitive types directly.

## 2. Array vs ArrayList

| Feature | Array | ArrayList |
|---|---|---|
| Size | Fixed after creation | Resizable |
| Access element | `arr[i]` | `list.get(i)` |
| Get size | `arr.length` | `list.size()` |
| Update element | `arr[i] = value` | `list.set(i, value)` |
| Add element | Limited by fixed size | `list.add(value)` |
| Remove element | Requires manual handling | `list.remove(...)` |
| Primitive types | Supported | Use wrapper classes |
| Index access | O(1) | O(1) |

Example:

```java
int[] arr = new int[3];

ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
list.add(40);
```

The array has space for exactly three elements. The `ArrayList` can grow to accommodate additional elements.

## 3. Wrapper Classes and Generics

Java collections use reference types rather than primitive types.

| Primitive | Wrapper class |
|---|---|
| `int` | `Integer` |
| `long` | `Long` |
| `double` | `Double` |
| `float` | `Float` |
| `char` | `Character` |
| `boolean` | `Boolean` |

Valid:

```java
ArrayList<Integer> numbers = new ArrayList<>();
ArrayList<Double> prices = new ArrayList<>();
ArrayList<String> names = new ArrayList<>();
```

Invalid:

```java
// ArrayList<int> numbers = new ArrayList<>();
```

Java supports **autoboxing** and **unboxing**:

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);          // Autoboxing: int -> Integer

int value = numbers.get(0); // Unboxing: Integer -> int
```

## 4. Creating an ArrayList

```java
ArrayList<Integer> numbers = new ArrayList<>();
```

Creating one with an initial capacity:

```java
ArrayList<Integer> numbers = new ArrayList<>(20);
```

The initial capacity is not the list's size. The list starts empty, even if its initial capacity is 20.

```java
System.out.println(numbers.size()); // 0
```

## 5. Adding Elements

### `add(value)`

Adds an element to the end of the list.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers); // [10, 20, 30]
```

### `add(index, value)`

Inserts an element at a specified index. Existing elements at that index and after it shift right.

```java
numbers.add(1, 15);

System.out.println(numbers); // [10, 15, 20, 30]
```

The insertion index must be between `0` and `size()` inclusive.

## 6. Accessing Elements: `get(index)`

Returns the element at the specified index without removing it.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers.get(1)); // 20
```

**Time complexity:** O(1)

Valid indices range from `0` to `size() - 1`. An invalid index causes an `IndexOutOfBoundsException`.

## 7. Updating Elements: `set(index, value)`

Replaces the element at a specified index.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.set(1, 99);

System.out.println(numbers); // [10, 99, 30]
```

`set()` replaces an element; it does not insert a new one.

**Time complexity:** O(1)

## 8. Removing Elements

Java has two important `remove()` overloads.

### `remove(index)`

Removes the element at the specified index. Elements after it shift left.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.remove(1);

System.out.println(numbers); // [10, 30]
```

**Time complexity:** O(n) in the general case because elements may need to shift.

### `remove(value)`

For an `ArrayList<Integer>`, passing an `int` literal selects `remove(int index)`, not removal by integer value.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

// Removes the element at index 1:
numbers.remove(1);

System.out.println(numbers); // [10, 30]
```

To remove an integer by value, use `Integer.valueOf()`:

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(20);

numbers.remove(Integer.valueOf(20));

System.out.println(numbers); // [10, 30, 20]
```

This removes only the **first occurrence** of the value.

**Important:** Understand the difference between removing an element by index and removing an element by value before solving DSA problems.

## 9. Getting the Number of Elements: `size()`

Returns the number of elements currently in the list.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers.size()); // 3
```

Use `size()` instead of `length` or `length()`.

- Array: `arr.length`
- String: `str.length()`
- ArrayList: `list.size()`

## 10. Searching Elements

### `contains(value)`

Checks whether the list contains a specified element.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers.contains(20)); // true
System.out.println(numbers.contains(50)); // false
```

Time complexity: O(n).

### `indexOf(value)`

Returns the index of the first occurrence of an element. Returns `-1` if the element is absent.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(20);

System.out.println(numbers.indexOf(20)); // 1
System.out.println(numbers.indexOf(50)); // -1
```

Time complexity: O(n).

## 11. Checking and Clearing a List

### `isEmpty()`

Checks whether the list contains zero elements.

```java
ArrayList<Integer> numbers = new ArrayList<>();

System.out.println(numbers.isEmpty()); // true

numbers.add(10);

System.out.println(numbers.isEmpty()); // false
```

### `clear()`

Removes all elements from the list.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.clear();

System.out.println(numbers);        // []
System.out.println(numbers.size()); // 0
```

## 12. Traversing an ArrayList

### Using a traditional `for` loop

Useful when you need indices.

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

for (int i = 0; i < numbers.size(); i++) {
    System.out.println(numbers.get(i));
}
```

Output:

```text
10
20
30
```

### Using an enhanced `for` loop

Useful when you only need the elements.

```java
for (int number : numbers) {
    System.out.println(number);
}
```

Both approaches are useful in DSA. Choose the traditional loop when an algorithm depends on an index.

## 13. ArrayList Time Complexity

Let `n` be the number of elements in the list.

| Operation | Time complexity | Reason |
|---|---|---|
| `get(index)` | O(1) | Direct index access |
| `set(index, value)` | O(1) | Direct index update |
| `add(value)` | Amortized O(1) | Usually appends; occasional resizing costs more |
| `add(index, value)` | O(n) | May shift existing elements |
| `remove(index)` | O(n) | May shift remaining elements |
| `remove(value)` | O(n) | Searches for the value and may shift elements |
| `contains(value)` | O(n) | May inspect every element |
| `indexOf(value)` | O(n) | Linear search |
| `size()` | O(1) | Returns the current element count |
| `isEmpty()` | O(1) | Checks the current element count |
| `clear()` | O(n) | Clears references to stored elements |

**Amortized O(1)** means appending is constant time on average over a sequence of operations, although an individual append can take O(n) when resizing requires copying elements.

## 14. Common Mistakes

1. Using `length` instead of `size()` for an `ArrayList`.
2. Using `ArrayList<int>` instead of `ArrayList<Integer>`.
3. Confusing `add(index, value)` with `set(index, value)`.
4. Assuming `remove(20)` removes the value `20` from an `ArrayList<Integer>`.
5. Accessing an index outside the valid range.
6. Assuming `indexOf()` returns every occurrence; it returns only the first.
7. Assuming `remove(Integer.valueOf(20))` removes all occurrences; it removes only the first.
8. Using repeated middle insertions or removals without considering their O(n) cost.
9. Assuming an initial capacity determines the list's current size.

## 15. When Should You Use ArrayList?

Use an `ArrayList` when you need:

- A dynamically sized sequence of elements.
- Fast index-based reads and updates.
- Frequent appends to the end.
- A collection that preserves insertion order.
- A convenient replacement for an array when the number of elements can change.

For frequent insertions and deletions near the beginning or middle, consider the operation costs and the alternative data structures before choosing a collection.

## 16. DSA Applications

ArrayList is useful for:

- Storing dynamically sized input.
- Collecting results from an algorithm.
- Building adjacency lists for graphs.
- Representing lists of objects.
- Returning multiple results from a method.
- Maintaining a sequence that needs index-based access.

A regular array may still be preferable when the size is fixed or when primitive-array performance and memory efficiency matter.

## 17. Quick Revision Checklist

- [ ] Understand Array vs ArrayList.
- [ ] Understand wrapper classes and autoboxing.
- [ ] Create an `ArrayList<Integer>`.
- [ ] Use `add()`, `get()`, `set()`, and `remove()`.
- [ ] Distinguish removal by index from removal by value.
- [ ] Use `size()`, `contains()`, `indexOf()`, `isEmpty()`, and `clear()`.
- [ ] Traverse with both `for` and enhanced `for` loops.
- [ ] Recall the time complexity of common operations.
- [ ] Explain why appending is amortized O(1).
- [ ] Solve simple problems using an ArrayList.

---

**Next file:** `03-linkedlist.md`

LinkedList will cover node-based storage, references between nodes, common operations, time complexity, and how it differs from ArrayList.
