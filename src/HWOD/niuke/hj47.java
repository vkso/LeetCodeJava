package HWOD.niuke;

import java.util.Arrays;
import java.util.Scanner;

public class hj47 {

    static class XNode {
        int value;
        XNode next;

        public XNode(int value, XNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = array[0];  // 节点总数
        int h = array[1];  // 头节点的值
        int k = array[array.length - 1];

        XNode head = new XNode(h, null);

        // 读取剩余需要插入节点的位置，对链表进行插入操作
        for (int i = 2; i < array.length - 2; i += 2) {
            // 在值为 b 的节点后面插入值为 a 的节点
            insert(head, array[i + 1], array[i]);
        }

        delete(head, k);

        XNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
    }

    public static void insert(XNode head, int valueB, int valueA) {
        XNode nodeB = head;

        while (nodeB.value != valueB) {
            nodeB = nodeB.next;
        }

        XNode nodeA = new XNode(valueA, null);

        XNode next = nodeB.next;
        nodeB.next = nodeA;
        nodeA.next = next;
    }

    public static void delete(XNode head, int k) {
        XNode cur = head;
        XNode pre = null;

        while (cur.value != k) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
    }
}
