# 04. Conditionals in Java

## 1. What Are Conditionals?

Conditionals allow a program to make decisions based on whether a condition is `true` or `false`.

For example, a program can check whether a person is an adult based on their age.

```java
int age = 20;

if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

**Output:**
```text
Adult
```

## 2. The `if` Statement

The `if` statement executes a block of code only when its condition is `true`.

### Syntax

```java
if (condition) {
    // Code executes when condition is true
}
```

### Example

```java
int number = 10;

if (number > 0) {
    System.out.println("Positive number");
}
```

**Output:**
```text
Positive number
```

If the condition is `false`, the code inside the `if` block is skipped.

## 3. The `if-else` Statement

The `if-else` statement provides two possible paths.

- `if`: Executes when the condition is `true`.
- `else`: Executes when the condition is `false`.

### Example

```java
int number = 7;

if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

**Output:**
```text
Odd
```

The `%` operator returns the remainder after division. A number is even when `number % 2 == 0`.

## 4. The `else-if` Ladder

Use `else if` when you need to check multiple conditions.

### Example

```java
int marks = 75;

if (marks >= 90) {
    System.out.println("Grade A");
} else if (marks >= 75) {
    System.out.println("Grade B");
} else if (marks >= 60) {
    System.out.println("Grade C");
} else {
    System.out.println("Grade D");
}
```

**Output:**
```text
Grade B
```

Java evaluates conditions from top to bottom. Once a condition is `true`, its block executes and the remaining branches are skipped.

**Important:** Order conditions carefully. More restrictive conditions often need to appear first.

## 5. Nested `if` Statements

A nested `if` is an `if` statement inside another `if` statement.

### Example

```java
int age = 25;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("Can drive");
    }
}
```

**Output:**
```text
Can drive
```

The inner condition is checked only when the outer condition is `true`.

## 6. The `switch` Statement

Use `switch` when you need to select a branch based on a value.

### Example

```java
int day = 2;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

**Output:**
```text
Tuesday
```

- `case`: Defines a possible matching value.
- `break`: Exits the switch statement.
- `default`: Executes when no case matches.

Without `break` in a traditional switch statement, execution can continue into subsequent cases. Modern Java also supports switch expressions and arrow-style cases, which can be learned later.

## 7. Comparison Operators

Comparison operators compare values and produce a boolean result: `true` or `false`.

| Operator | Meaning | Example | Result |
|---|---|---|---|
| `==` | Equal to | `10 == 10` | `true` |
| `!=` | Not equal to | `10 != 5` | `true` |
| `>` | Greater than | `10 > 5` | `true` |
| `<` | Less than | `10 < 5` | `false` |
| `>=` | Greater than or equal to | `10 >= 10` | `true` |
| `<=` | Less than or equal to | `5 <= 10` | `true` |

**Remember:**

- `=` assigns a value.
- `==` compares values.

```java
int a = 10;       // Assignment
boolean result = a == 10; // Comparison
```

## 8. Logical Operators

Logical operators combine or reverse boolean conditions.

| Operator | Meaning | Example |
|---|---|---|
| `&&` | AND: both conditions must be true | `age >= 18 && age <= 60` |
| `||` | OR: at least one condition must be true | `isAdmin || isOwner` |
| `!` | NOT: reverses a boolean | `!isLoggedIn` |

### Example

```java
int age = 25;
boolean hasLicense = true;

if (age >= 18 && hasLicense) {
    System.out.println("Eligible to drive");
}
```

**Output:**
```text
Eligible to drive
```

Java's `&&` and `||` use short-circuit evaluation: the second operand may not be evaluated if the first operand already determines the result.

## 9. The Ternary Operator

The ternary operator is a concise alternative to a simple `if-else` expression.

### Syntax

```java
condition ? valueIfTrue : valueIfFalse;
```

### Example

```java
int number = 10;

String result = (number % 2 == 0) ? "Even" : "Odd";

System.out.println(result);
```

**Output:**
```text
Even
```

Use the ternary operator for simple choices. Prefer `if-else` when the logic becomes complex.

## 10. Common Mistakes

### Mistake 1: Using `=` instead of `==`

```java
if (number = 10) { // Invalid Java
}
```

Correct:

```java
if (number == 10) {
}
```

### Mistake 2: Incorrect condition ordering

```java
int marks = 95;

if (marks >= 60) {
    System.out.println("Grade C");
} else if (marks >= 90) {
    System.out.println("Grade A");
}
```

This prints `Grade C`, because the first condition already matches.

Put the higher threshold first when assigning descending grades.

### Mistake 3: Forgetting braces

Braces are recommended even when a block contains only one statement. They improve readability and help prevent accidental logic errors.

## 11. DSA Applications

Conditionals are used throughout Data Structures and Algorithms:

- Checking whether a number is even or odd.
- Finding the maximum or minimum element in an array.
- Checking whether an element matches a target.
- Handling empty or invalid input.
- Implementing binary search decisions.
- Controlling recursive base cases.
- Comparing values while sorting.

### Example: Finding the maximum of two numbers

```java
int a = 15;
int b = 25;

if (a > b) {
    System.out.println(a);
} else {
    System.out.println(b);
}
```

**Output:**
```text
25
```

## 12. Practice Questions

1. Write a program to check whether a number is positive, negative, or zero.
2. Write a program to check whether a number is even or odd.
3. Find the largest of three numbers.
4. Check whether a person is eligible to vote.
5. Assign a grade based on marks using an `else-if` ladder.
6. Use `switch` to print the name of a weekday based on a number from 1 to 7.
7. Check whether a number is divisible by both 3 and 5.
8. Find the absolute difference between two integers using conditionals.

## Summary

- `if` executes code when a condition is true.
- `if-else` selects between two paths.
- `else-if` checks multiple conditions in order.
- Nested `if` statements handle dependent decisions.
- `switch` selects a branch based on a value.
- Comparison operators produce boolean results.
- Logical operators combine conditions.
- The ternary operator expresses simple conditional choices.

**Next topic:** Loops in Java — `for`, `while`, `do-while`, `break`, and `continue`.
