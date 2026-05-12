package Lab9;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Locale.filter;

public class AppLab9 {
    public static void main(String[] args) {
        //problema 9.3.1
        List<Integer> numere = new Random()
                .ints(10, 5, 26)
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Numerele sunt: " +numere);
        System.out.println(" ");

        int suma = numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma numerelor este: "+suma);

        int min =  numere.stream().mapToInt(Integer::intValue).min().getAsInt();
        int max =  numere.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("Numarul minim este: "+min);
        System.out.println("Numarul maxim este: "+max);

        List <Integer> intervalNou = numere.stream()
            .filter(n -> n >= 10 && n <= 20)
                    .collect(Collectors.toList());
        System.out.println("Lista filtrata in intervalul [10,20] este: "+intervalNou);

        List <Double> numereDouble = numere.stream()
                .map (n-> n.doubleValue())
                .collect (Collectors.toList());
        System.out.println("Lista transformata in Double: " + numereDouble);

        boolean gasit12 = numere.stream()
                .anyMatch(n -> n == 12);
        System.out.println("Se gaseste valoarea 12 in lista? " + (gasit12 ? "Da" : "Nu"));
        System.out.println(" ");

        //problema 9.3.2
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List <String> cuvinte = Arrays.asList(text.split(" "));
        System.out.println("Lista initiala este: " + cuvinte);

        List <String> cuvinteLungi = cuvinte.stream()
                .filter(n -> n.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("Cuvinte cu lungime >= 5: " + cuvinteLungi);
        System.out.println("Număr de cuvinte găsite >= 5: " + cuvinteLungi.size());

        List <String> cuvinteSortate = cuvinteLungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Cuvinte sortate alfabetic: " + cuvinteSortate);

        cuvinte.stream()
                .filter(c-> c.startsWith("p"))
                .findFirst()
                .ifPresent(c->System.out.println("Element care incepe cu litera p: "+c));

    }
}

