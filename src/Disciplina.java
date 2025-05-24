import java.io.*;
import java.util.ArrayList;

public class Disciplina {
    private String nomeDisciplina;
    //adicionar limitacoes para os possiveis codigos
    private String codigo;
    private Integer capacidadeMaxima;
    private String nomeProfessor;
    private ArrayList<Aluno> listaMatriculados;



    public Disciplina(String nomeDisciplina, String codigo, Integer capacidadeMaxima, String nomeProfessor, ArrayList<Aluno> listaMatriculados){
        this.nomeDisciplina = nomeDisciplina;
        this.codigo = codigo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.nomeProfessor = nomeProfessor;
        this.listaMatriculados = listaMatriculados;


    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public Integer getCapacidadeMaxima(){
        return this.capacidadeMaxima;
    }

    public void setCapacidadeMaxima(Integer capacidade){
        this.capacidadeMaxima = capacidade;
    }

    public String getNomeDisciplina(){
        return this.nomeDisciplina;
    }

    public void setNomeDisciplina(String nome){
        this.nomeDisciplina = nome;
    }

    public ArrayList<Aluno> getListaMatriculados() {
        return this.listaMatriculados;
    }

    public void setListaMatriculados(ArrayList<Aluno> listaMatriculados){
        this.listaMatriculados = listaMatriculados;
    }

    public String getNomeProfessor(){
        return this.nomeProfessor;
    }
    public void setNomeProfessor(String nomeProfessor){
        this.nomeProfessor = nomeProfessor;
    }

    public static void listarMatriculados(String nomeArquivo){

    }
    //falta lista de matriculados
    //checar de alguma forma se o arquivo ja existe
    public static void  arquivarDisciplina(String nomeDisciplina, String codigo, String nomeProfessor, Integer capacidadeMaxima) {
        try {
            File arquivoCSV = new File(nomeDisciplina);
            FileWriter out = new FileWriter(arquivoCSV);
            //deve ter um jeito de otimizar esse parte do codigo(escrever os meta dados)
            out.write("#" + nomeDisciplina + "\n");
            out.write("#" + codigo +"\n");
            out.write("#" + nomeProfessor + "\n");
            out.write("#" + capacidadeMaxima + "\n");
            out.close();

        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }
}

