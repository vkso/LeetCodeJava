package HWOD.realTask.Problem40执行任务赚积分;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem40 {
    /**
     * 执行任务赚积分
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读取任务数量
        int N = sc.nextInt();
        // 可用于处理任务的时间
        int T = sc.nextInt();
        // 优先队列用于存储可以执行的任务
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < N; i++) {
            int sla = sc.nextInt();
            int v = sc.nextInt();
            pq.offer(new int[] {sla, v});
        }

        // 当前处理任务的时间，一个时间只能处理一个任务
        int time = 0;

        // 统计已经处理任务获得的积分
        int scoreCount = 0;

        while (!pq.isEmpty() && time < T) {
            int[] poll = pq.poll();

            // 当前需要处理的任务已经大于可以用于处理任务的时间，则后续的任务不需要再处理
            if (poll[0] > time) {
                time++;
                scoreCount += poll[1];
            }
        }

        System.out.println(scoreCount);
    }
}
