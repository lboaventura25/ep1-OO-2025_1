
package persistencia.daoInterfaces;
import java.util.HashMap;
import java.util.List;
import entidades.Entidade;

public interface IDao<T extends Entidade> {// Generec's sendo T algum dado do tipo Entidade ?

	public T incluir( T entidade,Integer key,HashMap<Integer, T> listaManipulada);// retornar quem eu adicionar 
	// passa quem eu quero colocar, o valor vinculado a ele aonde quero colocar ele.
	public boolean excluir ( T entidade,HashMap<Integer, T> listaManipulada);// retorna um true ou false se for excluid ou nao 
	// passa quem eu quero tirar e de onde eu quero tirar 
	public T alterar ( T entidade,HashMap<Integer, T> listaManipulada);// retorno quem eu alterei
	// passa quem eu quero mudar e onde ele está
	public T obter(String nome); // retorna quem eu quero achar 
	// passa o nome de quem eu quero editar, nome ou matricula.
	//public T obter(long identificador); // retorna que eu quero achar 
	public List<T> listar(HashMap<Integer, T> listaExibida);// retornar a lista.
	
	
}
