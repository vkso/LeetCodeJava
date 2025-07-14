package HWOD.Problem31拼接URL;

import java.util.Scanner;

public class Problem31 {
    /**
     * 拼接 URL
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] split = s.split(",");

        // split.length 大于 0 的情况下，才有前缀在[0]处，否则就没有
        String front = (split.length > 0 && split[0].length() > 0) ? split[0] : "/";
        // split.length 大于 1 的情况下，才有后缀在[1]处，否则就没有
        String back = (split.length > 1 && split[1].length() > 0) ? split[1] : "/";

        System.out.println(getResult(front, back));

    }

    private static String getResult(String front, String back) {
        front = front.replaceAll("/+$", "");
        back = back.replaceAll("^/+", "");
        return front + "/" + back;
    }


}
