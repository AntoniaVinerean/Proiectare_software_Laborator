package Lab9;

public class Studenti {
    private int id;
    private String prenume;
    private String nume;
    private String grupa;
    private double nota;

    public Studenti(int id, String prenume, String nume, String grupa, double nota) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.grupa = grupa;
        this.nota = nota;
    }

    public double  getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public String getprenume() {
        return  prenume;
    }

    public String getnume() {
        return nume;
    }

    public String getgrupa() {
        return grupa;
    }

    @Override
    public String toString() {
        return String.format("%s %s (Nota: %.2f)", prenume, nume, nota);
    }
}
