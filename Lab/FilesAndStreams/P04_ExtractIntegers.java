package Lab.FilesAndStreams;

import java.io.*;
import java.util.Scanner;

public class P04_ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "D:\\downloads\\input.txt";
        String outputPath = "D:\\downloads\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter out = new PrintWriter(new FileOutputStream(outputPath))) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt())
                    out.println(scanner.nextInt());
                scanner.next();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
