package HWOD.Problem35提取字符串中最长合法简单数字表达式;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem35 {
    /**
     * 提取字符串中最长合法简单数字表达式
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static long getResult(String s) {

        String maxLenExp = getMaxLenExp(s);

        if (maxLenExp.isEmpty()) {
            return 0;
        } else {
            return calcExpStr(maxLenExp);
        }
    }

    public static String getMaxLenExp(String s) {

        Matcher matcher = Pattern.compile("((\\d+[+*-])*\\d+)").matcher(s);
        String maxLenExp = "";

        while (matcher.find()) {
            String exp = matcher.group(0);

            if (exp.length() > maxLenExp.length()) {
                maxLenExp = exp;
            }
        }
        return maxLenExp;
    }

    public static long calcExpStr(String exp) {
        exp += "+0";
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char op = '+';  // 第一个起始数字，默认是正的
        int num = 0;

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {  // 如果当前字符是个数字，需要将这个数累加到 num 中
                num = num * 10 + ch - '0';
            } else {  // 如果当前值是一个符号，那么需要对其进行计算
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else {
                    stack.push(num * stack.pop());
                }

                num = 0;
                op = ch;
            }
        }

        // 计算栈中的累计和
        long res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
