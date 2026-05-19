package Lab10;

public class Studenti {
    private int Id;
    private String Prenume;
    private String Nume;
    private String Grupa;
    private double Nota;

    public Studenti(int Id, String Prenume, String Nume, String Grupa, double Nota) {
        this.Id = Id;
        this.Prenume = Prenume;
        this.Nume = Nume;
        this.Grupa = Grupa;
        this.Nota = Nota;
    }

    public double  getNota() {
        return Nota;
    }
    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    public int getId() {
        return Id;
    }

    public String getPrenume() {
        return  Prenume;
    }

    public String getNume() {
        return Nume;
    }

    public String getGrupa() {
        return Grupa;
    }

    @Override
    public String toString() {
        return "ID: " + Id + ", Nume: " + Nume + " " + Prenume + ", Grupa: " + Grupa + ", Nota: " + Nota;
    }

}
