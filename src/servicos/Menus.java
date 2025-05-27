package servicos;

import java.util.Scanner;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;
import persistencia.daoEntidades.DisciplinaDao;
import persistencia.daoEntidades.TurmaDao;

import java.util.HashMap;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Listas;

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
		System.out.println("Digite 3 para Modo Avaliação");
		System.out.println("Digite 0 para sair da aplicação");
		int valor = sc.nextInt();
		if (valor == 1) {
			System.out.println("entrou no Modo aluno");
			modoAlunoI();

		} else if (valor == 2) {
			System.out.println("entrou no Modo Disciplina");
		} else if (valor == 3) {
			System.out.println("entrou no Modo avaliação");

		}else if (valor == 0) {
			System.out.println("saiu...");
			sc.close();
		} else {
			System.out.println("Valor digitado invalido");
		}

		sc.close();
	}

	public  void modoAlunoI() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite 1 Para cadastrar Aluno");
		System.out.println("Digite 2 Para Listar todos os Alunos");
		System.out.println("Digite 3 Para Matricular aluno em alguma turma");
		System.out.println("Digite 4 Para a aba de trancamento");
		System.out.println("Digite 9 para voltar");
		int valor = sc.nextInt();
		if (valor == 1) {
			cadAluno();
		} else if (valor == 2) {
			listarAlunosGeral();
		} else if (valor == 3) {

		} else if (valor == 4) {

		} else if (valor == 9) {
			menuPrincipal();
		} else {
			System.out.println("Valor digitado inválido");
		}
		sc.close();
	}
	public void listarAlunosGeral(){
		alunoDao.listarLista(BancoDados.getListas().getAlunosGeral());
	}


	public  void cadAluno() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Voc~e esta na aba de cadastro de aluno");
		System.out.println("Insira a matricula do aluno");
		Integer matricula = sc.nextInt();

		System.out.println("Insira o nome do aluno");
		String nomeAluno = sc.nextLine();

		System.out.println("Insira o cruso que o aluno faz");
		String curso = sc.nextLine();

		System.out.println("Insira se o aluno é especial. Digite 1 para 'sim' e 2 para 'não'");
		int valor = sc.nextInt();
		boolean especialidade = true;
		
		if(valor < 1 || valor > 2 ){
		  System.out.println ("Valor Informado inválido");
		  System.exit(0);
		}


		especialidade = valor == 1? true:false;
		
		
		Aluno alunox = new Aluno(matricula, nomeAluno, curso, especialidade, new HashMap<String,Disciplina>());
		alunoDao.incluir(alunox, BancoDados.getListas().getAlunosGeral(), null);//adicionando ele em turmas geral 
		
		
	}
	
} 
