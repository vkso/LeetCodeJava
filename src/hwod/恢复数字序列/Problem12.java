package hwod.恢复数字序列;

import java.util.HashMap;
import java.util.Scanner;

public class Problem12 {
    /**
     * 恢复数字序列
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split("\\s+");

        String randomChangeStr = split[0];
        int n = Integer.parseInt(split[1]);

        HashMap<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < randomChangeStr.length(); i++) {
            char ch = randomChangeStr.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        boolean isMatched = false;
        int res = -1;

        for (int i = 1; i < 1000 - n + 1; i++) {
            HashMap<Character, Integer> tmpMap = new HashMap<>();

            for (int j = i; j <  i + n; j++) {
                String string = Integer.toString(j);

                for (int k = 0; k < string.length(); k++) {
                    char ch = string.charAt(k);
                    tmpMap.put(ch, tmpMap.getOrDefault(ch, 0) + 1);
                }
            }

            isMatched = true;

            for (Character c : tmpMap.keySet()) {
                if (!tmpMap.get(c).equals(countMap.get(c))) {
                    isMatched = false;
                    break;
                }
            }

            if (isMatched) {
                res = i;
                break;
            }
        }
        System.out.println(res);
    }
}
