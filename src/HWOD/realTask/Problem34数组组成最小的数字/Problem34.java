package HWOD.realTask.Problem34数组组成最小的数字;

import java.util.Arrays;
import java.util.Scanner;

public class Problem34 {
    /**
     * 数组组成最小的数字
     *
     * 第一次直接升序排序，取前三
     * 第二次，对两数相加（字符串），进行排序
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().split(",");
        System.out.println(getResult(strs));
    }

    public static String getResult(String[] strs) {
        Arrays.sort(strs, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));

        String[] tmp = Arrays.copyOfRange(strs, 0, Math.min(3, strs.length));
        Arrays.sort(tmp, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();
        for (String s : tmp) {
            sb.append(s);
        }

        return sb.toString();
    }
}
