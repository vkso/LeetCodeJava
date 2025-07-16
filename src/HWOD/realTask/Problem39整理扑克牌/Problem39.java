package HWOD.realTask.Problem39整理扑克牌;

import java.util.*;

public class Problem39 {
    /**
     * 整理扑克牌
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = array.length;

        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
        // [A, B, C, D, E, F, G, H, I, J,  K,  L,  M]
        int[] count = new int[13];

        // 统计每张牌的数量
        for (int poker : array) {
            count[poker - 1]++;
        }

        String[] pokers = new String[n];
        // 将数字数组，转换成大写字母表，方便后面进行牌组顺序比较
        for (int i = 0; i < n; i++) {
            pokers[i] = mapToAlphabet(array[i]);
        }

        PriorityQueue<String> zhadan = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<String> sanzhang = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<String> duizi = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<String> danzhang = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        PriorityQueue<String> hulu = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < 13; i++) {
            int nums = count[i];
            char poker = (char) ('A' + i);
            combinePoker(poker, nums, zhadan, sanzhang, duizi, danzhang);
        }

        // 拼凑葫芦牌型
        while (sanzhang.size() > 1) {
            String first = sanzhang.poll();
            String second = sanzhang.poll();

            String newType = first + second.substring(0, 2);
            hulu.offer(newType);

            danzhang.offer(String.valueOf(second.charAt(2)));
        }

        StringBuilder res = new StringBuilder();

        while (!zhadan.isEmpty()) {
            String poll = zhadan.poll();
            res.append(poll);
        }

        while (!hulu.isEmpty()) {
            res.append(hulu.poll());
        }

        while (!sanzhang.isEmpty()) {
            res.append(sanzhang.poll());
        }

        while (!duizi.isEmpty()) {
            res.append(duizi.poll());
        }

        while (!danzhang.isEmpty()) {
            res.append(danzhang.poll());
        }

        ArrayList<String> pokersInt = new ArrayList<>();

        for (int i = 0; i < res.length(); i++) {
            char ch = res.charAt(i);
            pokersInt.add(String.valueOf(ch - 'A' + 1));
        }

        System.out.println(String.join(" ", pokersInt));
    }

    /**
     * 组合牌型，根据数量，将可以组成的牌型，添加到参数 list 中
     * @param nums
     * @return
     */
    public static void combinePoker(char poker, int nums, PriorityQueue<String> zhadan, PriorityQueue<String> sanzhang,
                                      PriorityQueue<String> duizi, PriorityQueue<String> danzhang) {

        int whole = nums / 4;
        int res = nums % 4;

        for (int i = 0; i < whole; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(poker).append(poker).append(poker).append(poker);
            zhadan.add(sb.toString());
        }

        StringBuilder sb = new StringBuilder();

        switch (res) {
            case 0:
                break;
            case 1:
                sb.append(poker);
                danzhang.add(sb.toString());
                break;
            case 2:
                sb.append(poker).append(poker);
                duizi.add(sb.toString());
                break;
            case 3:
                sb.append(poker).append(poker).append(poker);
                sanzhang.add(sb.toString());
                break;
        }
    }

    /**
     * 将传递的数字值，转换成大写字母表 [A, M] => [1, 13]
     * @param poker
     * @return
     */
    public static String mapToAlphabet(int poker) {
        for (int i = 1; i <= 13; i++) {
            if (i == poker) {
                return String.valueOf('A' - 1 + i);
            }
        }
        return "";
    }
}
