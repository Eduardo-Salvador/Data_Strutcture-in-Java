<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINISHED-<COLOR>.svg)

# Stacks

---

Explanation of the Stack Data Structure, its main operations and complexities.

---

## Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Overview

***A stack is a data structure that works like a stack of plates, or boxes:***

You place one box on top of another and can only remove the top one first. **This is called LIFO:**

LIFO → Last In, First Out.

--- 

## Why Stacks:

- Organizes data in a controlled way, with access only to the top.
- Avoids errors where the order of execution is important.
- Facilitates memory management and function calls.
- Used for recursive calls, function calls, API calls, etc.

---

## Operation Complexity

| Operation | Complexity | Type |
|----------------------|--------------|----------------------------------------|
| push(E element) | O(1) | Write |
| pop() | O(1) | Write |
| peek() | O(1) | Read |
| isEmpty() | O(1) | Write |
| size() | O(1) | Write |
| search(E element) | O(n) | Write |
| increaseCapacity() | O(n) | Read (For dynamic stacks only) |

---

## When to Use

**Use Stacks when:**

- You need LIFO (Last In, First Out) access
- Implementing recursion or backtracking
- Undoing operations
- Evaluating mathematical expressions
- Browsing history

**Avoid Stacks when:**

- You need to access elements in the middle
- You need FIFO access (use a Queue)
- Searching for specific elements is frequent
- You need random access by index

---

## Example of Use
```java
// Stack with Dynamic Array
Stack<String> stack = new Stack<>();

stack.push("A"); // O(1) - adds to the top
stack.push("B"); // O(1)
String top = stack.peek(); // O(1) - queries without removing
String removed = stack.pop(); // O(1) - removes from the top
boolean empty = stack.isEmpty(); // O(1)

```

---

## Implementation Details

### Available Implementations

| Implementation | Structure | Growth | Memory Usage | Usage | Implemented on GitHub |
|---------------|-----------|--------|----------------|-----|---------------------|
| Static Array | Array | ❌ | Medium | Didactic | ✔ |
| Dynamic Array | Array | ✔ | Medium | General | ✔ |
| Singly Linked | Nodes | ✔ | High | Academic | ✔ |
| Call Stack | JVM | ✔ | JVM | Conceptual | N/A |

**Differences between implementations:**
- **Fixed Array**: Uses `ArrayStructure`, requires a `top` (or `size`) variable, no resizing
- **Dynamic Array**: Uses `ArrayStructure` + `increaseCapacity()` for automatic growth
- **Linked Stack (singly linked list)**: Uses `NodeStructure`, more flexible but complex (pointers)
> ***The difference between implementations is based on the Big O's of each operation. For example, accessing a linked list has greater complexity than accessing a static or dynamic array.***

---

### Call Stack

A Call Stack is a fundamental data structure that the JVM uses to manage the execution of methods in a Java program.

Characteristics:

- Each thread has its own private Call Stack
- Created simultaneously with the thread

Structure of a Stack Frame:

When a method is invoked, the JVM creates a stack frame containing:
- Local variables of the method
- Received parameters
- Return value (when applicable)
- Reference to the calling method
- Operand stack (stack of operands for intermediate calculations)

This frame is pushed on top of the Call Stack. When the method finishes, the frame is popped from the stack and control returns to the calling method.

**Practical Example:**

```java
public class ExemploCallStack {

public static void main(String[] args) {
    methodA();
}

static void methodA() {
    methodB();
}

static void methodB() {
    methodC();
}

static void methodC() {
// Here the stack is: main -> methodA -> methodB -> methodC
    throw new RuntimeException("Error!");
    }
}
```

When you see the **stack trace** of an exception, you are literally seeing the contents of the Call Stack at the moment of the error, from bottom to top.

#### StackOverflowError

If there are many recursive calls or an infinite recursion, the Call Stack reaches its size limit and the JVM throws a `StackOverflowError`.

**Configuration:** The stack size can be adjusted with the `-Xss` flag in the JVM.

```java
// Example that causes StackOverflowError
public static void infiniteRecursion() {
    infiniteRecursion(); // Never returns!
}
```

---