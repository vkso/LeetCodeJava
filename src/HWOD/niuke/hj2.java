package HWOD.niuke;

import java.util.HashMap;
import java.util.Scanner;

public class hj2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String obj = sc.nextLine();
        char objCh = obj.charAt(0);

        char[] charArray = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : charArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;

        if (Character.isDigit(objCh)) {
            ans = map.get(objCh);
        } else {
            ans += map.getOrDefault(obj.toUpperCase().charAt(0), 0);
            ans += map.getOrDefault(obj.toLowerCase().charAt(0), 0);
        }

        System.out.println(ans);
    }
}
