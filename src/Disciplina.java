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

    public static void menuDisciplina(ArrayList<Disciplina> listaDisciplinas){
        Scanner leitor = new Scanner(System.in);
        //Adicionar a opcao de voltar para o menu anterior
        System.out.println("""
                        Voce deseja:
                        1- Cadastrar uma disciplina
                        2- Ver disciplinas cadastradas
                        """);
        int modoDisciplina = leitor.nextInt();
        //temporario, nao mostra os alunos matriculados ainda
        //ver se ele cria um arquivo novo ou usa o existente
        ArrayList<Aluno> listaMatriculados = new ArrayList<>();

        //teste remover depois
        if(modoDisciplina == 1){

            System.out.println("Digite o nome da disciplina:");
            // ver se o codigo quebra caso o nome seja maior que uma palavra
            String nomeDisciplina = leitor.next();

            System.out.println("Digite o codigo da disciplina:");
            String codigoDisciplina = leitor.next();

            System.out.println("digite o professor discente:");
            String nomeProfessor = leitor.next();

            System.out.println("digite a quantidade de vagas disponiveis na diciplina");
            Integer vagasDisponiveis = leitor.nextInt();


            Disciplina disciplina = new Disciplina(nomeDisciplina, codigoDisciplina,vagasDisponiveis,nomeProfessor,listaMatriculados);
            listaDisciplinas.add(disciplina);
            // nao esta completo ainda, so um teste
            //ver se aceita nomes com mais de uma palavra
            Disciplina.arquivarDisciplina(disciplina);

        }
        else if(modoDisciplina == 2){
            Disciplina.listarDisciplinas(listaDisciplinas);
        }
    }
}

