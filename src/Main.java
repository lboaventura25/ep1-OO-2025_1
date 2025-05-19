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
                Integer op2 = leitor.nextInt();
                if (op2 == 1){
                    Disciplina disciplina = new Disciplina("c1");
                    Aluno aluno1 = new Aluno("djota", "241040341", disciplina );
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
