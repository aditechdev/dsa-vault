# HashMap in Java

## 1. What Is a HashMap?

A `HashMap` is a data structure that stores data in **key-value pairs**.

Each key is associated with a value.

```text
Key → Value

101 → Rahul
102 → Priya
103 → Amit
```

Java class:

```java
HashMap<Integer, String> map = new HashMap<>();
```

Here:
- `Integer` is the key type.
- `String` is the value type.
- `map` is the reference variable.

Import the class:

```java
import java.util.HashMap;
```

## 2. Why Do We Need HashMap?

An `ArrayList` stores elements in a sequence and accesses them using an index.

```java
ArrayList<String> names = new ArrayList<>();

names.add("Rahul");
names.add("Priya");
names.add("Amit");

System.out.println(names.get(1)); // Priya
```

But suppose we want to retrieve a user by their user ID.

A `HashMap` lets us associate the ID directly with the name.

```java
HashMap<Integer, String> users = new HashMap<>();

users.put(101, "Rahul");
users.put(102, "Priya");
users.put(103, "Amit");

System.out.println(users.get(102)); // Priya
```

### Core Difference

| ArrayList | HashMap |
|---|---|
| Stores elements in a sequence | Stores key-value mappings |
| Access by index | Access by key |
| Duplicate elements are allowed | Keys must be unique |
| Index-based access is O(1) | Key lookup is O(1) average |

**Remember:**

- `ArrayList`: Which element is at this position?
- `HashMap`: Which value is associated with this key?

## 3. Creating a HashMap

### Basic Syntax

```java
HashMap<KeyType, ValueType> map = new HashMap<>();
```

Examples:

```java
HashMap<Integer, String> names = new HashMap<>();

HashMap<String, Integer> ages = new HashMap<>();

HashMap<Integer, Integer> frequency = new HashMap<>();
```

The key and value types can differ.

For example:

```java
HashMap<Integer, String> employees = new HashMap<>();
```

This allows an integer key associated with a string value.

## 4. Adding Elements: `put()`

The `put()` method adds a key-value mapping.

```java
map.put(key, value);
```

Example:

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(101, "Rahul");
map.put(102, "Priya");
map.put(103, "Amit");
```

Conceptually:

```text
101 → Rahul
102 → Priya
103 → Amit
```

### Duplicate Keys

A `HashMap` cannot contain duplicate keys.

If we insert an existing key, its value is replaced.

```java
map.put(101, "Rahul");
map.put(102, "Priya");

map.put(101, "Amit");
```

Final mappings:

```text
101 → Amit
102 → Priya
```

The second `put()` updates key `101`; it does not create another mapping.

### Duplicate Values

Duplicate values are allowed.

```java
map.put(101, "Rahul");
map.put(102, "Rahul");
```

Both mappings are valid:

```text
101 → Rahul
102 → Rahul
```

**Rule: Keys are unique; values can repeat.**

## 5. Retrieving Elements: `get()`

The `get()` method retrieves the value associated with a key.

```java
map.get(key);
```

Example:

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(101, "Rahul");
map.put(102, "Priya");

System.out.println(map.get(101)); // Rahul
System.out.println(map.get(102)); // Priya
```

### Missing Key

If the key does not exist, `get()` returns `null`.

```java
System.out.println(map.get(999)); // null
```

This differs from `ArrayList`:

```java
list.get(999); // IndexOutOfBoundsException if index is invalid
map.get(999);  // null if key is absent
```

### Important: `null` Does Not Always Mean Missing Key

A `HashMap` can store `null` values.

```java
map.put(20, null);
```

Then:

```java
map.get(20); // null
```

The result is also `null` when the key is absent. Therefore, use `containsKey()` when you need to distinguish these cases.

## 6. Checking Keys: `containsKey()`

The `containsKey()` method checks whether a key exists.

```java
map.containsKey(key);
```

It returns a boolean.

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(101, "Rahul");
map.put(102, null);

System.out.println(map.containsKey(101)); // true
System.out.println(map.containsKey(102)); // true
System.out.println(map.containsKey(999)); // false
```

Even though key `102` maps to `null`, the key exists.

### `get()` vs `containsKey()`

| Expression | Meaning |
|---|---|
| `map.get(key)` | Retrieve the associated value |
| `map.containsKey(key)` | Check whether the key exists |

## 7. Checking Values: `containsValue()`

The `containsValue()` method checks whether a value exists in the map.

```java
map.containsValue(value);
```

Example:

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(101, "Rahul");
map.put(102, "Priya");

System.out.println(map.containsValue("Priya")); // true
System.out.println(map.containsValue("Amit"));  // false
```

**DSA note:** `containsKey()` is generally more important because HashMap is designed for key-based lookup. `containsValue()` generally requires scanning entries.

## 8. Removing Elements: `remove()`

The `remove()` method removes a mapping using its key.

```java
map.remove(key);
```

Example:

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(10, "A");
map.put(20, "B");
map.put(30, "C");

