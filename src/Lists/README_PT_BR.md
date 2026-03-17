<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINALIZADO-<COLOR>.svg)

# Listas

---

Explicação da Estrutura de Dados Lista, suas operações principais e complexidades.

---

## Tecnologias
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Visão Geral

***Uma lista é uma estrutura de dados que armazena elementos de forma sequencial e ordenada:***

Ao contrário de pilhas e filas, listas permitem inserção, remoção e acesso em qualquer posição. **Não há uma regra única de acesso**, os elementos podem ser acessados por índice ou por travessia.

---

## Por que Listas:

- Organiza dados com acesso flexível a qualquer posição.
- Suporta inserção e remoção no início, meio ou fim.
- Serve como base para estruturas de nível superior como pilhas, filas e deques.
- Usadas para coleções ordenadas, iteradores, gerenciamento de histórico e armazenamento de propósito geral.

---

## Complexidade das Operações

| Operação | Complexidade | Tipo |
|----------------------|--------------|----------------------------------------|
| add(T element) | O(1) ou O(n) | Escrita |
| add(int index, T element) | O(n) | Escrita |
| addFirst(T element) | O(1) ou O(n) | Escrita |
| addLast(T element) | O(1) ou O(n) | Escrita |
| get(int index) | O(1) ou O(n) | Leitura |
| set(int index, T element) | O(n) | Escrita |
| remove(int index) | O(n) | Escrita |
| remove(T element) | O(n) | Escrita |
| removeFirst() | O(1) | Escrita |
| removeLast() | O(1) ou O(n) | Escrita |
| contains(T element) | O(n) | Leitura |
| indexOf(T element) | O(n) | Leitura |
| clear() | O(1) ou O(n) | Escrita |
| toArray() | O(n) | Leitura |
| increaseCapacity() | O(n) | Escrita (Para ArrayList apenas) |

> ***As complexidades variam conforme a implementação. Consulte cada seção abaixo para detalhes.***

---

## Quando Usar

**Use Listas quando:**

- Necessita de acesso flexível a elementos por índice ou posição
- Inserções e remoções podem ocorrer em qualquer ponto
- Implementando iteradores, histórico ou coleções ordenadas
- Construindo estruturas de nível superior sobre um contêiner sequencial

**Evite Listas quando:**

- Necessita apenas de acesso LIFO (use Pilha)
- Necessita apenas de acesso FIFO (use Fila)
- Necessita de busca em tempo constante por chave (use Map ou Set)
- Necessita de acesso ordenado com busca O(log n) (use Árvore)

---

## Exemplo de Uso
```java
// ArrayList
ArrayList<String> lista = new ArrayList<>();

lista.add("A");              // O(1) - adiciona no final
lista.add(0, "Z");           // O(n) - insere no índice 0
String valor = lista.get(1); // O(1) - acesso direto por índice
lista.remove(0);             // O(n) - remove e desloca elementos
boolean encontrado = lista.contains("A"); // O(n)
```

---

## Detalhes de Implementação

### Implementações Disponíveis

| Implementação | Estrutura | Cresce | Bidirecional | Circular | Uso de Memória | Implementado GitHub |
|---------------|-----------|--------|--------------|----------|----------------|---------------------|
| ArrayList | Array | ✔ | ❌ | ❌ | Médio | ✔ |
| LinkedList | Nós | ✔ | ❌ | ❌ | Alto | ✔ |
| DoublyLinkedList | Nós | ✔ | ✔ | ❌ | Alto | ✔ |
| LinkedCircularList | Nós | ✔ | ❌ | ✔ | Alto | ✔ |
| DoublyLinkedCircularList | Nós | ✔ | ✔ | ✔ | Alto | ✔ |

**Diferenças entre implementações:**
- **ArrayList**: Usa `ArrayStructure` com redimensionamento automático via `increaseCapacity()`, fornece acesso O(1) por índice, mas inserção e remoção no meio são O(n)
- **LinkedList**: Usa `NodeStructure` com apenas um ponteiro `head`, addFirst é O(1) mas addLast e get são O(n) por exigir travessia completa
- **DoublyLinkedList**: Usa `NodeStructure` com ponteiros `head` e `last` e links bidirecionais entre nós, permite travessia otimizada a partir de qualquer extremidade e removeLast O(1)
- **LinkedCircularList**: Simplesmente encadeada com ponteiros `head` e `tail` onde o último nó aponta de volta para head, possibilitando addFirst e addLast O(1)
- **DoublyLinkedCircularList**: Duplamente encadeada e circular, combinando travessia bidirecional com wrap circular; tanto head quanto tail são mantidos

