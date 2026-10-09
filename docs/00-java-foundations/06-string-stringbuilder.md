# Strings and StringBuilder in Java

## 1. What Is a String?

A `String` is a sequence of characters used to represent text.

```java
String name = "Aditya";
String language = "Java";
String empty = "";
```

Examples:

- `"Java"` is a String.
- `"Hello World"` is a String containing a space.
- `""` is an empty String.
- `'A'` is a `char`, not a String.

### String vs char

```java
char letter = 'A';
String word = "A";
```

| Type | Represents | Example |
|---|---|---|
| `char` | A single character | `'A'` |
| `String` | A sequence of characters | `"Java"` |

Remember:
- `char` uses single quotes.
- `String` uses double quotes.

## 2. String Immutability

Strings in Java are **immutable**.

Immutable means that once a String object is created, its contents cannot be changed.

Example:

```java
String s = "Hello";

s = s + " World";

System.out.println(s);
```

Output:

```text
Hello World
```

What happened?

1. Initially, `s` refers to the String `"Hello"`.
2. The expression `s + " World"` creates a new String containing `"Hello World"`.
3. The variable `s` is reassigned to refer to the new String.

The original String object was not modified.

### Important distinction

```java
String s = "Hello";
s = s + " World";
```

This does not modify the original String. It reassigns `s` to a String containing the combined text.

Immutability is important when working with Strings repeatedly in loops.

## 3. String `length()`

The `length()` method returns the number of characters in a String.

```java
String s = "Java";

System.out.println(s.length());
```

Output:

```text
4
```

### String length vs array length

```java
int[] arr = {10, 20, 30};
String s = "Java";

System.out.println(arr.length); // 3
System.out.println(s.length()); // 4
```

| Data type | Length syntax |
|---|---|
| Array | `arr.length` |
| String | `s.length()` |

An array's `length` is a field, while String's `length()` is a method.

## 4. String Indexing and `charAt()`

Strings use zero-based indexing, just like arrays.

```java
String s = "Hello";
```

Character positions:

```text
Character: H  e  l  l  o
Index:     0  1  2  3  4
```

Use `charAt(index)` to access a character.

```java
char c = s.charAt(1);

System.out.println(c);
```

Output:

```text
e
```

### Accessing the first and last characters

```java
String s = "Hello";

char first = s.charAt(0);
char last = s.charAt(s.length() - 1);
```

Values:

```text
first = 'H'
last  = 'o'
```

The last valid index is always:

```java
s.length() - 1
```

### Invalid index

```java
String s = "Java";

char c = s.charAt(4);
```

This throws:

```text
StringIndexOutOfBoundsException
```

Valid indices are `0` through `s.length() - 1`.

## 5. Comparing Strings with `equals()`

Use `equals()` to compare the contents of two Strings.

```java
String a = "Java";
String b = "Java";

System.out.println(a.equals(b));
```

Output:

```text
true
```

### Case-sensitive comparison

```java
String a = "hello";
String b = "Hello";

System.out.println(a.equals(b));
```

Output:

```text
false
```

The uppercase `H` and lowercase `h` are different characters.

Examples:

```java
"Java".equals("Java");   // true
"Java".equals("java");   // false
"Java".equals("Java ");  // false
```

An additional space also makes the Strings different.

### `equals()` vs `==`

For String content comparison, use `equals()`.

```java
String a = new String("Java");
String b = new String("Java");

System.out.println(a.equals(b)); // true
System.out.println(a == b);      // false
```

Here, `equals()` compares the contents. The `==` operator compares whether the two reference variables refer to the same object.

The `==` result can differ for other String creation patterns, such as String literals. Do not use `==` when your intention is to compare String contents.

## 6. Extracting Text with `substring()`

The `substring()` method extracts part of a String.

Syntax:

```java
s.substring(start, end)
```

- `start` is included.
- `end` is excluded.

Example:

```java
String s = "Programming";

String part = s.substring(0, 4);

System.out.println(part);
```

Output:

```text
Prog
```

Indexes:

```text
Character: P r o g r a m m i n g
Index:     0 1 2 3 4 5 6 7 8 9 10
```

The method selects indices `0`, `1`, `2`, and `3`. Index `4` is excluded.

### Another example

```java
String s = "HelloWorld";

String part = s.substring(5, 10);

System.out.println(part);
```

Output:

```text
World
```

### Important rule

