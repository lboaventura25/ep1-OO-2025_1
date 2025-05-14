package persistencia.dao;

import java.util.List;

import entidades.Entidade;

public interface IDao<T extends Entidade> {

	public T incluir(T entidade);
	public boolean excluir (T entidfade);
	public T alterar (T entidade);
	public T obter(String nome);
	public T obter(long identificador);
	public List<T> listar();
	
	
}
