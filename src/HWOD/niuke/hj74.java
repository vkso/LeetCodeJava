package HWOD.niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class hj74 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> result = new ArrayList<>();
        int len = input.length();
        StringBuilder current = new StringBuilder();
        boolean inQuote = false;

        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            if (ch == '"') {
                inQuote = !inQuote; // 引号开始或结束
            } else if (ch == ' ' && !inQuote) {
                if (current.length() > 0) {
                    result.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(ch);
            }
        }

        // 最后一个参数加进来
        if (current.length() > 0) {
            result.add(current.toString());
        }

        // 输出
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
