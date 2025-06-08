package skills.pq;

import java.util.PriorityQueue;

public class LambdaComparator {
    public static void main(String[] args) {
        // 创建按字符串长度排序的优先队列
        PriorityQueue<String> lengthQueue =  new PriorityQueue<String>(
                (a, b) -> a.length() - b.length()
        );

        lengthQueue.offer("apple");
        lengthQueue.offer("banana");
        lengthQueue.offer("kiwi");
        lengthQueue.offer("orange");
        lengthQueue.offer("pear");

        System.out.println("按字符串长度排序:");
        while (!lengthQueue.isEmpty()) {
            System.out.print(lengthQueue.poll() + " "); // 输出: kiwi pear apple banana orange
        }
        System.out.println("\n");
    }
}
