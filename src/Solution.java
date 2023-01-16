import com.leetcode.tools.ListNode;
import com.leetcode.tools.MyLinkedList;
import com.leetcode.tools.TreeNode;
import org.junit.jupiter.api.Test;
import com.leetcode.tools.ListNode;

import java.util.*;

// https://leetcode.cn/problemset/algorithms/?difficulty=EASY&page=4
@SuppressWarnings("all")
public class Solution {
    @Test
    public void Test() {
        String s1 = "A B C D B B";
        String s2 = "A B B";
        System.out.println(areSentencesSimilar(s1, s2));

    }

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] spiralMatrixx(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int total = m * n;
        int row = 0, col = 0;
        int dirIndex = 0;
        for (ListNode node = head; node != null; node = node.next) {
            matrix[row][col] = node.val;
            int nextRow = row + dirs[dirIndex][0], nextCol = col + dirs[dirIndex][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != -1) {
                dirIndex = (dirIndex + 1) % 4;
            }
            row += dirs[dirIndex][0];
            col += dirs[dirIndex][1];
        }
        return matrix;
    }

    public void Test2(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = 100;
        }
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
     * No. 17 电话号码的字母组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        String[][] numToAlphabet = {
                {"*"},
                {"*"},
                {"a", "b", "c"},       // 2
                {"d", "e", "f"},       // 3
                {"g", "h", "i"},       // 4
                {"j", "k", "l"},       // 5
                {"m", "n", "o"},       // 6
                {"p", "q", "r", "s"},  // 7
                {"t", "u", "v"},       // 8
                {"w", "x", "y", "z"},  // 9
        };
        Queue<String> queue = new LinkedList<>();
        int digit_int = digits.charAt(0) - 48;
        for (int i = 0; i < numToAlphabet[digit_int].length; i++) {
            queue.add(numToAlphabet[digit_int][i]);
        }

        int current_digit_int;

        for (int i = 1; i < digits.length(); i++) {
            current_digit_int = digits.charAt(i) - 48;
            String[] nextDigitArray = numToAlphabet[current_digit_int];
            int current_queue_size = queue.size();

            for (int j = 0; j < current_queue_size; j++) {
                String tmp = queue.poll();
                for (int k = 0; k < nextDigitArray.length; k++) {
                    String tmp_a = tmp + numToAlphabet[current_digit_int][k];
                    queue.add(tmp_a);
                }
            }
        }
        System.out.println(queue.size());

        int res_size = queue.size();

        for (int i = 0; i < res_size; i++) {
            res.add(queue.poll());
        }
        return res;
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
     * No. 26 删除数组中的重复项
     * Tips: 双指针（滑动窗口）
     *
     * @param nums
     * @return
     */
    public int removeDuplicates0(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int left = 1, right = 1;
        while (right < nums.length) {
            if (nums[right] != nums[left - 1]) {
                nums[left++] = nums[right];
            }
            right++;
        }
        return left;
    }

    /**
     * No. 30 串联所有单词的子串
     *        使用两个 map 分别统计 长度为 n 的 word 出现的次数，并判断两个 map 是否相等（时间较长）
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int s_len = s.length();
        int word_len = words[0].length();
        int word_nums = words.length;
        int obj_len = word_len * word_nums;

        if ( obj_len> s_len) {
           return res;
        }

        int left = 0, right = obj_len;
        while (right < s.length() + 1) {
            HashMap<String, Integer> map_words = new HashMap<>();
            HashMap<String, Integer> map_s = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                if (!map_words.containsKey(words[i])) {
                    map_words.put(words[i], 1);
                } else {
                    map_words.put(words[i], map_words.get(words[i]) + 1);
                }
            }

            for (int i = left; i < right; i += word_len) {
                String tmp = s.substring(i, i + word_len);
                if (!map_s.containsKey(tmp)) {
                    map_s.put(tmp, 1);
                } else {
                    map_s.put(tmp, map_s.get(tmp) + 1);
                }
            }

            if (map_s.equals(map_words)) {
                res.add(left);
            }

            left++;
            right++;
        }
        return res;
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
     * No. 80 删除有序数组中的重复项
     * Tips: 双指针（滑动窗口）slow、fast，slow之前表示已经检查过的项目
     * fast表示当前待检查的项目
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int slow = 2, fast = 2;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
            ++fast;
        }

        return slow;


//        普通方法，通过循环移动后面的数据得到
//        int front = 1, tail = nums.length;
//        int move_index;
//
//        while (front < tail) {
//            if (nums[front] != nums[front-1]) {
//                ++front;
//                continue;
//            }
//            if (nums[front] != nums[front+1]) {
//                ++front;
//                continue;
//            }
//            move_index = front + 1;
//            while (move_index < tail) {
//                nums[move_index] = nums[move_index+1];
//                ++move_index;
//            }
//            --tail;
//        }
//        return tail;
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
     * No. 128 最长连续序列
     *     Tips: 使用集合，存储所有不重复的元素，有如下规律：
     *           a, b, c, d, e, f, g, h   是一个连续序列，从 a 开始，到 h 结束，如果
     *           碰到任意一个 a-h 之间的序列，其长度不可能超过  h-a，因此，遍历set的时候，如果
     *           一个数组的前一个数字已经存在了，那么这个数字遍历的就没有意义了。
     * @param nums
     */
    public int longestConsecutive(int[] nums) {
        // 使用集合判断的方法
        if (nums.length < 2) {
            return nums.length;
        }
        HashSet<Integer> hashSet = new HashSet<>();

        for (int n : nums) {
            hashSet.add(n);
        }

        int longestStreak = 0;
        for (int num : hashSet) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;


        // 使用 sort 排序后判断的方法
//        if (nums.length < 2) {
//            return nums.length;
//        }
//        Arrays.sort(nums);
//
//        int i = 1;
//        int current_max = 1;
//        int res_max = 1;
//        while (i < nums.length) {
//            if (nums[i] - nums[i-1] == 0) {
//                i++;
//            } else if (nums[i] - nums[i-1] == 1) {
//                current_max++;
//                i++;
//                res_max = current_max > res_max ? current_max: res_max;
//            } else {
//                res_max = current_max > res_max ? current_max: res_max;
//                current_max = 1;
//                i++;
//            }
//        }
//        return res_max;
    }

    /**
     * No. 151 翻转字符串中的单词
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("")) {
                continue;
            }
            sb.append(s1[i]);
            sb.append(" ");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
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
            sum = sum + (int) Math.pow(26.0, i) * (columnTitle.charAt(index++) - 64);
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
                    tmp = new String(Integer.toString(nums[left]) + "->" + Integer.toString(nums[right_pre]));
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
            tmp = new String(Integer.toString(nums[left]) + "->" + Integer.toString(nums[right_pre]));
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
     * No. 404 左叶子之和
     * 提示：是否是左叶子节点判断    (node.left != null) && (node.left.left == null) && (node.left.right == null)
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode tnode = queue.poll();
            if (tnode.left != null) {
                queue.offer(tnode.left);
            }
            if (tnode.right != null) {
                queue.offer(tnode.right);
            }

            if (tnode.left != null && tnode.left.left == null && tnode.left.right == null) {
                res += tnode.left.val;
            }
        }
        return res;
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
     * 1. 将数组转换成字符串，使用split方法，按照0分割，统计最长字符串的长度
     * 该方法，思路清晰，执行时间比较长 oj=15ms
     * <p>
     * StringBuilder sb = new StringBuilder();
     * for (int i = 0; i < nums.length; i++) {
     * sb.append(Integer.toString(nums[i]));
     * }
     * <p>
     * String x = sb.toString();
     * String[] split = x.split("0");
     * <p>
     * int res = 0;
     * for (String s : split) {
     * if (s.length() > res) {
     * res = s.length();
     * }
     * }
     * return res;
     * <p>
     * 2. 滑动窗口的方法，统计全 1 窗口的长度，tips：由于是int类型的数组，可以
     * 利用sum直接计算即可，sum的最大值就是返回结果
     *
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
                sum++;
            }
        }
        max = sum > max ? sum : max;
        return max;
    }

    /**
     * No. 496 下一个更大的元素 I
     *
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
            for (int k = j + 1; k < nums2.length; k++) {
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
     * No. 504 七进制数
     *
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }

        String sign = "";
        if (num < 0) {
            sign = "-";
        }

        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        int mod = 0;

        while (num > 0) {
            mod = num % 7;
            sb.insert(0, mod);
            num /= 7;
        }

        return sb.insert(0, sign).toString();
    }

    /**
     * No. 543 二叉树的直径
     *     Tips: 设置全局变量 depth，每次递归的时候，判断 depth 是不是最长的
     *           递归遍历过程中，其实是计算left, right 的深度
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        depth = 1;
        binTreeInorderDepth(root);
        return depth - 1;
    }
    int depth;
    public int binTreeInorderDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = binTreeInorderDepth(root.left);
        int R = binTreeInorderDepth(root.right);
        // 没有下面这条语句，这是一个标准的计算二叉树深度的递归函数
        depth = Math.max(depth, L + R + 1);
        return Math.max(L, R) + 1;
    }

    /**
     * No. 701 二叉搜索树中插入操作
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (cur != null) {
            if (val < cur.val) {
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    break;
                }
            } else {
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    /**
     * No. 709 转换成小写字母
     *
     * @param s
     * @return
     */
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    /**
     * No. 744 寻找比目标字母大的最小字母
     * 本题可以直接线性查找，时间复杂度O(n)，也可以使用二分查找，时间复杂度O(log n)
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        // 线性查找：
//        char res = letters[0];
//        for (int i = 0; i < letters.length; i++) {
//            if (letters[i] - target > 0) {
//                return letters[i];
//            }
//        }
//        return res;
        // 二分查找
        int left = -1, right = letters.length;
        int mid;

        while (left + 1 != right) {
            mid = left + ((right - left) >> 1);
            if (letters[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right == letters.length ? letters[0] : letters[right];
    }

    /**
     * No. 821 字符的最短距离
     * 假定最近字符的索引是 idx
     * 1. 计算当前字符距离 左侧 最近目标字符的距离:  currentIndex - idx
     * 2. 计算当前字符距离 右侧 最近目标字符的距离:  idx - currentIndex
     * 3. 两个距离取最小值，即返回的目标数组的结果
     * <p>
     * tips：一开始遍历的时候，可能不存在目标字符的位置索引，这里使用 idx = -n 和 2n来计算，
     * 因为-n不存在，currentIndex - (-n) 一定是更大的值，同理，2n不存在 2n - currentIndex
     * 也一定是大于n的值
     *
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        // 计算 currentIndex 距离左侧最近的距离。因为从左到右遍历，左侧最近的字符是确定的，所以可以计算
        for (int i = 0, idx = -n; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            res[i] = i - idx;
        }

        // 计算 currentIndex 距离右侧最近的距离。因为从右向左遍历，右侧最近的字符位置是确定的
        for (int i = n - 1, idx = 2 * n; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            res[i] = Math.min(res[i], idx - i);
        }
        return res;
    }

    /**
     * No. 852 山峰数组的峰顶索引
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        // 由题意所知，这里一定存在"山峰"顶点，所以初始化 left、right边界的时候，可以缩小范围
        // left 向右扩张到 0 索引位置，right 向左缩小到 n - 1的位置，可以防止查询越界
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left + 1 != right) {
            mid = left + ((right - left) >> 1);
            // 因为山峰的左边一定是单调递增的，山峰的右边一定是单调递减的，山峰默认是 target，就可以根据递增
            // 或是递减的特性，找到target 当前所属的区间来判断，left 和 right 的区间范围应该如何变化
            if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * No. 893 特殊等价字符串组
     * Tips:
     * 1. 分别将 奇数 位置，偶数位置的字符串提取出来，并进行排序
     * 2. 拼接排序后的字符串，根据题意可得，如果两个字符串"特殊等价"那么，
     * 拼接后的字符串，一定相等
     * 3. 遍历字符串数组，将当前字符串的 奇偶排序拼接字符串存储在HashMap中【此处也可以是hashSet】
     * 4. hashset中存放的key个数，即是需要返回的数组数量
     * <p>
     * 还有一种思路是，用int[] chs = new int[52]对数组 奇偶字符分别统计，然后Arrays.toString() 添加到集合中
     *
     * @param words
     * @return
     */
    public int numSpecialEquivGroups(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String str = null;
        int res_max = 0;
        int current_count = 0;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder str_ou = new StringBuilder();
            StringBuilder str_ji = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                if (j % 2 == 0) {
                    str_ou.append(word.charAt(j));
                } else {
                    str_ji.append(word.charAt(j));
                }
            }

            str_ji = chsOrder(str_ji);
            str_ou = chsOrder(str_ou);

            str = str_ji.append(str_ou).toString();
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, 1);
                ++res_max;
            }
        }
        return res_max;
    }

    public StringBuilder chsOrder(StringBuilder sb) {
        String s = new String(sb);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);
        return new StringBuilder(s);
    }

    /**
     * No. 1275 找出井字棋的获胜者
     *
     * @param moves
     * @return
     */
    public String tictactoe(int[][] moves) {
        // 初始化棋盘
        char[][] pad = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(pad[i], '*');
        }

        int row, cow;
        for (int i = 0; i < moves.length; i++) {
            row = moves[i][0];
            cow = moves[i][1];
            if (i % 2 == 0) {
                pad[row][cow] = 'X';
            } else {
                pad[row][cow] = 'O';
            }
        }
        // 取出来最后一步棋子的 row 和 cow
        int[] lastStep = moves[moves.length - 1];
        row = lastStep[0];
        cow = lastStep[1];
        String res = null;
        // 最后一步落在中间偏上、下、左、右的位置
        if ((row + cow) % 2 != 0) {
            if (judgeRow(lastStep, pad) || judgeCow(lastStep, pad)) {
                res = String.valueOf(pad[row][cow]);
                if (res.equals("X")) {
                    return "A";
                } else {
                    return "B";
                }
            } else if (moves.length == 9) {
                return "Draw";
            } else {
                return "Pending";
            }
        } else {  // 最后一步落在 center 或 corner 的位置
            if (judgeRow(lastStep, pad) || judgeCow(lastStep, pad) || crossLine(lastStep, pad)) {
                res = String.valueOf(pad[row][cow]);
                if (res.equals("X")) {
                    return "A";
                } else {
                    return "B";
                }
            } else if (moves.length == 9) {
                return "Draw";
            } else {
                return "Pending";
            }
        }
    }

    // 交叉线是否连线判断：center 位置 分别和四个 corner 判断是否一致，且不是 *
    public boolean crossLine(int[] position, char[][] pad) {
        char center = pad[1][1];
        if (center == '*') {
            return false;
        }

        int row = position[0];
        int cow = position[1];

        if (row == cow) {
            if (center == pad[0][0] && center == pad[2][2]) {
                return true;
            }
        }
        if (row + cow == 2) {
            if (center == pad[0][2] && center == pad[2][0]) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeCow(int[] position, char[][] pad) {
        int cow = position[1];
        char pre = pad[0][cow];
        if (pre == '*') {
            return false;
        }
        for (int row = 1; row < 3; row++) {
            if (pad[row][cow] == '*') {
                return false;
            }
            if (pad[row][cow] == pre) {
                pre = pad[row][cow];
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean judgeRow(int[] position, char[][] pad) {
        int row = position[0];
        char pre = pad[row][0];
        if (pre == '*') {
            return false;
        }
        for (int cow = 1; cow < 3; cow++) {
            if (pad[row][cow] == '*') {
                return false;
            }
            if (pad[row][cow] == pre) {
                pre = pad[row][cow];
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * No. 1331 数组序号转换
     * Tips: HashMap 在 put 的过程中，对不同元素，有计数的功能
     *
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        int[] copyedArr = Arrays.copyOf(arr, arr.length);
        int[] res = new int[arr.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Arrays.sort(copyedArr);

        for (int i = 0; i < copyedArr.length; i++) {
            if (!hashMap.containsKey(copyedArr[i])) {
                hashMap.put(copyedArr[i], hashMap.size() + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            res[i] = hashMap.get(arr[i]);
        }

        return res;
    }

    /**
     * No. 1614 括号的最大嵌套深度
     *
     * @param s
     * @return
     */
    public int maxDepth(String s) {
        int max_depth = 0;
        int count = 0;
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                count++;
                max_depth = count > max_depth ? count : max_depth;
            } else if (ch == ')') {
                count--;
            }
        }
        return max_depth;
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
     *
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
     * No. 1813 句子相似性 III
     * @param sentence1
     * @param sentence2
     * @return
     */
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) {
            return true;
        }
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length == s2.length) {
            return false;
        }
        int shortLen = s1.length < s2.length ? s1.length : s2.length;

        int s1_left = 0, s1_right = s1.length-1, s2_left = 0, s2_right = s2.length -1;
        while (s1_left < s1.length && s2_left < s2.length &&
                s1[s1_left].equals(s2[s2_left])) {
            s1_left++;
            s2_left++;
        }
        if (s1_left == shortLen || s2_left == shortLen) {
            return true;
        }

        while (s1_right >= 0 && s2_right >= 0 &&
                s1[s1_right].equals(s2[s2_right])) {
            s1_right--;
            s2_right--;
        }
        if (s1_right == -1 || s2_right == -1) {
            return true;
        }

        if (s1.length < s2.length) {
            if (s1_left > s1_right) {
                return true;
            } else {
                return false;
            }
        } else {
            if (s2_left > s2_right) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * No. 1818 绝对差值和
     * 使用二分查找 nums1 中的 最逼近 nums2[i] 的元素，然后进行判断。如下代码，使用了多个if条件
     * 语句判断情况  potential_index, potential_index_left, potential_index_right 是否
     * 符合条件，这里多个判断语句，写法不是很优雅
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int[] origin_minus_abs = new int[nums1.length];
        int[] change_minus_abs = new int[nums1.length];
        int res = 0;

        int minus = 0;
        for (int i = 0; i < nums1.length; i++) {
            minus = nums1[i] - nums2[i];
            origin_minus_abs[i] = Math.abs(minus);
        }
        if (nums1.length == 1) {
            return origin_minus_abs[0];
        }
        Arrays.sort(nums1);

        int potential_index;
        int potential_index_result;
        int potential_index_left_result;
        int potential_index_right_result;

        for (int i = 0; i < nums2.length; i++) {
            potential_index = myBinarySearch(nums1, nums2[i]);
            if (potential_index == -1) {
                potential_index_right_result = Math.abs(nums2[i] - nums1[potential_index + 1]);

                change_minus_abs[i] = potential_index_right_result;
            } else if (potential_index == nums1.length - 1) {
                potential_index_result = Math.abs(nums2[i] - nums1[potential_index]);
                potential_index_left_result = Math.abs(nums2[i] - nums1[potential_index - 1]);

                change_minus_abs[i] = Math.min(potential_index_result, potential_index_left_result);
            } else if (potential_index == 0) {
                potential_index_result = Math.abs(nums2[i] - nums1[potential_index]);
                potential_index_right_result = Math.abs(nums2[i] - nums1[potential_index + 1]);
                change_minus_abs[i] = Math.min(potential_index_result, potential_index_right_result);
            } else {
                potential_index_result = Math.abs(nums2[i] - nums1[potential_index]);
                potential_index_left_result = Math.abs(nums2[i] - nums1[potential_index - 1]);
                potential_index_right_result = Math.abs(nums2[i] - nums1[potential_index + 1]);

                int tmpMin = Math.min(potential_index_result, potential_index_left_result);
                change_minus_abs[i] = tmpMin < potential_index_right_result ? tmpMin : potential_index_right_result;
            }
        }
        int max = -1;
        for (int i = 0; i < nums1.length; i++) {
            if (Math.abs(origin_minus_abs[i] - change_minus_abs[i]) > max) {
                max = Math.abs(origin_minus_abs[i] - change_minus_abs[i]);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            res = (res + origin_minus_abs[i]) % MOD;
        }
        return (res - max + MOD) % MOD;
    }

    public int myBinarySearch(int[] nums, int target) {
        int left = -1;
        int right = nums.length;
        int mid;

        while (left + 1 != right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
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
     *
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
     * No. 2287 重排字符形成目标字符串
     *
     * @param s
     * @param target
     * @return
     */
    public int rearrangeCharacters(String s, String target) {
        int[] ch_counts = new int[26];
        int min = 101;
        int repeat_count = 0;
        boolean loop = true;
        for (int i = 0; i < s.length(); i++) {
            ch_counts[s.charAt(i) - 'a']++;
        }

        // 外部 while 循环，无穷遍历
        // 内部 for 循环，每次遇到目标字符，就会对 ch_counts 中的字母进行 - 操作，相当于去除一个字符
        // 如果遇到 0 个字符，无法提取，就默认所有的情况都已经取完了，while循环可以退出
        while (loop) {
            for (int i = 0; i < target.length(); i++) {
                if (ch_counts[target.charAt(i) - 'a'] > 0) {
                    ch_counts[target.charAt(i) - 'a']--;
                } else {
                    loop = false;
                    break;
                }
            }
            // for 循环结束，判断当前for循环是否成功，如果成功则进行+1统计，如果当前循环失败了，则不统计
            if (loop) {
                repeat_count++;
            }
        }
        return repeat_count;
    }

    /**
     * No. 2293 极大极小游戏
     *
     * @param nums
     * @return
     */
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        while (nums.length > 1) {
            int len = nums.length / 2;
            int[] newNums = new int[len];
            for (int i = 0; i < len; i++) {

                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }

    /**
     * No. 2301 替换字符后匹配
     * @param s
     * @param sub
     * @param mappings
     * @return
     */
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        if (s.contains(sub)) {
            return true;
        }

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < mappings.length; i++) {
            if (!map.containsKey(mappings[i][0])) {
                map.put(mappings[i][0], Character.toString(mappings[i][1]));
            } else {
                map.put(mappings[i][0], map.get(mappings[i][0]) + mappings[i][1]);
            }
        }

        int s_len = s.length();
        int sub_len = sub.length();
        for (int i = 0; i < s_len - sub_len + 1; i++) {
            String compare = s.substring(i, i + sub_len);
            int finded = 0;
            for (int j = 0; j < compare.length(); j++) {
                if (compare.charAt(j) == sub.charAt(j)) {
                    if (j == sub.length() - 1) {
                        finded = 1;
                        break;
                    }
                    continue;
                } else {
                    if (!map.containsKey(sub.charAt(j))) {
                        break;
                    } else {
                        if (map.get(sub.charAt(j)).contains(Character.toString(compare.charAt(j)))) {
                            if (j == sub.length() - 1) {
                                finded = 1;
                                break;
                            }
                            continue;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (finded == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * No. 2326 螺旋矩阵 IV
     *
     * @param m
     * @param n
     * @param head
     * @return
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode cruise = head;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }

        int count = 0;
        int restRow = m;
        int restCow = n;
        int reachEnd = 0;

        while (restRow > 0 && restCow > 0 && reachEnd != 1) {
            if ( m == n && count == m / 2) {
                res[count][count] = cruise.val;
                return res;
            }
            // 打印最外圈的 上行
            for (int cow = count; cow < n - count - 1 && reachEnd != 1; cow++) {
                res[count][cow] = cruise.val;
                if (cruise.next != null) {
                    cruise = cruise.next;
                } else {
                    reachEnd = 1;
                    break;
                }
            }
            // 打印最外圈的 右列
            for (int row = count; row < m - count - 1 && reachEnd != 1; row++) {
                res[row][n - count - 1] = cruise.val;
                if (cruise.next != null) {
                    cruise = cruise.next;
                } else {
                    reachEnd = 1;
                    break;
                }
            }
            // 打印最外圈的 下行
            for (int cow = n - count - 1; cow > count && reachEnd != 1; cow--) {
                res[m - count - 1][cow] = cruise.val;
                if (cruise.next != null) {
                    cruise = cruise.next;
                } else {
                    reachEnd = 1;
                    break;
                }
            }
            // 打印最外圈的 左列
            for (int row = m - count - 1; row > count && reachEnd != 1; row--) {
                res[row][count] = cruise.val;
                if (cruise.next != null) {
                    cruise = cruise.next;
                } else {
                    reachEnd = 1;
                    break;
                }
            }

            restRow -= 2;
            restCow -= 2;
            ++count;
        }
        return res;
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









