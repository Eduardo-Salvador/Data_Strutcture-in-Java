<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINALIZADO-<COLOR>.svg)

# Algoritmos de Busca

---

Explicação dos algoritmos de busca, suas estratégias e complexidades.

---

## Tecnologias
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Visão Geral

***Um algoritmo de busca localiza um elemento alvo em uma coleção seguindo uma estratégia definida:***

A escolha da estratégia determina quantos elementos precisam ser examinados antes que o alvo seja encontrado ou confirmado ausente. Isso é expresso como complexidade de tempo e é a principal métrica para comparar algoritmos de busca.

As duas estratégias fundamentais são a **busca linear** e a **busca binária**. A busca linear examina cada elemento do início ao fim, simples e funciona em qualquer coleção, mas é O(n) no pior caso. A busca binária elimina metade dos candidatos restantes a cada passo, muito mais eficiente com O(log n), mas exige que a coleção esteja ordenada previamente.

Além dessas, estruturas mais especializadas como tabelas hash alcançam busca O(1) em média calculando diretamente a posição do elemento, e estruturas baseadas em árvore como BSTs alcançam busca O(log n) por meio de particionamento hierárquico.

O algoritmo correto depende de três fatores: se os dados estão ordenados, com que frequência a busca é realizada, e o custo de pré-processar a coleção.

---

## Comparação de Algoritmos

| Algoritmo | Requer Entrada Ordenada | Complexidade de Tempo (Melhor) | Complexidade de Tempo (Pior) | Complexidade de Espaço |
|----------------------|-----------------------|-------------------------------|------------------------------|------------------------|
| Busca Linear | ❌ | O(1) | O(n) | O(1) |
| Busca Binária | ✔ | O(1) | O(log n) | O(log n) recursivo |
| Busca em Hash Table | ❌ | O(1) | O(n) colisão | O(n) |
| Busca em BST | ✔ inserção ordenada | O(1) | O(n) desbalanceada | O(n) |

---

## Busca Binária

***A Busca Binária encontra um alvo em um array ordenado dividindo repetidamente o espaço de busca ao meio:***

A cada passo, compara o alvo com o elemento do meio. Se o alvo for menor, a metade direita é descartada. Se for maior, a metade esquerda é descartada. Isso continua até o alvo ser encontrado ou o espaço de busca se esgotar.

---

### Por que Busca Binária:

- Reduz a busca linear O(n) para O(log n) aproveitando a ordem dos elementos.
- Para 1.000.000 de elementos, a busca linear pode examinar até 1.000.000 elementos; a busca binária examina no máximo 20.
- O custo de ordenar o array previamente é O(n log n), que é rapidamente amortizado quando múltiplas buscas são realizadas.
- Usada em métodos da biblioteca padrão como `Arrays.binarySearch()` e como sub-rotina em algoritmos como o particionamento do Quick Sort.

---

### Complexidade das Operações

| Operação | Complexidade de Tempo | Complexidade de Espaço |
|----------------------|----------------------|------------------------|
| binarySearch() | O(log n) | O(log n) pilha recursiva |

> ***A complexidade de espaço é O(log n) porque a implementação recursiva adiciona um stack frame por etapa de divisão. Uma implementação iterativa reduziria o espaço para O(1).***

---

### Quando Usar

**Use Busca Binária quando:**

- O array está ordenado ou pode ser ordenado antes de buscas repetidas
- O desempenho da busca é crítico e a varredura linear O(n) é muito lenta
- A coleção é estática ou muda com pouca frequência

**Evite Busca Binária quando:**

- A coleção não está ordenada e ordená-la previamente não é viável
- Apenas uma única busca é realizada em uma coleção não ordenada (busca linear é mais simples)
- A coleção usa uma estrutura encadeada sem acesso O(1) por índice

---

### Exemplo de Uso
```java
Integer[] array = new Integer[]{1, 3, 5, 7, 9, 11, 13};
// O array deve estar ordenado antes de chamar binarySearch
Integer indice = BinarySearch.binarySearch(array, 7); // retorna 3
Integer ausente = BinarySearch.binarySearch(array, 4); // retorna -1
```

---

### Detalhes de Implementação

Esta implementação usa um helper privado recursivo que recebe `start`, `end` e um parâmetro `counter`. O método público inicializa a busca sobre o array completo chamando `helper(array, target, 0, array.length - 1, 0)`.

O ponto médio é calculado como `start + ((end - start) / 2)` em vez de `(start + end) / 2` para evitar overflow de inteiro quando `start` e `end` são índices grandes.

A cada chamada, um de três resultados ocorre: o elemento do meio coincide com o alvo e seu índice é retornado; o alvo é maior que o meio e a busca continua na metade direita; o alvo é menor e a busca continua na metade esquerda. Se `start > end`, o espaço de busca está esgotado e -1 é retornado.

Pilha de chamadas buscando `7` em `[1, 3, 5, 7, 9, 11, 13]`:

```
helper(array, 7, 0, 6)  → mid=3, array[3]=7 → encontrado, retorna 3
```

Pilha de chamadas buscando `6` em `[1, 3, 5, 7, 9, 11, 13]`:

```
helper(array, 6, 0, 6)  → mid=3, array[3]=7, 6 < 7  → vai para esquerda
helper(array, 6, 0, 2)  → mid=1, array[1]=3, 6 > 3  → vai para direita
helper(array, 6, 2, 2)  → mid=2, array[2]=5, 6 > 5  → vai para direita
helper(array, 6, 3, 2)  → start > end                → retorna -1
```

**Como o ponto médio e a divisão funcionam:**

```java
int mid = start + ((end - start) / 2); // ponto médio seguro contra overflow

if (array[mid].equals(elementSearch)) {
    return mid; // encontrado
}
if (elementSearch > array[mid]) {
    return helper(array, elementSearch, mid + 1, end, counter); // descarta metade esquerda
}
return helper(array, elementSearch, start, mid - 1, counter); // descarta metade direita
```

**Exemplo prático:**

```java
Random random = new Random();
Integer[] array = new Integer[1_000_000];
for (int i = 0; i < array.length; i++) {
    array[i] = random.nextInt(100_000);
}
Arrays.sort(array); // busca binária exige entrada ordenada

Integer result = BinarySearch.binarySearch(array, array[array.length - 1]);

// Saída esperada (aproximada):
// Binary Search Time O(logN):  ~1 μs
// Linear Search Time O(n):     ~3000 μs
```

> ***O método main inclui um laço de aquecimento da JVM de 100 iterações antes do benchmark. Isso força a compilação JIT do método antes da execução cronometrada, produzindo uma medição mais precisa do desempenho em estado estável.***

---