<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINALIZADO-<COLOR>.svg)

# Deques

---

Explicação da Estrutura de Dados Deque, suas operações principais e complexidades.

---

## Tecnologias
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Visão Geral

***Um deque (Double-Ended Queue) é uma estrutura de dados que permite inserção e remoção em ambas as extremidades:***

Ao contrário de uma fila, que permite apenas enqueue no final e dequeue no início, um deque oferece acesso completo a ambos os extremos. **Ele generaliza tanto pilhas quanto filas:**

Deque → Double-Ended Queue (insere e remove pela frente ou pelo final).

---

## Por que Deques:

- Combina os comportamentos de uma Pilha (LIFO) e uma Fila (FIFO) em uma única estrutura.
- Permite inserção e remoção em ambas as extremidades em O(1).
- Útil para algoritmos de janela deslizante, verificação de palíndromos e escalonamento de tarefas.
- Usado como estrutura base para sistemas de desfazer/refazer, navegação de histórico e BFS baseado em deque.

---

## Complexidade das Operações

| Operação | Complexidade | Tipo |
|----------------------|--------------|----------------------------------------|
| addFirst(T element) | O(1) | Escrita |
| addLast(T element) | O(1) | Escrita |
| removeFirst() | O(1) | Escrita |
| removeLast() | O(1) | Escrita |
| getFirst() | O(1) | Leitura |
| getLast() | O(1) | Leitura |
| peekFirst() | O(1) | Leitura |
| peekLast() | O(1) | Leitura |
| contains(T element) | O(n) | Leitura |
| clear() | O(1) | Escrita |

> ***Todas as operações primárias são O(1) em ambas as implementações. A única exceção é contains(), que exige travessia completa nos dois casos.***

---

## Quando Usar

**Use Deques quando:**

- Necessita de inserção e remoção O(1) em ambas as extremidades
- Implementando janela deslizante ou deque monotônico
- Construindo um sistema de desfazer/refazer
- Simulando comportamento de pilha e fila com uma única estrutura
- Implementando verificação de palíndromos ou BFS baseado em deque

**Evite Deques quando:**

- Necessita apenas de acesso em uma extremidade (use Pilha ou Fila)
- Necessita de acesso por índice (use Lista)
- Necessita de acesso ordenado (use Fila de Prioridade ou Árvore)

---

## Exemplo de Uso
```java
// Deque de Array Circular
CircularArrayDeque<String> deque = new CircularArrayDeque<>(5);

deque.addFirst("B"); // [B]
deque.addFirst("A"); // [A, B]
deque.addLast("C");  // [A, B, C]
String frente = deque.peekFirst(); // "A" — sem remoção
String final_ = deque.peekLast();  // "C" — sem remoção
deque.removeFirst(); // retorna "A" → [B, C]
deque.removeLast();  // retorna "C" → [B]
```

---

## Detalhes de Implementação

### Implementações Disponíveis

| Implementação | Estrutura | Cresce | Uso de Memória | Uso | Implementado GitHub |
|---------------|-----------|--------|----------------|-----|---------------------|
| Array Circular | Array | ❌ | Médio | Eficiente | ✔ |
| Lista Duplamente Encadeada | Nós | ✔ | Alto | Geral | ✔ |

**Diferenças entre implementações:**
- **Array Circular**: Usa `ArrayStructure` com ponteiros `start` e `end` que avançam circularmente usando o operador módulo, capacidade fixa, O(1) para todas as operações primárias sem deslocamento de elementos
- **Lista Duplamente Encadeada**: Usa `NodeStructure` com ponteiros de nó `start` e `end` e links bidirecionais, tamanho dinâmico, O(1) para todas as operações primárias via reatribuição direta de ponteiros

> ***Ambas as implementações alcançam O(1) para addFirst, addLast, removeFirst e removeLast. A diferença estrutural está na capacidade: o array circular é limitado e lança exceção em overflow, enquanto a lista duplamente encadeada cresce dinamicamente sem limite superior.***

---

### Deque de Array Circular

