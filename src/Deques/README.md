<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINISHED-<COLOR>.svg)

# Deques

---

Explanation of the Deque Data Structure, its main operations and complexities.

---

## Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Overview

***A deque (Double-Ended Queue) is a data structure that allows insertion and removal at both ends:***

Unlike a queue, which only allows enqueue at the back and dequeue at the front, a deque gives full access to both extremes. **It generalizes both stacks and queues:**

Deque → Double-Ended Queue (insert and remove from front or back).

---

## Why Deques:

- Combines the behaviors of a Stack (LIFO) and a Queue (FIFO) in a single structure.
- Allows insertion and removal at both ends in O(1).
- Useful for sliding window algorithms, palindrome checking, and task scheduling.
- Used as the underlying structure for undo/redo systems, browser navigation, and deque-based BFS.

---

## Operation Complexity

| Operation | Complexity | Type |
|----------------------|--------------|----------------------------------------|
| addFirst(T element) | O(1) | Write |
| addLast(T element) | O(1) | Write |
| removeFirst() | O(1) | Write |
| removeLast() | O(1) | Write |
| getFirst() | O(1) | Read |
| getLast() | O(1) | Read |
| peekFirst() | O(1) | Read |
| peekLast() | O(1) | Read |
| contains(T element) | O(n) | Read |
| clear() | O(1) | Write |

> ***All primary operations are O(1) across both implementations. The only exception is contains(), which requires full traversal in both cases.***

---

## When to Use

**Use Deques when:**

- You need O(1) insertion and removal at both ends
- Implementing a sliding window or monotonic deque
- Building an undo/redo system
- Simulating both stack and queue behavior with a single structure
- Implementing palindrome checking or deque-based BFS

**Avoid Deques when:**

- You only need single-ended access (use a Stack or Queue)
- You need access by index (use a List)
- You need sorted access (use a Priority Queue or Tree)

---

## Example of Use
```java
// Circular Array Deque
CircularArrayDeque<String> deque = new CircularArrayDeque<>(5);

deque.addFirst("B"); // [B]
deque.addFirst("A"); // [A, B]
deque.addLast("C");  // [A, B, C]
String front = deque.peekFirst(); // "A" — no removal
String back = deque.peekLast();   // "C" — no removal
deque.removeFirst(); // returns "A" → [B, C]
deque.removeLast();  // returns "C" → [B]
```

---

## Implementation Details

### Available Implementations

| Implementation | Structure | Growth | Memory Usage | Usage | Implemented on GitHub |
|---------------|-----------|--------|----------------|-----|---------------------|
| Circular Array | Array | ❌ | Medium | Efficient | ✔ |
| Doubly Linked List | Nodes | ✔ | High | General | ✔ |

**Differences between implementations:**
- **Circular Array**: Uses `ArrayStructure` with `start` and `end` pointers that wrap around using the modulo operator, fixed capacity, O(1) for all primary operations with no shifting
- **Doubly Linked List**: Uses `NodeStructure` with `start` and `end` node pointers and bidirectional links, dynamic size, O(1) for all primary operations via direct pointer reassignment

> ***Both implementations achieve O(1) for addFirst, addLast, removeFirst, and removeLast. The structural difference is capacity: the circular array is bounded and throws on overflow, while the doubly linked list grows dynamically with no upper limit.***

---

### Circular Array Deque

A CircularArrayDeque uses a fixed-size array inherited from `ArrayStructure` with two pointers, `start` and `end`, that advance circularly using the modulo operator. `addFirst` moves `start` backward and `addLast` moves `end` forward, both without shifting any elements.

Characteristics:

- Fixed capacity defined at construction
- Throws `RuntimeException` on overflow (addFirst or addLast when full)
- Returns `null` on underflow (removeFirst or removeLast when empty)
- `getFirst()` and `getLast()` throw `NoSuchElementException` when empty; `peekFirst()` and `peekLast()` return `null` instead
- `clear()` is O(1) — only resets `start`, `end`, and `size`

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| addFirst(T element) | O(1) |
| addLast(T element) | O(1) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| getFirst() | O(1) |
| getLast() | O(1) |
| peekFirst() | O(1) |
| peekLast() | O(1) |
| contains(T element) | O(n) |
| clear() | O(1) |

**Practical Example:**

```java
CircularArrayDeque<Integer> deque = new CircularArrayDeque<>(5);

deque.addLast(10);   // end=1, [10]
deque.addLast(20);   // end=2, [10, 20]
deque.addFirst(5);   // start wraps: start=4, [_, _, 10, 20, 5] logically [5, 10, 20]
deque.removeLast();  // returns 20, end=1
deque.removeFirst(); // returns 5, start=0
deque.peekFirst();   // returns 10, deque unchanged
```

**How the circular wrap works for addFirst:**

```java
// addFirst: moves start one position backward circularly, then places element
start = (start - 1 + this.elements.length) % this.elements.length;
this.elements[start] = element;

// addLast: places element at end, then moves end one position forward
this.elements[end] = element;
end = (end + 1) % this.elements.length;

// getLast: accesses the slot just before end, wrapping if necessary
return this.elements[(end - 1 + this.elements.length) % this.elements.length];
```

---

### Doubly Linked List Deque

A DoublyLinkedListDeque uses a doubly linked list via `NodeStructure`. Each node holds data and references to both the previous and previous nodes. The `start` and `end` pointers always reference the front and back nodes respectively, enabling O(1) operations at both ends without any traversal.

Characteristics:

- Dynamic size with no fixed capacity
- `addFirst()` and `addLast()` reassign only the relevant boundary pointer and update one adjacent link
- `removeFirst()` and `removeLast()` reassign the boundary pointer and null out the dangling reference
- When size equals 1, both `start` and `end` point to the same node; removal sets both to `null`
- `getFirst()` and `getLast()` throw `NoSuchElementException` when empty; `peekFirst()` and `peekLast()` return `null` instead
- `clear()` is O(1) — nullifying `start` and `end` releases all nodes to garbage collection

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| addFirst(T element) | O(1) |
| addLast(T element) | O(1) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| getFirst() | O(1) |
| getLast() | O(1) |
| peekFirst() | O(1) |
| peekLast() | O(1) |
| contains(T element) | O(n) |
| clear() | O(1) |

**Practical Example:**

```java
DoublyLinkedListDeque<String> deque = new DoublyLinkedListDeque<>();

deque.addFirst("B"); // start=[B]=end
deque.addFirst("A"); // start=[A]<->[B]=end
deque.addLast("C");  // start=[A]<->[B]<->[C]=end
deque.getFirst();    // returns "A"
deque.getLast();     // returns "C"
deque.removeLast();  // returns "C", end=[B]
deque.removeFirst(); // returns "A", start=[B]=end
```

**How addFirst and addLast manage boundary pointers:**

```java
// addFirst: new node's previous points to old start, old start's previous points back
start.setPrevious(newNode);
newNode.setNext(start);
start = newNode;

// addLast: old end's previous points to new node, new node's previous points back
end.setNext(newNode);
newNode.setPrevious(end);
end = newNode;

// removeLast: end moves one step back, its previous reference is nulled
end = end.getPrevious();
end.setNext(null);
```

---