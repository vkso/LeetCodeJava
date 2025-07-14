package HWOD.Problem05连续出牌数量;

import java.util.Scanner;

public class Problem05 {
    private static int maxCards = 0;
    /**
     * 连续出牌数量 100 分
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] numbersInput = sc.nextLine().split(" ");
        String[] colorsInput = sc.nextLine().split(" ");

        int n = numbersInput.length;
        int[] numbers = new int[n];
        char[] colors = new char[n];

        // 解析输入数据
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numbersInput[i]);
            colors[i] = colorsInput[i].charAt(0);
        }

        boolean[] visited = new boolean[n];

        // 从每一张排开始进行 DFS
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1, numbers, colors, visited);
            visited[i] = false;
        }

        System.out.println(maxCards);
    }

    private static void dfs(int lastIndex, int count, int[] numbers, char[] colors, boolean[] visited) {
        // 更新最大牌数量
        maxCards = Math.max(count, maxCards);

        // 尝试遍历所有的牌，并对符合的牌进行递归
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                // 检查当前牌与上一张牌是否匹配
                if (numbers[lastIndex] == numbers[i] || colors[lastIndex] == colors[i]) {
                    visited[i] = true;
                    dfs(i, count + 1, numbers, colors, visited);
                    visited[i] = false;  //回溯
                }
            }
        }

    }
}
