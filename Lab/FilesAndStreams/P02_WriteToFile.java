package Lab.FilesAndStreams;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02_WriteToFile {
    public static void main(String[] args) {
        String inputPath = "D:\\downloads\\input.txt";
        String outputPath = "D:\\downloads\\output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');
        try (InputStream in = new FileInputStream(inputPath);
             OutputStream out = new FileOutputStream(outputPath)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    out.write(oneByte);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
