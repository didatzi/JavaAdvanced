package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class P04_SortStudents {
    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> students = new HashSet<>();

        while (true){
            String input = scan.readLine();
            if("END".equals(input)){
                break;
            }
            students.add(input);
        }
        students.stream().sorted((a,b) -> {
            if (a.split("\\s+")[1].compareTo(b.split("\\s+")[1]) == 0){
                return b.split(" ")[0].compareTo(a.split("\\s+")[0]);
            }
            return a.split("\\s+")[1].compareTo(b.split("\\s+")[1]);
        }).forEach(System.out::println);
    }
}
