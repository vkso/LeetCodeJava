package hwod.螺旋数字矩阵;

import java.util.Arrays;
import java.util.Scanner;

public class Problem14 {
    /**
     * 螺旋数字矩阵
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        int cols = (int) Math.ceil(n / (double) m);
        String[][] matrix = new String[m][cols];

        for (String[] ints : matrix) {
            Arrays.fill(ints, "*");
        }

        int num = 1;
        // 定义运动方向，右 -> 下 -> 左 -> 上
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int curDir = 0;
        int curRow = 0, curCol = 0;

        if (n >= 1) {
            matrix[curRow][curCol] = "1";
        }

        for (int i = 2; i <= n; i++) {
            int nextRow = curRow + direct[curDir][0];
            int nextCol = curCol + direct[curDir][1];

            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= cols
            || !matrix[nextRow][nextCol].equals("*")) {
                curDir = (curDir + 1) % 4;
                nextRow = curRow + direct[curDir][0];
                nextCol = curCol + direct[curDir][1];
            }

            curRow = nextRow;
            curCol = nextCol;
            matrix[curRow][curCol] = String.valueOf(i);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(String.join(" ", matrix[i]));
        }
    }
}
