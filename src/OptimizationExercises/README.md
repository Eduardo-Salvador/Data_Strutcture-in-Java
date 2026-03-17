<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINISHED-<COLOR>.svg)

# Optimization Exercises

---

Practical exercises that apply data structures to solve classical optimization problems.

---

## Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Overview

***Optimization exercises demonstrate how the right choice of data structure can transform an inefficient solution into one with better time or space complexity:***

A naive solution often solves the problem correctly but at a higher cost, typically O(n²) or O(n log n). By identifying the access pattern required (LIFO, FIFO, double-ended, or constant-time min/max), a more appropriate structure can reduce that cost significantly, often to O(n) or O(1) per operation.

These exercises cover five classical problems: palindrome verification using a deque, sliding window maximum using a monotonic deque, queue with O(1) min/max using two stacks, stack with O(1) maximum tracking, stack with O(1) minimum tracking, and an undo/redo system using two stacks.

---

## Exercise Summary

| Exercise | Structure Used | Key Optimization |
|----------------------|----------------|------------------|
| CheckPalindrome | DoublyLinkedListDeque | O(1) removeFirst and removeLast instead of index access |
| SlidingWindow | ArrayDeque (monotonic) | O(n) total instead of O(n * k) brute force |
| QueueWith2Stacks | Two Min_O1 + Two Max_O1 stacks | O(1) getMin and getMax on a queue |
| Max_O1 | StackDinamicArray + auxiliary stack | O(1) getMax instead of O(n) scan |
| Min_O1 | StackDinamicArray + auxiliary stack | O(1) getMin instead of O(n) scan |
| UndoRedo | Two StackDinamicArray stacks | O(1) undo and redo via LIFO history |

---

### CheckPalindrome

CheckPalindrome verifies whether a string is a palindrome by loading all characters into a `DoublyLinkedListDeque` and comparing the front and back simultaneously, removing one from each end per iteration until fewer than two characters remain.

This approach exploits the O(1) `getFirst`, `getLast`, `removeFirst`, and `removeLast` operations of the deque, making each comparison and removal step constant time. The overall complexity is O(n) for the initial loading and O(n) for the comparison loop, for a total of O(n).

Spaces are skipped during loading, so phrases like "never odd or even" are handled correctly without preprocessing.

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| isPalindrome(String) | O(n) |

**Practical Example:**

```java
CheckPalindrome.isPalindrome("racecar");        // true
CheckPalindrome.isPalindrome("hello");          // false
CheckPalindrome.isPalindrome("never odd or even"); // true — spaces ignored
CheckPalindrome.isPalindrome(null);             // true — null treated as empty
```

**How the comparison loop works:**

```java
while (palindrome.size() > 1) {
    if (!palindrome.getFirst().equals(palindrome.getLast())) {
        return false; // mismatch found
    }
    palindrome.removeFirst();
    palindrome.removeLast();
}
return true;
```

---

### SlidingWindow

SlidingWindow computes the maximum value in every window of size `k` across an integer array, producing a list of maximums. The naive approach would scan all `k` elements of each window, giving O(n * k). This implementation uses a **monotonic deque** to achieve O(n) total.

The deque stores indices, not values. It is maintained in decreasing order of the corresponding array values. Before each new element is added, two cleanup steps run: indices outside the current window are removed from the front, and indices whose values are smaller than the incoming element are removed from the back. This guarantees that the front of the deque always holds the index of the maximum in the current window.

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| slidingWindow(int[], int k) | O(n) |

**Practical Example:**

```java
SlidingWindow<Integer> sw = new SlidingWindow<>();
sw.slidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
// Result: [3, 3, 5, 5, 6, 7]
```

**How the monotonic deque works:**

```java
for (int i = 0; i < arr.length; i++) {
    // Remove indices outside the window
    while (!aux.isEmpty() && aux.peekFirst() < i - k + 1) {
        aux.removeFirst();
    }
    // Remove indices whose values are smaller than the current element
    while (!aux.isEmpty() && arr[aux.peekLast()] < arr[i]) {
        aux.removeLast();
    }
    aux.addLast(i);
    // Once the first full window is complete, record the maximum
    if (i >= k - 1) {
        result.add(arr[aux.peekFirst()]);
    }
}
```

---

### Max_O1

Max_O1 extends `StackDinamicArray` and tracks the current maximum in O(1) by maintaining a parallel auxiliary stack. The auxiliary stack only stores a new element when it is greater than or equal to the current maximum. On pop, if the removed element equals the top of the auxiliary stack, the auxiliary stack also pops, revealing the previous maximum.

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| push(T element) | O(1) or O(n) |
| pop() | O(1) |
| getMax() | O(1) |

