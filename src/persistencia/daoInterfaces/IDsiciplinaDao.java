package persistencia.daoInterfaces;

import java.util.HashMap;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Turma;

public interface IDsiciplinaDao extends IDao<Turma,Disciplina>{

    public void adicionarPreRequisito(Disciplina disciplina,Disciplina disciplinaAdicionada);

    public Disciplina incluirDisciplina(Disciplina disciplina);
}