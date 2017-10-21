package Excercise.DataRepresentationAndManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class P05_Chocolates_1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int packetsCount = Integer.parseInt(console.nextLine());
        long[] arr = Arrays.stream(console.nextLine().split(", ")).mapToLong(Long::parseLong).toArray();
        int students = Integer.parseInt(console.nextLine());

        Arrays.sort(arr);
        long minDiff = findMinDiff(packetsCount, arr, students);

        System.out.println("Min Difference is " + minDiff + ".");
    }

    private static long findMinDiff(int packetsCount, long[] arr, int students) {
        long minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= packetsCount - students; i++) {
            long currentDiff = arr[i + students - 1] - arr[i];
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }
        return minDiff;
    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int packets = Integer.parseInt(scan.nextLine());
//        int[] chocolatesPerPacket = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//        int students = Integer.parseInt(scan.nextLine());
//        int diff = Integer.MAX_VALUE;
//        int[] min =  new int[students];
//
//        Arrays.sort(chocolatesPerPacket);
//        for (int i = 0; i < packets-students+1; i++) {
//            if (chocolatesPerPacket[i+students-1]-chocolatesPerPacket[i]<diff){
//                diff = chocolatesPerPacket[i+students-1]-chocolatesPerPacket[i];
//                for (int j = 0; j < students; j++) {
//                    min[j]=chocolatesPerPacket[i+j];
//                }
//            }
//        }
//        System.out.println("Min Difference is "+diff+ ".");
//    }
        //--- with recursion ---//
//    private static int[] nums;
//    private static int studentsCount;
//    private static int[] loops;
//    private static int minDiff = Integer.MAX_VALUE;
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int packetsCount = Integer.valueOf(scanner.nextLine());
//
//        nums = Arrays.stream(scanner.nextLine()
//                .split(", "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//        studentsCount = Integer.valueOf(scanner.nextLine());
//        loops = new int[studentsCount];
//        findMinSum(0, 0, studentsCount);
//        System.out.println("Min Difference is " + minDiff + ".");
//    }
//
//    private static void findMinSum(int level, int prevIndexStart, int prevIndexEnd) {
//        if (level > studentsCount - 1){
//            int min = getMinElement();
//            int max = getMaxElement();
//            if (max - min < minDiff) {
//                minDiff = max - min;
//            }
//            return;
//        }
//        if (level == 0) {
//            for (int i = 0; i <= nums.length - prevIndexEnd + 1; i++) {
//                loops[level] = nums[i];
//                findMinSum(level + 1, i, prevIndexEnd - 1);
//            }
//        } else {
//            for (int i = prevIndexStart + 1; i <= nums.length - prevIndexEnd; i++) {
//                loops[level] = nums[i];
//                findMinSum(level + 1, i, prevIndexEnd - 1);
//            }
//        }
//    }
//
//    private static int getMinElement() {
//        int min = loops[0];
//        for (int i = 1; i < loops.length; i++) {
//            if (loops[i] < min) {
//                min = loops[i];
//            }
//        }
//        return min;
//    }
//
//    private static int getMaxElement() {
//        int max = loops[0];
//        for (int i = 1; i < loops.length; i++) {
//            if (loops[i] > max) {
//                max = loops[i];
//            }
//        }
//        return max;
//    }
}
