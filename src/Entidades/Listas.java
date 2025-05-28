package entidades;
// calsse responsável ppor inicializar as listas

import java.io.Serializable;
import java.util.HashMap;
/* import java.util.List; */

public class Listas implements Serializable{
    private static final long serialVersionUID = 1L;
	public static HashMap<Integer, Aluno> alunosGeral = new HashMap<Integer, Aluno>();
    public static HashMap<Integer, Turma> turmasGeral = new HashMap<Integer, Turma>();
    public static HashMap<String, Disciplina> disciplinaGeral = new HashMap<String, Disciplina>();
    public static HashMap<Integer, Professor> professoresGeral = new HashMap<Integer, Professor>();

    public  static HashMap<Integer, Professor> getProfessoresGeral() {
        return professoresGeral;
    }

    public static HashMap<Integer, Aluno> getAlunosGeral() {
        return alunosGeral;
    }

    public static HashMap<Integer, Turma> getTurmasGeral() {
        return turmasGeral;
    }

    public static HashMap<String, Disciplina> getDisciplinaGeral() {
        return disciplinaGeral;
    }

    public void setProfessoresGeral(HashMap<Integer, Professor> professoresGeral) {
        Listas.professoresGeral = professoresGeral;
    }

    public void setAlunosGeral(HashMap<Integer, Aluno> alunosGeral) {
        Listas.alunosGeral = alunosGeral;
    }

    public void setTurmasGeral(HashMap<Integer, Turma> turmasGeral) {
        Listas.turmasGeral = turmasGeral;
    }

    public void setDisciplinaGeral(HashMap<String, Disciplina> disciplinaGeral) {
        Listas.disciplinaGeral = disciplinaGeral;
    }

}
