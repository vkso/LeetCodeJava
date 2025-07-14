package HWOD.Problem32热点网站统计;

import java.util.*;

public class Problem32 {
    /**
     * 热点网站统计
     */

    static Map<String, Integer> urlCount = new TreeMap<>();
    static PriorityQueue<Map.Entry<String, Integer>> pq;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String input = sc.nextLine();

            // 判断 input 是不是数字
            if (isNumeric(input)) {
                int n = Integer.parseInt(input);
                System.out.println(getTopN(n));
            } else {
                urlCount.put(input, urlCount.getOrDefault(input, 0) + 1);
            }

        }

    }

    public static String getTopN(int n) {

        pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (!o1.getValue().equals(o2.getValue())) {
                    return o2.getValue().compareTo(o1.getValue());
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        pq.addAll(urlCount.entrySet());

        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            res.add(pq.poll().getKey());
        }

        return String.join(",", res);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
