# HashSet in Java

## 1. What Is a HashSet?

A `HashSet` is a collection in Java that stores **unique elements**.

It does not allow duplicate elements and does not guarantee iteration order.

```java
import java.util.HashSet;

HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(30);
```

Conceptually, the set contains:

```text
{10, 20, 30}
```

### Key Characteristics

- Stores unique elements.
- Does not provide index-based access.
- Does not guarantee iteration order.
- Uses hashing for efficient membership checks.
- Allows one `null` element.
- Supports operations such as `add()`, `contains()`, and `remove()`.

---

## 2. Why Do We Need HashSet?

Consider this array:

```text
[10, 20, 10, 30, 20, 40]
```

Suppose we need only the unique values.

Using an `ArrayList` preserves duplicates:

```text
[10, 20, 10, 30, 20, 40]
```

Using a `HashSet` removes duplicate entries:

```text
{10, 20, 30, 40}
```

The actual iteration order of a `HashSet` is not guaranteed.

### When to Use HashSet

Use `HashSet` when you need to:

- Store unique values.
- Detect duplicates.
- Check whether a value has already appeared.
- Track visited elements.
- Perform efficient membership checks.

---

## 3. Creating a HashSet

### Syntax

```java
HashSet<Type> set = new HashSet<>();
```

Examples:

```java
HashSet<Integer> numbers = new HashSet<>();
HashSet<String> names = new HashSet<>();
HashSet<Double> prices = new HashSet<>();
```

For DSA, `HashSet<Integer>` is a common choice.

---

## 4. The `add()` Method

The `add()` method attempts to add an element.

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(30);
```

Result:

```text
{10, 20, 30}
```

### Adding Duplicates

```java
set.add(10);
set.add(10);
set.add(20);
```

Result:

```text
{10, 20}
```

The second `10` does not create another element.

### Return Value of `add()`

Unlike `ArrayList.add()`, `HashSet.add()` returns a boolean.

- `true`: the element was added.
- `false`: the element already existed.

Example:

```java
HashSet<Integer> set = new HashSet<>();

boolean a = set.add(10);
boolean b = set.add(10);
```

Result:

```text
a = true
b = false
```

### Dry Run

```text
Initial: {}

add(10) → true  → {10}
add(20) → true  → {10, 20}
add(10) → false → {10, 20}
```

---

## 5. The `contains()` Method

Use `contains()` to check whether an element exists.

### Syntax

```java
set.contains(value);
```

Example:

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(30);

System.out.println(set.contains(20)); // true
System.out.println(set.contains(50)); // false
```

### Key Point

`contains()` returns a boolean:

```text
Element exists     → true
Element not found  → false
```

Average/expected time complexity: **O(1)**.

---

## 6. The `remove()` Method

Use `remove()` to remove an element by value.

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(30);

boolean result = set.remove(20);
```

Result:

```text
Set:     {10, 30}
result:  true
```

### Return Value

```text
Element existed and was removed → true
Element did not exist           → false
```

Example:

```java
set.remove(50); // false, if 50 is absent
```

Unlike `ArrayList`, `HashSet` has no index-based removal because it has no index-based access.

Average/expected time complexity: **O(1)**.

---

## 7. The `size()` Method

`size()` returns the number of unique elements currently in the set.

```java
HashSet<Integer> set = new HashSet<>();

set.add(5);
set.add(10);
set.add(5);
set.add(15);
set.add(10);
set.add(20);

System.out.println(set.size());
```

Output:

```text
4
```

The unique elements are:

```text
{5, 10, 15, 20}
```

**Remember:** `size()` counts unique elements, not the number of calls to `add()`.

Time complexity: **O(1)**.

---

## 8. The `isEmpty()` Method

`isEmpty()` checks whether the set contains zero elements.

```java
HashSet<Integer> set = new HashSet<>();

System.out.println(set.isEmpty()); // true

set.add(10);

System.out.println(set.isEmpty()); // false
```

It returns:

```text
Empty set     → true
Non-empty set → false
```

You can also empty a set by removing all its elements.

```java
set.remove(10);

System.out.println(set.isEmpty()); // true
```

---

## 9. The `clear()` Method

`clear()` removes all elements from the set.

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(30);

set.clear();
```

Result:

```text
{}
```

After clearing:

```java
set.size();     // 0
set.isEmpty();  // true
```

The set object still exists; its elements have been removed.

