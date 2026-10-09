# Java Foundations — Variables and Data Types

## 1. What Is a Variable?

A variable is a named storage location used by a program to hold a value.

```
int age = 25;
```

- `int` — data type
- `age` — variable name
- `=` — assignment operator
- `25` — initial value

Think of a variable as a named box that stores a value.

## 2. Declaration, Initialization, and Assignment

### Declaration

Declaring a variable means specifying its data type and name.

```
int age;
```

### Initialization

Initialization means giving a variable its initial value.

```
int age = 25;
```

This statement combines declaration and initialization.

### Assignment

Assignment places a value into an existing variable.

```
int age = 25;
age = 26;
```

The final value of `age` is `26`.

A local variable must be assigned a value before it can be read.

## 3. Assigning Values Between Variables

Consider:

```
int a = 10;
int b = 20;

a = b;
b = 50;
```

Dry run:

| Statement | `a` | `b` |
| --- | --- | --- |
| `int a = 10;` | 10 | — |
| `int b = 20;` | 10 | 20 |
| `a = b;` | 20 | 20 |
| `b = 50;` | 20 | 50 |

Final values:

```
a = 20
b = 50
```

For primitive variables, assignment copies the current value. The two variables do not remain connected.

## 4. Java Basic Data Types

### `int` — Whole Numbers

Use `int` for integer values within its range.

```
int age = 25;
int temperature = -5;
int count = 0;
```

A Java `int` is a signed 32-bit integer. Its range is:

```
-2,147,483,648 to 2,147,483,647
```

Integer arithmetic can overflow when the result exceeds this range.

### `long` — Larger Whole Numbers

Use `long` when a whole number may exceed the `int` range.

```
long population = 1_400_000_000L;
long amount = 10_000_000_000L;
```

The suffix `L` marks a long integer literal.

Underscores in numeric literals improve readability:

```
long population = 1_400_000_000L;
```

This has the same value as:

```
long population = 1400000000L;
```

The underscore is a visual separator, not part of the numeric value.

A `long` is a signed 64-bit integer.

### `double` — Decimal Numbers

Use `double` for floating-point numbers.

```
double price = 99.99;
double average = 85.5;
```

#### Integer Division vs. Decimal Division

```
double a = 10 / 4;
double b = 10.0 / 4;
```

Values:

```
a = 2.0
b = 2.5
```

Why?

- `10 / 4` performs integer division first, producing `2`. The result is then stored as `2.0`.
- `10.0 / 4` performs floating-point division, producing `2.5`.

**Rule:** The operand types determine how an expression is evaluated before its result is assigned.

For financial calculations requiring exact decimal values, `double` may be inappropriate because it uses binary floating-point representation. Java's `BigDecimal` is often more suitable.

### `char` — One Character

Use `char` to store one UTF-16 code unit.

```
char grade = 'A';
char digit = '5';
char symbol = '#';
```

A `char` literal uses single quotes.

```
char letter = 'A'; // Valid
char digit = '5';  // Valid
```

These are not equivalent:

```
'A'  — char
'A'  — character value
5    — int
```

A `char` stores a numeric UTF-16 code unit internally. Not every Unicode character fits into a single `char`; some require a surrogate pair.

### `boolean` — True or False

Use `boolean` for logical values.

```
boolean isLoggedIn = true;
boolean isCompleted = false;
```

Java `boolean` values can only be `true` or `false`.

Example:

```
int number = 10;
boolean isEven = (number % 2 == 0);
```

The expression evaluates to `true`.

Comparison examples:

```
int a = 10;
int b = 20;

boolean result1 = a < b;  // true
boolean result2 = a > b;  // false
boolean result3 = a == b; // false
```

### `String` — Text

`String` is a class, not a primitive data type. It stores text.

```
String name = "Aditya";
String language = "Java";
```

A string literal uses double quotes.

```
String a = "A";
char b = 'A';
```

Both are valid, but their types are different.

#### String Length

```
String word = "Java";

System.out.println(word.length());
```

Output:

```
4
```

#### Accessing a Character

```
String word = "Java";

System.out.println(word.charAt(0));
System.out.println(word.charAt(3));
```

Output:

```
J
a
```

String indexes start at `0`.

```
J   a   v   a
0   1   2   3
```

Accessing an index outside the valid range throws an exception.

#### Comparing Strings

Use `.equals()` to compare string contents.

```
String a = "hello";
String b = "hello";

System.out.println(a.equals(b)); // true
```

Do not rely on `==` for comparing string content. It compares references for objects.

## 5. Type Casting

Type casting converts a value from one type to another.

### Widening Conversion

A conversion to a type that can represent a wider range is often automatic.

```
int a = 10;
long b = a;
```

### Narrowing Conversion

A conversion to a type with a narrower range requires an explicit cast.

```
long a = 10L;
int b = (int) a;
```

Narrowing can lose information if the value is outside the destination type's range.

### Cast Before Arithmetic When Necessary

```
int a = 100_000;
int b = 100_000;

long wrong = a * b;
long correct = (long) a * b;
```

`wrong` may overflow because `a * b` is calculated as `int` arithmetic before assignment. Casting an operand first makes the multiplication use `long` arithmetic.

## 6. Key Takeaways

- A variable has a name, a type, and a value.
- `=` assigns a value; `==` compares values.
- Assignment between primitive variables copies the current value.
- `int` and `long` store whole numbers with different ranges.
- `double` represents floating-point numbers.
- `char` stores one UTF-16 code unit.
- `boolean` represents `true` or `false`.
- `String` represents text and provides methods such as `length()`, `charAt()`, and `equals()`.
- Numeric expressions are evaluated before assignment.
- Underscores in numeric literals improve readability without changing the value.

## 7. Practice Questions

Try each question without running the code first.

### Question 1 — Assignment

```
int a = 10;
int b = 20;

a = b;
b = 50;
```

What are the final values of `a` and `b`?

### Question 2 — Copying Values

```
int a = 10;
int b = 20;

int c = a;
a = 50;
b = a;
```

What are the final values of `a`, `b`, and `c`?

### Question 3 — Integer Division

```
double a = 10 / 4;
double b = 10.0 / 4;
```

What are the values of `a` and `b`? Explain why.

### Question 4 — Data Types

Which declarations are valid?

```
int count = 10;
long population = 10_000_000_000L;
char letter = 'A';
char word = 'ABC';
boolean active = "true";
String language = "Java";
```

Identify the invalid declarations and explain why.

### Question 5 — String Indexing

```
String word = "Java";

System.out.println(word.length());
System.out.println(word.charAt(1));
System.out.println(word.charAt(3));
```

```
outputs

4
a
a
```