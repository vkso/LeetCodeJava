package hwod;

import java.util.Scanner;

public class Problem03 {
    /**
     * 光伏场地建设规划 100 分
     *
     * 2 5 2 6
     * 1 3 4 5 8
     * 2 3 6 7 1
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int len = sc.nextInt();
        int limit = sc.nextInt();

        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(countValidStations(grid, r, c, len, limit));

    }

    private static int countValidStations(int[][] grid, int rows, int cols, int size, int minSum) {

        // 构建二维前缀和数组，用于简化计算
        int[][] prefixSum = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                // 前缀和：左边 + 上边 - 左上角 + 当前格子的值
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }

        // 遍历所有的子矩阵，计算其和，并判断是否满足条件
        int count = 0;
        for (int i = size; i <= rows; i++) {
            for (int j = size; j <= cols; j++) {
                // 计算子矩阵的总和，公式：当前矩形总和 = 右下角矩阵元素的值
                // - 上边矩形（右上角的上一个元素）
                // - 左边矩形（左下角的左一个元素）
                // + 左上角的左上角元素值（重叠部分，减了两次）
                int sum = prefixSum[i][j]
                        - prefixSum[i - size][j]
                        - prefixSum[i][j - size]
                        + prefixSum[i - size][j - size];

                if (sum >= minSum) {
                    count++;
                }
            }
        }
        return count;
    }
}