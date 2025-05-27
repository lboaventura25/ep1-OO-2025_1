package servicos;

// implementar herança no alunoEspecial pra especial;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;
import persistencia.daoEntidades.DisciplinaDao;
import persistencia.daoEntidades.TurmaDao;
import java.util.Scanner;

import java.util.HashMap;
import entidades.Aluno;
import entidades.Disciplina;
import entidades.Turma;
import entidades.Listas;

public class Main_teste {// pra testar eu preciso executar por aqui;

	public static void main(String[] args) {
		BancoDados bd = new BancoDados();
		AlunoDao alunoDao = new AlunoDao();
		TurmaDao turmaDao = new TurmaDao();
		DisciplinaDao disciplinadao = new DisciplinaDao();
		Menus menu = new Menus();

		
		menu.menuPrincipal();
		
		

	}
}