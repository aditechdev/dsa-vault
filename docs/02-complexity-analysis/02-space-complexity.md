# Space Complexity — Java DSA Notes

> **Goal:** Understand how to analyze an algorithm's memory usage, calculate auxiliary space, analyze recursion and collections, and compare time and space complexity independently.

## 1. What Is Space Complexity?

**Space Complexity** describes how the memory requirements of an algorithm grow as the input size increases.

We analyze memory growth rather than the exact number of bytes used by a particular machine or JVM.

### Time vs. Space Complexity

| Complexity | Question |
|---|---|
| Time Complexity | How does the amount of work grow with input size? |
| Space Complexity | How does the memory requirement grow with input size? |

Example:

```java
int sum = 0;

for (int i = 0; i < n; i++) {
    sum += i;
}
```

Analysis:

- Time Complexity: `O(n)` because the loop executes `n` times.
- Auxiliary Space: `O(1)` because we use a fixed number of variables.

**Important:** More iterations do not automatically mean more memory.

---

## 2. Input Space vs. Auxiliary Space

There are two important memory concepts.

### 2.1 Input Space

Memory occupied by the input provided to the algorithm.

Example:

```java
void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }
}
```

If `arr` contains `n` elements:

- Input Space: `O(n)`
- Auxiliary Space: `O(1)`

The algorithm reads the existing array without creating another array proportional to `n`.

### 2.2 Auxiliary Space

Auxiliary space is the extra memory used by the algorithm, excluding the input itself.

Example:

```java
void process(int[] arr) {
    int[] result = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[i] * 2;
    }
}
```

Assume `arr` contains `n` elements.

| Memory | Complexity |
|---|---|
| Input array `arr` | `O(n)` |
| Extra array `result` | `O(n)` |
| Loop variable `i` | `O(1)` |

Therefore:

- Input Space: `O(n)`
- Auxiliary Space: `O(n)`
- Total Space: `O(n)`

### 2.3 Total Space

For this topic, total space means the input storage plus the additional storage required by the algorithm.

```text
Total Space = Input Space + Auxiliary Space
```

Example:

```text
Input:       O(n)
Auxiliary:   O(n)

Total:       O(n) + O(n)
           = O(2n)
           = O(n)
```

Big-O describes growth and ignores constant factors.

**Interview convention:** When an interviewer asks for space complexity, clarify whether they mean auxiliary space or total space if the distinction matters.

---

## 3. Understanding O(1) Space

`O(1)` means constant space: the amount of additional memory does not grow with the input size.

Example:

```java
int a = 10;
int b = 20;
int c = 30;
```

There are three variables, but their number is fixed.

```text
Space = O(1)
```

Even a fixed number of 100 variables would be `O(1)` with respect to `n`.

### Loop example

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Analysis:

- Time: `O(n)`
- Auxiliary Space: `O(1)`

The loop reuses the same variable. It does not retain all `n` values.

### Key rule

> `O(1)` does not mean one variable. It means memory usage does not grow with input size.

---

## 4. Understanding O(n) Space

Memory is `O(n)` when it grows linearly with the input size.

Example:

```java
int[] result = new int[n];
```

The array contains `n` elements.

```text
n = 5       → 5 elements
n = 100     → 100 elements
n = 1000    → 1000 elements
```

Therefore:

```text
Auxiliary Space = O(n)
```

### Array creation inside a loop

```java
int[] result = new int[n];

for (int i = 0; i < n; i++) {
    int sum = i * 2;
    result[i] = sum;
}
```

Analysis:

- `result`: `O(n)`
- `i`: `O(1)`
- `sum`: `O(1)`

The variable `sum` is declared repeatedly as the loop executes, but the algorithm does not retain a separate `sum` for every iteration.

```text
O(n) + O(1) + O(1) = O(n)
```

**Important:** The array causes `O(n)` space, not the repeated creation of the local variable.

---

## 5. Understanding O(n²) Space

A two-dimensional array with `n` rows and `n` columns stores `n × n` elements.

Example:

```java
int[][] matrix = new int[n][n];
```

For `n = 3`:

```text
[ ][ ][ ]
[ ][ ][ ]
[ ][ ][ ]
```

Total elements:

```text
3 × 3 = 9
```

For general `n`:

```text
n × n = n²
```

