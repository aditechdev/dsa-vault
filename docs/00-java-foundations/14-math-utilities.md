# Java Math Utilities

## 1. Introduction

Java provides a built-in `Math` class containing useful mathematical methods.

These methods help us perform operations such as:

- Finding the maximum and minimum of two numbers
- Calculating absolute differences
- Finding square roots and powers
- Rounding decimal numbers
- Initializing minimum and maximum values in DSA problems

The `Math` class is available in `java.lang`, so **no import is required**.

---

## 2. `Math.max()`

### What is it?

`Math.max(a, b)` returns the larger of two values.

### Syntax

```java
Math.max(a, b);
```

### Example

```java
int a = 10;
int b = 20;

int max = Math.max(a, b);

System.out.println(max);
```

Output:

```text
20
```

### Dry run

```text
Math.max(10, 20)
        ↓
Compare 10 and 20
        ↓
Larger value = 20
        ↓
max = 20
```

### Important points

- Returns the larger value.
- Does not modify the original variables.
- Supports `int`, `long`, `float`, and `double` overloads.

### DSA use case

Finding the larger of two values:

```java
int max = Math.max(a, b);
```

---

## 3. `Math.min()`

### What is it?

`Math.min(a, b)` returns the smaller of two values.

### Example

```java
int x = Math.min(25, 40);

System.out.println(x);
```

Output:

```text
25
```

### Dry run

```text
Math.min(25, 40)
        ↓
Compare 25 and 40
        ↓
Smaller value = 25
```

### DSA use case

Finding the smaller of two values:

```java
int min = Math.min(a, b);
```

---

## 4. `Math.abs()`

### What is it?

`Math.abs(x)` returns the absolute value of a number.

For ordinary values, it removes the negative sign when necessary.

### Examples

```java
Math.abs(10);    // 10
Math.abs(-10);   // 10
Math.abs(0);     // 0
```

### Dry run

```java
int x = Math.abs(7 - 20);
```

Execution:

```text
7 - 20 = -13
Math.abs(-13) = 13
x = 13
```

### DSA use case: Absolute difference

```java
int difference = Math.abs(a - b);
```

If `a = 10` and `b = 25`:

```text
a - b = -15
Math.abs(-15) = 15
```

**Important:** `Math.abs(Integer.MIN_VALUE)` is still negative because the positive counterpart cannot fit in an `int`. Be careful with integer overflow in edge cases.

---

## 5. `Math.sqrt()`

### What is it?

`Math.sqrt(x)` calculates the square root of a number.

### Example

```java
double result = Math.sqrt(49);

System.out.println(result);
```

Output:

```text
7.0
```

### More examples

```java
Math.sqrt(25);  // 5.0
Math.sqrt(16);  // 4.0
Math.sqrt(9);   // 3.0
```

### Important points

- Returns a `double`.
- A negative input produces `NaN` (not a number).

### DSA use case

Square roots are useful in mathematical problems, including some number-theory algorithms.

---

## 6. `Math.pow()`

### What is it?

`Math.pow(base, exponent)` calculates a number raised to a power.

### Example

```java
double result = Math.pow(3, 2);

System.out.println(result);
```

Output:

```text
9.0
```

### Dry run

```text
3²
= 3 × 3
= 9
```

### More examples

```java
Math.pow(2, 3);   // 8.0
Math.pow(5, 2);   // 25.0
Math.pow(10, 2);  // 100.0
```

### Important points

- Returns a `double`.
- Floating-point precision can matter for large or non-integer calculations.
- For integer exponentiation in DSA, don't automatically assume `Math.pow()` is the best choice.

---

## 7. `Math.ceil()`

### What is it?

`Math.ceil(x)` returns the smallest whole-number value that is greater than or equal to `x`.

Its return type is `double`.

### Example

```java
double result = Math.ceil(5.1);

System.out.println(result);
```

Output:

```text
6.0
```

### Examples

```java
Math.ceil(4.2);   // 5.0
Math.ceil(7.9);   // 8.0
Math.ceil(7.0);   // 7.0
Math.ceil(-4.2);  // -4.0
```

