package Entidades;

public class Disciplina {

	
	private int codigo;
	private int horas;
	private String[] preRequisitos;
	
	
	
	public Disciplina(int codigo, int horas, String[] preRequisitos) {
		super();
		this.codigo = codigo;
		this.horas = horas;
		this.preRequisitos = preRequisitos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public String[] getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(String[] preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	
	
	
}
