public class AlunoNormal extends Aluno {

    public AlunoNormal(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public boolean podeMatricular(int disciplinasQuantidade){
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\n[Aluno normal]";
    }
}
