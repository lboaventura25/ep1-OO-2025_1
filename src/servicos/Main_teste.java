package servicos;

// implementar herança no alunoEspecial pra especial;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;

public class Main_teste {
	// pra testar eu preciso executar por aqui;
	

	public static void main(String[] args) {
		
		
		
		BancoDados bd = new BancoDados();
		AlunoDao a = new AlunoDao();
		a.listarLista(bd.getListas().getAlunosGeral());
		
		
		Menus menu = new Menus();

		
		menu.menuPrincipal();
		
		bd.salvar();
		System.out.println("Encerrou ok");

	}
}