# Prime Number

## Definition

A **Prime Number** is a natural number **greater than 1** that has **exactly two positive factors**:
- **1**
- **The number itself**

A number with more than two factors is called a **Composite Number**.

---

## Examples

| Prime | Composite |
|-------|-----------|
| 2 | 4 |
| 3 | 6 |
| 5 | 8 |
| 7 | 9 |
| 11 | 10 |

---

## Important Points

- **0** is **not** prime.
- **1** is **not** prime.
- **2** is the **smallest** and **only even** prime number.
- Every prime number greater than **2** is odd.

---

## Prime Check Algorithm

1. If `n ≤ 1` → Not Prime.
2. Check divisibility from `2` to `√n`.
3. If any number divides `n`, it is **Composite**.
4. Otherwise, it is **Prime**.

**Time Complexity:** `O(√n)`

---

## Applications in DSA

- Sieve of Eratosthenes
- GCD & LCM
- Modular Arithmetic
- Hashing
- Cryptography
- Number Theory