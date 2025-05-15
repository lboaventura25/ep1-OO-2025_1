package entidades;




public class Aluno extends Entidade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Integer matricula;
	 private String nome;
	 private String curso;
	 private boolean especial;
	 
	 
	public Aluno(Integer matricula, String nome, String curso, boolean especial) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.especial = especial;
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
	 
	 
	
		
}
