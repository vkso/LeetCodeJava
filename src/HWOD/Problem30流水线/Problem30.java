package HWOD.Problem30流水线;

import java.util.Arrays;
import java.util.Scanner;

public class Problem30 {
    /**
     * 流水线
     *
     * 3（m 条流水线） 5（n 个独立的作业）
     * 8 4 3 2 10（每个作业的处理耗时）
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();  // m 条流水线
        int n = sc.nextInt();  // n 个独立作业

        int[] workTimes = new int[n];

        for (int i = 0; i < n; i++) {
            workTimes[i] = sc.nextInt();
        }

        Arrays.sort(workTimes);

        int[] flowLines = new int[m];
        for (int i = 0; i < n; i++) {
            flowLines[i % m] += workTimes[i];
        }

        int max = 0;
        for (int flowLine : flowLines) {
            max = Math.max(flowLine, max);
        }

        System.out.println(max);
    }
}
