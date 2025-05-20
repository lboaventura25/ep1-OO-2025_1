package servicos;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;

import java.util.HashMap;

import entidades.Aluno;
import entidades.Listas;

public class Main_teste {// pra testar eu preciso executar por aqui;

	public static void main(String[] args) {
		BancoDados bd = new BancoDados();
		AlunoDao alunoDao = new AlunoDao();
		Listas listas = new Listas();
		
		

		System.out.println("iniciei meu BD e meu daoALuno e minhas listas");

		Aluno aluno1 = new Aluno(242004706, "Gabriel Vieira", "Eng.software", false);// instanciando meu aluno
		Aluno aluno2 = new Aluno(456789123, "Maria Teresa", "Psicologia", false);// instanciando meu aluno
		// sera se a pessoa que vai escolher o nome do objeto?? acho que não né. 

		alunoDao.incluir(aluno1, aluno1.getMatricula(), listas.getAlunosGeral());// adicionando na lista
																						// alunosGeral
		alunoDao.incluir(aluno2, aluno2.getMatricula(), listas.getAlunosGeral());
		alunoDao.listar(BancoDados.getAlunosGeral());// listando a lista alunos geral
		//alunoDao.alterar(aluno2, BancoDados.getAlunosGeral(), "Curso", "Pedagogia");// TODO ver o porque desse metodo
																					// alterar(especial) nao ta
																					// funcionando
		alunoDao.obter(aluno1.getMatricula(), BancoDados.getAlunosGeral());
	
		alunoDao.listar(BancoDados.getAlunosGeral());// listando a lista alunos geral

		BancoDados.persistir(BancoDados.getAlunosGeral(), "alunoDB.txt");
		/*
		 * BancoDados.persistir(BancoDados.getProfessoresGeral(), "professores.txt");
		 * BancoDados.persistir(BancoDados.getTurmasGeral(), "turmas.txt");
		 */
		BancoDados.persistir(BancoDados.getAlunosGeral(), "disciplina.txt");

	}

}
