package HWOD.Problem52任务编排总时长;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Problem52 {
    /**
     * A, B, C
     * A -> TaskA 的执行时长
     * B -> TaskB 的执行时长
     * C 任务数量
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int taskATime = array[0];
        int taskBTime = array[1];
        int taskNums = array[2];

        if (taskNums == 0) {
            System.out.println("[]");
            return;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i <= taskNums; i++) {
            int totalTime = taskATime * i + taskBTime * (taskNums - i);
            treeSet.add(totalTime);
        }

        System.out.println(treeSet.toString());
    }
}













