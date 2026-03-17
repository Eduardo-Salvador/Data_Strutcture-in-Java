<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINALIZADO-<COLOR>.svg)

# Exercícios de Otimização

---

Exercícios práticos que aplicam estruturas de dados para resolver problemas clássicos de otimização.

---

## Tecnologias
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Visão Geral

***Exercícios de otimização demonstram como a escolha correta da estrutura de dados pode transformar uma solução ineficiente em uma com melhor complexidade de tempo ou espaço:***

Uma solução ingênua frequentemente resolve o problema corretamente, mas com um custo maior, tipicamente O(n²) ou O(n log n). Ao identificar o padrão de acesso necessário (LIFO, FIFO, dupla extremidade ou min/max em tempo constante), uma estrutura mais adequada pode reduzir esse custo significativamente, muitas vezes para O(n) ou O(1) por operação.

Estes exercícios cobrem cinco problemas clássicos: verificação de palíndromo usando um deque, máximo em janela deslizante usando um deque monotônico, fila com min/max O(1) usando duas pilhas, pilha com rastreamento de máximo O(1), pilha com rastreamento de mínimo O(1), e um sistema de desfazer/refazer usando duas pilhas.

---

## Resumo dos Exercícios

| Exercício | Estrutura Usada | Otimização Principal |
|----------------------|-----------------|----------------------|
| CheckPalindrome | DoublyLinkedListDeque | removeFirst e removeLast O(1) em vez de acesso por índice |
| SlidingWindow | ArrayDeque (monotônico) | O(n) total em vez de O(n * k) força bruta |
| QueueWith2Stacks | Dois Min_O1 + Dois Max_O1 | getMin e getMax O(1) em uma fila |
| Max_O1 | StackDinamicArray + pilha auxiliar | getMax O(1) em vez de varredura O(n) |
| Min_O1 | StackDinamicArray + pilha auxiliar | getMin O(1) em vez de varredura O(n) |
| UndoRedo | Duas StackDinamicArray | undo e redo O(1) via histórico LIFO |

---

### CheckPalindrome

CheckPalindrome verifica se uma string é um palíndromo carregando todos os caracteres em um `DoublyLinkedListDeque` e comparando a frente e o final simultaneamente, removendo um de cada extremidade por iteração até restar menos de dois caracteres.

Essa abordagem aproveita as operações O(1) de `getFirst`, `getLast`, `removeFirst` e `removeLast` do deque, tornando cada passo de comparação e remoção em tempo constante. A complexidade total é O(n) para o carregamento inicial e O(n) para o laço de comparação, totalizando O(n).

Espaços são ignorados durante o carregamento, portanto frases como "never odd or even" são tratadas corretamente sem pré-processamento.

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| isPalindrome(String) | O(n) |

**Exemplo prático:**

```java
CheckPalindrome.isPalindrome("racecar");           // true
CheckPalindrome.isPalindrome("hello");             // false
CheckPalindrome.isPalindrome("never odd or even"); // true — espaços ignorados
CheckPalindrome.isPalindrome(null);                // true — null tratado como vazio
```

**Como o laço de comparação funciona:**

```java
while (palindrome.size() > 1) {
    if (!palindrome.getFirst().equals(palindrome.getLast())) {
        return false; // divergência encontrada
    }
    palindrome.removeFirst();
    palindrome.removeLast();
}
return true;
```

---

### SlidingWindow

SlidingWindow calcula o valor máximo em cada janela de tamanho `k` sobre um array de inteiros, produzindo uma lista de máximos. A abordagem ingênua varreria todos os `k` elementos de cada janela, resultando em O(n * k). Esta implementação usa um **deque monotônico** para alcançar O(n) total.

O deque armazena índices, não valores. Ele é mantido em ordem decrescente dos valores correspondentes no array. Antes de cada novo elemento ser adicionado, dois passos de limpeza ocorrem: índices fora da janela atual são removidos da frente, e índices cujos valores são menores que o elemento entrante são removidos do final. Isso garante que a frente do deque sempre contém o índice do máximo na janela atual.

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| slidingWindow(int[], int k) | O(n) |

**Exemplo prático:**

```java
SlidingWindow<Integer> sw = new SlidingWindow<>();
sw.slidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
// Result: [3, 3, 5, 5, 6, 7]
```

**Como o deque monotônico funciona:**

```java
for (int i = 0; i < arr.length; i++) {
    // Remove índices fora da janela
    while (!aux.isEmpty() && aux.peekFirst() < i - k + 1) {
        aux.removeFirst();
    }
    // Remove índices cujos valores são menores que o elemento atual
    while (!aux.isEmpty() && arr[aux.peekLast()] < arr[i]) {
        aux.removeLast();
    }
    aux.addLast(i);
    // Assim que a primeira janela completa é formada, registra o máximo
    if (i >= k - 1) {
        result.add(arr[aux.peekFirst()]);
    }
}
```

---

### Max_O1

