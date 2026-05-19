package Lab10;
import java.util.List;
import Lab10.Studenti;

public class StudentiInConsola implements ExportStrategy{
    @Override
    public void exporta(List<Studenti> lista) {
        System.out.println("Afisare in consola: ");
        lista.forEach(System.out::println);
    }

}
