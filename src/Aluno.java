public class Aluno {
    private String nome;
    private Integer matricula;
    private String curso;
    private String email;

    Aluno(String nome, Integer matricula, String curso, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getMatricula() {
        return matricula;
    }
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}