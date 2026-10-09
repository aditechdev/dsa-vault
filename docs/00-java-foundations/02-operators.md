# Operators in Java
Operators perform calculations, compare values, combine conditions, and update variables. This document covers Java operators needed for beginner-level DSA.

## 1. Arithmetic Operators
| Operator | Meaning | Example |
|---|---|---|
| `+` | Addition | `10 + 5 = 15` |
| `-` | Subtraction | `10 - 5 = 5` |
| `*` | Multiplication | `10 * 5 = 50` |
| `/` | Division | `17 / 5 = 3` |
| `%` | Remainder | `17 % 5 = 2` |

```java

int a = 17;

int b = 5;

int division = a / b;   // 3

int remainder = a % b;  // 2

```

For integer operands, division discards the fractional part.

For example:

```java

System.out.println(7 / 2); // 3

System.out.println(7.0 / 2); // 3.5

```

### The remainder operator
The `%` operator returns the remainder after division.

```java

10 % 3; // 1

10 % 2; // 0

15 % 4; // 3

20 % 5; // 0

```

A common DSA use case is checking whether a number is even:

```java

int number = 10;

boolean isEven = number % 2 == 0; // true

```

## 2. Comparison Operators
Comparison operators return a boolean value: `true` or `false`.

| Operator | Meaning | Example |
|---|---|---|
| `==` | Equal to | `10 == 10` → `true` |
| `!=` | Not equal to | `10 != 20` → `true` |
| `>` | Greater than | `10 > 5` → `true` |
| `<` | Less than | `10 < 5` → `false` |
| `>=` | Greater than or equal to | `10 >= 10` → `true` |
| `<=` | Less than or equal to | `10 <= 10` → `true` |

### Assignment versus comparison
```java

int a = 10;               // Assignment

boolean result = a == 10; // Comparison

```

\- `=` assigns a value.

\- `==` compares values.

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

```java

int age = 25;

boolean result = age >= 18 && age <= 60; // true

```

### OR (`||`)
At least one condition must be true.

| A | B | A \|\| B |
|---|---|---|
| `true` | `true` | `true` |
| `true` | `false` | `true` |
| `false` | `true` | `true` |
| `false` | `false` | `false` |

```java

int age = 16;

boolean result = age >= 18 || age == 16; // true

```

### NOT (`!`)
Reverses a boolean value.

```java

!true;  // false

!false; // true

boolean isLoggedIn = true;

boolean result = !isLoggedIn; // false

```

## 4. Assignment Operators
Compound assignment operators update a variable using its current value.

| Operator | Equivalent form |
|---|---|
| `=` | Assign a value |
| `+=` | `x = x + value` |
| `-=` | `x = x - value` |
| `*=` | `x = x * value` |
| `/=` | `x = x / value` |
| `%=` | `x = x % value` |

Example:

```java

int x = 20;

x += 5; // 25

x -= 8; // 17

x *= 2; // 34

x /= 3; // 11

x %= 4; // 3

```

Dry run:

```text

Initial: 20

x += 5  → 25

x -= 8  → 17

x *= 2  → 34

x /= 3  → 11

x %= 4  → 3

```

Each statement updates `x`. The next statement uses the updated value.

Remember that integer division still applies: `34 / 3` gives `11`.

## 5. Unary Operators
A unary operator operates on one operand.

Examples include:

\- `++`  increment by one.

\- `--`  decrement by one.

\- `!`  reverse a boolean.

\- `~`  flip every bit of an integer.

### Increment (`++`)
```java

int x = 10;

x++;

```

Now `x = 11`.

### Decrement (`--`)
```java

int x = 10;

x--;

```

Now `x = 9`.

These operators are frequently used in loops.

### Prefix versus postfix
Prefix changes the variable before its value is used in the expression. Postfix uses the current value first, then changes the variable.

**Prefix example:****

```java

int x = 5;

int y = ++x;

```

Execution:

```text

Initial: x = 5

++x:     x becomes 6

y = x:   y becomes 6

```

Final values:

```text

x = 6

y = 6

```

**Postfix example:****

```java

int x = 5;

int y = x++;

```

