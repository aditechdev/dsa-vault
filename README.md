# ⚡ DSA Vault (Java Data Structures & Algorithms)

A curated, highly organized Java repository containing Data Structure and Algorithm implementations, mathematical problem-solving techniques, pattern problems, and searching algorithms. Structured for efficient revision and tailored for technical interview preparation.

---

## 📁 Repository Structure

```
dsa-vault/
└── src/
    ├── basic/
    │   ├── BigIntDemo.java
    │   ├── NormalBasicProblem.java
    │   ├── algorithm/
    │   │   ├── FactorialPMI.java
    │   │   ├── FibonacciSeries.java
    │   │   ├── GcdEuclideanAlgorithm.java
    │   │   └── PrintNNumbers.java
    │   ├── array/
    │   │   ├── ArrayDemo.java
    │   │   ├── BinaryToDecimal.java
    │   │   ├── InsertArray.java
    │   │   ├── PassByValue.java
    │   │   └── TwoDArrayDemo.java
    │   ├── arrayList/
    │   │   ├── ArrayListDemo.java
    │   │   └── LexicographicOrder.java
    │   ├── math/
    │   │   ├── LCM.java
    │   │   └── normal_problem/
    │   │       ├── AreaOfCircle.java
    │   │       ├── CheckVowel.java
    │   │       ├── Digits.java
    │   │       ├── NumberOfDigits.java
    │   │       ├── PalindromeCheck.java
    │   │       ├── PrimeNumberRange.java
    │   │       ├── PrintPrimeByMethod.java
    │   │       ├── PrintTable.java
    │   │       ├── RandomDemo.java
    │   │       └── ReverseNumber.java
    │   ├── pattern/
    │   │   ├── FullNumericPyramid.java
    │   │   ├── FullPyramid.java
    │   │   ├── HalfDiamond.java
    │   │   ├── HalfPyramid.java
    │   │   ├── HourGlass.java
    │   │   └── ReverseTrianglePattern.java
    │   ├── problems/
    │   │   └── LittlePonyProblem.java
    │   ├── string/
    │   │   ├── PlayWithString.java
    │   │   ├── StringBuilderDemo.java
    │   │   └── StringDemo.java
    │   └── twodarray/
    │       ├── PascalsTriangle2D.java
    │       ├── TwoDArrayPractice.java
    │       └── WaveTraversal.java
    └── intermediate/
        └── problems/
            ├── PrimeNumber.java
            └── SquareRoot.java
```

---

## 🚀 Key Topics & Complexity Reference

| Module | Algorithm / Topic | Time Complexity | Space Complexity |
| :--- | :--- | :---: | :---: |
| **Algorithms** | Euclidean GCD | $O(\log(\min(A, B)))$ | $O(\log(\min(A, B)))$ |
| **Algorithms** | Fibonacci Series (Recursion) | $O(2^N)$ | $O(N)$ |
| **Algorithms** | Factorial (PMI Recursion) | $O(N)$ | $O(N)$ |
| **Arrays & Searching** | Binary Search (Iterative & Recursive) | $O(\log N)$ | $O(1)$ / $O(\log N)$ |
| **Arrays & Searching** | Binary Search First/Last Occurrence | $O(\log N)$ | $O(1)$ |
| **Arrays & Searching** | Linear Search | $O(N)$ | $O(1)$ |
| **2D Arrays** | Pascal's Triangle Generator | $O(N^2)$ | $O(N^2)$ |
| **2D Arrays** | Wave Matrix Traversal | $O(N \times M)$ | $O(1)$ |
| **Math** | Prime Number Check ($O(\sqrt{N})$) | $O(\sqrt{N})$ | $O(1)$ |
| **Math** | Square Root via Binary Search | $O(\log N)$ | $O(1)$ |
| **Math** | Palindrome & Reversing Numbers | $O(\log_{10} N)$ | $O(1)$ |

---

## 🛠️ How to Build & Run

### Prerequisites
- **Java Development Kit (JDK 8+)** installed.

### 1. Compile All Files
Run the following command from the root directory to compile all Java source files into an `out/` directory:

```bash
mkdir -p out && javac -d out $(find src -name "*.java")
```

### 2. Execute a Specific Class
Run any class using its fully qualified name:

```bash
# Run Binary Search demonstration
java -cp out basic.array.TwoDArrayDemo

# Run Pascal's Triangle generator
java -cp out basic.twodarray.PascalsTriangle2D

# Run Binary Search Square Root solver
java -cp out intermediate.problems.SquareRoot
```

---

## 📌 Features & Best Practices
- **Clean Naming Conventions**: Strictly adheres to Java standard `PascalCase` class naming and `lowerCamelCase` package/method naming.
- **Robust IO Handling**: Safe Scanner stdin consumption to prevent input exceptions during local execution.
- **Zero Junk Files**: Clean repo history with `.gitignore` handling IDE metadata (`.idea/`), build output (`out/`), and generated HTML docs.

---

## 👤 Author
Developed and maintained by **Aditya Anand**.
- GitHub: [@aditechdev](https://github.com/aditechdev)
