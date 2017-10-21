package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05_WiggleWiggle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long[] numbers = Arrays.stream(reader.readLine().split("[\\s]+")).mapToLong(Long::parseLong).toArray();

        for (int num = 0; num < numbers.length; num += 2) {

            for (int bitPos = 0; bitPos < 64; bitPos+=2) { // for loop over each even bit
                // Take the bits
                long firstNumBit = numbers[num] & (1L << bitPos);
                long secondNumBit = numbers[num + 1] & (1L << bitPos);

                //If there is difference - reverse them
                if (firstNumBit != secondNumBit) {
                    numbers[num] ^= 1 << bitPos;
                    numbers[num + 1] ^= 1 << bitPos;
                }
            }

            numbers[num] = ~numbers[num];
            numbers[num + 1] = ~numbers[num + 1];

            numbers[num] &= ~(1L << 63);   //Turn the last bit -> 0
            numbers[num + 1] &= ~(1L << 63);

            System.out.println(numbers[num] + " " + String.format("%63s", Long.toBinaryString(numbers[num])));
            System.out.println(numbers[num + 1] + " " + String.format("%63s", Long.toBinaryString(numbers[num + 1])));
        }


    }

}