# Desafio de Simulação Bancária

## Visão Geral

Este projeto é uma simulação de um sistema bancário simples, desenvolvido inteiramente em Java. O objetivo principal foi aplicar e demonstrar os conceitos fundamentais da Programação Orientada a Objetos (POO) de forma prática. A aplicação modela entidades como Clientes e Contas (Corrente e Poupança) e implementa operações bancárias básicas através de uma aplicação de console.

## Funcionalidades Principais

* **Criação de Clientes e Contas:** Sistema para instanciar clientes e associá-los a diferentes tipos de contas bancárias.
* **Tipos de Conta:** Suporte para Conta Corrente e Conta Poupança, que herdam de uma estrutura de conta comum.
* **Operações Bancárias:**
    * **Depósito:** Adicionar valor ao saldo de uma conta.
    * **Saque:** Retirar valor do saldo.
    * **Transferência:** Mover fundos entre contas.
* **Impressão de Extrato:** Geração de um extrato simples no console com as informações do titular e o saldo da conta.

## Conceitos de POO Aplicados

Este projeto foi uma oportunidade para exercitar os quatro pilares da Programação Orientada a Objetos:

* **Abstração:** A classe `Conta` é abstrata e define um modelo genérico para qualquer tipo de conta, contendo os atributos e métodos essenciais (agência, número, saldo, etc.), enquanto a interface `IConta` define o contrato de operações que toda conta deve implementar.
* **Encapsulamento:** Os detalhes de implementação, como a manipulação do saldo, são protegidos dentro da classe `Conta`. O acesso é feito de forma controlada através de métodos públicos como `sacar()`, `depositar()` e `transferir()`.
* **Herança:** As classes `ContaCorrente` e `ContaPoupanca` herdam da classe `Conta`, reutilizando toda a sua estrutura e lógica base, ao mesmo tempo que implementam seus próprios comportamentos específicos, como o método `imprimirExtrato()`.
* **Polimorfismo:** O método `imprimirExtrato()` é sobrescrito nas classes filhas (`ContaCorrente` e `ContaPoupanca`), permitindo que cada tipo de conta exiba seu extrato de maneira personalizada, mesmo sendo chamadas a partir de um objeto do tipo `Conta`.

## Tecnologias Utilizadas

* **Java:** O projeto foi desenvolvido utilizando Java puro, sem a necessidade de frameworks externos, focando nos fundamentos da linguagem.

## Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/igorpintos/desafio-banco.git](https://github.com/igorpintos/desafio-banco.git)
    ```
2.  **Acesse o diretório do projeto:**
    ```bash
    cd desafio-banco
    ```
3.  **Compile os arquivos Java:**
    ```bash
    javac -d out src/Main.java src/Model/*.java src/Service/*.java
    ```
4.  **Execute a aplicação a partir da pasta `src`:**
    ```bash
    java -cp ../out Main
    ```

## Exemplo de Uso

O código abaixo, presente na classe `Main`, demonstra a criação de um cliente, suas contas e a execução de operações bancárias.

```java
public class Main {
    public static void main(String[] args) {

        Cliente joao = new Cliente();
        joao.setNome("João");
        Conta contaCorrente = new ContaCorrente(joao);
        Conta contaPoupanca = new ContaPoupanca(joao);

        contaCorrente.depositar(100);
        contaCorrente.transferir(100, contaPoupanca);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}
