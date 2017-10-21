package Lab.ObjectsClassesAndCollections;

import java.util.HashSet;
import java.util.Scanner;

public class P04_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> cars = new HashSet<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] car = line.split(", ");
            if (car[0].equals("IN")) {
                cars.add(car[1]);
            } else if (car[0].equals("OUT")) {
                cars.remove(car[1]);
            }
        }
        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
