package entidades;


/* import java.io.Serializable; */

public class Professor extends Entidade{
	private static final long serialVerionUID = 1L;
	
	private long id;
	private String nome;
	private Disciplina disciplina;
	private Turma turmas;
	
	
	public Professor(long id, String nome, Disciplina disciplina, Turma turmas) {
		super();// caso seja filha de alguma ou tra classe aqui vai ter os construtores da classe pai.
		this.id = id;
		this.nome = nome;
		this.disciplina = disciplina;
		this.turmas = turmas;
	}
	public long getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Turma getTurmas() {
		return turmas;
	}
	public void setTurmas(Turma turmas) {
		this.turmas = turmas;
	}
	
	
	
	
	 

}
