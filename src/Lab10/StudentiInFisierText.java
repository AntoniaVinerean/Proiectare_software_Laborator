package Lab10;
import java.util.List;
import Lab10.Studenti;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentiInFisierText implements ExportStrategy {
    @Override
    public void exporta(List<Studenti>lista){
        try (PrintWriter writer = new PrintWriter(new FileWriter("studenti.txt"))) {
            for (Studenti s : lista) {
                writer.println(String.format("%d,%s,%s,%s,%.2f",
                        s.getId(), s.getPrenume(), s.getNume(), s.getGrupa(), s.getNota()));
            }
            System.out.println("Exportul in fisier s-a realizat cu succes.");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisierul text: " + e.getMessage());
        }
    }

}
