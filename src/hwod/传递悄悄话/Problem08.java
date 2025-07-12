package hwod.传递悄悄话;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem08 {
    /**
     * 传递悄悄话
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] whisperTimes = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sc.close();

        int maxTime = 0;

        // 使用队列进行二叉树的层次遍历
        ArrayDeque<Integer> nodeQueue = new ArrayDeque<>();
        // 将根节点添加到队列中
        nodeQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            Integer parentNodeIndex = nodeQueue.poll();

            int leftChildIndex = 2 * parentNodeIndex + 1;
            int rightChildIndex = 2 * parentNodeIndex + 2;

            // 如果左子节点存在
            if (leftChildIndex < whisperTimes.length && whisperTimes[leftChildIndex] != -1) {
                // 更新左子节点的时间（父节点时间+当前节点时间）
                whisperTimes[leftChildIndex] += whisperTimes[parentNodeIndex];
                nodeQueue.offer(leftChildIndex);
                maxTime = Math.max(maxTime, whisperTimes[leftChildIndex]);
            }

            // 如果又子节点存在
            if (rightChildIndex < whisperTimes.length && whisperTimes[rightChildIndex] != -1) {
                whisperTimes[rightChildIndex] += whisperTimes[parentNodeIndex];
                nodeQueue.offer(rightChildIndex);
                maxTime = Math.max(maxTime, whisperTimes[rightChildIndex]);
            }
        }
        System.out.println(maxTime);
    }
}
