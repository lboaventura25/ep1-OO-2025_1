package persistencia;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
//import java.util.Map;

import entidades.Aluno;
import entidades.Professor;
import entidades.Turma;

public class BancoDados {
	// fazer lista disciplinaGera
	private static HashMap<Long, Aluno> alunosGeral = new HashMap<Long, Aluno>();// lista que tem todos os
																					// alunos:<matricula do aluno,Aluno>
	//private static HashMap<Long, Aluno> alunosPorTurma = new HashMap<Long, Aluno>();// lista que tem oa alunos por
	//ja inicializei ela em Turma																				// turma:<código da turma,Aluno>
	private static HashMap<Long, Turma> turmasGeral = new HashMap<Long, Turma>();// tem como eu colocar dois tipos de da
																					// dos em uma lista. -> lista que
																					// vai ter todas as turmas: <codigo
																				// da turma, Turma>
	//private static HashMap<Long, Turma> turmaPorDisciplina = new HashMap<Long, Turma>();// lista que vai ter as turmas
	// ja inicalizaei ela em Disciplinas																					// por disciplina:<codigo da
 																						// disciplina, Turma>
	private static HashMap<Long, Professor> professoresGeral = new HashMap<Long, Professor>();// lista que vai ter todos
																								// os professores: <id
																								// do professor,
																								// Professor>
	// como fazer uma lista que tenha os professores por Disciplinas.
	static {// porque eu preciso desse bloco? n é so chamar o metodo de carregar(ler) e
			// salvar(escrever) na classe onde eu quero executalas?

	}

	public static void persistir(HashMap<Long, Object> nomeHash, String nomeArquivoHash) {
		try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(
				"C:/users/Gabriel/eclipse-workspace/trabalho_OO/bin?Persistencia/arquivosPersistidos/"
						+ nomeArquivoHash))) {

			oss.writeObject(nomeHash);// escrevendo o arquivo
		} catch (IOException e) {
			System.out.println("Erro ao serializar o HashMap: " + e.getMessage());
		}
	}

	public static void carregar(String nomeArquivo) {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"C:/users/Gabriel/eclipse-workspace/trabalho_OO/bin?Persistencia/arquivosPersistidos/"
						+ nomeArquivo))) {

			HashMap<Long, Object> listaObjetos = (HashMap<Long, Object>) ois.readObject();// lendo o arquivo

			// for (Map.Entry<Long, Object> entry : listaObjetos.entrySet()) {// iterndo o
			// hashmap usando map.entry que
			// itera um por chave e valor de vez em vez
			// Long id = entry.getKey();
			// Object objeto = entry.getClass();// vai pegar a classe de cada um dos meus
			// objetos ?

			// System.out.println("Chave: " + id + ", Valor: " + objeto); // Imprime a chave
			// e o valor
			// }

		} catch (IOException | ClassNotFoundException e) {// se o arquivo n existir criar um arquivo, ele precisa ser
															// ja// um hashMap? acho que sim né.
			persistir(null, nomeArquivo);

		}

	}

	public static HashMap<Long, Aluno> getAlunosGeral() {
		return alunosGeral;
	}

	public static HashMap<Long, Aluno> getAlunosPorTurma() {
		return alunosPorTurma;
	}

	public static HashMap<Long, Turma> getTurmasGeral() {
		return turmasGeral;
	}

	public static HashMap<Long, Turma> getTurmaPorDisciplina() {
		return turmaPorDisciplina;
	}

	public static HashMap<Long, Professor> getProfessoresGeral() {
		return professoresGeral;
	}

}
