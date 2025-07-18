package HWOD.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hj26 {
    /**
     *  1. 字母表顺序排列，不区分大小写
     *  2. 同一大小写字母按照输入顺序排列
     *  3. 其他字符，保持原来的位置,不参与排序
     *
     */

    static class MyChar {
        int index;
        int weight;
        char ch;

        public MyChar(int index, char ch) {
            this.index = index;
            this.ch = ch;

            // 将大写字符和小写字符的 weight 统一转换成 大写字符的 阿斯克玛值，优先按照字母表的顺序排序
            if (ch >= 'a' && ch <= 'z') {
                this.weight = (char) (ch - ('a' - 'A'));
            } else if (ch >= 'A' && ch <= 'Z') {
                this.weight = ch;
            }
        }

        public int getIndex() {
            return index;
        }

        public int getWeight() {
            return weight;
        }

        public char getCh() {
            return ch;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        ArrayList<MyChar> otherChs = new ArrayList<>();

        PriorityQueue<MyChar> pq = new PriorityQueue<>(new Comparator<MyChar>() {
            @Override
            public int compare(MyChar o1, MyChar o2) {
                if (o1.getWeight() == o2.getWeight()) {
                    return o1.getIndex() - o2.getIndex();
                }
                return o1.getWeight() - o2.getWeight();
            }
        });

        char[] array = line.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];

            MyChar myChar = new MyChar(i, ch);

            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                pq.offer(myChar);
            } else {
                otherChs.add(myChar);
            }
        }

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            MyChar poll = pq.poll();
            res.append(poll.getCh());
        }

        otherChs.forEach(a -> res.insert(a.getIndex(), a.getCh()));

        System.out.println(res.toString());
    }
}