A CircularArrayDeque utiliza um array de tamanho fixo herdado de `ArrayStructure` com dois ponteiros, `start` e `end`, que avançam circularmente usando o operador módulo. `addFirst` move `start` para trás e `addLast` move `end` para frente, ambos sem deslocar nenhum elemento.

Características:

- Capacidade fixa definida na construção
- Lança `RuntimeException` em overflow (addFirst ou addLast quando cheia)
- Retorna `null` em underflow (removeFirst ou removeLast quando vazia)
- `getFirst()` e `getLast()` lançam `NoSuchElementException` quando vazia; `peekFirst()` e `peekLast()` retornam `null` em vez disso
- `clear()` é O(1) — apenas redefine `start`, `end` e `size`

Complexidade das operações:

| Operação | Complexidade |
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

**Exemplo prático:**

```java
CircularArrayDeque<Integer> deque = new CircularArrayDeque<>(5);

deque.addLast(10);   // end=1, [10]
deque.addLast(20);   // end=2, [10, 20]
deque.addFirst(5);   // start recua: start=4, logicamente [5, 10, 20]
deque.removeLast();  // retorna 20, end=1
deque.removeFirst(); // retorna 5, start=0
deque.peekFirst();   // retorna 10, deque inalterado
```

**Como o avanço circular funciona no addFirst:**

```java
// addFirst: move start uma posição para trás circularmente, depois insere o elemento
start = (start - 1 + this.elements.length) % this.elements.length;
this.elements[start] = element;

// addLast: insere o elemento em end, depois move end uma posição para frente
this.elements[end] = element;
end = (end + 1) % this.elements.length;

// getLast: acessa o slot imediatamente antes de end, com wrap se necessário
return this.elements[(end - 1 + this.elements.length) % this.elements.length];
```

---

### Deque de Lista Duplamente Encadeada

A DoublyLinkedListDeque utiliza uma lista duplamente encadeada via `NodeStructure`. Cada nó armazena dados e referências tanto para o próximo quanto para o nó anterior. Os ponteiros `start` e `end` sempre referenciam os nós da frente e do final respectivamente, possibilitando operações O(1) em ambas as extremidades sem nenhuma travessia.

Características:

- Tamanho dinâmico sem capacidade fixa
- `addFirst()` e `addLast()` reatribuem apenas o ponteiro de extremidade relevante e atualizam um único link adjacente
- `removeFirst()` e `removeLast()` reatribuem o ponteiro de extremidade e anulam a referência pendente
- Quando o tamanho é igual a 1, `start` e `end` apontam para o mesmo nó; a remoção define ambos como `null`
- `getFirst()` e `getLast()` lançam `NoSuchElementException` quando vazia; `peekFirst()` e `peekLast()` retornam `null` em vez disso
- `clear()` é O(1) — anular `start` e `end` libera todos os nós para o coletor de lixo

Complexidade das operações:

| Operação | Complexidade |
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

**Exemplo prático:**

```java
DoublyLinkedListDeque<String> deque = new DoublyLinkedListDeque<>();

deque.addFirst("B"); // start=[B]=end
deque.addFirst("A"); // start=[A]<->[B]=end
deque.addLast("C");  // start=[A]<->[B]<->[C]=end
deque.getFirst();    // retorna "A"
deque.getLast();     // retorna "C"
deque.removeLast();  // retorna "C", end=[B]
deque.removeFirst(); // retorna "A", start=[B]=end
```

**Como addFirst e addLast gerenciam os ponteiros de extremidade:**

```java
// addFirst: o previous do novo nó aponta para o antigo start, o previous do antigo start aponta de volta
start.setPrevious(newNode);
newNode.setNext(start);
start = newNode;

// addLast: o previous do antigo end aponta para o novo nó, o previous do novo nó aponta de volta
end.setNext(newNode);
newNode.setPrevious(end);
end = newNode;

// removeLast: end recua um passo, sua referência previous é anulada
end = end.getPrevious();
end.setNext(null);
```

---