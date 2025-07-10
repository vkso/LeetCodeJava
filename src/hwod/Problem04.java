package hwod;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem04 {
    /**
     * 字符串解密
     *
     * 给定两个字符串string1和string2。
     * string1是一个被加扰的字符串。
     * string1由小写英文字母（’a’~ ’z’）和数字字符（’0’~ ’9’）组成
     * 而加扰字符串由’0’~ ’9’、’a’~’f’组成。
     *
     * string1里面可能包含0个或多个加扰子串，剩下可能有0个或多个有效子串，这些有效子串被加扰子串隔开。
     *
     * string2是一个参考字符串，仅由小写英文字母（’a’~’z’）组成。
     *
     * 你需要在string1字符串里找到一个有效子串，这个有效子串要同时满足下面两个条件：
     * （1）这个有效子串里不同字母的数量不超过且最接近于string2里不同字母的数量，即小于或等于string2里不同字母的数量的同时且最大。
     * （2）这个有效子串是满足条件（1）里的所有子串（如果有多个的话）里字典序最大的一个。
     *
     * 如果没有找到合适条件的子串的话，请输出”Not Found”
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(findSub(s1, s2));
    }

    public static String findSub(String s1, String s2) {
        String[] validParts = s1.split("[0-9a-f]+");
        int targetCount = uniqueCount(s2);

        String result = "Not Found";
        int maxUnique = 0;

        for (String part : validParts) {
            if (!part.isEmpty()) {
                // 计算当前字符串的字符种类数
                int uniqueInPart = uniqueCount(part);

                // 如果当前串满足种类限制
                if (uniqueInPart <= targetCount) {
                    // 只要上面的 if 满足条件，那么 result 一定会更新，这是下面 if 的第一个或条件保证的
                    // 同时，如果当前的串最大不同字符数量 == 的情况下，对字典序高的，进行更新
                    if (uniqueInPart > maxUnique || (uniqueInPart == maxUnique && part.compareTo(result) > 0)) {
                        result = part;
                        maxUnique = uniqueInPart;  // 更新最大字符种类数
                    }
                }
            }
        }

        return result;
    }

    private static int uniqueCount(String s) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char ch : s.toCharArray()) {
            uniqueChars.add(ch);
        }
        return uniqueChars.size();
    }
}
