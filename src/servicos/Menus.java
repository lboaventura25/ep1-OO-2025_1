package servicos;

import java.util.Scanner;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;
import persistencia.daoEntidades.DisciplinaDao;
import persistencia.daoEntidades.TurmaDao;

import java.util.HashMap;
import java.util.Map;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Listas;
import entidades.Turma;

public class Menus {

	AlunoDao alunoDao = new AlunoDao();
	TurmaDao turmaDao = new TurmaDao();
	DisciplinaDao disciplinadao = new DisciplinaDao();

	public void menuPrincipal() {
		Scanner sc = new Scanner(System.in);

		System.out.println("seja bem vindo ao sistema de gerenciamento academico.");
		System.out.println("digite oque deseja fazer");
		System.out.println("Digite 1 para Modo Aluno");
		System.out.println("Digite 2 para Modo Disciplina");
		System.out.println("Digite 3 para Modo Avaliação");
		System.out.println("Digite 0 para sair da aplicação");

		int valor = sc.nextInt();
		if (valor == 1) {
			System.out.println("entrou no Modo aluno");
			modoAlunoI();

		} else if (valor == 2) {
			System.out.println("entrou no Modo Disciplina");
			modoDisciplina();
		} else if (valor == 3) {
			System.out.println("entrou no Modo avaliação");
			System.out.println("Modo Avaliação indisponível");
		} else if (valor == 0) {
			System.out.println("saiu...");
		} else {
			System.out.println("Valor digitado invalido");
			 voltarMenu(); 
		}

		sc.close();
	}

	private void modoDisciplina() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrou no método disciplina");
		System.out.println("Digite 1 para cadastrar disciplinas");
		System.out.println("digite 2 pra cadastrar Turma (cadastrar disciplina antes)");
		System.out.println("Digite 3 pra listar turmas (cadastrar uma turma antes)");
		System.out.println("Digite 0 pra parar a aplicação");
		int valor = sc.nextInt();

		if (valor == 0) {
			sc.close();
		} else if (valor == 1) {
			cadDisciplina();
		} else if (valor == 2) {
			System.out.println("AVISO!! CADASTRE UMA DISCIPLINA ANTES DE CADASTRAR UMA TURMA");
			cadTurma();
		} else if (valor == 3) {
			System.out.println("É NECESSARIO QUE CRIE PELO MENOS UMA TURMA ANTES DE LISTA-LAS");
			listarTurmas();
		} else {
			System.out.println("Valor digitado inválido");
			/* voltarMenu(); */
		}

