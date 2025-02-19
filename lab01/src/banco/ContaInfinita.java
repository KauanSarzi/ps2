package banco;

public class ContaInfinita extends Conta{
    public ContaInfinita(int n, double s){
        super(n,s);
    }
    @Override
    public void depositar(double valor){
        saldo += + 5;

    }
    @Override
    public boolean sacar(double valor){
        saldo -= valor;
        return true;
    }
    
}


