import java.util.*;

public class Printer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入括号的数量: ");
        int n = scanner.nextInt();

        char[] strings = new char[n * 2];
        List<String> result = new ArrayList<>();
        generateAll(strings, 0, result);
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("合法的序列一共有：" + result.size());
    }

    public static void generateAll(char[] current, int index, List<String> result) {
        if (index == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[index] = '(';
            generateAll(current, index + 1, result);
            current[index] = ')';
            generateAll(current, index + 1, result);
            current[index] = '{';
            generateAll(current, index + 1, result);
            current[index] = '}';
            generateAll(current, index + 1, result);
        }
    }

    public static boolean valid(char[] current) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : current) {
            if (c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() < 1) {
                    return false;
                }
                char pop = stack.pop();
                if (c == ')' && pop != '(' || c == '}' && pop != '{') {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
