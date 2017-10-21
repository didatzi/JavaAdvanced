package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03_BitRoller {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.valueOf(reader.readLine());


        int frozenBitPosition = Integer.valueOf(reader.readLine());
        int rollTimes = Integer.valueOf(reader.readLine());

        //used for checking bit string in debug mode
        String bitValueOfNumber = Integer.toBinaryString(number);

        //first shift number frozenBitPosition times and
        // take 0|1 at shifted position
        int numAtPosition = (1 & (number >> frozenBitPosition));

        for (int roll = 0; roll < rollTimes; roll++) {
            //take last 0|1 from bit representation of number
            int lastNum = number & 1;
            //shift right bits of number one time
            number = number >> 1;

            bitValueOfNumber = Integer.toBinaryString(number);
            if (frozenBitPosition != 0) {
                //if lastNum = 1, shift 1 - 18 times,
                // then check if replace first bit with 1
                // 0 | 1 == 1
                if (lastNum != 0) {
                    number = number | (1 << 18);
                }
                bitValueOfNumber = Integer.toBinaryString(number);
                // shift number and take 0|1 at frozenBitPosition
                int numToRotate = (number >> frozenBitPosition) & 1;

                //if bit in position is 0|1 -> change it to 1|0;
                if (numToRotate != numAtPosition) {
                    number = number ^ (1 << frozenBitPosition - 1);
                    number = number ^ (1 << frozenBitPosition);
                    bitValueOfNumber = Integer.toBinaryString(number);
                }
            } else {
                // frozenBitPosition = 0
                // & -> AND (1 if both bits are 1) 1 = 001 in bits;
                int secondLastNum = number & 1;
                if (secondLastNum != 0) {
                    // | -> OR (1 if either bit is 1) = 1 - 0 = 1; 0 - 1 = 1; 1 - 1 = 1; 0 - 0 = 0;
                    // 1 << 18 -> shift left 1 - 18 times
                    number = number | (1 << 18);
                    bitValueOfNumber = Integer.toBinaryString(number);
                }
                if (lastNum != secondLastNum) {
                    // ^ -> XOR (1 if both bits are different) -> 0 - 1 = 1; 1 - 0 = 1; 1 - 1 = 0; 0 - 0 = 0;
                    number = number ^ 1;
                    bitValueOfNumber = Integer.toBinaryString(number);
                }
            }
        }
        System.out.println(number);
    }
}
