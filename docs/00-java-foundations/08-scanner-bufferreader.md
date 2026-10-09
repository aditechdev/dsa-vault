# 08 — Scanner and BufferedReader

## 1. Introduction

In Java, we use input classes to read data provided by the user or a coding platform.

The two common approaches are:

1. `Scanner` — beginner-friendly and easy to use.
2. `BufferedReader` — reads text efficiently and is often preferred for large inputs in DSA.

Both can read input from the keyboard using `System.in`.

---

## 2. Scanner

`Scanner` is a Java class used to read and parse input.

### Import Scanner

```java
import java.util.Scanner;
```

### Create a Scanner object

```java
Scanner sc = new Scanner(System.in);
```

- `Scanner` is the class.
- `sc` is the reference variable.
- `new Scanner(System.in)` creates a Scanner that reads from standard input.
- `System.in` represents standard input, usually the keyboard or coding platform input.

### Reading different data types

```java
int age = sc.nextInt();

long population = sc.nextLong();

double price = sc.nextDouble();

String name = sc.next();

String sentence = sc.nextLine();
```

| Method | Reads | Return type |
|---|---|---|
| `nextInt()` | An integer | `int` |
| `nextLong()` | A long integer | `long` |
| `nextDouble()` | A decimal number | `double` |
| `next()` | One token | `String` |
| `nextLine()` | The remaining current line | `String` |

### Example 1: Read an integer

Input:

```text
25
```

Code:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int age = sc.nextInt();

        System.out.println(age);
    }
}
```

Output:

```text
25
```

### Example 2: Read multiple values

Input:

```text
10 20
```

Code:

```java
Scanner sc = new Scanner(System.in);

int a = sc.nextInt();
int b = sc.nextInt();

System.out.println(a + b);
```

Output:

```text
30
```

**Important:** Input values are read from left to right. `nextInt()` reads the next integer token, skipping whitespace such as spaces and newlines.

---

## 3. `next()` vs `nextLine()`

These methods behave differently.

### `next()`

Reads one token and stops at whitespace.

Input:

```text
Aditya Anand
```

Code:

```java
String name = sc.next();

System.out.println(name);
```

Output:

```text
Aditya
```

### `nextLine()`

Reads the remaining characters on the current line, including spaces.

Input:

```text
Aditya Anand
```

Code:

```java
String name = sc.nextLine();

System.out.println(name);
```

Output:

```text
Aditya Anand
```

### Comparison

| Feature | `next()` | `nextLine()` |
|---|---|---|
| Reads | One token | Remaining line |
| Stops at spaces | Yes | No |
| Return type | `String` | `String` |
| Common use | Single-word input | Full-line input |

---

## 4. The `nextInt()` + `nextLine()` Problem

This is a common Java input issue.

Consider the input:

```text
25
Aditya Anand
```

Code:

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();
String name = sc.nextLine();

System.out.println(age);
System.out.println(name);
```

You might expect `name` to contain `"Aditya Anand"`, but it will usually be an empty string.

### Why does this happen?

1. `nextInt()` reads `25`.
2. It does not consume the newline character at the end of that line.
3. `nextLine()` consumes the remaining part of the current line, which is empty.

### Correct solution

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();
sc.nextLine(); // Consume the leftover newline

String name = sc.nextLine();

System.out.println(age);
System.out.println(name);
```

Output:

```text
25
Aditya Anand
```

**Rule:** When switching from a token-based method such as `nextInt()` to `nextLine()`, consume the leftover line ending if you intend to read the next line.

This issue does not arise in the same way when all input is read using `nextLine()`.

---

## 5. BufferedReader

`BufferedReader` reads text efficiently by buffering characters.

It is commonly used in competitive programming when input is large.

### Import required classes

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
```

### Create a BufferedReader

```java
BufferedReader br =
    new BufferedReader(new InputStreamReader(System.in));
```

- `InputStreamReader` converts bytes from `System.in` into characters.
- `BufferedReader` buffers characters and provides convenient line-based reading.
- `br` is the reference variable used to read input.

### Read a line

```java
String line = br.readLine();
```

**Important:** `readLine()` always returns a `String`, regardless of whether the input represents a number, a word, or a sentence.

It returns `null` when the end of the input stream is reached without another line to read.

### Example: Read an integer

Input:

```text
25
```

Code:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int age = Integer.parseInt(line);

        System.out.println(age);
    }
}
```

Output:

```text
25
```

---

## 6. Parsing Input

Parsing means converting text into the required data type.

Since `BufferedReader.readLine()` returns a `String`, numeric input must be converted before performing arithmetic.

### String to int

```java
String value = "100";
int number = Integer.parseInt(value);
```

Result:

```text
100
```

### String to long

```java
String value = "12345678900";
long number = Long.parseLong(value);
```

### String to double

```java
String value = "19.99";
double price = Double.parseDouble(value);
```

### Number to String

```java
int number = 100;
String value = String.valueOf(number);
```

### Important distinction

```java
String value = "100";
```

Here, `value` is a String, not an integer.

This will not compile:

```java
// int number = value;
```

Use:

```java
int number = Integer.parseInt(value);
```

Invalid numeric text, such as `"abc"`, causes `NumberFormatException` when parsed as an integer.

---

## 7. Reading Multiple Numbers with BufferedReader

Suppose the input is:

```text
10 20 30
```

### Step 1: Read the complete line

```java
String line = br.readLine();
```

The variable `line` contains:

```text
"10 20 30"
```

### Step 2: Split the line

```java
String[] parts = line.split("\\s+");
```

The resulting array contains:

```text
parts[0] = "10"
parts[1] = "20"
parts[2] = "30"
```

`split("\\s+")` separates the line using one or more whitespace characters, such as spaces or tabs.

### Step 3: Convert each value

```java
int a = Integer.parseInt(parts[0]);
int b = Integer.parseInt(parts[1]);
int c = Integer.parseInt(parts[2]);
```

### Complete example

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        String[] parts = br.readLine().trim().split("\\s+");

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);

        System.out.println(a + b + c);
    }
}
```

