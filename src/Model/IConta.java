package Model;

public interface IConta {
    void transferir(double valor, Conta contaDestino);
    void sacar(double valor);
    void depositar(double valor);
    void imprimirExtrato();

}
