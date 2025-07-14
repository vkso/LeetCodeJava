package HWOD.Problem38异常的打卡记录;

import java.util.*;

public class Problem38 {
    /**
     * 异常的打卡记录（按顺序输出）
     *
     * 10000（id）, 10（时间）,1（）,ABCD（打卡号）,ABCD（注册号）
     *
     *
     * 打开异常判定：
     * 1. 打卡号与注号不一致
     * 2. 打卡时间差小于 60分钟，且地点误差超过 5 km，这两条记录都是异常的
     */

    static class ClickIn {
        int index;
        int id;
        int time;
        int distance;
        String actualDeviceNumber;
        String registeredDeviceNumber;

        public ClickIn(int index, int id, int time, int distance, String actualDeviceNumber, String registeredDeviceNumber) {
            this.index = index;
            this.id = id;
            this.time = time;
            this.distance = distance;
            this.actualDeviceNumber = actualDeviceNumber;
            this.registeredDeviceNumber = registeredDeviceNumber;
        }

        @Override
        public String toString() {
            return this.id + ","
                    + this.time + ","
                    + this.distance + ","
                    + this.actualDeviceNumber + ","
                    + this.registeredDeviceNumber;
        }

        public int getIndex() {
            return index;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }

        public int getDistance() {
            return distance;
        }

        public String getActualDeviceNumber() {
            return actualDeviceNumber;
        }

        public String getRegisteredDeviceNumber() {
            return registeredDeviceNumber;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        HashMap<Integer, List<ClickIn>> map = new HashMap<>();

        TreeSet<ClickIn> treeSet = new TreeSet<>(new Comparator<ClickIn>() {
            @Override
            public int compare(ClickIn o1, ClickIn o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });
        ArrayList<String> returnList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] split = sc.nextLine().split(",");
            int index = i;
            int id = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[1]);
            int distance = Integer.parseInt(split[2]);
            String actualDeviceNumber = split[3];
            String registeredDeviceNumber = split[4];

            ClickIn clickIn = new ClickIn(index, id, time, distance, actualDeviceNumber, registeredDeviceNumber);

            if (!actualDeviceNumber.equals(registeredDeviceNumber)) {
                treeSet.add(clickIn);
                continue;
            }

            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<ClickIn>());
            }
            map.get(id).add(clickIn);
        }

        for (Map.Entry<Integer, List<ClickIn>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<ClickIn> value = entry.getValue();

            value.sort(new Comparator<ClickIn>() {
                @Override
                public int compare(ClickIn o1, ClickIn o2) {
                    return o1.getTime() - o2.getTime();
                }
            });

            if (value.size() > 1) {
                for (int i = 1; i < value.size(); i++) {
                    ClickIn prevValue = value.get(i - 1);
                    ClickIn currentValue = value.get(i);

                    int timeABS = Math.abs(currentValue.getTime() - prevValue.getTime());
                    int disABS = Math.abs(currentValue.getDistance() - prevValue.getDistance());

                    if (timeABS < 60 && disABS > 5) {
                        treeSet.add(prevValue);
                        treeSet.add(currentValue);
                    }
                }
            }
        }

        if (treeSet.isEmpty()) {
            System.out.println("null");
        } else {
            for (ClickIn clickIn : treeSet) {
                returnList.add(clickIn.toString());
            }
            System.out.println(String.join(";", returnList));
        }
    }
}
