package HWOD.realTask.Problem54增强的str;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem54 {
    /**
     * 增强的 str
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String source = sc.nextLine();
        String target = sc.nextLine();

//        target.replaceAll("\\[(.*?)\\]", "[$1]");

        // 编译目标字符串为正则表达式模式
        Pattern pattern = Pattern.compile(target);
        // 创建匹配器，用于在源字符串中查找匹配的子字符串
        Matcher matcher = pattern.matcher(source);

        // 如果找到匹配的子字符串，则输出匹配的子字符串在源字符串中的起始位置
        if (matcher.find()) {
            System.out.println(matcher.start());
        } else {
            // 如果没有找到匹配的子字符串，则输出-1
            System.out.println(-1);
        }
    }
}
