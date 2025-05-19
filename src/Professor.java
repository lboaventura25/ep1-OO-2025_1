public class Professor extends Pessoa {
    private String area;

    public Professor(String nome, String matricula, String area) {
        super(nome, matricula);
        this.area = area;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() + "\nArea: " + area + "\n[Professor]";
    }
}
