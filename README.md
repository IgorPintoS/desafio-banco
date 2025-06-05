#Projeto Banco - Simulação Bancária
Este projeto é uma simulação bancária desenvolvida em Java para fins de treinamento e aprendizado de conceitos de Programação Orientada a Objetos (POO).

##Funcionalidades Implementadas

✅ Sistema de contas bancárias (corrente e poupança)

✅ Gerenciamento de clientes

✅ Operações financeiras básicas:

Depósito

Saque

Transferência entre contas

✅ Geração de extratos bancários

✅ Numeração automática de contas

##Diagrama de Classes Simplificado

classDiagram
    direction BT

    class IConta {
        <<interface>>
        +transferir(double valor, Conta contaDestino)
        +sacar(double valor)
        +depositar(double valor)
        +imprimirExtrato()
    }

    class Conta {
        <<abstract>>
        -static AGENCIA_PADRAO: int
        -static SEQUENCIAL: int
        #conta: int
        #agencia: int
        #saldo: double
        #cliente: Cliente
        +Conta(Cliente cliente)
        #imprimirInfosComuns()
        +transferir(double valor, Conta contaDestino)
        +sacar(double valor)
        +depositar(double valor)
        +getConta() int
        +getAgencia() int
        +getSaldo() double
    }

    class Cliente {
        -nome: String
        +setNome(String nome)
        +getNome() String
    }

    class ContaCorrente {
        +imprimirExtrato()
    }

    class ContaPoupanca {
        +imprimirExtrato()
    }

    Conta ..|> IConta
    Conta --> Cliente : possui
    ContaCorrente --|> Conta
    ContaPoupanca --|> Conta
    
##Tecnologias Utilizadas

Java 11+

##Paradigma de Orientação a Objetos

Principais conceitos aplicados:

Abstração

Encapsulamento

Herança

Polimorfismo

##Como Executar o Projeto##
Clone o repositório:

bash
git clone https://github.com/seu-usuario/projeto-banco.git
Compile os arquivos Java:

bash
javac -d bin src/Model/*.java src/Service/*.java
Execute a aplicação (exemplo com classe Main):

bash
java -cp bin Main
Exemplo de Uso
java
public class Main {
    public static void main(String[] args) {
        // Criando cliente
        Cliente cliente1 = new Cliente();
        cliente1.setNome("João Silva");
        
        // Criando contas
        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente1);
        
        // Realizando operações
        cc.depositar(1000);
        cc.transferir(400, poupanca);
        
        // Gerando extratos
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}

Saída do Exemplo
=== Extrato Conta Corrente ===
Cliente: João Silva
Agencia: 1
Conta: 1
Saldo: 600.00

=== Extrato Conta Poupança ===
Cliente: João Silva
Agencia: 1
Conta: 2
Saldo: 400.00

##Contribuição
Este projeto é para fins educacionais, mas contribuições e sugestões são bem-vindas! Sinta-se à vontade para:

Reportar issues

Sugerir melhorias

Enviar pull requests
