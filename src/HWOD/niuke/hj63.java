package HWOD.niuke;

import java.util.Scanner;

public class hj63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dna = sc.next();
        int n = sc.nextInt();

        System.out.println(findMaxGcSubstring(dna, n));
    }

    public static String findMaxGcSubstring(String dna, int n) {
        int maxGc = 0;
        int currentGc = 0;
        int startIndex = 0;

        // 初始窗口
        for (int i = 0; i < n; i++) {
            if (dna.charAt(i) == 'G' || dna.charAt(i) == 'C') {
                currentGc++;
            }
        }
        maxGc = currentGc;

        // 滑动窗口
        for (int i = n; i < dna.length(); i++) {
            // 移出左侧
            if (dna.charAt(i - n) == 'G' || dna.charAt(i - n) == 'C') {
                currentGc--;
            }
            // 加入右侧
            if (dna.charAt(i) == 'G' || dna.charAt(i) == 'C') {
                currentGc++;
            }

            if (currentGc > maxGc) {
                maxGc = currentGc;
                startIndex = i - n + 1;
            }
        }

        return dna.substring(startIndex, startIndex + n);
    }
}