### Important rule

Ceiling moves toward positive infinity, not simply toward a larger absolute value.

For example:

```text
Math.ceil(-5.1) = -5.0
```

### DSA use case: Ceiling division

When `n` items must be divided into groups of size `k`, the number of groups required is:

\[
\left\lceil \frac{n}{k} \right\rceil
\]

For positive integers, a common overflow-safe approach is:

```java
int groups = n / k;

if (n % k != 0) {
    groups++;
}
```

This avoids converting to `double` just to round upward. Assume `k > 0` and `n >= 0`.

---

## 8. `Math.floor()`

### What is it?

`Math.floor(x)` returns the greatest whole-number value that is less than or equal to `x`.

Its return type is `double`.

### Example

```java
double result = Math.floor(8.7);

System.out.println(result);
```

Output:

```text
8.0
```

### Examples

```java
Math.floor(5.1);   // 5.0
Math.floor(5.9);   // 5.0
Math.floor(5.0);   // 5.0
Math.floor(-5.1);  // -6.0
```

### Important rule

Floor moves toward negative infinity.

```text
Math.floor(-5.1) = -6.0
```

It does not mean simply removing the decimal portion, especially for negative values.

---

## 9. `Math.round()`

### What is it?

`Math.round(x)` rounds a number to the nearest whole-number value according to Java's rounding rules.

### Return types

- `Math.round(float)` returns `int`.
- `Math.round(double)` returns `long`.

### Examples

```java
Math.round(6.2);  // 6L
Math.round(6.7);  // 7L
Math.round(4.5);  // 5L
```

For a `double` argument, the return type is `long`, even when the result is a whole number.

### Example

```java
long result = Math.round(6.7);

System.out.println(result);
```

Output:

```text
7
```

### Negative-number behavior

Java's `Math.round()` effectively uses:

\[
\lfloor x + 0.5 \rfloor
\]

Examples:

```java
Math.round(2.5);   // 3
Math.round(-2.5);  // -2
Math.round(-2.7);  // -3
```

This is not the same as rounding every halfway value away from zero.

---

## 10. `ceil()` vs `floor()` vs `round()`

| Method | Behavior | Return type for `double` input | Example with `5.7` |
|---|---|---|---|
| `Math.ceil()` | Toward positive infinity | `double` | `6.0` |
| `Math.floor()` | Toward negative infinity | `double` | `5.0` |
| `Math.round()` | Nearest integer, using Java's rule | `long` | `6` |

Remember:

```java
Math.ceil(6.2);   // 7.0
Math.floor(6.2);  // 6.0
Math.round(6.2);  // 6
```

---

## 11. `Integer.MAX_VALUE`

### What is it?

`Integer.MAX_VALUE` is a constant representing the largest value an `int` can store.

```text
2,147,483,647
```

### Example

```java
int x = Integer.MAX_VALUE;

System.out.println(x);
```

Output:

```text
2147483647
```

### DSA use case: Finding the minimum

```java
int[] arr = {50, 20, 80};

int min = Integer.MAX_VALUE;

for (int x : arr) {
    if (x < min) {
        min = x;
    }
}

System.out.println(min);
```

Output:

```text
20
```

### Dry run

```text
Initial:
min = 2,147,483,647

50 → min = 50
20 → min = 20
80 → min = 20
```

The initial value is larger than every possible `int`, so any array element can replace it.

**Important:** If the array is empty, the loop does not run and `min` remains `Integer.MAX_VALUE`. Always consider whether an empty array is possible.

---

## 12. `Integer.MIN_VALUE`

### What is it?

`Integer.MIN_VALUE` is the smallest value an `int` can store.

```text
-2,147,483,648
```

### DSA use case: Finding the maximum

```java
int[] arr = {-100, -50, -200};

int max = Integer.MIN_VALUE;

for (int x : arr) {
    if (x > max) {
        max = x;
    }
}

System.out.println(max);
```

Output:

```text
-50
```

### Dry run

```text
Initial:
max = -2,147,483,648

-100 → max = -100
-50  → max = -50
-200 → max = -50
```

Remember:

```text
-50 > -100
-100 > -200
```

For negative numbers, the value closer to zero is greater.

---

## 13. `Long.MAX_VALUE`

### What is it?

`Long.MAX_VALUE` is the largest value a Java `long` can store.

```text
9,223,372,036,854,775,807
```

### Example

```java
long x = Long.MAX_VALUE;

System.out.println(x);
```

Output:

```text
9223372036854775807
```

### DSA use case

Use it when you need an initial large value for calculations involving `long`.

```java
long min = Long.MAX_VALUE;
```

This is useful when working with values that may exceed the `int` range.

---

## 14. Bonus: `Long.MIN_VALUE`

Although it was not originally on our checklist, it follows the same principle.

`Long.MIN_VALUE` is the smallest value a `long` can store:

```text
-9,223,372,036,854,775,808
```

For example:

```java
long max = Long.MIN_VALUE;
```

This is useful when finding the maximum of a collection of `long` values.

---

## 15. `int` vs `long` Ranges

| Constant | Value |
|---|---:|
| `Integer.MIN_VALUE` | -2,147,483,648 |
| `Integer.MAX_VALUE` | 2,147,483,647 |
| `Long.MIN_VALUE` | -9,223,372,036,854,775,808 |
| `Long.MAX_VALUE` | 9,223,372,036,854,775,807 |

A `long` has a much larger range than an `int`.

Use `long` when calculations or input values might exceed the `int` range. Remember that assigning a calculation to `long` does not prevent overflow if the calculation itself is performed using `int` operands.

---

## 16. Common DSA Patterns

### Finding a minimum

```java
int min = Integer.MAX_VALUE;

for (int x : arr) {
    if (x < min) {
        min = x;
    }
}
```

### Finding a maximum

```java
int max = Integer.MIN_VALUE;

for (int x : arr) {
    if (x > max) {
        max = x;
    }
}
```

### Finding absolute difference

```java
int difference = Math.abs(a - b);
```

Be careful: `a - b` can overflow before `Math.abs()` is applied. Use `long` arithmetic if the range requires it.

### Finding the larger value

```java
int max = Math.max(a, b);
```

### Finding the smaller value

```java
int min = Math.min(a, b);
```

---

## 17. Quick Reference

| Method / Constant | Purpose |
|---|---|
| `Math.max(a, b)` | Larger of two values |
| `Math.min(a, b)` | Smaller of two values |
| `Math.abs(x)` | Absolute value |
| `Math.sqrt(x)` | Square root |
| `Math.pow(a, b)` | Power |
| `Math.ceil(x)` | Round toward positive infinity |
| `Math.floor(x)` | Round toward negative infinity |
| `Math.round(x)` | Round to nearest integer using Java's rule |
| `Integer.MAX_VALUE` | Largest `int` |
| `Integer.MIN_VALUE` | Smallest `int` |
| `Long.MAX_VALUE` | Largest `long` |
| `Long.MIN_VALUE` | Smallest `long` |

---

## 18. Completion Checklist

- [x] `Math.max()`
- [x] `Math.min()`
- [x] `Math.abs()`
- [x] `Math.sqrt()`
- [x] `Math.pow()`
- [x] `Math.ceil()`
- [x] `Math.floor()`
- [x] `Math.round()`
- [x] `Integer.MAX_VALUE`
- [x] `Integer.MIN_VALUE`
- [x] `Long.MAX_VALUE`
- [x] `Long.MIN_VALUE` (bonus)

**Status: Java Math Utilities and Numeric Constants completed.**

### Next topic in the roadmap

**Remaining Bitwise Operators**

- [ ] Bitwise NOT: `~`
- [ ] Left shift: `<<`
- [ ] Signed right shift: `>>`
- [ ] Unsigned right shift: `>>>`

We will start that topic only after the next topic-transition checklist and your confirmation.