map.remove(20);
```

Remaining mappings:

```text
10 → A
30 → C
```

The key and its associated value are removed together.

## 9. Getting the Size: `size()`

The `size()` method returns the number of key-value mappings.

```java
map.size();
```

Example:

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(1, "A");
map.put(2, "B");
map.put(3, "C");

System.out.println(map.size()); // 3
```

Updating an existing key does not increase the size.

```java
map.put(2, "D");

System.out.println(map.size()); // 3
```

There are still only three unique keys.

## 10. Checking Whether a Map Is Empty: `isEmpty()`

The `isEmpty()` method returns `true` if the map contains zero mappings.

```java
HashMap<Integer, String> map = new HashMap<>();

System.out.println(map.isEmpty()); // true

map.put(1, "A");

System.out.println(map.isEmpty()); // false
```

After removing all mappings, the map becomes empty again.

## 11. Removing All Mappings: `clear()`

The `clear()` method removes all key-value mappings.

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(1, "A");
map.put(2, "B");

map.clear();

System.out.println(map.size());    // 0
System.out.println(map.isEmpty()); // true
```

The map object still exists. Only its mappings are removed.

You can add new mappings afterward.

## 12. Iterating Through a HashMap

A `HashMap` does not use numeric indexes like an `ArrayList`.

Java provides three useful methods for traversing its contents:

- `keySet()` — keys
- `values()` — values
- `entrySet()` — key-value entries

### 12.1 Enhanced For Loop

Java provides an enhanced `for` loop, also called a for-each loop.

Traditional loop:

```java
int[] arr = {10, 20, 30};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

Enhanced loop:

```java
for (int x : arr) {
    System.out.println(x);
}
```

Output:

```text
10
20
30
```

Read `for (int x : arr)` as:

"For each integer `x` in `arr`."

The variable `x` contains the current element, not its index.

The same syntax works with an `ArrayList`:

```java
for (int x : list) {
    System.out.println(x);
}
```

Assigning a new value to `x` does not replace the element in the list:

```java
for (int x : list) {
    x = x * 2;
}
```

To replace elements, use an index and `set()`:

```java
for (int i = 0; i < list.size(); i++) {
    list.set(i, list.get(i) * 2);
}
```

### 12.2 `keySet()` — Iterate Through Keys

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(10, "A");
map.put(20, "B");
map.put(30, "C");

for (Integer key : map.keySet()) {
    System.out.println(key);
}
```

This visits each key.

The iteration order is not guaranteed by a normal `HashMap`.

### 12.3 `values()` — Iterate Through Values

```java
for (String value : map.values()) {
    System.out.println(value);
}
```

This visits each value without requiring the key.

### 12.4 `entrySet()` — Iterate Through Keys and Values

Each mapping is represented by a `Map.Entry`.

```java
import java.util.HashMap;
import java.util.Map;

HashMap<Integer, String> map = new HashMap<>();

map.put(10, "A");
map.put(20, "B");

for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());
}
```

Each `entry` represents one key-value pair.

For example, when the current entry is:

```text
20 → B
```

then:

```java
entry.getKey();   // 20
entry.getValue(); // "B"
```

Use `entrySet()` when you need both the key and its value.

**Remember:**

| Method | Returns conceptually |
|---|---|
| `keySet()` | All keys |
| `values()` | All values |
| `entrySet()` | All key-value entries |

A normal `HashMap` does not guarantee the order in which these entries are traversed.

## 13. `null` Keys and Values

Java's standard `HashMap` permits one `null` key and multiple `null` values.

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(null, "A");
map.put(1, null);
map.put(2, null);
```

These mappings are valid.

### Only One `null` Key

```java
map.put(null, "A");
map.put(null, "B");
```

The second insertion replaces the value associated with the existing `null` key.

```java
System.out.println(map.get(null)); // B
```

There is still only one mapping for the `null` key.

### Multiple `null` Values

```java
map.put(1, null);
map.put(2, null);
```

Both mappings are valid because the keys differ.

## 14. The Return Value of `put()`

The `put()` method returns the previous value associated with the key, or `null` if there was no previous mapping.

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(10, "A");

String old = map.put(10, "B");

System.out.println(old);       // A
System.out.println(map.get(10)); // B
```

The previous value was `"A"`, and the new value is `"B"`.

**Caveat:** A return value of `null` does not always mean the key was absent, because its previous value might have been `null`.

## 15. `getOrDefault()`

The `getOrDefault()` method returns the associated value if the key exists; otherwise, it returns the specified default value.

```java
map.getOrDefault(key, defaultValue);
```

Example:

```java
HashMap<Integer, Integer> map = new HashMap<>();

map.put(10, 5);

System.out.println(map.getOrDefault(10, 0)); // 5
System.out.println(map.getOrDefault(20, 0)); // 0
```

For key `10`, the existing value is returned.

For missing key `20`, the default value `0` is returned.

**Important:** If a key exists with a `null` value, `getOrDefault()` returns that `null` value rather than the default.

## 16. Hashing: Basic Concept

A `HashMap` uses hashing to locate keys efficiently.

Conceptually:

```text
Key
 ↓
Hashing
 ↓
Hash-table location
 ↓
