import java.util.List;

public interface GerenciadorNomes {
    int MAX_CARACTERES_NOMES = 20;
    
    List<String> obterNomes();
    void adicionarNome(String nome);


   
    
    interface B {
        int metodoB();
    }
    
}
