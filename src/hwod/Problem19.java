package hwod;

import org.junit.Test;

import java.util.*;

public class Problem19 {

    static class People {
        int total;
        int firstDay;
        int id;

        public People(int total, int firstDay, int id) {
            this.total = total;
            this.firstDay = firstDay;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> dayCountList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            dayCountList.add(sc.nextInt());
        }

        PriorityQueue<People> pq = new PriorityQueue<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.total - o2.total > 0) {
                    return -1;
                }
                if (o1.total - o2.total == 0 && o1.firstDay - o2.firstDay > 0) {
                    return 1;
                }
                if (o1.id - o2.id > 0) {
                    return 1;
                }
                return 0;
            }
        });

        HashMap<Integer, People> integerPeopleHashMap = new HashMap<>();

        for (int i = 0; i < 30; i++) {
            Integer dayPeoples = dayCountList.get(i);

            for (int j = 0; j < dayPeoples; j++) {
                int curId = sc.nextInt();

                if (integerPeopleHashMap.containsKey(curId)) {
                    People people = integerPeopleHashMap.get(curId);
                    people.total++;
                } else {
                    integerPeopleHashMap.put(curId, new People(0, i, curId));
                }
            }
        }

        for (Integer i : integerPeopleHashMap.keySet()) {
            pq.offer(integerPeopleHashMap.get(i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5 && !pq.isEmpty(); i++) {
            sb.append(pq.poll().id).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
