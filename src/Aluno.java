import java.io.*;
import java.util.ArrayList;
public class Aluno {
    private String nome;
    private String matricula;
    //    private Integer cpf; //validar cpf
//    private String curso;
    private Disciplina disciplina;

//    public Aluno(String nome, String matricula, Integer cpf, String curso){
//        this.nome =nome;
//        this.matricula = matricula;
//        this.cpf = cpf;
//        this.curso = curso;
//    }

    public Aluno(String nome, String matricula, Disciplina disciplina){
        this.nome =nome;
        this.matricula = matricula;
        this.disciplina = disciplina;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getMatricula(){
        return this.matricula;
    }

//    public void setCpf(Integer cpf){
//        this.cpf = cpf;
//    }
//
//    public Integer getCpf(){
//        return this.cpf;
//    }

//    public void setCurso(String curso){
//        this.curso = curso;
//    }
//
//    public String getCurso(){
//        return this.curso;
//    }

    public void setDisciplina(Disciplina disciplina){
        this.disciplina = disciplina;
    }

    public Disciplina getDIsciplina(){
        return this.disciplina;
    }

    public void formatado(){
        System.out.printf("Nome: %s, Matricula: %s \n", this.nome, this.matricula);
    }

    public String toCSV(){
        return this.nome + "," + this.matricula + "," + this.disciplina;
    }
    public static void salvarAluno( Aluno aluno, String nomeArquivo){

        try {
            FileWriter writer = new FileWriter(nomeArquivo, true);
            writer.write(aluno.toCSV() + "\n");
            writer.close();

        }catch (IOException e){
            System.out.println("Erro ao salvar aluno" + e.getMessage());
        }
    }

    public static ArrayList<Aluno> listarAlunos(String nomeArquivo){
        ArrayList<Aluno> alunos = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                String nome = partes[0];
                String matricula = partes[1];
                String nomeDisciplina = partes[2];
                Disciplina disciplina = new Disciplina(nomeDisciplina);
                Aluno aluno = new Aluno(nome, matricula, disciplina);
                alunos.add(aluno);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }

}