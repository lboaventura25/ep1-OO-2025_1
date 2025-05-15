package servicos;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;

import java.util.HashMap;

import entidades.Aluno;

public class Main_teste {// pra testar eu preciso executar por aqui;

	public static void main(String[] args) {
		BancoDados bd = new BancoDados();
		AlunoDao alunoDao = new AlunoDao();

		System.out.println("iniciei meu BD e meu daoALuno");

		Aluno Gabriel = new Aluno(242004706, "Gabriel Vieira", "Eng.software", false);// instanciando meu aluno
		Aluno Teresa = new Aluno(456789123, "Maria Teresa", "Psicologia", false);// instanciando meu aluno
		
		alunoDao.incluir(Gabriel, Gabriel.getMatricula(), BancoDados.getAlunosGeral());// adicionando ma lista alunosGeral
		alunoDao.incluir(Teresa, Teresa.getMatricula(), BancoDados.getAlunosGeral());
		alunoDao.listar(BancoDados.getAlunosGeral());// listando a lista alunos geral
		alunoDao.excluir(Gabriel.getMatricula(), BancoDados.getAlunosGeral());
		alunoDao.listar(BancoDados.getAlunosGeral());
		
		
		BancoDados.persistir(BancoDados.getAlunosGeral(), "alunoDB.txt");
		/* BancoDados.persistir(BancoDados.getProfessoresGeral(), "professores.txt");
		BancoDados.persistir(BancoDados.getTurmasGeral(), "turmas.txt"); */
		BancoDados.persistir(BancoDados.getAlunosGeral(), "disciplina.txt");
		
		
	}

}
