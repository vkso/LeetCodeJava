package hwod.精准核酸检测;

import java.util.*;

public class Problem28 {
    /**
     * 精准核酸监测
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 总人数
        int N = Integer.parseInt(sc.nextLine());
        // 确认病历人员的编号
        int[] sicked = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = sc.nextLine().split(",");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 构建邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        // BFS 遍历图
        boolean[] visited = new boolean[N];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 将已经确诊的病人序号标记为已访问，并添加到队列中
        for (int i : sicked) {
            visited[i] = true;
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        // 统计 visited 数组，和为需要做核酸的人数
        int count = 0;
        for (boolean b : visited) {
            if (b) {
                count++;
            }
        }

        System.out.println(count - sicked.length);

    }
}
