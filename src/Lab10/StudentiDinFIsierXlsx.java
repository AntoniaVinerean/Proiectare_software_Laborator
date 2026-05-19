package Lab10;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFIsierXlsx implements ImportStrategy {

    @Override
    public List<Studenti> importa() {
        List<Studenti> lista = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream("studenti.xlsx");
             Workbook workbook = new XSSFWorkbook(fileIn)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                int id = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String grupa = row.getCell(3).getStringCellValue();
                double nota = row.getCell(4).getNumericCellValue();
                lista.add(new Studenti(id, prenume, nume, grupa, nota));
            }

            System.out.println("Importul din fisierul Excel s-a realizat cu succes.");

        } catch (IOException | NullPointerException | IllegalStateException e) {
            System.err.println("Eroare la citirea din fisierul Excel: " + e.getMessage());
        }
        return lista;
    }
}
