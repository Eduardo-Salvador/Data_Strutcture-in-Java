<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINISHED-<COLOR>.svg)

# Recursion

---

Explanation of recursive strategies, their structure and complexities.

---

## Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Overview

***Recursion is a technique where a function solves a problem by calling itself with a smaller input until a base case is reached:***

Instead of using explicit loops, the function delegates part of the work to a new call of itself. Each call is pushed onto the Call Stack as a stack frame and only resolved after all subsequent calls return.

Every recursive function requires two parts: a **base case** that stops the recursion, and a **recursive case** that reduces the problem toward the base case. Without a base case, the Call Stack grows indefinitely and the JVM throws a `StackOverflowError`.

Recursion is naturally suited for problems with self-similar structure, where the solution for the full input is defined in terms of the solution for a smaller input of the same kind.

---

## Recursion Structure

Every divide and conquer recursive function has two mandatory parts:

**Base case:** the condition that stops the recursion. Without it, the call stack grows indefinitely and throws a `StackOverflowError`.

**Recursive case:** the call that reduces the problem by one step and delegates the remainder.

```java
public static Integer sum(Integer[] array, int index) {
    // Base case: nothing left to process
    if (index >= array.length) {
        return 0;
    }
    // Recursive case: current element + result of the remaining subarray
    return array[index] + sum(array, index + 1);
}
```
---

## Divide and Conquer

***Divide and Conquer is a recursive strategy that solves a problem by breaking it into smaller subproblems of the same kind:***

Each recursive call handles one element and delegates the rest to the previous call. **The structure always follows three steps:**

Divide → reduce the problem by one unit. Conquer → solve the base case. Combine → return the accumulated result up the call stack.

---

## Why Divide and Conquer:

- Breaks complex problems into trivially simple base cases.
- Eliminates the need for explicit loops by expressing iteration as recursion.
- Produces clean, readable code for problems with naturally recursive structure.
- Serves as the foundation for algorithms such as Merge Sort, Quick Sort, and Binary Search.

---

## Operation Complexity

| Algorithm | Time Complexity | Space Complexity |
|----------------------|-----------------|------------------|
| ArraySum | O(n) | O(n) |
| CountElements | O(n) | O(n) |
| MaxValue | O(n) | O(n) |

> ***Space complexity is O(n) for all implementations because each recursive call adds a stack frame to the Call Stack. For an array of n elements, n frames are active simultaneously before the base case is reached.***

---

## When to Use

**Use Divide and Conquer recursion when:**

- The problem can be reduced by processing one element at a time
- The solution for the full input depends on the solution of a smaller input
- The problem has a clear and reachable base case
- Readability and structural clarity matter more than raw performance

**Avoid when:**

- The input is very large and stack depth is a concern (risk of `StackOverflowError`)
- An iterative solution with O(1) space is preferred for performance reasons
- The subproblems overlap and results should be cached (use Dynamic Programming instead)

---

## Example of Use
```java
// Sum of all elements in an array
Integer[] array = new Integer[]{1, 2, 3, 4, 5};
Integer result = ArraySum.sum(array); // 15

// Count elements in a list
List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
Integer count = ItemsInTheListArray.counterListElements(list, 0); // 3

// Maximum value in an array
Integer[] values = new Integer[]{3, 7, 1, 9, 4};
Integer max = MaxValueInListArray.max(values, 0, 0); // 9
```

---

## Implementation Details

### Available Implementations

| Implementation | Input | Strategy | Implemented on GitHub |
|---------------|-------|----------|-----------------------|
| ArraySum | Integer[] | Accumulate via return | ✔ |
| CountElements | List, Array | Accumulate via index | ✔ |
| MaxValue | List, Integer[] | Accumulate via parameter | ✔ |

**Differences between implementations:**
- **ArraySum**: Accumulates the result through the return value, each frame adds its element to the value returned by the previous call
- **CountElements**: Accumulates through the index, the base case returns the final index value, which equals the size of the collection
- **MaxValue**: Accumulates through a parameter, the current maximum is carried forward in each call rather than computed on the way back

> ***The difference between these strategies is when the work happens. In ArraySum, the addition occurs on the way back up the call stack (after the recursive call returns). In MaxValue, the comparison occurs on the way down (before the recursive call is made). Both are valid divide and conquer approaches.***

---

### ArraySum

ArraySum computes the total of all elements in an Integer array. A private helper method receives the index as a parameter, isolating the recursive logic from the public API. Each frame returns the element at its index added to the result of the remaining subarray.

Call stack for `{1, 2, 3}`:

```
sum(array, 0) = 1 + sum(array, 1)
                    = 2 + sum(array, 2)
                            = 3 + sum(array, 3)
                                      = 0  ← base case
```

**Practical Example:**

```java
Integer[] array = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
Integer result = ArraySum.sum(array);
System.out.println("Array Sum: " + result); // 45
```

---

### CountElements

CountElements counts the number of elements in a List or array without using `.size()` or `.length`. The index advances by one on each call until it equals the collection size, at which point the index itself is returned as the count.

Call stack for `[A, B, C]`:

```
counter(list, 0) → counter(list, 1)
                       → counter(list, 2)
                               → counter(list, 3)
                                       → return 3  ← base case, index == size
```

**Practical Example:**

```java
List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 2, 5, 2));
Integer resultList = ItemsInTheListArray.counterListElements(list, 0);
// resultList = 14

String[] array = new String[]{"One", "Two", "Three", "Four"};
Integer resultArray = ItemsInTheListArray.counterListElements(array, 0);
// resultArray = 4
```

---

### MaxValue

MaxValue finds the largest value in a List or array. The current maximum is passed as a parameter on each call. If the element at the current index is greater than the stored maximum, it replaces it before the previous recursive call.

Call stack for `[3, 9, 1]`:

```
max(list, 0, 0) → 3 > 0, maxValue=3
    max(list, 1, 3) → 9 > 3, maxValue=9
        max(list, 2, 9) → 1 < 9, maxValue=9
            max(list, 3, 9) → return 9  ← base case
```

**Practical Example:**

```java
List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 23, 42, 12));
Integer resultList = MaxValueInListArray.max(list, 0, 0);
// resultList = 42

Integer[] array = new Integer[]{0, 1, 44, 23, 192, 321, 4, 2, 1, 1};
Integer resultArray = MaxValueInListArray.max(array, 0, 0);
// resultArray = 321
```

---