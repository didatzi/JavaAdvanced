package Excercise.FilesAndStreams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P05_LineNumbers {
    public static void main(String[] args) {

        Path inputPath = Paths.get("D:\\Downloads\\input.txt");
        String fileNameOut = "D:\\Downloads\\output.txt";


        try (// with while use// BufferedReader reader = Files.newBufferedReader(inputPath);
             FileWriter out = new FileWriter(fileNameOut);
             PrintWriter output = new PrintWriter(out)) {

            List<String> lines = Files.readAllLines(inputPath);
            for (int i = 0; i < lines.size(); i++) {
                output.printf("%d. %s%n", i + 1, lines.get(i));
            }
            output.close();

            // with while cycle;
//            List<String> lines = Files.readAllLines(inputPath);
//            int counter = 1;
//            String line = reader.readLine();
//            while (line != null) {
//                output.printf("%d. %s%n", counter, lines.get(counter - 1));
//                counter++;
//                line = reader.readLine();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
