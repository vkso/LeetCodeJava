package HWOD.Problem37统计射击比赛成绩;

import java.util.*;

public class Problem37 {
    /**
     * 统计设计比赛成绩
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] ids = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] scores = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if (!map.containsKey(ids[i])) {
                map.put(ids[i], new ArrayList<>());
            }
        }

        for (int i = 0; i < N; i++) {
            List<Integer> integers = map.get(ids[i]);
            integers.add(scores[i]);
        }

        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            Integer key = integerListEntry.getKey();
            List<Integer> value = integerListEntry.getValue();
            value.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            if (value.size() >= 3) {
                pq.offer(new int[] {key, value.get(0) + value.get(1) + value.get(2)});
            }
        }

        ArrayList<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            res.add(String.valueOf(poll[0]));
        }

        System.out.println(String.join(",", res));
    }
}
