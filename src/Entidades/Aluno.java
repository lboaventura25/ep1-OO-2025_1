package entidades;


import java.io.Serializable;

public class Aluno implements Serializable{
	private static final long serialVerionUID = 1L;
	 private long matricula;
	 private String nome;
	 private String curso;
	 private boolean especial;
	 
	 
	public Aluno(long matricula, String nome, String curso, boolean especial) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.especial = especial;
	}


	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
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
	 
	 
	
		
}
