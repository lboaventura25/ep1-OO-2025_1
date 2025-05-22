package entidades;
// calsse responsável ppor inicializar as listas

import java.util.HashMap;
/* import java.util.List; */

public class Listas {
    private static HashMap<Integer, Aluno> alunosGeral;
    private static HashMap<Integer, Turma> turmasGeral;
    private static HashMap<Integer, Disciplina> disciplinaGeral;
    private static HashMap<Integer, Professor> professoresGeral;

    public  static HashMap<Integer, Professor> getProfessoresGeral() {
        return professoresGeral;
    }

    public static HashMap<Integer, Aluno> getAlunosGeral() {
        return alunosGeral;
    }

    public static HashMap<Integer, Turma> getTurmasGeral() {
        return turmasGeral;
    }

    public static HashMap<Integer, Disciplina> getDisciplinaGeral() {
        return disciplinaGeral;
    }

    public void setProfessoresGeral(HashMap<Integer, Professor> professoresGeral) {
        this.professoresGeral = professoresGeral;
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
