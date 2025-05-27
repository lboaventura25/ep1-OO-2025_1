package persistencia.daoEntidades;

import java.util.HashMap;
import java.util.List;

import entidades.Disciplina;
import entidades.Turma;
import persistencia.daoInterfaces.IDsiciplinaDao;

public class DisciplinaDao implements IDsiciplinaDao {

    @Override
    public Turma incluir(Turma entidade, HashMap<Integer, Turma> listaManipulada, Disciplina turmaOuDisciplina) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incluir'");
    }

    @Override
    public boolean excluir(Integer key, HashMap<Integer, Turma> listaManipulada) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public Turma alterar(Integer chave, String campoAlterado, String alteração) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public Turma obter(Integer chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obter'");
    }

    @Override
    public List<Turma> listarLista(HashMap<Integer, Turma> listaExibida) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarLista'");
    }

    @Override
    public void adicionarPreRequisito(Disciplina disciplina, Disciplina disciplinaAdicionada) {
        if (disciplina != null & disciplinaAdicionada != null) {
            disciplina.getPreRequisitos().put(disciplinaAdicionada.getCodigo(), disciplinaAdicionada);
            System.out.println("PreRequisito: "+disciplinaAdicionada+"adicionado com sucesso pra disciplina: "+disciplina);

        }else {
            System.out.println("erro ao adicionar pré-requisito");
        }
       
    }

}
