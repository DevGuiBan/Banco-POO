# <img src="https://cdn.icon-icons.com/icons2/2601/PNG/512/piggy_bank_icon_155904.png" alt="Banco Logo" width="40" height="40"> Sistema Bancário Simples <img src="https://cdn.icon-icons.com/icons2/2601/PNG/512/piggy_bank_icon_155904.png" alt="Banco Logo" width="40" height="40">

Este projeto é uma aplicação de sistema bancário que permite gerenciar usuários com diferentes tipos de contas, como Conta Corrente e Conta Poupança. Ele foi desenvolvido como parte de um exercício de Programação Orientada a Objetos (POO) e inclui os seguintes conceitos:


Este projeto é uma aplicação de sistema bancário que permite gerenciar usuários com diferentes tipos de contas, como Conta Corrente e Conta Poupança. Ele foi desenvolvido como parte de um exercício de Programação Orientada a Objetos (POO) e inclui os seguintes conceitos:

- Herança
- Encapsulamento
- Reescrita de métodos
- Tratamento de exceções

## Funcionalidades

- **Cadastro de Contas**: O usuário pode se cadastrar com dados como nome, CPF e saldo inicial.
- **Operações de Conta**: Depósitos, saques e contas correntes.
- **Visualização de Dados**: Os dados de cada usuário e sua conta podem ser visualizados na tela, incluindo tipo de conta, saldo, limite e número da conta.

## Estrutura de Classes

- **Usuario**: Classe base que contém atributos classicos de usuário como nome, CPF, etc...
- **Conta**: Classe derivada de Pessoa, que adiciona funcionalidades como depósito e saque.
- **ContaCorrente**: Classe filha de Conta, que implementa funcionalidades específicas de uma conta corrente, como o uso de crédito.

## Requisitos Não Funcionais

- **Encapsulamento**: Todos os atributos das classes estão privados e são acessados via getters e setters.
- **Tratamento de Erros**: Todos os métodos que realizam operações financeiras tratam possíveis erros, como saldo insuficiente e valores inválidos.

## Como Executar

Clone o projeto e compile os arquivos Java, certificando-se que todos as dependências estão instaladas:

#### Dependências:
- IDE
- JDK

No escolha o diretório e com o terminal utilize o comando:
```
git clone https://github.com/DevGuiBan/Banco-POO.git
```

## Equipe

- Guilherme Bandeira
- Vinicius Guedes
- Daniel Rodrigues
- Gustavo Habib
