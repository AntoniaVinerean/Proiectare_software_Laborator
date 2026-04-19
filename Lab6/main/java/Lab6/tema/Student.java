package Lab6.tema;

import java.util.Objects;

public class Student {
    private
    int numarMatricol;
    String nume;
    String prenume;
    String formatieDeStudiu;
    protected double nota;

    public
    Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.nume = nume;
        this.prenume = prenume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
    @Override
    public String toString() {
        return String.format("Matricol: %s | Nume: %-20s | Grupa: %-8s | Nota: %.2f",
                numarMatricol, (prenume + " " + nume), formatieDeStudiu, nota);
    }

    public String getNume(){
        return nume;
    }
    public String getPrenume(){return prenume;}
    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }
    public double getNota() {return nota;}

    public boolean esteAcelasiStudent(Student altul){
        return this.nume.equals(altul.nume) && this.prenume.equals(altul.prenume) && this.formatieDeStudiu.equals(altul.formatieDeStudiu);
    }

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

    public String Afisare(){
        return numarMatricol + "," + nume + "," + prenume + "," + formatieDeStudiu;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

}
