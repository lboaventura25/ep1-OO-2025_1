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
			System.out.println("Objeto: " + aluno.getNome());
			System.out.println("adicionado com sucesso");
		} else {
			System.out.println("Lista vazia ou não existe");
		}
		return null;
	}

	@Override
	public List<Aluno> listar(HashMap<Integer, Aluno> listaExibida) {
		for(Map.Entry<Integer, Aluno> elemento : listaExibida.entrySet()) {
			System.out.println("chave:"+elemento.getKey()+" valor:"+elemento.getValue());
		}
		return null;
	}

	@Override
	public boolean excluir(Aluno entidade, HashMap<Integer, Aluno> listaManipulada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Aluno alterar(Aluno entidade, HashMap<Integer, Aluno> listaManipulada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aluno obter(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Aluno obter(long identificador) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
