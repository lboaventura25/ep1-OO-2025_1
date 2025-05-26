import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void formatado(){
        //formatacao inclompleta, faltam atributos
        System.out.printf("Nome da disciplina: %s, Nome do discente:%s, Codigo da disciplina:%s \n", this.nomeDisciplina, this.nomeProfessor, this.codigo);
    }

    public static void listarMatriculados(Disciplina disciplina){
        for (Aluno alunos : disciplina.listaMatriculados){
            alunos.formatado();
        }
    }

    public static void listarDisciplinas(ArrayList<Disciplina> listaDisciplina){
        for (Disciplina i : listaDisciplina){
                i.formatado();
        }
    }
    //falta lista de matriculados
    //checar de alguma forma se o arquivo ja existe
    public static void  arquivarDisciplina(Disciplina disciplina) {
        try {
            File arquivoCSV = new File(disciplina.getNomeDisciplina());
            FileWriter out = new FileWriter(arquivoCSV);
            //deve ter um jeito de otimizar esse parte do codigo(escrever os meta dados)
            out.write("#" + disciplina.getNomeDisciplina() + "\n");
            out.write("#" + disciplina.getCodigo() +"\n");
            out.write("#" + disciplina.getNomeProfessor() + "\n");
            out.write("#" + disciplina.getCapacidadeMaxima() + "\n");
            for(Aluno i : disciplina.getListaMatriculados()){
                out.write(i.toCSV());
            }
            out.close();

        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }

    public void matricularAluno(Aluno aluno){
        //testar depois
        //ver como o poerador size funciona
        if(this.listaMatriculados.size() <= this.capacidadeMaxima){
            this.listaMatriculados.add(aluno);
        }
    }
}

