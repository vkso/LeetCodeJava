package HWOD.Problem16生成哈夫曼树;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem16 {
    /**
     * 生成哈夫曼树
     */
    static class Node {
        int value;
        Node left;
        Node right;
        int height;  // 节点高度，用于处理相等权值的情况

        public Node(int v) {
            this.value = v;
            this.left = null;
            this.right = null;
            height = 0;
        }
    }


    // 构建哈夫曼树
    public static Node buildHuffmanTree(ArrayList<Integer> values) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                // 首先比较节点的权值，若权值相等，比较高度
                if (a.value > b.value) {
                    return 1;
                }

                if (a.value < b.value) {
                    return -1;
                }

                if (a.height > b.height) {
                    return 1;
                }

                if (a.height < b.height) {
                    return -1;
                }
                return 0;
            }
        });

        for (Integer value : values) {
            pq.offer(new Node(value));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left.value + right.value);
            if (left.value > right.value || (left.value == right.value && left.height > right.height)) {
                Node temp = left;
                left = right;
                right = temp;
            }
            parent.left = left;
            parent.right = right;
            parent.height = Math.max(left.height, right.height) + 1;
            pq.add(parent);
        }
        // 返回优先队列中的最后一个节点，
        return pq.peek();
    }

    public static void inOrderTravel(Node root, StringBuilder result) {
        if (root == null) {
            return;
        }
        inOrderTravel(root.left, result);
        result.append(root.value).append(" ");
        inOrderTravel(root.right, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            values.add(sc.nextInt());
        }

        Node root = buildHuffmanTree(values);
        StringBuilder result = new StringBuilder();

        inOrderTravel(root, result);

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        System.out.println(result.toString());
        sc.close();
    }
}
























