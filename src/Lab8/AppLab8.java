package Lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class AppLab8 {

    public static void main(String[] args) throws IOException {
        String caleIntrare = "laborator8_input.xlsx";
        String caleIesire2 = "laborator8_output2.xlsx";
        String caleIesire3 = "laborator8_output3.xlsx";

        System.out.println("Afisare Consola");
        citesteSiAfiseaza(caleIntrare);

        copiazaSiCalculeazaMedia(caleIntrare, caleIesire2);
        genereazaCuFormula(caleIntrare, caleIesire3);

        System.out.println("\nToate fisierele au fost generate cu succes!");
    }

    public static void genereazaCuFormula(String caleIntrare, String caleIesire) throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(caleIntrare));
             XSSFWorkbook workbookIesire = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbookIesire.getSheetAt(0);

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                int ultimaColoana = 6;
                Cell cellMedia = row.createCell(ultimaColoana);

                if (i == 0) {
                    cellMedia.setCellValue("Medie (Formula)");
                } else {
                    int rowExcel = i + 1;
                    String formula = "AVERAGE(D" + rowExcel + ":F" + rowExcel + ")";
                    cellMedia.setCellFormula(formula);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(new File(caleIesire))) {
                workbookIesire.write(fos);
            }
        }
    }

    public static void citesteSiAfiseaza(String caleFisier) throws IOException {
        File f = new File(caleFisier);
        if(!f.exists()) return;
        try (FileInputStream fis = new FileInputStream(f); XSSFWorkbook wb = new XSSFWorkbook(fis)) {
            XSSFSheet s = wb.getSheetAt(0);
            for (Row r : s) {
                for (Cell c : r) {
                    System.out.printf("%-12s ", (c.getCellType() == CellType.NUMERIC) ? c.getNumericCellValue() : c.getStringCellValue());
                }
                System.out.println();
            }
        }
    }

    public static void copiazaSiCalculeazaMedia(String caleIntrare, String caleIesire) throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(caleIntrare));
             XSSFWorkbook wbIntrare = new XSSFWorkbook(fis);
             XSSFWorkbook wbIesire = new XSSFWorkbook()) {

            XSSFSheet sIn = wbIntrare.getSheetAt(0);
            XSSFSheet sOut = wbIesire.createSheet("Media Java");

            for (int i = 0; i <= sIn.getLastRowNum(); i++) {
                Row rIn = sIn.getRow(i);
                Row rOut = sOut.createRow(i);
                if (rIn == null) continue;

                for (int j = 0; j < rIn.getLastCellNum(); j++) {
                    Cell cIn = rIn.getCell(j);
                    Cell cOut = rOut.createCell(j);
                    if (cIn == null) continue;
                    if (cIn.getCellType() == CellType.NUMERIC) cOut.setCellValue(cIn.getNumericCellValue());
                    else cOut.setCellValue(cIn.getStringCellValue());
                }

                if (i == 0) rOut.createCell(rIn.getLastCellNum()).setCellValue("Media Java");
                else {
                    double m = (rIn.getCell(3).getNumericCellValue() + rIn.getCell(4).getNumericCellValue() + rIn.getCell(5).getNumericCellValue()) / 3;
                    rOut.createCell(rIn.getLastCellNum()).setCellValue(m);
                }
            }
            try (FileOutputStream fos = new FileOutputStream(new File(caleIesire))) { wbIesire.write(fos); }
        }
    }
}