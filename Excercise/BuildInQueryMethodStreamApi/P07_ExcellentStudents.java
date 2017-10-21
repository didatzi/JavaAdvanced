package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class P07_ExcellentStudents {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Student> students = new LinkedHashSet<>();
        while (true){
            String inputLine = reader.readLine();
            if ("end".equalsIgnoreCase(inputLine)){
                break;
            }

            Student student = new Student();
            student.firstName = inputLine.split("\\s+")[1];
            student.lastName = inputLine.split("\\s+")[2];
            student.grades = new ArrayList<>();
            student.grades.add(Integer.parseInt(inputLine.split("\\s+")[6]));
            student.grades.add(Integer.parseInt(inputLine.split("\\s+")[7]));
            student.grades.add(Integer.parseInt(inputLine.split("\\s+")[8]));
            student.grades.add(Integer.parseInt(inputLine.split("\\s+")[9]));
            student.grades.sort(Comparator.reverseOrder());
            students.add(student);
        }

        students.stream().filter(s -> s.grades.contains(6))
                .forEach(s -> System.out.printf("%s %s %s%n",
                        s.firstName, s.lastName, s.grades.toString().replaceAll("[\\[,\\]]", "")));
    }
}
