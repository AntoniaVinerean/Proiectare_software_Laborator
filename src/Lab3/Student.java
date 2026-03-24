package Lab3;
import java.util.Objects;
public class Student {
    private
    String numarMatricol;
    String nume;
    String prenume;
    String formatieDeStudiu;

    public
    Student(String numarMatricol, String nume, String prenume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.nume = nume;
        this.prenume = prenume;
        this.formatieDeStudiu = formatieDeStudiu;
    }
    @Override
    public String toString() {
        return "Student:" +" "+ "numarMatricol=" +" "+ numarMatricol + ", " +
                "nume=" +" "+ nume + ", " +
                "prenume=" +" "+ prenume + ", " +
                "formatie de studiu=" +" "+ formatieDeStudiu;
    }

    public boolean esteAcelasiStudent(Student altul){
        return this.nume.equals(altul.nume) && this.prenume.equals(altul.prenume) && this.formatieDeStudiu.equals(altul.formatieDeStudiu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(nume, student.nume) && Objects.equals(prenume, student.prenume) && Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, formatieDeStudiu);
    }

    public String getNume(){
        return nume;
    }

    public String Afisare(){
        return numarMatricol + "," + nume + "," + prenume + "," + formatieDeStudiu;
    }

}
