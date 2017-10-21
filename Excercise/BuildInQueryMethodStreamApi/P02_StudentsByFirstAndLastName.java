package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        List<String> students = new ArrayList<>();

        while (true){
            String[] input = scan.readLine().split("\\s+");
            if("END".equals(input[0])){
                break;
            }
            if(input[0].compareTo(input[1]) < 0){
                students.add(input[0] + " " + input[1]);
            }
        }
        students.forEach(System.out::println);
    }
//        Scanner scanner = new Scanner(System.in);
//
//        String[] fullName = scanner.nextLine().split("\\s+");
//        Map<String, String> names = new HashMap<>();
//        while (!"end".equalsIgnoreCase(fullName[0])) {
//            String firstName = fullName[0];
//            String lastName = fullName[1];
//            names.put(firstName, lastName);
//            fullName = scanner.nextLine().split("\\s+");
//        }
//     names.entrySet().stream()
//             .filter(n -> n.getKey().charAt(0) < n.getValue().charAt(0))
//             .forEach(n -> System.out.println(n.getKey() + " " + n.getValue()));
//    }
}
