package HWOD.niuke;

import java.util.*;

public class hj8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < N; i++) {
            int index = scanner.nextInt();
            int value = scanner.nextInt();

            treeMap.put(index, treeMap.getOrDefault(index, 0) + value);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : treeMap.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            System.out.println(key + " " + value);
        }
    }
}
