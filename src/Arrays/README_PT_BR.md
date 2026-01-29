<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINALIZADO-<COLOR>.svg)

# Arrays

---

Explicação da Estrutura de Dados Array, suas operações principais e complexidades.

---

## Tecnologias
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Visão Geral

- **Arrays armazenam de forma contínua na memória**, sendo assim **mesmo que tenhamos o exato espaço dísponivel na memória, se ele não estiver alinhado, não conseguira alocar.**
- **Arrays aceitam apenas Objetos do mesmo tipo** na memória.
- Arrays tem **tempo de leitura O(1) e Escrita O(n)** em sua grande maioria, pois devem deslocar todos elementos para escrever em um lugar que já exite algo.
- **Arrays tem tamanho fíxo**, sendo assim podem ter elementos vazios, ou espaço insufíciente.
- **São impementados pela classe ArrayList do Java, ou apenas instânciados por vetores comuns (menos métodos).**

---

## Complexidade das Operações

| Operação               | Complexidade | Tipo |
|------------------------|--------------|------|
| add(element)           | O(1)         | Escrita |
| add(index, element)    | O(n)         | Escrita |
| get(index)             | O(1)         | Leitura |
| set(int index)         | O(1)         | Escrita |
| remove(index)          | O(n)         | Escrita |
| remove(E element)      | O(n)         | Escrita |
| indexOf(element)       | O(n)         | Leitura |
| size()                 | O(1)         | Leitura |
| isEmpty()              | O(1)         | Leitura |
| contains(E element)    | O(n)         | Leitura |
| clear()                | O(n) ou O(1) | Escrita |
| getFirst()             | O(1)         | Leitura |
| getLast()              | O(1)         | Leitura |
| lastIndexOf(E element) | O(n)         | Leitura |

---

## Quando Usar

**Use Arrays quando:**
- Acesso frequente por índice
- Tamanho fixo ou previsível
- Leitura é mais comum que escrita
- Memória contígua é importante

**Evite Arrays quando:**
- Muitas inserções/remoções no meio
- Tamanho altamente dinâmico
- Precisa de ordenação constante

---

## Exemplo de Uso
```java
ArrayList<Integer> numeros = new ArrayList<>();
numeros.add(10);        // O(1) - adiciona no final
numeros.add(0, 5);      // O(n) - desloca elementos
int valor = numeros.get(1);  // O(1) - acesso direto
```

---

## Detalhes de Implementação

Esta implementação utiliza:
- **Variável `size`**: controla quantidade de elementos válidos
- **Array interno**: armazena os elementos
- **Classe `ArrayStructure`**: classe pai com operações comuns
- **Redimensionamento**: quando capacidade é excedida (increaseCapacity)

---