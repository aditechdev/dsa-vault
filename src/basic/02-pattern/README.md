# 🌟 Patterns — DSA Quick Revision Notes

A concise, human-readable revision cheat sheet designed for rapid interview prep and DSA technical reviews on pattern printing.

---

## 📌 Problem Directory & Pattern Summary

| ID | Pattern Type | Implementation File | Time | Space | Core Logic |
| :--- | :--- | :--- | :---: | :---: | :--- |
| **P01** | Full Numeric Pyramid | [P01_FullNumericPyramid.java](./P01_FullNumericPyramid.java) | $O(N^2)$ | $O(1)$ | Leading spaces, increasing up to $2i-1$, decreasing down to $i$, trailing spaces |
| **P02** | Full Numeric Pyramid (Simplified) | [P02_FullPyramid.java](./P02_FullPyramid.java) | $O(N^2)$ | $O(1)$ | Leading spaces $n-i$, then numbers $1$ to $i$ |
| **P03** | Half Diamond Pattern | [P03_HalfDiamond.java](./P03_HalfDiamond.java) | $O(N^2)$ | $O(1)$ | Spaces up to $n-i$, stars up to $2i-1$ |
| **P04** | Half Pyramid (Numeric & Star) | [P04_HalfPyramid.java](./P04_HalfPyramid.java) | $O(N^2)$ | $O(1)$ | Print values from $1$ to $n$ for each row $n$ |
| **P05** | Hour Glass Pattern | [P05_HourGlass.java](./P05_HourGlass.java) | $O(N^2)$ | $O(1)$ | Outer loop $1$ to $num$, inner $1$ to $i$ |
| **P06** | Reverse Triangle Pattern | [P06_ReverseTrianglePattern.java](./P06_ReverseTrianglePattern.java) | $O(N^2)$ | $O(1)$ | Outer loop $num$ down to $1$, inner $1$ to $i$ |

---

## 🧠 Quick Interview Revision Snippets

### 1. General Pattern Printing Strategy
Pattern printing questions test your ability to use nested loops.
- **Outer Loop**: Usually controls the number of rows (e.g., `for (int i = 1; i <= n; i++)`).
- **Inner Loops**: Usually control what is printed on each row. You might need multiple inner loops for spaces, increasing characters, and decreasing characters.

### 2. Identifying the Row Logic
To solve any pattern:
1. Count the number of rows ($N$).
2. For row $i$, count how many spaces need to be printed (often a function of $N - i$).
3. For row $i$, count how many characters (stars or numbers) need to be printed (often a function of $i$, like $i$ or $2i - 1$).
4. Determine the sequence of characters printed (e.g., $1$ to $i$, or a running counter).

### 3. Common Loop Structures

**Half Pyramid (Left-aligned)**
```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

**Inverted Half Pyramid**
```java
for (int i = n; i >= 1; i--) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
```

**Full Pyramid (Centered)**
```java
for (int i = 1; i <= n; i++) {
    // Print leading spaces
    for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
    }
    // Print stars
    for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print("*");
    }
    System.out.println();
}
```
