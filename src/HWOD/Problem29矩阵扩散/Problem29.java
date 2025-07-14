package HWOD.Problem29矩阵扩散;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem29 {
    /**
     * 矩阵扩散
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] line = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int m = line[0];
        int n = line[1];
        int i = line[2];
        int j = line[3];
        int k = line[4];
        int l = line[5];

        // 创建时间矩阵，对遍历过的位置进行时间标记
        int[][] times = new int[m][n];
        for (int[] time : times) {
            Arrays.fill(time, -1);
        }

        // 定义传播的方向, 上下左右
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        queue.offer(new int[] {k, l});
        times[i][j] = 0;
        times[k][l] = 0;
        int timeStep = 0;
        int res = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int[] direction : directions) {
                int xNew = x + direction[0];
                int yNew = y + direction[1];

                // 没有越界、没有访问
                if (xNew >= 0 && xNew < m && yNew >= 0 && yNew < n && times[xNew][yNew] == -1) {
                    times[xNew][yNew] = times[x][y] + 1;
                    res = Math.max(times[xNew][yNew], res);
                    queue.offer(new int[] {xNew, yNew});
                }
            }
        }
        System.out.println(res);
    }
}
