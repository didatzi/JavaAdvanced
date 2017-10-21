package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class P08_WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
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
            student.grades.sort(Integer::compareTo);
            students.add(student);
        }

        Predicate<ArrayList<Integer>> twoWeakGrades = integers -> {
            int count = 2;
            for (int grade : integers) {
                if (grade <= 3){
                    count--;
                }
            }
            return count <= 0;
        };
        students.stream().filter(s -> twoWeakGrades.test(s.getGrades())).sorted(Comparator.comparing(st -> st.grades.stream().mapToInt(x -> x).sum()))
                .forEach(s -> System.out.printf("%s %s %s%n",
                s.firstName, s.lastName, s.grades.toString().replaceAll("[\\[,\\]]", "")));
    }
}
