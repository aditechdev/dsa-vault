# 05. Loops in Java

## 1. What Are Loops?

Loops allow us to execute a block of code repeatedly while a condition is satisfied or for a specified number of iterations.

Without a loop:

```java
System.out.println(1);
System.out.println(2);
System.out.println(3);
System.out.println(4);
System.out.println(5);
```

Using a loop:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

**Output:**

```text
1
2
3
4
5
```

Loops are fundamental to DSA because we frequently traverse arrays, process strings, and repeat calculations.

## 2. The `for` Loop

Use a `for` loop when the iteration logic is clear, especially when you know the range of iterations.

### Syntax

```java
for (initialization; condition; update) {
    // Code to repeat
}
```

The three parts are:

- **Initialization:** Executes once at the beginning.
- **Condition:** Checked before each iteration.
- **Update:** Executes after each completed iteration.

### Example

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

**Dry run:**

| Step | Value of `i` | Condition `i <= 5` | Action |
|---|---:|---|---|
| 1 | 1 | `true` | Print 1 |
| 2 | 2 | `true` | Print 2 |
| 3 | 3 | `true` | Print 3 |
| 4 | 4 | `true` | Print 4 |
| 5 | 5 | `true` | Print 5 |
| 6 | 6 | `false` | Stop |

### Counting Forward

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

Output: `0 1 2 3 4`

### Counting Backward

```java
for (int i = 5; i >= 1; i--) {
    System.out.println(i);
}
```

Output: `5 4 3 2 1`

### Using a Loop Variable in Calculations

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i * 2);
}
```

Output:

```text
2
4
6
8
10
```

## 3. Increment and Decrement

### Increment: `++`

Increases a variable by one.

```java
int x = 10;
x++;
```

Now `x = 11`.

Equivalent to:

```java
x = x + 1;
```

### Decrement: `--`

Decreases a variable by one.

```java
int x = 10;
x--;
```

Now `x = 9`.

Equivalent to:

```java
x = x - 1;
```

### Example

```java
int x = 10;

x++;
x++;
x--;
x++;
```

Final value: `x = 12`.

## 4. Nested Loops

A nested loop is a loop inside another loop.

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 2; j++) {
        System.out.println(i + " " + j);
    }
}
```

Output:

```text
1 1
1 2
2 1
2 2
3 1
3 2
```

The inner loop completes all its iterations for each iteration of the outer loop.

Here:

- Outer loop: 3 iterations.
- Inner loop: 2 iterations per outer iteration.
- Total inner-loop executions: \(3 \times 2 = 6\).

### Nested Loops and Complexity

Consider:

```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

The inner statement executes \(n \times n = n^2\) times.

This is **\(O(n^2)\)** time complexity.

## 5. The `while` Loop

A `while` loop repeats as long as its condition is `true`.

### Syntax

```java
while (condition) {
    // Code to repeat
}
```

### Example

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

Output:

```text
1
2
3
4
5
```

Execution:

1. Initialize `i = 1`.
2. Check whether `i <= 5`.
3. Execute the loop body if the condition is true.
4. Increment `i`.
5. Check the condition again.
6. Stop when the condition becomes false.

### Example: Decreasing by Two

```java
int x = 10;

while (x > 0) {
    x = x - 2;
}
```

Values of `x`: `10 → 8 → 6 → 4 → 2 → 0`.

The loop stops when `x > 0` becomes false.

### Example: Doubling a Value

```java
int x = 1;

while (x < 20) {
    x = x * 2;
}
```

Values: `1 → 2 → 4 → 8 → 16 → 32`.

Final value: `32`.

The loop stops when the condition becomes false; it does not necessarily stop at exactly 20.

## 6. `for` vs `while`

Both loops can perform the same task.

Using `for`:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Using `while`:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

Both print numbers from 1 to 5.

Use a `for` loop when initialization, condition, and update naturally belong together. Use a `while` loop when repetition depends on a condition that may change dynamically.

## 7. Infinite Loops

An infinite loop continues indefinitely because its termination condition never becomes false.

### Example

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
}
```

This loop never ends because `i` is never updated.

### Correct Version

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

**Important:** Ensure the loop can reach a terminating condition unless an infinite loop is intentional.

## 8. The `break` Statement

