package Lab3;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String inputFile= "in.txt";
        String outputFile= "out.txt";
        StringBuilder finalresult = new StringBuilder();
        try {
            printLargerTextFile("in.txt");
            List<String> lines = Files.readAllLines(Paths.get("in.txt"));

            StringBuilder builder = new StringBuilder();

            String ex1 = result1(lines);
            System.out.print(ex1);
            finalresult.append("Rezultat A: ").append(ex1).append("\n");


            String ex2 = result2(lines);
            System.out.print(ex2);
            finalresult.append("Rezultat B: ").append(ex2).append("\n");

            saveToFile(outputFile, finalresult.toString() );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printLargerTextFile(String fileName) throws IOException {
        System.out.println("Using Scanner:");
        Path path = Paths.get(fileName);
        try (Scanner scanner = new Scanner(path)){
            while (scanner.hasNextLine()){
                System.out.println(": " + scanner.nextLine());
            }
        }
    }

    static String result1(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line).append("\n\n");
        }
        return sb.toString();
    }

    static String result2(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            String[] parts = line.split("\\.");

            for (int i = 0; i < parts.length; i++) {
                String fragment = parts[i].trim();
                if (!fragment.isEmpty()) {
                    sb.append(fragment).append(".\n");
                }
            }
        }
        return sb.toString();
    }

    static void saveToFile(String outputFile, String content) throws IOException {
        Path path = Paths.get(outputFile);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(content);
        }
    }
}