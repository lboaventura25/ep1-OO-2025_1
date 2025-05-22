package persistencia.daoEntidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Disciplina;
import entidades.Turma;
import persistencia.daoInterfaces.ITurmaDao;

public class TurmaDao implements ITurmaDao {
    // funciona pra lista turmasGeral

    @Override
    public Turma incluir(Turma entidade, HashMap<Integer, Turma> listaManipulada) {
        // adicionar em turmas geral e em turmas/disciplinas
        if (listaManipulada.containsKey(entidade.getCodigoDaDisciplina())) {
            System.out.println("A turma da dsciplina " + entidade.getDisciplina() + " e codigo "
                    + entidade.getCodigoDaDisciplina() + " JA ESTA cadastrada nessa lista");

        } else {
            if (listaManipulada != null) {
                listaManipulada.put(entidade.getCodigoDaDisciplina(), entidade);
                System.out.println("A turma da dsciplina " + entidade.getDisciplina() + " e codigo "
                        + entidade.getCodigoDaDisciplina() + " FOI cadastrada nessa lista");

            }

        }
        return null;

    }

    @Override
    public boolean excluir(Integer key, HashMap<Integer, Turma> listaManipulada) {
        // funciona em turmas geral e turmas por disciplina
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public Turma alterar(Integer chave, String campoAlterado, String alteração) {
        // alterar algum atributo de turma, menos a lista
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public Turma obter(Integer chave) { // obter uma certa turma em uma lista de turmas;
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obter'");
    }

    @Override
    public List<Turma> listarLista(HashMap<Integer, Turma> listaExibida) {// retorna a lista de turmas que eu escolher.

        for (Map.Entry<Integer, Turma> elemento : listaExibida.entrySet()) {
            System.out.println("-> O códogo da turma é: " + elemento.getValue().getCodigoDaDisciplina());
            System.out.println(
                    "-> A disciplina que esa turma faz parte é de: " + elemento.getValue().getDisciplina());
            System.out.println(
                    "-> O professor que da aula pra essa turma é o: " + elemento.getValue().getProfessor());
            System.out.println("-> O horário dessa turma é as:" + elemento.getValue().getHorario());
            System.out.println("-> O semestre dessa turma é o: " + elemento.getValue().getSemestre());
            System.out.println("-> A sala que essa turma tem aula é a:" + elemento.getValue().getSala());
            System.out.println("-> A capacidade máxima de alunos é: " + elemento.getValue().getCapMaxAluno());

        }
        return null;

    }

}