**Practical Example:**

```java
Max_O1<Integer> stack = new Max_O1<>(Comparator.naturalOrder());

stack.push(3);  // maxStack: [3]
stack.push(1);  // maxStack: [3]   — 1 < 3, not pushed to maxStack
stack.push(5);  // maxStack: [3, 5]
stack.push(5);  // maxStack: [3, 5, 5] — equal, pushed to maxStack
stack.getMax(); // returns 5
stack.pop();    // removes 5, maxStack pops: [3, 5]
stack.getMax(); // returns 5
stack.pop();    // removes 5, maxStack pops: [3]
stack.getMax(); // returns 3
```

---

### Min_O1

Min_O1 follows the same pattern as Max_O1 but tracks the minimum instead. The auxiliary stack receives a new element only when it is less than or equal to the current minimum, ensuring the top of the auxiliary stack always reflects the smallest value in the main stack.

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| push(T element) | O(1) or O(n) |
| pop() | O(1) |
| getMin() | O(1) |

**Practical Example:**

```java
Min_O1<Integer> stack = new Min_O1<>(Comparator.naturalOrder());

stack.push(5);  // minStack: [5]
stack.push(3);  // minStack: [5, 3]
stack.push(7);  // minStack: [5, 3]  — 7 > 3, not pushed to minStack
stack.push(3);  // minStack: [5, 3, 3] — equal, pushed to minStack
stack.getMin(); // returns 3
stack.pop();    // removes 3, minStack pops: [5, 3]
stack.getMin(); // returns 3
stack.pop();    // removes 7, minStack unchanged: [5, 3]
stack.getMin(); // returns 3
```

---

### QueueWith2Stacks

QueueWith2Stacks implements a queue with O(1) `getMin` and `getMax` using four stacks internally: `inStackMin`, `inStackMax`, `outStackMin`, and `outStackMax`. Enqueued elements are pushed onto the `in` pair. When `dequeue` is called and the `out` stacks are empty, all elements from the `in` stacks are transferred to the `out` stacks. The minimum and maximum are retrieved by comparing the current min/max of each pair.

The key insight is that both the `in` and `out` stacks independently track their own min and max via `Min_O1` and `Max_O1`. The global minimum is the smaller of the two stack minimums, and the global maximum is the larger of the two maximums.

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| enqueue(T element) | O(1) |
| dequeue() | O(1) amortized |
| getMin() | O(1) |
| getMax() | O(1) |

**Practical Example:**

```java
QueueWith2Stacks<Integer> queue = new QueueWith2Stacks<>();

queue.enqueue(3);
queue.enqueue(1);
queue.enqueue(5);
queue.getMin(); // returns 1
queue.getMax(); // returns 5
queue.dequeue(); // returns 3 — triggers transfer: outStacks = [1, 5] (reversed)
queue.getMin(); // returns 1
queue.getMax(); // returns 5
```

**How getMin compares both stack pairs:**

```java
public T getMin() {
    if (outStackMin.isEmpty()) return inStackMin.getMin();
    if (inStackMin.isEmpty()) return outStackMin.getMin();
    T minIn = inStackMin.getMin();
    T minOut = outStackMin.getMin();
    return minIn.compareTo(minOut) < 0 ? minIn : minOut;
}
```

---

### UndoRedo

UndoRedo implements a state history system using two stacks: `undoStack` and `redoStack`. The current state is stored in a dedicated field. When an action is executed, the previous state is pushed onto `undoStack` and `redoStack` is cleared. Undo moves the current state to `redoStack` and restores the top of `undoStack`. Redo reverses this process.

Clearing `redoStack` on every new action ensures that the redo history is always consistent with the actual sequence of executed actions.

Operation complexity:

| Operation | Complexity |
|----------------------|------------|
| executeAction(T newState) | O(1) |
| undo() | O(1) |
| redo() | O(1) |
| getCurrentState() | O(1) |
| canUndo() | O(1) |
| canRedo() | O(1) |

**Practical Example:**

```java
UndoRedo<String> editor = new UndoRedo<>("initial");

editor.executeAction("draft 1");   // undoStack: ["initial"],  current: "draft 1"
editor.executeAction("draft 2");   // undoStack: ["initial", "draft 1"], current: "draft 2"
editor.undo();                     // redoStack: ["draft 2"],  current: "draft 1"
editor.undo();                     // redoStack: ["draft 2", "draft 1"], current: "initial"
editor.redo();                     // undoStack: ["initial"],  current: "draft 1"
editor.executeAction("draft 3");   // redoStack cleared,       current: "draft 3"
editor.canRedo();                  // false
```

---