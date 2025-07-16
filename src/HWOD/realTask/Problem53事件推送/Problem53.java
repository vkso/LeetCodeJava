package HWOD.realTask.Problem53事件推送;

import java.util.Arrays;
import java.util.Scanner;

public class Problem53 {
    /**
     * 事件推送，双指针
     * A.m B.n R
     * A1 A1 ... Am
     * B1 B2 ... Bn
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int R = sc.nextInt();
        sc.nextLine();

        int[] setA = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] setB = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 指向 B 的索引
        int index = 0;

        for (int valueA : setA) {
            while (index < setB.length && setB[index] < valueA) {
                index++;
            }

            if (index < setB.length && setB[index] - valueA <= R) {
                System.out.println(valueA + " " + setB[index]);
            }
        }

    }
}