> ***A diferença das implementações se baseia nos BigO's de cada operação. Por exemplo, ArrayList fornece acesso aleatório O(1) enquanto implementações encadeadas requerem travessia O(n) para alcançar um elemento por índice.***

---

### ArrayList

A ArrayList utiliza um array redimensionável herdado de `ArrayStructure`. Fornece acesso por índice em tempo constante e adições amortizadas O(1). Inserções e remoções no meio exigem deslocamento de elementos.

Características:

- Cresce automaticamente via `increaseCapacity()` quando a capacidade é excedida
- `get()` e `set()` são O(1) por causa do acesso direto por índice
- `remove(int index)` e `add(int index, element)` são O(n) por causa do deslocamento de elementos
- `resize(int newCapacity)` permite ajuste manual de capacidade
- `clear()` itera pelo array definindo cada posição como `null`

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| add(T element) | O(1) ou O(n) |
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

**Exemplo prático:**

```java
ArrayList<Integer> lista = new ArrayList<>(3);

lista.add(10);        // [10]
lista.add(20);        // [10, 20]
lista.add(30);        // [10, 20, 30]
lista.add(1, 15);     // [10, 15, 20, 30] - desloca para direita a partir do índice 1
lista.get(2);         // retorna 20
lista.remove(0);      // retorna 10, desloca: [15, 20, 30]
lista.removeLast();   // retorna 30, sem deslocamento: [15, 20]
```

---

### LinkedList

A LinkedList utiliza uma lista simplesmente encadeada via `NodeStructure`. Cada nó armazena dados e uma referência ao próximo nó. Apenas um ponteiro `head` é mantido, exigindo travessia completa para alcançar o final.

Características:

- Tamanho dinâmico sem capacidade fixa
- `addFirst()` é O(1), apenas reatribui head
- `addLast()` é O(n), deve percorrer até o último nó
- `get(int index)` é O(n), sem acesso direto, exige travessia
- `remove(T element)` percorre a partir do head, tratando separadamente o caso em que o alvo é o head

Complexidade das operações:

| Operação | Complexidade |
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

**Exemplo prático:**

```java
LinkedList<String> lista = new LinkedList<>();

lista.addFirst("B"); // head -> [B]
lista.addFirst("A"); // head -> [A] -> [B]
lista.addLast("C");  // head -> [A] -> [B] -> [C]
lista.get(1);        // retorna "B" — travessia a partir do head
lista.remove("B");   // head -> [A] -> [C]
lista.remove(0);     // retorna "A", head -> [C]
```

> ***LinkedList não tem ponteiro de cauda, tornando addLast O(n). Para alcançar addLast O(1), uma referência à cauda deve ser mantida junto ao head, como feito na LinkedCircularList.***

---

### DoublyLinkedList

A DoublyLinkedList utiliza uma lista duplamente encadeada via `NodeStructure`. Cada nó possui referências tanto para o próximo quanto para o nó anterior. Os ponteiros `head` e `last` são mantidos, possibilitando travessia a partir de qualquer extremidade e acesso O(1) a ambos os extremos.

Características:

- `addFirst()` e `addLast()` (via `add()`) são O(1)
- `removeLast()` é O(1) porque `last.getPrevious()` é diretamente acessível
- `add(int index, element)` e `remove(int index)` otimizam a direção da travessia: se o índice está na primeira metade, a travessia começa pelo head; se na segunda metade, pelo last
- `removeFirstOccurrence()` e `removeLastOccurrence()` percorrem a partir de head e last respectivamente

Complexidade das operações:

| Operação | Complexidade |
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

**Exemplo prático:**

```java
DoublyLinkedList<String> lista = new DoublyLinkedList<>();

lista.add("B");       // head -> [B] <- last
lista.addFirst("A");  // head -> [A] <-> [B] <- last
lista.addLast("C");   // head -> [A] <-> [B] <-> [C] <- last
lista.get(1);         // retorna "B"
lista.removeLast();   // retorna "C", O(1) via last.getPrevious()
lista.removeFirst();  // retorna "A", O(1) via head.getPrevious()
```

