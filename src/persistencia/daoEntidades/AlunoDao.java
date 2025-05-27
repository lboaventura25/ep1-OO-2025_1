// as manipulações de objeto aluno nas listas de aluno 

package persistencia.daoEntidades;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Listas;
import entidades.Turma;
import entidades.Aluno;
import entidades.Disciplina;
import persistencia.BancoDados;
import persistencia.daoInterfaces.IAlunoDao;

public class AlunoDao implements IAlunoDao {
	// funciona pra lista alunoGeral

	@Override // VERIFICADA
	public Aluno incluir(Aluno aluno, HashMap<Integer, Aluno> listaManipulada, Turma turma) {

		if (listaManipulada != BancoDados.getListas().getAlunosGeral()) {// se a lista for de alguma turma
			if (listaManipulada.size() < turma.getCapMaxAluno()) {// se tiver vaga na turma ainda,// verificado
				if (contemPrerequisitos(aluno, turma.getDisciplina())) { // se o aluno tiver os pré requisitos
					if (verificaDuplicidade(aluno, listaManipulada)) {// se n for uma matricula duplicada

						System.out.println("detectada Duplicidade de matricula");
					} else {// senão, cadastra
						if (aluno.isEspecial() == true) {// verificado

							incluirEspecial(aluno, aluno.getMatricula(), listaManipulada, aluno.getContador());
						} else {
							System.out.println("aluno não é especial");
							if (listaManipulada != null) {// se a lista existir
								listaManipulada.put(aluno.getMatricula(), aluno);
								System.out.println("Objeto: " + aluno.getNome() + " adicionado com sucesso na lista ");
								System.out.println("-----------------");
							}
						}

					}
				}

			} else {

				System.out.println("A turma já está lotada");
			}

		} else {
			if (verificaDuplicidade(aluno, listaManipulada)) {// cadastra
				System.out.println("detectada Duplicidade de matricula");
			} else {
				if (listaManipulada != null) {// se a lista existir
					listaManipulada.put(aluno.getMatricula(), aluno);
					System.out.println("Objeto: " + aluno.getNome() + " adicionado com sucesso na lista ");
					System.out.println("-----------------");
				}

			}

		}
		// escolho aonde eu quero colocar e e quem eu quero colocar;

		return null;
	}

	@Override // VERIFICADA
	public List<Aluno> listarLista(HashMap<Integer, Aluno> listaExibida) {// aqui pode ser duas listas diferentes por
																			// isso
																			// tenho que ter um argumento pra isso
		// funciona pra qualquer lista??

		// listando cada objeto da lista
		System.out.println("Nessa lista tem os seguintes alunos:");
		System.out.println("------------");
		for (Map.Entry<Integer, Aluno> elemento : listaExibida.entrySet()) {

			System.out.println("nome do aluno:" + elemento.getValue().getNome());
			System.out.println("matricula do aluno:" + elemento.getValue().getMatricula());
			System.out.println("curso:" + elemento.getValue().getCurso());
			System.out.println("É especial:" + elemento.getValue().isEspecial());
			System.out.println("---------------");

		}
		return null;
	}

	@Override // VERIFICADO
	public boolean excluir(Integer key, HashMap<Integer, Aluno> listaManipulada) {
		if (listaManipulada.containsKey(key)) {// verificando se existe esse objeto na lista
			listaManipulada.remove(key);// achar um valor pela a chave
			System.out.println("objeto de chave: " + key + " removido");
			System.out.println("objeto de valor: " + listaManipulada.get(key) + " removido");
			return true;
		} else {
			System.out.println("esse objeto nao existe nessa  lista");
			return false;
		}

	}

	@Override
	public Aluno alterar(Integer chave, String campoAlterado, String alteração) {

		Aluno elemento = obter(chave);// metodo que acha o aluno pela a chave;

		if (BancoDados.getListas().getAlunosGeral().containsValue(obter(chave))) {// se a lista conter algum valor desse
			if (campoAlterado == "Matricula") {// retorno o velho e o novo
				System.out.println("tentando alterar matricula");
				Integer novaMatricula = Integer.parseInt(alteração);// transforma a string em integer
				String velhoNome = elemento.getNome();
				String velhoCurso = elemento.getCurso();
				boolean velhoEspecial = elemento.isEspecial();
				HashMap<String, Disciplina> disciplinaFeitas = elemento.getDisciplinasFeitas();
				Aluno novoAluno = new Aluno(novaMatricula, velhoNome, velhoCurso, velhoEspecial, disciplinaFeitas);// criei
																													// outro
																													// aluno

				excluir(elemento.getMatricula(), BancoDados.getListas().getAlunosGeral());// excluindo o antigo elemento com a matricula
																			// velha.
				incluir(novoAluno, BancoDados.getListas().getAlunosGeral(), null);// adicionando novo aluno na lista
				System.out.println("matriucula alterada com sucesso");
				return elemento;
			}
			// VERIFICADO
			if (campoAlterado == "Curso") {
				System.out.println("tentando alterar o Curso");
				elemento.setCurso(alteração);
				System.out.println("curso alterado");
				return elemento;
			}
			// VERIFICADO
			if (campoAlterado == "Nome") {
				System.out.println("tentando alterar o nome");
				elemento.setNome(alteração);
				System.out.println("nome alterado com sucesso");
				return elemento;
				// se eu for disponibilizar esse metodo eu preciso pensar em outra forma de
				// chamr os objetos Aluno, que nao seja pelo o nome deles
				// talvez "aluno1", "aluno2"... e assim por diante.

			}
			if (campoAlterado == "Especialidade") { // TODO verificar esse metodo;
				System.out.println("tentando alterar o Especial");
				if (alteração != "true" | alteração != "false") {// se o valor nao for true ou false;
					System.out.println("alteração não válida");
					System.out.println("aceita-se somente a String 'True' ou 'False'");
				} else {// se for igual a tru ou false;
					boolean alteraçãoBoolean = Boolean.parseBoolean(alteração);
					elemento.setEspecial(alteraçãoBoolean);
					return elemento;
				}

			} else {
				System.out.println("-> Nao existe esse campo para ser alterado.");
				System.out.println("-> Os campos existentes são: 'Nome', 'Curso', 'Matricula', e 'Especialidade'");

			}

		} else {
			System.out.println("não existe esse elemento na lista de alunos");
			return null;
		}
		return null;
	}