Execution:

```text

Initial: x = 5

y = x:   y gets 5

x++:     x becomes 6

```

Final values:

```text

x = 6

y = 5

```

| Expression | Order | Result when `x = 5` |
|---|---|---|
| `++x` | Increment, then use | Expression value is `6` |
| `x++` | Use, then increment | Expression value is `5` |
| `--x` | Decrement, then use | Expression value is `4` |
| `x--` | Use, then decrement | Expression value is `5` |

When increment or decrement is used alone as a statement, both forms update the variable by one. The distinction matters when the expression's value is used.

## 6. Ternary Operator (`?:`)
The ternary operator is a compact expression that chooses one of two values based on a condition.

Syntax:

```java

condition ? valueIfTrue : valueIfFalse

```

Example:

```java

int a = 10;

int b = 20;

int max = (a > b) ? a : b;

```

The condition `a > b` is false, so the value after `:` is selected.

```text

a = 10

b = 20

max = 20

```

Equivalent `if-else`:

```java

int max;

if (a > b) {

    max = a;

} else {

    max = b;

}

```

Use ternary expressions for simple choices. Prefer `if-else` when the logic becomes difficult to read.

## 7. Operator Precedence and Associativity
**Precedence**** determines which operators are grouped first.

**Associativity**** determines how operators of the same precedence are grouped.

A useful beginner-level precedence guide:

1. Parentheses: `()`

2. Multiplication, division, remainder: `*`, `/`, `%`

3. Addition, subtraction: `+`, `-`

4. Relational operators: `<`, `<=`, `>`, `>=`

5. Equality operators: `==`, `!=`

6. Logical AND: `&&`

7. Logical OR: `||`

8. Ternary conditional: `?:`

9. Assignment: `=`, `+=`, `-=`, and related operators

This is a simplified guide, not the complete Java precedence table.

### Example 1: Multiplication before addition
```java

int result = 10 + 5 * 2;

```

Execution:

```text

5 * 2 = 10

10 + 10 = 20

```

Result: `20`.

### Example 2: Parentheses change grouping
```java

int result = (10 + 5) * 2;

```

Execution:

```text

10 + 5 = 15

15 * 2 = 30

```

Result: `30`.

### Example 3: Associativity
Multiplication and division have equal precedence and group from left to right.

```java

int result = 20 / 5 * 2;

```

Execution:

```text

20 / 5 = 4

4 * 2 = 8

```

Result: `8`.

Another example:

```java

int result = 10 + 20 / 5 * 2;

```

Execution:

```text

20 / 5 = 4

4 * 2 = 8

10 + 8 = 18

```

Result: `18`.

**Tip:**** Use parentheses to make expressions easier to understand, even when Java's precedence rules already determine the result.

## 8. Short-Circuit Evaluation
Java evaluates `&&` and `||` from left to right and may skip the right operand when the result is already determined.

### Short-circuit with AND (`&&`)
If the left condition is false, Java does not evaluate the right condition.

```java

int x = 10;

if (x < 5 && x / 0 > 1) {

    System.out.println("Yes");

}

```

Execution:

```text

x < 5

10 < 5

false

```

The entire AND expression must be false. Java skips `x / 0`, so no division-by-zero exception occurs.

### Short-circuit with OR (`||`)
If the left condition is true, Java does not evaluate the right condition.

```java

int x = 10;

if (x > 5 || x / 0 > 1) {

    System.out.println("Yes");

}

```

Execution:

```text

x > 5

10 > 5

true

```

The entire OR expression must be true. Java skips `x / 0` and prints `Yes`.

### What is division by zero?
Integer division by zero throws an `ArithmeticException`.

```java

int x = 10;

int y = x / 0; // ArithmeticException

```

The exception occurs only if Java actually evaluates the division.

### Important DSA example: Safe array access
```java

int[] arr = {10, 20, 30, 40, 50};

int i = 5;

if (i < arr.length && arr[i] == 10) {

    System.out.println("Yes");

}

```

Here:

```text

arr.length = 5

i = 5

i < arr.length

5 < 5

false

```

