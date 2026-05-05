package Lab8.tema;

import java.util.Objects;

public class Student {

    private int numarMatricol;
    private String nume;
    private String prenume;
    private String formatieDeStudiu;
    private double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota) {
        this.numarMatricol = numarMatricol;
        this.nume = nume;
        this.prenume = prenume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("Matricol: %s | Nume: %-20s | Grupa: %-8s | Nota: %.2f",
                numarMatricol, (prenume + " " + nume), formatieDeStudiu, nota);
    }

    public int getNumarMatricol() {return numarMatricol;}
    public String getNume(){
        return nume;
    }
    public String getPrenume(){return prenume;}
    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }
    public double getNota() {return nota;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(numarMatricol, student.numarMatricol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }

}