	@Override // VERIFICADA
	public boolean verificaDuplicidade(Aluno aluno, HashMap<Integer, Aluno> listaManipulada) {

		// esse metodo vai verificar se quem eu quero cadastrar ja existe na lista onde
		// eu quero colocar ele.
		if (listaManipulada.containsKey(aluno.getMatricula())) {
			System.out.println("O aluno de nome: " + aluno.getNome() + ", e matricula: " + aluno.getMatricula()
					+ " já esta presente nessa lista.");

			return true;
		} else {
			return false;

		}

	}

	@Override // VERIFICADO
	public Aluno obter(Integer chave) {// buscando aluno no alunos geral e exibindo ele
		if (BancoDados.getListas().getAlunosGeral().containsKey(chave)) {
			System.out.println(" achou " + BancoDados.getListas().getAlunosGeral().get(chave));
			return BancoDados.getListas().getAlunosGeral().get(chave);

		} else {
			System.out.println("o aluno vinculado a esta maticula nao esta nessa lista");
		}
		return null;
	}

	@Override
	public void adicionarDisciplinasFeitas(Aluno aluno, Disciplina disciplina) {// verificado
		if (aluno != null & disciplina != null) {
			aluno.getDisciplinasFeitas().put(disciplina.getCodigo(), disciplina);
		}
	}

	@Override
	public boolean contemPrerequisitos(Aluno aluno, Disciplina disciplina) {// verificado
		boolean verificado = true;
		for (Map.Entry<String, Disciplina> preRequisito : disciplina.getPreRequisitos().entrySet()) {
			if (aluno.getDisciplinasFeitas().containsKey(preRequisito.getKey())) {// se em alunoDisciplinas feitas
				// exitir alguma disciplinas em
				verificado = true;
			} else {
				System.out.println(
						"este aluno nao tem os pré-requisitos necessários pra ser matriculado nessa disciplina.");
			}
			verificado = false;

		}
		return verificado;
	}

	@Override // verificado
	public void trancarSemestre(Aluno aluno) {// devo ver em quais listas ele estiver matriculado e tirar de todas
		if (aluno != null) {
			for (Map.Entry<Integer, Turma> turmas : BancoDados.getListas().getTurmasGeral().entrySet()) {// para cada turma em
																							// listaTurmasGeral
				if (turmas.getValue().getAlunosPorTurma().containsKey(aluno.getMatricula())) {
					turmas.getValue().getAlunosPorTurma().remove(aluno.getMatricula());
				} else {
					System.out.println(
							"esse aluno não foi encontrado em nenhuma lista de turmas, ou seja, ele não está matriculado em nehuma turma");
				}
			}
		}
		System.out.println("-> Aluno: " + aluno.getNome() + " trancou o semstre");

	}

	@Override
	public void trancarDisciplina(Aluno aluno, Turma turma) {
		if (aluno != null & turma != null) {
			if (turma.getAlunosPorTurma().containsKey(aluno.getMatricula())) {
				turma.getAlunosPorTurma().remove(aluno.getMatricula());
			} else {
				System.out.println("-> O aluno:" + aluno.getNome() + " não esta matriculado nessa turma");
			}
		}

	}

	@Override
	public void incluirEspecial(Aluno aluno, Integer chave, HashMap<Integer, Aluno> listamanipulada,
			int contador) {

		System.out.println(contador);
		if (contador < 2) {
			listamanipulada.put(chave, aluno);
			aluno.setContador(contador += 1);
			;// cada vez que colocar um vai adicionar um ao contador
			System.out.println(aluno.getNome() + " adicionado com sucesso");
		} else {
			System.out.println("Erro: este aluno já foi adicionado a 2 turmas.");
		}
	}
}