Java skips `arr[i]`, so it does not access the invalid index `5`. The condition is false and nothing is printed.

Valid indices for this array are `0` through `4`.

If we replace `&&` with `||`:

```java

if (i < arr.length || arr[i] == 10) {

    System.out.println("Yes");

}

```

The left side is false, so Java evaluates `arr[5]` and throws an `ArrayIndexOutOfBoundsException`.

Remember:

\- `&&`: left false → stop.

\- `||`: left true → stop.

## 9. Bitwise Operators
Bitwise operators work on individual bits of integer values. They are useful for bit-manipulation problems in DSA, but are not prerequisites for basic array and string problems.

### Binary representation
Binary uses only two digits: `0` and `1`.

Each position represents a power of two.

For four-bit binary:

```text

Position value:  8 4 2 1

0 = 0000

1 = 0001

2 = 0010

3 = 0011

4 = 0100

5 = 0101

6 = 0110

7 = 0111

```

For example:

```text

5 = 0101

0 × 8 + 1 × 4 + 0 × 2 + 1 × 1

= 5

```

Leading zeros do not change a number:

```text

101

0101

00000101

```

All represent decimal `5`.

These four-bit examples are for learning. Java's `int` uses 32 bits.

### Bitwise AND (`&`)
A result bit is `1` only when both input bits are `1`.

| A | B | A & B |
|---|---|---|
| `0` | `0` | `0` |
| `0` | `1` | `0` |
| `1` | `0` | `0` |
| `1` | `1` | `1` |

Example:

```text

  0110  (6)

& 0011  (3)

\------

  0010  (2)

```

Therefore:

```java

int result = 6 & 3; // 2

```

Do not confuse `&` with `&&`.

\- `&&` is logical AND for boolean expressions and short-circuits.

\- `&` performs bitwise AND on integers. Java also allows `&` on booleans, where both operands are evaluated.

### Bitwise OR (`|`)
A result bit is `1` when at least one input bit is `1`.

| A | B | A \| B |
|---|---|---|
| `0` | `0` | `0` |
| `0` | `1` | `1` |
| `1` | `0` | `1` |
| `1` | `1` | `1` |

Example:

```text

  0110  (6)

| 0011  (3)

\------

  0111  (7)

```

Therefore:

```java

int result = 6 | 3; // 7

```

### Bitwise XOR (`^`)
XOR means exclusive OR.

A result bit is `1` when the input bits are different, and `0` when they are the same.

| A | B | A ^ B |
|---|---|---|
| `0` | `0` | `0` |
| `0` | `1` | `1` |
| `1` | `0` | `1` |
| `1` | `1` | `0` |

Example:

```text

  0101  (5)

^ 0011  (3)

\------

  0110  (6)

```

Therefore:

```java

int result = 5 ^ 3; // 6

```

Useful XOR identities:

```text

a ^ a = 0

a ^ 0 = a

```

For example:

```text

  0101  (5)

^ 0101  (5)

\------

  0000  (0)

```

Therefore, `5 ^ 5 = 0`.

XOR is used in some DSA problems involving numbers that occur in pairs.

### Bitwise NOT (`~`)
The bitwise NOT operator flips every bit:

```text

0 → 1

1 → 0

```

However, Java's `int` is a 32-bit signed integer. Flipping all 32 bits can produce a negative value.

```java

int x = 5;

System.out.println(~x); // -6

```

The result follows Java's two's-complement representation. We will study the binary details later when learning bit manipulation.

### Shift operators
Java provides three shift operators:

| Operator | Meaning |
|---|---|
| `<<` | Left shift |
| `>>` | Signed right shift |
| `>>>` | Unsigned right shift |

\- `<<` shifts bits to the left.

\- `>>` shifts bits to the right while preserving the sign bit.

\- `>>>` shifts bits to the right and fills the newly opened positions with zeros.

These operators deserve a separate lesson, particularly for negative values. Do not assume that shifts are always interchangeable with multiplication or division.

## 10. DSA Priority
### Learn and practise now
\- Arithmetic operators

\- Comparison operators

\- Logical operators

\- Assignment operators

\- Prefix and postfix increment/decrement

