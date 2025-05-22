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
	
		Turma turma1 = new Turma(005, "Calculo1", "Fragelli", 25.1, false, "I9", 10.00, 125,new HashMap<Integer, Aluno>());
		// nome da lista é o nome do atributo
		Disciplina disciplina1 = new Disciplina("calculo1", "mat0031", 90, null, new HashMap<Integer,Turma>());

		alunoDao.incluir(aluno1, Listas.getAlunosGeral());// adicionando meu aluno em alunosGeral
		alunoDao.incluir(Listas.getAlunosGeral().get(aluno1.getMatricula()), turma1.getAlunosPorTurma());
		//adicionando meu aluno de alunosGeral em na lista de uma turma
/* 		alunoDao.listarLista(turma1.getAlunosPorTurma());
 */		//listando a lista de alunos daquela turma

		turmaDao.incluir(turma1, Listas.getTurmasGeral());// adicionando aquela turma em turmasGeral
		turmaDao.incluir(turma1, Listas.getTurmasGeral());// adicionando aquela turma em turmasGeral
		turmaDao.incluir(Listas.getTurmasGeral().get(turma1.getCodigoDaDisciplina()), disciplina1.getTurmasPorDisciplinas());
		// pegando essa turma e colocando ela numa lista de uma disciplina.

		turmaDao.listarLista(disciplina1.getTurmasPorDisciplinas());

	}

}
