package sistemaGerenciamentoTarefas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGerenciamentoTarefas {
	public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Adicionar tarefa para um usuário");
            System.out.println("3. Mostrar todas as tarefas de um usuário");
            System.out.println("4. Marcar tarefa como concluída");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o nome do usuário: ");
                scanner.nextLine(); // Consumir a quebra de linha após o próximoInt()
                String nome = scanner.nextLine();

                Usuario usuario = new Usuario(nome);
                usuarios.add(usuario);
                System.out.println("Usuário adicionado com sucesso!");

            } else if (opcao == 2) {
                System.out.print("Digite o nome do usuário: ");
                scanner.nextLine(); // Consumir a quebra de linha após o próximoInt()
                String nomeUsuario = scanner.nextLine();

                Usuario usuario = encontrarUsuario(usuarios, nomeUsuario);
                if (usuario != null) {
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Digite o prazo da tarefa (yyyy-MM-dd): ");
                    String prazoStr = scanner.nextLine();
                    LocalDate prazo = LocalDate.parse(prazoStr);

                    Tarefa tarefa = new Tarefa(descricao, prazo);
                    usuario.adicionarTarefa(tarefa);
                    System.out.println("Tarefa adicionada com sucesso!");
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 3) {
                System.out.print("Digite o nome do usuário: ");
                scanner.nextLine(); // Consumir a quebra de linha após o próximoInt()
                String nomeUsuario = scanner.nextLine();

                Usuario usuario = encontrarUsuario(usuarios, nomeUsuario);
                if (usuario != null) {
                    System.out.println("Tarefas do usuário " + usuario.getNome() + ":");
                    ArrayList<Tarefa> tarefas = usuario.getTarefas();
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println((i + 1) + ". " + tarefas.get(i));
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 4) {
                System.out.print("Digite o nome do usuário: ");
                scanner.nextLine(); // Consumir a quebra de linha após o próximoInt()
                String nomeUsuario = scanner.nextLine();

                Usuario usuario = encontrarUsuario(usuarios, nomeUsuario);
                if (usuario != null) {
                    System.out.println("Tarefas do usuário " + usuario.getNome() + ":");
                    ArrayList<Tarefa> tarefas = usuario.getTarefas();
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println((i + 1) + ". " + tarefas.get(i));
                    }

                    System.out.print("Digite o número da tarefa que deseja marcar como concluída: ");
                    int numTarefa = scanner.nextInt();
                    if (numTarefa >= 1 && numTarefa <= tarefas.size()) {
                        Tarefa tarefa = tarefas.get(numTarefa - 1);
                        tarefa.marcarConcluida();
                        System.out.println("Tarefa marcada como concluída com sucesso!");
                    } else {
                        System.out.println("Número de tarefa inválido.");
                    }
                } else {
                    System.out.println("Usuário não encontrado.");
                }

            } else if (opcao == 5) {
                System.out.println("Saindo...");
                break;

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
	
    private static Usuario encontrarUsuario(ArrayList<Usuario> usuarios, String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
            
        }
        return null;
        
        
    }
}
