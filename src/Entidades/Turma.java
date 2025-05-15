package entidades;

//import java.util.ArrayList;
import java.util.HashMap;



public class Turma extends Entidade {
	private static final long serialVerionUID = 1L;

	private String disciplina;
	private String professor;
	private double semestre;
	private boolean presencial;
	private String sala;
	private double horario;
	private int capMaxAluno;
	private HashMap<Long, Aluno> alunos;// criando um atributo que receba a lista de alunos. -> vou precisar
	// TODO de um metodo pra adicionar alunos em turmas, DAOTurma???

	public Turma(String disciplina, String professor, double semestre, boolean presencial, String sala, double horario,
			int capMaxAluno) {
		super();
		this.disciplina = disciplina;
		this.professor = professor;
		this.semestre = semestre;
		this.presencial = presencial;
		this.sala = sala;
		this.horario = horario;
		this.capMaxAluno = capMaxAluno;
	}
	
	public HashMap<Long, Aluno> getAlunos() {
		return alunos;
	}
	
	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public double getSemestre() {
		return semestre;
	}

	public void setSemestre(double semestre) {
		this.semestre = semestre;
	}

	public boolean isPresencial() {
		return presencial;
	}

	public void setPresencial(boolean presencial) {
		this.presencial = presencial;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getHorario() {
		return horario;
	}

	public void setHorario(double horario) {
		this.horario = horario;
	}

	public int getCapMaxAluno() {
		return capMaxAluno;
	}

	public void setCapMaxAluno(int capMaxAluno) {
		this.capMaxAluno = capMaxAluno;
	}

}