Therefore:

```text
Auxiliary Space = O(n²)
```

### Filling the matrix

```java
int[][] matrix = new int[n][n];

for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        matrix[i][j] = i + j;
    }
}
```

Analysis:

- Time: `O(n²)` because both loops execute `n` times.
- Auxiliary Space: `O(n²)` because the matrix stores `n²` elements.

The loops determine the work; the matrix determines the growing storage.

---

## 6. Space Complexity of Different Array Dimensions

Always inspect the dimensions rather than assuming every 2D array requires `O(n²)` space.

| Java declaration | Number of elements | Space |
|---|---:|---|
| `new int[10]` | `10` | `O(1)` |
| `new int[n]` | `n` | `O(n)` |
| `new int[n][n]` | `n²` | `O(n²)` |
| `new int[n][m]` | `nm` | `O(nm)` |
| `new int[n][10]` | `10n` | `O(n)` |
| `new int[20][m]` | `20m` | `O(m)` |
| `new int[20][30]` | `600` | `O(1)` |

### Example: Different dimensions

```java
int[][] grid = new int[n][m];
```

If `n = 3` and `m = 4`, the grid contains 12 elements.

```text
Rows × Columns
3 × 4 = 12
```

In general:

```text
Space = O(nm)
```

Do not simplify this to `O(n²)` unless the problem establishes that both dimensions grow proportionally to `n`.

---

## 7. Combining Multiple Data Structures

When several structures retain memory simultaneously, add their storage requirements and simplify the result.

### Example 1: Two arrays

```java
int[] a = new int[n];
int[] b = new int[n];
```

```text
a     → O(n)
b     → O(n)

Total → O(n) + O(n)
      = O(2n)
      = O(n)
```

### Example 2: Two arrays and a constant-sized array

```java
int[] a = new int[n];
int[] b = new int[n];
int[] c = new int[100];
```

```text
a → O(n)
b → O(n)
c → O(1)

Total → O(n) + O(n) + O(1)
      = O(n)
```

### Example 3: Arrays and a matrix

```java
int[] a = new int[n];
int[] b = new int[n];
int[][] matrix = new int[n][n];
```

```text
a      → O(n)
b      → O(n)
matrix → O(n²)

Total → O(n) + O(n) + O(n²)
      = O(n²)
```

The quadratic term dominates.

### Dominant-term rules

```text
O(n) + O(1)  = O(n)
O(n) + O(n)  = O(n)
O(n) + O(n²) = O(n²)
O(n²) + O(n³) = O(n³)
```

---

## 8. Space Complexity of Java Collections

The space complexity of a collection depends on how many elements or entries it retains.

### 8.1 ArrayList

```java
ArrayList<Integer> list = new ArrayList<>();

for (int i = 0; i < n; i++) {
    list.add(i);
}
```

The list retains `n` elements.

```text
Auxiliary Space = O(n)
```

### 8.2 HashMap

```java
HashMap<Integer, Integer> map = new HashMap<>();

for (int i = 0; i < n; i++) {
    map.put(i, i * 2);
}
```

The map stores `n` distinct key-value entries.

```text
Auxiliary Space = O(n)
```

### 8.3 HashSet

```java
HashSet<Integer> set = new HashSet<>();

for (int i = 0; i < n; i++) {
    set.add(i);
}
```

If the set retains `n` distinct values:

```text
Auxiliary Space = O(n)
```

But consider:

```java
HashSet<Integer> set = new HashSet<>();

for (int i = 0; i < n; i++) {
    set.add(i % 100);
}
```

The only possible values are `0` through `99`.

The set retains at most 100 distinct values, regardless of `n`.

```text
Auxiliary Space = O(100) = O(1)
```

### 8.4 Queue

Keeping every element:

```java
Queue<Integer> queue = new LinkedList<>();

for (int i = 0; i < n; i++) {
    queue.offer(i);
}
```

```text
Auxiliary Space = O(n)
```

Keeping the queue bounded:

```java
Queue<Integer> queue = new LinkedList<>();

for (int i = 0; i < n; i++) {
    queue.offer(i);

    if (queue.size() > 10) {
        queue.poll();
    }
}
```

After each iteration, the queue contains at most 10 elements. Immediately after `offer()` and before `poll()`, it can temporarily contain 11.

