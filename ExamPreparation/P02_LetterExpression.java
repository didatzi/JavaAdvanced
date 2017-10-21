package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String textLine = reader.readLine();

        Pattern words = Pattern.compile("[^\\d]+");


        Matcher matcherForWords = words.matcher(textLine);
        String[] extractedNumbers = textLine.replaceAll(words.toString(), " ").split("\\s+");

        Queue<Integer> allNumbersQueue = new LinkedList<>();

        //put number in allNumbers
        for (String number : extractedNumbers) {
            allNumbersQueue.offer(Integer.parseInt(number));
        }

        long sum = 0;

        sum += allNumbersQueue.poll();

        while (matcherForWords.find()) {
            if (allNumbersQueue.isEmpty()) {
                break;
            }

            int num = allNumbersQueue.poll();

            //find word in text
            if (matcherForWords.group().length() % 2 == 0) {
                sum += num;
            } else {
                sum -= num;
            }
        }
        System.out.println(sum);
    }
}
