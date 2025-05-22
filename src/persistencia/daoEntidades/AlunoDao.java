// as manipulações de objeto aluno nas listas de aluno 

package persistencia.daoEntidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import entidades.Listas;
import entidades.Aluno;
import persistencia.daoInterfaces.IAlunoDao;

public class AlunoDao implements IAlunoDao {
	// funciona pra lista alunoGeral

	@Override// VERIFICADA
	public Aluno incluir(Aluno aluno, HashMap<Integer, Aluno> listaManipulada) {
		
		// escolho aonde eu quero colocar e e quem eu quero colocar;
		if (verificaDuplicidade(aluno, listaManipulada)) {
			System.out.println("detectada Duplicidade de matricula");
		} else {
			if (listaManipulada != null) {// se a lista existir
				listaManipulada.put(aluno.getMatricula(), aluno);
				System.out.println("Objeto: " + aluno.getNome() + " adicionado com sucesso na lista ");
				System.out.println("-----------------");
			}

		}

		return null;
	}

	@Override// VERIFICADA
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

		if (Listas.getAlunosGeral().containsValue(obter(chave))) {// se a lista conter algum valor desse
			if (campoAlterado == "Matricula" || campoAlterado == "matricula") {// retorno o velho e o novo
				System.out.println("tentando alterar matricula");
				Integer novaMatricula = Integer.parseInt(alteração);// transforma a string em integer
				String velhoNome = elemento.getNome();
				String velhoCurso = elemento.getCurso();
				boolean velhoEspecial = elemento.isEspecial();
				Aluno novoAluno = new Aluno(novaMatricula, velhoNome, velhoCurso, velhoEspecial);// criei outro aluno

				excluir(elemento.getMatricula(), Listas.getAlunosGeral());// excluindo o antigo elemento com a matricula
																			// velha.
				incluir(novoAluno, Listas.getAlunosGeral());// adicionando novo aluno na lista
				System.out.println("matriucula alterada com sucesso");
				return elemento;
			}
			// VERIFICADO
			if (campoAlterado == "Curso" || campoAlterado == "curso") {
				System.out.println("tentando alterar o Curso");
				elemento.setCurso(alteração);
				System.out.println("curso alterado");
				return elemento;
			}
			 // VERIFICADO
			if (campoAlterado == "Nome" || campoAlterado == "nome") {
				System.out.println("tentando alterar o nome");
				elemento.setNome(alteração);
				System.out.println("nome alterado com sucesso");
				return elemento;
				// se eu for disponibilizar esse metodo eu preciso pensar em outra forma de
				// chamr os objetos Aluno, que nao seja pelo o nome deles
				// talvez "aluno1", "aluno2"... e assim por diante.

			}
			if (campoAlterado == "Especial" || campoAlterado == "nome") { // TODO verificar esse metodo;
				System.out.println("tentando alterar o Especial");
				if (alteração != "true" | alteração != "false") {// se o valor nao for true ou false;
					System.out.println("alteração não válida");
					System.out.println("aceita-se somente a String 'True' ou 'False'");
				} else {// se for igual a tru ou false;
					boolean alteraçãoBoolean = Boolean.parseBoolean(alteração);
					elemento.setEspecial(alteraçãoBoolean);
					return elemento;
				}

			}else{
				System.out.println("-> Nao existe esse campo para ser alterado.");
				System.out.println("-> Os campos existentes são: nome, curso, matricula, e se é especial.");

			}

		} else {
			System.out.println("não existe esse elemento na lista de alunos");
			return null;
		}
		return null;
	}

	@Override// VERIFICADA
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
		/*
		 * throw new
		 * UnsupportedOperationException("Unimplemented method 'verificaDuplicidade'");/
		 * / oque isso faz ?
		 */
	}

	@Override// VERIFICADO
	public Aluno obter(Integer chave) {// buscando aluno no alunos geral e exibindo ele
		if (Listas.getAlunosGeral().containsKey(chave)) {
			System.out.println(" achou " + Listas.getAlunosGeral().get(chave));
			return Listas.getAlunosGeral().get(chave);

		} else {
			System.out.println("o aluno vinculado a esta maticula nao esta nessa lista");
		}
		return null;
	}

}
