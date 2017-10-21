package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class P06_FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Student> students = new LinkedHashSet<>();

        while (true) {
            String inputLine = reader.readLine();
            if ("end".equalsIgnoreCase(inputLine)) {
                break;
            }
           //initialize new student ant fill it
            Student student = new Student();
            student.firstName = inputLine.split("\\s+")[1];
            student.lastName = inputLine.split("\\s+")[2];
            student.phone = inputLine.split("\\s+")[10];
            //adding student to list or hashSet
            students.add(student);
        }
        students.stream()
                .filter(s -> s.phone.startsWith("02") || s.phone.startsWith("+3592"))
                .forEach(s -> System.out.printf("%s %s %s%n", s.firstName, s.lastName, s.phone));
    }
}
