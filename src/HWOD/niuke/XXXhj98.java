package HWOD.niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class XXXhj98 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long ans = 0;
        long[] a = new long[n + 1]; //原数组
        long[] s = new long[n + 1]; //前缀和数组
        int[] c = new int[n + 1];   //正数个数前缀和
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            s[i] = a[i] + s[i - 1];
            c[i] = c[i - 1] + (a[i] > 0 ? 1 : 0);
            //map的key是从1到i元素的和，value是一个数组存前缀和相同的所有下标i
            map.computeIfAbsent(s[i], k -> new ArrayList<>()).add(i);
        }
        for (int i = n; i > 2; i--) {   //i及i后面的部分是切后第三部分
            long sum = s[n] - s[i - 1];
            if (c[n] - c[i - 1] == 0) continue;
            if (map.containsKey(sum)) {     //用第三部分的和，找第一部分右端点
                for (Integer p : map.get(sum)) {
                    if (p >= i) continue;       //第一部分右端点需要在i左边
                    if (c[p] == 0) continue;
                    if (s[i - 1] - s[p] != sum) continue;
                    if (c[i - 1] - c[p] == 0) continue;
                    ans++;
                }
            }
        }
        System.out.println(ans);
        in.close();
    }
}
