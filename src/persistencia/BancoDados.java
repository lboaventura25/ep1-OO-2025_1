package persistencia;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import entidades.Aluno;
import entidades.Disciplina;
import entidades.Listas;
import entidades.Professor;
import entidades.Turma;

public class BancoDados {// TODO fazer um caminho geral

	/*
	 * static final String PATH_BD =
	 * "D:\\faculGabriel\\2°semestre\\Orientação_Objeto\\trabalho_OO\\";
	 */
	static final Listas listas = new Listas();

	/* static final String PATH_BD = "C:\\Temp\\trabalho_OO\\bin\\"; */
	static final String PATH_BD = "C:\\Users\\Gabriel\\eclipse-workspace\\trabalho_OO\\bin\\Persistencia\\";

	// endereço com barra invertada;

    
	
	
	
	public void salvar() {
		persistir("Aluno");
		persistir("Professor");
		persistir("Disciplina");
		persistir("Turma");
	}

	public BancoDados() {
		this.carregar();
	}

	private static void persistir(String nomeEntidade) {// verificado
		// passo a classe ou as listas ??
		try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(PATH_BD + nomeEntidade + ".txt"))) {

			
			switch (nomeEntidade) {
			case "Aluno": {
				oss.writeObject(listas.getAlunosGeral());
				break;
			}
			case "Professor": {
				oss.writeObject(listas.getProfessoresGeral());
				break;
			}
			case "Turma": {
				oss.writeObject(listas.getTurmasGeral());
				break;
			}
			
			default:
			
				oss.writeObject(listas.getDisciplinaGeral());
				break;
			}
			
			
			oss.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Erro ao serializar as listas: " + e.getMessage());
		}
	}

	private Listas carregar() {// método pronto
	
		preparaArquivo("Aluno");// porque ta chamando isso tudo de coisa ?
		preparaArquivo("Professor");
		preparaArquivo("Disciplina");
		preparaArquivo("Turma");
		
		Listas listas = new Listas();
		
		 listas.setAlunosGeral(lerAunos());
		 listas.setDisciplinaGeral(leDisciplina());
		 listas.setProfessoresGeral(leProfessor());
		 listas.setTurmasGeral(lerTurma());
		 
		 return listas;
		
	}

	private static void preparaArquivo(String nomeEntidade) {// valida Arquivo
		if (!validaArquivo(nomeEntidade )) {// se ele nao existir
			try {
				criaArquivo(nomeEntidade );// cria
			} catch (IOException e) {// se der esso, não sei
				e.printStackTrace();
			}
		}
	}

	private static HashMap<Integer, Aluno> lerAunos() {
		

		HashMap<Integer, Aluno> alunosGeral  = new HashMap<Integer,Aluno>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BD + "Aluno.txt"))) {

			alunosGeral = (HashMap<Integer, Aluno>) ois.readObject();// lendo o arquivo

		} catch (IOException | ClassNotFoundException e) {// se o arquivo n existir criar um arquivo, ele precisa ser
															// ja// um hashMap? acho que sim né.
			/* carregar(); */
			System.out.println(e.getMessage());
		}
		return alunosGeral;
	
	}
	
	
    private static HashMap<Integer, Professor> leProfessor() {
		
		/*
		 * public static HashMap<Integer, Aluno> alunosGeral = new HashMap<Integer, Aluno>();
    public static HashMap<Integer, Turma> turmasGeral = new HashMap<Integer, Turma>();
    public static HashMap<String, Disciplina> disciplinaGeral = new HashMap<String, Disciplina>();
    public static HashMap<Integer, Professor> professoresGeral = new HashMap<Integer, Professor>();
		 * 
		 * */
		HashMap<Integer, Professor> professorGeral  = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BD + "Professor.txt"))) {

			professorGeral = (HashMap<Integer, Professor>) ois.readObject();// lendo o arquivo

		} catch (IOException | ClassNotFoundException e) {// se o arquivo n existir criar um arquivo, ele precisa ser
															// ja// um hashMap? acho que sim né.
			/* carregar(); */
			System.out.println(e.getMessage());
		}
		return professorGeral;
	}
    
    
    private static HashMap<String, Disciplina> leDisciplina() {
		
		/*
		 * public static HashMap<Integer, Aluno> alunosGeral = new HashMap<Integer, Aluno>();
    public static HashMap<Integer, Turma> turmasGeral = new HashMap<Integer, Turma>();
    public static HashMap<String, Disciplina> disciplinaGeral = new HashMap<String, Disciplina>();
    public static HashMap<Integer, Professor> professoresGeral = new HashMap<Integer, Professor>();
		 * 
		 * */
		HashMap<String, Disciplina> proDisciplinaGeral  = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BD + "Disciplina.txt"))) {

			proDisciplinaGeral = (HashMap<String, Disciplina>) ois.readObject();// lendo o arquivo

		} catch (IOException | ClassNotFoundException e) {// se o arquivo n existir criar um arquivo, ele precisa ser
															// ja// um hashMap? acho que sim né.
			/* carregar(); */
			System.out.println(e.getMessage());
		}
		return proDisciplinaGeral;
	} 
    
    private static HashMap<Integer, Turma> lerTurma() {
		
 		/*
 		 * public static HashMap<Integer, Aluno> alunosGeral = new HashMap<Integer, Aluno>();
     public static HashMap<Integer, Turma> turmasGeral = new HashMap<Integer, Turma>();
     public static HashMap<String, Disciplina> disciplinaGeral = new HashMap<String, Disciplina>();
     public static HashMap<Integer, Professor> professoresGeral = new HashMap<Integer, Professor>();
 		 * 
 		 * */
 		HashMap<Integer, Turma> proTurmaGeral  = null;
 		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH_BD + "Turma.txt"))) {

 			proTurmaGeral = (HashMap<Integer, Turma>) ois.readObject();// lendo o arquivo

 		} catch (IOException | ClassNotFoundException e) {// se o arquivo n existir criar um arquivo, ele precisa ser
 															// ja// um hashMap? acho que sim né.
 			/* carregar(); */
 			System.out.println(e.getMessage());
 		}
 		return proTurmaGeral;
 	} 
    
    
    
    
    
    


	private static boolean validaArquivo(String nomeEntidade) {

		File f = new File(PATH_BD + nomeEntidade + ".txt");
		return f.exists();
	}

	private static void criaArquivo(String nomeEntidade) throws IOException {

		File f = new File(PATH_BD + nomeEntidade + ".txt");
		f.createNewFile();
		//persistir();

	}

	public static Listas getListas() {
		return listas;
	}

	public static String getPathBd() {
		return PATH_BD;
	}
}
