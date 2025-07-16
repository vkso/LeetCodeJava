package HWOD.realTask.Problem18英文输入法提示词;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Problem18 {
    /**
     * 英文输入法提示词
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split("[^a-zA-Z]");

        String prefix = sc.nextLine();

        TreeSet<String> treeSet = new TreeSet<>(Arrays.asList(split));

        StringBuilder res = new StringBuilder();

        for (String s : treeSet) {
            if (s.startsWith(prefix)) {
                res.append(s).append(" ");
            }
        }

        if (res.length() > 0) {
            System.out.println(res.toString().trim());
        } else {
            System.out.println(prefix);
        }
    }
}
