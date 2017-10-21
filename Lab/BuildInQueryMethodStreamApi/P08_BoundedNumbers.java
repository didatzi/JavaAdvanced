package Lab.BuildInQueryMethodStreamApi;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08_BoundedNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> borderNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        numbers.stream()
                .filter(n -> Collections.min(borderNumbers) <= n && n <= Collections.max(borderNumbers))
                .forEach(n -> System.out.print(n + " "));
    }
}
