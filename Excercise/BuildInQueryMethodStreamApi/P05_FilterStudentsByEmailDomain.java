package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class P05_FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<String> students = new LinkedHashSet<>();

        while (true) {
            String input = reader.readLine();
            if ("end".equalsIgnoreCase(input)) {
                break;
            }
            students.add(input);
        }

        students.stream()
                .filter(s -> s.split("\\s+")[3].endsWith("@gmail.com"))
                .forEach(student -> System.out.println(student.split("\\s+")[1] + " "
                        + student.split("\\s+")[2] + " "
                        + student.split("\\s+")[3]));
    }
}
