package HWOD.realTask.Problem02返回矩阵中非1元素个数;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem02 {
    /**
     * 返回矩阵中非 1 的元素个数，200 分
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        matrix[0][0] = 1;

        System.out.println(getResult(m, n, matrix));
    }

    public static int getResult(int m, int n, int[][] matrix) {
        // 左、又、上、下，四个方向的偏移量
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 创建一个队列，用于广度优先搜索
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 第一个位置的元素入队
        queue.offer(new int[] {0, 0});

        // 记录矩阵中 1 元素的个数
        int count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];

            for (int[] offset : offsets) {
                int newX = x + offset[0];
                int newY = y + offset[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 0) {
                    matrix[newX][newY] = 1;
                    count++;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return m * n - count;
    }
}