```text
substring(start, end)

start → included
end   → excluded
```

This is often written as the half-open range `[start, end)`.

It is a useful convention for DSA problems.

## 7. String Concatenation

Concatenation means joining Strings together.

The `+` operator performs numeric addition when both operands are numbers. When String concatenation applies, it joins text.

### Numeric addition

```java
int a = 10;
int b = 20;

System.out.println(a + b);
```

Output:

```text
30
```

### String concatenation

```java
String first = "Hello";
String second = "World";

String result = first + " " + second;

System.out.println(result);
```

Output:

```text
Hello World
```

### Mixing Strings and numbers

```java
int a = 10;
int b = 20;

System.out.println("" + a + b);
```

Output:

```text
1020
```

Evaluation:

```text
"" + 10  → "10"
"10" + 20 → "1020"
```

But:

```java
System.out.println("" + (a + b));
```

Output:

```text
30
```

The parentheses cause `a + b` to be evaluated as numeric addition first, producing `30`. That number is then converted to text during concatenation.

## 8. StringBuilder

`StringBuilder` is a Java class used to build and modify text without creating a new String object for every append operation.

It is especially useful when repeatedly building text inside loops.

### Creating a StringBuilder

```java
StringBuilder sb = new StringBuilder();
```

You can also initialize it with existing text:

```java
StringBuilder sb = new StringBuilder("Java");
```

### The `append()` method

`append()` adds text or another value to the end of the current contents.

```java
StringBuilder sb = new StringBuilder();

sb.append("Java");
sb.append(" ");
sb.append("DSA");

System.out.println(sb);
```

Output:

```text
Java DSA
```

Dry run:

```text
Initially        → ""
append("Java")   → "Java"
append(" ")      → "Java "
append("DSA")    → "Java DSA"
```

`append()` can also accept numbers:

```java
StringBuilder sb = new StringBuilder();

sb.append("A");
sb.append("B");
sb.append(123);

System.out.println(sb);
```

Output:

```text
AB123
```

### Accessing characters

StringBuilder also supports `charAt()`.

```java
StringBuilder sb = new StringBuilder("Java");

char c = sb.charAt(2);

System.out.println(c);
```

Output:

```text
v
```

### Converting to a String

Use `toString()` to obtain a String containing the current contents.

```java
StringBuilder sb = new StringBuilder();

sb.append("Hello");
sb.append(" World");

String result = sb.toString();

System.out.println(result);
```

Output:

```text
Hello World
```

## 9. String vs StringBuilder

| Feature | String | StringBuilder |
|---|---|---|
| Mutable? | No | Yes |
| Main purpose | Represent text | Build and modify text |
| Add text | `s = s + "A"` | `sb.append("A")` |
| Character access | `charAt()` | `charAt()` |
| Length | `length()` | `length()` |
| Convert to String | Already a String | `toString()` |

### When should you use each?

Use `String` when storing or passing text normally.

```java
String name = "Aditya";
```

Use `StringBuilder` when repeatedly building or modifying text.

```java
StringBuilder result = new StringBuilder();

for (int i = 1; i <= 5; i++) {
    result.append(i);
}

System.out.println(result);
```

Output:

```text
12345
```

Repeated String concatenation can create many intermediate String objects. `StringBuilder` is generally more efficient for repeated appends, especially inside loops.

## 10. String-to-Number Conversion

Input from coding platforms often needs to be converted from text into numeric types before performing calculations.

### String to `int`

Use `Integer.parseInt()`.

```java
String s = "42";

int x = Integer.parseInt(s);

System.out.println(x);
```

Output:

```text
42
```

Here:

```text
s → String containing "42"
x → int containing 42
```

The text must represent a valid integer within the `int` range. Otherwise, parsing can throw an exception.

### String to `long`

Use `Long.parseLong()`.

```java
String s = "12345678900";

long x = Long.parseLong(s);
```

This is useful for integer values that exceed the range of `int` but fit within `long`.

## 11. Number-to-String Conversion

Use `String.valueOf()` to convert a number into text.

```java
int x = 42;

String s = String.valueOf(x);
```

Now:

```text
x = 42    → int
s = "42"  → String
```

Example:

```java
int number = 123;
String text = String.valueOf(number);

System.out.println(text);
```

Output:

```text
123
```

Although the output looks the same, `number` is numeric and `text` is text.

## 12. Character Operations

Java provides useful static methods through the `Character` class.

