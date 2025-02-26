
import java.io.*;
import java.util.*;
class GerenciadorNomesArq implements GerenciadorNomes {
    private static final String FILE_PATH = "lab03/nomes.txt";

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                nomes.add(linha);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Criando um novo arquivo.");
            criarArquivo();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(nome);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    private void criarArquivo() {
        try {
            File file = new File(FILE_PATH);
            if (file.createNewFile()) {
                System.out.println("Arquivo criado com sucesso: " + FILE_PATH);
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo: " + e.getMessage());
        }
    }
}