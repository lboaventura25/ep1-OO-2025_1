import java.util.List;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private String codigo;
    private String cargaHoraria;
    private List<Disciplina> preRequisitos = new ArrayList<>();

    public Disciplina(String nome, String codigo, String cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    public void adicionarPreRequisito(Disciplina disciplina) {
        if (!preRequisitos.contains(disciplina)) {
            preRequisitos.add(disciplina);
        }
    }

    public String toString() {
        return "Nome: " + nome + " codigo: " + codigo + " Carga Horaria: " + cargaHoraria;
    }
}