### Check whether a character is a digit

```java
char c = '7';

System.out.println(Character.isDigit(c));
```

Output:

```text
true
```

### Check whether a character is a letter

```java
char c = 'A';

System.out.println(Character.isLetter(c));
```

Output:

```text
true
```

### Convert character case

```java
char lower = Character.toLowerCase('A');
char upper = Character.toUpperCase('b');

System.out.println(lower);
System.out.println(upper);
```

Output:

```text
a
B
```

### Character vs number vs String

```java
int number = 7;
char character = '7';
String text = "7";
```

These are different:

- `number` stores the numeric value seven.
- `character` stores the character digit `'7'`.
- `text` stores a String containing the character digit.

For example:

```java
Character.isDigit('7'); // true
Character.isLetter('7'); // false
```

## 13. String Traversal

String traversal means visiting each character, usually with a loop.

Example:

```java
String s = "Java";

for (int i = 0; i < s.length(); i++) {
    System.out.println(s.charAt(i));
}
```

Output:

```text
J
a
v
a
```

Dry run:

```text
i = 0 → s.charAt(0) → J
i = 1 → s.charAt(1) → a
i = 2 → s.charAt(2) → v
i = 3 → s.charAt(3) → a
i = 4 → stop
```

The condition is:

```java
i < s.length()
```

Do not use `i <= s.length()` when accessing each character, because that would eventually attempt an invalid index.

### Traversing backwards

```java
String s = "Java";

for (int i = s.length() - 1; i >= 0; i--) {
    System.out.println(s.charAt(i));
}
```

Output:

```text
a
v
a
J
```

## 14. Common Mistakes

### Mistake 1: Using array syntax for String length

Incorrect:

```java
s.length
```

Correct:

```java
s.length()
```

### Mistake 2: Accessing an invalid index

Incorrect:

```java
String s = "Java";
char c = s.charAt(s.length());
```

Correct:

```java
char c = s.charAt(s.length() - 1);
```

### Mistake 3: Using `==` for String content comparison

Prefer:

```java
a.equals(b)
```

### Mistake 4: Forgetting the exclusive end index

```java
"Hello".substring(0, 2)
```

returns `"He"`, not `"Hel"`.

### Mistake 5: Using String concatenation repeatedly in a large loop

For repeated text construction, prefer:

```java
StringBuilder sb = new StringBuilder();
sb.append("text");
```

### Mistake 6: Confusing characters with numbers

```java
'7'  // char
7    // int
"7"  // String
```

These values have different types and different uses.

## 15. Practice Questions

Attempt these without running the code first. Write down your reasoning and dry-run each expression.

### Beginner

1. What does `"Computer".length()` return?
2. What does `"Java".charAt(0)` return?
3. What does `"Hello".charAt(4)` return?
4. What does `"Hello".substring(1, 4)` return?
5. What does `"Java".equals("java")` return?
6. What is the difference between `'5'`, `5`, and `"5"`?

### Intermediate

7. What is the output?

   ```java
   String s = "Cat";

   for (int i = 0; i < s.length(); i++) {
       System.out.print(s.charAt(i));
   }
   ```

8. What is the output?

   ```java
   int a = 10;
   int b = 20;

   System.out.println(a + b);
   System.out.println("" + a + b);
   ```

9. Dry-run this code:

   ```java
   StringBuilder sb = new StringBuilder();

   sb.append("A");
   sb.append("B");
   sb.append(123);

   System.out.println(sb);
   ```

10. Convert the String `"123"` into an `int`.
11. Convert the integer `456` into a String.
12. Explain why `StringBuilder` is useful when constructing text in a loop.

## 16. Key Takeaways

- A String represents text and is immutable.
- Use `length()` to get the length of a String.
- Use `charAt(index)` to access a character.
- String indices begin at zero.
- Use `equals()` to compare String contents.
- In `substring(start, end)`, the start is included and the end is excluded.
- Use `+` for simple concatenation.
- Use `StringBuilder` for repeated text construction.
- Use `Integer.parseInt()` to convert a String to an `int`.
- Use `String.valueOf()` to convert a number to a String.
- Use `Character` methods to inspect or convert characters.
- Traverse Strings using a loop and `charAt()`.
- Always ensure that character indices remain within valid bounds.

**Learning sequence:** Understand String operations → practise traversal → use StringBuilder → solve basic String problems → learn String-specific DSA patterns.