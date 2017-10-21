package Excercise.FilesAndStreams;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P04_CountCharacterTypes {
    public static void main(String[] args) {
        Path inputPath = Paths.get("D:\\Downloads\\input.txt");

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             //create an print writer for writing to a file
             PrintWriter output = new PrintWriter(new FileWriter("D:\\Downloads\\output.txt"))
        ) {
            String line = reader.readLine();
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            while (line != null) {

                for (char c : line.toLowerCase().toCharArray()) {
                    switch (c) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u':
                            vowelsCount++;
                            break;
                        case '!':
                        case '.':
                        case '?':
                        case ',':
                            punctuationCount++;
                            break;
                        case ' ':
                            break;
                        default:
                            consonantsCount++;
                            break;
                    }
                }

                line = reader.readLine();
            }

            //output to the file a line
            output.printf("Vowels: %d\nConsonants: %d\nPunctuation: %d\n", vowelsCount, consonantsCount, punctuationCount);

            //close the file (VERY IMPORTANT!)
            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
