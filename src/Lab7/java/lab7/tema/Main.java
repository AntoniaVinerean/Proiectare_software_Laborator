package lab7.tema;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student(101, "Ion", "Popescu", "Grupa1", 9.5));
        studenti.add(new Student(102, "Ana", "Ionescu", "Grupa1", 8.0));
        studenti.add(new Student(103, "Dan", "Marin", "Grupa1", 7.5));
        imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");
    }

    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(st.getNumarMatricol(), st.getPrenume(), st.getNume(), nouaFormatieDeStudiu, st.getNota());
    }

    static void imparteInDouaFormatii(List<Student> studenti, String formatia1, String formatia2) {
        List<Student> listaNoua = new ArrayList<>();
        int prag = (studenti.size() + 1) / 2;

        for (int i = 0; i < studenti.size(); i++) {
            String grupaNoua = (i < prag) ? formatia1 : formatia2;
            listaNoua.add(schimbaFormatia(studenti.get(i), grupaNoua));
        }

        System.out.println("Noile formatii de studiu:");
        listaNoua.forEach(System.out::println); // [cite: 173]
    }
}