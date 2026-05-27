package Lab11.student;
import java.util.List;
import Lab11.student.Studenti;

public class StudentiInConsola implements ExportStrategy{
    @Override
    public void exporta(List<Studenti> lista) {
        System.out.println("Afisare in consola: ");
        lista.forEach(System.out::println);
    }

}
