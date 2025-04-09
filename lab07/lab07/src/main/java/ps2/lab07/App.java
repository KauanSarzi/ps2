package ps2.lab07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private MusicaRepo musicaRepo;

    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Cadastrar música");
            System.out.println("2. Listar músicas");
            System.out.println("3. Atualizar música");
            System.out.println("4. Remover música");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(entrada.nextLine());

            switch (opcao) {
                case 1 -> cadastrarMusica();
                case 2 -> listarMusicas();
                case 3 -> atualizarMusica();
                case 4 -> removerMusica();
                case 5 -> sair = true;
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarMusica() {
        System.out.print("Título: ");
        String titulo = entrada.nextLine();
        System.out.print("Compositor: ");
        String compositor = entrada.nextLine();
        System.out.print("Ano: ");
        int ano = Integer.parseInt(entrada.nextLine());

        musicaRepo.save(new Musica(titulo, compositor, ano));
        System.out.println("Música cadastrada com sucesso!");
    }

   

    private void listarMusicas() {
        List<Musica> musicas = (List<Musica>) musicaRepo.findAll();
        System.out.println("\nMÚSICAS CADASTRADAS:");
        for (Musica m : musicas) {
            System.out.printf("[%d] %s - %s (%d)\n", m.getId(), m.getTitulo(), m.getCompositor(), m.getAno());
        }
    }

    private void atualizarMusica() {
        listarMusicas();
        System.out.print("ID da música a atualizar: ");
        Long id = Long.parseLong(entrada.nextLine());
        Musica m = musicaRepo.findById(id).orElse(null);

        if (m != null) {
            System.out.print("Novo título: ");
            m.setTitulo(entrada.nextLine());
            System.out.print("Novo compositor: ");
            m.setCompositor(entrada.nextLine());
            System.out.print("Novo ano: ");
            m.setAno(Integer.parseInt(entrada.nextLine()));
            musicaRepo.save(m);
            System.out.println("Música atualizada com sucesso!");
        } else {
            System.out.println("Música não encontrada.");
        }
    }

    private void removerMusica() {
        listarMusicas();
        System.out.print("ID da música a remover: ");
        Long id = Long.parseLong(entrada.nextLine());
        musicaRepo.deleteById(id);
        System.out.println("Música removida.");
    }
}
