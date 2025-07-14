package HWOD.Problem43最大数字;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Problem43 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(maxNumberWithAtMostTwo(s));

    }

    private static String maxNumberWithAtMostTwo(String s) {

        int n = s.length();

        // 剩余数字的数量
        int[] rem = new int[10];

        // 当前栈中已经使用数字的数量
        int[] used = new int[10];

        // 统计全部的数字数量
        for (char ch : s.toCharArray()) {
            rem[ch - '0']++;
        }

        // 单调栈，用于存放字符
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            int d = ch - '0';

            // 首先消耗一次次数
            rem[d]--;

            // 因为是从左向右遍历，如果左边的位置已经按照单调栈特性填满了这个数字 d，那么后面即使再出现，也不需要
            // 再考虑了，可以认为是重复元素，直接丢弃即可
            if (used[d] == 2) {
                continue;
            }

            // 贪心：在满足还能补回两次的前提下，弹出比当前小的栈顶元素
            while (!stack.isEmpty()) {
                char top = stack.peek();
                int td = top - '0';

                // 如果栈顶 < 当前，并且弹出后，还可能在后面补回两次
                if (td < d && used[td] - 1 + rem[td] >= 2) {
                    stack.pop();
                    used[td]--;
                } else {
                    break;
                }
            }

            stack.push(ch);
            used[d]++;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }


}


















