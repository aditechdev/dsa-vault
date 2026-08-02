# ⚡ Basic Math — DSA Quick Revision Notes

A concise, human-readable revision cheat sheet designed for rapid interview prep and DSA technical reviews.

---

## 📌 Problem Directory & Complexity Summary

| ID | Problem | File Link | Time | Space | Key Formula / Technique |
| :--- | :--- | :--- | :---: | :---: | :--- |
| **P01** | Area of Circle & Volume of Sphere | [P01_AreaOfCircle.java](./P01_AreaOfCircle.java) | $O(1)$ | $O(1)$ | $\text{Area} = \pi r^2, \quad \text{Vol} = \frac{4}{3} \pi r^3$ |
| **P02** | Check Vowel | [P02_CheckVowel.java](./P02_CheckVowel.java) | $O(1)$ | $O(1)$ | `Character.toLowerCase(ch)` check |
| **P03** | Factorial of a Number | [P03_Factorial.java](./P03_Factorial.java) | $O(N)$ | $O(1)$ | $N! = N \times (N-1) \times \dots \times 1$ |
| **P04** | Greatest Common Divisor (GCD) | [P04_GCDOfNumber.java](./P04_GCDOfNumber.java) | $O(\log(\min(A, B)))$ | $O(1)$ | $\text{GCD}(A, B) = \text{GCD}(B, A \bmod B)$ |
| **P05** | Least Common Multiple (LCM) | [P05_LCM.java](./P05_LCM.java) | $O(\min(A, B))$ | $O(1)$ | $\text{LCM}(A, B) = (A \times B) / \text{GCD}(A, B)$ |
| **P06** | Count Number of Digits | [P06_NumberOfDigits.java](./P06_NumberOfDigits.java) | $O(\log_{10} N)$ | $O(1)$ | $\lfloor \log_{10} N \rfloor + 1$ or `/ 10` loop |
| **P07** | Palindrome Number Check | [P07_PalindromeCheck.java](./P07_PalindromeCheck.java) | $O(\log_{10} N)$ | $O(1)$ | $N == \text{Reverse}(N)$ |
| **P08** | Prime Number Check & Range | [P08_PrimeNumber.java](./P08_PrimeNumber.java) | $O(\sqrt{N})$ | $O(1)$ | Check divisors from $2$ to $\sqrt{N}$ |
| **P09** | Multiplication Table | [P09_PrintTable.java](./P09_PrintTable.java) | $O(1)$ | $O(1)$ | Iterative product $N \times i$ for $i \in [1, 10]$ |
| **P10** | Pseudo-Random Generation | [P10_RandomDemo.java](./P10_RandomDemo.java) | $O(1)$ | $O(1)$ | `java.util.Random.nextInt(bound)` |
| **P11** | Reverse Number | [P11_ReverseNumber.java](./P11_ReverseNumber.java) | $O(\log_{10} N)$ | $O(1)$ | $\text{rev} = (\text{rev} \times 10) + (N \bmod 10)$ |
| **P12** | Sum of Digits | [P12_SumOfNumbers.java](./P12_SumOfNumbers.java) | $O(\log_{10} N)$ | $O(1)$ | Accumulate `sum += N % 10` |

---

## 🔢 Number Types & Quick Properties

