package entidades;
// calsse responsável ppor inicializar as listas

import java.util.HashMap;
import java.util.List;

public class Listas {
    private HashMap<Integer, Aluno> alunosGeral ;
    private HashMap<Integer, Turma> turmasGeral ;
    private HashMap<Integer, Disciplina> disciplinaGeral ;
    private HashMap<Integer, Professor> professoresGeral ;
    
    
    public Listas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HashMap<Integer, Professor> getProfessoresGeral() {
		return professoresGeral;
	}

	public void setProfessoresGeral(HashMap<Integer, Professor> professoresGeral) {
		this.professoresGeral = professoresGeral;
	}

	public HashMap<Integer, Aluno> getAlunosGeral() {
        return alunosGeral;
    }

    public HashMap<Integer, Turma> getTurmasGeral() {
        return turmasGeral;
    }

    public HashMap<Integer, Disciplina> getDisciplinaGeral() {
        return disciplinaGeral;
    }

    public void setAlunosGeral(HashMap<Integer, Aluno> alunosGeral) {
        this.alunosGeral = alunosGeral;
    }

    public void setTurmasGeral(HashMap<Integer, Turma> turmasGeral) {
        this.turmasGeral = turmasGeral;
    }

    public void setDisciplinaGeral(HashMap<Integer, Disciplina> disciplinaGeral) {
        this.disciplinaGeral = disciplinaGeral;
    }

}
