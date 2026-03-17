<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINISHED-<COLOR>.svg)

# Lists

---

Explanation of the List Data Structure, its main operations and complexities.

---

## Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Overview

***A list is a data structure that stores elements in a sequential and ordered manner:***

Unlike stacks and queues, lists allow insertion, removal, and access at any position. **There is no single access rule**, elements can be reached by index or by traversal.

---

## Why Lists:

- Organizes data with flexible access to any position.
- Supports insertion and removal at the beginning, middle, or end.
- Serves as the foundation for higher-level structures such as stacks, queues, and deques.
- Used for ordered collections, iterators, history management, and general-purpose storage.

---

## Operation Complexity

| Operation | Complexity | Type |
|----------------------|--------------|----------------------------------------|
| add(T element) | O(1) or O(n) | Write |
| add(int index, T element) | O(n) | Write |
| addFirst(T element) | O(1) or O(n) | Write |
| addLast(T element) | O(1) or O(n) | Write |
| get(int index) | O(1) or O(n) | Read |
| set(int index, T element) | O(n) | Write |
| remove(int index) | O(n) | Write |
| remove(T element) | O(n) | Write |
| removeFirst() | O(1) | Write |
| removeLast() | O(1) or O(n) | Write |
| contains(T element) | O(n) | Read |
| indexOf(T element) | O(n) | Read |
| clear() | O(1) or O(n) | Write |
| toArray() | O(n) | Read |
| increaseCapacity() | O(n) | Write (For ArrayList only) |

> ***Complexities vary by implementation. See each section below for details.***

---

## When to Use

**Use Lists when:**

- You need flexible access to elements by index or position
- Insertion and removal can happen at any point
- Implementing iterators, history, or ordered collections
- Building higher-level structures on top of a sequential container

**Avoid Lists when:**

- You only need LIFO access (use a Stacks)
- You only need FIFO access (use a Queue)
- You need constant-time search by key (use a Map or Set)
- You need sorted access with O(log n) search (use a Tree)

---

## Example of Use
```java
// ArrayList
ArrayList<String> list = new ArrayList<>();

list.add("A");           // O(1) - appends to the end
list.add(0, "Z");        // O(n) - inserts at index 0
String value = list.get(1); // O(1) - direct access by index
list.remove(0);          // O(n) - removes and shifts elements
boolean found = list.contains("A"); // O(n)
```

---

## Implementation Details

### Available Implementations

| Implementation | Structure | Growth | Bidirectional | Circular | Memory Usage | Implemented on GitHub |
|---------------|-----------|--------|---------------|----------|--------------|---------------------|
| ArrayList | Array | ✔ | ❌ | ❌ | Medium | ✔ |
| LinkedList | Nodes | ✔ | ❌ | ❌ | High | ✔ |
| DoublyLinkedList | Nodes | ✔ | ✔ | ❌ | High | ✔ |
| LinkedCircularList | Nodes | ✔ | ❌ | ✔ | High | ✔ |
| DoublyLinkedCircularList | Nodes | ✔ | ✔ | ✔ | High | ✔ |

**Differences between implementations:**
- **ArrayList**: Uses `ArrayStructure` with automatic resizing via `increaseCapacity()`, provides O(1) access by index but O(n) insertion and removal in the middle
- **LinkedList**: Uses `NodeStructure` with a single `head` pointer, O(1) addFirst but O(n) addLast and get due to full traversal
- **DoublyLinkedList**: Uses `NodeStructure` with `head` and `last` pointers and bidirectional node links, enables optimized traversal from either end and O(1) removeLast
- **LinkedCircularList**: Singly linked with `head` and `tail` pointers where the last node points back to head, enabling O(1) addFirst and addLast
- **DoublyLinkedCircularList**: Doubly linked and circular, combining bidirectional traversal with circular wrap; both head and tail are maintained

> ***The difference between implementations is based on the Big O's of each operation. For example, ArrayList provides O(1) random access while linked implementations require O(n) traversal to reach an element by index.***

---

### ArrayList

An ArrayList uses a resizable array inherited from `ArrayStructure`. It provides constant-time access by index and amortized O(1) appends. Insertions and removals in the middle require shifting elements.

Characteristics:

