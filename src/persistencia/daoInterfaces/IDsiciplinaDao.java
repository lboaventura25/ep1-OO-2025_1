package persistencia.daoInterfaces;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Turma;

public interface IDsiciplinaDao extends IDao<Turma,Disciplina>{

    public void adicionarPreRequisito(Disciplina disciplina,Disciplina disciplinaAdicionada);

}