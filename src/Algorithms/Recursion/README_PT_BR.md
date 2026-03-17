<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINALIZADO-<COLOR>.svg)

# Recursão

---

Explicação das estratégias recursivas, suas estruturas e complexidades.

---

## Tecnologias
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Visão Geral

***Recursão é uma técnica onde uma função resolve um problema chamando a si mesma com uma entrada menor até que um caso base seja alcançado:***

Em vez de usar laços explícitos, a função delega parte do trabalho para uma nova chamada de si mesma. Cada chamada é empilhada na Call Stack como um stack frame e só é resolvida após todas as chamadas subsequentes retornarem.

Toda função recursiva exige duas partes: um **caso base** que interrompe a recursão, e um **caso recursivo** que reduz o problema em direção ao caso base. Sem um caso base, a Call Stack cresce indefinidamente e a JVM lança um `StackOverflowError`.

A recursão é naturalmente adequada para problemas com estrutura auto-similar, onde a solução para a entrada completa é definida em termos da solução para uma entrada menor do mesmo tipo.

---

## Estrutura da Recursão

Toda função recursiva de dividir e conquistar possui duas partes obrigatórias:

**Caso base:** a condição que interrompe a recursão. Sem ele, a pilha de chamadas cresce indefinidamente e lança um `StackOverflowError`.

**Caso recursivo:** a chamada que reduz o problema em um passo e delega o restante.

```java
public static Integer sum(Integer[] array, int index) {
    // Caso base: nada mais a processar
    if (index >= array.length) {
        return 0;
    }
    // Caso recursivo: elemento atual + resultado do subarray restante
    return array[index] + sum(array, index + 1);
}
```

---

## Dividir e Conquistar

***Dividir e Conquistar é uma estratégia recursiva que resolve um problema dividindo-o em subproblemas menores do mesmo tipo:***

Cada chamada recursiva processa um elemento e delega o restante para a próxima chamada. **A estrutura sempre segue três etapas:**

Dividir → reduz o problema em uma unidade. Conquistar → resolve o caso base. Combinar → retorna o resultado acumulado pela pilha de chamadas.

---

## Por que Dividir e Conquistar:

- Divide problemas complexos em casos base trivialmente simples.
- Elimina a necessidade de laços explícitos ao expressar iteração como recursão.
- Produz código limpo e legível para problemas com estrutura naturalmente recursiva.
- Serve como base para algoritmos como Merge Sort, Quick Sort e Busca Binária.

---

## Complexidade das Operações

| Algoritmo | Complexidade de Tempo | Complexidade de Espaço |
|----------------------|----------------------|------------------------|
| ArraySum | O(n) | O(n) |
| CountElements | O(n) | O(n) |
| MaxValue | O(n) | O(n) |

> ***A complexidade de espaço é O(n) em todas as implementações porque cada chamada recursiva adiciona um stack frame à Call Stack. Para um array de n elementos, n frames estão ativos simultaneamente antes de o caso base ser alcançado.***

---

## Quando Usar

**Use recursão Dividir e Conquistar quando:**

- O problema pode ser reduzido processando um elemento por vez
- A solução para a entrada completa depende da solução de uma entrada menor
- O problema possui um caso base claro e alcançável
- Legibilidade e clareza estrutural importam mais que desempenho bruto

**Evite quando:**

- A entrada é muito grande e a profundidade da pilha é uma preocupação (risco de `StackOverflowError`)
- Uma solução iterativa com espaço O(1) é preferida por razões de desempenho
- Os subproblemas se sobrepõem e os resultados devem ser armazenados em cache (use Programação Dinâmica)

---

## Exemplo de Uso
```java
// Soma de todos os elementos em um array
Integer[] array = new Integer[]{1, 2, 3, 4, 5};
Integer resultado = ArraySum.sum(array); // 15

// Contar elementos em uma lista
List<Integer> lista = new ArrayList<>(List.of(10, 20, 30));
Integer contagem = ItemsInTheListArray.counterListElements(lista, 0); // 3

// Valor máximo em um array
Integer[] valores = new Integer[]{3, 7, 1, 9, 4};
Integer max = MaxValueInListArray.max(valores, 0, 0); // 9
```

