import com.leetcode.tools.ListNode;
import com.leetcode.tools.MyLinkedList;
import com.leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;
import com.leetcode.tools.ListNode;

import java.util.*;
// https://leetcode.cn/problemset/algorithms/?difficulty=EASY&page=3
@SuppressWarnings("all")
public class Solution {
    @Test
    public void Test() {
        String s = "(name)is(age)yearsold";
        List<List<String>> arrayLists = new ArrayList<>();

        List<String> str1 = new ArrayList<>();
        List<String> str2 = new ArrayList<>();
        str1.add("name");
        str1.add("bob");
        str2.add("age");
        str2.add("two");
        arrayLists.add(str1);
        arrayLists.add(str2);

        System.out.println(evaluate(s, arrayLists));

    }

    /**
     * No.1 两数之和：HashMap
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int value_tmp;

        hashMap.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            value_tmp = target - nums[i];
            if (hashMap.containsKey(value_tmp)) {
                res[0] = i;
                res[1] = hashMap.get(value_tmp);
                return res;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return res;
    }

    /**
     * No. 2 两数相加（链表）
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode head_move = head;
        ListNode move_l1 = l1;
        ListNode move_l2 = l2;

        int push_up = 0;
        int mod_result = 0;
        int sum = 0;

        while (move_l1 != null && move_l2 != null) {
            sum = move_l1.val + move_l2.val + push_up;
            push_up = 0;
            if (sum > 9) {
                push_up = 1;
                mod_result = sum % 10;

                head_move.next = new ListNode(mod_result);
                head_move = head_move.next;

                move_l1 = move_l1.next;
                move_l2 = move_l2.next;
            } else {
                head_move.next = new ListNode(sum);
                head_move = head_move.next;

                move_l1 = move_l1.next;
                move_l2 = move_l2.next;
            }
        }

        while (move_l1 != null) {
            sum = move_l1.val + push_up;
            push_up = 0;
            if (sum > 9) {
                push_up = 1;
                mod_result = sum % 10;
                head_move.next = new ListNode(mod_result);
                head_move = head_move.next;
                move_l1 = move_l1.next;
            } else {
                head_move.next = new ListNode(sum);
                head_move = head_move.next;
                move_l1 = move_l1.next;
            }
        }

        while (move_l2 != null) {
            sum = move_l2.val + push_up;
            push_up = 0;
            if (sum > 9) {
                push_up = 1;
                mod_result = sum % 10;
                head_move.next = new ListNode(mod_result);
                head_move = head_move.next;
                move_l2 = move_l2.next;
            } else {
                head_move.next = new ListNode(sum);
                head_move = head_move.next;
                move_l2 = move_l2.next;
            }
        }

        if (push_up == 1) {
            head_move.next = new ListNode(1);
            head_move = head_move.next;
        }

        return head.next;
    }

    public ListNode addTwoNumbersa(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode head_move = head;
        ListNode move_l1 = l1;
        ListNode move_l2 = l2;

        int push_up = 0;
        int mod_result = 0;
        int sum = 0;

        while (move_l1 != null || move_l2 != null) {
            int x = (move_l1 == null ? 0 : move_l1.val);
            int y = (move_l2 == null ? 0 : move_l2.val);
            sum = x + y + push_up;

            push_up = sum / 10;
            mod_result = sum % 10;

            head_move.next = new ListNode(mod_result);
            head_move = head_move.next;

            if (move_l1 != null) {
                move_l1 = move_l1.next;
            }
            if (move_l2 != null) {
                move_l2 = move_l2.next;
            }
        }
        if (push_up == 1) {
            head_move.next = new ListNode(1);
        }
        return head.next;
    }

    /**
     * No. 21 合并两个有序链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode move = head;
        ListNode l1 = list1;
        ListNode l2 = list2;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                move.next = l1;
                l1 = l1.next;
            } else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }

        while (l1 != null) {
            move.next = l1;
            l1 = l1.next;
            move = move.next;
        }

        while (l2 != null) {
            move.next = l2;
            l2 = l2.next;
            move = move.next;
        }

        return head.next;
    }

    /**
     * No. 35 搜索插入位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        int mid;

        while (left + 1 != right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    /**
     * No. 125 验证回文串
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        StringBuilder res = new StringBuilder();
        String lowerStr = s.toLowerCase();
        char tmp_ch;

        for (int i = 0; i < lowerStr.length(); i++) {
            tmp_ch = lowerStr.charAt(i);
            if ((tmp_ch >= 'a' && tmp_ch <= 'z') || (tmp_ch >= '0' && tmp_ch <= '9')) {
                res.append(tmp_ch);
            }
        }

        if (res.length() == 0) {
            return true;
        }

        int left = 0;
        int right = res.length() - 1;

        while (left < right) {
            if (res.charAt(left) == res.charAt(right)) {
                ++left;
                --right;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * No. 171 Excel表序列号
     * <p>
     * 这里，直接按照26进制，从头开始计算更方便：
     * sum = sum * 26 + (s.charAt(index) - 'A' + 1);
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int index = 0;
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum = sum + (int) Math.pow(26.0, i)
                    * (columnTitle.charAt(index++) - 64);
        }
        return sum;
    }

    /**
     * No. 190 颠倒二进制位
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;  // 无符号右移位，高位补0
        }
        return rev;
    }

    /**
     * No. 191 位1的个数
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                ++count;
            }
            n >>>= 1;
        }
        return count;
    }

    /**
     * No. 202 快乐数
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (true) {
            if (!hashSet.contains(n)) {
                hashSet.add(n);
                n = sumEverDigit(n);
                if (n == 1) {
                    break;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * No. 205 同构字符串
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap_s2t = new HashMap();
        HashMap<Character, Character> hashMap_t2s = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);

            if (hashMap_s2t.containsKey(ch_s) && hashMap_s2t.get(ch_s) != ch_t || hashMap_t2s.containsKey(ch_t) && hashMap_t2s.get(ch_t) != ch_s) {
                return false;
            }
            hashMap_s2t.put(ch_s, ch_t);
            hashMap_t2s.put(ch_t, ch_s);
        }
        return true;
    }

    /**
     * No. 228 汇总区间
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        String tmp;

        if (nums.length == 1) {
            tmp = new String(Integer.toString(nums[0]));
            res.add(tmp);
            return res;
        }

        int left = 0;
        int right_pre = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[right] - nums[right_pre] == 1) {
                ++right_pre;
                ++right;
            } else {
                if (left == right_pre) {
                    tmp = new String(Integer.toString(nums[left]));
                } else {
                    tmp = new String(Integer.toString(nums[left]) +
                            "->" + Integer.toString(nums[right_pre]));
                }
                res.add(tmp);
                left = right;
                ++right;
                ++right_pre;
            }
        }

        if (left == right_pre) {
            tmp = new String(Integer.toString(nums[left]));
        } else {
            tmp = new String(Integer.toString(nums[left]) +
                    "->" + Integer.toString(nums[right_pre]));
        }
        res.add(tmp);
        return res;
    }

    /**
     * No. 231 2的幂
     * 判断一个数是不是2的幂
     * 技巧：n & (n-1) 可以移除一个二进制数末位的1，2的幂次数，只有一个1，所以会被置0
     * return n > 0 && (n & (n - 1)) == 0;
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
            n = n >> 1;
        }
        return true;
    }

    /**
     * No. 242 有效的字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ++alphabet[s.charAt(i) - 'a'];
        }

        for (int i = 0; i < t.length(); i++) {
            if (--alphabet[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * No. 257 二叉树的所有路径
     * 本题BFS、DFS两种算法均可以取得效果其实现细节，稍有不同。
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<Object> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root.val + "");

        while (!queue.isEmpty()) {
            // 每次出栈都会记录当栈节点已经走过的路径，和当前栈的值
            TreeNode node = (TreeNode) queue.poll();
            String path = (String) queue.poll();

            // 如果当前节点是叶子节点，那么这就是一条完整路径，可以加入到返回值中
            if (node.left == null && node.right == null) {
                res.add(path);
            }

            // 每次进栈，都会记录当前节点已经走过的路径，并追加当前节点的路径
            if (node.right != null) {
                queue.add(node.right);
                queue.add(path + "->" + node.right.val);
            }

            if (node.left != null) {
                queue.add(node.left);
                queue.add(path + "->" + node.left.val);
            }
        }
        return res;
    }

    // 递归写法
    // 如果知道了左子树和右子树的所有路径，那么添加一个root节点，root节点到左右
    // 子树的路径就是全部路径（遍历添加），递归可以使用这种思想
    public List<String> binaryTreePathsRec(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }

        // 遍历左子节点的路径
        for (String path : binaryTreePathsRec(root.left)) {
            res.add(root.val + "->" + path);
        }
        // 遍历右子节点的路径
        for (String path : binaryTreePathsRec(root.right)) {
            res.add(root.val + "->" + path);
        }

        return res;
    }

    /**
     * No. 258 各位相加
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        while (num >= 10) {
            num = sumDigits(num);
        }
        return num;
    }

    public int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    /**
     * No. 268 丢失的数字
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int[] count = new int[nums.length + 1];
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = 1;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                ans = i;
            }
        }
        return ans;
    }

    public int sumEverDigit(int n) {
        int res = 0;
        while (n > 0) {
            res = res + (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }

    /**
     * No. 292 Nim游戏
     * 如果你先手，n是4的倍数，必输。可以反向推理一下
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    /**
     * No. 345 翻转字符串中的元音字母
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder str = new StringBuilder(s);
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        char exchange;

        while (true) {
            while (!set.contains(str.charAt(left)) && left < s.length() - 1) {
                left++;
            }
            while (!set.contains(str.charAt(right)) && right > 0) {
                right--;
            }
            if (left < right) {
                exchange = str.charAt(left);
                str.setCharAt(left, str.charAt(right));
                str.setCharAt(right, exchange);
                ++left;
                --right;
            } else {
                break;
            }
        }
        return str.toString();
    }

    /**
     * No. 459 重复的子字符串
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        char headChar = s.charAt(0);
        StringBuilder subStr = null;
        StringBuilder res = null;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == headChar) {
                subStr = new StringBuilder(s.substring(0, i));
                res = new StringBuilder(subStr);

                for (int j = 0; j < (s.length() / i) - 1; j++) {
                    res.append(subStr);
                }

                if (s.equals(new String(res))) {
                    return true;
                } else {
                    res = null;
                    subStr = null;
                }
            }
        }
        return false;
    }

    /**
     * No. 482 密钥格式化
     *
     * @param s
     * @param k
     * @return
     */
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                res.append(s.charAt(i));
            }
        }

        int chs_count = 0;
        //   0 1   2 3 4 5   6 7 8 9
        //   a b - c d e f - g h i j
        for (int i = res.length() - 1; i > 0; --i) {
            chs_count++;
            if (chs_count % k == 0) {
                res.insert(i, '-');
                chs_count = 0;
            }
        }
        return res.toString().toUpperCase();
    }

    /**
     * No. 485 最大连续1的个数
     *     1. 将数组转换成字符串，使用split方法，按照0分割，统计最长字符串的长度
     *        该方法，思路清晰，执行时间比较长 oj=15ms
     *
     *         StringBuilder sb = new StringBuilder();
     *         for (int i = 0; i < nums.length; i++) {
     *             sb.append(Integer.toString(nums[i]));
     *         }
     *
     *         String x = sb.toString();
     *         String[] split = x.split("0");
     *
     *         int res = 0;
     *         for (String s : split) {
     *             if (s.length() > res) {
     *                 res = s.length();
     *             }
     *         }
     *         return res;
     *
     *     2. 滑动窗口的方法，统计全 1 窗口的长度，tips：由于是int类型的数组，可以
     *        利用sum直接计算即可，sum的最大值就是返回结果
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = sum > max ? sum : max;
                sum = 0;
            } else {
                sum ++;
            }
        }
        max = sum > max ? sum : max;
        return max;
    }

    /**
     * No. 496 下一个更大的元素 I
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int exist;
        for (int i = 0; i < nums1.length; i++) {
            exist = -1;
            int j = 0;
            while (nums2[j] != nums1[i]) {
               j++;
            }
            for (int k = j+1; k < nums2.length; k++) {
                if (nums2[k] > nums1[i]) {
                    exist = 1;
                    res[i] = nums2[k];
                    break;
                }
            }

            if (exist == -1) {
                res[i] = -1;
            }
        }
        return res;
    }

    /**
     * No. 1711 大餐计数
     *
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = (int) 1e9 + 7;
        int max = 1 << 22;
        int ans = 0;
        for (int x : deliciousness) {
            // 遍历可能是2的幂次数的值，匹配map中是否存在
            for (int i = 1; i < max; i <<= 1) {
                int t = i - x;
                if (map.containsKey(t)) {
                    ans += map.get(t);
                    if (ans >= mod) {
                        ans -= mod;
                    }
                }
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return ans;
    }

    // 判断一个数是不是2的幂次数
    public boolean isTwoPow(int n) {
        if (n == 0) {
            return false;
        }
        int count = 0;

        while (n > 0) {
            if (n % 2 == 1) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
            n = n >> 1;
        }
        return true;
    }

    /**
     * No. 1807 替换字符串中的括号内容
     * @param s
     * @param knowledge
     * @return
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hashmap = new HashMap<>();
        int right;
        String compare;

        for (int i = 0; i < knowledge.size(); i++) {
            hashmap.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '(') {
                sb.append(ch);
            } else {
                right = i + 1;
                while (s.charAt(right) != ')') {
                    ++right;
                }
                compare = s.substring(i + 1, right);
                if (hashmap.containsKey(compare)) {
                    sb.append(hashmap.get(compare));
                } else {
                    sb.append("?");
                }
                // 右括号赋值给i之后，循环结束，执行+1操作
                i = right;
            }
        }
        return sb.toString();
    }

    /**
     * No. 2022 将一维数组转变成二维数组
     *
     * @param original
     * @param m
     * @param n
     * @return
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] res = new int[m][n];
        int row = 0;
        int cow = 0;

        for (int i = 0; i < original.length; i++) {
            res[row][cow++] = original[i];
            if (cow == n) {
                row++;
                cow = 0;
            }
        }

        return res;
    }

    /**
     * No. 2042 检查句子中的数字是否递增
     *
     * @param s
     * @return
     */
    public boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        int left = 0, right = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) >= '0' && words[i].charAt(0) <= '9') {
                left = right;
                right = Integer.parseInt(words[i]);
                if (right <= left) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * No. 2180 统计各位数字之和为偶数的整数个数
     *
     * @return
     */
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (judgeEven(i)) {
                ++count;
            }
        }
        return count;
    }

    //统计一个数所有位数相加的结果是否位偶数
    public boolean judgeEven(int num) {
        // num 是正整数
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        if (sum % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * No. 2185 统计包含给定前缀的字符串
     *
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String str : words) {
            if (str.startsWith(pref)) {
                ++count;
            }
        }
        return count;
    }

    /**
     * No. 2283 判断一个数的数字计数是否等于数位的值
     * @param num
     * @return
     */
    public boolean digitCount(String num) {
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i) - '0']++;
        }

        for (int i = 0; i < num.length(); i++) {
            int tmp = num.charAt(i) - '0';
            if (count[i] != tmp) {
                return false;
            }
        }

        return true;
    }

    /**
     * No. 2351 第一个出现两次的字母
     *
     * @param s
     * @return
     */
    public char repeatedCharacter(String s) {
        int[] charCount = new int[26];
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (charCount[ch - 97] == 0) {
                charCount[ch - 97]++;
            } else {
                return ch;
            }
        }
        return ' ';
    }
}
