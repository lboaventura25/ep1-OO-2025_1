package servicos;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;

import java.util.HashMap;

import entidades.Aluno;

public class Main_teste {// pra testar eu preciso executar por aqui;

	public static void main(String[] args) {
		BancoDados bd = new BancoDados();
		AlunoDao alunoDao = new AlunoDao();

		System.out.println("iniciei meu BD");

		Aluno Gabriel = new Aluno(242004706, "Gabriel Vieira", "Eng.software", false);// instanciando meu aluno
		
		alunoDao.incluir(Gabriel, Gabriel.getMatricula(), BancoDados.getAlunosGeral());
		alunoDao.listar(BancoDados.getAlunosGeral());
		
		
		BancoDados.persistir(BancoDados.getAlunosGeral(), "alunosDB.txt");
		
		
	}

}
