package skills.pq;

import java.util.Comparator;
import java.util.PriorityQueue;

class Task {
    String name;
    int priority;  // 1 = 最高，5 = 最低
    double processingTime;

    public Task(String name, int priority, double processingTime) {
        this.name = name;
        this.priority = priority;
        this.processingTime = processingTime;
    }

    @Override
    public String toString() {
        return name + " (pri=" + priority + ", time=" + processingTime + ")";
    }
}

public class CustomClassPriorityQueue {
    public static void main(String[] args) {
        // 多属性比较器：优先级（降序）> 处理时间（升序）> 名称（升序）
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(
                Comparator.comparingInt((Task t) -> t.priority)  // 优先级升序比较器
                        .reversed()  // 通过 reversed() 实现降序
                        .thenComparingDouble(t -> t.processingTime)  // 处理时间升序
                        .thenComparing(t -> t.name)  // 名称升序
        );

        PriorityQueue<Task> way2 = new PriorityQueue<>(
                (t1, t2) -> {
                    // 处理第一个优先级
                    // 优先级：数值小的优先级高（降序）
                    int priorityCompare = Integer.compare(t1.priority, t2.priority);
                    if (priorityCompare != 0) return priorityCompare;

                    // 处理时间：时间短有先（升序）
                    int timeCompare = Double.compare(t1.processingTime, t2.processingTime);
                    if (timeCompare != 0) return timeCompare;

                    // 名称：字典序（升序）
                    return t1.name.compareTo(t2.name);
                }
        );

        taskQueue.add(new Task("TaskA", 2, 3.5));
        taskQueue.add(new Task("TaskB", 1, 4.0));
        taskQueue.add(new Task("TaskC", 1, 2.5));
        taskQueue.add(new Task("TaskD", 3, 1.0));
        taskQueue.add(new Task("TaskE", 2, 3.0));

        System.out.println("任务优先级排序：");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }

        // 输出：
        // TaskC (pri=1, time=2.5)
        // TaskB (pri=1, time=4.0)
        // TaskE (pri=2, time=3.0)
        // TaskA (pri=2, time=3.5)
        // TaskD (pri=3, time=1.0)
    }
}
