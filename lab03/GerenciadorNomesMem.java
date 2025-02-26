import java.util.*;

public class GerenciadorNomesMem implements GerenciadorNomes {
    private List<String> nomes = new ArrayList<>();

    @Override
    public List<String> obterNomes() {
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        nomes.add(nome);
    }
}

