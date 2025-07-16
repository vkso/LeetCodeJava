package HWOD.realTask.Problem36停车场车辆统计;

import java.util.Scanner;

public class Problem36 {
    /**
     * 停车场车辆统计
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String result = sc.nextLine().replaceAll(",", "")
                .replaceAll("111", "x")
                .replaceAll("11", "x")
                .replaceAll("1", "x");

        int count = 0;
        for (int i = 0; i < result.length(); i++) {
            char ch = result.charAt(i);
            if (ch == 'x') {
                count++;
            }
        }
        System.out.println(count);
    }
}
