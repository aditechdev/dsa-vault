# Arrays and 2D Arrays in Java

## 1. What Is an Array?

An array is a data structure that stores multiple values of the same type under a single variable name.

```java
int[] arr = {10, 20, 30, 40};
```

Instead of creating four separate variables, we can store all four values in one array.

### Key Characteristics

- Stores elements of the same type.
- Has a fixed length after creation.
- Uses zero-based indexing.
- Elements can be accessed or updated using their index.
- An array's length is available through the `length` property.

## 2. Declaring and Creating Arrays

### Declaration

```java
int[] arr;
```

Declares a variable that can refer to an integer array.

### Initialization with Values

```java
int[] arr = {10, 20, 30};
```

### Creating an Array with a Specific Size

```java
int[] arr = new int[5];
```

This creates an array of length 5.

For an `int` array, all elements initially contain `0`.

```text
[0, 0, 0, 0, 0]
```

### Default Values

| Type | Default value |
|---|---|
| `int` | `0` |
| `long` | `0L` |
| `double` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Reference types | `null` |

These defaults apply to array elements, not to uninitialized local variables.

## 3. Zero-Based Indexing

Array indexing starts at `0`.

```java
int[] arr = {10, 20, 30, 40};
```

| Index | Value |
|---:|---:|
| 0 | 10 |
| 1 | 20 |
| 2 | 30 |
| 3 | 40 |

Accessing elements:

```java
System.out.println(arr[0]); // 10
System.out.println(arr[2]); // 30
System.out.println(arr[3]); // 40
```

For an array of length `n`, valid indices range from `0` to `n - 1`.

```java
arr[arr.length - 1]; // Last element
```

Accessing an invalid index throws `ArrayIndexOutOfBoundsException`.

## 4. Array Length

Use the `length` property to get the number of elements.

```java
int[] arr = {10, 20, 30};

System.out.println(arr.length); // 3
```

Important: arrays use `length`, not `length()`.

```java
arr.length    // Correct
arr.length()  // Incorrect
```

## 5. Reading and Updating Elements

### Reading

```java
int[] arr = {10, 20, 30};

int x = arr[1];

System.out.println(x); // 20
```

### Updating

```java
int[] arr = {10, 20, 30};

arr[1] = 99;
```

The array becomes:

```text
[10, 99, 30]
```

Updating an element changes the existing array; it does not create a new array.

## 6. Array Traversal

Traversal means visiting array elements one by one.

### Forward Traversal

```java
int[] arr = {10, 20, 30};

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

Output:

```text
10
20
30
```

### Backward Traversal

```java
int[] arr = {10, 20, 30};

for (int i = arr.length - 1; i >= 0; i--) {
    System.out.println(arr[i]);
}
```

Output:

```text
30
20
10
```

### Enhanced For Loop

```java
int[] arr = {10, 20, 30};

for (int value : arr) {
    System.out.println(value);
}
```

Use an enhanced `for` loop when you need to visit every element and do not need its index.

## 7. Common Array Operations

### Calculate the Sum

```java
int[] arr = {2, 4, 6, 8};

int sum = 0;

for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
}

System.out.println(sum); // 20
```

### Find the Maximum

```java
int[] arr = {5, 2, 9, 3};

int max = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
}

System.out.println(max); // 9
```

### Find the Minimum

```java
int[] arr = {5, 2, 9, 3};

int min = arr[0];

for (int i = 1; i < arr.length; i++) {
    if (arr[i] < min) {
        min = arr[i];
    }
}

System.out.println(min); // 2
```

These examples assume the array is non-empty.

### Count Elements Matching a Condition

Count even numbers:

```java
int[] arr = {1, 2, 4, 7, 8};

int count = 0;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] % 2 == 0) {
        count++;
    }
}

System.out.println(count); // 3
```

### Linear Search

Linear search checks elements one by one until the target is found.

```java
int[] arr = {10, 20, 30, 40};
int target = 30;

