public abstract class Aluno extends Pessoa {
    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        super(nome, matricula);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public abstract boolean podeMatricular(int disciplinasQuantidade);

    @Override
    public String toString() {
        return super.toString() + "\nCurso: " + curso;
    }
}
