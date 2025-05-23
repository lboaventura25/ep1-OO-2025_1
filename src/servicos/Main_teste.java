package servicos;

// implementar herança no alunoEspecial pra especial;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;
import persistencia.daoEntidades.TurmaDao;

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

		System.out.println("iniciei meu BD e meu daoALuno");
	

		Aluno aluno1 = new Aluno(242004706, "Gabriel Vieira", "Eng.software", false);
	
		Turma turma2 = new Turma(789, "Calculo1", "Wesley", "24.2", true, "I9", "12:00", 100, new HashMap<Integer, Aluno>());
		Turma turma1 = new Turma(005, "Calculo1", "Fragelli", "25.1", true, "I9", "10:00", 125,new HashMap<Integer, Aluno>());
		// nome da lista é o nome do atributo
		Disciplina disciplina1 = new Disciplina("calculo1", "mat0031", 90, null, new HashMap<Integer,Turma>());

		alunoDao.incluir(aluno1, Listas.getAlunosGeral());// adicionando meu aluno em alunosGeral
		//alunoDao.excluir(aluno1.getMatricula(), Listas.getAlunosGeral());
		alunoDao.incluir(Listas.getAlunosGeral().get(aluno1.getMatricula()), turma1.getAlunosPorTurma());
		// matriculando meu aluno em uma turma.


		turmaDao.incluir(turma1, Listas.getTurmasGeral());// adicionando aquela turma em turmasGeral
		turmaDao.incluir(turma2, Listas.getTurmasGeral());// adicionando aquela turma em turmasGeral
		turmaDao.incluir(Listas.getTurmasGeral().get(turma1.getCodigoDaDisciplina()), disciplina1.getTurmasPorDisciplinas());
		turmaDao.incluir(Listas.getTurmasGeral().get(turma2.getCodigoDaDisciplina()), disciplina1.getTurmasPorDisciplinas());
		// pegando essa turma e colocando ela numa lista de uma disciplina.
		
		turmaDao.alterar(turma1.getCodigoDaDisciplina(), "ftyfygui", null);
	

		

	}

}