---

## 10. Traversing a HashSet

A `HashSet` does not support index-based access.

This is invalid:

```java
set.get(0); // Compilation error
```

Use the enhanced `for` loop to traverse it.

```java
HashSet<Integer> set = new HashSet<>();

set.add(5);
set.add(10);
set.add(15);

for (int x : set) {
    System.out.println(x);
}
```

The loop visits all three elements, but **their iteration order is not guaranteed**.

### Understanding the Syntax

```java
for (int x : set)
```

Read it as:

> For each element in the set, assign that element to `x`.

The variable `x` represents the current element, not its index.

### Important: Reassigning the Loop Variable

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(5);
list.add(10);
list.add(15);

for (int x : list) {
    x = x * 2;
}
```

The list remains:

```text
[5, 10, 15]
```

Reassigning the local variable `x` does not update the element stored in the list.

This is a general Java loop concept, not a special feature of `HashSet`.

---

## 11. HashSet and `null`

A standard Java `HashSet` permits one `null` element.

```java
HashSet<Integer> set = new HashSet<>();

boolean a = set.add(null);
boolean b = set.add(null);
```

Result:

```text
a = true
b = false
```

Why?

The first call adds `null`. The second call finds that `null` already exists.

The set can contain:

```text
{null, 10, 20}
```

It cannot contain duplicate `null` elements.

---

## 12. How Does HashSet Work Internally?

At a high level, `HashSet` uses hashing to locate elements.

Conceptually:

```text
Value
  ↓
hashCode()
  ↓
Hash-table location
  ↓
Check equality
  ↓
Determine whether the element exists
```

For example:

```java
set.contains(20);
```

Java uses the hashing mechanism to locate the relevant area and checks equality to determine whether the element exists.

### Hash Collisions

A collision occurs when multiple values map to the same hash-table location.

Hash-based collections must handle collisions correctly.

For ordinary DSA use, you do not need to implement hashing yourself, but you should understand that collisions are possible.

### `hashCode()` and `equals()`

For objects used as set elements:

- `hashCode()` helps determine where an element belongs.
- `equals()` determines whether two elements should be treated as equal.

If two objects are equal according to `equals()`, they must have the same `hashCode()`.

When using custom classes as set elements, correctly implementing both methods is important. We can defer the details until Java/OOP or hashing internals.

---

## 13. Time Complexity

For a typical Java `HashSet`:

| Operation | Average/Expected Time |
|---|---:|
| `add()` | O(1) |
| `contains()` | O(1) |
| `remove()` | O(1) |
| `size()` | O(1) |
| `isEmpty()` | O(1) |
| Traversal | O(n) |

Here, `n` is the number of elements.

**Important:** O(1) for hash-based operations is the average/expected complexity, not an unconditional guarantee for every possible situation.

---

## 14. HashSet vs ArrayList

| Feature | ArrayList | HashSet |
|---|---|---|
| Duplicates | Allowed | Not allowed |
| Index-based access | Yes | No |
| Iteration order | Preserves sequence order | Not guaranteed |
| Membership check | O(n) | O(1) average |
| Add at end | O(1) amortized | O(1) average |
| Remove by value | O(n) | O(1) average |
| Main purpose | Store a sequence | Store unique values |

### Example: Membership Check

Given:

```text
[10, 20, 30, 40, 50]
```

With an `ArrayList`:

```java
list.contains(40);
```

The list may need to inspect elements one by one. Worst-case time is O(n).

With a `HashSet`:

```java
set.contains(40);
```

The expected time is O(1).

### Choosing Between Them

Use `ArrayList` when:
- You need to preserve all occurrences.
- You need index-based access.
- You need a sequence in a defined order.

Use `HashSet` when:
- You need unique values.
- You need efficient membership checks.
- You need to detect duplicates.

---

## 15. HashSet vs HashMap

| Feature | HashSet | HashMap |
|---|---|---|
| Stores | Unique elements | Key-value mappings |
| Duplicate keys/elements | Duplicate elements rejected | Duplicate keys rejected |
| Duplicate values | Not applicable | Allowed |
| Main lookup | `contains(value)` | `get(key)` / `containsKey(key)` |
| Add operation | `add(value)` | `put(key, value)` |
| Typical use | Track seen values | Store associations or counts |

### Examples

Detect duplicates:

```java
HashSet<Integer> seen = new HashSet<>();
```

Count occurrences:

```java
HashMap<Integer, Integer> frequency = new HashMap<>();
```

Store a mapping:

```java
HashMap<Integer, String> namesById = new HashMap<>();
```

### Quick Decision Rule

```text
Need to preserve all occurrences? → ArrayList
Need unique values?              → HashSet
Need key → value associations?   → HashMap
Need value frequencies?          → HashMap
```

---

## 16. Classic DSA Use Case: Duplicate Detection

Suppose the input is:

```text
[2, 5, 2, 7, 5, 9]
```

We want to determine whether any value appears more than once.

A `HashSet` is a natural choice.

Conceptual algorithm:

1. Create an empty set.
2. Traverse the input.
3. If the current value already exists in the set, a duplicate has been found.
4. Otherwise, add the value to the set.

Dry run:

```text
Input: [2, 5, 2, 7, 5, 9]

