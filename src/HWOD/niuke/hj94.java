package HWOD.niuke;

import java.util.*;

public class hj94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> members = new ArrayList<>();

        String[] split = sc.nextLine().split(" ");

        for (String s : split) {
            map.put(s, 0);
            members.add(s);
        }

        int m = Integer.parseInt(sc.nextLine());
        int invalid = 0;

        String[] ms = sc.nextLine().split(" ");

        for (String s : ms) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                invalid++;
            }
        }

        for (String member : members) {
            System.out.println(member + " : " + map.get(member));
        }

        System.out.println("Invalid : " + invalid);
    }
}
