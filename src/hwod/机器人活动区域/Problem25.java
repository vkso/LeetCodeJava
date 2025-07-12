package hwod.机器人活动区域;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem25 {
    /**
     * 机器人活动区域
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 行、列数
        int MRwo = sc.nextInt();
        int NCol = sc.nextInt();

        // 创建活动区域并初始化
        int[][] matrix = new int[MRwo][NCol];
        for (int i = 0; i < MRwo; i++) {
            for (int j = 0; j < NCol; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 是否访问过
        int[][] visited = new int[MRwo][NCol];
        // 移动方向，上 下 左 右
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        // 最大区域值，开始为 0
        int maxArea = 0;

        for (int i = 0; i < MRwo; i++) {
            for (int j = 0; j < NCol; j++) {

                int curArea = returnCurrentArea(matrix, visited, directions, i, j);
                maxArea = Math.max(maxArea, curArea);
            }
        }

        System.out.println(maxArea);
    }

    public static int returnCurrentArea(int[][] matrix, int[][] visited, int[][] directions, int x, int y) {

        // 创建一个新的队列，使用 BFS 遍历当前起点 x，y 可以到达的全部点
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});
        int count = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            visited[poll[0]][poll[1]] = 1;
            count++;

            // 判断是否可以 ↑、↓、<-、-> 移动，如果可以将上面的节点添加到队列中
            for (int[] direction : directions) {
                int xNew = poll[0] + direction[0];
                int yNew = poll[1] + direction[1];

                // 如果该方向移动一步的坐标没有越界，并且该节点没有被访问过，
                if (xNew >= 0 && xNew < matrix.length && yNew >= 0 && yNew <matrix[0].length && visited[xNew][yNew] != 1) {

                    // 如果相邻元素的值相差不超过 1，那么可以将该方向的坐标添加到队列中
                    if (Math.abs(matrix[poll[0]][poll[1]] - matrix[xNew][yNew]) <= 1) {
                        queue.offer(new int[] {xNew, yNew});
                    }

                }
            }
        }

        return count;
    }

}