int index = -1;

for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        index = i;
        break;
    }
}

System.out.println(index); // 2
```

Here, `-1` means the target was not found.

Time complexity: `O(n)` in the worst case.

### Reverse an Array In Place

Use two pointers: one at the beginning and one at the end.

```java
int[] arr = {10, 20, 30, 40};

int left = 0;
int right = arr.length - 1;

while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;

    left++;
    right--;
}
```

Result:

```text
[40, 30, 20, 10]
```

Time complexity: `O(n)`.

Auxiliary space: `O(1)`.

## 8. Two-Pointer Basics

The two-pointer technique uses two indices to process an array.

Common arrangements include:

- One pointer at the beginning and one at the end.
- Two pointers moving forward at different speeds.
- Two pointers maintaining a range or window.

Example: reversing an array.

```java
int left = 0;
int right = arr.length - 1;
```

The pointers move toward each other until `left >= right`.

Two pointers are a problem-solving technique, not a separate Java data type.

## 9. Array Reference and Copying Basics

An array variable holds a reference to an array object.

```java
int[] a = {1, 2, 3};
int[] b = a;

b[0] = 99;
```

Now both `a[0]` and `b[0]` are `99`, because both variables refer to the same array.

To create a copy:

```java
import java.util.Arrays;

int[] a = {1, 2, 3};
int[] b = Arrays.copyOf(a, a.length);
```

Now `b` is a separate array.

## 10. What Is a 2D Array?

A 2D array is an array whose elements are themselves arrays.

It is commonly used to represent tables, grids, and matrices.

```java
int[][] matrix = {
    {10, 20, 30},
    {40, 50, 60}
};
```

Visualization:

```text
         Columns
          0   1   2
        +---+---+---+
Row 0   | 10| 20| 30|
        +---+---+---+
Row 1   | 40| 50| 60|
        +---+---+---+
```

This array contains 2 rows and 3 columns.

## 11. Creating a 2D Array

### Initialize with Values

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

### Create with a Fixed Size

```java
int[][] matrix = new int[3][4];
```

This creates 3 rows, each containing 4 integer elements.

All elements initially contain `0`.

Total elements:

```text
3 × 4 = 12
```

## 12. 2D Array Indexing

The first index identifies the row. The second identifies the column.

```java
matrix[row][column]
```

Example:

```java
int[][] matrix = {
    {10, 20, 30},
    {40, 50, 60}
};

System.out.println(matrix[0][0]); // 10
System.out.println(matrix[0][2]); // 30
System.out.println(matrix[1][0]); // 40
System.out.println(matrix[1][2]); // 60
```

Remember that indices start at `0`.

Therefore, `matrix[1][2]` means the second row and third column.

## 13. Updating a 2D Array

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

matrix[0][2] = 100;
```

Result:

```text
1   2   100
4   5     6
```

Only the element at row `0`, column `2` changes.

## 14. Understanding 2D Array Length

For a 2D array:

```java
int[][] matrix = new int[3][5];
```

- `matrix.length` gives the number of rows.
- `matrix[i].length` gives the number of elements in row `i`.

```java
matrix.length       // 3
matrix[0].length    // 5
matrix[1].length    // 5
```

For this rectangular array:

```text
Rows    = 3
Columns = 5
Elements = 3 × 5 = 15
```

Do not confuse the number of rows with the total number of elements.

## 15. Traversing a 2D Array

Use nested loops: the outer loop visits rows, and the inner loop visits columns.

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.println(matrix[i][j]);
    }
}
```

Traversal order:

```text
1
2
3
4
5
6
```

The variables conventionally mean:

- `i`: row index
- `j`: column index

Using `matrix[i].length` makes the loop work even when rows have different lengths.

## 16. Sum of All 2D Array Elements

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

int sum = 0;

for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        sum += matrix[i][j];
    }
}

System.out.println(sum); // 21
```

The algorithm visits every element exactly once.