Both bounds are constants.

```text
Auxiliary Space = O(1)
```

### 8.5 Stack, Deque and PriorityQueue

| Structure | Retained data | Space |
|---|---|---|
| Stack | `n` elements | `O(n)` |
| Deque | `n` elements | `O(n)` |
| PriorityQueue | `n` elements | `O(n)` |

A PriorityQueue is commonly implemented using a heap, but storing `n` heap elements still requires `O(n)` space. Its `O(log n)` height is not the total storage requirement.

### Collection rule

> Do not classify space solely from the collection type. Determine how much data it retains.

---

## 9. Temporary Memory vs. Retained Memory

The number of allocations is not necessarily the peak memory requirement.

### Example 1: Fixed-sized temporary arrays

```java
for (int i = 0; i < n; i++) {
    int[] temp = new int[10];
}
```

Each array contains 10 elements.

If previous arrays become unreachable before the next allocation, the algorithm's peak live auxiliary space is `O(1)`.

### Example 2: Temporary arrays of size n

```java
for (int i = 0; i < n; i++) {
    int[] temp = new int[n];

    // Use temp.
}
```

Each array contains `n` elements.

If only one array is needed at a time and previous arrays become unreachable, the peak live auxiliary space is `O(n)`, not automatically `O(n²)`.

### Example 3: Retaining all arrays

```java
int[][] all = new int[n][n];
```

The matrix retains `n²` elements.

```text
Auxiliary Space = O(n²)
```

### Important Java qualification

An unreachable object becomes eligible for garbage collection, but Java does not guarantee that garbage collection happens immediately. For algorithmic space analysis, we normally reason about the peak live memory required by the algorithm, rather than the exact physical heap occupancy at every instant.

**Remember:**

```text
Repeated allocation ≠ automatically O(n²) space
Retained n-sized matrix = O(n²) space
```

---

## 10. Recursion and Call-Stack Space

Recursion consumes memory because each active method call needs a stack frame.

A stack frame conceptually holds information such as method parameters, local variables and return information.

### 10.1 Linear recursion

```java
void fun(int n) {
    if (n == 0) {
        return;
    }

    fun(n - 1);
}
```

For `fun(3)`:

```text
fun(3)
  |
fun(2)
  |
fun(1)
  |
fun(0)
```

There are four active calls at the deepest point.

For general `n`, the maximum depth is `n + 1`.

```text
Time Complexity      = O(n)
Auxiliary Space      = O(n)
```

### 10.2 Logarithmic recursion

```java
void fun(int n) {
    if (n <= 1) {
        return;
    }

    fun(n / 2);
}
```

For `n = 32`:

```text
fun(32)
   |
fun(16)
   |
fun(8)
   |
fun(4)
   |
fun(2)
   |
fun(1)
```

The input is repeatedly divided by 2.

The maximum recursion depth is proportional to `log₂(n)`.

```text
Auxiliary Space = O(log n)
```

### 10.3 Branching recursion

```java
void fun(int n) {
    if (n <= 0) {
        return;
    }

    fun(n - 1);
    fun(n - 1);
}
```

There are two recursive calls, but Java executes them sequentially. The first finishes before the second begins.

For space complexity, count the maximum number of simultaneously active stack frames.

The maximum depth is `O(n)`, so:

```text
Auxiliary Space = O(n)
```

The total number of calls can be much larger. That affects time complexity and must be analyzed separately.

### 10.4 Two branches that halve the input

```java
void fun(int n) {
    if (n <= 1) {
        return;
    }

    fun(n / 2);
    fun(n / 2);
}
```

The maximum depth is logarithmic:

```text
n → n/2 → n/4 → ... → 1
```

Therefore:

```text
Auxiliary Space = O(log n)
```

The existence of two recursive branches does not automatically make the stack space `O(n²)`.

### Recursion rule

> Auxiliary space depends on maximum recursion depth and the memory used by active stack frames—not merely the total number of calls.

---

## 11. Multiple Function Calls and Simultaneous Memory

When methods call other methods, determine which allocations coexist.

### 11.1 Sequential calls

```java
void A(int n) {
    B(n);
    C(n);
}

void B(int n) {
    int[] x = new int[n];
}

void C(int n) {
    int[] y = new int[n];
}
```

