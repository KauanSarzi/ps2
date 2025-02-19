import banco.*;

public class App8 {
    public static void main(String[] args) {
        Banco meuBanco = new Banco("Java");
        
        meuBanco.adicionar(new ContaInfinita(1111, 50));
        meuBanco.adicionar(new ContaEspecial(1234, 10, 1000));
        meuBanco.adicionar(new ContaBancaria(2222, 99));
        meuBanco.adicionar(new ContaBancaria(3333, 1300));
        meuBanco.adicionar(new ContaInfinita(4444, 999));
        meuBanco.adicionar(new ContaEspecial(7777, 800, 200));

        meuBanco.aumentarLimiteEspeciais(200);
        meuBanco.tentarSacar(1100);
        meuBanco.mostrar();
    }
}
