package sistemaGerenciamentoTarefas;

import java.util.ArrayList;

public class Usuario {
	 private String nome;
	    private ArrayList<Tarefa> tarefas;

	    public Usuario(String nome) {
	        this.nome = nome;
	        this.tarefas = new ArrayList<>();
	    }

	    public String getNome() {
	        return nome;
	    }

	    public ArrayList<Tarefa> getTarefas() {
	        return tarefas;
	    }

	    public void adicionarTarefa(Tarefa tarefa) {
	        tarefas.add(tarefa);
	    }

	    @Override
	    public String toString() {
	        return "Usuario{" +
	                "nome='" + nome + '\'' +
	                ", tarefas=" + tarefas +
	                '}';
	    }

}
