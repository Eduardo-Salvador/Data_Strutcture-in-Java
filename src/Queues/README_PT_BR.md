<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINALIZADO-<COLOR>.svg)

# Filas

---

Explicação da Estrutura de Dados Fila, suas operações principais e complexidades.

---

## Tecnologias
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Visão Geral

***Uma fila é uma estrutura de dados que funciona como uma fila de pessoas esperando:***

A primeira pessoa a chegar é a primeira a ser atendida. **Isso é chamado de FIFO:**

FIFO → First In, First Out (O primeiro a entrar é o primeiro a sair).

---

## Por que Filas:

- Organiza dados de forma controlada, respeitando a ordem de chegada.
- Evita erros onde a sequência de processamento importa.
- Facilita o agendamento e o gerenciamento de recursos.
- Usadas para escalonamento de tarefas, fila de impressão, fila de mensagens, travessia BFS, etc.

---

## Complexidade das Operações

| Operação | Complexidade | Tipo |
|----------------------|--------------|----------------------------------------|
| enqueue(T element) | O(1) ou O(n) | Escrita |
| dequeue() | O(1) ou O(n) | Escrita |
| peek() | O(1) | Leitura |
| isEmpty() | O(1) | Leitura |
| isFull() | O(1) | Leitura |
| contains(T element) | O(n) | Leitura |
| clear() | O(1) ou O(n) | Escrita |
| list() | O(n) | Leitura |
| increaseCapacity() | O(n) | Escrita (Para filas dinâmicas apenas) |

> ***As complexidades variam conforme a implementação. Consulte cada seção abaixo para detalhes.***

---

## Quando Usar

**Use Filas quando:**

- Necessita de acesso FIFO (First In, First Out)
- Implementação de agendamento ou gerenciamento de tarefas
- Processamento de fluxos de dados em ordem
- Travessia BFS (Busca em Largura) em grafos
- Buffer de mensagens ou trabalhos de impressão

**Evite Filas quando:**

- Precisa de acesso LIFO (use Pilha)
- Precisa acessar elementos no meio
- Busca por elementos específicos é frequente
- Precisa de acesso aleatório por índice

---

## Exemplo de Uso
```java
// Fila com Array Dinâmico
DinamicArrayQueue<String> fila = new DinamicArrayQueue<>();

fila.enqueue("A"); // O(1) - adiciona no final
fila.enqueue("B"); // O(1)
String frente = fila.peek(); // O(1) - consulta sem remover
String removido = fila.dequeue(); // O(n) - remove da frente
boolean vazia = fila.isEmpty(); // O(1)
```

---

## Detalhes de Implementação

### Implementações Disponíveis

| Implementação | Estrutura | Cresce | Uso de Memória | Uso | Implementado GitHub |
|---------------|-----------|--------|----------------|-----|---------------------|
| Array Estático | Array | ❌ | Médio | Didático | ✔ |
| Array Dinâmico | Array | ✔ | Médio | Geral | ✔ |
| Array Circular | Array | ❌ | Médio | Eficiente | ✔ |
| Simples Encadeada | Nós | ✔ | Alto | Acadêmico | ✔ |
| Fila de Prioridade | Array | ✔ | Médio | Ordenado | ✔ |

**Diferenças entre implementações:**
- **Array Estático**: Usa `ArrayStructure`, capacidade fixa, lança exceção em overflow
- **Array Dinâmico**: Usa `ArrayStructure` + `increaseCapacity()` para crescimento automático, porém `dequeue()` é O(n) por causa do deslocamento de elementos
- **Array Circular**: Usa `ArrayStructure` com ponteiros `start` e `end`, evita deslocamento de elementos para enqueue e dequeue O(1)
- **LinkedQueue (lista simples encadeada)**: Usa `NodeStructure`, tamanho dinâmico, porém `enqueue()` é O(n) por causa da travessia até a cauda
- **Fila de Prioridade**: Estende `DinamicArrayQueue`, insere elementos em ordem usando `Comparable`

> ***A diferença das implementações se baseia nos BigO's de cada operação. Por exemplo, a Fila Circular alcança O(1) para enqueue e dequeue ao evitar o deslocamento de elementos, enquanto a Fila de Array Estático ou Dinâmico possui dequeue O(n) pela necessidade de deslocar todos os elementos restantes para a esquerda.***

---

### Fila de Array Estático

A StaticArrayQueue utiliza um array de tamanho fixo herdado de `ArrayStructure`. Os elementos são sempre armazenados a partir do índice 0. Quando um elemento é removido, todos os elementos restantes são deslocados uma posição para a esquerda.

Características:

- Capacidade fixa definida na construção
- Lança `RuntimeException` em overflow (enqueue quando cheia)
- Retorna `null` em underflow (dequeue ou peek quando vazia)
- `dequeue()` é O(n) por causa do deslocamento de elementos

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| enqueue(T element) | O(1) |
| dequeue() | O(n) |
| peek() | O(1) |
| contains(T element) | O(n) |
| clear() | O(n) |
| list() | O(n) |

**Exemplo prático:**

```java
StaticArrayQueue<Integer> fila = new StaticArrayQueue<>(3);

fila.enqueue(10); // [10]
fila.enqueue(20); // [10, 20]
fila.enqueue(30); // [10, 20, 30]
fila.dequeue();   // retorna 10, desloca: [20, 30]
fila.peek();      // retorna 20, fila inalterada
fila.enqueue(40); // [20, 30, 40]
```

---

### Fila de Array Dinâmico

A DinamicArrayQueue utiliza um array redimensionável herdado de `ArrayStructure`. Cresce automaticamente quando a capacidade é excedida via `increaseCapacity()`. Assim como a versão estática, o dequeue exige o deslocamento de todos os elementos.

