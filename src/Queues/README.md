<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINISHED-<COLOR>.svg)

# Queues

---

Explanation of the Queue Data Structure, its main operations and complexities.

---

## Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Overview

***A queue is a data structure that works like a line of people waiting:***

The first person to arrive is the first to be served. **This is called FIFO:**

FIFO → First In, First Out.

---

## Why Queues:

- Organizes data in a controlled way, respecting the order of arrival.
- Avoids errors where the sequence of processing is important.
- Facilitates scheduling and resource management.
- Used for task scheduling, print spooling, message queuing, BFS traversal, etc.

---

## Operation Complexity

| Operation | Complexity | Type |
|----------------------|--------------|----------------------------------------|
| enqueue(T element) | O(1) or O(n) | Write |
| dequeue() | O(1) or O(n) | Write |
| peek() | O(1) | Read |
| isEmpty() | O(1) | Read |
| isFull() | O(1) | Read |
| contains(T element) | O(n) | Read |
| clear() | O(1) or O(n) | Write |
| list() | O(n) | Read |
| increaseCapacity() | O(n) | Write (For dynamic queues only) |

> ***Complexities vary by implementation. See each section below for details.***

---

## When to Use

**Use Queues when:**

- You need FIFO (First In, First Out) access
- Implementing scheduling or task management
- Processing streams of data in order
- BFS (Breadth-First Search) graph traversal
- Buffering messages or print jobs

**Avoid Queues when:**

- You need LIFO access (use a Stacks)
- You need to access elements in the middle
- Searching for specific elements is frequent
- You need random access by index

---

## Example of Use
```java
// Queue with Dynamic Array
DinamicArrayQueue<String> queue = new DinamicArrayQueue<>();

queue.enqueue("A"); // O(1) - adds to the end
queue.enqueue("B"); // O(1)
String front = queue.peek(); // O(1) - queries without removing
String removed = queue.dequeue(); // O(n) - removes from the front
boolean empty = queue.isEmpty(); // O(1)
```

---

## Implementation Details

### Available Implementations

| Implementation | Structure | Growth | Memory Usage | Usage | Implemented on GitHub |
|---------------|-----------|--------|----------------|-----|---------------------|
| Static Array | Array | ❌ | Medium | Didactic | ✔ |
| Dynamic Array | Array | ✔ | Medium | General | ✔ |
| Circular Array | Array | ❌ | Medium | Efficient | ✔ |
| Singly Linked | Nodes | ✔ | High | Academic | ✔ |
| Priority Queue | Array | ✔ | Medium | Ordered | ✔ |

**Differences between implementations:**
- **Static Array**: Uses `ArrayStructure`, fixed capacity, throws exception on overflow
- **Dynamic Array**: Uses `ArrayStructure` + `increaseCapacity()` for automatic growth, but `dequeue()` is O(n) due to element shifting
- **Circular Array**: Uses `ArrayStructure` with `start` and `end` pointers, avoids element shifting for O(1) enqueue and dequeue
- **Linked Queue (singly linked list)**: Uses `NodeStructure`, dynamic size, but `enqueue()` is O(n) due to tail traversal
- **Priority Queue**: Extends `DinamicArrayQueue`, inserts elements in sorted order using `Comparable`

> ***The difference between implementations is based on the Big O's of each operation. For example, a Circular Queue achieves O(1) enqueue and dequeue by avoiding element shifting, while a Static or Dynamic Array Queue has O(n) dequeue due to the need to shift all remaining elements forward.***

---

### Static Array Queue

A StaticArrayQueue uses a fixed-size array inherited from `ArrayStructure`. Elements are always stored starting at index 0. When an element is dequeued, all remaining elements are shifted one position to the left.

Characteristics:

- Fixed capacity defined at construction
- Throws `RuntimeException` on overflow (enqueue when full)
- Returns `null` on underflow (dequeue or peek when empty)
- `dequeue()` is O(n) due to element shifting

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| enqueue(T element) | O(1) |
| dequeue() | O(n) |
| peek() | O(1) |
| contains(T element) | O(n) |
| clear() | O(n) |
| list() | O(n) |

**Practical Example:**

```java
StaticArrayQueue<Integer> queue = new StaticArrayQueue<>(3);

queue.enqueue(10); // [10]
queue.enqueue(20); // [10, 20]
queue.enqueue(30); // [10, 20, 30]
queue.dequeue();   // returns 10, shifts: [20, 30]
queue.peek();      // returns 20, queue unchanged
queue.enqueue(40); // [20, 30, 40]
```

---

### Dynamic Array Queue

A DinamicArrayQueue uses a resizable array inherited from `ArrayStructure`. It grows automatically when capacity is exceeded via `increaseCapacity()`. Like the static version, dequeue requires shifting all elements.

Characteristics:

- Starts with default capacity, grows as needed
- `enqueue()` is O(1) normally, O(n) when resizing occurs
- `dequeue()` is always O(n) due to element shifting
- `clear()` fills the entire array with `null`

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| enqueue(T element) | O(1) or O(n) |
| dequeue() | O(n) |
| peek() | O(1) |
| contains(T element) | O(n) |
| clear() | O(n) |
| list() | O(n) |

**Practical Example:**

```java
DinamicArrayQueue<String> queue = new DinamicArrayQueue<>();

queue.enqueue("A"); // ["A"]
queue.enqueue("B"); // ["A", "B"]
queue.enqueue("C"); // ["A", "B", "C"]
queue.dequeue();    // returns "A", shifts: ["B", "C"]
queue.peek();       // returns "B"
queue.contains("C"); // true
```

---

### Circular Queue

A CircularQueue uses a fixed-size array with two pointers, `start` and `end`, that wrap around using the modulo operator (`%`). This eliminates the need to shift elements, achieving O(1) for both enqueue and dequeue.

Characteristics:

- Fixed capacity defined at construction
- Uses one extra slot to distinguish full from empty states (`size == length - 1` means full)
- `end` and `start` advance circularly: `pointer = (pointer + 1) % length`
- Throws `RuntimeException` on overflow
- Returns `null` on underflow

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| enqueue(T element) | O(1) |
| dequeue() | O(1) |
| peek() | O(1) |
| isEmpty() | O(1) |
| isFull() | O(1) |
| contains(T element) | O(n) |
| clear() | O(1) |
| list() | O(n) |

**Practical Example:**

```java
CircularQueue<Integer> queue = new CircularQueue<>(4); // capacity 4, usable slots: 3

queue.enqueue(10); // start=0, end=1
queue.enqueue(20); // start=0, end=2
queue.enqueue(30); // start=0, end=3 — FULL
queue.dequeue();   // returns 10, start=1, end=3
queue.enqueue(40); // start=1, end=0 — wraps around
queue.peek();      // returns 20
```

**How the circular wrap works:**

```java
// enqueue: places element at end, then advances end circularly
this.elements[end] = element;
end = (end + 1) % this.elements.length;

// dequeue: reads element at start, then advances start circularly
T removed = this.elements[start];
start = (start + 1) % this.elements.length;
```

---

### Linked Queue

A LinkedQueue uses a singly linked list via `NodeStructure`. Each node holds data and a reference to the next node. The `head` pointer always points to the front of the queue.

Characteristics:

- Dynamic size, no fixed capacity
- `enqueue()` is O(n) because it must traverse the list to find the tail
- `dequeue()` is O(1) because it only reassigns the head pointer
- `clear()` explicitly nullifies each node to assist garbage collection

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| enqueue(T element) | O(n) |
| dequeue() | O(1) |
| peek() | O(1) |
| contains(T element) | O(n) |
| clear() | O(n) |
| list() | O(n) |

**Practical Example:**

```java
LinkedQueue<String> queue = new LinkedQueue<>();

queue.enqueue("X"); // head -> [X]
queue.enqueue("Y"); // head -> [X] -> [Y]
queue.enqueue("Z"); // head -> [X] -> [Y] -> [Z]
queue.dequeue();    // returns "X", head -> [Y] -> [Z]
queue.peek();       // returns "Y"
```

> ***LinkedQueue has O(n) enqueue because there is no tail pointer. To achieve O(1) enqueue, a tail reference would need to be maintained alongside head.***

---

### Priority Queue

A PriorityQueue extends `DinamicArrayQueue` and inserts elements in sorted order using the `Comparable` interface. The front of the queue always holds the element with the lowest value.

Characteristics:

- Extends `DinamicArrayQueue`, inheriting all its operations
- `enqueue()` finds the correct insertion position using a linear scan, then calls `add(i, element)`
- In the literature, priority queues are typically implemented with a Heap for O(log n) enqueue,this implementation uses a sorted array for didactic purposes
- Elements must implement `Comparable`

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| enqueue(T element) | O(n) — linear scan (O(log n) with Heap) |
| dequeue() | O(n) — inherited from DinamicArrayQueue |
| peek() | O(1) |
| contains(T element) | O(n) |
| clear() | O(n) |

**Practical Example:**

```java
PriorityQueue<Integer> queue = new PriorityQueue<>();

queue.enqueue(30); // [30]
queue.enqueue(10); // [10, 30] — inserted before 30
queue.enqueue(20); // [10, 20, 30] — inserted between 10 and 30
queue.dequeue();   // returns 10 — lowest value first
queue.peek();      // returns 20
```

**How the sorted insert works:**

```java
// Finds the first position where element is smaller than the current element
Comparable<T> key = (Comparable<T>) element;
int i;
for (i = 0; i < size; i++) {
    if (key.compareTo(elements[i]) < 0) {
        break;
    }
}
this.add(i, element); // inserts at position i, shifting elements right
```

---