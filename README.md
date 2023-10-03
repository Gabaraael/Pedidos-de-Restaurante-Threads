# Sistema de Pedidos de Restaurante - Documentação

Este é um sistema de pedidos de restaurante baseado no conceito de produtor-consumidor. O sistema permite que clientes façam pedidos de diferentes categorias (entrada, prato principal, sobremesa), os quais são preparados por cozinheiros.

## Visão Geral

O sistema consiste em três componentes principais: clientes, cozinheiros e uma fila de pedidos. Os clientes fazem pedidos que são adicionados à fila de pedidos. Os cozinheiros removem pedidos da fila, preparam os pratos e notificam os clientes quando estão prontos para serem servidos.

### Classe Cliente

A classe `Cliente` representa os clientes do restaurante. Cada cliente é uma thread que faz pedidos, espera a preparação e consome os pedidos.

- **Método Construtor:** `Cliente(String nome, FilaPedidos filaPedidos)`
  - `nome`: Nome do cliente.
  - `filaPedidos`: Fila de pedidos onde os pedidos serão adicionados.

- **Método `run()`:**
  - Faz três pedidos aleatórios (entrada, prato principal, sobremesa).
  - Adiciona os pedidos à fila de pedidos.
  - Aguarda até que os pedidos estejam prontos para serem servidos.
  - Exibe mensagens indicando os pedidos feitos e consumidos.

### Classe Cozinheiro

A classe `Cozinheiro` representa os cozinheiros do restaurante. Cada cozinheiro é uma thread que prepara os pedidos.

- **Método Construtor:** `Cozinheiro(FilaPedidos filaPedidos)`
  - `filaPedidos`: Fila de pedidos da qual os cozinheiros retiram pedidos para preparar.

- **Método `run()`:**
  - Remove pedidos da fila de pedidos.
  - Simula o tempo de preparo do pedido.
  - Marca o pedido como pronto para ser servido.
  - Exibe mensagens indicando a preparação do pedido.

### Classe FilaPedidos

A classe `FilaPedidos` é responsável por gerenciar a fila de pedidos pendentes dos clientes.

- **Método `adicionarPedido(Pedido pedido)`:**
  - Adiciona um pedido à fila de pedidos.
  - Notifica outras threads se estiverem esperando por pedidos.

- **Método `removerPedido()`:**
  - Remove um pedido da fila de pedidos.
  - Aguarda se a fila estiver vazia.

### Classe Categoria (enum)

A classe `Categoria` é uma enumeração que define as categorias de itens do cardápio (entrada, prato principal, sobremesa). Ela também fornece métodos para obter valores aleatórios dentro de uma categoria.

## Como Usar

1. Clone o repositório do projeto.

2. Compile as classes e execute o programa.

3. O sistema gerará automaticamente um número aleatório de clientes (20 a 50) e cozinheiros (5 a 10).

4. Os clientes farão pedidos aleatórios e os cozinheiros prepararão esses pedidos.

5. O sistema exibirá mensagens indicando as ações dos clientes e cozinheiros.
