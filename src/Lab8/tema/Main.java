package Lab8.tema;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args){

        String CaleFisier = "laborator8_studenti.xlsx";

        List<Student> listainitiala = new ArrayList<>();
        listainitiala.add(new Student(101, "Ion", "Popescu", "Grupa1", 9.5));
        listainitiala.add(new Student(102, "Ana", "Ionescu", "Grupa1", 8.0));
        listainitiala.add(new Student(103, "Dan", "Marin", "Grupa1", 7.5));

        try {
            exportaStudenti(listainitiala, CaleFisier);
            System.out.println("Exportul a fost realizat cu succes!");
            List<Student> listaImportata = importaStudenti(CaleFisier);

            System.out.println("\nLista de studenti importata din Excel:");
            for (Student s : listaImportata) {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.err.println("Eroare la manipularea fisierului: " + e.getMessage());
        }
    }

    public static void exportaStudenti(List<Student> studenti, String CaleFisier) throws IOException {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Studenti");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nr. Matricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("Grupa");
        header.createCell(4).setCellValue("Nota");

        int rowIndex=1;
        for (Student s : studenti) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(s.getNumarMatricol());
            row.createCell(1).setCellValue(s.getPrenume());
            row.createCell(2).setCellValue(s.getNume());
            row.createCell(3).setCellValue(s.getFormatieDeStudiu());
            row.createCell(4).setCellValue(s.getNota());
        }
        try (FileOutputStream fileOut = new FileOutputStream(CaleFisier)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }

    public static List<Student> importaStudenti(String CaleFisier) throws IOException {
        List<Student> studentiCititi = new ArrayList<>();

        try(FileInputStream fileIn = new FileInputStream(new File(CaleFisier));
            Workbook workbook = new HSSFWorkbook(fileIn)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                int matricol = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String grupa = row.getCell(3).getStringCellValue();
                double nota = row.getCell(4).getNumericCellValue();

                studentiCititi.add(new Student(matricol, prenume, nume, grupa, nota));
            }
        }
        return studentiCititi;
    }
}
