package HWOD.Problem41字符串分割;

import java.util.Scanner;

public class Problem41 {
    /**
     * 字符串分割
     *
     * K
     * 非空字符串 S = 12abc-abCABc-4ab@
     *
     * - 分割的字符串，除了第一个外
     *
     * 其余的每 k 个字符组成一个车新的淄川，并用 - 分割
     * 1. 如果 小写字母 > 大写字母，将子串所有大写字母转换为小写字母
     * 2. 如果 小写字母 < 大写字母，将小写字母转换为大写字母
     * 3. 如果         =       不转换
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = Integer.parseInt(sc.nextLine());

        String[] split = sc.nextLine().split("-");

        StringBuilder header = new StringBuilder().append(split[0]);
        StringBuilder tail = new StringBuilder();

        for (int i = 1; i < split.length; i++) {
            tail.append(split[i]);
        }

        for (int i = 0; i < tail.length(); i += K) {

            header.append("-");

            int start = i;
            int end = Math.min(start + K, tail.length());

            String substring = tail.substring(start, end);

            int status = strIsLowerMoreThanUpper(substring);

            if (status == 1) {
                substring = substring.toLowerCase();
            } else if (status == -1) {
                substring = substring.toUpperCase();
            }

            header.append(substring);
        }

        System.out.println(header);
    }

    /**
     * 小写字母数量 > 大写字母数量，如果是真，返回 1
     * 小写字母数量 = 大写字母数量，如果是真，返回 0
     * 小写字母数量 < 大写字母数量，如果是真，返回 -1
     * @param str
     * @return
     */
    public static int strIsLowerMoreThanUpper(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }

        int lowerCount = 0;
        int upperCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowerCount++;
            } else if (ch >= 'A' && ch <= 'Z') {
                upperCount++;
            }
        }

        if (lowerCount > upperCount) {
            return 1;
        }

        if (lowerCount == upperCount) {
            return 0;
        }

        return -1;
    }
}
