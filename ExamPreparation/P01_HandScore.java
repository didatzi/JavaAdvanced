package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class P01_HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] allCards = reader.readLine().split(" ");
        ArrayDeque<String> cardsLeft = new ArrayDeque<>();
        Collections.addAll(cardsLeft, allCards);

        int result = 0;
        int tempResult = 0;
        int count = 0;
        for (int i = 0; i < allCards.length; i = i + count) {
            String card = allCards[i];
            char currentCardType = card.charAt(card.length() - 1);
            count = 0;

            while (cardsLeft.size() > 0) {
                String pickedCard = cardsLeft.peek();
                char pickedCardType = pickedCard.charAt(pickedCard.length() - 1);
                if (currentCardType != pickedCardType) {
                    break;
                }
                count++;
                cardsLeft.pop();
                tempResult += cardValue(pickedCard);
            }
            if (count > 1) {
                result += tempResult * count;

            } else {
                result += cardValue(card);
            }

            tempResult = 0;
        }
        System.out.println(result);
    }

    private static Integer cardValue(String card) {

        String value = card.substring(0, card.length() - 1);

        switch (value) {
            case "10":
                value = "10";
                break;
            case "J":
                value = "12";
                break;
            case "Q":
                value = "13";
                break;
            case "K":
                value = "14";
                break;
            case "A":
                value = "15";
                break;
        }
        return Integer.parseInt(value);
    }
}
