package servicos;

// implementar herança no alunoEspecial pra especial;


import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;

import java.util.HashMap;

import entidades.Aluno;
import entidades.Listas;

public class Main_teste {// pra testar eu preciso executar por aqui;

	public static void main(String[] args) {
		BancoDados bd = new BancoDados();
		AlunoDao alunoDao = new AlunoDao();

		System.out.println("iniciei meu BD e meu daoALuno e minhas listas");

		Aluno aluno1 = new Aluno(242004706, "Gabriel Vieira", "Eng.software", false);// instanciando meu aluno
		Aluno aluno2 = new Aluno(456789123, "Maria Teresa", "Psicologia", false);// instanciando meu aluno


		
		//alunoDao.incluir(aluno2, Listas.getAlunosGeral());
		alunoDao.incluir(aluno1, Listas.getAlunosGeral());
		alunoDao.alterar(aluno1.getMatricula(), "matricula", "123456789");
		
		alunoDao.listarLista(Listas.getAlunosGeral());
		//alunoDao.listarLista(Listas.getAlunosGeral());
		

		
	}

}
