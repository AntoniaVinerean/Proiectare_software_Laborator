package Lab3;

import java.util.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("123", "Vinerean", "Antonia", "TI 22/1");
        System.out.println(student1);

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        List<Integer> xPlusY = new ArrayList<>();
        Set<Integer> zSet = new TreeSet<>();
        List<Integer> xMinusY = new ArrayList<>();
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < 5; i++) x.add(rand.nextInt(11));
        for (int i = 0; i < 7; i++) y.add(rand.nextInt(11));

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("x: " + x);
        System.out.println("y: " + y);

        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("xPlusY: " + xPlusY);

        for (Integer e : x) if (y.contains(e)) zSet.add(e);
        System.out.println("zSet: " + zSet);

        for (Integer e : x) if (!y.contains(e)) xMinusY.add(e);
        System.out.println("xMinusY: " + xMinusY);

        Set<Integer> tempSet = new TreeSet<>();
        for (Integer v : x) if (v <= p) tempSet.add(v);
        for (Integer v : y) if (v <= p) tempSet.add(v);
        xPlusYLimitedByP.addAll(tempSet);
        System.out.println("xPlusYLimitedByP: " + xPlusYLimitedByP);

        List<Student> listaStudenti = new ArrayList<>();
        listaStudenti.add(new Student("125", "Mariciuc", "Denisa", "TI 22/2"));
        listaStudenti.add(new Student("120", "Popa", "Maria", "TI 21/1"));

        System.out.println("\nContinut lista studenti:");
        for (Student s : listaStudenti) System.out.println(s);

        System.out.println();

        Set<Student> setStudenti = new HashSet();
        System.out.println("Studenti in set:");
        for(Student s: setStudenti){
            System.out.println(s);
        }

        Student cautat1 = new Student("120", "Popa", "Maria", "TI 21/1");
        Student cautat2 = new Student("112", "Popa", "Alis", "TI 21/2");

        System.out.println("Este Popa Maria in lista? " + verificaPrezenta(listaStudenti, cautat1));
        System.out.println("Este Popa Alis in lista? " + verificaPrezenta(listaStudenti, cautat2));

        boolean gasit1 = setStudenti.add(cautat1);
        boolean gasit2 = setStudenti.add(cautat2);

        System.out.println("Popa Maria este prezenta?" + gasit1);
        System.out.println("Mariciuc Ioana este prezenta? " + gasit2);
        System.out.println();

        String fileIn = "Studenti_in.txt";
        String fileOut = "Studenti_out.txt";
        List<Student> listadinFisier=new ArrayList<>();

        try{
            List<String>linii = Files.readAllLines(Paths.get(fileIn));
            for(String linie : linii){
                String[] date = linie.split(",");
                if(date.length == 4){
                    listadinFisier.add(new Student(date[0], date[2], date[1], date[3]));
                }
            }

            System.out.println("Studenti cititi din fisier:");
            for(Student s: listadinFisier){
                System.out.println(s);
            }
            listadinFisier.sort(Comparator.comparing(Student :: getNume));

            try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileOut))){
                for(Student s: listadinFisier){
                    writer.write(s.Afisare());
                    writer.newLine();
                }
            }
            System.out.println("Sortare finalizata" +" "+ fileOut);
        }catch (IOException e){
            System.out.println("Eroare");
        }
    }

    public static boolean verificaPrezenta(List<Student> lista, Student deCautat) {
        for (Student s : lista) {
            if (s.esteAcelasiStudent(deCautat)) {
                return true;
            }
        }
        return false;
    }


}