Características:

- Inicia com capacidade padrão, cresce conforme necessário
- `enqueue()` é O(1) normalmente, O(n) quando ocorre redimensionamento
- `dequeue()` é sempre O(n) por causa do deslocamento de elementos
- `clear()` preenche todo o array com `null`

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| enqueue(T element) | O(1) ou O(n) |
| dequeue() | O(n) |
| peek() | O(1) |
| contains(T element) | O(n) |
| clear() | O(n) |
| list() | O(n) |

**Exemplo prático:**

```java
DinamicArrayQueue<String> fila = new DinamicArrayQueue<>();

fila.enqueue("A"); // ["A"]
fila.enqueue("B"); // ["A", "B"]
fila.enqueue("C"); // ["A", "B", "C"]
fila.dequeue();    // retorna "A", desloca: ["B", "C"]
fila.peek();       // retorna "B"
fila.contains("C"); // true
```

---

### Fila Circular

A CircularQueue utiliza um array de tamanho fixo com dois ponteiros, `start` e `end`, que avançam de forma circular usando o operador módulo (`%`). Isso elimina a necessidade de deslocar elementos, alcançando O(1) tanto para enqueue quanto para dequeue.

Características:

- Capacidade fixa definida na construção
- Utiliza um slot extra para distinguir fila cheia de vazia (`size == length - 1` significa cheia)
- `end` e `start` avançam circularmente: `ponteiro = (ponteiro + 1) % length`
- Lança `RuntimeException` em overflow
- Retorna `null` em underflow

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| enqueue(T element) | O(1) |
| dequeue() | O(1) |
| peek() | O(1) |
| isEmpty() | O(1) |
| isFull() | O(1) |
| contains(T element) | O(n) |
| clear() | O(1) |
| list() | O(n) |

**Exemplo prático:**

```java
CircularQueue<Integer> fila = new CircularQueue<>(4); // capacidade 4, slots utilizáveis: 3

fila.enqueue(10); // start=0, end=1
fila.enqueue(20); // start=0, end=2
fila.enqueue(30); // start=0, end=3 — CHEIA
fila.dequeue();   // retorna 10, start=1, end=3
fila.enqueue(40); // start=1, end=0 — volta ao início
fila.peek();      // retorna 20
```

**Como o avanço circular funciona:**

```java
// enqueue: coloca o elemento em end, depois avança end circularmente
this.elements[end] = element;
end = (end + 1) % this.elements.length;

// dequeue: lê o elemento em start, depois avança start circularmente
T removed = this.elements[start];
start = (start + 1) % this.elements.length;
```

---

### Fila Encadeada

A LinkedQueue utiliza uma lista simplesmente encadeada via `NodeStructure`. Cada nó armazena dados e uma referência ao próximo nó. O ponteiro `head` sempre aponta para a frente da fila.

Características:

- Tamanho dinâmico, sem capacidade fixa
- `enqueue()` é O(n) pois deve percorrer a lista para encontrar a cauda
- `dequeue()` é O(1) pois apenas reatribui o ponteiro head
- `clear()` anula explicitamente cada nó para auxiliar o coletor de lixo

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| enqueue(T element) | O(n) |
| dequeue() | O(1) |
| peek() | O(1) |
| contains(T element) | O(n) |
| clear() | O(n) |
| list() | O(n) |

**Exemplo prático:**

```java
LinkedQueue<String> fila = new LinkedQueue<>();

fila.enqueue("X"); // head -> [X]
fila.enqueue("Y"); // head -> [X] -> [Y]
fila.enqueue("Z"); // head -> [X] -> [Y] -> [Z]
fila.dequeue();    // retorna "X", head -> [Y] -> [Z]
fila.peek();       // retorna "Y"
```

> ***A LinkedQueue possui enqueue O(n) porque não há um ponteiro de cauda. Para alcançar enqueue O(1), seria necessário manter uma referência à cauda junto ao head.***

---

### Fila de Prioridade

A PriorityQueue estende `DinamicArrayQueue` e insere elementos em ordem usando a interface `Comparable`. A frente da fila sempre contém o elemento com o menor valor.

Características:

- Estende `DinamicArrayQueue`, herdando todas as suas operações
- `enqueue()` encontra a posição correta de inserção via varredura linear, depois chama `add(i, element)`
- Na literatura, filas de prioridade são tipicamente implementadas com Heap para enqueue O(log n), esta implementação usa array ordenado para fins didáticos
- Os elementos devem implementar `Comparable`

Complexidade das operações:

| Operação | Complexidade |
|----------------------|------------|
| enqueue(T element) | O(n) — varredura linear (O(log n) com Heap) |
| dequeue() | O(n) — herdado de DinamicArrayQueue |
| peek() | O(1) |
| contains(T element) | O(n) |
| clear() | O(n) |

**Exemplo prático:**

```java
PriorityQueue<Integer> fila = new PriorityQueue<>();

fila.enqueue(30); // [30]
fila.enqueue(10); // [10, 30] — inserido antes do 30
fila.enqueue(20); // [10, 20, 30] — inserido entre 10 e 30
fila.dequeue();   // retorna 10 — menor valor primeiro
fila.peek();      // retorna 20
```

**Como a inserção ordenada funciona:**

```java
// Encontra a primeira posição onde o elemento é menor que o elemento atual
Comparable<T> key = (Comparable<T>) element;
int i;
for (i = 0; i < size; i++) {
    if (key.compareTo(elements[i]) < 0) {
        break;
    }
}
this.add(i, element); // insere na posição i, deslocando os elementos para a direita
```

---