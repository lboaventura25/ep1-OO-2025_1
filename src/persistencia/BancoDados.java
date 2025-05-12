package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
//import java.util.Map;

import entidades.Aluno;
import entidades.Professor;
import entidades.Turma;

public class BancoDados {
	static final String PATH_BD = "C:\\Users\\Gabriel\\eclipse-workspace\\trabalho_OO\\bin\\Persistencia\\arquivosPersistidos\\";
	// fazer lista disciplinaGera
	private static HashMap<Long, Aluno> alunosGeral = new HashMap<Long, Aluno>();// lista que tem todos os
																					// alunos:<matricula do aluno,Aluno>
	// private static HashMap<Long, Aluno> alunosPorTurma = new HashMap<Long,
	// Aluno>();// lista que tem oa alunos por
	// ->ja inicializei ela em Turma // turma:<código da turma,Aluno>
	private static HashMap<Long, Turma> turmasGeral = new HashMap<Long, Turma>();// tem como eu colocar dois tipos de da
																					// dos em uma lista? -> lista que
																					// vai ter todas as turmas: <codigo
																					// da turma, Turma>
	// private static HashMap<Long, Turma> turmaPorDisciplina = new HashMap<Long,
	// Turma>();// lista que vai ter as turmas
	// ->ja inicalizaei ela em Disciplinas // por disciplina:<codigo da
	// disciplina, Turma>
	private static HashMap<Long, Professor> professoresGeral = new HashMap<Long, Professor>();// lista que vai ter todos
																								// os professores: <id
																								// do professor,
																								// Professor>
	// como fazer uma lista que tenha os professores por Disciplinas.
	static {
		carregar("alunoDB.txt");

		// porque eu preciso desse bloco? n é so chamar o metodo de carregar(ler) e
		// salvar(escrever) na classe onde eu quero executalas?

	}
	
	public static void carregar(String nomeArquivo) {
		preparaArquivo(nomeArquivo);
		preparaArquivo(nomeArquivo);
		preparaArquivo(nomeArquivo);
		preparaArquivo(nomeArquivo);
		preparaArquivo(nomeArquivo);
		
		alunosGeral = desserializarLista()
		
		 
		
		
	}
	private static void preparaArquivo(String nomeArquivo) {
		if (!validaArquivo(PATH_BD + nomeArquivo)) {
			try {
				criaArquivo(PATH_BD + nomeArquivo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}		
	public static void persistir(HashMap<Long, Object> nomeHash, String nomeArquivoHash) {
		try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(PATH_BD + nomeArquivoHash))) {

			oss.writeObject(nomeHash);// escrevendo o arquivo
		} catch (Exception e) {
			System.out.println("Erro ao serializar o HashMap: " + e.getMessage());
		}




		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BD + nomeArquivoHash))) {

			HashMap<Long, Object> listaObjetos = (HashMap<Long, Object>) ois.readObject();// lendo o arquivo

		} catch (IOException | ClassNotFoundException e) {// se o arquivo n existir criar um arquivo, ele precisa ser
															// ja// um hashMap? acho que sim né.
			persistir(null, nomeArquivoHash);

		}

	}

	private static boolean validaArquivo(String nomeArquivo) {
		
		File f = new File(nomeArquivo);
		return f.exists(); 
	}

	private static void criaArquivo(String nomeArquivo) throws IOException {
		
		File f = new File(nomeArquivo);
		f.createNewFile();
		
		
		
	}

	public static HashMap<Long, Aluno> getAlunosGeral() {
		return alunosGeral;
	}

	public static HashMap<Long, Turma> getTurmasGeral() {
		return turmasGeral;
	}

	public static HashMap<Long, Professor> getProfessoresGeral() {
		return professoresGeral;
	}

}
