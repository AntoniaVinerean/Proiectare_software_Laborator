package Lab11.student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierText implements ImportStrategy {
    @Override
    public List<Studenti> importa() {
        List<Studenti> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("studenti.txt"))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] detalii = linie.split(",");
                int id = Integer.parseInt(detalii[0]);
                String prenume = detalii[1];
                String nume = detalii[2];
                String grupa = detalii[3];
                double nota = Double.parseDouble(detalii[4]);
                lista.add(new Studenti(id, prenume, nume, grupa, nota));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Eroare la citirea din fisier text: " + e.getMessage());
        }
        return lista;
    }
}
