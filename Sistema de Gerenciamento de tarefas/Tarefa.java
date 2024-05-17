package sistemaGerenciamentoTarefas;

import java.time.LocalDate;

public class Tarefa {
	private String descricao;
	private LocalDate prazo;
	private boolean concluida;

	public Tarefa(String descricao, LocalDate prazo) {
		this.descricao = descricao;
		this.prazo = prazo;
		this.concluida = false;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDate getPrazo() {
		return prazo;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void marcarConcluida() {
		this.concluida = true;
	}

	@Override
	public String toString() {
		return "Tarefa{" + "descricao='" + descricao + '\'' + ", prazo=" + prazo + ", concluida=" + concluida + '}';
	}

}
