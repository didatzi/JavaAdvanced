package Excercise.ObjectsClassesAndCollections;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P04_TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pumps = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> cycle = IntStream.range(0, pumps).mapToObj(i -> scanner.nextLine()).collect(Collectors.toCollection(ArrayDeque::new));

        for (int iPump = 0; iPump < pumps; iPump++) {
            Integer currentPetrol = 0;
            String station = cycle.remove();
            String[] line = station.split("\\s+");
            Integer petrolFilled = Integer.parseInt(line[0]);
            Integer petrolSpent = Integer.parseInt(line[1]);

            currentPetrol += petrolFilled - petrolSpent;
            if (currentPetrol >=0){
                boolean hasFilled = true;

                for (String stations : cycle) {
                    String[] nextStation = stations.split("\\s+");
                    int nextPetrolToFill = Integer.parseInt(nextStation[0]);
                    int nextPetrolToSpend = Integer.parseInt(nextStation[1]);

                    currentPetrol += nextPetrolToFill - nextPetrolToSpend;
                    if (currentPetrol < 0) {
                        hasFilled = false;
                        break;
                    }
                }
                if (hasFilled) {
                    System.out.println(iPump);
                    return;
                } else {
                    cycle.addLast(station);
                }
            }else{
                cycle.add(station);
            }
        }
        System.out.println("Can't refill");
    }
}
