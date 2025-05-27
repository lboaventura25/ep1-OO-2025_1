import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    private String nome;
    private String matricula;
    //    private Integer cpf; //validar cpf
    private String curso;

    public Aluno(String nome, String matricula, String curso){
        this.nome =nome;
        this.matricula = matricula;
        this.curso = curso;


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

    public void setCurso(String curso){
        this.curso = curso;
    }

    public String getCurso(){
        return this.curso;
    }


    public void formatado(){
        System.out.printf("Nome: %s, Matricula: %s, Curso: %s \n", this.nome, this.matricula, this.curso);
    }

    public String toCSV(){
        return this.nome + "," + this.matricula + "," + this.curso;
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
                String curso = partes[2];
                Aluno aluno = new Aluno(nome, matricula, curso);
                alunos.add(aluno);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }
//fazer uma view dps
    public static void menuAluno(ArrayList<Disciplina> listaDisciplinas){
        Scanner leitor = new Scanner(System.in);
            System.out.println("""
                        Voce deseja:
                        1- Cadastrar um aluno
                        2- Ver alunos cadastrados
                        """);
            //Codigo quebra quando nenhuma opcao eh selecionada CORRIGIR ANTES DE MANDAR
            Integer modoAluno = leitor.nextInt();
            leitor.useDelimiter(System.lineSeparator());
            if (modoAluno == 1){
                //verificar se o nome ja existe no banco de dados
                System.out.println("Digite o nome do aluno: ");
                String nomeAluno = leitor.next();
                //verificar se a matricula ja existe no banco de dados
                System.out.println("Digite a matricula do aluno:");
                String matriculaAluno = leitor.next();

                //verificar se esta sendo digitado um curso mesmo
                System.out.println("Digite o curso de graduacao do aluno:");
                String cursoAluno = leitor.next();

                Aluno aluno1 = new Aluno(nomeAluno, matriculaAluno, cursoAluno );
                Aluno.salvarAluno(aluno1, "teste.csv");
                //adicionar sistema de contador para as disciplinas terem numeros
                int cont = 1;
                for(Disciplina i : listaDisciplinas){
                    i.formatado(cont);
                }
                System.out.println("Selecione a disciplina que quer matricula-lo:");
                int escolhaDisciplina = leitor.nextInt() - 1;
                listaDisciplinas.get(escolhaDisciplina).matricularAluno(aluno1);
            }
            if (modoAluno == 2){
                ArrayList<Aluno> alunos = Aluno.listarAlunos("teste.csv");
                for(Aluno i : alunos){
                    i.formatado();
                }
            }

        }
    }