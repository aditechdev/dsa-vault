# 13. Classes and Objects in Java

## 1. What Is a Class?

A **class** is a blueprint used to create objects. It defines the data an object stores and the behavior it can perform.

For example, a `Student` class can define a student's name, age, and a method to display their details.

```java
class Student {
    String name;
    int age;
}
```

Here:
- `Student` is the class name.
- `name` and `age` are fields (instance variables).
- The class defines the structure of a student object.

## 2. What Is an Object?

An **object** is an instance of a class.

We create an object using the `new` keyword.

```java
class Student {
    String name;
    int age;
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.name = "Aditya";
        s1.age = 25;

        System.out.println(s1.name);
        System.out.println(s1.age);
    }
}
```

Output:

```text
Aditya
25
```

### Understanding the code

- `Student s1` declares a reference variable.
- `new Student()` creates a new `Student` object.
- `s1` stores a reference to that object.
- `s1.name` accesses the object's `name` field.
- `s1.age` accesses the object's `age` field.

**Important:** The reference variable and the object are different things.

## 3. Multiple Objects of the Same Class

A single class can be used to create multiple independent objects.

```java
class Student {
    String name;
    int age;
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "Aditya";
        s1.age = 25;

        s2.name = "Rahul";
        s2.age = 22;

        System.out.println(s1.name);
        System.out.println(s2.name);
    }
}
```

Output:

```text
Aditya
Rahul
```

Each object has its own instance fields.

Changing `s1.name` does not change `s2.name` because they refer to different objects.

## 4. Fields / Instance Variables

Fields are variables declared inside a class but outside its methods and constructors.

```java
class Student {
    String name;
    int age;
}
```

Here, `name` and `age` are instance variables.

Every object gets its own copy of each instance variable.

### Default values

When an object is created, its instance fields receive default values if they are not explicitly initialized.

| Data type | Default value |
|---|---|
| `int` | `0` |
| `long` | `0L` |
| `double` | `0.0` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Reference types, including `String` | `null` |

Example:

```java
class Student {
    String name;
    int age;
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();

        System.out.println(s1.name);
        System.out.println(s1.age);
    }
}
```

Output:

```text
null
0
```

These defaults apply to instance fields and static fields. Local variables inside methods do not automatically receive these default values; they must be initialized before use.

## 5. Constructors

A **constructor** initializes an object when it is created.

Constructor rules:
- Its name must match the class name.
- It has no return type, not even `void`.
- It runs when an object is created using `new`.
- It can accept parameters.

Example:

```java
class Student {
    String name;
    int age;

    Student(String studentName, int studentAge) {
        name = studentName;
        age = studentAge;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Aditya", 25);

        System.out.println(s1.name);
        System.out.println(s1.age);
    }
}
```

Output:

```text
Aditya
25
```

The constructor initializes the object's fields during creation.

### Parameterized constructor

A constructor that accepts parameters is called a parameterized constructor.

```java
Student(String studentName, int studentAge) {
    name = studentName;
    age = studentAge;
}
```

The arguments `"Aditya"` and `25` are passed to the constructor when creating the object.

### Default constructor vs no-argument constructor

If you declare no constructor, Java provides an implicit no-argument default constructor.

```java
class Student {
    String name;
}
```

This is valid:

```java
Student s1 = new Student();
```

However, if you declare a parameterized constructor, Java does not automatically provide the no-argument default constructor.

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}
```

Now this is valid:

```java
Student s1 = new Student("Aditya");
```

But this is invalid unless you explicitly add a no-argument constructor:

```java
Student s2 = new Student(); // Compilation error
```

You can define both constructors if needed.

```java
class Student {
    String name;

    Student() {
        name = "Unknown";
    }

    Student(String name) {
        this.name = name;
    }
}
```

## 6. The `this` Keyword

The `this` keyword refers to the current object.

It is commonly used when a constructor parameter has the same name as an instance variable.

```java
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

Understanding:

- `this.name` refers to the current object's instance variable.
- `name` refers to the constructor parameter.
- `this.age` refers to the current object's instance variable.
- `age` refers to the constructor parameter.

Consider:

```java
Student s1 = new Student("Aditya", 25);
```

During construction:
- The parameter `name` contains `"Aditya"`.
- The parameter `age` contains `25`.
- `this.name = name` stores `"Aditya"` in the object's field.
- `this.age = age` stores `25` in the object's field.

**Remember:** `this` refers to the current object, not the class itself.

## 7. Constructor vs Method

