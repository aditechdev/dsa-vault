# Methods and Functions in Java

## 1. What Is a Method?

A **method** is a named block of code that performs a specific task. Methods help us reuse code instead of writing the same logic repeatedly.

Example:

```java
static int add(int a, int b) {
    return a + b;
}
```

Calling the method:

```java
int result = add(10, 20);
System.out.println(result); // 30
```

**Why use methods?**
- Reuse code.
- Break large problems into smaller tasks.
- Improve readability.
- Make code easier to test and maintain.

In Java, we generally call these functions *methods* because they belong to a class.

## 2. Method Syntax

```java
static int add(int a, int b) {
    return a + b;
}
```

| Component | Meaning |
|---|---|
| `static` | Allows calling the method through the class without creating an object. |
| `int` | Return type; the method returns an integer. |
| `add` | Method name. |
| `int a, int b` | Parameters. |
| `return a + b` | Sends the calculated result back to the caller. |

We will study `static` in greater depth when learning classes and objects.

## 3. Parameters vs Arguments

**Parameters** are variables declared in a method definition. **Arguments** are the actual values supplied when calling the method.

```java
static int multiply(int a, int b) {
    return a * b;
}

int result = multiply(5, 4);
```

- Parameters: `a`, `b`
- Arguments: `5`, `4`

Execution:

```text
a = 5
b = 4

a * b = 5 * 4 = 20

result = 20
```

**Remember:** Parameters are placeholders; arguments are the values passed to them.

## 4. The `return` Statement

The `return` statement sends a value back to the caller and ends that method's current execution.

```java
static int square(int number) {
    return number * number;
}

int result = square(5);
System.out.println(result); // 25
```

Execution:

```text
square(5)
    ↓
number = 5
    ↓
5 * 5 = 25
    ↓
return 25
    ↓
result = 25
```

A method's returned value can be stored in a variable, printed, or used in another calculation.

## 5. The `void` Return Type

Use `void` when a method does not return a value.

```java
static void printNumber(int x) {
    System.out.println(x);
}

printNumber(25);
```

Output:

```text
25
```

The method prints `25`, but it does not return `25` to its caller.

## 6. Printing vs Returning

Printing and returning are different operations.

### Printing

```java
static void methodA(int x) {
    System.out.println(x);
}
```

Calling `methodA(10)` displays `10`.

### Returning

```java
static int methodB(int x) {
    return x;
}
```

Calling `methodB(10)` produces the value `10`, but does not automatically display it.

```java
int result = methodB(10);
System.out.println(result); // 10
```

| Printing | Returning |
|---|---|
| Displays output. | Sends a value to the caller. |
| Uses `System.out.println()`. | Uses `return`. |
| Does not automatically provide a value to the caller. | Can be used in assignments and expressions. |

**DSA rule:** If a coding problem asks you to implement a method that returns an answer, return the answer instead of only printing it.

## 7. The `static` Keyword

A `static` method belongs to the class rather than an individual object.

```java
public class Main {

    static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(10, 20);
        System.out.println(result); // 30
    }
}
```

Because `add()` is static, it can be called directly from the static `main()` method in the same class.

For now, remember that `static` is commonly used for helper methods in beginner Java and DSA programs.

## 8. Local Variable Scope

**Scope** determines where a variable can be accessed.

```java
static int add(int a, int b) {
    int result = a + b;
    return result;
}
```

Here:
- `a` and `b` are parameters.
- `result` is a local variable.
- These variables can be accessed inside the method where they are declared, subject to their block scope.
- The local variable `result` cannot be accessed directly outside `add()`.

The following is invalid if there is no other variable named `result` in scope:

```java
System.out.println(result);
```

The returned value can still be stored in another variable:

```java
int answer = add(10, 20);
System.out.println(answer); // 30
```

## 9. Calling One Method from Another

Methods can call other methods to reuse existing logic.

```java
static int square(int x) {
    return x * x;
}

static int addSquares(int a, int b) {
    return square(a) + square(b);
}
```

Calling:

```java
int result = addSquares(3, 4);
System.out.println(result); // 25
```

Dry run:

```text
addSquares(3, 4)
    ↓
square(3) + square(4)
    ↓
9 + 16
    ↓
25
```

This approach helps divide a larger problem into smaller, understandable operations.

## 10. Methods in DSA

Methods are useful for implementing reusable algorithmic operations.

For example, finding the maximum value in an array:

```java
static int findMax(int[] arr) {
    int max = arr[0];

    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    return max;
}
```

Calling the method:

```java
int[] numbers = {10, 50, 30, 20, 40};

int result = findMax(numbers);
System.out.println(result); // 50
```

This method accepts an array and returns its maximum element.

**Precondition:** The array must contain at least one element. Empty-array handling can be added when required by the problem.

## 11. Important Rules to Remember

1. A method has a name, a body, and a declared return type.
2. Parameters are placeholders; arguments are supplied values.
3. A non-`void` method must return a compatible value on every possible path that completes normally.
4. A `void` method does not return a value to its caller.
5. Printing is not the same as returning.
6. Local variables are accessible only within their scope.
7. Methods can call other methods.
8. A `static` method can be called without creating an instance of its class.
9. Method calls can make code reusable and easier to understand.
10. In DSA, methods commonly accept inputs, perform an algorithm, and return the result.

## 12. Practice Questions

### Question 1: Basic method

What is the output?

```java
static int multiply(int a, int b) {
    return a * b;
}

int result = multiply(5, 4);
System.out.println(result);
```

### Question 2: Return value

What is the value of `result`?

```java
static int doubleNumber(int x) {
    return x * 2;
}

int result = doubleNumber(10);
```

### Question 3: Print vs return

Does this method return a value?

```java
static void greet() {
    System.out.println("Hello");
}
```

### Question 4: Calling methods

What is the output?

```java
static int square(int x) {
    return x * x;
}

static int addSquares(int a, int b) {
    return square(a) + square(b);
}

System.out.println(addSquares(3, 4));
```

### Question 5: Array method

Given:

```java
int[] arr = {4, 9, 2, 7};
```

Trace `findMax(arr)` and identify the value returned.

---

## Summary

A Java method is a reusable block of code. It can accept inputs through parameters, perform an operation, and return a result. Understanding method calls, scope, `return`, `void`, and `static` provides the foundation needed to implement DSA algorithms in Java.