package entidades;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;

public class Disciplina implements Serializable {
	private static final long serialVerionUID = 1L;

	private int codigo;
	private int horas;
	private String[] preRequisitos;
	private List<HashMap<Long, Turma>> turmasNaDisciplina;// como eu crio um metodo pra adicionar turmas nessa lista???
															// DAO???

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
