package Lab11.student;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

import Lab11.*;
import Lab11.student.Studenti;

public class Main {
    public static void main(String[] args) {
        List<Lab11.student.Studenti> studentiCuNote = Arrays.asList(
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
                        return new Studenti(s.getId(), s.getPrenume(), s.getNume(), s.getGrupa(), 4.0);
                    }
                    return s;
                })
                .collect(Collectors.toList());
        System.out.println("Lista dupa aplicarea note minime de 4:");
        listaModificata.forEach(System.out::println);
        System.out.println(" ");

        double sumaNotelor = studentiCuNote.stream()
                .map(Studenti::getNota)
                .reduce(0.0, Double::sum);
        System.out.println("Suma notelor:"+sumaNotelor);

        double media = sumaNotelor/studentiCuNote.size();
        System.out.println("Media:"+media);
        System.out.println(" ");

        ExportStrategy context;
        System.out.println("Rulare Export Strategy cu decorator");

        context = new Decorator (new StudentiInConsola());
        context.exporta(studentiCuNote);
        System.out.println(" ");

        context = new Decorator(new StudentiInFisierText());
        context.exporta(studentiCuNote);
        System.out.println(" ");

        context = new Decorator(new StudentiInFisierXlsx());
        context.exporta(studentiCuNote);
        System.out.println(" ");

        System.out.println("Rulare Import Strategy");
        ImportStrategy importContext;

        System.out.println("Citire prin clasa StudentiDinFisierText:");
        importContext = new StudentiDinFisierText();
        List<Studenti> listaDinText = importContext.importa();
        listaDinText.forEach(System.out::println);
        System.out.println(" ");

        System.out.println("Citire prin clasa StudentiDinFisierXlsx:");
        importContext = new StudentiDinFIsierXlsx();
        List<Studenti> listaDinExcel = importContext.importa();
        listaDinExcel.forEach(System.out::println);


    }
}
