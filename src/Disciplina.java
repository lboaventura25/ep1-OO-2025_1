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
            File pasta = new File("disciplinas");
            if(!pasta.exists()){
                pasta.mkdir();
            }

            // verificar depois se isso funciona
            String nomeArquivo = disciplina.getNomeDisciplina().replace(" ", "_") + ".csv";
            File arquivoCSV = new File(pasta, disciplina.getNomeDisciplina());
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

    public static void iniciarDisciplina(ArrayList<Disciplina> listaDisciplinas){
        File dir = new File("disciplinas");
        File[] listaArquivos =dir.listFiles();
        if(listaArquivos != null){
            for(File i : listaArquivos){
                ArrayList<Aluno> listaAlunos = new ArrayList<>();
                int cont = 0;
                String nomeDisciplina = "";
                String codigo = "";
                // ver se tem problema mais de 1 nome
                String nomeProfessor = "";
                int capacidadeMaxima = 0;

                try {
                    String linha;
                    BufferedReader leitor = new BufferedReader(new FileReader(i));
                    while ((linha =leitor.readLine()) != null){
                        cont++;
                        if(cont==1){
                                nomeDisciplina = linha.substring(1);
                                continue;
                        }
                        if(cont == 2){
                            codigo = linha.substring(1);
                            continue;
                        }
                        if(cont ==3){
                            nomeProfessor = linha.substring(1);
                            continue;
                        }
                        if(cont == 4){
                            capacidadeMaxima = Integer.parseInt(linha.substring(1));
                            continue;
                        }
                        else{
                            String linha2;
                            while((linha2 = leitor.readLine()) != null){
                                //ver se da so pra usar o metodo que eu ja tinha escrito antes aqui, devia ter visto isso antes de escrever :/
                                //nao sei se precisa do [], talvez o cara tava usando uma versao antiga do java
                                Aluno aluno = getAluno(linha2);
                                listaAlunos.add(aluno);

                            }
                        }
                    }
                    leitor.close();
                    Disciplina disciplina = new Disciplina(nomeDisciplina,codigo, capacidadeMaxima,nomeProfessor, listaAlunos);
                    listaDisciplinas.add(disciplina);
                }
                catch (IOException e){
                    throw new RuntimeException("Erro ao ler o arquivo");
                }
            }
        }
        else{
            throw new RuntimeException("Nao existe nenhuma disclina criada ainda");
        }

    }
    //Minha IDE fez isso sem eu querer, ver se funciona normal
    private static Aluno getAluno(String linha) {
        String[] partes = linha.split(",");
        //ver depois se precisava mesmo declarar as variaveis antes e nao aqui
        //converir se os valores certos estao indo para o lugar certo
        String nomeAluno = partes[0];
        String matricula = partes[1];
        String curso = partes[2];
        Aluno aluno = new Aluno(nomeAluno, matricula, curso);
        return aluno;
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
        }
        else if(modoDisciplina == 2){
            Disciplina.listarDisciplinas(listaDisciplinas);
        }
    }
}

