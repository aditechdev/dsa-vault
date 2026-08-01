# Basic Math

Basic mathematical concepts frequently used in DSA, Competitive Programming, and Coding Interviews.

---

## Number Types Overview

| Number Type | Examples | Common Uses |
|-------------|----------|-------------|
| Natural Numbers | `1, 2, 3...` | Counting, Prime Numbers |
| Whole Numbers | `0, 1, 2...` | Counting including zero |
| Integers | `..., -2, -1, 0, 1, 2...` | Arrays, Math, DP |
| Even Numbers | `2, 4, 6...` | Bit Manipulation, Parity |
| Odd Numbers | `1, 3, 5...` | Parity Checks |
| Prime Numbers | `2, 3, 5, 7...` | Number Theory |
| Composite Numbers | `4, 6, 8, 9...` | Factorization |
| Co-prime Numbers | `(8, 15), (9, 28)` | GCD, Modular Arithmetic |
| Perfect Square | `1, 4, 9, 16...` | Binary Search, Math |
| Perfect Cube | `1, 8, 27, 64...` | Math Problems |
| Power of Two | `1, 2, 4, 8...` | Bit Manipulation |
| Power of Ten | `10, 100, 1000...` | Digit Problems |
| Fibonacci Numbers | `0, 1, 1, 2, 3...` | DP, Recursion |
| Palindrome Numbers | `121, 1331` | Number Manipulation |
| Armstrong Numbers | `153, 370` | Basic Math Problems |

---

## Table of Contents

