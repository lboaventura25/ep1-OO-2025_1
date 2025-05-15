 


package persistencia.daoInterfaces;

import entidades.Aluno;

public interface IAlunoDao extends IDao<Aluno> {//  ALuno vai ser o tipo de metodo que eu vou receber, faz a função de T
	public  boolean verificaDuplicidade();
//	 pelo o fato de estar em uma interface todo AlunoDao vai ser obrigado a implementar esse metodo
	
}
