public class Main {
    public static void main(String[] args) {
        GerenciadorNomes gNomes = new GerenciadorNomesMem();  // Corrigindo a instância do objeto
        Ihm ihm = new Ihm(gNomes); // Corrigindo a declaração e inicialização
        ihm.dialogar(); // Mantendo a chamada do método
    }
}