---

## Detalhes de Implementação

### Implementações Disponíveis

| Implementação | Entrada | Estratégia | Implementado GitHub |
|---------------|---------|------------|---------------------|
| ArraySum | Integer[] | Acumula pelo retorno | ✔ |
| CountElements | List, Array | Acumula pelo índice | ✔ |
| MaxValue | List, Integer[] | Acumula pelo parâmetro | ✔ |

**Diferenças entre implementações:**
- **ArraySum**: Acumula o resultado pelo valor de retorno, cada frame adiciona seu elemento ao valor retornado pela próxima chamada
- **CountElements**: Acumula pelo índice, o caso base retorna o valor final do índice, que é igual ao tamanho da coleção
- **MaxValue**: Acumula pelo parâmetro, o máximo atual é carregado para frente em cada chamada, em vez de ser calculado no retorno

> ***A diferença entre essas estratégias está em quando o trabalho acontece. No ArraySum, a adição ocorre no retorno da pilha (depois que a chamada recursiva retorna). No MaxValue, a comparação ocorre na descida (antes de a chamada recursiva ser feita). Ambas são abordagens válidas de dividir e conquistar.***

---

### ArraySum

ArraySum calcula a soma de todos os elementos de um array de inteiros. Um método auxiliar privado recebe o índice como parâmetro, isolando a lógica recursiva da API pública. Cada frame retorna o elemento no seu índice somado ao resultado do subarray restante.

Pilha de chamadas para `{1, 2, 3}`:

```
sum(array, 0) = 1 + sum(array, 1)
                    = 2 + sum(array, 2)
                            = 3 + sum(array, 3)
                                      = 0  ← caso base
```

**Exemplo prático:**

```java
Integer[] array = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
Integer resultado = ArraySum.sum(array);
System.out.println("Array Sum: " + resultado); // 45
```

---

### CountElements

CountElements conta o número de elementos em uma List ou array sem usar `.size()` ou `.length`. O índice avança uma posição a cada chamada até igualar o tamanho da coleção, momento em que o próprio índice é retornado como a contagem.

Pilha de chamadas para `[A, B, C]`:

```
counter(list, 0) → counter(list, 1)
                       → counter(list, 2)
                               → counter(list, 3)
                                       → retorna 3  ← caso base, index == size
```

**Exemplo prático:**

```java
List<Integer> lista = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 2, 5, 2));
Integer resultadoLista = ItemsInTheListArray.counterListElements(lista, 0);
// resultadoLista = 14

String[] array = new String[]{"One", "Two", "Three", "Four"};
Integer resultadoArray = ItemsInTheListArray.counterListElements(array, 0);
// resultadoArray = 4
```

---

### MaxValue

MaxValue encontra o maior valor em uma List ou array. O máximo atual é passado como parâmetro em cada chamada. Se o elemento no índice atual for maior que o máximo armazenado, ele o substitui antes da próxima chamada recursiva.

Pilha de chamadas para `[3, 9, 1]`:

```
max(list, 0, 0) → 3 > 0, maxValue=3
    max(list, 1, 3) → 9 > 3, maxValue=9
        max(list, 2, 9) → 1 < 9, maxValue=9
            max(list, 3, 9) → retorna 9  ← caso base
```

**Exemplo prático:**

```java
List<Integer> lista = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 23, 42, 12));
Integer resultadoLista = MaxValueInListArray.max(lista, 0, 0);
// resultadoLista = 42

Integer[] array = new Integer[]{0, 1, 44, 23, 192, 321, 4, 2, 1, 1};
Integer resultadoArray = MaxValueInListArray.max(array, 0, 0);
// resultadoArray = 321
```

---