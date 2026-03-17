package Lab2;
import java.util.*;

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

        Student cautat1 = new Student("120", "Popa", "Maria", "TI 21/1");
        Student cautat2 = new Student("112", "Popa", "Alis", "TI 21/2");

        System.out.println("Este Popa Maria in lista? " + verificaPrezenta(listaStudenti, cautat1));
        System.out.println("Este Popa Alis in lista? " + verificaPrezenta(listaStudenti, cautat2));
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