`B()` finishes before `C()` begins.

Each method creates an `O(n)` array. Their temporary arrays need not coexist.

```text
Peak auxiliary space = max(O(n), O(n))
                     = O(n)
```

### 11.2 Nested calls

```java
void A(int n) {
    int[] x = new int[n];
    B(n);
}

void B(int n) {
    int[] y = new int[n];
}
```

While `B()` executes, `A()` has not finished.

Both arrays exist simultaneously.

```text
O(n) + O(n) = O(n)
```

### 11.3 Nested calls with different sizes

```java
void A(int n) {
    int[] x = new int[n];
    B(n);
}

void B(int n) {
    int[][] y = new int[n][n];
}
```

While `B()` executes:

```text
x → O(n)
y → O(n²)
```

Therefore:

```text
O(n) + O(n²) = O(n²)
```

### 11.4 Passing an array to another method

```java
void A(int n) {
    int[] arr = new int[n];
    B(arr);
}

void B(int[] arr) {
    // Process the existing array.
}
```

Java passes the array reference by value. The method receives a reference to the same array; it does not automatically copy all its elements.

```text
Array storage       → O(n)
Parameter reference → O(1)

Overall             → O(n)
```

Compare:

```java
B(arr);                       // Pass existing reference.
B(Arrays.copyOf(arr, n));     // Create an additional array.
```

The copy in the second call requires `O(n)` additional space.

---

## 12. Strings and Space Complexity

Java `String` objects are immutable: their contents cannot be changed after creation.

### 12.1 Fixed-size string

```java
String name = "Hello";
```

With respect to an input size `n`, a fixed-size literal contributes constant-sized data:

```text
Space = O(1)
```

### 12.2 String of length n

Suppose an input string contains `n` characters.

Its character data grows with `n`.

```text
String length = n
Space         = O(n)
```

The exact JVM representation is implementation-dependent; Big-O reasoning focuses on growth.

### 12.3 Input string vs. new string

```java
void process(String s) {
    // Read s without creating another growing structure.
}
```

If `s` is the input:

```text
Input Space     = O(n)
Auxiliary Space = O(1)
```

Now consider an algorithm that constructs and retains another string of length `n`.

```text
Input string    = O(n)
New string      = O(n)
```

The additional string contributes `O(n)` auxiliary space.

### 12.4 String concatenation

```java
String result = "";

for (int i = 0; i < s.length(); i++) {
    result = result + s.charAt(i);
}
```

Because `String` is immutable, concatenation generally creates new string results rather than modifying the existing string in place.

This can cause repeated copying and temporary allocations.

- A straightforward repeated-concatenation implementation can take `O(n²)` time.
- The final retained result has length `n`, so its storage is `O(n)`.
- Exact peak memory depends on the implementation and temporary-object lifetimes.

For repeated string construction, `StringBuilder` is usually a better choice:

```java
StringBuilder result = new StringBuilder();

for (int i = 0; i < s.length(); i++) {
    result.append(s.charAt(i));
}
```

For a result of length `n`:

```text
Time             = O(n) amortized
Auxiliary Space  = O(n)
```

This is a conceptual introduction; detailed string problems can be covered in the Strings topic.

---

## 13. Objects and Nodes: Space Basics

An object with a fixed number of fields occupies constant space, excluding any separately allocated data referenced by those fields.

Example:

```java
class Person {
    int age;
}

Person p1 = new Person();
Person p2 = new Person();
Person p3 = new Person();
```

A fixed number of objects:

```text
Space = O(1)
```

### Creating n objects

```java
class Person {
    int age;
}

Person[] people = new Person[n];

for (int i = 0; i < n; i++) {
    people[i] = new Person();
}
```

Memory includes:

- An array of `n` references.
- `n` `Person` objects.

```text
O(n) + O(n) = O(n)
```

### Node concept

A Node is an object commonly used to build data structures.

```java
class Node {
    int data;
    Node next;
}
```

- One Node: `O(1)` space.
- `n` retained Nodes: `O(n)` space.

The `next` field is a reference; it does not automatically allocate another Node.

Detailed Node behavior belongs to Linked Lists and Trees.

---

## 14. In-Place Algorithms

An in-place algorithm modifies the existing input structure while using only constant or small auxiliary memory.

### 14.1 Using another array

