package entidades;

import java.util.HashMap;

public class Aluno extends Entidade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer matricula;
	private String nome;
	private String curso;
	private boolean especial;
	private HashMap<String, Disciplina> disciplinasFeitas;
	private int contador = 0;

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Aluno(Integer matricula, String nome, String curso, boolean especial,
			HashMap<String, Disciplina> disciplinasFeitas) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.especial = especial;
		this.disciplinasFeitas = disciplinasFeitas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public HashMap<String, Disciplina> getDisciplinasFeitas() {
		return disciplinasFeitas;
	}

	public void setDisciplinasFeitas(HashMap<String, Disciplina> disciplinasFeitas) {
		this.disciplinasFeitas = disciplinasFeitas;
	}

}
