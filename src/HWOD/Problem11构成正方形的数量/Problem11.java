package HWOD.Problem11构成正方形的数量;

import java.util.*;

public class Problem11 {
    /**
     * 构成正方形的数量
     */

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Point point = (Point) obj;
            return point.x == x && point.y == y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();
        Set<Point> pointSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point p = new Point(x, y);
            points.add(p);
            pointSet.add(p);
        }

        if (n < 4) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Point A = points.get(i);
                Point B = points.get(j);

                int dx = B.x - A.x;
                int dy = B.y - A.y;

                // (-dy, dx), (dy, -dx)

                // 顺时针旋转 90° 得到的点
                Point C1 = new Point(A.x - dy, A.y + dx);
                Point C2 = new Point(B.x - dy, B.y + dx);

                // 逆时针旋转 90° 得到的点
                Point C3 = new Point(A.x + dy, A.y - dx);
                Point C4 = new Point(B.x + dy, B.y - dx);

                if (pointSet.contains(C1) && pointSet.contains(C2)) {
                    count++;
                }

                if (pointSet.contains(C3) && pointSet.contains(C4)) {
                    count++;
                }
            }
        }

        System.out.println(count / 4);
    }
}