**Como a otimização de travessia bidirecional funciona:**

```java
// Para índice na primeira metade: percorre a partir do head
if (index <= this.size / 2) {
    current = head;
    for (int i = 0; i < index; i++) current = current.getNext();
} else {
    // Para índice na segunda metade: percorre a partir do last
    current = last;
    for (int i = this.size - 1; i > index; i--) current = current.getPrevious();
}
```

---

### LinkedCircularList

A LinkedCircularList utiliza uma lista simplesmente encadeada circular via `NodeStructure`. Os ponteiros `head` e `tail` são mantidos. O último nó sempre aponta de volta para `head`, formando um círculo fechado.

Características:

- `addFirst()` e `addLast()` são O(1), o ponteiro tail elimina a travessia até o final
- `removeLast()` é O(n), sem ponteiro anterior, exige travessia para encontrar o penúltimo nó
- A travessia usa `do-while (current != head)` para iterar sobre a estrutura circular sem um sentinela nulo explícito
- `clear()` é O(1), anular head e tail quebra o círculo

Complexidade das operações:

| Operação | Complexidade |
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

**Exemplo prático:**

```java
LinkedCircularList<String> lista = new LinkedCircularList<>();

lista.addFirst("B"); // tail -> [B] -> [B] (aponta para si mesmo)
lista.addFirst("A"); // head=[A], tail=[B], [B]->head
lista.addLast("C");  // head=[A], tail=[C], [C]->head
lista.get(1);        // retorna "B" — travessia a partir do head
lista.removeFirst(); // retorna "A", head=[B], [C]->[B]
lista.removeLast();  // retorna "C" — O(n), percorre para encontrar novo tail
```

**Como a ligação circular é mantida:**

```java
// addFirst: novo nó aponta para o antigo head, tail atualiza seu previous para o novo head
newNode.setNext(head);
head = newNode;
tail.setNext(head); // tail sempre aponta para o head atual

// addLast: novo nó aponta para head, antigo tail liga ao novo nó
newNode.setNext(head);
tail.setNext(newNode);
tail = newNode;
```

---

### DoublyLinkedCircularList

A DoublyLinkedCircularList utiliza uma lista duplamente encadeada circular via `NodeStructure`. Os ponteiros `head` e `tail` são mantidos. Cada nó possui referências previous e previous, e a estrutura forma um círculo fechado em ambas as direções.

Características:

- `addFirst()` e `addLast()` são O(1)
- `removeFirst()` e `removeLast()` são O(1), os ponteiros head e tail são atualizados e os links circulares são mantidos
- `removeLast()` não exige travessia porque `tail.getPrevious()` é diretamente acessível
- A travessia usa `do-while (current != head)` para iterar circularmente
- `clear()` é O(1), anular head e tail quebra todas as referências circulares

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| add(int index, T element) | O(n) |
| addFirst(T element) | O(1) |
| addLast(T element) | O(1) |
| get(int index) | O(n) |
| set(int index, T element) | O(n) |
| remove(int index) | O(1) para head/tail, O(n) caso contrário |
| remove(T element) | O(n) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| contains(T element) | O(n) |
| indexOf(T element) | O(n) |
| clear() | O(1) |

**Exemplo prático:**

```java
DoublyLinkedCircularList<String> lista = new DoublyLinkedCircularList<>();

lista.addFirst("B"); // head=[B], tail=[B], [B]<->[B] (circular, aponta para si mesmo)
lista.addFirst("A"); // head=[A]<->[B]=tail, tail.previous=head, head.prev=tail
lista.addLast("C");  // head=[A]<->[B]<->[C]=tail, tail.previous=head
lista.get(1);        // retorna "B"
lista.removeLast();  // retorna "C", O(1) via tail.getPrevious()
lista.removeFirst(); // retorna "A", O(1) via head.getPrevious()
```

**Como a ligação dupla circular é mantida no addFirst:**

```java
// Novo nó aponta para o antigo head (previous) e para o tail (previous)
newNode.setNext(head);
newNode.setPrevious(tail);
// O previous do antigo head é atualizado para o novo nó
head.setPrevious(newNode);
// Novo nó torna-se o head
head = newNode;
// O previous do tail é atualizado para o novo head, mantendo o círculo fechado
tail.setNext(head);
```

---