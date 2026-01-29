<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINISHED-<COLOR>.svg)

# Arrays

---

Explanation of the Array Data Structure, its main operations and complexities.

---

## Technologies

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Overview

- **Arrays store data continuously in memory**, so **even if we have the exact available space in memory, if it's not aligned, it won't be able to allocate.**
- **Arrays only accept objects of the same type** in memory.
- **Arrays have **read time O(1) and write time O(n)** in most cases, as they must move all elements to write to a place where something already exists.**
- **Arrays have a fixed size**, so they can have empty elements or insufficient space.
- **They are implemented by the Java ArrayList class, or simply instantiated by common vectors (fewer methods).**

---

## Complexity of Operations

| Operation | Complexity | Type |
|------------------------|--------------|------|
| add(element) | O(1) | Write |
| add(index, element) | O(n) | Write |
| get(index) | O(1) | Read |
| set(int index) | O(1) | Write |
| remove(index) | O(n) | Write |
| remove(E element) | O(n) | Write |
| indexOf(element) | O(n) | Read |
| size() | O(1) | Read |
| isEmpty() | O(1) | Read |
| contains(E element) | O(n) | Read |
| clear() | O(n) or O(1) | Write |
| getFirst() | O(1) | Read |
| getLast() | O(1) | Read |
| lastIndexOf(E element) | O(n) | Read |

---

## When to Use Arrays

**Use Arrays when:**

- Frequent access by index
- Fixed or predictable size
- Reading is more common than writing
- Contiguous memory is important

**Avoid Arrays when:**

- Many insertions/removals in the middle
- Highly dynamic size
- Constant sorting is needed

---

## Example of Use
```java ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10); // O(1) - adds to the end
numbers.add(0, 5); // O(n) - shifts elements
int value = numbers.get(1); // O(1) - Direct Access
```

---

## Implementation Details

This implementation uses:

- **Variable `size`**: controls the number of valid elements
- **Internal Array**: stores the elements
- **Class `ArrayStructure`**: parent class with common operations
- **Resizing**: when capacity is exceeded (increaseCapacity)

---