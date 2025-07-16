package HWOD.realTask.Problem50流浪地球;

import java.util.*;

public class Problem50 {
    /**
     * 输入：
     * 第一行：N（发动机总个数） E（手动操作的次数）
     * 第 E 行：【T 启动时刻，E 发动机编号】
     *          T（手动启动时刻 0 <= T <= N） P（发动机位置编号 0 <= P < N）
     *
     * 输出：
     * N（最后被自动的发动机数量）
     * N 个发动机的位置编号
     *
     * 【多源 BFS】
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();

        int[] startTime = new int[N];
        Arrays.fill(startTime, -1);

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < E; i++) {
            int T = sc.nextInt();
            int P = sc.nextInt();

            // 如果这个位置还没有启动，或者后面有更小的启动时间，则更新该位置的时间，并将其添加到队列中
            if (startTime[P] == -1 || T < startTime[P]) {
                startTime[P] = T;
                queue.offer(new int[] {T, P});
            }
        }

        // 多源广度优先搜索
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int t = cur[0];  // 当前发动机的情动时间
            int p = cur[1];  // 当前发动机的编号

            // 计算左右相邻位置（环形结构）
            int left = (p - 1 + N) % N;
            int right = (p + 1) % N;

            // 遍历相邻的两个发动机
            for (int neighbour : new int[]{left, right}) {
                // 如果相邻的发动机没有启动，或者现有启动时间大于 t + 1，那么需要更新
                if (startTime[neighbour] == -1 || startTime[neighbour] > t + 1) {
                    startTime[neighbour] = t + 1;
                    queue.offer(new int[] {t + 1, neighbour});
                }
            }
        }

        // 查找所有发动机中，最晚被启动的时间（最大值）
        int maxTime = Arrays.stream(startTime).max().getAsInt();

        // 存储最后被启动的发动机的编号
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (startTime[i] == maxTime) {
                result.add(i);
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        result.forEach(id -> System.out.print(id + " "));
        System.out.println();
    }
}
