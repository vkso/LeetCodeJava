package HWOD.Problem46AI画板识别;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem46 {
    /**
     * 找到灯的中心，是否属于同一行的依据是，灯的中心点 y 轴的差值绝对值小于等于灯的半径
     */
    static class Point {
        public int index;
        public int leftTop_x;
        public int leftTop_y;
        public int rightBottom_x;
        public int rightBottom_y;
        public int center_x;
        public int center_y;
        public int r;

        public Point(int index, int leftTop_x, int leftTop_y, int rightBottom_x, int rightBottom_y) {
            this.index = index;
            this.leftTop_x = leftTop_x;
            this.leftTop_y = leftTop_y;
            this.rightBottom_x = rightBottom_x;
            this.rightBottom_y = rightBottom_y;
            this.center_x = leftTop_x + (rightBottom_x - leftTop_x) / 2;
            this.center_y = leftTop_y + (rightBottom_y - leftTop_y) / 2;
            this.r = (rightBottom_y - leftTop_y) / 2;
        }

        public int getCenter_x() {
            return center_x;
        }

        public int getCenter_y() {
            return center_y;
        }

        public int getIndex() {
            return index;
        }

        public int getR() {
            return r;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int index = sc.nextInt();
            int leftTop_x = sc.nextInt();
            int leftTop_y = sc.nextInt();
            int rightBottom_x = sc.nextInt();
            int rightBottom_y = sc.nextInt();

            Point point = new Point(index, leftTop_x, leftTop_y, rightBottom_x, rightBottom_y);
            points.add(point);
        }

        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.getCenter_y() - o2.getCenter_y();
            }
        });

        ArrayList<String> ans = new ArrayList<>();

        ArrayList<Point> sameRowLights = new ArrayList<>();
        Point base = points.get(0);
        sameRowLights.add(base);

        for (int i = 1; i < points.size(); i++) {
            Point point = points.get(i);
            if (point.getCenter_y() - base.getCenter_y() <= base.getR()) {
                sameRowLights.add(point);
            } else {
                // 后面所有的等都不是同一行了，这时候，可以输出已经进入列表中的同一行灯的第一个了
                sameRowLights.sort((a, b) -> a.getCenter_x() - b.getCenter_x());
                sameRowLights.forEach(a -> ans.add(a.getIndex() + ""));
                sameRowLights.clear();

                // 处理新的一行
                base = point;
                sameRowLights.add(point);
            }
        }

        // 如果最后一行只有一个节点，需要单独处理
        if (sameRowLights.size() > 0) {
            sameRowLights.sort((a, b) -> a.getCenter_x() - b.getCenter_x());
            sameRowLights.forEach(a -> ans.add(a.getIndex() + ""));
        }

        System.out.println(String.join(" ", ans));
    }
}