2 → not seen → add 2
5 → not seen → add 5
2 → already seen → duplicate found
```

At this point, we can stop because the problem only asks whether any duplicate exists.

### Complexity

- Expected time: O(n)
- Auxiliary space: O(n)

In the worst case, we inspect every element. The set may store up to `n` distinct values.

---

## 17. Common Mistakes

### Mistake 1: Expecting duplicates

```java
set.add(10);
set.add(10);
```

Only one `10` exists.

### Mistake 2: Assuming iteration order

A normal `HashSet` does not guarantee that values will be traversed in insertion order.

### Mistake 3: Using an index

```java
set.get(0); // Invalid
```

A `HashSet` does not provide index-based access.

### Mistake 4: Confusing `add()` with `ArrayList.add()`

`HashSet.add()` returns a boolean indicating whether the element was added.

### Mistake 5: Assuming O(1) is guaranteed in every case

Hash-based operations are O(1) on average/expected, subject to collision behavior and implementation details.

### Mistake 6: Using HashSet when occurrences matter

If you must preserve duplicate occurrences, use an appropriate sequence such as `ArrayList`. If you must count them, consider `HashMap`.

---

## 18. Practice Questions

Try answering these without running the code.

### Question 1

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(10);
set.add(30);

System.out.println(set.size());
```

What is the output?

### Question 2

```java
HashSet<Integer> set = new HashSet<>();

boolean a = set.add(5);
boolean b = set.add(5);
```

What are `a` and `b`?

### Question 3

```java
HashSet<Integer> set = new HashSet<>();

set.add(10);
set.add(20);

System.out.println(set.contains(30));
```

What is the output?

### Question 4

Which data structure is most appropriate for checking whether a value has appeared before?

- A. `ArrayList`
- B. `HashSet`
- C. `HashMap`

### Question 5

Which data structure should you choose if you need to count the frequency of each integer?

- A. `ArrayList`
- B. `HashSet`
- C. `HashMap`

### Question 6

Does a normal Java `HashSet` guarantee iteration order?

- A. Yes
- B. No

---

## 19. Quick Revision

```text
HashSet
  ↓
Stores unique elements
  ↓
No index-based access
  ↓
No guaranteed iteration order
  ↓
Hashing-based membership checks
```

Important methods:

```java
set.add(value);       // Add if absent; returns boolean
set.contains(value);  // Check membership
set.remove(value);    // Remove; returns boolean
set.size();           // Number of unique elements
set.isEmpty();        // Is the set empty?
set.clear();          // Remove all elements
```

Expected complexity:

```text
add()      → O(1)
contains() → O(1)
remove()   → O(1)
```

### Final Decision Rule

```text
Sequence + duplicates + index
          → ArrayList

Unique values + membership checks
          → HashSet

Key-value associations + frequencies
          → HashMap
```

---

## Progress

- [x] What HashSet is
- [x] Why it exists
- [x] Creating a HashSet
- [x] `add()` and its boolean return value
- [x] Duplicate handling
- [x] `contains()`
- [x] `remove()` and its return value
- [x] `size()`
- [x] `isEmpty()`
- [x] `clear()`
- [x] Enhanced `for` loop traversal
- [x] No index-based access
- [x] `null` behavior
- [x] Hashing and collision basics
- [x] Basic complexity
- [x] HashSet vs ArrayList
- [x] HashSet vs HashMap
- [x] Duplicate detection use case

**Next collection:** Queue

We will begin Queue only after explicitly announcing the collection transition and presenting its learning checklist.