Max_O1 estende `StackDinamicArray` e rastreia o máximo atual em O(1) mantendo uma pilha auxiliar paralela. A pilha auxiliar armazena um novo elemento apenas quando ele é maior ou igual ao máximo atual. No pop, se o elemento removido for igual ao topo da pilha auxiliar, a pilha auxiliar também faz pop, revelando o máximo anterior.

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| push(T element) | O(1) ou O(n) |
| pop() | O(1) |
| getMax() | O(1) |

**Exemplo prático:**

```java
Max_O1<Integer> stack = new Max_O1<>(Comparator.naturalOrder());

stack.push(3);  // maxStack: [3]
stack.push(1);  // maxStack: [3]    — 1 < 3, não empilhado no maxStack
stack.push(5);  // maxStack: [3, 5]
stack.push(5);  // maxStack: [3, 5, 5] — igual, empilhado no maxStack
stack.getMax(); // retorna 5
stack.pop();    // remove 5, maxStack faz pop: [3, 5]
stack.getMax(); // retorna 5
stack.pop();    // remove 5, maxStack faz pop: [3]
stack.getMax(); // retorna 3
```

---

### Min_O1

Min_O1 segue o mesmo padrão do Max_O1, mas rastreia o mínimo em vez do máximo. A pilha auxiliar recebe um novo elemento apenas quando ele é menor ou igual ao mínimo atual, garantindo que o topo da pilha auxiliar sempre reflita o menor valor na pilha principal.

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| push(T element) | O(1) ou O(n) |
| pop() | O(1) |
| getMin() | O(1) |

**Exemplo prático:**

```java
Min_O1<Integer> stack = new Min_O1<>(Comparator.naturalOrder());

stack.push(5);  // minStack: [5]
stack.push(3);  // minStack: [5, 3]
stack.push(7);  // minStack: [5, 3]   — 7 > 3, não empilhado no minStack
stack.push(3);  // minStack: [5, 3, 3] — igual, empilhado no minStack
stack.getMin(); // retorna 3
stack.pop();    // remove 3, minStack faz pop: [5, 3]
stack.getMin(); // retorna 3
stack.pop();    // remove 7, minStack inalterado: [5, 3]
stack.getMin(); // retorna 3
```

---

### QueueWith2Stacks

QueueWith2Stacks implementa uma fila com `getMin` e `getMax` O(1) usando quatro pilhas internamente: `inStackMin`, `inStackMax`, `outStackMin` e `outStackMax`. Elementos enfileirados são empilhados no par `in`. Quando `dequeue` é chamado e as pilhas `out` estão vazias, todos os elementos das pilhas `in` são transferidos para as pilhas `out`. O mínimo e o máximo são obtidos comparando o min/max atual de cada par.

O insight central é que as pilhas `in` e `out` rastreiam independentemente seus próprios min e max via `Min_O1` e `Max_O1`. O mínimo global é o menor entre os dois mínimos das pilhas, e o máximo global é o maior entre os dois máximos.

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| enqueue(T element) | O(1) |
| dequeue() | O(1) amortizado |
| getMin() | O(1) |
| getMax() | O(1) |

**Exemplo prático:**

```java
QueueWith2Stacks<Integer> queue = new QueueWith2Stacks<>();

queue.enqueue(3);
queue.enqueue(1);
queue.enqueue(5);
queue.getMin(); // retorna 1
queue.getMax(); // retorna 5
queue.dequeue(); // retorna 3 — dispara transferência: outStacks = [1, 5] (invertido)
queue.getMin(); // retorna 1
queue.getMax(); // retorna 5
```

**Como getMin compara os dois pares de pilhas:**

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

UndoRedo implementa um sistema de histórico de estados usando duas pilhas: `undoStack` e `redoStack`. O estado atual é armazenado em um campo dedicado. Quando uma ação é executada, o estado anterior é empilhado em `undoStack` e `redoStack` é limpa. Undo move o estado atual para `redoStack` e restaura o topo de `undoStack`. Redo inverte esse processo.

Limpar `redoStack` a cada nova ação garante que o histórico de redo seja sempre consistente com a sequência real de ações executadas.

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| executeAction(T newState) | O(1) |
| undo() | O(1) |
| redo() | O(1) |
| getCurrentState() | O(1) |
| canUndo() | O(1) |
| canRedo() | O(1) |

**Exemplo prático:**

```java
UndoRedo<String> editor = new UndoRedo<>("initial");

editor.executeAction("draft 1");   // undoStack: ["initial"],  current: "draft 1"
editor.executeAction("draft 2");   // undoStack: ["initial", "draft 1"], current: "draft 2"
editor.undo();                     // redoStack: ["draft 2"],  current: "draft 1"
editor.undo();                     // redoStack: ["draft 2", "draft 1"], current: "initial"
editor.redo();                     // undoStack: ["initial"],  current: "draft 1"
editor.executeAction("draft 3");   // redoStack limpa,         current: "draft 3"
editor.canRedo();                  // false
```

---