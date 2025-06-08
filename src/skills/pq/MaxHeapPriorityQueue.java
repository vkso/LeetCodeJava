package skills.pq;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapPriorityQueue {
    public static void main(String[] args) {
        // 使用 Collections.reverseOrder() 创建最大堆）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);
        maxHeap.offer(3);

        System.out.println("最大堆输出：");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println("\n");
    }
}
