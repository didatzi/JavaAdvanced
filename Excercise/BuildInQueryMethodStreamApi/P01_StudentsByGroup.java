package Excercise.BuildInQueryMethodStreamApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P01_StudentsByGroup {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String line = scanner.nextLine();
//        List<String> lines = new ArrayList<>();
//        while (!"end".equalsIgnoreCase(line)) {
//            lines.add(line);
//            line = scanner.nextLine();
//        }
//        List<String[]> names = lines.stream()
//                .filter(n -> "2".equals(n.substring(n.length() - 1)))
//                .map(l -> l.substring(0, l.length() - 2))
//                .map(l -> l.split(" "))
//                .collect(Collectors.toList());
//
//        names.sort((a,b) -> a[0].compareTo(b[0]));
//        names.forEach(n -> System.out.println(n[0] + " " + n[1]));
//    }
public static void main(String[] args) throws IOException {

    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    List<String> students = new ArrayList<>();

    while (true){
        String[] input = scan.readLine().split("\\s+");
        if("END".equals(input[0])){
            break;
        }
        if("2".equals(input[2])){
            students.add(input[0] + " " + input[1]);
        }
    }
    students.stream().sorted(Comparator.comparing(a -> a.split(" ")[0])).forEach(System.out::println);
}
}
