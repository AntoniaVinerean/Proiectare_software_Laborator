package Lab7.java.lab7.tema;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AplicatieCuBursa {

    public static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentiBursieri> lista = instanta.genereaza();

        System.out.println("Lista initiala:");
        for (StudentiBursieri student : lista) {
            System.out.println(student);
        }

        System.out.println();
        System.out.println("Lista sortata:");
        List<StudentiBursieri> sortata = instanta.sorteaza(lista);
        for (StudentiBursieri student : sortata) {
            System.out.println(student);
        }
    }

    public List<StudentiBursieri> genereaza() {
        List<StudentiBursieri> lista = new ArrayList<>();
        lista.add(new StudentiBursieri(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        lista.add(new StudentiBursieri(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        lista.add(new StudentiBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));
        lista.add(new StudentiBursieri(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        lista.add(new StudentiBursieri(1029, "Bianca", "Popescu", "TI131/1", 9.10, 100.00));
        return lista;
    }

    public List<StudentiBursieri> sorteaza(List<StudentiBursieri> lst) {
        lst.sort(Comparator
                .comparing(StudentiBursieri::getFormatieDeStudiu)
                .thenComparing(StudentiBursieri::getNume)
                .thenComparing(StudentiBursieri::getPrenume)
                .thenComparing(StudentiBursieri::getNota)
                .thenComparing(StudentiBursieri::getCuantumBursa));
        return lst;
    }
}