1. [Natural Numbers](#1-natural-numbers)
2. [Whole Numbers](#2-whole-numbers)
3. [Integers](#3-integers)
4. [Even Numbers](#4-even-numbers)
5. [Odd Numbers](#5-odd-numbers)
6. [Prime Number](#6-prime-number)
7. [Composite Number](#7-composite-number)
8. [Co-prime Numbers](#8-co-prime-numbers)
9. [Factors](#9-factors)
10. [Divisors](#10-divisors)
11. [Prime Factorization](#11-prime-factorization)
12. [GCD (HCF)](#12-gcd-hcf)
13. [LCM](#13-lcm)
14. [Euclidean Algorithm](#14-euclidean-algorithm)
15. [Sieve of Eratosthenes](#15-sieve-of-eratosthenes)
16. [Modular Arithmetic](#16-modular-arithmetic)
17. [Binary Exponentiation](#17-binary-exponentiation)
18. [Perfect Square](#18-perfect-square)
19. [Perfect Cube](#19-perfect-cube)
20. [Power of Two](#20-power-of-two)
21. [Power of Ten](#21-power-of-ten)
22. [Number of Digits](#22-number-of-digits)
23. [Digit Extraction](#23-digit-extraction)
24. [Trailing Zeros](#24-trailing-zeros)
25. [Palindrome Number](#25-palindrome-number)
26. [Armstrong Number](#26-armstrong-number)
27. [Fibonacci Numbers](#27-fibonacci-numbers)

---

# Basic Math

Basic mathematical concepts frequently used in DSA, Competitive Programming, and Coding Interviews.

---

# 1. Natural Numbers

Natural numbers are positive whole numbers used for counting.

**Examples:** `1, 2, 3, 4, ...`

They cannot be:
- Negative
- Decimal
- Fraction

---

# 2. Whole Numbers

Whole numbers include **0** and all natural numbers.

**Examples:** `0, 1, 2, 3, ...`

---

# 3. Integers

Integers include negative numbers, zero, and positive numbers.

**Examples:** `..., -3, -2, -1, 0, 1, 2, 3, ...`

---

# 4. Even Numbers

Numbers divisible by **2**.

**Examples:** `2, 4, 6, 8, 10`

```text
n % 2 == 0
```

---

# 5. Odd Numbers

Numbers that are **not divisible by 2**.

**Examples:** `1, 3, 5, 7, 9`

```text
n % 2 != 0
```

---

# 6. Prime Number

A **Prime Number** is a number greater than **1** that is divisible only by **1** and itself.

A number with more than two factors is called a **Composite Number**.

## Examples

**Prime:** `2, 3, 5, 7, 11, 13, 17`

**Composite:** `4, 6, 8, 9, 10, 12`

## Key Points

- 0 is not prime.
- 1 is not prime.
- 2 is the only even prime.
- Every prime number greater than 2 is odd.

## Prime Check

1. If `n <= 1` → Not Prime
2. Check divisibility from `2` to `√n`
3. Divisor found → Composite
4. Otherwise → Prime

**Time Complexity:** `O(√n)`

## Code

- [PrimeNumber.java](PrimeNumber.java)

---

# 7. Composite Number

A **Composite Number** has more than two positive factors.

**Examples:** `4, 6, 8, 9, 10`

---

# 8. Co-prime Numbers

Two numbers whose **GCD is 1**.

**Examples**

- `(8, 15)`
- `(9, 28)`

---

# 9. Factors

Factors are numbers that divide another number exactly.

**Factors of 12**

```text
1, 2, 3, 4, 6, 12
```

---

# 10. Divisors

A divisor is any number that divides another number without leaving a remainder.

Example:

```text
12 ÷ 3 = 4
```

So, **3** is a divisor of **12**.

---

# 11. Prime Factorization

Expressing a number as the product of prime numbers.

Example

```text
24 = 2 × 2 × 2 × 3
```

---

# 12. GCD (HCF)

The **Greatest Common Divisor** (Highest Common Factor) is the largest number that divides both numbers.

Example

```text
GCD(12,18)=6
```

---

# 13. LCM

The **Least Common Multiple** is the smallest number divisible by both numbers.

Example

```text
LCM(6,8)=24
```

---

# 14. Euclidean Algorithm

An efficient algorithm to calculate the GCD.

```text
GCD(a,b)=GCD(b,a%b)
```

**Time Complexity:** `O(log n)`

---

# 15. Sieve of Eratosthenes

Efficient algorithm to find all prime numbers up to **N**.

**Time Complexity:** `O(N log log N)`

---

# 16. Modular Arithmetic

Modulo returns the remainder after division.

```text
a % b
```

Common properties:

```text
(a+b)%m=((a%m)+(b%m))%m

(a*b)%m=((a%m)*(b%m))%m
```

---

# 17. Binary Exponentiation

Efficient method to calculate large powers.

```text
a^n
```

**Time Complexity:** `O(log n)`

---

# 18. Perfect Square

A number obtained by multiplying an integer by itself.

**Examples**

```text
1,4,9,16,25
```

---

# 19. Perfect Cube

A number obtained by multiplying an integer three times.

**Examples**

```text
1,8,27,64,125
```

---

# 20. Power of Two

A number of the form:

```text
2^n
```

Examples

```text
1,2,4,8,16,32
```

Bit Trick

```text
n > 0 && (n & (n-1)) == 0
```

---

# 21. Power of Ten

A number of the form:

```text
10^n
```

Examples

```text
10,100,1000,10000
```

---

# 22. Number of Digits

Number of digits in an integer.

Examples

```text
12345 → 5 digits
```

Formula

```text
⌊log10(n)⌋ + 1
```

---

# 23. Digit Extraction

Extract digits using modulo and division.

```text
digit = n % 10
n = n / 10
```

---

# 24. Trailing Zeros

Zeros at the end of a number.

Frequently asked in:

- Factorial
- Large Numbers

---

# 25. Palindrome Number

A number that reads the same forward and backward.

Examples

```text
121
1331
12321
```

---

# 26. Armstrong Number

A number equal to the sum of its digits raised to the power of the number of digits.

Example

```text
153

1³ + 5³ + 3³ = 153
```

---

# 27. Fibonacci Numbers

A sequence where each number is the sum of the previous two.

```text
0,1,1,2,3,5,8,13,...
```

Formula

```text
F(n)=F(n−1)+F(n−2)
```

---

# Time Complexity Summary

| Topic | Complexity |
|--------|------------|
| Prime Check | O(√N) |
| Euclidean Algorithm | O(log N) |
| Binary Exponentiation | O(log N) |
| Sieve of Eratosthenes | O(N log log N) |
