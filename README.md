<div align="center">

[![Generic badge](https://img.shields.io/badge/STATUS-IN_PROGRESS-<COLOR>.svg)](https://shields.io/) [![Ask Me Anything !](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](https://github.com/Eduardo-Salvador)

---

# Quick Navigation

#### [Overview](#data-structure-in-java)
#### [Technologies](#technologies)
#### [Big O Complexity](#bigo-complexity)
#### [Linear Structures](#linear-structures--estruturas-lineares)
#### [Non-Linear Structures](#non-linear-structures--estruturas-não-lineares)
#### [Advanced Structures](#advanced-structures--estruturas-avançadas)
#### [Optimization Exercises](#optimization-exercises)
#### [Algorithms](#algorithms--algoritmos)
#### [Highlighted Results](#highlighted-results)

---

# Data Structure and Algorithms in Java

---

A study project on data structures and algorithms in Java, focused on understanding computational cost and in the main algorithms that need to be learned.

Um projeto de estudo sobre estruturas de dados e algoritmos em Java, focado no aprendizado de custo computacional e nos principais algoritmos que devem ser aprendidos.

---

![USA](https://img.shields.io/badge/🇺🇸-English-blue)

This project covers the study of data structures and algorithms, including:

**Linear Structures (Stacks, Queues, Lists, Deques)  
Non-Linear Structures (Trees, Graphs)  
Advanced Structures (Hash Tables)  
Searching and Sorting Algorithms  
Recursion  
Optimization Exercises  
Complexity Analysis (Big O)**

---

![Brazil](https://img.shields.io/badge/🇧🇷-Português-green)

Este projeto cobre o estudo de estruturas de dados e algoritmos, incluindo:

**Estruturas Lineares (Pilhas, Filas, Listas, Deques)  
Estruturas Não Lineares (Árvores, Grafos)  
Estruturas Avançadas (Tabelas Hash)  
Algoritmos de Busca e Ordenação  
Recursão  
Exercícios de Otimização  
Análise de Complexidade (Big O)**

---

## Technologies

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

<div align="center">

## Important Notes | Observações Importantes

---

![USA](https://img.shields.io/badge/🇺🇸-English-blue)

</div>

- Some package names do not strictly follow the standard Java naming conventions (lowercase structure).  
- This was intentional, as the goal of this repository is educational organization by topic.  
- The deviation does not reflect lack of knowledge regarding best practices, but rather a didactic choice.  

<div align="center">

---

![Brazil](https://img.shields.io/badge/🇧🇷-Português-green)

</div>

- Alguns nomes de pacotes não seguem estritamente as convenções de nomenclatura padrão do Java (estrutura em minúsculas).  
- Isso foi intencional, pois o objetivo deste repositório é a organização educacional por tópico.  
- O desvio não reflete falta de conhecimento sobre as melhores práticas, mas sim uma escolha didática.  

---

<div align="center">

## What are data structures? | O que são estruturas de dados?

---

![USA](https://img.shields.io/badge/🇺🇸-English-blue)

</div>

- Data structures **are ways to organize, store, and manipulate data efficiently.**
- They are like boxes with compartments:
  - **Depending on the type of information and what you need to do with it, one type of box may be better than another.**
- For example, **a queue at a bank is a data structure.**

<div align="center">

---

![Brazil](https://img.shields.io/badge/🇧🇷-Português-green)

</div>

- Estruturas de dados **são formas de organizar, armazenar e manipular dados de maneira eficiente.**
- Elas são como caixas com compartimentos:
  - **Dependendo do tipo de informação e do que você precisa fazer com ela, um tipo de caixa pode ser melhor que a outra.**
- Por exemplo, **uma fila de atendimento no banco é uma estrutura de dados.**

---

<div align="center">

## Why are they important? | Por que são importantes?

---

![USA](https://img.shields.io/badge/🇺🇸-English-blue)

</div>

- **Data structures directly influence the performance of your applications.**
- Using the **right structure can make your program faster, lighter, and even easier to understand.**
- They are **essential in technical interviews (especially for foreign companies), algorithms, and production systems.**
- **They help solve problems efficiently.**
- They improve **computer literacy.**

<div align="center">

---

![Brazil](https://img.shields.io/badge/🇧🇷-Português-green)

</div>

- As **estruturas de dados influenciam diretamente a performance das suas aplicações.**
- Usar a **estrutura certa pode tornar seu programa mais rápido, mais leve, e até mais fácil de entender.**
- São **essenciais em entrevistas técnicas (principalmente para gringa), algoritmos e sistemas em produção.**
- **Ajudam a resolver problemas de forma eficiente.**
- Melhoram o **conhecimento em computação.**

---

<div align="center">

## BigO Complexity | Complexidade Big0

---

![USA](https://img.shields.io/badge/🇺🇸-English-blue)

</div>

**Time vs. Space:**

- An algorithm can be fast but consume a lot of memory, or consume little memory but be slow. Big-O measures both: time (execution) and space (memory used).
- You can cache results to avoid calculations; this uses space but saves time.
- Always consider the worst-case scenario, where `n` is the number of operations needed.

**Complexities:**

- O(1) → **Constant time** (Ex: Accessing an item in an array)
- O(logN) → **Logarithmic** (Ex: Binary search)
- O(n) → **Linear** (Ex: Traversing a list)
- O(n log N) → **Good for sorting algorithms**
- O(n²) → **Bad:** Algorithms with many nested loops
- **Time complexity** → execution time
- **Space complexity** → memory usage
- **Time** = how many times you *process* data
- **Space** = how much data you *store at the same time*

**It is not always possible to have the perfect algorithm, but it can always be improved.**

- Avoid unnecessary loops.
- Use more efficient data structures (HashMap instead of List).
- Divide and Conquer (MergeSort).
- Use cache (memoization).

<div align="center">

---

![Brazil](https://img.shields.io/badge/🇧🇷-Português-green)

</div>

**Tempo vs Espaço:**

- Um **algoritmo pode ser rápido, mas consumir muita memória. Ou consumir pouca memória mas ser lento. Big-O mede as duas coisas: tempo (execução) e espaço (memória usada).**
- Você pode guardar resultados em cache para evitar cálculos; isso gasta espaço, mas economiza tempo.
- **Sempre considerar o pior caso**, sendo `n` a **quantidade de operações necessárias a fazer.**

**Complexidades:**

- O(1) → **Tempo constante** (Ex: Acessar um item do array)
- O(logN) → **Logarítmico** (Ex: Busca binária)
- O(n) → **Linear** (Ex: Percorrer uma lista)
- O(n log N) → **Bom para algoritmos de ordenação**
- O(n²) → **Ruim:** Algoritmos com muitos loops aninhados
- **Complexidade temporal** → tempo de execução
- **Complexidade espacial** → uso de memória
- **Tempo** = quantas vezes você *processa* dados
- **Espaço** = quantos dados você *guarda ao mesmo tempo*

**Nem sempre dá para ter o algoritmo perfeito, mas dá para melhorar.**

- Evitar loops desnecessários.
- Usar estruturas de dados mais eficientes (HashMap ao invés de Lista).
- Dividir e Conquistar (MergeSort).
- Usar cache (memorização).

---

<div align="center">

## Linear Structures | Estruturas Lineares:

---

### Arrays:

[Click here for read in English](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/blob/main/src/Arrays/README.md) | [Click here for read in Portuguese-BR](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/blob/main/src/Arrays/README_PT_BR.md)

---

### Stacks:
Implementations, operations, and complexities of the Stack data structure. Includes conceptual coverage of the JVM Call Stack.

[Click here for read in English](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/blob/main/src/Stacks/README.md) | [Click here for read in Portuguese-BR](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/blob/main/src/Stacks/README_PT_BR.md)

---

### Queues:
Implementations, operations, and complexities of the Queue data structure.

[Click here for read in English](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Queues/README.md) | [Click here for read in Portuguese-BR](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Queues/README_PT_BR.md)

---

### Lists:
Implementations, operations, and complexities of the List data structure.

[Click here for read in English](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Lists/README.md) | [Click here for read in Portuguese-BR](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Lists/README_PT_BR.md)

---

### Deques:
Implementations, operations, and complexities of the Deque data structure.

[Click here for read in English](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Deques/README.md) | [Click here for read in Portuguese-BR](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Deques/README_PT_BR.md)

---

## Non-Linear Structures | Estruturas Não Lineares:

---

## Advanced Structures | Estruturas Avançadas:

---

## Optimization Exercises:
Classical optimization problems solved by applying the right data structure to reduce time or space complexity.

[Click here for read in English](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/OptimizationExercises/README.md) | [Click here for read in Portuguese-BR](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/OptimizationExercises/README_PT_BR.md)

---

## Algorithms | Algoritmos:

### Recursion:
Recursive strategies, base case structure, and practical implementations.

[Click here for read in English](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Algorithms/Recursion/README.md) | [Click here for read in Portuguese-BR](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Algorithms/Recursion/README_PT_BR.md)

---

### Searching:
Searching strategies, algorithm comparison, and practical implementations.

[Click here for read in English](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Algorithms/Searching/README.md) | [Click here for read in Portuguese-BR](https://github.com/Eduardo-Salvador/Data_Strutcture-in-Java/tree/main/src/Algorithms/Searching/README_PT_BR.md)

---

## Highlighted Results

</div>

- Measured benchmarks from exercises where structure or algorithm choice produced a concrete performance difference. All times recorded after JVM warmup.
- Resultados de benchmarks medidos a partir de exercícios onde a estrutura ou o algoritmo de escolha produziram uma diferença concreta de desempenho. Todos os tempos foram registrados após o aquecimento da JVM.

- Coming soon

  | Exercise | Approach A | Approach B | Input Size | Time A | Time B |
  |---|---|---|---|---|---|
  |  |  |  |  |  |  |