Input:

```text
10 20 30
```

Output:

```text
60
```

**Note:** `trim()` removes leading and trailing whitespace. The example assumes the input line is nonempty.

---

## 8. Reading an Array

Suppose the input is:

```text
5
10 20 30 40 50
```

The first line contains the array size, `n`. The second line contains `n` elements.

### Using Scanner

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

### Using BufferedReader

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n];

        String[] parts = br.readLine().trim().split("\\s+");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

The second example assumes the array elements are all on one line. For input spread across arbitrary numbers of lines, use a token-based parser or another approach that handles the full input format.

---

## 9. Scanner vs BufferedReader

| Feature | Scanner | BufferedReader |
|---|---|---|
| Ease of use | Easier for beginners | Requires more setup |
| Input methods | Reads and parses tokens | Reads text lines |
| Numeric conversion | Built-in methods such as `nextInt()` | Explicit parsing required |
| Full-line input | `nextLine()` | `readLine()` |
| Performance | Usually slower | Usually faster for large input |
| Typical DSA use | Small or moderate input | Large input or performance-sensitive problems |

### Which should you use?

- **While learning Java:** Use `Scanner` because it is straightforward.
- **For large competitive-programming inputs:** Prefer `BufferedReader` with appropriate parsing.
- **For online judges:** Follow the problem's input format and use whichever approach is suitable.

Neither class makes an inefficient algorithm efficient. Input handling and algorithmic time complexity are separate concerns.

---

## 10. Common Mistakes

### Mistake 1: Treating a String as an integer

```java
String value = br.readLine();
int n = Integer.parseInt(value);
```

Do not assign the String directly to an `int`.

### Mistake 2: Forgetting the leftover newline

```java
int age = sc.nextInt();
sc.nextLine(); // Consume the remaining line ending
String name = sc.nextLine();
```

### Mistake 3: Forgetting imports

For Scanner:

```java
import java.util.Scanner;
```

For BufferedReader:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
```

### Mistake 4: Forgetting checked exceptions

`BufferedReader.readLine()` can throw `IOException`. A beginner-friendly approach is:

```java
public static void main(String[] args) throws IOException {
    // Input code
}
```

Alternatively, handle the exception using `try-catch`.

### Mistake 5: Using `split(" ")` for all whitespace

```java
String[] parts = line.split("\\s+");
```

This is generally more robust than splitting on a single literal space because it handles multiple spaces and tabs.

---

## 11. Quick Revision

- `Scanner` reads and parses common input types.
- `nextInt()` reads an integer token.
- `next()` reads one token as a String.
- `nextLine()` reads the remaining current line.
- `BufferedReader.readLine()` reads a line as a String.
- `Integer.parseInt()` converts a numeric String into an `int`.
- `Long.parseLong()` converts a numeric String into a `long`.
- `Double.parseDouble()` converts a numeric String into a `double`.
- `split("\\s+")` separates a line using whitespace.
- `Scanner` is easier to learn; `BufferedReader` is often faster for large input.
- Input parsing does not change the time complexity of the algorithm itself.

---

## 12. Practice Questions

### Conceptual questions

1. What is the difference between `next()` and `nextLine()`?
2. Why does `BufferedReader.readLine()` return a String even when the input contains a number?
3. What does `Integer.parseInt("123")` return?
4. Why can `nextInt()` followed by `nextLine()` produce an empty String?
5. When would you prefer `BufferedReader` over `Scanner`?

### Coding exercises

**Exercise 1 — Sum of two numbers**

Input:

```text
10 20
```

Output:

```text
30
```

Solve using `Scanner`.

**Exercise 2 — Read a full name**

Input:

```text
Aditya Anand
```

Output:

```text
Hello, Aditya Anand
```

Solve using `Scanner` and `nextLine()`.

**Exercise 3 — Sum an array**

Input:

```text
5
10 20 30 40 50
```

Output:

```text
150
```

Solve using `BufferedReader`.

**Exercise 4 — Parse and calculate**

Read a line containing three integers, convert them to integers, and print their average as a decimal value.

---

## Completion Checklist

- [ ] Understand `Scanner` and its constructor.
- [ ] Know `nextInt()`, `nextLong()`, `nextDouble()`, `next()`, and `nextLine()`.
- [ ] Understand the `nextInt()` + `nextLine()` issue.
- [ ] Understand `BufferedReader` and `readLine()`.
- [ ] Convert Strings to numeric types using parsing methods.
- [ ] Read multiple values using `split("\\s+")`.
- [ ] Read array input using both approaches.
- [ ] Know when to use `Scanner` versus `BufferedReader`.
- [ ] Solve the practice exercises.

**Next topic:** Java fundamentals — primitive vs reference types, `null`, `final`, pass-by-value, and classes/objects.
