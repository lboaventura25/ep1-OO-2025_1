package servicos;

// implementar herança no alunoEspecial pra especial;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;

public class Main_teste {
	// pra testar eu preciso executar por aqui;
	

	public static void main(String[] args) {
		
		System.out.println(BancoDados.getListas().getDisciplinaGeral());
		
		BancoDados bd = new BancoDados();



		Menus menu = new Menus();

		
		menu.menuPrincipal();
		
		bd.salvar();
		System.out.println("Encerrou ok");

	}
}