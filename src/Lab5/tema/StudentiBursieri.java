package Lab5.tema;
import java.util.Objects;

public class StudentiBursieri extends Student {
    private double cuantumBursa;

    public StudentiBursieri(String numarMatricol, String nume, String prenume, String formatieDeStudiu, double nota, double cuantumBursa) {
        super(numarMatricol, nume, prenume, formatieDeStudiu);
        this.setNota(nota);
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Bursă: %.2f", cuantumBursa);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentiBursieri that = (StudentiBursieri)  o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }
}