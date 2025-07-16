package HWOD.realTask.Problem44最小调整顺序次数特异性双端队列;

import java.util.Scanner;

public class Problem44 {
    /**
     * 双端队列
     * 1. 头部、尾部【添加】数据
     * 2. 头部【移除】数据
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int m = n * 2;

        String[] cmds = new String[m];
        for (int i = 0; i < m; i++) {
            cmds[i] = sc.nextLine();
        }

        System.out.println(getResult(cmds));
    }

    public static int getResult(String[] cmds) {
        int size = 0;
        // 初始的时候，空列表是有序的
        boolean isSorted = true;
        int count = 0;

        for (int i = 0; i < cmds.length; i++) {
            String cmd = cmds[i];
            if (cmd.startsWith("head add")) {
                // 头部添加数据的时候，如果队列是空的，不影响其有序性
                // 如果队列不是空的，那么原来的有序的序列，会变成无序序列
                if (size > 0 && isSorted) {
                    isSorted = false;
                }

            } else if (cmd.startsWith("tail add")) {
                // 尾部添加，只会增加当前队列中的数量，不会改变队列的有序性
                size++;
            } else {
                // 删除头部元素的时候，如果队列空，直接返回
                if (size == 0) {
                    continue;
                }
                // 如果队列是无序的，则需要对其进行一次排序
                if (!isSorted) {
                    count++;
                    isSorted = true;
                }
                // 如果队列是有序的，则直接返回即可，不需要进行一次排序操作
                size--;
            }
        }
        return count;
    }
}
