import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        while (true){

            System.out.println("""
                    Bem vindo ao sigaa
                    Qual modo deseja escolher?
                    1- Modo aluno
                    2- Sair
                    """);
            Integer opcao = leitor.nextInt();
            if(opcao == 1){
                System.out.println("""
                        Voce deseja:
                        1- Cadastrar um aluno
                        2- Ver alunos cadastrados
                        """);
                //Codigo quebra quando nenhuma opcao eh selecionada CORRIGIR ANTES DE MANDAR
                Integer op2 = leitor.nextInt();
                leitor.useDelimiter(System.lineSeparator());
                if (op2 == 1){
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
                if (op2 == 2){
                    ArrayList<Aluno> alunos = Aluno.listarAlunos("teste.csv");
                    for(Aluno i : alunos){
                        i.formatado();
                    }
                }

            }
            if(opcao == 2){
                break;
            }

        }
    }
}
