package servicos;

// implementar herança no alunoEspecial pra especial;

import persistencia.BancoDados;
import persistencia.daoEntidades.AlunoDao;
import persistencia.daoEntidades.DisciplinaDao;
import persistencia.daoEntidades.TurmaDao;

import java.util.HashMap;
import entidades.Aluno;
import entidades.Disciplina;
import entidades.Turma;
import entidades.Listas;


public class Main_teste {// pra testar eu preciso executar por aqui;

	public static void main(String[] args) {
		BancoDados<Aluno> bd = new BancoDados<Aluno>();
		AlunoDao alunoDao = new AlunoDao();
		TurmaDao turmaDao = new TurmaDao();
		DisciplinaDao  disciplinadao = new DisciplinaDao();

		System.out.println("iniciei meu BD e meu daoALuno");
	

		Aluno aluno1 = new Aluno(242004706, "Gabriel Vieira", "Eng.software", false, new HashMap<String,Disciplina>());
		Aluno aluno2 = new Aluno(123456, "Vieira", "Eng.software", false,new HashMap<String,Disciplina>());
	
		Turma turma2 = new Turma(789, "Calculo1", "Wesley", "24.2", true, "I9", "12:00", 1, new HashMap<Integer, Aluno>());
		// nome da lista é o nome do atributo
		Disciplina disciplina1 = new Disciplina("calculo1", "mat0031", 90,  new HashMap<String,Disciplina>(), new HashMap<Integer,Turma>());
		Disciplina disciplina2 = new Disciplina("Fisica1", "FI0031", 90, new HashMap<String,Disciplina>(), new HashMap<Integer,Turma>());


		alunoDao.incluir(aluno1, Listas.getAlunosGeral(),null);// adicionando meu aluno em alunosGeral
		alunoDao.incluir(aluno2, Listas.getAlunosGeral(),null);// adicionando meu aluno em alunosGeral
		alunoDao.incluir(Listas.getAlunosGeral().get(aluno1.getMatricula()), turma2.getAlunosPorTurma(), turma2);
		alunoDao.incluir(Listas.getAlunosGeral().get(aluno2.getMatricula()), turma2.getAlunosPorTurma(), turma2);
		//alunoDao.excluir(aluno1.getMatricula(), Listas.getAlunosGeral());
		// matriculando meu aluno em uma turma.

		disciplinadao.adicionarPreRequisito(disciplina2, disciplina1);
		


		
		/* turmaDao.incluir(turma2, Listas.getTurmasGeral());// adicionando aquela turma em turmasGeral
		turmaDao.incluir(Listas.getTurmasGeral().get(turma2.getCodigoDaDisciplina()), disciplina1.getTurmasPorDisciplinas()); */
		// pegando essa turma e colocando ela numa lista de uma disciplina.
		
	
	

		

	}

}
