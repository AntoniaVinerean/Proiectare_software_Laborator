package Lab4;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = Map.of(
                "Ioan", "Sibiu",
                "Maria", "Bucuresti",
                "Victor", "Cluj",
                "Simina", "Alba-Iulia",
                "Marius", "Medias",
                "Mihai", "Cisnadie",
                "Daniela", "Sibiu"
        );

        System.out.println("Continut initial varste: " + varste);
        System.out.println();
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        System.out.println("Continut varste dupa adaugare: " + varste);
        System.out.println();

        HashMap<String, Tanar> tineri = new HashMap<>();
        for (String nume : varste.keySet()) {
            int varsta = varste.get(nume);
            String adresa = adrese.get(nume);

            Tanar tanarNou = new Tanar(nume, varsta, adresa, 0.0f);
            tineri.put(nume, tanarNou);
        }

        System.out.println("Continutul instantei tineri:");
        for (String cheie : tineri.keySet()) {
            System.out.println("Cheie: " + " " + cheie + " " + "Valoare:" + " " + tineri.get(cheie));
        }

        HashMap<String, Student> dictionarStudenti = new HashMap<>();
        try (Scanner scannerStudenti = new Scanner(new File("studenti_in.txt"))) {
            while (scannerStudenti.hasNextLine()) {
                String linie = scannerStudenti.nextLine();
                if (linie.isEmpty()) continue;

                String[] parti = linie.split(",");
                Student s = new Student(parti[0], parti[1], parti[2], parti[3]);
                dictionarStudenti.put(parti[0], s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Eroare: Nu s-a gasit fisierul studenti_in.txt");
        }

        try (Scanner scannerNote = new Scanner(new File("note_anom.txt"))) {
            while (scannerNote.hasNextLine()) {
                String linie = scannerNote.nextLine();
                if (linie.isEmpty()) continue;

                String[] parti = linie.split(",");
                String matricol = parti[0];
                double valoareNota = Double.parseDouble(parti[1]);
                if (dictionarStudenti.containsKey(matricol)) {
                    dictionarStudenti.get(matricol).setNota(valoareNota);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Eroare: Nu s-a gasit fisierul note_anom.txt");
        }

        System.out.println();
        System.out.println("Situatie Studenti");
        for (Student s : dictionarStudenti.values()) {
            System.out.println(s);
        }
    }
}