`break` immediately terminates the nearest enclosing loop.

### Example

```java
for (int i = 1; i <= 10; i++) {
    if (i == 6) {
        break;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

When `i == 6`, the loop ends before printing 6.

### DSA Application: Linear Search

```java
int[] arr = {5, 12, 8, 20, 15};
int target = 20;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        System.out.println("Found at index " + i);
        break;
    }
}
```

Output:

```text
Found at index 3
```

The `break` avoids checking remaining elements after finding the target.

## 9. The `continue` Statement

`continue` skips the rest of the current iteration and proceeds to the next iteration.

### Example

```java
for (int i = 1; i <= 6; i++) {
    if (i % 2 == 0) {
        continue;
    }

    System.out.println(i);
}
```

Output:

```text
1
3
5
```

Even numbers are skipped because `i % 2 == 0`.

### `break` vs `continue`

| Statement | Behavior |
|---|---|
| `break` | Terminates the loop |
| `continue` | Skips the current iteration |

**Important:** In a `while` loop, ensure the variable used in the condition still gets updated when using `continue`. Otherwise, you may accidentally create an infinite loop.

## 10. The `do-while` Loop

A `do-while` loop executes its body at least once because the condition is checked after the body.

### Syntax

```java
do {
    // Code to repeat
} while (condition);
```

Notice the semicolon after `while (condition)`.

### Example

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 5);
```

Output:

```text
1
2
3
4
5
```

### Key Difference

```java
int i = 10;

while (i < 5) {
    System.out.println(i);
}
```

Prints nothing because the condition is initially false.

But:

```java
int i = 10;

do {
    System.out.println(i);
} while (i < 5);
```

Prints `10` once.

## 11. Loops and Arrays

Loops are commonly used to traverse and process arrays.

### Forward Traversal

```java
int[] arr = {10, 20, 30, 40, 50};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

### Backward Traversal

```java
int[] arr = {10, 20, 30, 40, 50};

for (int i = arr.length - 1; i >= 0; i--) {
    System.out.println(arr[i]);
}
```

Output:

```text
50
40
30
20
10
```

### Modifying Array Elements

```java
int[] arr = {1, 2, 3, 4, 5};

for (int i = 0; i < arr.length; i++) {
    arr[i] = arr[i] * 2;
}
```

Final array: `[2, 4, 6, 8, 10]`.

### Summing Array Elements

```java
int[] arr = {10, 20, 30, 40, 50};
int sum = 0;

for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
}
```

Final value: `sum = 150`.

## 12. Common Loop Patterns

### Counting

```java
int count = 0;

for (int i = 0; i < n; i++) {
    count++;
}
```

### Accumulation

```java
int sum = 0;

for (int i = 1; i <= 5; i++) {
    sum += i;
}
```

Final value: `sum = 15`.

### Filtering

```java
int[] arr = {10, 15, 22, 7, 8, 13};
int count = 0;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] % 2 == 0) {
        count++;
    }
}
```

Final value: `count = 3`.

### Searching

```java
int[] arr = {5, 12, 8, 20, 15};
int target = 100;
int index = -1;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        index = i;
        break;
    }
}
```

Final value: `index = -1`, meaning the target was not found.

## 13. Practice Questions

1. Print numbers from 1 to 100.
2. Print numbers from 100 down to 1.
3. Print all even numbers between 1 and 50.
4. Calculate the sum of numbers from 1 to `n`.
5. Calculate the factorial of a positive integer.
6. Print a multiplication table for a given number.
7. Count the digits in an integer.
8. Reverse the digits of an integer.
9. Print this pattern using nested loops:

   ```text
   *
   **
   ***
   ****
   *****
   ```

10. Find the maximum element in an array using a loop.
11. Count the even numbers in an array.
12. Reverse an array using two pointers and a `while` loop.

## Summary

- `for`: Useful when loop control is clearly defined.
- `while`: Repeats while a condition is true.
- `do-while`: Executes at least once.
- `++`: Increments a variable.
- `--`: Decrements a variable.
- `break`: Exits the nearest enclosing loop.
- `continue`: Skips the current iteration.
- Nested loops: Run one loop inside another.
- Array traversal: Uses loops to access each element.

**Next topic:** Methods and functions in Java.