		voltarMenuPrincipal();

	}

 	public void voltarMenu() {
		menuPrincipal();
	} 

	public void listarTurmas() {
		turmaDao.listarLista(BancoDados.getListas().getTurmasGeral());

		voltarMenuPrincipal();

	}

	public void cadTurma() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira o código da turma");
		int codigoDisciplina = sc.nextInt();

		System.out.println("Insira o código da disciplina que ela vai fazer parte");
		String disciplina = sc.next();
		Disciplina escolhidaX = disciplinadao.obter(disciplina);

		System.out.println("Digite o nome do professor que será dessa turma");
		String professor = sc.next();

		System.out.println("digite o semestre dessa turma");
		String semestre = sc.next();

		System.out.println("digite se a turma é presencial, 1 para sim e 2 para não");
		int valor = sc.nextInt();
		boolean presencialidade = true;

		if (valor < 1 || valor > 2) {
			System.out.println("Valor Informado inválido");
			System.exit(0);
		}

		presencialidade = valor == 1 ? true : false;

		System.out.println("Digite a sala que vai rolar a aula");
		String sala = sc.next();

		System.out.println("Digite o horario da aula");
		String horario = sc.next();

		System.out.println("digite a capacidade da turma. É válido somente numeros inteiros");
		int capMax = sc.nextInt();

		Turma turmax = new Turma(codigoDisciplina, escolhidaX, professor, semestre, presencialidade, sala, horario,
				capMax,
				new HashMap<Integer, Aluno>());

		turmaDao.incluir(turmax, BancoDados.getListas().getTurmasGeral(), null);

		voltarMenuPrincipal();

	}

	public void cadDisciplina() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome da disciplina");
		String nome = sc.next();

		System.out.println("digite o código da disciplina");
		String codDisciplina = sc.next();

		System.out.println("digite a quantidade de horas que é a disicplina");
		int horaa = sc.nextInt();

		Disciplina disciplinax = new Disciplina(nome, codDisciplina, horaa, new HashMap<String, Disciplina>(),
				new HashMap<Integer, Turma>());

		disciplinadao.incluirDisciplina(disciplinax);

		System.out.println("essa disciplina tem pré requisito? 1) SIM 2) NÃO");
		int valorY = sc.nextInt();
		if (valorY == 1) {
			System.out.println("digite qual será o pré requisito pra essa dsciplina");
			String codString = sc.next();
			Disciplina escolhidaM = disciplinadao.obter(codString);
			disciplinadao.adicionarPreRequisito(disciplinax, escolhidaM);
		}

		
	}

	public void modoAlunoI() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite 1 Para cadastrar Aluno");
		System.out.println("Digite 2 Para Listar todos os Alunos");
		System.out.println("Digite 3 Para Matricular aluno em alguma turma (é necessario cirar turma antes)");
		System.out.println("Digite 4 Para a aba de trancamento");
		System.out.println("Digite 9 para voltar");
		int valor = sc.nextInt();
		if (valor == 1) {
			cadAluno();
		} else if (valor == 2) {
			listarAlunosGeral();
		} else if (valor == 3) {
			System.out.println("AVISO!!! É NECESSARIO CRIAR UMA TURMA ANTES DE MATRICULAR UM ALUNO");
			matriculaAluno();
		} else if (valor == 4) {
			trancamento();

		} else if (valor == 9) {
			menuPrincipal();
		} else {
			System.out.println("Valor digitado inválido");
			/* voltarMenu(); */
		}
		sc.close();
		 voltarMenuPrincipal(); 
	}

	private void trancamento() {
		Scanner sc = new Scanner(System.in);
		System.out.println("voc~e entrou na aba de trancamento");
		System.out.println("digite 1 para trancar um semestre");
		System.out.println("digite 2 para trancar uma disciplina");
		System.out.println("digite 0 para voltar");
		int valor = sc.nextInt();
		if (valor == 1) {

		} else if (valor == 2) {

		} else {
			System.out.println("valor inválido, volte e tente novamente");
			/* voltarMenu(); */

		}
		 voltarMenuPrincipal(); 
	}

	public void matriculaAluno() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a matricula do aluno que vc deseja matricular");

		alunoDao.incluir(null, null, null);
		// TODO fazer esse daqui
		voltarMenuPrincipal();
	}

	public void listarAlunosGeral() {
		alunoDao.listarLista(BancoDados.getListas().getAlunosGeral());

		voltarMenuPrincipal();
	}

	public void cadAluno() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Você esta na aba de cadastro de aluno");
		System.out.println("Insira a matricula do aluno");
		Integer matricula = sc.nextInt();

		System.out.println("Insira o nome do aluno");
		String nomeAluno = sc.next();

		System.out.println("Insira o curso que o aluno faz");
		String curso = sc.next();

		System.out.println("Insira se o aluno é especial. Digite 1 para 'sim' e 2 para 'não'");
		int valor = sc.nextInt();
		boolean especialidade = true;

		if (valor < 1 || valor > 2) {
			System.out.println("Valor Informado inválido");
			System.exit(0);
		}

		especialidade = valor == 1 ? true : false;

		Aluno alunox = new Aluno(matricula, nomeAluno, curso, especialidade, new HashMap<String, Disciplina>());
		alunoDao.incluir(alunox, BancoDados.getListas().getAlunosGeral(), null);// adicionando ele em turmas geral

		System.out.println("O aluno matriculado ja fez alguma disciplina? 1)SIM 2)NÃO");
		int numero = sc.nextInt();
		if (numero == 1) {
			System.out.println("digite  a matricula do aluno");
			int matriculaX = sc.nextInt();
			Aluno escolhido = alunoDao.obter(matriculaX);

			System.out.println("digite o codigo da disciplina que ele fez");
			String codigoString = sc.next();

			Disciplina escolhida = disciplinadao.obter(codigoString);
			alunoDao.adicionarDisciplinasFeitas(escolhido, escolhida);

		}
		 voltarMenuPrincipal(); 
	}

	 public void voltarMenuPrincipal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Deseja voltar ao menu principal?");
		System.out.println("1 para sim ");
		System.out.println("2 para não ");
		int valor = sc.nextInt();
		if (valor == 1) {
			menuPrincipal();
		} else {
			System.out.println("tchau");
		}
	} 

}
