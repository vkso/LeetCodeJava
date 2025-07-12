package hwod;

import java.util.*;

public class Problem26 {
    /**
     * 查找单入口空闲区域
     *
     * 有唯一符合要求的结果，返回三个数字 （行 列 区域大小）
     * 有多个符合要求的结果：
     *   有区域最大的，输出区域最大的
     *   区域最大的不唯一，直接输出区域大小
     * 没有符合要求的结果，输出 NULL
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");

        // m 行
        int m = Integer.parseInt(split[0]);
        // n 列
        int n = Integer.parseInt(split[1]);

        char[][] matrix = new char[m][n];

        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line[j].charAt(0);
            }
        }

        // 定义访问矩阵，确定点是否被访问过
        int[][] visited = new int[m][n];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 以 (i, j)点为起点，开始进行 bfs 搜索，返回搜索结果
                ArrayList<Integer> temp = bfs(matrix, visited, i, j, m, n);
                if (temp != null) {
                    result.add(temp);
                }
            }
        }

        StringBuilder printx = new StringBuilder();

        if (result.isEmpty()) {
            System.out.println("NULL");

        } else if (result.size() == 1) {
            ArrayList<Integer> integers = result.get(0);
            for (Integer integer : integers) {
                printx.append(integer).append(" ");
            }
            System.out.println(printx.toString().trim());

        } else {
            result.sort(new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                    if (o1.get(2) - o2.get(2) > 0) {
                        return -1;
                    }
                    return 0;
                }
            });

            if (result.get(0).get(2) == result.get(1).get(2)) {  // 如果相等直接输出面积
                System.out.println(result.get(0).get(2));
            } else {  // 如果不相等，那么直接输出第一个list 中的数据
                ArrayList<Integer> integers = result.get(0);
                for (Integer integer : integers) {
                    printx.append(integer).append(" ");
                }
                System.out.println(printx.toString().trim());
            }
        }
    }

    /**
     *
     * @param matrix 矩阵
     * @param visited 记录是否访问过
     * @param i 当前点的行数
     * @param j 当前点的列数
     * @param m 矩阵的总行数
     * @param n 矩阵的总列数
     * @return 返回符合目标的入口坐标和区域数量 [x, y, count] 可以为空
     */
    public static ArrayList<Integer> bfs(char[][] matrix, int[][] visited, int i, int j, int m, int n) {
        ArrayList<Integer> res = new ArrayList<>();

        // 如果当前节点已经访问过，或当前节点的值不是'O'，则直接返回 null
        if (visited[i][j] == 1 || matrix[i][j] == 'X') {
            return null;
        }

        // 移动方向，上下左右
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 将起始点入队
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = 1;
        // 定义当前起点包含的区域面积
        int count = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            count++;

            // 如果当前节点位于边缘，那么可以将其作为一个入口
            if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                res.add(x);
                res.add(y);
            }

            for (int[] direction : directions) {
                int xNew = x + direction[0];
                int yNew = y + direction[1];

                // 如果前进方向的节点：没有越界，没有访问过，值是'O'，那么将前进方向的节点坐标添加到队列中
                if (xNew >= 0 && xNew < m && yNew >= 0 && yNew < n && visited[xNew][yNew] != 1 && matrix[xNew][yNew] == 'O') {
                    visited[xNew][yNew] = 1;
                    queue.offer(new int[] {xNew, yNew});
                }
            }
        }
        res.add(count);

        if (res.size() > 3) {
            return null;
        }
        return res;
    }
}
