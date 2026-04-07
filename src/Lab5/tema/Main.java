package Lab5.tema;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<StudentiBursieri> bursieri = new ArrayList<>();

        bursieri.add(new StudentiBursieri("1025", "Popa", "Andrei", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentiBursieri("1024", "Mihalcea", "Ioan", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentiBursieri("1026", "Prodan", "Anamaria", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentiBursieri("1029", "Popescu", "Bianca", "TI131/1", 9.10, 780.80));

        salveazaInFisier("bursieri_out.txt", bursieri);
    }

    public static void salveazaInFisier(String numeFisier, List<? extends Student> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(numeFisier))) {
            for (Student s : lista) {
                writer.write(s.toString());
                writer.newLine();
            }
            System.out.println("Datele au fost salvate cu succes în " + numeFisier);
        } catch (IOException e) {
            System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
        }
    }
}
