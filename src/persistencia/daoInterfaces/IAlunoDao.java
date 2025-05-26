 


package persistencia.daoInterfaces;

import java.util.HashMap;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Turma;

public interface IAlunoDao extends IDao<Aluno,Turma> {//  ALuno vai ser o tipo de metodo que eu vou receber, faz a função de T
	public  boolean verificaDuplicidade(Aluno aluno, HashMap<Integer,Aluno> listaManipulada);
//	 pelo o fato de estar em uma interface todo AlunoDao vai ser obrigado a implementar esse metodo
// 
	public void adicionarDissciplinasFeitas(Aluno aluno,Disciplina disciplina);

	


}