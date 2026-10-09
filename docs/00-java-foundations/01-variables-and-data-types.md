# Java Foundations — Variables and Data Types


## 1. What Is a Variable?

A variable is a named storage location used by a program to hold a value.

```java
int age = 25;
```

- `int` is the declared data type.
- `age` is the variable name.
- `=` assigns the value on the right to the variable on the left.
- `25` is the initial value.

## 2. Declaration, Initialization, and Assignment

```java
int age;       // declaration
age = 25;      // assignment
int score = 90; // declaration and initialization
```

A local variable must be assigned a value before it is read.

## 3. Assignment Copies a Primitive Value

```java
int a = 10;
int b = 20;

b = a; // b becomes 10
a = 50; // a becomes 50; b remains 10
```

For primitive variables, assignment copies the current value. The variables are not permanently linked.

## 4. `int`

Use `int` for whole-number values within its range. Java `int` is a signed 32-bit integer with the range -2,147,483,648 through 2,147,483,647.

```java
int count = 10;
int temperature = -5;
int total = count + 20;
```

Integer arithmetic can overflow if the mathematical result is outside that range.

## 5. `long`

Use `long` when whole-number values may exceed the `int` range. An integer literal intended as a `long` commonly uses the `L` suffix.

```java
long population = 14_000_000_000L;
```

**Important:** assigning an `int` expression to a `long` does not retroactively widen the expression calculation.

```java
int a = 100_000;
int b = 100_000;

// Multiplication happens as int arithmetic first and can overflow.
long wrong = a * b;

// Cast before multiplication so the multiplication is long arithmetic.
long correct = (long) a * b;
```

## 6. Integer Division

When both operands are integer types, division discards the fractional part.

```java
int a = 5;
int b = 2;

double x = a / b;           // 2.0: division is evaluated as int division
double y = (double) a / b;  // 2.5: division is floating-point
```

**Rule:** expression evaluation happens before assignment to the destination variable.

## 7. Practice Questions

Try these without running the code first.

### Question 1

```java
int a = 10;
int b = 20;
int c = a;
a = 50;
b = a;
```

What are the final values of `a`, `b`, and `c`?

### Question 2

```java
int a = 5;
int b = 2;
double result = a / b;
```

What does `result` contain, and why?

### Question 3

What is the difference between declaration and initialization?

```java
int count;
int total = 0;
```

## Key Takeaways

- Assignment updates the variable on the left.
- Assigning one primitive variable to another copies its current value.
- `int` and `long` are integer types with different ranges.
- Operand types determine arithmetic behavior.
- Integer division discards the fractional part.
- Cast an operand before an operation when you need the operation evaluated using a wider or floating-point type.

## Next

Continue with `double`, then `char`, `boolean`, and `String`. Add new material only after it has been covered in the lesson.