- Grows automatically via `increaseCapacity()` when capacity is exceeded
- `get()` and `set()` are O(1) due to direct index access
- `remove(int index)` and `add(int index, element)` are O(n) due to element shifting
- `resize(int newCapacity)` allows manual capacity adjustment
- `clear()` iterates through the array setting each slot to `null`

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| add(T element) | O(1) or O(n) |
| add(int index, T element) | O(n) |
| get(int index) | O(1) |
| set(int index, T element) | O(1) |
| remove(int index) | O(n) |
| remove(T element) | O(n) |
| removeFirst() | O(n) |
| removeLast() | O(1) |
| contains(T element) | O(n) |
| indexOf(T element) | O(n) |
| clear() | O(n) |

**Practical Example:**

```java
ArrayList<Integer> list = new ArrayList<>(3);

list.add(10);        // [10]
list.add(20);        // [10, 20]
list.add(30);        // [10, 20, 30]
list.add(1, 15);     // [10, 15, 20, 30] — shifts right from index 1
list.get(2);         // returns 20
list.remove(0);      // returns 10, shifts: [15, 20, 30]
list.removeLast();   // returns 30, no shifting: [15, 20]
```

---

### LinkedList

A LinkedList uses a singly linked list via `NodeStructure`. Each node holds data and a reference to the previous node. Only a `head` pointer is maintained, requiring full traversal to reach the end.

Characteristics:

- Dynamic size with no fixed capacity
- `addFirst()` is O(1), reassigns head only
- `addLast()` is O(n),must traverse to the last node
- `get(int index)` is O(n),no direct access, requires traversal
- `remove(T element)` traverses from head, handling the case where the target is head separately

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| add(int index, T element) | O(n) |
| addFirst(T element) | O(1) |
| addLast(T element) | O(n) |
| get(int index) | O(n) |
| set(int index, T element) | O(n) |
| remove(int index) | O(n) |
| remove(T element) | O(n) |
| contains(T element) | O(n) |
| indexOf(T element) | O(n) |
| clear() | O(1) |

**Practical Example:**

```java
LinkedList<String> list = new LinkedList<>();

list.addFirst("B"); // head -> [B]
list.addFirst("A"); // head -> [A] -> [B]
list.addLast("C");  // head -> [A] -> [B] -> [C]
list.get(1);        // returns "B" — traverses from head
list.remove("B");   // head -> [A] -> [C]
list.remove(0);     // returns "A", head -> [C]
```

> ***LinkedList has no tail pointer, making addLast O(n). To achieve O(1) addLast, a tail reference must be maintained alongside head, as done in LinkedCircularList.***

---

### DoublyLinkedList

A DoublyLinkedList uses a doubly linked list via `NodeStructure`. Each node holds references to both the previous and previous nodes. Both `head` and `last` pointers are maintained, enabling traversal from either end and O(1) access to both extremes.

Characteristics:

- `addFirst()` and `addLast()` (via `add()`) are O(1)
- `removeLast()` is O(1) because `last.getPrevious()` is directly accessible
- `add(int index, element)` and `remove(int index)` optimize traversal direction: if index is in the first half, traversal starts from head; if in the second half, from last
- `removeFirstOccurrence()` and `removeLastOccurrence()` traverse from head and last respectively

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| add(T element) | O(1) |
| add(int index, T element) | O(n) |
| addFirst(T element) | O(1) |
| addLast(T element) | O(1) |
| get(int index) | O(n) |
| set(int index, T element) | O(n) |
| remove(int index) | O(n) |
| remove(T element) | O(n) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| removeFirstOccurrence(T element) | O(n) |
| removeLastOccurrence(T element) | O(n) |
| contains(T element) | O(n) |
| indexOf(T element) | O(n) |
| lastIndexOf(T element) | O(n) |
| clear() | O(1) |

**Practical Example:**

```java
DoublyLinkedList<String> list = new DoublyLinkedList<>();

list.add("B");       // head -> [B] <- last
list.addFirst("A");  // head -> [A] <-> [B] <- last
list.addLast("C");   // head -> [A] <-> [B] <-> [C] <- last
list.get(1);         // returns "B"
list.removeLast();   // returns "C", O(1) via last.getPrevious()
list.removeFirst();  // returns "A", O(1) via head.getPrevious()
```

