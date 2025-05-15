// as manipulações de objeto aluno nas listas de aluno 

package persistencia.daoEntidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Aluno;
import persistencia.daoInterfaces.IAlunoDao;

public class AlunoDao implements IAlunoDao {

	@Override
	public Aluno incluir(Aluno aluno, Integer key, HashMap<Integer, Aluno> listaManipulada) {
		if (listaManipulada != null) {
			listaManipulada.put(key, aluno);
			System.out.println("Objeto: " + aluno.getNome() + " adicionado com sucesso");
			System.out.println("-----------------");
		} else {
			System.out.println("Lista vazia ou não existe");
		}
		return null;
	}

	@Override
	public List<Aluno> listar(HashMap<Integer, Aluno> listaExibida) {// aqui pode ser duas listas diferentes por isso
																		// tenho que ter um argumento pra isso
		// listando cada objeto da lista
		System.out.println("Na lista que tem todos os alunos matriculados tem os tais alunos:");
		System.out.println("------------");
		for (Map.Entry<Integer, Aluno> elemento : listaExibida.entrySet()) {

			System.out.println("objeto: " + elemento.getValue());
			System.out.println("chave:" + elemento.getKey());
			System.out.println("nome do aluno:" + elemento.getValue().getNome());
			System.out.println("matricula do aluno:" + elemento.getValue().getMatricula());
			System.out.println("curso:" + elemento.getValue().getCurso());
			System.out.println("É especial:" + elemento.getValue().isEspecial());
			System.out.println("---------------");

		}
		return null;
	}

	@Override
	public boolean excluir(Integer key, HashMap<Integer, Aluno> listaManipulada) {
		if (listaManipulada.containsKey(key)) {// verificando se existe esse objeto na lista
			System.out.println("objeto de chave: " + key + " removido");
			System.out.println("objeto de valor: " + listaManipulada.get(key) + " removido");
			listaManipulada.remove(key);
			return true;
		} else {
			System.out.println("esse objeto nao existe nessa  lista");
			return false;
		} // achar um valor pela a chave

	}

	@Override
	public Aluno alterar(Aluno entidade, HashMap<Integer, Aluno> listaManipulada, String campoAlterado,
			String alteração) {
		Aluno elemento = listaManipulada.get(entidade.getMatricula());
		// a matricula vai ser a chave, logo passando a matricula eu retorno a chave
		// dele.
		if (listaManipulada.containsValue(entidade)) {// se a lista conter algum valor desse
			if (campoAlterado == "Matricula") {
				// aqui é melhor pedir pra ele adicionar outro aluno com outra chave, sendo a
				// nova matricula
				return elemento;
			}
			if (campoAlterado == "Curso") {
				System.out.println("tentando alterar o Curso");
				elemento.setCurso(alteração);
				System.out.println("curso alterado");
				return elemento;
			}
			if (campoAlterado == "Nome") {
				System.out.println("tentando alterar o nome");
				elemento.setNome(alteração);
				System.out.println("nome alterado com sucesso");
				return elemento;
				// se eu for disponibilizar esse metodo eu preciso pensar em outra forma de chamr os objetos Aluno, que nao seja pelo o nome deles
				// talvez "aluno1", "aluno2"... e assim por diante.

			}
			if (campoAlterado == "Especial") { // TODO verificar esse metodo;
				System.out.println("tentando alterar o Especial");
				if (alteração != "true" | alteração !="false") {// se o valor nao for true ou false;
					System.out.println("alteração não válida");
					System.out.println("aceita-se somente a String 'True' ou 'False'");
				}
				else{// se for igual a tru ou false;
					boolean alteraçãoBoolean = Boolean.parseBoolean(alteração);
					elemento.setEspecial(alteraçãoBoolean);
				return elemento;
				}
				

			}

		} else {
			System.out.println("não existe esse elemento em tal lista");
			return null;
		}
		return null;
	}

	@Override
	public Aluno obter(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Integer key, HashMap<Integer, Aluno> listaManipulada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verificaDuplicidade() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'verificaDuplicidade'");
	}

	// @Override
	// public Aluno obter(long identificador) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
