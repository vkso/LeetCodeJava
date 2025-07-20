package HWOD.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hj43 {

    static int h;
    static int w;
    static int[][] visited;
    static List<String> path = new ArrayList<>();
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();

        int[][] matrix = new int[h][w];
        visited = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        dfs(matrix, 0, 0);
        path.forEach(System.out::println);
    }

    public static boolean dfs(int[][] matrix, int i, int j) {
        // 如果越界，直接返回
        if (i < 0 || i >= h || j < 0 || j >= w) {
            return false;
        }
        // 如果已经访问过了，直接返回
        if (visited[i][j] == 1 || matrix[i][j] == 1) {
            return false;
        }

        path.add("(" + i + "," + j + ")");
        visited[i][j] = 1;

        if (i == h - 1 && j == w - 1) {
            return true;
        }

        for (int[] direction : directions) {
            if (dfs(matrix, i + direction[0], j + direction[1])) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
