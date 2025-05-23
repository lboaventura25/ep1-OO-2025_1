package entidades;

//import java.util.ArrayList;
import java.util.HashMap;

public class Turma extends Entidade {
	private static final long serialVerionUID = 1L;

	private Integer codigoDaDisciplina;
	private String disciplina;
	private String professor;
	private String semestre;
	private boolean presencial;
	private String sala;
	private String horario;
	private int capMaxAluno;
	private HashMap<Integer, Aluno> alunosPorTurma;// criando um atributo que receba a lista de alunos. -> vou precisar

	public Turma(Integer codigoDaDisciplina, String disciplina, String professor, String semestre, boolean presencial,
			String sala, String horario, int capMaxAluno, HashMap<Integer, Aluno> alunosPorTurma) {
		this.codigoDaDisciplina = codigoDaDisciplina;
		this.disciplina = disciplina;
		this.professor = professor;
		this.semestre = semestre;
		this.presencial = presencial;
		this.sala = sala;
		this.horario = horario;
		this.capMaxAluno = capMaxAluno;
		this.alunosPorTurma = alunosPorTurma;
	}

	public HashMap<Integer, Aluno> getAlunosPorTurma() {
		return alunosPorTurma;
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

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getCapMaxAluno() {
		return capMaxAluno;
	}

	public void setCapMaxAluno(int capMaxAluno) {
		this.capMaxAluno = capMaxAluno;
	}

	public static long getSerialverionuid() {
		return serialVerionUID;
	}

	public Integer getCodigoDaDisciplina() {
		return codigoDaDisciplina;
	}

	public void setNumeroDaTurma(int numeroDaTurma) {
		this.codigoDaDisciplina = numeroDaTurma;
	}

	// será se vou precisar mesmo desse metodo?
	public void setAlunosPorTurma(HashMap<Integer, Aluno> alunosPorTurma) {
		this.alunosPorTurma = alunosPorTurma;
	}

}