| Number Type | Examples | Key Property / Bit Trick | Common Use Case |
| :--- | :--- | :--- | :--- |
| **Natural Numbers** | `1, 2, 3, 4...` | $N > 0$, whole positive numbers | Counting, Loop bounds |
| **Whole Numbers** | `0, 1, 2, 3...` | $N \ge 0$, includes zero | Array indices, Non-negative counts |
| **Integers** | `..., -2, -1, 0, 1, 2...` | Includes negative, zero, positive | General mathematical calculations |
| **Even Numbers** | `0, 2, 4, 6, 8...` | `(n & 1) == 0` or `n % 2 == 0` | Bit manipulation, Parity check |
| **Odd Numbers** | `1, 3, 5, 7, 9...` | `(n & 1) != 0` or `n % 2 != 0` | Parity checks, Step increments |
| **Prime Numbers** | `2, 3, 5, 7, 11...` | Exactly 2 divisors ($1$ and itself) | Number theory, Hashing, Cryptography |
| **Composite Numbers** | `4, 6, 8, 9, 10...` | $>2$ factors ($0, 1$ are neither) | Factorization problems |
| **Co-prime Numbers** | `(8, 15), (9, 28)` | $\text{GCD}(A, B) == 1$ | Modular inverses, Euler's totient |
| **Perfect Square** | `1, 4, 9, 16, 25...` | $\sqrt{N} \in \mathbb{Z}$ | Binary search range problems |
| **Perfect Cube** | `1, 8, 27, 64, 125...` | $\sqrt[3]{N} \in \mathbb{Z}$ | Mathematical pattern problems |
| **Power of Two** | `1, 2, 4, 8, 16...` | `n > 0 && (n & (n - 1)) == 0` | Bit manipulation, Segment Trees |
| **Power of Ten** | `10, 100, 1000...` | $10^k$ | Digit place-value manipulation |
| **Fibonacci Numbers** | `0, 1, 1, 2, 3, 5...` | $F(n) = F(n-1) + F(n-2)$ | Dynamic Programming, Recursion |
| **Palindrome Numbers**| `121, 1331, 12321` | $N == \text{Reverse}(N)$ | String/Number manipulation |
| **Armstrong Numbers** | `153, 370, 371...` | $\sum (\text{digit})^k = N$ | Basic digit extraction practice |

---

## 🧠 Quick Interview Revision Snippets

### 1. Digit Extraction Pattern
Used in digit counting, digit sum, number reversal, and palindrome checks.

```java
int temp = Math.abs(num);
while (temp > 0) {
    int digit = temp % 10;   // Extract rightmost digit
    // Process digit (e.g. sum += digit, rev = rev * 10 + digit, count++)
    temp /= 10;              // Drop rightmost digit
}
```
- **Formula for total digits**: `(int) Math.floor(Math.log10(num)) + 1`
- **Implementations**: 
  - [P06_NumberOfDigits.java](./P06_NumberOfDigits.java)
  - [P07_PalindromeCheck.java](./P07_PalindromeCheck.java)
  - [P11_ReverseNumber.java](./P11_ReverseNumber.java)
  - [P12_SumOfNumbers.java](./P12_SumOfNumbers.java)

---

### 2. Prime Number Check ($O(\sqrt{N})$)
Factors always occur in pairs $(d, \frac{N}{d})$. If no factor exists $\le \sqrt{N}$, the number is prime.

```java
public static boolean checkPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++) { // Loop up to √N
        if (n % i == 0) return false;
    }
    return true;
}
```
- **Key Facts**: $2$ is the only even prime. $0$ and $1$ are not prime.
- **Sieve of Eratosthenes Complexity**: $O(N \log \log N)$ time, $O(N)$ space for finding all primes up to $N$.
- **Implementation**: [P08_PrimeNumber.java](./P08_PrimeNumber.java)

---

### 3. GCD & LCM (Euclidean Algorithm)
- **Euclidean Algorithm**: $\text{GCD}(A, B) = \text{GCD}(B, A \bmod B)$ until $B = 0$.
- **Fundamental Identity**: $\text{GCD}(A, B) \times \text{LCM}(A, B) = A \times B$

```java
// Euclidean GCD (O(log(min(A,B))))
public static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// LCM using GCD (O(log(min(A,B))))
public static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}
```
- **Implementations**: 
  - [P04_GCDOfNumber.java](./P04_GCDOfNumber.java)
  - [P05_LCM.java](./P05_LCM.java)

---

### 4. Factorial & Combinatorics
- **Factorial**: $N! = N \times (N-1) \times \dots \times 1$; $0! = 1$.
- **Time Complexity**: $O(N)$ | **Space Complexity**: $O(1)$
- **Implementation**: [P03_Factorial.java](./P03_Factorial.java)