```java
int[] result = new int[n];
```

An additional `n`-element array requires:

```text
Auxiliary Space = O(n)
```

### 14.2 Modifying the original array

Consider reversing:

```text
Original: [1, 2, 3, 4, 5]
```

Swap the outer elements:

```text
[5, 2, 3, 4, 1]
```

Then swap the next pair:

```text
[5, 4, 3, 2, 1]
```

A few variables are sufficient:

```java
int temp;
int left;
int right;
```

```text
Auxiliary Space = O(1)
```

The two-pointer reversal takes `O(n)` time and `O(1)` auxiliary space.

### Important distinction

In-place does not mean zero extra memory. It generally means the algorithm does not allocate another data structure proportional to the input size.

For example:

```text
Reverse using a new array → O(n) auxiliary space
Reverse using swaps       → O(1) auxiliary space
```

---

## 15. Time Complexity vs. Space Complexity

Analyze time and space independently.

### Example 1: Linear time, constant space

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

```text
Time  = O(n)
Space = O(1)
```

### Example 2: Linear time, linear space

```java
int[] result = new int[n];

for (int i = 0; i < n; i++) {
    result[i] = i;
}
```

```text
Time  = O(n)
Space = O(n)
```

### Example 3: Quadratic time, constant space

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

```text
Time  = O(n²)
Space = O(1)
```

The nested loops increase work, not necessarily storage.

### Example 4: Linear time, quadratic space

```java
int[][] matrix = new int[n][n];

for (int i = 0; i < n; i++) {
    matrix[i][0] = i;
}
```

```text
Time  = O(n)
Space = O(n²)
```

The loop runs linearly, but the matrix stores `n²` elements.

### Example 5: Sequential loops

```java
int[] a = new int[n];
int[] b = new int[n];

for (int i = 0; i < n; i++) {
    a[i] = i;
}

for (int i = 0; i < n; i++) {
    b[i] = a[i] * 2;
}
```

The loops are sequential:

```text
Time = O(n) + O(n)
     = O(2n)
     = O(n)
```

Both arrays coexist:

```text
Space = O(n) + O(n)
      = O(n)
```

### Sequential vs. nested loops

```text
Sequential loops → Add time complexities.

Nested loops     → Multiply iteration counts.

Space            → Count simultaneously retained memory.
```

---

## 16. Understanding O(n log n)

`O(n log n)` is called **linearithmic time complexity**.

You already know:

- `O(n)` means linear growth.
- `O(log n)` commonly appears when an input is repeatedly divided by a constant factor, such as 2.

If an `O(log n)` operation is performed `n` times:

```java
for (int i = 0; i < n; i++) {
    // Perform O(log n) work.
}
```

Then:

```text
Time = n × log n
     = O(n log n)
```

For example:

```text
n = 8:   8 × log₂(8)  = 8 × 3 = 24
n = 16: 16 × log₂(16) = 16 × 4 = 64
n = 32: 32 × log₂(32) = 32 × 5 = 160
```

Common examples:

| Algorithm | Typical time complexity |
|---|---|
| Merge Sort | `O(n log n)` |
| Heap Sort | `O(n log n)` |
| Quick Sort | `O(n log n)` average case |

The key pattern is:

```text
O(n) × O(log n) = O(n log n)
```

This is a time-complexity concept. It does not automatically imply `O(n log n)` space.

---

## 17. Common Interview Traps

### Trap 1: Assuming loops determine space

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

Incorrect: `O(n²)` space.

Correct:

```text
Time  = O(n²)
Space = O(1)
```

### Trap 2: Assuming every 2D array is quadratic

```java
new int[n][10]
```

Correct: `O(n)`, because 10 is constant.

### Trap 3: Assuming a PriorityQueue uses O(log n) space

A heap with `n` elements stores `n` elements.

Correct: `O(n)` space.

### Trap 4: Counting all allocations instead of peak live memory

Creating temporary arrays repeatedly does not automatically make peak space `O(n²)`.

Consider whether earlier arrays are retained.

### Trap 5: Counting every recursive call for space

Total recursive calls primarily affect time. Maximum simultaneous stack depth determines recursion-stack space.

### Trap 6: Assuming a method parameter copies an array

Passing an array reference does not copy the array contents.

### Trap 7: Confusing input space with auxiliary space

