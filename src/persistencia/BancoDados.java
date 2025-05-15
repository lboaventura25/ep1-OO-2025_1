package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;// nao usando;
import java.nio.file.Path;// nao usando;
import java.util.HashMap;
//import java.util.Map;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Professor;
import entidades.Turma;

public class BancoDados {
	static final String PATH_BD = "C:\\Users\\Gabriel\\eclipse-workspace\\trabalho_OO\\bin\\Persistencia\\arquivosPersistidos\\";
	// endereço com barra invertada;

	private static HashMap<Integer, Disciplina> disciplinaGeral = new HashMap<Integer, Disciplina>();

	private static HashMap<Integer, Aluno> alunosGeral = new HashMap<Integer, Aluno>();
	// lista que tem todos osalunos:<matricula do aluno,Aluno>	

	// private static HashMap<Integer, Aluno> alunosPorTurma = new HashMap<Integer,
	// Aluno>();// lista que tem oa alunos porturma:<código da turma,Aluno>
	// ->ja inicializei ela em Turma
	
	private static HashMap<Integer, Turma> turmasGeral = new HashMap<Integer, Turma>();
	// TODO tem como eu colocar dois tipos de dados em uma lista? -> lista que vai ter
	// todas as turmas: <codigoda turma, Turma> //

	// private static HashMap<Integer, Turma> turmaPorDisciplina = new HashMap<Integer,
	// Turma>();// lista que vai ter as turmas
	// ->ja inicalizaei ela em Disciplinas // por disciplina:<codigo dadisciplina, Turma>
	
	private static HashMap<Integer, Professor> professoresGeral = new HashMap<Integer, Professor>();
	// lista que vai ter todos os professores: <id do professor, Professor>
	
	// TODO como fazer uma lista que tenha os professores por Disciplinas???
	static {
		// chamo o preparar arquivo dentro do bloco estatico? acho que sim né.
		carregar("professores.txt");
		carregar("alunoDB.txt");
		carregar("turmasDB.txt");
		carregar("disciplinaDB.txt");

		// porque eu preciso desse bloco? n é so chamar o metodo de carregar(ler) e
		// salvar(escrever) na classe onde eu quero executalas?
		// esse blco vai carregar as carregar as coisas como primiera coisa a se fazer e quero isso pras minhas listas,
		//logo.... ele vai estar aqui

	}

	public static void carregar(String nomeArquivo) {// método pronto
		preparaArquivo(nomeArquivo);// porque ta chamando isso tudo de coisa ?
		/*
		 * preparaArquivo(nomeArquivo); preparaArquivo(nomeArquivo);
		 * preparaArquivo(nomeArquivo); preparaArquivo(nomeArquivo);
		 */
		
		//alunosGeral = desserializarLista(), nao entedi, alunos geral nao precisaria ser um argumento de um método?
		 
		
		
	}

	private static void preparaArquivo(String nomeArquivo) {// vaidaArquivo
		if (!validaArquivo(PATH_BD + nomeArquivo)) {// se ele nao existir
			try {
				criaArquivo(PATH_BD + nomeArquivo);// cria
			} catch (IOException e) {// se der esso, não sei 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void persistir(HashMap<Integer, Object> nomeHash, String nomeArquivoHash) {
		try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(PATH_BD + nomeArquivoHash))) {

			oss.writeObject(nomeHash);// escrevendo o arquivo
		} catch (Exception e) {
			System.out.println("Erro ao serializar o HashMap: " + e.getMessage());
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BD + nomeArquivoHash))) {

			HashMap<Integer, Object> listaObjetos = (HashMap<Integer, Object>) ois.readObject();// lendo o arquivo

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

	public static HashMap<Integer,Aluno> getAlunosGeral() {
		return alunosGeral;
	}

	public static HashMap<Integer, Turma> getTurmasGeral() {
		return turmasGeral;
	}

	public static HashMap<Integer, Professor> getProfessoresGeral() {
		return professoresGeral;
	}

}
