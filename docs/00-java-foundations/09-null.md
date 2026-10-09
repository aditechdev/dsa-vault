# Java `null`

## 1. What Is `null`?

In Java, `null` represents the absence of an object reference.

A reference variable can refer to an object or contain `null`, meaning it does not currently refer to any object.

```java
String name = "Java";
String value = null;
```

Conceptually:

```text
name  ─────→ "Java" String object
value ─────→ null (no object referenced)
```

**Important:** `null` is not zero, an empty String, or `false`.

```java
int x = 0;              // Number zero
String s = "";          // Empty String
boolean flag = false;   // Boolean false
String name = null;     // No object referenced
```

## 2. Primitive Types vs. Reference Types

Primitive variables cannot hold `null`.

```java
int x = null;       // Compilation error
double d = null;    // Compilation error
boolean b = null;   // Compilation error
char c = null;      // Compilation error
```

Reference variables can hold `null`.

```java
String s = null;       // Valid
int[] arr = null;      // Valid
```

Examples of reference types include:

- `String`
- Arrays
- Objects created from classes
- Collections such as `ArrayList` and `HashMap`

## 3. Printing a Null Reference

Printing a null reference is allowed.

```java
String s = null;

System.out.println(s);
```

Output:

```text
null
```

`println()` can print the text representation of a null reference without accessing an object.

## 4. NullPointerException (NPE)

A `NullPointerException` occurs when code attempts an operation that requires an object through a null reference.

Example:

```java
String s = null;

System.out.println(s.length());
```

This throws a `NullPointerException` because `s` does not refer to a String object.

Another example:

```java
int[] arr = null;

System.out.println(arr.length);
```

This also throws a `NullPointerException`.

### Remember

```text
Print a null reference       → Allowed
Call a method through null  → NullPointerException
Access an array through null → NullPointerException
```

The exact operation matters: not every expression involving `null` throws an exception.

## 5. Checking for `null`

Use `== null` to check whether a reference is null.

```java
String s = null;

if (s == null) {
    System.out.println("No value");
}
```

Output:

```text
No value
```

The comparison itself is safe.

Use `!= null` to check whether a reference is not null.

```java
String s = null;

if (s != null) {
    System.out.println(s.length());
}
```

Output:

```text
```

Nothing is printed because the condition is false, so the `if` block is skipped.

This also prevents the call to `length()` on a null reference.

### Safe access pattern

```java
if (s != null) {
    System.out.println(s.length());
}
```

The method is called only when `s` is not null.

## 6. `null` vs. Empty String

These values are different:

```java
String a = null;
String b = "";
String c = "Java";
```

| Value | Meaning |
|---|---|
| `null` | No String object is referenced |
| `""` | An empty String containing zero characters |
| `"Java"` | A String containing four characters |

For example:

```java
String s = "";

System.out.println(s.length());
```

Output:

```text
0
```

An empty String is still a valid object, so calling `length()` is safe.

However:

```java
String s = null;

System.out.println(s.length());
```

throws a `NullPointerException`.

## 7. Why `null` Matters in DSA

`null` is especially important when working with reference-based data structures.

### Linked Lists

A `next` reference may be null when a node has no successor.

```java
class Node {
    int value;
    Node next;
}
```

A newly created node has `next == null` unless another reference is assigned.

### Trees

A tree node may have no left or right child.

```java
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
}
```

Initially, `left` and `right` are null.

### Collections and Maps

Reference variables and some collection operations can involve null values. Whether null is permitted depends on the particular collection implementation and operation.

### General DSA pattern

```java
if (node == null) {
    return;
}
```

This checks whether a node reference is absent before attempting to use it.

## 8. Default Values and `null`

Instance fields and array elements receive default values when they are not explicitly initialized.

| Type | Default value |
|---|---|
| `int` | `0` |
| `long` | `0L` |
| `double` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Reference types | `null` |

Example:

```java
class Student {
    String name;
    int age;
}
```

After:

```java
Student s = new Student();
```

the initial field values are:

```text
s.name = null
s.age  = 0
```

**Important:** Local variables do not automatically receive these default values. A local variable must be initialized before it can be read.

## 9. Common Mistakes

### Mistake 1: Treating `null` as zero

```java
int x = null; // Compilation error
```

### Mistake 2: Calling a method on a null reference

```java
String s = null;
s.length(); // NullPointerException
```

### Mistake 3: Confusing `null` with an empty String

```java
String a = null;
String b = "";
```

These represent different states.

### Mistake 4: Checking the contents instead of the reference

```java
if (s == null) {
    // Reference is null
}
```

This is different from checking whether a String is empty:

```java
if (s != null && s.isEmpty()) {
    // String exists but contains no characters
}
```

The `&&` operator short-circuits, so `s.isEmpty()` is evaluated only when `s != null` is true.

## 10. Quick Revision

- `null` means a reference does not refer to an object.
- Primitive variables cannot contain `null`.
- Reference variables can contain `null`.
- Printing `null` is allowed.
- Calling a method through a null reference can cause `NullPointerException`.
- Use `== null` and `!= null` to check a reference.
- `null` and `""` are different.
- Reference fields default to `null`.
- Null checks are important for linked lists, trees, and other DSA structures.

## 11. Practice Questions

Try answering these without running the code.

### Question 1

```java
String s = null;
System.out.println(s);
```

What is printed?

### Question 2

```java
String s = null;
System.out.println(s.length());
```

What happens?

### Question 3

```java
String s = null;

if (s != null) {
    System.out.println("Hello");
}
```

What is printed?

### Question 4

```java
String s = "";
System.out.println(s.length());
```

What is printed?

### Question 5

```java
class Student {
    String name;
    int age;
}

Student s = new Student();
```

What are the initial values of `s.name` and `s.age`?
