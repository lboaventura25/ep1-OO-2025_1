package persistencia.dao;

import java.util.HashMap;
import java.util.Map;




public class Daos {

	public static void deletar(HashMap<Integer, Object> listaManipulada, Integer chave) {
	}

	public static void listarCompleta(HashMap<Integer, Object> listaManipulada) {
		for(Map.Entry<Integer, Object> entra: listaManipulada.entrySet()) {
			System.out.println("chave:"+entra.getKey()+" valor:"+entra.getValue());
		}
		
	}

	public static void adicionar(HashMap<Integer, Object> listaManipulada, Integer chave, Object objeto) {
		if (listaManipulada != null) {// se a lista for diferente de null(se existir)
			listaManipulada.put(chave, objeto);// vou passar a chave que eu quero (matricula ou id), e o objeto.
			System.out.println("Objeto: " + objeto);
			System.out.println("adicionado com sucesso");//testar isso ?
		} else {

			System.out.println("Lista vazia ou não existe");
		}
	}

	public static void contemChave(HashMap<Integer, Object> listaManipulada, Integer chave) {

	}

	public static void listarUm(HashMap<Integer, Object> listaManipulada, Integer chave) {
		if (listaManipulada != null && !listaManipulada.isEmpty()) {// se a lista for diferente de null e se estiver
																	// vazia
			Object objetoAchado = listaManipulada.get(chave); // o get retorna o valor daquela chave
			System.out.println(objetoAchado);
		} else {

			System.out.println("Lista vazia ou não existe");
		}

	}

}