package HWOD.realTask.Problem38游戏分组;

import java.util.Scanner;

public class Problem38 {
    /**
     * 游戏分组：最优解问题，可以是抛硬币背景
     * 使用回溯法生成一个分组，使用递归实现，并在生成过程中，计算出两组之差
     */

    static int minDiff = Integer.MAX_VALUE;
    static int totalSum = 0;
    static int[] scores = new int[10];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            scores[i] = sc.nextInt();
            totalSum += scores[i];
        }

        backtrack(0, 0, 0);

        System.out.println(minDiff);
    }

    /**
     * 回溯法生成组合
     * @param start  当前起始索引
     * @param count  已选择人数
     * @param currentSum  当前组合总分
     */
    static void backtrack(int start, int count, int currentSum) {
        // 已经选择的人数，到达到 5 个
        if (count == 5) {
            int diff = Math.abs(totalSum - 2 * currentSum);  // |(currentSum) - (total - currentSum)|
            minDiff = Math.min(minDiff, diff);
            return;
        }

        // 递归每个可能的元素
        for (int i = start; i < 10; i++) {
            backtrack(i + 1, count + 1, currentSum + scores[i]);
        }
    }
}
