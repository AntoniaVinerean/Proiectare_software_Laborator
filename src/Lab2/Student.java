package Lab2;
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

}
