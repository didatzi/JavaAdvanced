package Excercise.FilesAndStreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P03_AllCapitals {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Downloads\\input.txt");
//        Path outputPath = Paths.get("D:\\Downloads\\output.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             //create an print writer for writing to a file
             PrintWriter output = new PrintWriter(new FileWriter("D:\\Downloads\\output.txt"))
        ) {
            String line = reader.readLine();
            while (line != null) {
                StringBuilder upperText = new StringBuilder();
                for (char c : line.toUpperCase().toCharArray()) {
                    upperText.append(c);
                }
                //output to the file a line
                output.println(upperText);

                line = reader.readLine();
            }
            //close the file (VERY IMPORTANT!)
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
