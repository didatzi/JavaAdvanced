package Lab.FilesAndStreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06_SortLines {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\downloads\\input.txt");
        Path output = Paths.get("D:\\downloads\\output.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            Files.write(output, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
