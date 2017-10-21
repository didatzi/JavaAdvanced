package Lab.IntroToJava;

public class P08_Lottery {
    public static void main(String[] args) {

        for (int first = 1; first <= 8; first++) {
            for (int second = first+1; second <= 9; second++) {
                for (int third = second+1; third <= 10; third++) {
                    System.out.printf("%d %d %d%n",first,second,third);
                }
            }
        }
    }
}
