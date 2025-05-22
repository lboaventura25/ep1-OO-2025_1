package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import entidades.Entidade;
import entidades.Listas;

public class BancoDados<T extends Entidade> {
	static final String PATH_BD = "C:\\Users\\Gabriel\\eclipse-workspace\\trabalho_OO\\bin\\Persistencia\\";
	// endereço com barra invertada;
	// lista que vai ter todos os professores: <id do professor, Professor>

	// TODO como fazer uma lista que tenha os professores por Disciplinas???
	static {
		// chamo o preparar arquivo dentro do bloco estatico? acho que sim né.
	/* 	carregar("professores.txt");
		carregar("alunoDB.txt");
		carregar("turmasDB.txt");
		carregar("disciplinaDB.txt"); */

		// porque eu preciso desse bloco? n é so chamar o metodo de carregar(ler) e
		// salvar(escrever) na classe onde eu quero executalas?
		// esse blco vai carregar as carregar as coisas como primiera coisa a se fazer e
		// quero isso pras minhas listas,
		// logo.... ele vai estar aqui


		carregar("listas.txt");

	}

	public static void salvar(Listas listas){
		persistir(listas);
	} 

	private static void persistir( Listas listas) {//TODO verificar ese metodo 
		try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(PATH_BD + "listas.txt"))) {

			oss.writeObject(listas);// escrevendo o arquivo
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



	public static void ler (HashMap<Integer, Object> listaObjetos, String nomeArquivoHash){
		//TODO conferir esse metodo
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BD + nomeArquivoHash))) {

			HashMap<Integer, Object> listHashMap = (HashMap<Integer, Object>) ois.readObject();// lendo o arquivo

		} catch (IOException | ClassNotFoundException e) {// se o arquivo n existir criar um arquivo, ele precisa ser
															// ja// um hashMap? acho que sim né.
			persistir(null);}

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
