package HWOD.Problem27打印机队列;

import java.util.*;

public class Problem27 {
    /**
     * 打印机队列
     * IN P（打印机序列号） NUM（文件优先级）
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        HashMap<Integer, PriorityQueue<int[]>> printers = new HashMap<>();
        int fileIndex = 0;

        for (int i = 1; i <= 5; i++) {
            // 队列输入：[文件序号，优先级]
            printers.put(i, new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] - o2[1] > 0) {
                        return -1;
                    } else if (o1[0] - o2[0] > 0) {
                        return 1;
                    }
                    return 0;
                }
            }));
        }

        String[] ops = new String[N];

        for (int i = 0; i < N; i++) {
            ops[i] = sc.nextLine();
        }

        for (String op : ops) {
            String[] split = op.split(" ");
            switch (split[0]) {
                case "IN":
                    PriorityQueue<int[]> printer = printers.get(Integer.parseInt(split[1]));
                    printer.offer(new int[] {++fileIndex, Integer.parseInt(split[2])});
                    break;
                case "OUT":
                    PriorityQueue<int[]> printerx = printers.get(Integer.parseInt(split[1]));
                    if (printerx.isEmpty()) {
                        System.out.println("NULL");
                    } else {
                        int[] poll = printerx.poll();
                        System.out.println(poll[0]);
                    }
                    break;
            }
        }
    }
}
