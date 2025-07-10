package hwod;

import java.util.*;
import java.util.stream.Collectors;

public class Problem15 {
    /**
     * 模拟消息队列
     *
     * (2, 22) (1, 11) (4, 44) (5, 55) (3, 33)
     * (1, 11) (2, 22) (3, 33) (4, 44) (5, 55)
     *
     * (1 7) (2, 3)
     *
     * 11 33 44 55
     * 22
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] message = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] consumer = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayList<int[]> messageList = new ArrayList<>();
        for (int i = 0; i < message.length; i += 2) {
            messageList.add(new int[] {message[i], message[i + 1]});
        }

        ArrayList<int[]> consumerList = new ArrayList<>();
        for (int i = 0; i < consumer.length; i += 2) {
            consumerList.add(new int[] {consumer[i], consumer[i + 1]});
        }

        messageList.sort((a, b) -> {
            return a[0] - b[0];
        });

        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < consumerList.size(); i++) {
            ArrayList<Integer> recv = new ArrayList<>();
            recv.add(-1);
            lists.add(recv);
        }

        for (int i = 0; i < messageList.size(); i++) {
            int[] send = messageList.get(i);
            for (int j = consumerList.size() - 1; j >= 0; j--) {
                int[] user = consumerList.get(j);

                if (send[0] >= user[0] && send[0] < user[1]) {
                    lists.get(j).add(send[1]);
                    break;
                }
            }
        }

        for (List<Integer> list : lists) {
            if (list.size() > 1) {
                list.remove(0);
            }

            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + (i < list.size() - 1 ? " " : "\n"));
            }
        }
    }
}
