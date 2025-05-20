package entidades;

//import java.util.ArrayList;
import java.util.HashMap;

public class Turma extends Entidade {
	private static final long serialVerionUID = 1L;

	private int numeroDaTurma;
	private String disciplina;
	private String professor;
	private double semestre;
	private boolean presencial;
	private String sala;
	private double horario;
	private int capMaxAluno;
	private HashMap<Long, Aluno> alunosPorTurma;// criando um atributo que receba a lista de alunos. -> vou precisar
	// TODO de um metodo pra adicionar alunos em turmas, DAOTurma???

	public Turma(int numeroDaTurma, String disciplina, String professor, double semestre, boolean presencial,
			String sala, double horario, int capMaxAluno, HashMap<Long, Aluno> alunosPorTurma) {
		this.numeroDaTurma = numeroDaTurma;
		this.disciplina = disciplina;
		this.professor = professor;
		this.semestre = semestre;
		this.presencial = presencial;
		this.sala = sala;
		this.horario = horario;
		this.capMaxAluno = capMaxAluno;
		this.alunosPorTurma = alunosPorTurma;
	}

	public HashMap<Long, Aluno> getAlunosPorTurma() {
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

	public static long getSerialverionuid() {
		return serialVerionUID;
	}

	public int getNumeroDaTurma() {
		return numeroDaTurma;
	}

	public void setNumeroDaTurma(int numeroDaTurma) {
		this.numeroDaTurma = numeroDaTurma;
	}

	public void setAlunosPorTurma(HashMap<Long, Aluno> alunosPorTurma) {
		this.alunosPorTurma = alunosPorTurma;
	}

}
