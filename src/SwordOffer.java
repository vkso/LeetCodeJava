import com.leetcode.tools.ListNode;

import java.util.Map;

public class SwordOffer {

    /**
     * 剑指Offer II 024. 翻转链表
     * Tips: ① 使用 stack 存放数据，弹出数据加入到新的链表中，即可翻转链表
     * ② 原地修改链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        // 原地修改，使用尾插法，从head处，重新构建一个新链表，插入的节点就是原来链表顺序遍历的节点
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ans_head = new ListNode(0, null);
        ListNode cruise = head.next;
        ListNode cruise_pre = head;

        ans_head.next = cruise_pre;
        cruise_pre.next = null;

        while (cruise.next != null) {
            cruise_pre = cruise;
            cruise = cruise.next;

            cruise_pre.next = ans_head.next;
            ans_head.next = cruise_pre;
        }

        cruise.next = ans_head.next;
        ans_head.next = cruise;
        return ans_head.next;

//       if (head == null || head.next == null) {
//           return head;
//       }
//       ListNode res_head = new ListNode(0, null);
//       ListNode cru = res_head;
//       Stack<ListNode> stack = new Stack<>();
//       while (head != null) {
//           stack.push(head);
//           head = head.next;
//       }
//       while (!stack.isEmpty()) {
//           cru.next = stack.pop();
//           cru = cru.next;
//       }
//       cru.next = null;
//       return res_head.next;
    }

    /**
     * 剑指Offer 44. 数字序列中某一位的数字
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int len = 1;
        while (len * 9 * Math.pow(10, len - 1) < n) {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }
        long s = (long) Math.pow(10, len - 1);
        long x = n / len - 1 + s;
        n -= (x - s + 1) * len;
        return n == 0 ? (int) (x % 10) : (int) ((x + 1) / Math.pow(10, len - n) % 10);
    }

    /**
     * 剑指Offer 47. 礼物的最大价值
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int cow = grid[0].length;

        int[][] dp = new int[row+1][cow+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= cow; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[row][cow];
    }
    public boolean inArea(int x, int y, int[][] grid) {
        return x < grid.length && y < grid[0].length;
    }

    /**
     * 剑指Offer 53 - II 0~1 中缺失的数字
     * Tips: [0, 1, 2]   缺失的是3，n = 4， 0~n-1 = 0, 1, 2, 3
     *
     * @param nums
     * @return
     */
    public int missingNumber_swardOffer(int[] nums) {
        int n = nums.length + 1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n - 1;
    }
}
