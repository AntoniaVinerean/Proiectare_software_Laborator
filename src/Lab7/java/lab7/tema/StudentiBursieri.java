package lab7.tema;

public class StudentiBursieri extends Student {
    private final double cuantumBursa; // Camp final pentru imutabilitate

    public StudentiBursieri(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double cuantumBursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu, nota);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() { return cuantumBursa; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Bursă: %.2f", cuantumBursa);
    }
}