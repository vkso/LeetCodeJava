package HWOD.niuke;

import java.util.*;

public class hj45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            System.out.println(calc(line));
        }
    }

    public static int calc(String line) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : line.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            pq.add(new int[] {(int) key, value});
        }

        int weight = 26;
        int res = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();

            res += poll[1] * weight--;
        }

        return res;
    }
}
