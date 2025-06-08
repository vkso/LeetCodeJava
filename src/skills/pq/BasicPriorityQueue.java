package skills.pq;

import java.util.PriorityQueue;

public class BasicPriorityQueue {
    public static void main(String[] args) {
        // 默认最小堆 - 队首元素最小
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.offer(3);

        System.out.println("最小堆输出：");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");  // 输出：1 2 3 4 5 8
        }
        System.out.println("\n");
    }
}
