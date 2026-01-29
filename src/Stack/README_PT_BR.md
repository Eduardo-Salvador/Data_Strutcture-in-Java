<div align="center">

![Generic badge](https://img.shields.io/badge/STATUS-FINALIZADO-<COLOR>.svg)

# Pilhas

---

Explicação da Estrutura de Dados Pilha, suas operações principais e complexidades.

---

## Tecnologias
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

---

## Visão Geral

***Uma pilha é uma estrutura de dados que funciona como uma pilha de pratos, ou caixas:***

Você coloca uma caixa em cima da outra e só pode retirar a de cima primeiro. **Isso é chamado de LIFO:**

LIFO → Last in, First Out (O ultimo a entrar é o primeiro a sair).

---

## Por que Pilhas:

- Organiza dados de forma controlada, com acesso apenas ao topo.
- Evita erros onde a ordem de execução importa.
- Facilita o gerenciamento de memória e chamadas de função.
- Usadas para chamadas recursivas, de função, chamadas de APIs, etc.

---

## Complexidade das Operações


| Operação             | Complexidade | Tipo                                   |
|----------------------|--------------|----------------------------------------|
| push(E element)      | O(1)         | Escrita                                |
| pop()   | O(1)         | Escrita                                |
| peek()          | O(1)         | Leitura                                |
| isEmpty()       | O(1)         | Escrita                                |
| size()        | O(1)         | Escrita                                |
| search(E element)    | O(n)         | Escrita                                |
| increaseCapacity()     | O(n)         | Leitura (Para pilhas dinâmicas apenas) |

---

## Quando Usar

**Use Pilhas quando:**
- Necessita de acesso LIFO (Last In, First Out)
- Implementação de recursão ou backtracking
- Desfazer operações (Undo)
- Avaliação de expressões matemáticas
- Navegação de histórico (browser)

**Evite Pilhas quando:**
- Precisa acessar elementos no meio
- Necessita de acesso FIFO (use Fila)
- Busca por elementos específicos é frequente
- Precisa de acesso aleatório por índice

---

## Exemplo de Uso
```java
// Pilha com Array Dinâmico
Stack<String> pilha = new Stack<>();
pilha.push("A");        // O(1) - adiciona no topo
pilha.push("B");        // O(1)
String topo = pilha.peek();  // O(1) - consulta sem remover
String removido = pilha.pop();  // O(1) - remove do topo
boolean vazia = pilha.isEmpty();  // O(1)
```

---

## Detalhes de Implementação

### Implementações Disponíveis

| Implementação | Estrutura | Cresce | Uso de Memória | Uso | Implementado GitHub |
|---------------|-----------|--------|----------------|-----|---------------------|
| Array estático | Array | ❌ | Médio | Didático | ✔ |
| Array dinâmico | Array | ✔ | Médio | Geral | ✔ |
| Simples Encadeada | Nós | ✔ | Alto | Acadêmico | ✔ |
| Call Stack | JVM | ✔ | JVM | Conceitual | N/A |

**Diferenças entre implementações:**
- **Array Fixo**: Usa `ArrayStructure`, requer variável `topo` (ou `size`), sem redimensionamento
- **Array Dinâmico**: Usa `ArrayStructure` + `increaseCapacity()` para crescimento automático
- **LinkedStack (lista simples encadeada)**: Usa `NodeStructure`, mais flexível mas complexa (ponteiros)

> ***A diferença das implementações se baseia nos BigO's de cada operação. Por exemplo, o acesso a uma lista encadeada tem complexidade maior que de um Array estático ou dinâmico.***

---

### Call Stack (Pilha de Chamadas)

A **Call Stack** é uma estrutura de dados fundamental que a JVM usa para gerenciar a execução de métodos em um programa Java.

**Características:**
- Cada thread tem sua própria Call Stack privada
- Criada simultaneamente com a thread

**Estrutura de um Stack Frame:**

Quando um método é invocado, a JVM cria um **stack frame** contendo:
- **Variáveis locais** do método
- **Parâmetros** recebidos
- **Valor de retorno** (quando aplicável)
- **Referência** ao método chamador
- **Operand stack** (pilha de operandos para cálculos intermediários)

Este frame é empilhado no topo da Call Stack. Quando o método termina, o frame é desempilhado e o controle retorna ao método chamador.

**Exemplo prático:**
```java
public class ExemploCallStack {
    public static void main(String[] args) {
        metodoA();
    }
    
    static void metodoA() {
        metodoB();
    }
    
    static void metodoB() {
        metodoC();
    }
    
    static void metodoC() {
        // Aqui a stack está: main -> metodoA -> metodoB -> metodoC
        throw new RuntimeException("Erro!");
    }
}
```

Quando você vê o **stack trace** de uma exceção, está literalmente vendo o conteúdo da Call Stack no momento do erro, de baixo para cima.

#### StackOverflowError

Se houver muitas chamadas recursivas ou uma recursão infinita, a Call Stack atinge seu limite de tamanho e a JVM lança um `StackOverflowError`.

**Configuração:** O tamanho da stack pode ser ajustado com a flag `-Xss` na JVM.
```java
// Exemplo que causa StackOverflowError
public static void recursaoInfinita() {
    recursaoInfinita();  // Nunca retorna!
}
```

---