package Excercise.Abstraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11_StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        int rotations = Integer.parseInt(inputLine.split("[]\\(\\)]")[1]);
        rotations /= 90;
        rotations %= 4;
        StringBuilder matrixLine = new StringBuilder();
        inputLine = reader.readLine();
        int maxLength = 0;

        while (!inputLine.equals("END")) {
            if (inputLine.length() > maxLength) maxLength = inputLine.length();
            matrixLine.append(inputLine).append("\n");
            inputLine = reader.readLine();
        }

        String[] matrixL = matrixLine.toString().split("\n");
        StringBuilder output = new StringBuilder();

        switch (rotations) {
            case 0:
                output = matrixLine;
                break;
            case 1:
                output = CalculateMatrix(maxLength, matrixL, output);
                break;
            case 2:
                output = matrixLine.reverse();
                break;

            case 3:
                output = CalculateMatrix(maxLength, matrixL, output);
                output.reverse();
                break;
        }
        System.out.println(output.toString());
    }

    private static StringBuilder CalculateMatrix(Integer maxLen, String[] matrixL, StringBuilder output) {
        StringBuilder outputBuilder = new StringBuilder(output);
        for (int j = 0; j < maxLen; j++) {
            for (int i = matrixL.length - 1; i >= 0; i--) {
                try {
                    outputBuilder.append(matrixL[i].charAt(j));
                } catch (Exception e) {
                    outputBuilder.append(" ");
                }
            }
            outputBuilder.append("\n");
        }
        return outputBuilder;
    }
}
