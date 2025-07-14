package HWOD.Problem01判断不等式是否满足约束;

import java.util.Arrays;
import java.util.Scanner;

public class Problem01 {
    /**
     *
     * 判断一组不等式是否满足约束并输出最大差，100 分
     *
     * 系数，是一个二维数组 double
     * 2.3,3,5.6,7,6;
     * 11,3,8.6,25,1;
     * 0.3,9,5.3,66,7.8;
     *
     * 变量，是一个一维数组 int
     * 1,3,2,7,5;
     *
     * 目标值，是一个一维数组 double
     * 340,670,80.6;
     *
     * 约束关系，是字符串数组
     * <=,<=,<=
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] arr = Arrays.stream(sc.nextLine().split(";")).map(s -> s.split(",")).toArray(String[][]::new);

        double[] a1 = Arrays.stream(arr[0]).mapToDouble(Double::parseDouble).toArray();
        double[] a2 = Arrays.stream(arr[1]).mapToDouble(Double::parseDouble).toArray();
        double[] a3 = Arrays.stream(arr[2]).mapToDouble(Double::parseDouble).toArray();
        double[] x = Arrays.stream(arr[3]).mapToDouble(Double::parseDouble).toArray();
        double[] b = Arrays.stream(arr[4]).mapToDouble(Double::parseDouble).toArray();

        String[] y = arr[5];

        double diff1 = a1[0] * x[0] + a1[1] * x[1] + a1[2] * x[2] + a1[3] * x[3] + a1[4] * x[4] - b[0];
        double diff2 = a2[0] * x[0] + a2[1] * x[1] + a2[2] * x[2] + a2[3] * x[3] + a2[4] * x[4] - b[1];
        double diff3 = a3[0] * x[0] + a3[1] * x[1] + a3[2] * x[2] + a3[3] * x[3] + a3[4] * x[4] - b[2];

        boolean flag = compareWithZero(diff1, y[0])
                && compareWithZero(diff2, y[1])
                && compareWithZero(diff3, y[2]);

        double maxDiff = Math.max(Math.max(diff1, diff2), diff3);
        System.out.println(flag + " " + (int) maxDiff);
    }

    public static boolean compareWithZero(double val, String constraint) {
        boolean flag = false;

        switch (constraint) {
            case ">":
                flag = val > 0;
                break;
            case ">=":
                flag = val >= 0;
                break;
            case "<":
                flag = val < 0;
                break;
            case "<=":
                flag = val <= 0;
                break;
            case "=":
                flag = val == 0;
                break;
        }

        return flag;
    }
}
