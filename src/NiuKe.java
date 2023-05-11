import com.leetcode.tools.ListNode;
import org.junit.Test;

import java.util.HashMap;

public class NiuKe {
    /**
     * BM 1 反转链表
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        ListNode temp = null;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = temp;
        }
        cur.next = newHead.next;
        newHead.next = cur;
        return newHead.next;
    }

    /**
     * BM 2 链表内指定区间反转
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode res = pre;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode tail = pre.next;
        for (int j = 0; j < n - m; j++) {
            tail = tail.next;
        }
        pre.next = tail.next;

        for (int k = 0; k < n - m + 1; k++) {
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }

        return res.next;
    }

    /**
     * BM 50 两数之和
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i + 1};
            } else {
                map.put(num, i + 1);
            }
        }
        return new int[]{0, 0};
    }

    /**
     * BM 51 数组中出现次数超过一半的数字
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int halfLen = array.length / 2;
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            Integer integer = map.get(i);
            if (integer > halfLen) {
                return i;
            }
        }
        return 0;
    }

    /**
     * BM 83 字符串变形
     * @param s
     * @param n
     * @return
     */
    public String trans(String s, int n) {
        int tailBlankCount = 0;
        int tail = n - 1;
        while (tail >= 0 && s.charAt(tail) == ' ') {
            tailBlankCount++;
            tail--;
        }

        String[] split = s.split(" ");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < tailBlankCount; i++) {
            ans.append(" ");
        }

        for (int i = split.length - 1; i >= 0; i--) {
            StringBuilder reverse = new StringBuilder(split[i]);
            ans.append(reverse).append(" ");
        }

        for (int i = 0; i < ans.length() - 1; i++) {
            char ch = ans.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch >= 97) {  // 如果当前字符是小写字母
                ans.setCharAt(i, (char)(ch - 32));
            } else {
                ans.setCharAt(i, (char)(ch + 32));
            }
        }
        return ans.substring(0, n);
    }

    /**
     * BM 84 最长公共前缀
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public String longestCommonPrefix (String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int rows = strs.length;
        int cols = strs[0].length();

        for (int i = 0; i < cols; i++) {
            char firstChar = strs[0].charAt(i);
            for (int j = 1; j < rows; j++) {
                if (strs[j].length() == i || strs[j].charAt(i) != firstChar) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


//    /**
//     * BM 85 验证IP地址
//     * @param IP string字符串 一个IP地址字符串
//     * @return string字符串
//     */
//    public String solve (String IP) {
//        String ipv4Re = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
//    }

    @Test
    public void testIntegerCache() {
        int a = 129;
        int b = 129;
        System.out.println(a == b);
    }

}