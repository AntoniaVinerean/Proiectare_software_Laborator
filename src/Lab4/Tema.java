package Lab4;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Tema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdu fraza:");
        String fraza = scanner.nextLine();
        String[] cuvinte = fraza.split(" ");

        Stack<String> stiva = new Stack<>();
        for (String c : cuvinte) {
            if (!c.isEmpty()) {
                stiva.push(c);
            }
        }

        System.out.print("Rezultat stiva: ");
        while (!stiva.isEmpty()) {
            System.out.print(stiva.pop() + " ");
        }
        System.out.println("\n");

        HashMap<String, Tanar> tineri = new HashMap<>();
        tineri.put("Bianca", new Tanar("Bianca Popescu", 20, "Sibiu", 9.10f));
        tineri.put("Ioan", new Tanar("Ioan Ionescu", 21, "Cluj", 7.50f));

        float notaM = gasesteNota("Bianca", "Popescu", tineri);
        float notaN = gasesteNota("Ioan", "Popa", tineri);

        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Popa: " + notaN);
        scanner.close();
    }

    public static float gasesteNota(String prenume, String nume, HashMap<String, Tanar> tineri) {
        HashMap<String, Float> hartaCautare = new HashMap<>();
        for (Tanar t : tineri.values()) {
            hartaCautare.put(t.getName(), t.getNota());
        }

        String cheieCautata = prenume + " " + nume;
        if (hartaCautare.containsKey(cheieCautata)) {
            return hartaCautare.get(cheieCautata);
        }

        return 0.0f;
    }
}