A constructor initializes an object. A method defines behavior that an object or class can perform.

| Feature | Constructor | Method |
|---|---|---|
| Name | Must match the class name | Can have any valid method name |
| Return type | No return type | Must declare a return type, including `void` |
| Purpose | Initialize an object | Perform an operation |
| Invocation | Runs during object creation | Called explicitly or by other code |
| Inheritance | Not inherited | Instance methods can be inherited |

Example:

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    void introduce() {
        System.out.println("My name is " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Aditya");
        s1.introduce();
    }
}
```

Output:

```text
My name is Aditya
```

`Student(String name)` initializes the object, while `introduce()` performs an operation.

## 8. Instance Methods

An instance method belongs to an object and can access that object's instance fields.

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    void introduce() {
        System.out.println("Hello, I am " + name);
    }
}
```

Usage:

```java
Student s1 = new Student("Aditya");
Student s2 = new Student("Rahul");

s1.introduce();
s2.introduce();
```

Output:

```text
Hello, I am Aditya
Hello, I am Rahul
```

The same method behaves differently depending on which object calls it.

## 9. `static` vs Instance Fields

An instance field belongs to each object individually. A static field belongs to the class and is shared among its instances.

```java
class Student {
    String name;
    static String school = "ABC School";

    Student(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Aditya");
        Student s2 = new Student("Rahul");

        System.out.println(s1.name);
        System.out.println(s2.name);

        System.out.println(Student.school);
    }
}
```

Output:

```text
Aditya
Rahul
ABC School
```

### Instance field

```java
String name;
```

Each object has its own `name`.

### Static field

```java
static String school = "ABC School";
```

The `school` field is shared by all `Student` objects.

Access a static field using the class name:

```java
Student.school
```

If the static field changes, the updated value is visible through the class and its instances.

**Important:** Prefer accessing static members through the class name rather than an object reference.

## 10. Multiple References to the Same Object

Two reference variables can point to the same object.

```java
class Student {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Aditya";

        Student s2 = s1;
        s2.name = "Rahul";

        System.out.println(s1.name);
        System.out.println(s2.name);
    }
}
```

Output:

```text
Rahul
Rahul
```

Why?

- `new Student()` creates one object.
- `s1` refers to that object.
- `s2 = s1` copies the reference value, not the object.
- Both references point to the same object.
- Updating the object's `name` through `s2` is visible through `s1`.

This is different from creating two objects:

```java
Student s1 = new Student();
Student s2 = new Student();
```

Here, `s1` and `s2` refer to separate objects.

## 11. Class and Object: Complete Example

```java
class Student {
    String name;
    int age;
    static String school = "ABC School";

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("School: " + school);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Aditya", 25);
        Student s2 = new Student("Rahul", 22);

        s1.displayDetails();
        s2.displayDetails();
    }
}
```

Output:

```text
Name: Aditya
Age: 25
School: ABC School
Name: Rahul
Age: 22
School: ABC School
```

This example combines:
- Class and objects
- Instance fields
- A static field
- A parameterized constructor
- The `this` keyword
- Instance methods
- Multiple independent objects

## 12. Key Takeaways

1. A class defines the structure and behavior of its objects.
2. An object is an instance of a class.
3. `new` creates an object.
4. Reference variables hold references to objects.
5. Instance fields belong to individual objects.
6. Static fields are shared at the class level.
7. Constructors initialize objects and have no return type.
8. Java provides an implicit default constructor only when no constructor is declared.
9. `this` refers to the current object.
10. Methods define behavior; constructors initialize objects.
11. Multiple references can point to the same object.
12. Each separately created object has its own instance fields.

## 13. Practice Questions

Try these without looking at the answers.

1. What is the difference between a class and an object?
2. What does `new Student()` do?
3. What is the difference between an instance field and a static field?
4. Why do we use `this.name = name`?
5. Does a constructor have a return type?
6. What happens if you declare a parameterized constructor but no no-argument constructor?
7. What will this print?

   ```java
   class Box {
       int value;
   }

   public class Main {
       public static void main(String[] args) {
           Box b1 = new Box();
           Box b2 = b1;

           b2.value = 10;

           System.out.println(b1.value);
       }
   }
   ```

8. What is the difference between these two statements?

   ```java
   Student s2 = s1;
   ```

   ```java
   Student s2 = new Student();
   ```

---

**Scope note:** These notes cover the Classes and Objects material discussed in this chat. Inheritance, polymorphism, encapsulation, and abstraction are separate OOP topics and are not marked as covered here.