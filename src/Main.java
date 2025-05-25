import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
        while (true){

            System.out.println("""
                    Bem vindo ao sigaa
                    Qual modo deseja escolher?
                    1 - Modo aluno
                    2 - Modo Disciplina
                    3- Sair
                    """);
            Integer opcao = leitor.nextInt();
            if(opcao == 1){
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
                }
                if (modoAluno == 2){
                    ArrayList<Aluno> alunos = Aluno.listarAlunos("teste.csv");
                    for(Aluno i : alunos){
                        i.formatado();
                    }
                }

            }

            else if (opcao == 2){
                //Adicionar a opcao de voltar para o menu anterior
                System.out.println("""
                        Voce deseja:
                        1- Cadastrar uma disciplina
                        2- Ver disciplinas cadastradas
                        """);
                int modoDisciplina = leitor.nextInt();
                //temporario, nao mostra os alunos matriculados ainda
                //ver se ele cria um arquivo novo ou usa o existente
                ArrayList<Aluno> listaMatriculados = Aluno.listarAlunos("teste.csv");
                
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
                    Disciplina.arquivarDisciplina(nomeDisciplina, codigoDisciplina, nomeProfessor, vagasDisponiveis );

                }
                else if(modoDisciplina == 2){
                    //temporario, nao mostra as diciplinas cadastradas ainda
                    Disciplina.listarDisciplinas(listaDisciplinas);
                }
            }

            else if(opcao == 3){
                break;
            }

        }
    }
}
