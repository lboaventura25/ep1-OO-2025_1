package persistencia.daoInterfaces;

import entidades.Disciplina;
import entidades.Professor;
import entidades.Turma;

public interface IProfessorDao extends IDao<Turma,Professor> {// professor vai assumir o valor de T 
	// TODO por que esse problema da linha de cima ?
	// algum metodo especial de Professor de modo que todo professor vai ser obrigado a 

}
