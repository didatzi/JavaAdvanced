package Excercise.ObjectsClassesAndCollections;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P14_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, Long> countriesOnly = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> countryCity = new LinkedHashMap<>();



        while (!input.equals("report")) {
            String[] current = input.split("\\|");

            String currentCity = current[0];
            String currentCountry = current[1];
            long currentPopulation = Long.valueOf(current[2]);

            //countriesOnly Map
            countriesOnly.putIfAbsent(currentCountry, 0L);
            countriesOnly.put(currentCountry, countriesOnly.get(currentCountry) + currentPopulation);

            //countries Map
            countryCity.putIfAbsent(currentCountry, new LinkedHashMap<>());

            countryCity.get(currentCountry).putIfAbsent(currentCity, 0L);

            countryCity.get(currentCountry).put(currentCity, countryCity.get(currentCountry).get(currentCity) + currentPopulation);


            input = scanner.nextLine();
        }

        countryCity.entrySet().stream()
                .sorted((c1,c2)-> countriesOnly.get(c2.getKey()).compareTo(countriesOnly.get(c1.getKey())))
                .forEach(country ->{
                    System.out.println(String.format("%s (total population: %d)",country.getKey(),countriesOnly.get(country.getKey())));
                    country.getValue().entrySet()
                            .stream().sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue())).forEach(city -> System.out.println(String.format("=>%s: %d", city.getKey(),city.getValue())));
                });
    }
}
