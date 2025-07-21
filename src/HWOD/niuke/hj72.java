package HWOD.niuke;

public class hj72 {
    public static void main(String[] args) {
        int x, y, z, middle;
        for (x = 0; x <= 14; x++) {
            for (y = 0; y <= 25; y++) {
                if (7 * x + 4 * y == 100) {
                    System.out.print(x + " " + y + " " + (100 - x - y));
                }
            }
        }
    }
}
