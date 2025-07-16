package HWOD.realTask.Problem45最长的指定瑕疵度的元音子串;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem45 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flaw = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        char[] array = s.toCharArray();
        ArrayList<Integer> edges = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (isVowel(array[i])) {
                edges.add(i);
            }
        }

        if (edges.size() < 2) {
            System.out.println(0);
        }

        int ans = 0;
        int n = edges.size();

        int l = 0, r = 0;

        while (r < n) {
            // 计算瑕疵度
            // 【此方法的精妙之处就在于一个数组的转换】外层数组的差值 - 内层数组的差值 = 瑕疵个数
            int diff = edges.get(r) - edges.get(l) - (r - l);

            if (diff > flaw) {
                l++;
            } else if (diff < flaw) {
                r++;
            } else {
                ans = Math.max(ans, edges.get(r) - edges.get(l) + 1);
                r++;
            }
        }

        System.out.println(ans);
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
