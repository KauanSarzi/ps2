import banco.Conta;
import banco.ContaBancaria;
import banco.ContaInfinita;

class Main{
    public static void main (String [] args ){
        Conta[] contas ={ new ContaInfinita(1111,50),
                          new ContaBancaria(2222, 99),
                          new ContaBancaria(3333, 1000)};
        for (int i=0; i<contas.length; i++){
            contas[i].sacar(900);
            System.out.println(contas[i]);
        }
    }
}