\- Ternary operator

\- Operator precedence and associativity

\- Short-circuit evaluation

### Understand the basics; practise more later
\- Bitwise AND (`&`)

\- Bitwise OR (`|`)

\- Bitwise XOR (`^`)

### Defer detailed study until bit-manipulation problems
\- Bitwise NOT (`~`) and two's complement

\- Left shift (`<<`)

\- Signed right shift (`>>`)

\- Unsigned right shift (`>>>`)

## 11. Practice Questions
Trace each statement in order. Do not guess the final value without tracking intermediate values.

1. Calculate `17 / 5` and `17 % 5`.

2. What is the result of `10 < 20 && 20 < 30`?

3. What is the result of `10 > 20 || 20 == 20`?

4. What is the value of `!false`?

5. If `x = 10`, what is the final value after `x++; x++; x--;`?

6. Find the final values of `x`, `a`, and `b`:

   ```java

   int x = 10;

   int a = ++x;

   int b = x++;

   ```

7. What is the value of `10 + 20 / 5 * 2`? Explain precedence and associativity.

8. Why does `i < arr.length && arr[i] == 10` avoid accessing `arr[i]` when `i == arr.length`?

9. Calculate `6 & 3`, `6 | 3`, and `5 ^ 3`.

10. What is `5 ^ 5`, and why?

11. What does `~` do to the bits of an integer?

12. What is the difference between `<<`, `>>`, and `>>>`?

## Summary
Arithmetic operators calculate values. Comparison operators return booleans. Logical operators combine conditions. Assignment operators update variables. Prefix and postfix operators differ when their expression values are used. The ternary operator selects a value. Precedence and associativity determine expression grouping. Short-circuit evaluation can skip the right operand. Bitwise operators manipulate individual bits and are useful for later DSA problems.


---

## 12. Progress Update — Covered in This Chat

### Bitwise concepts practised

- **Binary representation:** binary uses `0` and `1`; in a four-bit example, the place values are `8, 4, 2, 1`.
- **Bitwise AND (`&`):** a result bit is `1` only when both input bits are `1`. Example: `6 & 3 = 2`.
- **Bitwise OR (`|`):** a result bit is `1` when at least one input bit is `1`. Example: `6 | 3 = 7`.
- **Bitwise XOR (`^`):** a result bit is `1` when the input bits differ. Example: `5 ^ 3 = 6`.
- **XOR identities:** `a ^ a = 0` and `a ^ 0 = a`.
- **Bitwise NOT (`~`):** flips every bit. Because Java `int` is a 32-bit signed integer using two's-complement representation, `~n` evaluates to `-(n + 1)`. Examples: `~3 == -4` and `~5 == -6`.

### Shift operators — introduced, then deferred

| Operator | Meaning | Status |
|---|---|---|
| `<<` | Left shift | Introduced; detailed practice deferred |
| `>>` | Signed right shift | Introduced; detailed practice deferred |
| `>>>` | Unsigned right shift | Identified; detailed practice deferred |

Examples discussed:

```java
3 << 1  // 6
3 << 2  // 12
5 << 1  // 10
20 >> 2 // 5
```

**Important:** These examples establish the basic direction of shifting, not mastery of all shift behavior. Negative values and the difference between `>>` and `>>>` are still pending. We agreed not to spend more time on shifts before continuing with the next learning area; return to them during bit manipulation.

### Current learning status

- **Practised:** arithmetic, comparison, logical, assignment, unary, prefix/postfix, ternary, precedence/associativity, short-circuit evaluation, binary representation, `&`, `|`, `^`, and the basic behavior of `~`.
- **Deferred:** detailed shift operators (`<<`, `>>`, `>>>`) and the deeper two's-complement explanation.
- **DSA relevance:** bitwise operators are useful for later bit-manipulation problems, but detailed bit manipulation is not a prerequisite for starting ordinary array and string problems.

### Suggested next step

Continue with Java Collections, beginning with `ArrayList`, then `HashMap`, `HashSet`, `Queue`, `Deque`, `Stack`, and `PriorityQueue`. Return to shift operators when studying bit manipulation.
