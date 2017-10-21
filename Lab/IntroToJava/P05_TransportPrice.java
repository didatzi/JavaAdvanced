package Lab.IntroToJava;

import java.util.Scanner;

public class P05_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distance = Double.parseDouble(scanner.nextLine());
        String timeOfDay = scanner.nextLine().toLowerCase();
        double priceOfTrip = 0;
        if (distance > 0 && distance < 20) {
            double tax = 0.7;
            if (timeOfDay.equals("day")) {
                priceOfTrip = tax + 0.79 * distance;
            } else if (timeOfDay.equals("night")) {
                priceOfTrip = tax + 0.9 * distance;
            }
        } else if (distance >= 20 && distance < 100) {
            priceOfTrip = 0.09 * distance;
        } else if (distance >= 100) {
            priceOfTrip = distance * 0.06;
        }

        System.out.printf("%.2f", priceOfTrip);
    }
}