Find the associated value
```

When retrieving a value:

```java
map.get(key);
```

the map uses its hashing mechanism to find the corresponding mapping instead of always scanning every entry.

You do not manually calculate hash values when using a normal `HashMap`.

### Hash Collision

A collision occurs when different keys map to the same hash-table location.

Conceptually:

```text
Key A ──→ Bucket 5
Key B ──→ Bucket 5
```

The map must handle the collision correctly so that the two keys remain distinguishable.

You do not need to understand bucket implementation details to use `HashMap` in beginner-level DSA, but you should understand the term **collision**.

## 17. Time Complexity

For typical `HashMap` operations:

| Operation | Average / Expected Time |
|---|---:|
| `put(key, value)` | O(1) |
| `get(key)` | O(1) |
| `remove(key)` | O(1) |
| `containsKey(key)` | O(1) |
| `containsValue(value)` | O(n) |
| `size()` | O(1) |
| `isEmpty()` | O(1) |
| `clear()` | O(n) in terms of mappings under the usual complexity model |

Here, `n` is the number of mappings.

HashMap's key-based operations are typically O(1) on average, but they are not guaranteed to take constant time in every possible situation. Collisions and implementation details can affect performance.

## 18. HashMap vs ArrayList

| Feature | ArrayList | HashMap |
|---|---|---|
| Structure | Sequence | Key-value mappings |
| Access | Index | Key |
| Lookup | O(n) when searching by value | O(1) average when searching by key |
| Duplicate elements | Allowed | Values may repeat; keys are unique |
| Ordering | Maintains sequence order | No iteration-order guarantee |
| Typical use | Store and process a sequence | Associate values with keys |

### Choosing Between Them

Use an `ArrayList` when you need:
- A sequence of elements.
- Index-based access.
- Ordered traversal.
- A resizable collection.

Use a `HashMap` when you need:
- Key-value associations.
- Efficient lookup by key.
- To associate a value with an identifier.
- To maintain counts or other information for each key.

## 19. Common Mistakes

### Mistake 1: Assuming Duplicate Keys Create Multiple Entries

```java
map.put(1, "A");
map.put(1, "B");
```

Incorrect assumption: The map contains two entries with key `1`.

Correct: The mapping is updated to `1 → B`.

### Mistake 2: Assuming Missing Keys Throw an Index Exception

```java
map.get(999);
```

Correct: Returns `null` if no mapping exists for key `999`.

### Mistake 3: Confusing Keys and Values

```java
map.containsKey(10);
map.containsValue("A");
```

The first checks a key; the second checks a value.

### Mistake 4: Assuming Iteration Order

A normal `HashMap` does not guarantee insertion order.

Do not write logic that depends on a particular iteration order.

### Mistake 5: Assuming `get() == null` Means the Key Is Missing

A mapping may exist with a `null` value.

Use `containsKey()` when the distinction matters.

### Mistake 6: Treating Average O(1) as Guaranteed O(1)

HashMap operations are generally O(1) on average, not unconditionally O(1) in every situation.

## 20. DSA Applications

HashMap is frequently used for:

- Frequency counting.
- Finding duplicates.
- Mapping values to indexes.
- Tracking previously seen values.
- Grouping data by a key.
- Storing intermediate results.

Example of a frequency-map representation:

Input:

```text
[2, 3, 2, 5, 3, 2]
```

Expected frequency mapping:

```text
2 → 3
3 → 2
5 → 1
```

The mapping stores each distinct number as a key and its frequency as the value.

We will implement frequency counting in the DSA problem-solving section.

## 21. Interview Questions

1. What is a `HashMap`?
2. Why would you use a `HashMap` instead of an `ArrayList`?
3. Can a `HashMap` contain duplicate keys?
4. Can multiple keys map to the same value?
5. What happens when you insert an existing key?
6. What does `get()` return when the key is absent?
7. Why is `containsKey()` useful?
8. What is a hash collision?
9. What is the average time complexity of `get()`?
10. What is the difference between `keySet()`, `values()`, and `entrySet()`?
11. Does a normal `HashMap` guarantee iteration order?
12. What does `getOrDefault()` do?
13. Can a Java `HashMap` contain `null` keys and values?

## 22. Quick Revision

```text
HashMap<K, V>
    ↓
Stores key-value mappings

put(key, value)
    → Add or update a mapping

get(key)
    → Retrieve the associated value

containsKey(key)
    → Check whether a key exists

containsValue(value)
    → Check whether a value exists

remove(key)
    → Remove a mapping

size()
    → Number of mappings

isEmpty()
    → Check whether the map is empty

clear()
    → Remove all mappings

keySet()
    → All keys

values()
    → All values

entrySet()
    → Key-value entries

getOrDefault(key, defaultValue)
    → Return the mapped value or the default

Average key lookup
    → O(1)

Hash collision
    → Different keys map to the same hash-table location
```

### Final Takeaway

**Use `HashMap` when your problem naturally involves looking up a value using a key.**

It is one of the most important Java collections for DSA, particularly for hashing, frequency counting, and efficient lookups.
