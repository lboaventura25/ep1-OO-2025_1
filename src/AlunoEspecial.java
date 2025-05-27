public class AlunoEspecial extends Aluno{
    int limiteDisciplinas = 0;
    public AlunoEspecial(String nome, String matricula, String curso) {
        super(nome, matricula, curso);
    }

    @Override
    public void formatado(){
        System.out.printf("Nome: %s, Matricula: %s, Curso: %s \n, Aluno especial -> limite de disciplinas(2):%d", getNome(), getMatricula(), getCurso(),this.limiteDisciplinas);

    }

    @Override
    public String toCSV(){
       return getNome() + getMatricula() + getCurso() + this.limiteDisciplinas;
    }
}
