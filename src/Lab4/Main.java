package Lab4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        Map<String, String> adrese = Map.of("Ioan", "Sibiu",
                "Maria", "Bucuresti",
                "Victor", "Cluj",
                "Simina", "Alba-Iulia",
                "Marius", "Medias",
                "Mihai", "Cisnadie",
                "Daniela", "Sibiu"
        );

        System.out.println("Continut initial varste: "+ varste);
        System.out.println();
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);
        System.out.println("Continut varste dupa adaugare: " + varste);
        System.out.println();

        HashMap<String, Tanar> tineri = new HashMap<>();
        for (String nume: varste.keySet()){
            int varsta = varste.get(nume);
            String adresa = adrese.get(nume);

            Tanar tanarNou = new Tanar(nume, varsta, adresa);
            tineri.put(nume, tanarNou);
        }

        System.out.println("Continutul instantei tineri:");
        for(String cheie: tineri.keySet()){
            System.out.println("Cheie: "+ " "+cheie+ " "+ "Valoare:"+ " "+ tineri.get(cheie));
        }

    }
}
