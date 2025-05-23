package persistencia.daoEntidades;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Disciplina;
import entidades.Listas;
import entidades.Turma;
import persistencia.daoInterfaces.ITurmaDao;

public class TurmaDao implements ITurmaDao {
    // funciona pra lista turmasGeral

    @Override // VERIFICADA;
    public Turma incluir(Turma entidade, HashMap<Integer, Turma> listaManipulada) {
        // adicionar em turmas geral e em turmas/disciplinas
        if (listaManipulada.containsKey(entidade.getCodigoDaDisciplina())) {
            System.out.println("-> A turma da dsciplina " + entidade.getDisciplina() + " e codigo "
                    + entidade.getCodigoDaDisciplina() + " JA ESTA cadastrada nessa lista");

        } else {
            if (listaManipulada != null) {
                listaManipulada.put(entidade.getCodigoDaDisciplina(), entidade);
                System.out.println("-> A turma da dsciplina " + entidade.getDisciplina() + " e codigo "
                        + entidade.getCodigoDaDisciplina() + " FOI cadastrada nessa lista");

            }

        }
        return null;

    }

    @Override // VERIFICADA
    public boolean excluir(Integer key, HashMap<Integer, Turma> listaManipulada) {
        System.out.println("->excluindo-------------");
        // funciona em turmas geral e turmas por disciplina
        if (listaManipulada != null) {
            if (listaManipulada.containsKey(key)) {
                listaManipulada.remove(key);
                System.out.println("-> Turma de chave: " + key + " removido");
                return true;

            } else {
                System.out.println("-> não existe essa turma nessa lista");
                return false;
            }

        } else {
            System.out.println("-> essa lista nao existe");
            return false;
        }

    }

    @Override
    public Turma alterar(Integer chave, String campoAlterado, String alteração) {
        Turma elemento = obter(chave);
        // alterar algum atributo de turma, menos a lista
        if (Listas.getTurmasGeral() != null) {
            if (campoAlterado == "Código da disciplina ") {// TODO matricula depois eu faço
                Integer novoCodigo = Integer.parseInt(alteração);
                String velhaDisciplina = elemento.getDisciplina();
                String velhoProfessor = elemento.getProfessor();
                String velhoSemestre = elemento.getSemestre();
                boolean presecialidade = elemento.isPresencial();
                String velhaSala = elemento.getSala();
                String velhoHorario = elemento.getHorario();
                int velhacapacidadeMax = elemento.getCapMaxAluno();

                

            }
            if (campoAlterado == "Disciplina") {
                String novaDisciplina = alteração;
                elemento.setDisciplina(novaDisciplina);
            }
            if (campoAlterado == "Professor") {
                String novoProfessor = alteração;
                elemento.setProfessor(novoProfessor);
            }
            if (campoAlterado == "Semestre") {
                String novoSemestre = alteração;
                elemento.setSemestre(novoSemestre);
            }
            if (campoAlterado == "Presencialidade") {// TODO verificar esse meodo boolean


            }
            if (campoAlterado == "Sala") {
                String novaSala = alteração;
                elemento.setSala(novaSala);
            }
            if (campoAlterado == "Horário") {
                String novoHoraio = alteração;
                elemento.setHorario(novoHoraio);
            }
            if (campoAlterado == "Capacidade de alunos") {
                int novaCapacidade = Integer.parseInt(alteração);
                elemento.setCapMaxAluno(novaCapacidade);
            } else { // verificado
                System.out.println("-> Nao existe esse campo para ser alterado.");
                System.out.println(
                        "-> Os campos alteráveis são exatamente esses:'Código da disciplina','Disciplina','Professor','Semestre','Presencialidade','Sala','Horário','Capacidade de alunos'.Tente algum destes ");
            }

        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override // VERIFICADA
    public Turma obter(Integer chave) { // obter uma certa turma em uma em turmasGerais;
        if (Listas.getTurmasGeral() != null) {
            if (Listas.getTurmasGeral().containsKey(chave)) {
                return Listas.getTurmasGeral().get(chave);
            } else {
                System.out.println("-> Essa turma não se encontra nessa lista");
                return null;
            }

        } else {
            System.out.println("a lista 'trmasGeral' não foi cadastrada");
            return null;
        }

    }

    @Override // VERIFICADA
    public List<Turma> listarLista(HashMap<Integer, Turma> listaExibida) {// retorna a lista de turmas que eu escolher.

        for (Map.Entry<Integer, Turma> elemento : listaExibida.entrySet()) {
            System.out.println("-> listando próximo abaixo ----------------");
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
