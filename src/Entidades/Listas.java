package entidades;
// calsse responsável ppor inicializar as listas

import java.util.HashMap;
/* import java.util.List; */

public class Listas {
    private static HashMap<Integer, Aluno> alunosGeral = new HashMap<Integer, Aluno>();
    private static HashMap<Integer, Turma> turmasGeral = new HashMap<Integer, Turma>();
    private static HashMap<String, Disciplina> disciplinaGeral = new HashMap<String, Disciplina>();
    private static HashMap<Integer, Professor> professoresGeral = new HashMap<Integer, Professor>();

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
        this.professoresGeral = professoresGeral;
    }

    public void setAlunosGeral(HashMap<Integer, Aluno> alunosGeral) {
        this.alunosGeral = alunosGeral;
    }

    public void setTurmasGeral(HashMap<Integer, Turma> turmasGeral) {
        this.turmasGeral = turmasGeral;
    }

    public void setDisciplinaGeral(HashMap<String, Disciplina> disciplinaGeral) {
        this.disciplinaGeral = disciplinaGeral;
    }

}
