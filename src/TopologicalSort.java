import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {

    public static List<Integer> topologicalSort(int n, int[][] edges) {
        // 构建邻接表
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 入度数组
        int[] inDegree = new int[n];

        // 构建图并计算入度
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            inDegree[v]++;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);
            // 遍历邻居，减少入度
            for (Integer v : graph[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // 检查是否存在环
        if (result.size() != n) {
            return new ArrayList<>();  // 存在环，返回空列表
        }
        return result;
    }

    public static void main(String[] args) {
        // 示例：4个顶点，边为 0->1, 0->2, 1->3, 2->3
        int n = 4;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        List<Integer> order = topologicalSort(n, edges);
        System.out.println("拓扑排序结果：" + order);
    }

}
