package Lab11.student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Lab11.student.Studenti;
import Lab11.student.ExportStrategy;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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