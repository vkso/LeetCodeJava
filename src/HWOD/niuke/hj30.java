package HWOD.niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class hj30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");

        String s = split[0];
        String t = split[1];

        String combine = s + t;

        ArrayList<Character> jishu = new ArrayList<>();
        ArrayList<Character> oushu = new ArrayList<>();

        // 下标从 0 开始，奇偶是相反的
        for (int i = 0; i < combine.length(); i++) {
            char ch = combine.charAt(i);
            if (i % 2 == 0) {
                jishu.add(ch);
            } else {
                oushu.add(ch);
            }
        }

        jishu.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });

        oushu.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });

        StringBuilder newStr = new StringBuilder();

        int curIndex = 0;
        while (curIndex < jishu.size() && curIndex < oushu.size()) {
            newStr.append(jishu.get(curIndex));
            newStr.append(oushu.get(curIndex));
            curIndex++;
        }

        if (curIndex < jishu.size()) {
            newStr.append(jishu.get(curIndex));
        }

        if (curIndex < oushu.size()) {
            newStr.append(oushu.get(curIndex));
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < newStr.length(); i++) {
            char ch = newStr.charAt(i);

            if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) {
                res.append(ch);
                continue;
            }

            int num;

            String numValue = String.valueOf(ch);
            if (ch >= '0' && ch <= '9') {
                num = Integer.parseInt(numValue);
            } else {
                num = Integer.parseInt(numValue, 16);
            }

            String binaryString = Integer.toBinaryString(num);
            while (binaryString.length() < 4) {
                binaryString = '0' + binaryString;
            }

            StringBuilder reverse = new StringBuilder(binaryString).reverse();

            int resvalue10 = Integer.parseInt(reverse.toString(), 2);
            String upperCase = Integer.toHexString(resvalue10).toUpperCase();

            res.append(upperCase);
        }

        System.out.println(res);
    }
}
