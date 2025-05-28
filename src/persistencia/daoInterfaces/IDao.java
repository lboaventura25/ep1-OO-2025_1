
package persistencia.daoInterfaces;
import java.util.HashMap;
import java.util.List;
import entidades.Entidade;



public interface IDao<T,T1 extends Entidade> {// Generec's sendo T algum dado do tipo Entidade ?

	public T incluir( T entidade,HashMap<Integer, T> listaManipulada, T1 turmaOuDisciplina);// retornar quem eu adicionar 
	// quem eu quero colocar e aonde, a matricula eu pego do proprio objeto.

	public boolean excluir ( Integer key,HashMap<Integer, T> listaManipulada);// retorna um true ou false se for excluid ou nao 
	// VERIFICADA
	// excluir de uma lista especifica;
	// passa a chave de quem eu quero tirar,e de onde eu quero tirar 

	public T alterar ( Integer chave, String campoAlterado, String alteração);
	//TODO revisar esse metodo 
	//todos que eu mudar eu vou mudar no alunosGeral logo mudarão em todas as outras listas;  
	

	public T obter(Integer chave); // retorna que eu quero achar 
	//TODO verificar esse método
	// se eu passar só a chave eu posso acho quem eu quero ja que as listas são derivadas;
	// é necessário que eu chame os alunos de chamando de alunosGeral eu chamo de todas as outras.

	public List<T> listarLista(HashMap<Integer, T> listaExibida);// retornar a lista.
	// VERIFICADA
	// tudo certo

	
}