If an array is supplied as input, do not count it as auxiliary space.

### Trap 8: Thinking in-place means zero extra memory

A few temporary variables still consume constant space.

### Trap 9: Assuming repeated assignments retain all previous values

```java
int sum = i * 2;
```

does not create a growing collection of sums.

### Trap 10: Assuming two `O(n)` structures produce `O(n²)`

```text
O(n) + O(n) = O(n)
```

Quadratic space requires a quadratic growth factor, such as an `n × n` matrix.

---

## 18. Space Complexity Analysis Checklist

When analyzing an unfamiliar algorithm, use this checklist.

1. **Identify the input.** What memory already exists?
2. **Find additional allocations.** Look for arrays, collections, objects, strings and other growing structures.
3. **Count retained data.** How many elements or entries are actually stored?
4. **Check dimensions.** Is the allocation proportional to `n`, `n²`, `nm` or a constant?
5. **Check object lifetime.** Are allocations retained or merely temporary?
6. **Check method calls.** Which allocations coexist during nested calls?
7. **Check recursion depth.** How many stack frames are active at the deepest point?
8. **Separate time from space.** Do not infer space from the number of loop iterations.
9. **Add simultaneous memory.** Combine the space requirements that coexist.
10. **Simplify.** Remove constants and retain the dominant growth term.
11. **State the result.** Clearly identify time, auxiliary space and total space where appropriate.

---

## 19. Quick Revision Table

| Pattern | Complexity |
|---|---|
| Fixed number of variables | `O(1)` space |
| Array of `n` elements | `O(n)` space |
| Matrix of `n × n` | `O(n²)` space |
| Matrix of `n × m` | `O(nm)` space |
| Matrix of `n × constant` | `O(n)` space |
| Fixed number of objects | `O(1)` space |
| `n` retained objects | `O(n)` space |
| Collection retaining `n` elements | `O(n)` space |
| Collection bounded by a constant | `O(1)` space |
| Recursion depth `n` | `O(n)` stack space |
| Recursion depth `log n` | `O(log n)` stack space |
| In-place array reversal | `O(1)` auxiliary space |
| Two `O(n)` structures coexisting | `O(n)` combined space |
| `O(n)` and `O(n²)` structures coexisting | `O(n²)` combined space |
| `n` sequential iterations | Usually `O(n)` time |
| Two nested `n`-iteration loops | Usually `O(n²)` time |
| `n` operations, each costing `O(log n)` | `O(n log n)` time |

---

## 20. Learning Progress and Remaining Topics

### Covered in our learning session

- [x] Definition of Space Complexity
- [x] Input Space vs. Auxiliary Space
- [x] Total Space
- [x] `O(1)`, `O(n)`, `O(n²)` and `O(nm)` space
- [x] Arrays and matrices of different dimensions
- [x] Combining multiple data structures
- [x] ArrayList, HashMap, HashSet, Stack, Queue, Deque and PriorityQueue space
- [x] Retained vs. temporary memory
- [x] Recursion and call-stack space
- [x] Linear and logarithmic recursion depth
- [x] Multiple function calls and simultaneous memory
- [x] String space fundamentals and immutability
- [x] Basic object and Node space
- [x] In-place algorithms
- [x] Mixed time and space examples
- [x] `O(n log n)` time-complexity refresher
- [x] Common interview traps

### Still to practise and consolidate

- [ ] Detailed string-space problems and concatenation analysis
- [ ] More challenging nested-function memory analysis
- [ ] In-place algorithm comparisons
- [ ] Auxiliary vs. total space in unfamiliar problems
- [ ] Space complexity of common DSA operations and algorithms
- [ ] Mixed time and space practice problems
- [ ] Interview-style edge cases and traps
- [ ] Final Space Complexity assessment

**Important:** Having covered a concept in an explanation is not the same as mastering it independently. The remaining work is to practise the concepts until you can analyze unfamiliar code without hints.

---

## Final Mental Model

Remember these three questions:

**1. Time:** How much work does the algorithm perform as input grows?

**2. Space:** How much memory does it retain as input grows?

**3. Auxiliary space:** How much extra memory does the algorithm require, excluding the input itself?

The central principle is:

> **Count the memory that is simultaneously required, determine how it grows with the input, and simplify the result using Big-O.**