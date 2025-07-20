package HWOD.niuke;

import java.util.Scanner;
import java.util.Stack;

public class hj70 {
    static class Matrix {
        int rows, cols;

        Matrix(int r, int c) {
            this.rows = r;
            this.cols = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Matrix[] matrices = new Matrix[n];
        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            matrices[i] = new Matrix(r, c);
        }
        sc.nextLine();  // 读掉换行
        String expr = sc.nextLine();

        Stack<Matrix> stack = new Stack<>();
        int totalCost = 0;

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (ch == '(') {
                continue;
            } else if (Character.isUpperCase(ch)) {
                // 是矩阵名
                stack.push(matrices[ch - 'A']);
            } else if (ch == ')') {
                Matrix m2 = stack.pop();
                Matrix m1 = stack.pop();
                // 检查矩阵维度合法性
                if (m1.cols != m2.rows) {
                    System.out.println("error");
                    return;
                }
                totalCost += m1.rows * m1.cols * m2.cols;
                // 将乘积结果入栈
                stack.push(new Matrix(m1.rows, m2.cols));
            }
        }

        System.out.println(totalCost);
    }
}
