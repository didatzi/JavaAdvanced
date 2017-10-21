package Excercise.ObjectsClassesAndCollections;

import java.util.*;

public class P13_HandOfCards2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Set<String>> playersCards = new LinkedHashMap<>();

        while (!line.equals("JOKER")) {
            String[] tokens = line.split(": ");

            String playerName = tokens[0];
            String[] playerHand = tokens[1].split(", ");

            if (playersCards.containsKey(playerName)) {

                for (Map.Entry<String, Set<String>> kv : playersCards.entrySet()) {

                    if (kv.getKey().contains(playerName)) {
                        Set<String> existingHand = kv.getValue();
                        Collections.addAll(existingHand, playerHand);
                    }
                }

            } else {
                Set<String> handHolder = new HashSet<>();
                Collections.addAll(handHolder, playerHand);
                playersCards.put(playerName, handHolder);
            }

            line = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> kv : playersCards.entrySet()) {
            String playerName = kv.getKey();
            Set<String> existingHand = kv.getValue();
            int handValue = cardTotalValueCalc(existingHand);
            System.out.println(playerName + ": " + handValue);
        }
    }

    private static int cardTotalValueCalc(Set<String> existingHand) {

        int handValue = 0;
        for (String card : existingHand) {
            String power;
            String multiplier;
            if (card.length() == 2) {
                power = String.valueOf(card.charAt(0));
                multiplier = String.valueOf(card.charAt(1));
            } else {
                power = String.valueOf(card.charAt(0));
                multiplier = String.valueOf(card.charAt(2));
            }
            int p = cardPower(power);
            int m = cardMultiplier(multiplier);

            handValue += p * m;
        }
        return handValue;
    }

    private static int cardMultiplier(String multiplier) {

        char c = multiplier.charAt(0);
        switch (c) {
            case 'S': return 4;
            case 'H': return 3;
            case 'D': return 2;
            case 'C': return 1;
            default:  return 0;
        }
    }

    private static int cardPower(String power) {

        char c = power.charAt(0);
        switch (c) {
            case '1': return 10;
            case 'J': return 11;
            case 'Q': return 12;
            case 'K': return 13;
            case 'A': return 14;
            default:  return Integer.parseInt(power);
        }
    }
}
