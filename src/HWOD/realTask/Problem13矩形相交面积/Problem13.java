package HWOD.realTask.Problem13矩形相交面积;

import java.util.Scanner;

public class Problem13 {
    /**
     * 矩形相交面积
     */
    static class Rectangle {
        int x, y, w, h;

        public Rectangle(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public int getLeft() {
            return x;
        }

        public int getRight() {
            return x + w;
        }

        public int getTop() {
            return y;
        }

        public int getBottom() {
            return y - h;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Rectangle[] rects = new Rectangle[3];
        for (int i = 0; i < 3; i++) {
            String[] data = sc.nextLine().split("\\s+");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            int w = Integer.parseInt(data[2]);
            int h = Integer.parseInt(data[3]);
            rects[i] = new Rectangle(x, y, w, h);
        }

        // 计算 x 方向的重叠范围
        int commonLeft = Math.max(rects[0].getLeft(),
                Math.max(rects[1].getLeft(), rects[2].getLeft()));
        int commonRight = Math.min(rects[0].getRight(),
                Math.min(rects[1].getRight(), rects[2].getRight()));

        int width = Math.max(0, commonRight - commonLeft);

        // 计算 y 方向的重叠范围
        int commonTop = Math.min(rects[0].getTop(),
                Math.min(rects[1].getTop(), rects[2].getTop()));

        int commonBottom = Math.max(rects[0].getBottom(),
                Math.max(rects[1].getBottom(), rects[2].getBottom()));

        int height = Math.max(0, commonTop - commonBottom);

        // 返回面积
        System.out.println(width * height);
    }
}

























