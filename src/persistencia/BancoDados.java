package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Entidade;
import entidades.Listas;
import entidades.Turma;

public class BancoDados<T extends Entidade> {// TODO fazer um caminho geral

	/*
	 * static final String PATH_BD =
	 * "D:\\faculGabriel\\2°semestre\\Orientação_Objeto\\trabalho_OO\\";
	 */

	static final String PATH_BD = "C:\\Users\\Gabriel\\eclipse-workspace\\trabalho_OO\\bin\\Persistencia\\";

	// endereço com barra invertada;

	static {

		// porque eu preciso desse bloco? n é so chamar o metodo de carregar(ler) e
		// salvar(escrever) na classe onde eu quero executalas?
		// esse blco vai carregar as carregar as coisas como primiera coisa a se fazer e
		// quero isso pras minhas listas,
		// logo.... ele vai estar aqui

		carregar("alunosGeral.txt");// valida arquivo
		carregar("turmasGeral.txt");// valida arquivo
		carregar("professoresGeral.txt");// valida arquivo
		carregar("DisciplinasGeral.txt");// valida arquivo

	}

	public void salvar(Listas listas) {
		persistir(listas);
	}

	private static void persistir(Listas listas) {// verificado
		// passo a classe ou as listas ??
		try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(PATH_BD + "listas.txt"))) {

			oss.writeObject(listas);// escrevendo o arquivo
			System.out.println("objeto serializado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro ao serializar as listas: " + e.getMessage());
		}
	}

	public static void carregar(String nomeArquivo) {// método pronto
		preparaArquivo(nomeArquivo);// porque ta chamando isso tudo de coisa ?

	}

	private static void preparaArquivo(String nomeArquivo) {// valida Arquivo
		if (!validaArquivo(PATH_BD + nomeArquivo)) {// se ele nao existir
			try {
				criaArquivo(PATH_BD + nomeArquivo);// cria
			} catch (IOException e) {// se der esso, não sei
				e.printStackTrace();
			}
		}
	}

	public void ler() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BD + "listas.txt"))) {

			HashMap<Integer, Object> listHashMap = (HashMap<Integer, Object>) ois.readObject();// lendo o arquivo

		} catch (IOException | ClassNotFoundException e) {// se o arquivo n existir criar um arquivo, ele precisa ser
															// ja// um hashMap? acho que sim né.
			persistir(null);

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
}
