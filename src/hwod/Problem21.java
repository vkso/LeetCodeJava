package hwod;

import java.util.*;

public class Problem21 {
    /**
     * VLAN资源池
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int target = sc.nextInt();

        ArrayList<Integer> pools = new ArrayList<>();

        for (String cur : split) {
            if (cur.contains("-")) {
                String[] vlanRange = cur.split("-");

                int left = Integer.parseInt(vlanRange[0]);
                int right = Integer.parseInt(vlanRange[1]);

                for (int i = left; i <= right; i++) {
                    if (i != target) {
                        pools.add(i);
                    }
                }

            } else {
                int curVlanId = Integer.parseInt(cur);
                if (curVlanId != target) {
                    pools.add(curVlanId);
                }
            }
        }

        // 处理空列表的情况
        if (pools.isEmpty()) {
            System.out.println("");
            return;
        }

        pools.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

//        Collections.sort(pools);

        ArrayList<String> resultParts = new ArrayList<>();
        int start = pools.get(0);
        int prev = start;

        for (int i = 1; i < pools.size(); i++) {
            int current = pools.get(i);
            // 检查是否连续
            if (current != prev + 1) {  // 如果不连续，添加区间
                if (start == prev) {  // 如果开始区间，等于 prev，就一个节点，直接添加单独的一个数字区间
                    resultParts.add(String.valueOf(start));
                } else {
                    resultParts.add(start + "-" + prev);
                }
                start = current;
            }
            prev = current;
        }

        // 处理最后一段区间
        if (start == prev) {
            resultParts.add(String.valueOf(start));
        } else {
            resultParts.add(start + "-" + prev);
        }

        System.out.println(String.join(",", resultParts));
    }
}
