package Excercise.Abstraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P09_TerroristsWin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        while (true) {
            int openPipe = text.indexOf('|');
            if (openPipe == -1) {
                break;
            }
            int closePipe = text.indexOf('|', openPipe + 1);
            if (closePipe == -1) {
                break;
            }
            int power = 0;
            char[] arrayBetweenPipes = text.substring(openPipe + 1, closePipe).toCharArray();

            for (char element : arrayBetweenPipes) {
                power += (int) element;
            }
            power %= 10;
            int startIndex = Math.max(openPipe - power, 0);
            int endIndex = Math.min(closePipe + power + 1, text.length());

            text = text.substring(0, startIndex)
                    + new String(new char[endIndex - startIndex]).replace("\0", ".")
                    + text.substring(endIndex);
        }
        System.out.println(text);
    }

}
