import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

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
            Aluno.salvarAluno(aluno1, "listaluno.csv");
            //adicionar sistema de contador para as disciplinas terem numeros
            int cont = 1;
            for(Disciplina i : listaDisciplinas){
                i.formatado(cont);
                cont++;
            }
            System.out.println("Selecione a disciplina que quer matricula-lo:");
            int escolhaDisciplina = leitor.nextInt() - 1;
            listaDisciplinas.get(escolhaDisciplina).matricularAluno(aluno1);
        }
        if (modoAluno == 2){
            ArrayList<Aluno> alunos = Aluno.listarAlunos("listaluno.csv");
            for(Aluno i : alunos){
                i.formatado();
            }
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
        }
        else if(modoDisciplina == 2){
            Disciplina.listarDisciplinas(listaDisciplinas);
        }
    }
}
