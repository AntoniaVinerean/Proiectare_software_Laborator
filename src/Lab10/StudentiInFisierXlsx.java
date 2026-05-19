package Lab10;

import java.util.List;

import Lab10.ExportStrategy;
import Lab10.Studenti;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class StudentiInFisierXlsx implements ExportStrategy {
    @Override
    public void exporta(List<Studenti> lista) {
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream("studenti.xlsx")) {

            Sheet sheet = workbook.createSheet("Studenti");
            Row headerRow = sheet.createRow(0);
            String[] coloane = {"ID", "Prenume", "Nume", "Grupa", "Nota"};
            for (int i = 0; i < coloane.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(coloane[i]);
            }

            int rowNum = 1;
            for (Studenti s : lista) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.getId());
                row.createCell(1).setCellValue(s.getPrenume());
                row.createCell(2).setCellValue(s.getNume());
                row.createCell(3).setCellValue(s.getGrupa());
                row.createCell(4).setCellValue(s.getNota());
            }

            workbook.write(fileOut);
            System.out.println("Exportul in format Excel s-a realizat cu succes.");

        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisierul Excel: " + e.getMessage());
        }
    }
}