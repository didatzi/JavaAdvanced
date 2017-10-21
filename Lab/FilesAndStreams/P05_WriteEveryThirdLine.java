package Lab.FilesAndStreams;

import java.io.*;

public class P05_WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "D:\\downloads\\input.txt";
        String outputPath = "D:\\downloads\\output.txt";

        try (BufferedReader in =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter out =
                     new PrintWriter(new FileWriter(outputPath))) {
            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0)
                    out.println(line);
                counter++;
                line = in.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
