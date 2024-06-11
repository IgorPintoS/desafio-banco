import Model.Conta;
import Service.Cliente;
import Service.ContaCorrente;
import Service.ContaPoupanca;


public class Main {
    public static void main(String[] args) {

        Cliente joao = new Cliente();
        joao.setNome("João");
        Conta contaCorrente = new ContaCorrente(joao);
        Conta contaPoupanca = new ContaPoupanca(joao);

        contaCorrente.depositar(100);
        contaCorrente.imprimirExtrato();

        contaCorrente.transferir(100, contaPoupanca);

        contaCorrente.imprimirExtrato();
        contaPoupanca.imprimirExtrato();
    }
}