package Lab.BuildInQueryMethodStreamApi;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P07_MapDistricts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<Integer>> cities = new HashMap<>();
        List<String> inputTokens = Arrays.asList(scanner.nextLine().split("\\s+"));

        for (String token : inputTokens) {
            String[] tokens = token.split(":");
            String city = tokens[0];
            int districtPopulation = Integer.parseInt(tokens[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(districtPopulation);
        }
        int bound = Integer.parseInt(scanner.nextLine());
        cities.entrySet()
                .stream()
                .filter(filterByPopulation(bound))
                .sorted(sortedByDescending())
                .forEach(print());
    }

    private static Consumer<? super Map.Entry<String, List<Integer>>> print() {
        return keyValue -> {
            System.out.print(keyValue.getKey() + ": ");
            keyValue.getValue()
                    .stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(v -> System.out.print(v + " "));
            System.out.println();
        };
    }

    private static Comparator<? super Map.Entry<String, List<Integer>>> sortedByDescending() {
        return (keyValue1,keyValue2) -> Integer.compare(
                keyValue2.getValue()
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .sum(),
                keyValue1.getValue()
                        .stream()
                        .mapToInt(Integer::valueOf)
                        .sum());
    }

    private static Predicate<? super Map.Entry<String, List<Integer>>> filterByPopulation(int bound) {
        return keyValue -> keyValue.getValue()
                .stream()
                .mapToInt(Integer::valueOf)
                .sum() >= bound;
    }
}
