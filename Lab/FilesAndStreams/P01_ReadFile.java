package Lab.FilesAndStreams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class P01_ReadFile {
    public static void main(String[] args) {
        String path = "D:\\downloads\\input.txt";
        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            StringBuilder sb = new StringBuilder();
            while (oneByte >= 0) {
                sb.append(Integer.toBinaryString(oneByte)).append(" ");

                oneByte = in.read();
            }
            System.out.println(sb.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
