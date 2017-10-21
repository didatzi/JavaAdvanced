package Lab.DataRepresentationAndManipulation;

import java.util.Collections;
import java.util.Scanner;

public class P05_RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        drawFigure(n);
    }

    private static void drawFigure(int n) {
        //base
        if (n < 1) {
            return;
        }
        //pre-action
        System.out.println(String.join("", Collections.nCopies(n, "*")));
        //Recursion
        drawFigure(n - 1);
        //post-Action
        System.out.println(String.join("", Collections.nCopies(n, "#")));
    }
}