**How bidirectional traversal optimization works:**

```java
// For index in the first half: traverse from head
if (index <= this.size / 2) {
    current = head;
    for (int i = 0; i < index; i++) current = current.getNext();
} else {
    // For index in the second half: traverse from last
    current = last;
    for (int i = this.size - 1; i > index; i--) current = current.getPrevious();
}
```

---

### LinkedCircularList

A LinkedCircularList uses a singly linked circular list via `NodeStructure`. Both `head` and `tail` pointers are maintained. The last node always points back to `head`, forming a closed circle.

Characteristics:

- `addFirst()` and `addLast()` are O(1), tail pointer eliminates end traversal
- `removeLast()` is O(n), no previous pointer, requires traversal to find the second-to-last node
- Traversal uses `do-while (current != head)` to iterate over the circular structure without an explicit null sentinel
- `clear()` is O(1), nullifying head and tail breaks the circle

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| add(int index, T element) | O(n) |
| addFirst(T element) | O(1) |
| addLast(T element) | O(1) |
| get(int index) | O(n) |
| set(int index, T element) | O(n) |
| remove(int index) | O(n) |
| remove(T element) | O(n) |
| removeFirst() | O(1) |
| removeLast() | O(n) |
| contains(T element) | O(n) |
| indexOf(T element) | O(n) |
| clear() | O(1) |

**Practical Example:**

```java
LinkedCircularList<String> list = new LinkedCircularList<>();

list.addFirst("B"); // tail -> [B] -> [B] (points to itself)
list.addFirst("A"); // head=[A], tail=[B], [B]->head
list.addLast("C");  // head=[A], tail=[C], [C]->head
list.get(1);        // returns "B" — traversal from head
list.removeFirst(); // returns "A", head=[B], [C]->[B]
list.removeLast();  // returns "C" — O(n), traverses to find new tail
```

**How circular linking is maintained:**

```java
// addFirst: new node points to old head, tail updates its previous to new head
newNode.setNext(head);
head = newNode;
tail.setNext(head); // tail always points to the current head

// addLast: new node points to head, old tail links to new node
newNode.setNext(head);
tail.setNext(newNode);
tail = newNode;
```

---

### DoublyLinkedCircularList

A DoublyLinkedCircularList uses a doubly linked circular list via `NodeStructure`. Both `head` and `tail` pointers are maintained. Every node has both previous and previous references, and the structure forms a closed circle in both directions.

Characteristics:

- `addFirst()` and `addLast()` are O(1)
- `removeFirst()` and `removeLast()` are O(1), both head and tail pointers are updated, and circular links are maintained
- `removeLast()` does not require traversal because `tail.getPrevious()` is directly accessible
- Traversal uses `do-while (current != head)` to iterate circularly
- `clear()` is O(1), nullifying head and tail breaks all circular references

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| add(int index, T element) | O(n) |
| addFirst(T element) | O(1) |
| addLast(T element) | O(1) |
| get(int index) | O(n) |
| set(int index, T element) | O(n) |
| remove(int index) | O(1) for head/tail, O(n) otherwise |
| remove(T element) | O(n) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| contains(T element) | O(n) |
| indexOf(T element) | O(n) |
| clear() | O(1) |

**Practical Example:**

```java
DoublyLinkedCircularList<String> list = new DoublyLinkedCircularList<>();

list.addFirst("B"); // head=[B], tail=[B], [B]<->[B] (circular, points to itself)
list.addFirst("A"); // head=[A]<->[B]=tail, tail.previous=head, head.prev=tail
list.addLast("C");  // head=[A]<->[B]<->[C]=tail, tail.previous=head
list.get(1);        // returns "B"
list.removeLast();  // returns "C", O(1) via tail.getPrevious()
list.removeFirst(); // returns "A", O(1) via head.getPrevious()
```

**How the circular double link is maintained on addFirst:**

```java
// New node points forward to old head and backward to tail
newNode.setNext(head);
newNode.setPrevious(tail);
// Old head's previous is updated to new node
head.setPrevious(newNode);
// New node becomes the head
head = newNode;
// Tail's previous is updated to the new head, keeping the circle closed
tail.setNext(head);
```

---