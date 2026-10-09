# Operators in Java

Operators perform calculations, comparisons, and logical operations.

## 1. Arithmetic Operators

| Operator | Meaning | Example |
|---|---|---|
| `+` | Addition | `10 + 5 = 15` |
| `-` | Subtraction | `10 - 5 = 5` |
| `*` | Multiplication | `10 * 5 = 50` |
| `/` | Division | `17 / 5 = 3` |
| `%` | Remainder | `17 % 5 = 2` |

Example:

```java
int a = 17;
int b = 5;

int division = a / b;       // 3
int remainder = a % b;      // 2
```

For integer operands, division discards the fractional part.

### The remainder operator

The `%` operator returns the remainder after division.

```java
10 % 3;  // 1
10 % 2;  // 0
15 % 4;  // 3
20 % 5;  // 0
```

A common DSA use case is checking whether a number is even:

```java
int number = 10;
boolean isEven = number % 2 == 0;
```

Result: `true`.

## 2. Comparison Operators

Comparison operators return a boolean value.

| Operator | Meaning | Example |
|---|---|---|
| `==` | Equal to | `10 == 10` → `true` |
| `!=` | Not equal to | `10 != 20` → `true` |
| `>` | Greater than | `10 > 5` → `true` |
| `<` | Less than | `10 < 5` → `false` |
| `>=` | Greater than or equal | `10 >= 10` → `true` |
| `<=` | Less than or equal | `10 <= 10` → `true` |

### Assignment versus comparison

```java
int a = 10;  // Assignment
boolean b = a == 10;  // Comparison
```

- `=` assigns a value.
- `==` compares values for primitive types.

## 3. Logical Operators

Logical operators combine or reverse boolean expressions.

### AND (`&&`)

Both conditions must be true.

| A | B | A && B |
|---|---|---|
| `true` | `true` | `true` |
| `true` | `false` | `false` |
| `false` | `true` | `false` |
| `false` | `false` | `false` |

Example:

```java
int age = 25;

boolean result = age >= 18 && age <= 60;
```

Result: `true`.

### OR (`||`)

At least one condition must be true.

| A | B | A \|\| B |
|---|---|---|
| `true` | `true` | `true` |
| `true` | `false` | `true` |
| `false` | `true` | `true` |
| `false` | `false` | `false` |

Example:

```java
int age = 16;

boolean result = age >= 18 || age == 16;
```

Result: `true`.

### NOT (`!`)

Reverses a boolean value.

```java
!true;   // false
!false;  // true
```

Example:

```java
boolean isLoggedIn = true;
boolean result = !isLoggedIn;
```

Result: `false`.

## 4. Increment and Decrement

### Increment (`++`)

Increases a variable by one.

```java
int x = 10;
x++;
```

Now `x = 11`.

### Decrement (`--`)

Decreases a variable by one.

```java
int x = 10;
x--;
```

Now `x = 9`.

These operators are frequently used in loops.

## 5. Important Rules

- Integer division can discard the fractional part.
- `%` returns the remainder.
- Comparison expressions produce boolean values.
- `&&` requires both conditions to be true.
- `||` requires at least one condition to be true.
- `!` reverses a boolean.
- `++` increments by one; `--` decrements by one.
- `&&` and `||` use short-circuit evaluation.

## 6. Practice Questions

1. Calculate `17 / 5` and `17 % 5`.
2. What is the result of `10 < 20 && 20 < 30`?
3. What is the result of `10 > 20 || 20 == 20`?
4. What is the value of `!false`?
5. If `x = 10`, what is the final value after `x++; x++; x--;`?

## Summary

Arithmetic operators perform calculations, comparison operators evaluate relationships, and logical operators combine conditions. These are the building blocks of conditions, loops, and DSA algorithms.