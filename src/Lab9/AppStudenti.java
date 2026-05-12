package Lab9;
import java.util.*;
import java.util.stream.Collectors;
import Lab9.Studenti;

public class AppStudenti {
    public static void main(String[] args) {
        List <Studenti> studentiCuNote = Arrays.asList(
                new Studenti(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Studenti(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Studenti(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Studenti(1029, "Bianca", "Popescu", "TI131/1", 10),
                new Studenti(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Studenti(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Studenti(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Studenti(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Studenti(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        System.out.println("Studenti cu nota 10:");
        studentiCuNote.stream()
                .filter(s->s.getNota()==10)
                .forEach(System.out::println);
        System.out.println(" ");

        System.out.println("Studenti cu nota sub 5:");
        studentiCuNote.stream()
                .filter(s->s.getNota()<5)
                .forEach(System.out::println);
        System.out.println(" ");

        List<Studenti> listaModificata = studentiCuNote.stream()
                .map(s -> {
                    if (s.getNota() < 4) {
                        return new Studenti(s.getId(), s.getprenume(), s.getnume(), s.getgrupa(), 4.0);
                    }
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println("Lista după aplicarea notei minime de 4:");
        listaModificata.forEach(System.out::println);
        System.out.println(" ");

        double sumaNotelor = studentiCuNote.stream()
                .map(Studenti::getNota)
                .reduce(0.0, Double::sum);
        System.out.println("Suma notelor:"+sumaNotelor);

        double media = sumaNotelor/studentiCuNote.size();
        System.out.println("Media:"+media);
    }
}
