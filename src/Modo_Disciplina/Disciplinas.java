package Modo_Disciplina;

public class Disciplinas {
	private String nome;
	private int codigo;
	private int creditos;
	private String preRequisito;
	
	
	public Disciplinas(String nome, int codigo, int creditos, String preRequisito) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.creditos = creditos;
		this.preRequisito = preRequisito;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCretditos(int cargaHorario) {
		this.creditos = cargaHorario;
	}
	public String getPreRequisito() {
		return preRequisito;
	}
	public void setPreRequisito(String preRequisito) {
		this.preRequisito = preRequisito;
	}
	
	
}
