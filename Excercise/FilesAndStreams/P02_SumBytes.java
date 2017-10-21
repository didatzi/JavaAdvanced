package Excercise.FilesAndStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02_SumBytes {
    public static void main(String[] args) {
        String inputPath = "D:\\Downloads\\input.txt";
        long sum = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))){
            String line = reader.readLine();
            while (line != null){
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
