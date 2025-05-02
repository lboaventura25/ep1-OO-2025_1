package Modo_Disciplina;

public class Turmas {
	private double horario;
	private String disciplina ;
	private String professor;
	private double semestre;
	private String metodoAvaliativo;
	private boolean ePresencial;
	private String sala;
	private int capacidadeMax;
	
	public Turmas(double horario, String disciplina, String professor, double semestre, String metodoAvaliativo,
			boolean ePresencial, String sala, int capacidadeMax) {
		super();
		this.horario = horario;
		this.disciplina = disciplina;
		this.professor = professor;
		this.semestre = semestre;
		this.metodoAvaliativo = metodoAvaliativo;
		this.ePresencial = ePresencial;
		this.sala = sala;
		this.capacidadeMax = capacidadeMax;
	}

	public double getHorario() {
		return horario;
	}

	public void setHorario(double horario) {
		this.horario = horario;
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

	public String getMetodoAvaliativo() {
		return metodoAvaliativo;
	}

	public void setMetodoAvaliativo(String metodoAvaliativo) {
		this.metodoAvaliativo = metodoAvaliativo;
	}

	public boolean isePresencial() {
		return ePresencial;
	}

	public void setePresencial(boolean ePresencial) {
		this.ePresencial = ePresencial;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getCapacidadeMax() {
		return capacidadeMax;
	}

	public void setCapacidadeMax(int capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}
	
	
}
