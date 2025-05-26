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

            else if (opcao == 2) {
            Disciplina.menuDisciplina(listaDisciplinas);
            }
            else if(opcao == 3){
                break;
            }

        }
    }
}
