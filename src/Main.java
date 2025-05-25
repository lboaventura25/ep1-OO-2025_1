import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
        while (true){

            System.out.println("""
                    ANTES DE CADASTRAR UM ALUNO, CADASTRE UMA DISCIPLINA!
                    Qual modo deseja escolher?
                    1 - Modo aluno
                    2 - Modo Disciplina
                    3- Sair
                    """);
            Integer opcao = leitor.nextInt();
            if(opcao == 1){
                Aluno.menuAluno(listaDisciplinas);
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