For an `R × C` rectangular matrix, time complexity is `O(R × C)`.

## 17. Maximum and Minimum in a 2D Array

### Maximum

```java
int[][] matrix = {
    {5, 2, 8},
    {1, 9, 3}
};

int max = matrix[0][0];

for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] > max) {
            max = matrix[i][j];
        }
    }
}

System.out.println(max); // 9
```

### Minimum

```java
int[][] matrix = {
    {5, 2, 8},
    {1, 9, 3}
};

int min = matrix[0][0];

for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] < min) {
            min = matrix[i][j];
        }
    }
}

System.out.println(min); // 1
```

These examples assume the matrix contains at least one element.

## 18. Jagged Arrays

Java allows each row of a 2D array to have a different length. Such an array is called a jagged array.

```java
int[][] matrix = {
    {10, 20},
    {30, 40, 50},
    {60}
};
```

Row lengths:

```java
matrix.length       // 3
matrix[0].length    // 2
matrix[1].length    // 3
matrix[2].length    // 1
```

Visualization:

```text
Row 0 → 10 20
Row 1 → 30 40 50
Row 2 → 60
```

A rectangular array is a special case where all rows have the same length.

## 19. Why Use `matrix[i].length`?

Correct traversal:

```java
for (int i = 0; i < matrix.length; i++) {
    for (int j = 0; j < matrix[i].length; j++) {
        System.out.println(matrix[i][j]);
    }
}
```

This handles both rectangular and jagged arrays.

Using `matrix[0].length` assumes every row has the same length and may skip elements or cause an invalid-index error for jagged arrays.

## 20. Common Mistakes

1. Using `<= arr.length` instead of `< arr.length`.
2. Forgetting that array indices start at `0`.
3. Confusing `arr.length` with the last valid index.
4. Confusing `matrix.length` with the total number of elements.
5. Reversing row and column indices.
6. Using `matrix[0].length` when traversing jagged arrays.
7. Assuming an array is automatically copied when assigning it to another variable.
8. Accessing an array before checking that the index is valid.
9. Initializing maximum or minimum to `0` when all values might be negative or positive, respectively. Prefer the first element when the array is non-empty.

## 21. Time Complexity Summary

Let `n` be the number of elements in a 1D array, and let `R` and `C` be the number of rows and columns in a rectangular 2D array.

| Operation | Time complexity |
|---|---|
| Access by index | `O(1)` |
| Update by index | `O(1)` |
| Traverse a 1D array | `O(n)` |
| Linear search | `O(n)` worst case |
| Reverse a 1D array | `O(n)` |
| Traverse a 2D array | `O(R × C)` |
| Sum a 2D array | `O(R × C)` |
| Find max/min in a 2D array | `O(R × C)` |

These are algorithmic time complexities, not guarantees about exact execution time.

## 22. Practice Exercises

### 1D Arrays

- Print all elements forward and backward.
- Calculate the sum and average.
- Find the maximum and minimum.
- Count even and odd elements.
- Search for a target using linear search.
- Reverse an array in place.
- Copy an array and modify the copy without changing the original.

### 2D Arrays

- Print every element row by row.
- Calculate the sum of all elements.
- Find the maximum and minimum.
- Count even elements.
- Calculate the sum of each row.
- Calculate the sum of each column in a rectangular matrix.
- Update an element using its row and column indices.
- Traverse a jagged array without accessing invalid indices.

## Key Takeaways

- Arrays store multiple values of the same type.
- Indexing starts at `0`.
- Array length is fixed after creation.
- `arr.length` gives the number of elements.
- A 2D array is an array of arrays.
- `matrix[row][column]` accesses a 2D element.
- `matrix.length` gives the number of rows.
- `matrix[i].length` gives the length of a particular row.
- Nested loops are the standard approach for traversing 2D arrays.
- Jagged arrays can have rows of different lengths.
- Basic array problems build the foundation for more advanced DSA patterns.
