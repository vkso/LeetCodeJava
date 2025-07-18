package HWOD.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class hj27 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");

        // 读取字符串数量
        int n = Integer.parseInt(split[0]);

        // 将字符串存储到 list 中
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(split[i + 1]);
        }

        // 读取目标字符串
        String obj = split[n + 1];
        // 读取目标 k 值
        int k = Integer.parseInt(split[n + 2]);

        // 统计目标字符串中的字符数量
        int[] objCount = new int[24];
        for (char ch : obj.toCharArray()) {
            objCount[ch - 'a']++;
        }

        ArrayList<String> resList = new ArrayList<>();

        // 遍历待检查串
        for (String s : list) {
            int[] curCount = new int[24];
            for (char ch : s.toCharArray()) {
                curCount[ch - 'a']++;
            }

            if (s.equals(obj)) {
                continue;
            }

            boolean flag = true;

            for (int i = 0; i < 24; i++) {
                if (objCount[i] != curCount[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                resList.add(s);
            }
        }

        System.out.println(resList.size());

        resList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        if (resList.size() >= k) {
            System.out.println(resList.get(k - 1));
        }
    }
}
