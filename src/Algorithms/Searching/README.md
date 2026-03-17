<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINISHED-<COLOR>.svg)

# Searching Algorithms

---

Explanation of searching algorithms, their strategies and complexities.

---

## Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Overview

***A searching algorithm locates a target element within a collection by following a defined strategy:***

The choice of strategy determines how many elements must be examined before the target is found or confirmed absent. This is expressed as time complexity and is the primary metric for comparing searching algorithms.

The two fundamental strategies are **linear search** and **binary search**. Linear search examines every element from start to finish, simple and works on any collection, but O(n) in the worst case. Binary search eliminates half the remaining candidates on every step, far more efficient at O(log n), but requires the collection to be sorted beforehand.

Beyond these, more specialized structures such as hash tables achieve O(1) average-case search by computing the element's position directly, and tree-based structures such as BSTs achieve O(log n) search through hierarchical partitioning.

The right algorithm depends on three factors: whether the data is sorted, how frequently the search is performed, and the cost of preprocessing the collection.

---

## Algorithm Comparison

| Algorithm | Requires Sorted Input | Time Complexity (Best) | Time Complexity (Worst) | Space Complexity |
|----------------------|-----------------------|------------------------|--------------------------|------------------|
| Linear Search | ❌ | O(1) | O(n) | O(1) |
| Binary Search | ✔ | O(1) | O(log n) | O(log n) recursive |
| Hash Table Lookup | ❌ | O(1) | O(n) collision | O(n) |
| BST Search | ✔ sorted insert | O(1) | O(n) unbalanced | O(n) |

---

## Binary Search

***Binary Search finds a target in a sorted array by repeatedly halving the search space:***

On each step, it compares the target against the middle element. If the target is smaller, the right half is discarded. If larger, the left half is discarded. This continues until the target is found or the search space is empty.

---

### Why Binary Search:

- Reduces O(n) linear search to O(log n) by exploiting sorted order.
- For 1,000,000 elements, linear search may examine up to 1,000,000 elements; binary search examines at most 20.
- The cost of sorting the array beforehand is O(n log n), which is quickly amortized when multiple searches are performed.
- Used in standard library methods such as `Arrays.binarySearch()` and as a subroutine in algorithms like Quick Sort partitioning.

---

### Operation Complexity

| Operation | Time Complexity | Space Complexity |
|----------------------|-----------------|------------------|
| binarySearch() | O(log n) | O(log n) recursive stack |

> ***Space complexity is O(log n) because the recursive implementation adds one stack frame per halving step. An iterative implementation would reduce space to O(1).***

---

### When to Use

**Use Binary Search when:**

- The array is sorted or can be sorted before repeated searches
- Search performance is critical and O(n) linear scan is too slow
- The collection is static or changes infrequently

**Avoid Binary Search when:**

- The collection is unsorted and sorting it first is not viable
- Only a single search is performed on an unsorted collection (linear search is simpler)
- The collection uses a linked structure with no O(1) index access

---

### Example of Use
```java
Integer[] array = new Integer[]{1, 3, 5, 7, 9, 11, 13};
// Array must be sorted before calling binarySearch
Integer index = BinarySearch.binarySearch(array, 7); // returns 3
Integer missing = BinarySearch.binarySearch(array, 4); // returns -1
```

---

### Implementation Details

This implementation uses a recursive private helper that receives `start`, `end`, and a `counter` parameter. The public method initializes the search over the full array by calling `helper(array, target, 0, array.length - 1, 0)`.

The midpoint is computed as `start + ((end - start) / 2)` rather than `(start + end) / 2` to avoid integer overflow when `start` and `end` are large indices.

On each call, one of three outcomes occurs: the middle element matches the target and its index is returned; the target is greater than the middle and the search continues in the right half; the target is smaller and the search continues in the left half. If `start > end`, the search space is exhausted and -1 is returned.

Call stack for searching `7` in `[1, 3, 5, 7, 9, 11, 13]`:

```
helper(array, 7, 0, 6)  → mid=3, array[3]=7 → found, return 3
```

Call stack for searching `6` in `[1, 3, 5, 7, 9, 11, 13]`:

```
helper(array, 6, 0, 6)  → mid=3, array[3]=7, 6 < 7  → go left
helper(array, 6, 0, 2)  → mid=1, array[1]=3, 6 > 3  → go right
helper(array, 6, 2, 2)  → mid=2, array[2]=5, 6 > 5  → go right
helper(array, 6, 3, 2)  → start > end                → return -1
```

**How the midpoint and halving work:**

```java
int mid = start + ((end - start) / 2); // overflow-safe midpoint

if (array[mid].equals(elementSearch)) {
    return mid; // found
}
if (elementSearch > array[mid]) {
    return helper(array, elementSearch, mid + 1, end, counter); // discard left half
}
return helper(array, elementSearch, start, mid - 1, counter); // discard right half
```

**Practical Example:**

```java
Random random = new Random();
Integer[] array = new Integer[1_000_000];
for (int i = 0; i < array.length; i++) {
    array[i] = random.nextInt(100_000);
}
Arrays.sort(array); // binary search requires sorted input

Integer result = BinarySearch.binarySearch(array, array[array.length - 1]);

// Expected output (approximate):
// Binary Search Time O(logN):  ~1 μs
// Linear Search Time O(n):     ~3000 μs
```

> ***The main method includes a JVM warmup loop of 100 iterations before benchmarking. This forces JIT compilation of the method before the timed run, producing a more accurate measurement of steady-state performance.***

---