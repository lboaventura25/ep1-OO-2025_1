package servicos;

import persistencia.BancoDados;
import persistencia.dao.Daos;
import entidades.Aluno;

public class Main_teste {// pra testar eu preciso executar por aqui;

	public static void main(String[] args) {
		BancoDados bd = new BancoDados();
		Daos daos = new Daos();

		System.out.println("iniciei meu BD");

		Aluno Gabriel = new Aluno(242004706, "Gabriel Vieira", "Eng.software", false);// instanciando meu aluno

		Daos.adicionar(BancoDados.getAlunosGeral(), 242004706, Gabriel);// adicionando ele em alunosGeral
		
		Daos.listarCompleta(BancoDados.getAlunosGeral());

	}

}
