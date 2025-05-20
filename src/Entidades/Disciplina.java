package entidades;

import java.util.HashMap;

public class Disciplina extends Entidade {
	private static final long serialVerionUID = 1L;

	private String nomeDisciplina;
	private int codigo;
	private int horas;
	private String[] preRequisitos;
	private HashMap<Long, Turma> turmasPorDisciplinas;
	// como inicializar essa lista sem criar uma Disciplina ?

	public Disciplina(String nomeDisciplina, int codigo, int horas, String[] preRequisitos,
			HashMap<Long, Turma> turmasPorDisciplinas) {
		this.nomeDisciplina = nomeDisciplina;
		this.codigo = codigo;
		this.horas = horas;
		this.preRequisitos = preRequisitos;
		this.turmasPorDisciplinas = turmasPorDisciplinas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String[] getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(String[] preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

	public static long getSerialverionuid() {
		return serialVerionUID;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public HashMap<Long, Turma> getTurmasPorDisciplinas() {
		return turmasPorDisciplinas;
	}

	public void setTurmasPorDisciplinas(HashMap<Long, Turma> turmasPorDisciplinas) {
		this.turmasPorDisciplinas = turmasPorDisciplinas;
	}

}
