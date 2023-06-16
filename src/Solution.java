import com.leetcode.tools.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import com.leetcode.tools.ListNode;

import java.net.Inet4Address;
import java.util.*;

import static java.util.Arrays.*;

// https://leetcode.cn/problemset/algorithms/?difficulty=EASY&page=4
@SuppressWarnings("all")
public class Solution {
    @Test
    public void Test() {
    }

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] spiralMatrixx(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            fill(matrix[i], -1);
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
     * No. 4 寻找两个正序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] mergeNums = new int[n1 + n2];
        int currentIndex = 0;
        for (int i = 0; i < nums1.length; i++) {
            mergeNums[currentIndex++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            mergeNums[currentIndex++] = nums2[i];
        }

        Arrays.sort(mergeNums);

        if ((n1 + n2) % 2 == 0) {
            int left = (n1 + n2 - 1) / 2;
            int right = left + 1;
            return (double) (mergeNums[left] + mergeNums[right]) / 2;
        } else {
            return (double) mergeNums[(n1 + n2 - 1) / 2];
        }
    }

    /**
     * No. 8 字符串转换整数(atoi)
     *
     * @param columnTitle
     * @return
     */
    public int myAtoi(String columnTitle) {

        return 0;
    }

    /**
     * No. 回文数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int half = 0;
        while (x > half) {
            half = half * 10 + x % 10;
            x /= 10;
        }
        return x == half || x == half / 10;
    }

    /**
     * No. 13 整数转罗马数字
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ROMA = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(ROMA[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    /**
     * No. 15 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) { // 由于已经升序排列过了，第一个数都大于0，那么后面的数加起来一定是大于0，循环可以退出了
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  // 如果当前值和前一个位置的值相同，则跳过
                continue;
            }
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    ++left;
                    --right;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    /**
     * No. 16 最接近的三数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        sort(nums);
        int best = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < best) {
                    best = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum > target) {
                    --k;
                    while (k > j && nums[k] == nums[k + 1]) {
                        --k;
                    }
                } else {
                    ++j;
                    while (j < k && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * No. 17 电话号码的字母组合
     *
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
     * No. 19 删除链表的倒数第N个节点
     * Tips: 方便删除操作，构造一个 dummy 头节点挂载 head 的前面
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;

        while (fast != null && n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * No. 20 有效的括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char ch = stack.pop();
                    switch (ch) {
                        case '(':
                            if (cur != ')') return false;
                            break;
                        case '{':
                            if (cur != '}') return false;
                            break;
                        case '[':
                            if (cur != ']') return false;
                            break;
                    }
                }
            }
        }
        return stack.isEmpty() ? true : false;
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
     * No. 22 括号生成
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll(new char[n * 2], 0, res);
        return res;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valided(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valided(char[] charArray) {
        int balance = 0;
        for (char ch : charArray) {
            if (ch == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    /**
     * No. 23 合并 K 个升序链表
     * Tips: 优先队列（小顶堆）
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        class Status implements Comparable<Status> {
            int val;
            ListNode ptr;

            public Status(int val, ListNode ptr) {
                this.val = val;
                this.ptr = ptr;
            }

            @Override
            public int compareTo(Status o) {
                return this.val - o.val;
            }
        }

        PriorityQueue<Status> queue = new PriorityQueue<>();

        ListNode head = new ListNode();
        ListNode tail = head;

        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }

        while (!queue.isEmpty()) {
            Status poll = queue.poll();
            tail.next = poll.ptr;
            tail = tail.next;

            if (poll.ptr.next != null) {
                queue.offer(new Status(poll.ptr.next.val, poll.ptr.next));
            }
        }
        return head.next;
    }

    /**
     * No. 24 两两交换链表中的节点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode resHead = cur;

        while (cur.next != null && cur.next.next != null) {
            ListNode p = cur.next;
            ListNode pp = p.next;
            ListNode next = pp.next;

            p.next = next;
            pp.next = p;
            cur.next = pp;

            cur = pp.next;
        }

        return resHead.next;
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
     * 使用两个 map 分别统计 长度为 n 的 word 出现的次数，并判断两个 map 是否相等（时间较长）
     *
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

        if (obj_len > s_len) {
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
     * No. 33 搜索旋转排序数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return res;
    }

    public int search_bin(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                left = mid + 1;
            else
                right = mid;
        }
        return left == right && nums[left] == target ? left : -1;
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
     * No. 36 有效的数独
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int line[][] = new int[9][9];
        int column[][] = new int[9][9];
        int cell[][] = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0' - 1;
                int k = i / 3 * 3 + j / 3;
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0)
                    return false;
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        }
        return true;
    }

    /**
     * No. 38 外观数列
     * Tips: 典型的递归方法且没有重复递归项目，递归  say(n) = say(n-1), say(1) = "1";
     * 双重while循环，不停的滑动  [left, right] 区间，left指向区间内开始的字符，right是整个区间的重点
     * 将结果append 到 res 字符串中即可
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();

        int start = 0, end = 0;

        while (end < pre.length()) {
            while (end < pre.length() && pre.charAt(start) == pre.charAt(end)) {
                end++;
            }
            res.append(end - start);
            res.append(pre.charAt(start));
            start = end;
        }
        return res.toString();
    }

    /**
     * No. 缺失的第一个正数
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * No. 46 全排列
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs_46(nums, len, 0, path, used, res);
        return res;
    }

    public static void dfs_46(int[] nums, int len, int depth,
                              List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs_46(nums, len, depth + 1, path, used, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * No. 48 旋转图像
     * Tips：顺时针旋转matrix 90度，可以转换为，对角线翻转后，按行逆序
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int tmp;
        // 沿着左上、右下对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 按行逆序
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                tmp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = tmp;
            }
        }
    }

    /**
     * No. 66 加一
     * Tips: 从后向前遍历，如果当前位置数字不是9，那么可以直接进行+1操作然后返回
     * 直到第一位也是9的时候，重新生成一个数组【默认全0】，最高位置1，返回即可
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int res[] = new int[length + 1];
        res[0] = 1;
        return res;
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
     * No. 83 删除排序链表中的重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = cur.next;

        while (next.next != null) {
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = next;
            }
            next = next.next;
        }

        if (cur.val == next.val) {
            cur.next = null;
        }

        return head;
    }

    /**
     * No. 86 分隔链表
     * Tips: 类似归并的方法，最后将两个链表整合在一起
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode();
        ListNode dummyRight = new ListNode();
        ListNode cur = head;
        ListNode curLeft = dummyLeft;
        ListNode curRight = dummyRight;

        while (null != cur) {
            if (cur.val < x) {
                curLeft.next = cur;
                curLeft = curLeft.next;
            } else {
                curRight.next = cur;
                curRight = curRight.next;
            }
            cur = cur.next;
        }
        curRight.next = null;
        curLeft.next = dummyRight.next;
        return dummyLeft.next;
    }

    /**
     * No. 88 合并两个有序数组
     * Tips: 由于 nums1 数组的后半部分是0，所有可以从后往前归并两个数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int current = m + n - 1;
        int nums1_end = m - 1;
        int nums2_end = n - 1;
        while (nums1_end >= 0 && nums2_end >= 0) {
            if (nums1[nums1_end] >= nums2[nums2_end]) {
                nums1[current--] = nums1[nums1_end--];
            } else {
                nums1[current--] = nums2[nums2_end--];
            }
        }
        while (nums1_end >= 0) {
            nums1[current--] = nums1[nums1_end--];
        }
        while (nums2_end >= 0) {
            nums1[current--] = nums2[nums2_end--];
        }
    }

    /**
     * No. 92 翻转链表 II
     * Tips: 找到 pre cur next 三个节点的位置，进行尾插法即可，注意新建一个头结点
     * 用作处理返回。
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode pHead = new ListNode();
        ListNode start = new ListNode();
        ListNode next = new ListNode();
        ListNode end = new ListNode();
        ListNode HHead = new ListNode();

        pHead.next = head;
        HHead = pHead;

        // pHead 指向 left 节点的左侧，待调整链表的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pHead = pHead.next;
        }

        start = pHead.next;
        next = start.next;

        // end 指向 right 节点
        end = start;
        for (int i = 0; i < right - left; i++) {
            end = end.next;
        }

        for (int i = 0; i < right - left; i++) {
            start.next = next.next;
            next.next = pHead.next;
            pHead.next = next;
            next = start.next;
        }

        return HHead.next;
    }

    /**
     * No. 98 验证二叉搜索树
     * Tips: 中序遍历一个二叉搜索树，一定得到一个单调递增序列
     *
     * @param root
     * @return
     */
    Long pre_98 = Long.MIN_VALUE;
    boolean res_98 = true;

    public boolean isValidBST(TreeNode root) {
        inOrder_98(root);
        return res_98;
    }

    public void inOrder_98(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder_98(root.left);
        if (pre_98 <= root.val) {
            res_98 = false;
            return;
        } else {
            pre_98 = (long) root.val;
        }
        inOrder_98(root.right);
    }

    /**
     * No. 101 对称二叉树
     * Tips:
     * ①递归实现
     * ②队列实现（相当于将左右子树，重叠在一起遍历，一次取出两个元素）
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 0) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

//    public boolean isSymmetric(TreeNode root) {
//        // 如果是空树，返回 true
//        if (root == null) {
//            return true;
//        }
//        // 递归判断这个树的左右孩子是不是符合对称二叉树的规律
//        return dfs_101(root.left, root.right);
//
//    }
//    public boolean dfs_101(TreeNode left, TreeNode right) {
//        // 如果左右孩子节点都是空，返回 true
//        if (left == null && right == null) {
//            return true;
//        }
//        // 如果只有一个节点是非空，结合上一个if语句，那么这课树一定不对称
//        if (left == null || right == null) {
//            return false;
//        }
//        // 如果带个节点都不为空，但是val不相等，那么不对称
//        if (left.val != right.val) {
//            return false;
//        }
//        // 递归判断，左节点的做孩子 和 有节点的右孩子是不是相等
//        //          左节点的右孩子 和 右节点的左孩子是不是相等
//        return dfs_101(left.left, right.right) &&
//                dfs_101(left.right, right.left);
//    }

    /**
     * No. 102 二叉树的层序遍历
     * Tips: 在while循环中间，添加一个当前队列包含的总数量，即一层所有的节点数量
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode tmp;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tmp = queue.poll();
                tmpList.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            res.add(tmpList);
        }
        return res;
    }

    /**
     * No. 104 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * No. 108 将有序数组转换为二叉搜索树
     * Tips: 二叉搜索树的中序遍历是一个递增数列，那么数列的中间节点可以作为 root 节点，
     * 左边节点作为左子树节点，右边节点作为右子树节点
     * 利用这一特性，递归可得
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);

    }

    // [start, x, x, [mid], x, x, end]  => mid应该是 root 返回
    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }

    /**
     * No. 110 平衡二叉树
     *
     * @param root
     * @return
     */
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepthX(root);
        return isBalanced;
    }

    public int maxDepthX(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepthX(root.left);
        int rDepth = maxDepthX(root.right);
        if (Math.abs(lDepth - rDepth) > 1) {
            isBalanced = false;
        }
        return 1 + Math.max(lDepth, rDepth);
    }

    /**
     * No. 111 二叉树最小深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = minDepth(root.left);
        int rDepth = minDepth(root.right);

        // 如果左右子数其中一个为空的时候，深度为另一个数的深度 + 1
        if (lDepth == 0 || rDepth == 0) {
            return lDepth + rDepth + 1;
        }

        return Math.min(lDepth, rDepth) + 1;
    }

    /**
     * No. 112 路径总和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);

    }

    /**
     * No. 118 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
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
     * Tips: 使用集合，存储所有不重复的元素，有如下规律：
     * a, b, c, d, e, f, g, h   是一个连续序列，从 a 开始，到 h 结束，如果
     * 碰到任意一个 a-h 之间的序列，其长度不可能超过  h-a，因此，遍历set的时候，如果
     * 一个数组的前一个数字已经存在了，那么这个数字遍历的就没有意义了。
     *
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
     * No. 141 环形链表
     * Tips: 快慢指针，如果快的能追上慢的，代表一定有环路出现
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
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
     * No. 160 相交链表
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        if (l1 == null || l2 == null) {
            return null;
        }
        while (l1 != l2) {
            l1 = (l1 != null) ? l1.next : headB;
            l2 = (l2 != null) ? l2.next : headA;
        }

        return l1;
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
     * No. 200 岛屿数量
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    markIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void markIsland(char[][] grid, int row, int cow) {
        if (!isValid(grid, row, cow)) {
            return;
        }
        if (grid[row][cow] != '1') {
            return;
        }
        grid[row][cow] = '2';
        markIsland(grid, row, cow - 1);
        markIsland(grid, row, cow + 1);
        markIsland(grid, row - 1, cow);
        markIsland(grid, row + 1, cow);
    }

    public boolean isValid(char[][] grid, int row, int cow) {
        return row >= 0 && row < grid.length && cow >= 0 && cow < grid[0].length;
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

    public boolean xxx(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);
            if (!map.containsKey(ch_s)) {
                map.put(ch_s, ch_t);
            } else {
                if (map.get(ch_s) != ch_t) {
                    return false;
                }
            }
        }

        map.clear();

        for (int i = 0; i < length; i++) {
            char ch_s = s.charAt(i);
            char ch_t = t.charAt(i);
            if (!map.containsKey(ch_t)) {
                map.put(ch_t, ch_s);
            } else {
                if (map.get(ch_t) != ch_s) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * No. 206 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode resHead = new ListNode(0, null);
        ListNode temp = new ListNode(0);

        while (head != null) {
            temp = head.next;
            head.next = resHead.next;
            resHead.next = head;
            head = temp;
        }
        return resHead.next;
    }

    /**
     * No. 226 翻转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = new TreeNode();
        left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
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
     * No. 229 多数元素 II
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        Set<Integer> integers = hashMap.keySet();
        for (Integer num : integers) {
            if (hashMap.get(num) > nums.length / 3) {
                ans.add(num);
            }
        }
        return ans;
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
     * No. 234 回文链表
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            while (!stack.isEmpty()) {
                if (stack.pop() != slow.val) {
                    return false;
                } else {
                    slow = slow.next;
                }
            }
        } else if (fast.next == null) {
            slow = slow.next;
            while (!stack.isEmpty()) {
                if (stack.pop() != slow.val) {
                    return false;
                } else {
                    slow = slow.next;
                }
            }
        }
        return true;
    }

    /**
     * No. 236 二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs_236(root);
        HashSet<Integer> visited = new HashSet<>();
        while (p != null) {
            visited.add(p.val);
            p = map_236.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = map_236.get(q.val);
        }
        return null;
    }

    //递归，存储每个节点的父节点到map中
    Map<Integer, TreeNode> map_236 = new HashMap<>();

    public void dfs_236(TreeNode root) {
        if (root.left != null) {
            map_236.put(root.left.val, root);
            dfs_236(root.left);
        }
        if (root.right != null) {
            map_236.put(root.right.val, root);
            dfs_236(root.right);
        }
    }

    /**
     * No. 237 删除链表中的节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
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
     * No. 278 第一个错误的版本
     * Tips: 使用二分查找，注意 n 的取值范围，有可能导致 int 越界
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        long left = -1, right = n + 1;
        while (left + 1 != right) {
            long mid = left + ((right - left) >> 1);
            System.out.println(mid);
            if (!isBadVersion((int) mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int) right;
    }

    public boolean isBadVersion(int n) {
        return n == 2147483647 ? true : false;
    }

    /**
     * No. 283 移动零
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;    // left,right 位于整个数组的起始位置，right 从头到后遍历，遇到非0元素 替换到left的为止
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
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
     * No. 337 打家劫舍III
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map337.containsKey(root)) {
            return map337.get(root);
        }
        int total1 = root.val;

        if (root.left != null) {
            total1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            total1 += rob(root.right.left) + rob(root.right.right);
        }

        int total2 = 0;
        total2 = rob(root.left) + rob(root.right);

        int max = Math.max(total1, total2);
        map337.put(root, max);

        return max;
    }

    HashMap<TreeNode, Integer> map337 = new HashMap<>();

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
     * No. 350 两个数组的交集 II
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], hashMap.getOrDefault(nums1[i], 0) + 1);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (hashMap.containsKey(nums2[j])) {
                arrayList.add(nums2[j]);
                hashMap.put(nums2[j], hashMap.get(nums2[j]) - 1);
                if (hashMap.get(nums2[j]) == 0) {
                    hashMap.remove(nums2[j]);
                }
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

    /**
     * No. 357 统计个位数字都不相同的数字个数
     * Tips: 用枚举的方法，从第一位开始统计 9 x 9 x 8 x 7 x 6 x 5 x ... + f(n-1)
     *
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }

        int[] dp = new int[9];
        dp[0] = 1;
        dp[1] = 10;

        for (int i = 2; i <= n; i++) {
            int cur = 9;
            for (int j = 0; j < i - 1; j++) {
                cur *= (9 - j);
            }
            cur += dp[i - 1];
            dp[i] = cur;
        }
        return dp[n];
    }

    /**
     * No. 373 查找和最小的k对数字
     * Tips: 优先队列，PriorityQueue 构造
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//
//
//    }

    /**
     * No. 387 字符串中的第一个唯一字符
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int res = -1;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashmap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return res;
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
     * No. 409 最长回文串
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int res = 0, Odd = 0;
        int[] map = new int['z' - 'A'];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch - 'A']++;
        }

        for (int item : map) {
            if (item % 2 == 0) {
                res += item;
            } else {
                res += item - 1;
                Odd = 1;
            }
        }
        return Odd == 0 ? res : res + 1;
    }

    /**
     * No. 415 字符串相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int add = 0;
        StringBuilder ans = new StringBuilder();

        while (index1 >= 0 || index2 >= 0 || add != 0) {
            int x = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int y = index2 >= 0 ? num2.charAt(index2) - '0' : 0;

            int temp = x + y + add;

            add = temp > 9 ? 1 : 0;
            ans.append(temp % 10);
        }
        return ans.reverse().toString();
    }

    /**
     * No. 433 最小基因变化
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        // 如果 start 和 end 相同，不需要调整，直接返回
        if (startGene.equals(endGene)) {
            return 0;
        }
        // 将合法的基因序列，添加到hash表中，用于判断
        HashSet<String> validGene = new HashSet<>();
        for (String s : bank) {
            validGene.add(s);
        }
        // 如果 end 不在 bank 中，start 则不可能突变成 end 序列
        if (!validGene.contains(endGene)) {
            return -1;
        }
        char[] keys = {'A', 'C', 'G', 'T'};
        ArrayDeque<String> queue = new ArrayDeque<>();
        // hash 表，用于存储是 bank 中的序列，但是已经出现过，且不是 end 序列
        HashSet<String> appeared = new HashSet<>();
        // 将 start 序列，添加到集合和队列中
        appeared.add(startGene);
        queue.offer(startGene);
        int step = 1;

        while (!queue.isEmpty()) {
            // 对当前队列中全部的序列，进行遍历，每次调整其中的一位字符（[0-7])），遍历完成，步数 +1
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (poll.charAt(j) != keys[k]) {
                            StringBuilder sb = new StringBuilder(poll);
                            sb.setCharAt(j, keys[k]);
                            String tempJudge = sb.toString();
                            // 对调整一个字符后的序列进行判断，该序列没有出现过，且是 bank 中的合规序列
                            if (!appeared.contains(tempJudge) && validGene.contains(tempJudge)) {
                                if (tempJudge.equals(endGene)) {
                                    return step;
                                }
                                // 如果不是 end 序列，则将序列添加到队列中（下次可以依据当前序列进行调整）
                                queue.offer(tempJudge);
                                // 添加到已经出现过的序列中
                                appeared.add(tempJudge);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    @Test
    public void testaaa() {
        String start = "AACCGGTT", end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(minMutation(start, end, bank));
    }

    /**
     * No. 437 路径总和III
     *
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = pathSumStartWithRoot(root, targetSum) +
                pathSum(root.left, targetSum) +
                pathSum(root.right, targetSum);

        return res;
    }

    public int pathSumStartWithRoot(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;

        if (root.val == targetSum) {
            res += 1;
        }

        res += pathSumStartWithRoot(root.left, targetSum - root.val) +
                pathSumStartWithRoot(root.right, targetSum - root.val);

        return res;
    }

    /**
     * No. 445 两数相加II
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersI(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int total = 0;
        ListNode resFirst = new ListNode();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                total += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                total += stack2.pop();
            }

            resFirst.val = total % 10;
            total /= 10;
            ListNode tmp = new ListNode();
            tmp.val = total;
            tmp.next = resFirst;
            resFirst = tmp;
        }

        return resFirst.val == 0 ? resFirst.next : resFirst;
    }

    /**
     * No. 457 环形数组是否存在循环
     *
     * @param nums
     * @return
     */
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素已经访问过，那么可以直接跳过（因为，前面已经访问过，并没有跳出循环，那么该节点可以不用重复判断了）
            if (nums[i] == 0) {
                continue;
            }

            int slow = i, fast = next457(nums, i);

            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next457(nums, fast)] > 0) {
                if (slow == fast) {
                    // 判断是否原地循环了
                    if (slow != next457(nums, slow)) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = next457(nums, slow);
                fast = next457(nums, next457(nums, fast));
            }
            // 将失败的路径全部置0，用以优化下次走到该节点，直接跳过
            int add = i;
            while (nums[add] * nums[next457(nums, add)] > 0) {
                int tmp = add;
                add = next457(nums, add);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    public int next457(int[] nums, int cur) {
        int length = nums.length;
        return ((cur + nums[cur]) % length + length) % length;
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
     * No. 463 岛屿的周长
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return islandLen(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int islandLen(int[][] grid, int row, int cow) {
        if (!isValid(grid, row, cow)) {
            return 1;
        }
        if (grid[row][cow] == 0) {
            return 1;
        }
        if (grid[row][cow] != 1) {
            return 0;
        }
        grid[row][cow] = 2;
        return islandLen(grid, row, cow - 1) +
                islandLen(grid, row, cow + 1) +
                islandLen(grid, row + 1, cow) +
                islandLen(grid, row - 1, cow);
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
     * No. 503 下一个更大元素II
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length * 2];
        fill(ans, -1);
        int[] copyNums = new int[length * 2];
        for (int i = 0; i < length * 2; i++) {
            copyNums[i] = nums[i % length];
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length * 2; i++) {
            int curNumber = copyNums[i];
            while (!stack.isEmpty() && curNumber > copyNums[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = curNumber;
            }
            stack.push(i);
        }

        return copyOf(ans, length);
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
     * No. 513 找数左下角的值
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
        }
        return cur.val;
    }

    /**
     * No. 540 有序数组中的单一元素
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    /**
     * No. 543 二叉树的直径
     * Tips: 设置全局变量 depth，每次递归的时候，判断 depth 是不是最长的
     * 递归遍历过程中，其实是计算left, right 的深度
     *
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
     * No. 566 重塑矩阵
     *
     * @param mat
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int old_r = mat.length;
        int old_c = mat[0].length;

        if (old_r * old_c != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < old_r; i++) {
            for (int j = 0; j < old_c; j++) {
                res[count / c][count % c] = mat[i][j];
                count++;
            }
        }
        return res;
    }

    /**
     * No. 594 最长和谐子序列
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }

        return res;
    }

    /**
     * No. 617 合并二叉树
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    /**
     * No. 637 二叉树的层平均值
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<Double> res = new ArrayList<>();
        TreeNode mark = new TreeNode();
        queue.offer(root);
        queue.offer(mark);

        double sum = 0, count = 0;

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != mark) {
                sum += poll.val;
                count += 1;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            } else {
                res.add(sum / count);
                sum = 0;
                count = 0;
                if (queue.isEmpty()) {
                    break;
                }
                queue.offer(mark);
            }
        }
        return res;
    }

    /**
     * No. 647 回文子串
     *
     * @param s
     * @return
     */
    int cnt_647 = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return cnt_647;
    }

    public void extend(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
            cnt_647++;
        }
    }

    /**
     * No. 680 验证回文串 II
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                continue;
            } else {
                if (isPalindrome_(s.substring(l, r)) || isPalindrome_(s.substring(l + 1, r + 1))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome_(String s) {
        if (s.length() == 1) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) == s.charAt(r--)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * No. 687 最长同值的路径
     *
     * @param root
     * @return
     */
    int length_687 = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs_687(root);
        return length_687;
    }

    public int dfs_687(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs_687(root.left);
        int right = dfs_687(root.right);

        int left_len = 0, right_len = 0;

        left_len = root.left != null && root.left.val == root.val ? left + 1 : 0;
        right_len = root.right != null && root.right.val == root.val ? right + 1 : 0;

        length_687 = Math.max(length_687, left_len + right_len);

        return Math.max(left_len, right_len);
    }

    /**
     * No. 695 岛屿的最大面积
     * Tips: 二叉树DFS的变形，二维矩阵的DFS搜索
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, area(grid, i, j));
                }
            }
        }
        return max;
    }

    public int area(int[][] grid, int row, int cow) {
        if (!isValid(grid, row, cow)) {
            return 0;
        }
        if (grid[row][cow] != 1) {
            return 0;
        }
        grid[row][cow] = 2;

        return 1 + area(grid, row, cow - 1) +
                area(grid, row, cow + 1) +
                area(grid, row - 1, cow) +
                area(grid, row + 1, cow);
    }

    public boolean isValid(int[][] grid, int row, int cow) {
        return row >= 0 && row < grid.length && cow >= 0 && cow < grid[0].length;
    }

    /**
     * No. 696 计数二进制子串
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur += 1;
            }
        }
        return ans + Math.min(prev, cur);
    }

    /**
     * No. 700 二叉搜索树中的搜索
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
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
     * No. 720 字典中最长的单词
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        class Trie {
            boolean isEnd;
            Map<Character, Trie> child;

            public Trie() {
                this.isEnd = false;
                this.child = new HashMap<>();
            }

            public void addWord(String word) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    node.child.putIfAbsent(ch, new Trie());
                    node = node.child.get(ch);
                }
                node.isEnd = true;
            }

            public boolean hasWord(String word) {
                Trie node = this;
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (node.child.containsKey(ch) && node.isEnd == true) {
                        node = node.child.get(ch);
                    } else {
                        return false;
                    }
                }
                return true;
            }
        }

        Trie root = new Trie();
        root.isEnd = true;
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i]);
        }

        String ans = "";
        int maxLen = 0;
        sort(words);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (root.hasWord(word) && word.length() > maxLen) {
                ans = word;
                maxLen = word.length();
            }
        }
        return ans;
    }

    /**
     * No. 739 每日温度
     * 遍历每日温度，若当日温度大于栈顶索引日的温度，说明当日是栈顶元素的升温日，因此
     * 将栈顶元素出栈，计算其与当日的天数差，存放与结果数组中。遍历结束，栈中剩余的元
     * 素没有升温日，保持默认值为 0
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
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
     * No. 748 最短补全词
     *
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String ans = null;
        int ansSize = Integer.MAX_VALUE;
        String lowerCase = licensePlate.toLowerCase();
        int[] count = new int[26];
        countCharactor(lowerCase, count);

        for (String str : words) {
            int[] tempCount = new int[26];
            countCharactor(str, tempCount);
            boolean isCover = true;

            for (int i = 0; i < 26; i++) {
                if (tempCount[i] < count[i]) {
                    isCover = false;
                    break;
                }
            }

            if (isCover && str.length() < ansSize) {
                ans = str;
                ansSize = str.length();
            }
        }

        return ans;
    }

    public void countCharactor(String str, int[] count) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                count[ch - 'a']++;
            }
        }
    }

    /**
     * No. 779 第K个语法符号
     *
     * @param n
     * @param k
     * @return
     */
    public int kthGrammar(int n, int k) {
        int pre = 0;
        for (int p = k - 1, q = n - 1; q >= 0; --q) {
            if (pre == 0) pre = (p & (1 << q)) > 0 ? 1 : 0;
            else pre = (p & (1 << q)) > 0 ? 0 : 1;
        }
        return pre;
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
     * No. 824 山羊拉丁文
     *
     * @param sentence
     * @return
     */
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        String vowel = "aeiouAEIOU";
        String appends = "a";
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            char ch = words[i].charAt(0);
            if (vowel.indexOf(ch) != -1) {
                words[i] = words[i] + "ma";
            } else {
                words[i] = words[i].substring(1) + ch + "ma";
            }
            words[i] = words[i] + appends;
            appends = appends + "a";
        }

        for (String word : words) {
            ans.append(word);
            ans.append(" ");
        }

        return ans.toString().substring(0, ans.length() - 1);
    }

    /**
     * No. 827 最大人工岛
     * Tips: 两次DFS遍历
     * 1. 第一次遍历岛屿，计算每个岛屿的面积并标记该岛屿
     * 2. 第二次遍历海洋，计算与海洋相邻的岛屿的面积之和最大
     *
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        int max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);    //
        int index = 2, curArea;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    curArea = calIsland(grid, i, j, index);
                    max = Math.max(max, curArea);
                    hashMap.put(index++, curArea);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    max = Math.max(max, calConnectSea(grid, i, j, hashMap));
                }
            }
        }
        return max;
    }

    /**
     * DFS计算每个独立岛屿的面积，并将该岛屿的grid值修改为index
     *
     * @param grid
     * @param row
     * @param cow
     * @param index
     * @return
     */
    public int calIsland(int[][] grid, int row, int cow, int index) {
        if (!isValid(grid, row, cow)) {
            return 0;
        }
        if (grid[row][cow] != 1) {
            return 0;
        }
        grid[row][cow] = index;
        return 1 + calIsland(grid, row, cow - 1, index) +
                calIsland(grid, row, cow + 1, index) +
                calIsland(grid, row - 1, cow, index) +
                calIsland(grid, row + 1, cow, index);
    }

    /**
     * 计算将row、cow 位置的海域填充为岛屿后，与其相邻的四块海域全部面积加起来是多少
     * 其中，hashMap是上一步计算出的所有index岛屿的面积，removeRepeat为了减少重复计算
     *
     * @param grid
     * @param row
     * @param cow
     * @param hashMap
     * @return
     */
    public int calConnectSea(int[][] grid, int row, int cow, HashMap<Integer, Integer> hashMap) {
        int upArea, downArea, leftArea, rightArea;
        int upIndex, downIndex, leftIndex, rightIndex;
        int res = 1;
        // 为了降低重复计算，一个填充岛屿的周围可能是同一块岛屿
        HashMap<Integer, Integer> removeRepeat = new HashMap<>();
        if (isValid(grid, row - 1, cow)) {
            upIndex = grid[row - 1][cow];
            upArea = hashMap.get(upIndex);
            removeRepeat.put(upIndex, upArea);
        }
        if (isValid(grid, row + 1, cow)) {
            downIndex = grid[row + 1][cow];
            downArea = hashMap.get(downIndex);
            removeRepeat.put(downIndex, downArea);
        }
        if (isValid(grid, row, cow - 1)) {
            leftIndex = grid[row][cow - 1];
            leftArea = hashMap.get(leftIndex);
            removeRepeat.put(leftIndex, leftArea);
        }
        if (isValid(grid, row, cow + 1)) {
            rightIndex = grid[row][cow + 1];
            rightArea = hashMap.get(rightIndex);
            removeRepeat.put(rightIndex, rightArea);
        }
//        Collection<Integer> values = removeRepeat.values();
        for (Integer value : removeRepeat.values()) {
            res = res + value;
        }
        return res;
    }

    /**
     * No. 831 隐藏个人信息
     *
     * @param s
     * @return
     */
    public String maskPII(String s) {
        int i = s.indexOf('@');
        if (i != -1) {
            return mailPress(s);
        } else {
            return phoneNumberPress(s);
        }
    }

    public String mailPress(String s) {
        String toLowCase = s.toLowerCase();
        String[] split = toLowCase.split("@");

        String instead = "*****";
        StringBuilder name = new StringBuilder(split[0]);
        StringBuilder new_name = name.replace(1, name.length() - 1, instead);
        return new_name.append('@').append(split[1]).toString();
    }

    public String phoneNumberPress(String s) {
        StringBuilder ret = new StringBuilder();
        StringBuilder nums = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch > 47 && ch < 58) {
                nums.append(ch);
            }
        }

        int len = nums.length();
        switch (len) {
            case 10:
                ret.append("***-***-");
                break;
            case 11:
                ret.append("+*-***-***-");
                break;
            case 12:
                ret.append("+**-***-***-");
                break;
            case 13:
                ret.append("+***-***-***-");
                break;
        }

        ret.append(nums.substring(nums.length() - 4));
        return ret.toString();
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
     * No. 873 最长的斐波那契子序列的长度
     * @param arr
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int maxLength = 0;
        int tempLength = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                tempLength = 2;
                int left = arr[i], right = arr[j];
                int tempSum = left + right;
                while (set.contains(tempSum)) {
                    tempLength++;
                    left = right;
                    right = tempSum;
                    tempSum = left + right;
                }
                maxLength = Math.max(maxLength, tempLength);
            }
        }
        return maxLength == 2 ? 0 : maxLength;
    }

    @Test
    public void testxxx() {
        int[] arr = {1, 3, 7, 11, 12, 14, 18};
        System.out.println(lenLongestFibSubseq(arr));
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
        sort(chars);
        s = new String(chars);
        return new StringBuilder(s);
    }

    /**
     * No. 921 使括号有效的最少添加
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        int left_count = 0, right_count = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                left_count++;
            } else {
                if (left_count > 0) {
                    left_count--;
                } else {
                    right_count++;
                }
            }
        }
        return left_count + right_count;
    }

    /**
     * No. 1010 总持续时间可以被60整除的歌曲
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] timeCount = new int[60];

        for (int i : time) {
            timeCount[i % 60]++;
        }

        for (int i = 1; i < 30; i++) {
            ans += (timeCount[i] * timeCount[60 - i]);
        }

//        ans += timeCount[0] / 2 * (timeCount[0] - 1);
//        ans += timeCount[30] / 2 * (timeCount[30] - 1);

        if (timeCount[0] % 2 == 0) {
            ans += timeCount[0] / 2 * (timeCount[0] - 1);
        } else {
            ans += (timeCount[0] - 1) / 2 * timeCount[0];
        }

        if (timeCount[30] % 2 == 0) {
            ans += timeCount[30] / 2 * (timeCount[30] - 1);
        } else {
            ans += (timeCount[30] - 1) / 2 * timeCount[30];
        }

        return ans;
    }

    /**
     * No. 970 强整数
     *
     * @param x
     * @param y
     * @param bountd
     * @return
     */
    public List<Integer> powerfulIntegers(int x, int y, int bountd) {
        HashSet<Integer> set = new HashSet<>();
        int value1 = 1;

        for (int i = 0; i < 21; i++) {
            int value2 = 1;
            for (int j = 0; j < 21; j++) {
                int value = value1 + value2;
                if (value <= bountd) {
                    set.add(value);
                } else {
                    break;
                }
                value2 *= y;
            }
            if (value1 > bountd) {
                break;
            }
            value1 *= x;
        }
        return new ArrayList<Integer>(set);
    }

    /**
     * No. 1019 链表中的下一个更大节点
     *
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        Queue<ListNode> queue = new LinkedList();
        int total = 0;
        ListNode cur = head;
        while (cur != null) {
            queue.add(cur);
            total++;
            cur = cur.next;
        }
        int[] ans = new int[total];
        int cur_index = -1;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            int cur_val = poll.val;
            cur_index++;
            poll = poll.next;
            while (poll != null) {
                if (poll.val > cur_val) {
                    ans[cur_index] = poll.val;
                }
            }
        }
        return ans;
    }

    /**
     * No. 1023 驼峰式匹配
     *
     * @param queries
     * @param pattern
     * @return
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            if (isMatched_1023(query, pattern)) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    /**
     * 相等 直接跳过 p + 1, q + 1
     * 大     小  【无法匹配】直接返回 false
     * 大     大  【无法匹配】直接返回 false
     * 小     大  【无法匹配】q 向后移动一位
     * 小     小  【无法匹配】q 向后移动一位
     *
     * @param query
     * @param pattern
     * @return
     */
    public static Boolean isMatched_1023(String query, String pattern) {
        int q = 0, p = 0;
        while (q < query.length() && p < pattern.length()) {
            char ch_q = query.charAt(q);
            char ch_p = pattern.charAt(p);

            if (ch_q == ch_p) {  // 如果 q 和 p 指向的位置，相等，则 p 和 q 分别向后移动一位
                q++;
                p++;
            } else {
                if (ch_q <= 90) {    // 如果不相等，q 字符是大写字母，那么一定不能匹配（因为 pattern 只能插入小写字符）
                    return false;
                } else {    // 如果 q 字符是小写字符，那么可以将 q 向后移动一位（因为 pattern 可以插入小写字符）
                    q++;
                }
            }
        }
        if (q != query.length()) {    // 当 q 没有到达末尾的时候，如果剩下的字符都是小写字符，那么可以认为 成功匹配
            for (int i = q + 1; i < query.length(); i++) {
                if (query.charAt(i) <= 90) {
                    return false;
                }
            }
        }
        if (p != pattern.length()) {    // 如果 p 没有到达末尾，那么一定无法匹配
            return false;
        }
        return true;    // 其他情况是两者都同时到达末尾，认为成功匹配
    }

    /**
     * No. 1026 节点与其祖先之间的最大差值
     *
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            ans = Math.max(ans, maxOfSingleNode(temp));
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return ans;
    }

    /**
     * 按层次遍历返回 root 节点的所有孩子节点中 最大值与最小值的差值绝对值
     * A - B = MAX - MIN
     * 如果 root 节点是叶子节点，则返回 0，因为单节点无法计算
     *
     * @param root
     * @return
     */
    public int maxOfSingleNode(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int A = Integer.MIN_VALUE;
        int B = Integer.MAX_VALUE;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            A = Math.max(A, temp.val);
            B = Math.min(B, temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        return Math.max(A - root.val, root.val - B);
    }

    /**
     * No. 1029 两地调度
     *
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; ++i) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }

    /**
     * No. 1035 不相交的线
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * No. 1041 困于环中的机器人
     *
     * @param instructions
     * @return
     */
    public boolean isRobotBounded(String instructions) {
        // 起始位置 (x, y) -> (0, 0)
        // 起始朝向：north = 0, right = 1, down = 2, left = 3
        // position[0] = x, position[1] = y, position[2] = direction
        int[] position = new int[]{0, 0, 0};

        for (int i = 0; i < instructions.length(); i++) {
            char move = instructions.charAt(i);
            move_1041(move, position);
        }
        if (position[0] == 0 && position[1] == 0 || position[2] != 0) {
            return true;
        }
        return false;
    }

    public static void move_1041(char action, int[] position) {
        // position[0] = x, position[1] = y, position[2] = direction
        switch (action) {
            case 'G':
                if (position[2] == 0) {
                    position[1]++;
                } else if (position[2] == 1) {
                    position[0]++;
                } else if (position[2] == 2) {
                    position[1]--;
                } else {
                    position[0]--;
                }
                break;
            case 'L':
                position[2] = (position[2] + 3) % 4;
                break;
            case 'R':
                position[2] = (position[2] + 1) % 4;
                break;
        }
    }

    /**
     * No. 1042 不临接植花
     *
     * @param n
     * @param paths
     * @return
     */
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 构建邻接表
        for (int i = 0; i < paths.length; i++) {
            graph.get(paths[i][0] - 1).add(paths[i][1] - 1);
            graph.get(paths[i][1] - 1).add(paths[i][0] - 1);
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> color = new HashSet<Integer>() {{
                add(1);
                add(2);
                add(3);
                add(4);
            }};
            // 依次从 color set 中移除与自己连接的已经吐涂过的节点颜色（没有涂的颜色为0）
            for (int j = 0; j < graph.get(i).size(); j++) {
                color.remove(ans[graph.get(i).get(j)]);
            }
            ans[i] = color.iterator().next();
        }
        return ans;
    }

    /**
     * No. 1047 删除字符串中所有相邻重复项
     * Tips 使用栈来实现相邻重复字符的删除，这里使用StringBuilder的append和deleteCharAt方法
     * 来实现栈
     *
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    /**
     * No. 1053 交换一次的先前排列
     * Tips: 因为交换后的序列需要比原先的序列字典序小，所以，如果原先序列是升序，那么直接返回原先序列即可
     * 从后往前找到原先序列的第一个降序子序列的起始点，这个起始点可以和后面的某一个值进行交换（降序序列代表后面的值一定小于该点的值）
     * 从降序序列的起止点开始向后寻找，寻找小于该点值的最大值，进行交换
     * 交换后的序列，一定是比原来字典序小的最大字典序序列
     *
     * @param arr
     * @return
     */
    public int[] prevPermOpt1(int[] arr) {
        int swap_index = -1;
        int max_index = -1;
        int max_value = Integer.MIN_VALUE;
        for (int back = arr.length - 1; back > 0; --back) {
            if (arr[back - 1] > arr[back]) {
                swap_index = back;
                break;
            }
        }
        if (swap_index != -1) {
            for (int i = swap_index; i < arr.length; i++) {
                if (arr[i] >= arr[swap_index - 1]) {
                    continue;
                }
                if (arr[i] > max_value) {
                    max_value = arr[i];
                    max_index = i;
                }
            }
            int temp = arr[max_index];
            arr[max_index] = arr[swap_index - 1];
            arr[swap_index - 1] = temp;
        }
        return arr;
    }

    /**
     * No. 1054 距离相等的条形码
     * @param barcodes
     * @return
     */
//    public int[] rearrangeBarcodes(int[] barcodes) {
//
//    }

    /**
     * No. 1072 按列翻转得到的最大值等行数
     * 如果一个行的所有元素值和另外一行完全相同或者完全相反，那么这两行是等值的（001 == 110），因为他们可以完全由对方完全翻转获得
     *
     * @param matrix
     * @return
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int maxCount = 0;
        int m = matrix.length, n = matrix[0].length;
        HashMap<String, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int firstColValue = matrix[i][0];
            if (firstColValue == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 1 - matrix[i][j];
                }
            }
            String stringRow = Arrays.toString(matrix[i]);
            hashmap.put(stringRow, hashmap.getOrDefault(stringRow, 0) + 1);
            maxCount = Math.max(maxCount, hashmap.get(stringRow));
        }

        return maxCount;
    }

    /**
     * No. 1079 活字印刷
     *
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char t : tiles.toCharArray()) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        Set<Character> tile = new HashSet<>(count.keySet());
        return dfs_1079(tiles.length(), count, tile) - 1;
    }

    public int dfs_1079(int i, Map<Character, Integer> count, Set<Character> tile) {
        if (i == 0) {
            return 1;
        }
        int res = 1;
        for (char t : tile) {
            if (count.get(t) > 0) {
                count.put(t, count.get(t) - 1);
                res += dfs_1079(i - 1, count, tile);
                count.put(t, count.get(t) + 1);
            }
        }
        return res;
    }

    /**
     * No. 1080 根到叶路径上不足节点
     *
     * @param root
     * @param limit
     * @return
     */
    public TreeNode sufficientSubset(TreeNode root, int limit) {

        if (root == null) {
            return null;
        }

        if (root.left == root.right) {
            if (root.val < limit) {
                return null;
            }
            return root;
        }

        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);

        if (root.left == null && root.right == null) {
            return null;
        }

        return root;
    }

    /**
     * No. 1090 受标签影响的最大值
     *
     * @param values
     * @param labels
     * @param numWanted
     * @param useLimit
     * @return
     */
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        Integer[] id = new Integer[n];

        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

        Arrays.sort(id, (a, b) -> values[b] - values[a]);

        int ans = 0, choose = 0;

        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n && choose < numWanted; ++i) {
            int label = labels[id[i]];
            if (cnt.getOrDefault(label, 0) == useLimit) {
                continue;
            }
            ++choose;
            ans += values[id[i]];
            cnt.put(label, cnt.getOrDefault(label, 0) + 1);
        }
        return ans;
    }

    @Test
    public void testlarge() {
        int[] values = new int[]{5, 4, 3, 2, 1};
        int[] labels = new int[]{1, 1, 2, 2, 3};
        System.out.println(largestValsFromLabels(values, labels, 3, 1));
    }

    /**
     * No. 1091 二进制矩阵中的最短路径
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1];
            if (x == n - 1 && y == n - 1) {
                return dist[x][y];
            }
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (!isInGrid(grid, x + dx, y + dy) || grid[x + dx][y + dy] == 1) {  // 越界或值为1
                        continue;
                    }
                    if (dist[x + dx][y + dy] <= dist[x][y] + 1) {  // 已经访问过（因为初始值是Ingeter.MAX_VALUE）
                        continue;
                    }
                    dist[x + dx][y + dy] = dist[x][y] + 1;
                    queue.offer(new int[]{x + dx, y + dy});
                }
            }
        }
        return -1;
    }

    public boolean isInGrid(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid.length;
    }

    /**
     * No. 1093 大样本统计
     *
     * @param count
     * @return
     */
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                ans[0] = i;
                break;
            }
        }

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != 0) {
                ans[1] = i;
                break;
            }
        }

        double sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += (double) count[i] * i;
        }
        int numbers = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                numbers += count[i];
            }
        }
        ans[2] = sum / numbers;

        if (numbers % 2 == 0) {
            int mid_left = (numbers - 1) / 2;
            int mid_right = mid_left + 1;
            int current_index = -1;
            double left = 0;
            double right = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    current_index += count[i];
                    if (current_index >= mid_left) {
                        left = i;
                        break;
                    }
                }
            }
            current_index = -1;
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    current_index += count[i];
                    if (current_index >= mid_right) {
                        right = i;
                        break;
                    }
                }
            }
            ans[3] = (left + right) / 2;
        } else {
            int currentIndex = -1;
            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    currentIndex += count[i];
                    if (currentIndex >= (numbers - 1) / 2) {
                        ans[3] = i;
                        break;
                    }
                }
            }
        }

        int maxExist = 0, maxExistIndex = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxExist) {
                maxExist = count[i];
                maxExistIndex = i;
            }
        }
        ans[4] = maxExistIndex;

        return ans;
    }

    /**
     * No. 1110 删点成林
     *
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        List<TreeNode> ans = new ArrayList<>();
        if (dfs_1110(ans, set, root) != null) {
            ans.add(root);
        }
        return ans;
    }

    public TreeNode dfs_1110(List<TreeNode> ans, Set<Integer> set, TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = dfs_1110(ans, set, node.left);
        node.right = dfs_1110(ans, set, node.right);
        if (!set.contains(node.val)) {
            return node;
        }
        if (node.left != null) {
            ans.add(node.left);
        }
        if (node.right != null) {
            ans.add(node.right);
        }
        return null;
    }


    /**
     * No. 1129 颜色交替的最短路径
     *
     * @param n
     * @param redEdges
     * @param blueEdges
     * @return
     */
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        int[][] edges = new int[n][n];
        int[] visited = new int[n];
        int row, cow, pathLong = 0, curColor = -1;
        int[] curNode = new int[2];
        Queue<int[]> queue = new LinkedList<>();

        fill(ans, -1);

        // redEdges value = 1
        for (int i = 0; i < redEdges.length; i++) {
            row = redEdges[i][0];
            cow = redEdges[i][1];
            edges[row][cow] = 1;
        }
        // blueEdges value = 2
        for (int i = 0; i < blueEdges.length; i++) {
            row = blueEdges[i][0];
            cow = blueEdges[i][1];
            edges[row][cow] = 2;
        }

        queue.add(new int[]{0, curColor});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                curNode = queue.poll();
                curColor = curNode[1];
                visited[curNode[0]] = 1;
                ans[curNode[0]] = pathLong;
                for (int i = 0; i < n; i++) {
                    if (edges[curNode[0]][i] != 0 && visited[i] != 1 &&
                            edges[curNode[0]][i] != curColor) {
                        queue.add(new int[]{i, edges[curNode[0]][i]});
                    }
                }
            }
            pathLong++;
        }
        return ans;
    }

    /**
     * No. 1139 最大的以1为边界的正方形
     *
     * @param grid
     * @return
     */
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rs = new int[m][n + 1], cs = new int[n][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rs[i][j + 1] = rs[i][j] + grid[i][j];
                cs[j][i + 1] = cs[j][i] + grid[i][j];
            }
        }
        for (int d = Math.min(m, n); d > 0; d--) {
            for (int i = 0; i <= m - d; i++) {
                for (int j = 0; j <= n - d; j++) {
                    if (rs[i][j + d] - rs[i][j] == d &&
                            cs[j][i + d] - cs[j][i] == d &&
                            rs[i + d - 1][j + d] - rs[i + d - 1][j] == d &&
                            cs[j + d - 1][i + d] - cs[j + d - 1][i] == d)
                        return d * d;
                }
            }
        }
        return 0;
    }

    /**
     * No. 1145 二叉树着色游戏
     * Tips: 本题可以转换为一个统计二叉树节点数量的问题。节点X将整个二叉树分为了3个部分：左孩子树、右孩子树、父节点数
     *
     * @param root
     * @param n
     * @param x
     * @return
     */
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x_1145 = x;
        dfs_1145(root);
        return Math.max(Math.max(lsz_1145, rsz_1145), n - 1 - lsz_1145 - rsz_1145) * 2 > n;
    }

    private int x_1145, lsz_1145, rsz_1145;

    public int dfs_1145(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ls = dfs_1145(node.left);
        int rs = dfs_1145(node.right);
        if (node.val == x_1145) {
            lsz_1145 = ls;
            rsz_1145 = rs;
        }
        return ls + rs + 1;
    }

    /**
     * No. 1170 比较字符串最小字母出现次数
     * @param queries
     * @param words
     * @return
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] queriesArray = new int[queries.length];
        int[] wordsArray = new int[words.length];

        for (int i = 0; i < queries.length; i++) {
            queriesArray[i] = f_1170(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wordsArray[i] = f_1170(words[i]);
        }
        for (int i = 0; i < queriesArray.length; i++) {
            for (int j = 0; j < wordsArray.length; j++) {
                if (queriesArray[i] < wordsArray[j]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    public int f_1170(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return count[i];
            }
        }
        return 0;
    }

    /**
     * No. 1171 从链表中删去总和为零的连续节点
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer, ListNode> seen = new HashMap<>();
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            seen.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = seen.get(prefix).next;
        }
        return dummy.next;
    }

    /**
     * No. 1177 构建回文串检测
     * @param s
     * @param queries
     * @return
     */
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            sum[i + 1] = sum[i] ^ bit; // 该比特对应字母的奇偶性：奇数变偶数，偶数变奇数
        }

        List<Boolean> ans = new ArrayList<Boolean>(queries.length); // 预分配空间
        for (int[] q : queries) {
            int left = q[0], right = q[1], k = q[2];
            int m = Integer.bitCount(sum[right + 1] ^ sum[left]);
            ans.add(m / 2 <= k);
        }
        return ans;
    }

    /**
     * No. 1210 穿过迷宫的最少移动次数
     * Tips: 将贪吃蛇的坐标和方向用一个int[] {x, y, s} 三元组表示
     * 1, 0, 0 表示向右移动
     * 0, 1, 0 表示向下移动
     * 0, 0, 1 表示旋转（这里可以用 ^ 异或运算表示旋转）
     * <p>
     * 使用广度优先搜索 BFS 算法，记录每次的路径
     *
     * @param grid
     * @return
     */
    private static int[][] DIRS = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        boolean[][][] vis = new boolean[n][n][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        vis[0][0][0] = true;
        for (int steps = 1; !queue.isEmpty(); steps++) {
            Queue<int[]> tmp = queue;
            queue = new LinkedList<>();
            for (int[] t : tmp) {
                for (int[] d : DIRS) {
                    int x = t[0] + d[0];
                    int y = t[1] + d[1];
                    int s = t[2] ^ d[2];
                    int x2 = x + s;
                    int y2 = y + (s ^ 1);

                    if (x2 < n && y2 < n && !vis[x][y][s] &&
                            grid[x][y] == 0 && grid[x2][y2] == 0 &&
                            (d[2] == 0 || grid[x + 1][y + 1] == 0)) {
                        if (x == n - 1 && y == n - 2) {
                            return steps;
                        }
                        vis[x][y][s] = true;
                        queue.add(new int[]{x, y, s});
                    }
                }
            }
        }
        return -1;
    }

    /**
     * No. 1220 统计元音字母序列的数目
     *
     * @param n
     * @return
     */
    public int countVowelPermutation(int n) {
        long mod = (long) 1e9 + 7;
        long[] dp = new long[5];
        long[] ndp = new long[5];

        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            ndp[1] = (dp[0] + dp[2]) % mod;
            ndp[2] = (dp[1] + dp[3]) % mod;
            ndp[3] = dp[2];
            ndp[4] = (dp[2] + dp[3]) % mod;

            System.arraycopy(ndp, 0, dp, 0, 5);
        }

        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[i]) % mod;
        }

        return (int) ans;
    }

    /**
     * No. 1233 删除子文件夹
     *
     * @param folder
     * @return
     */
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; i++) {
            List<String> dir = split_1233(folder[i]);
            Trie cur = root;
            for (String name : dir) {
                cur.children.putIfAbsent(name, new Trie());
                cur = cur.children.get(name);
            }
            cur.ref = i;
        }

        List<String> ans = new ArrayList<>();
        dfs_1233(folder, ans, root);
        return ans;
    }

    public List<String> split_1233(String s) {
        List<String> ret = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '/') {
                ret.add(cur.toString());
                cur.setLength(0);
            } else {
                cur.append(ch);
            }
        }
        ret.add(cur.toString());
        return ret;
    }

    public void dfs_1233(String[] folder, List<String> ans, Trie cur) {
        if (cur.ref >= 0) {
            ans.add(folder[cur.ref]);
            return;
        }
        for (Trie child : cur.children.values()) {
            dfs_1233(folder, ans, child);
        }
    }

    /**
     * No. 1237 找出给定方程的正整数解
     *     Tips：直接枚举所有结果，即可AC
     * @param customFunction
     * @param z
     * @return
     */
//    public List<List<Integer>> findSolution(CustomFunction customFunction, int z) {
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int i = 1; i <= 1000; i++) {
//            for (int j = 1; j <= 1000; j++) {
//                if (customFunction.f(i, j) == z) {
//                    List<Integer> pairs = new ArrayList<>();
//                    pairs.add(i);
//                    pairs.add(j);
//                    ans.add(pairs);
//                }
//            }
//        }
//        return ans;
//    }

    /**
     * No. 1255 得分最高的单词集合
     *
     * @param words
     * @param letters
     * @param score
     * @return
     */
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int[] count = new int[26];
        for (char ch : letters) {
            count[ch - 'a']++;
        }
        for (int i = 1; i < 1 << n; i++) {

        }
        return 0;
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
            fill(pad[i], '*');
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
     * No. 1300 转变数组后最接近目标值的数组和
     *
     * @param var
     * @param target
     * @return
     */
    public int findBestValue(int[] var, int target) {
        sort(var);
        int len = var.length;
        int cur_sum = 0;

        for (int i = 0; i < len; i++) {
            int cur_avg = (target - cur_sum) / (len - i);
            // 如果当前位置的值 比 已经计算的后面所需的平均值大【意味着，后面加起来一定 > target】
            if (cur_avg < var[i]) {
                // 平均值不一定是整除，这里用double保留小数位
                double curAveDou = (target * 1.0 - cur_sum) / (len - i);
                if (curAveDou - cur_avg <= 0.5) {
                    return cur_avg;
                } else {
                    return cur_avg + 1;
                }
            }
            // 如果当前位置的平均值小于 当前位置的值，代表这个位置的值之后变大，sum也不会超过target
            cur_sum += var[i];
        }
        // 返回数组最后一位，也就是所求的value值
        return var[len - 1];
    }

    /**
     * No. 1306 跳跃游戏III
     *
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[arr.length];
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (arr[poll] == 0) {
                return true;
            }
            if (visited[poll] == 1) {
                continue;
            }
            visited[poll] = 1;
            if (poll + arr[poll] >= 0 && poll + arr[poll] < arr.length) {
                queue.add(poll + arr[poll]);
            }
            if (poll - arr[poll] >= 0 && poll - arr[poll] < arr.length) {
                queue.add(poll - arr[poll]);
            }
        }
        return false;
    }

    @Test
    public void mmmtest() {
    }

    /**
     * No. 1323 6和9组成的最大数字
     *
     * @param num
     * @return
     */
    public int maximum69Number(int num) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = sb.charAt(i);
            if (ch == '6') {
                sb.setCharAt(i, '9');
                break;
            }
        }
        s = sb.toString();
        return Integer.parseInt(s);
    }

    /**
     * No. 1331 数组序号转换
     * Tips: HashMap 在 put 的过程中，对不同元素，有计数的功能
     *
     * @param arr
     * @return
     */
    public int[] arrayRankTransform(int[] arr) {
        int[] copyedArr = copyOf(arr, arr.length);
        int[] res = new int[arr.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        sort(copyedArr);

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
     * No. 1375 二进制字符串前缀一致的次数
     * @param flips
     * @return
     */
    public int numTimesAllBlue(int[] flips) {
        int n = flips.length;
        int ans = 0, right = 0;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, flips[i]);
            if (right == i + 1) {
                ++ans;
            }
        }
        return ans;
    }
    public int numTimesAllBlue_(int[] flips) {
        char[] chars = new char[flips.length];
        Arrays.fill(chars, '0');

        int count = 0;
        for (int i = 0; i < flips.length; i++) {
            chars[flips[i] - 1] = '1';
            if (isSame(chars, i + 1)) {
                count++;
            }
        }

        return count;
    }

    public boolean isSame(char[] flips, int times) {
        for (int i = 0; i < times; i++) {
            if (flips[i] != '1') {
                return false;
            }
        }
        return true;
    }

    /**
     * No. 1445 定长子串中元音的最大数目
     *
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        int left = 0, right = k - 1;
        int count = 0, max_count = Integer.MIN_VALUE;
        for (int i = 0; i <= right; i++) {
            if (isVowels(s.charAt(i))) {
                count++;
            }
        }
        if (count == k) {
            return count;
        }
        max_count = Math.max(count, max_count);
        while (right < s.length() - 1) {
            char ch_l = s.charAt(left);
            ++left;
            ++right;
            char ch_r = s.charAt(right);
            if (((isVowels(ch_l)) && !(isVowels(ch_r)))) {
                --count;
            } else if ((!(isVowels(ch_l)) && (isVowels(ch_r)))) {
                ++count;
            }
            max_count = Math.max(max_count, count);
        }
        return max_count;
    }

    public boolean isVowels(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    /**
     * No. 1465 切割后面积最大的蛋糕
     *
     * @param h
     * @param w
     * @param horizontalCuts
     * @param verticalCuts
     * @return
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int MOD = 1000000007;
        sort(horizontalCuts);
        sort(verticalCuts);
        long max_h = Integer.MIN_VALUE, max_v = Integer.MIN_VALUE;
        max_h = Math.max(max_h, horizontalCuts[0]);
        max_v = Math.max(max_v, verticalCuts[0]);

        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            max_h = Math.max(max_h, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            max_v = Math.max(max_v, verticalCuts[i + 1] - verticalCuts[i]);
        }
        max_h = Math.max(max_h, h - horizontalCuts[horizontalCuts.length - 1]);
        max_v = Math.max(max_v, w - verticalCuts[verticalCuts.length - 1]);
        return (int) ((max_h * max_v) % MOD);
    }

    /**
     * No. 不同整数的最少数目
     *
     * @param arr
     * @param k
     * @return
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 创建哈希表，并统计每个数字出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 创建比较器，用于优先队列的元素比较大小
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        };

        // 创建优先队列，队列的前端次数最少，队列的尾端，次数最大
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(comparator);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
        }

        // 优先队列的顶部元素出队判断，如果value值大于1，那么当前元素出队后，需要再次入队。否则直接出队
        // 出队入队的操作可以根据 value 值的大小，进行优化【未实现】
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = priorityQueue.poll();
            Integer value = poll.getValue();
            if (value > 1) {
                poll.setValue(value - 1);
                priorityQueue.offer(poll);
            }
        }

        // 最终队列的长度，就是调整后，不同数字的个数
        return priorityQueue.size();
    }

    /**
     * No. 1487 保证文件名唯一
     *
     * @param names
     * @return
     */
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<String> ret = new ArrayList<>();
        for (String name : names) {
            if (hashMap.containsKey(name)) {
                int k = hashMap.get(name);
                while (hashMap.containsKey(name + "(" + k + ")")) {
                    k++;
                }
                ret.add(name + "(" + k + ")");
                hashMap.put(name, k + 1);
                hashMap.put(name + "(" + k + ")", 1);
            } else {
                hashMap.put(name, 1);
                ret.add(name);
            }
        }
        String[] ans = new String[ret.size()];
        ans = ret.toArray(ans);
        return ans;
    }

    /**
     * No. 1497 检查数组对是否可以被k整除
     *
     * @param arr
     * @param K
     * @return
     */
    public boolean canArrange(int[] arr, int K) {
        int[] count = new int[K];
        for (int num : arr) {
            count[(num % K + K) % K]++;  // 这里保证负数也可以被取余数
        }
        for (int i = 1; i + i < K; i++) {
            if (count[i] != count[K - i]) {
                return false;
            }
        }
        return count[0] % 2 == 0;  // 如果 0 位置的统计数量为奇数，那么 剩下的一个位置的数，也一定为奇数，则找不到与其对应的配对数
    }

    /**
     * No. 1509 三次操作后最大值与最小值的最小差
     *
     * @param nums
     * @return
     */
    public int minDifference_(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        sort(nums);
        int min = Integer.MAX_VALUE;
        min = Math.min(min, nums[nums.length - 1] - nums[3]);
        min = Math.min(min, nums[nums.length - 4] - nums[0]);
        min = Math.min(min, nums[nums.length - 2] - nums[2]);
        min = Math.min(min, nums[nums.length - 3] - nums[1]);
        return min;
    }

    public int minDifference(int[] nums) {
        int n = nums.length;
        if (nums.length <= 4) {
            return 0;
        }
        sort(nums);
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ret = Math.min(ret, nums[n - 4 + i] - nums[i]);
        }
        return ret;
    }

    /**
     * No. 1574 删除最短的子数组使剩余数组有序
     *
     * @param arr
     * @return
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;

        while (i + 1 < n && arr[i] <= arr[i + 1]) {
            ++i;
        }
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            --j;
        }

        if (i >= j) {
            return 0;
        }

        int ans = Math.min(n - i - 1, j);
        for (int l = 0; l <= i; ++l) {
            int r = search_1574(arr, arr[l], j);
            ans = Math.min(ans, r - l - 1);
        }
        return ans;
    }

    public int search_1574(int[] arr, int x, int left) {
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * No. 1575 统计所有可行路径
     * Tips: 动态规划
     *
     * @param locations
     * @param start
     * @param finish
     * @param fuel
     * @return
     */
    static final int MOD = 1000000007;

    int[][] f;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        f = new int[locations.length][fuel + 1];
        for (int[] row : f) {
            fill(row, -1);
        }
        return dfs_1575(locations, start, finish, fuel);
    }

    /**
     * @param locations 城市location数组
     * @param pos       当前所处城市 position
     * @param finish    目的城市
     * @param rest      当前所剩的汽油量
     * @return 返回当前城市、所剩汽油数量 距 finish 目的城市一共有多少种路径
     */
    public int dfs_1575(int[] locations, int pos, int finish, int rest) {
        // 当前情况已经计算过
        if (f[pos][rest] != -1) {
            return f[pos][rest];
        }

        f[pos][rest] = 0; // 计算之前，置零
        if (Math.abs(locations[pos] - locations[finish]) > rest) {
            return 0;  // 如果两点直线距离 rest 数量的汽油都不可达，那么肯定没有路径可选
        }

        int n = locations.length;
        for (int i = 0; i < n; ++i) {
            if (pos != i) {  // 需要跳过当前节点
                int cost;
                if ((cost = Math.abs(locations[pos] - locations[i])) <= rest) {
                    f[pos][rest] += dfs_1575(locations, i, finish, rest - cost);
                    f[pos][rest] %= MOD;
                }
            }
        }
        if (pos == finish) {
            f[pos][rest] += 1;
            f[pos][rest] %= MOD;
        }
        return f[pos][rest];
    }

    /**
     * No. 1604 警告一小时内使用相同员工卡大于等于三次的人
     *
     * @param keyName
     * @param keyTime
     * @return
     */
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        List<String> ans = new ArrayList<>();
        int H_m = 0, M = 0, minutes;
        for (int i = 0; i < keyName.length; i++) {
            hashMap.putIfAbsent(keyName[i], new ArrayList<>());
            H_m = ((keyTime[i].charAt(0) - '0') * 10 + (keyTime[i].charAt(1) - '0')) * 60;
            M = (keyTime[i].charAt(3) - '0') * 10 + (keyTime[i].charAt(4) - '0');
            minutes = H_m + M;
            hashMap.get(keyName[i]).add(minutes);
        }
        Set<String> strings = hashMap.keySet();
        for (String name : strings) {
            List<Integer> list = hashMap.get(name);
            Collections.sort(list);
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    /**
     * No. 1605 给定行和列的和，求可行的矩阵
     *
     * @param rowSum
     * @param colSum
     * @return
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowLen = rowSum.length;
        int colLen = colSum.length;

        int[][] ans = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                ans[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return ans;
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
     * No. 1615 最大网络秩
     * Tips: 直接枚举所有城市对之间的连接数量，如果两个城市之间存在连接，则结果-1
     * 如果
     *
     * @param n
     * @param roads
     * @return
     */
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] matrix = new int[n][n + 1];

        // 构建邻接矩阵
        for (int[] path : roads) {
            matrix[path[0]][path[1]] = 1;
            matrix[path[1]][path[0]] = 1;
        }

        // 求i城市的度，结果存放在邻接矩阵的最后一列，matrix[i][n]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][n] += matrix[i][j];
            }
        }

        // 枚举所有的城市对，如果这两个城市之间存在连接，那么结果 -1，求取最大的即可
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int max_tmp = 0;
            for (int j = i + 1; j < n; j++) {
                max_tmp = matrix[i][n] + matrix[j][n];
                max_tmp = matrix[i][j] == 1 ? max_tmp - 1 : max_tmp;
                ans = Math.max(ans, max_tmp);
            }
        }
        return ans;
    }

    /**
     * No. 1626 无矛盾的最佳球队
     *
     * @param scores
     * @param ages
     * @return
     */
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] people = new int[n][2];

        for (int i = 0; i < n; i++) {
            people[i] = new int[]{scores[i], ages[i]};
        }

        sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * No. 1630 等差子数组
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        int zooms = l.length;
        for (int i = 0; i < zooms; i++) {
            boolean isFalse = false;
            int left = l[i];
            int right = r[i];
            int[] zoom = copyOfRange(nums, left, right + 1);
            sort(zoom);
            int step = zoom[1] - zoom[0];
            for (int j = 1; j < zoom.length; j++) {
                if (zoom[j] - zoom[j - 1] != step) {
                    isFalse = true;
                    break;
                }
            }

            boolean b = isFalse ? ans.add(false) : ans.add(true);
        }
        return ans;
    }

    /**
     * No. 1637 两点之间不包含任何点的最宽垂直区域
     *
     * @param points
     * @return
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }

        return ans;
    }

    /**
     * No. 1641 统计字典序元音字符串的数目
     *
     * @param n
     * @return
     */
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[j] += dp[j - 1];
            }
        }

        int ans = 0;
        for (int i : dp) {
            ans += i;
        }

        return ans;
    }

    /**
     * No. 1653 使字符串平衡的最少删除次数
     * Tips: 1 如果字符串中存在 "ba"，那么一定不是平衡的串，将其替换为空串，最后字符串的长度
     * 除以2就是需要删除的操作次数
     * 2 a a a a | b b b b ，平衡的串一定是 a 在 b 的左边，枚举所有的 | 的位置，计算次数
     *
     * @param s
     * @return
     */
    public int minimumDeletions(String s) {
        int len = s.length();
        while (s.indexOf("ba") >= 0) {
            s = s.replace("ba", "");
        }
        return (len - s.length()) / 2;
    }

    /**
     * No. 1695 删除子数组的最大得分
     *
     * @param nums
     * @return
     */
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int l = 0, r = 0, sum = 0, ans = 0;

        while (r < nums.length) {
            int num = nums[r];
            if (!hashSet.contains(num)) {
                hashSet.add(num);
                ++r;
                sum += num;
            } else {
                ans = Math.max(ans, sum);
                while (nums[l] != num) {
                    hashSet.remove(nums[l]);
                    sum -= nums[l];
                    ++l;
                }
                ++l;
                ++r;
            }
        }
        ans = Math.max(ans, sum);
        return ans;
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
     * No. 1775 通过最少操作次数使数组的和相等
     * nums1 的最小值 1 * nums1.length，最大值： 6 * nums1.length;
     * nums2 的最小值 1 * nums2.length，最大值： 6 * nums2.length;
     * 如果 nums1[min, max] 和 nums2[min, max] 没有交集，那么，两个数组和不可能相等
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (6 * n < m || 6 * m < n) {
            return -1;
        }
        int[] cnt1 = new int[7];
        int[] cnt2 = new int[7];
        int diff = 0;
        for (int i : nums1) {
            ++cnt1[i];
            diff += i;
        }
        for (int i : nums2) {
            ++cnt2[i];
            diff -= i;
        }
        if (diff == 0) {
            return 0;
        }
        if (diff > 0) {
            return help(cnt2, cnt1, diff);
        }
        return help(cnt1, cnt2, -diff);
    }

    public int help(int[] h1, int[] h2, int diff) {
        int[] h = new int[7];
        for (int i = 1; i < 7; ++i) {
            h[6 - i] += h1[i];
            h[i - 1] += h2[i];
        }
        int res = 0;
        for (int i = 5; i > 0 && diff > 0; --i) {
            int t = Math.min((diff + i - 1) / i, h[i]);
            res += t;
            diff -= t * i;
        }
        return res;
    }

    /**
     * No. 1798 你能构造出连续值的最大数目
     *
     * @param coins
     * @return
     */
    public int getMaximumConsecutive(int[] coins) {
        sort(coins);
        int x = 0;
        for (int y : coins) {
            if (y > x + 1) {
                break;
            }
            x += y;
        }
        return x + 1;
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
     *
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

        int s1_left = 0, s1_right = s1.length - 1, s2_left = 0, s2_right = s2.length - 1;
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
     * No. 1814 统计一个数组中 好对子 的数目
     * Tips: O(n^2) 时间复杂对会超时
     * 使用HashMap简化统计方式：nums[i] + rev(nums[j]) = nums[j] + rev(nums[i]) ①
     * 对公式1两边转换计算可以得到   nums[i] - rev(nums[i]) = nums[j] - rev(nums[j]) ②
     * 有：f(i) = f(j)   便可以找到  i 和 j 的关系对，使用HashMap可以统计是否出现过，
     * value = f(i) value 出现过5次，hashmap中的统计值4，1 + 2 + 3 + 4，就是一共出现的对数
     *
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> h = new HashMap<>();
        for (int i : nums) {
            int temp = i, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            // 这里有一个细节，res 第一次 + 0 操作，此时的值，并没有 put 到哈希表中
            res = (res + h.getOrDefault(i - j, 0)) % MOD;
            h.put(i - j, h.getOrDefault(i - j, 0) + 1);
        }
        return res;
    }

    /**
     * No. 1817 查找用户活跃分钟数,
     * Tips: HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
     *
     * @param logs
     * @param k
     * @return
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        HashMap<Integer, HashSet<Integer>> hashMap = new HashMap<>();
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            hashMap.putIfAbsent(id, new HashSet<Integer>());
            hashMap.get(id).add(time);
        }

//        Set keyset = hashMap.keySet();
//        for (Object key : keyset) {
//            int size = hashMap.get(key).size();
//            res[size-1]++;
//        }

        for (Set<Integer> times : hashMap.values()) {
            int size = times.size();
            res[size - 1]++;
        }
        return res;
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
        sort(nums1);

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
     * No. 1828 统计一个圆中点的个数
     *
     * @param points
     * @param queries
     * @return
     */
    public int[] countPoints(int[][] points, int[][] queries) {
        int queryTimes = queries.length;
        int[] ans = new int[queryTimes];
        for (int i = 0; i < queryTimes; i++) {
            for (int j = 0; j < points.length; j++) {
                if (pointInCircle(points[j], queries[i])) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    public boolean pointInCircle(int[] point, int[] circle) {
        float x1 = point[0], y1 = point[1];
        float x2 = circle[0], y2 = circle[1];
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)) <= circle[2];
    }

    /**
     * No. 1844 将所有数字用字符替换
     *
     * @param s
     * @return
     */
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length() - 1; i += 2) {
            sb.setCharAt(i + 1, shift_1844(s.charAt(i), Integer.parseInt(s.substring(i + 1, i + 2))));
        }
        return sb.toString();
    }

    public char shift_1844(char ch, int step) {
        return (char) (ch + step);
    }

    /**
     * No. 1877 数组中最大数对和的最小值
     *
     * @param nums
     * @return
     */
    public int minPairSum(int[] nums) {
        sort(nums);
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (int left = 0, right = nums.length - 1; left < right; right--, right++) {
//            max = Math.max(max, nums[left] + nums[right]);
            temp = nums[left] + nums[right];
            max = temp > max ? temp : max;
        }
        return max;
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
     * No. 2073 买票需要的时间
     * @param tickets
     * @param k
     * @return
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int times = 0;
        // 如果 k 位置的人，需要购买的票的数量大于 0，那么需要重新排队，进行下一次循环
        while (tickets[k] != 0) {
            // 从头到尾，遍历数组，相当于按顺序排队
            for (int i = 0; i < tickets.length; i++) {
                // 如果当前人，需要购买的票为0，则直接跳过
                if (tickets[i] != 0) {
                    tickets[i]--;
                    times++;
                    // 如果进行过一次购买行为，发现 k 位置的人，不需要再继续购买了，程序直接返回已经统计过的 times 的结果
                    if (tickets[k] == 0) {
                        return times;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * No. 2087 网格图中机器人回家的最小代价
     *
     * @param startPos
     * @param homePos
     * @param rowCosts
     * @param colCosts
     * @return
     */
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int rowStart = startPos[0];
        int rowEnd = homePos[0];
        int colStart = startPos[1];
        int colEnd = homePos[1];
        int res = 0;

        int tmp;
        if (rowStart < rowEnd) {
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                res += rowCosts[i];
            }
        } else {
            for (int i = rowEnd; i < rowStart; i++) {
                res += rowCosts[i];
            }
        }
        if (colStart < colEnd) {
            for (int i = colStart + 1; i <= colEnd; i++) {
                res += colCosts[i];
            }
        } else {
            for (int i = colEnd; i < colStart; i++) {
                res += colCosts[i];
            }
        }
        return res;
    }

    /**
     * No. 2089 找出数组排序后的目标下标
     *
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        sort(nums);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
            if (nums[i] > target) {
                break;
            }
        }
        return ans;
    }

    /**
     * No. 2096 从二叉树一个节点到另一个节点每一步的方向
     *
     * @param root
     * @param startValue
     * @param destValue
     * @return
     */
    String path = "";

    public String getDirections(TreeNode root, int startValue, int destValue) {

        dfs(root, startValue, new StringBuilder());
        String path1 = path;
        path = "";
        dfs(root, destValue, new StringBuilder());
        String path2 = path;

        char[] c1 = path1.toCharArray();
        char[] c2 = path2.toCharArray();
        int index = 0;

        // 找出公共路径
        while (index < c1.length && index < c2.length && c1[index] == c2[index]) {
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c1.length - index; ++i) {
            sb.append("U");
        }

        sb.append(path2.substring(index));

        return sb.toString();
    }

    // 找出根节点到目标节点的路径
    public boolean dfs(TreeNode root, int target, StringBuilder sb) {

        if (root.val == target) {
            path = sb.toString();
            return true;
        }

        if (root.left != null) {
            sb.append("L");
            if (dfs(root.left, target, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);
        }

        if (root.right != null) {
            sb.append("R");
            if (dfs(root.right, target, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);
        }

        return false;
    }

    /**
     * No. 2115 从给定原材料中找到所有可以做出的菜
     *     Tips: 拓扑排序，广度优先搜索，不断添加入度为0的节点(入度为0表示，这个菜品可以直接获得)
     * @param recipes
     * @param ingredients
     * @param supplies
     * @return
     */
//    public List<String> FindAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
//
//    }

    /**
     * No. 2119 翻转两次的数字
     *
     * @param num
     * @return
     */
    public boolean isSameAfterReversals(int num) {
        return num == 0 || num % 10 != 0;
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
     * No. 2235 两整数相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * No. 2236 判断根节点是否等于子节点之和
     *
     * @param root
     * @return
     */
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

    /**
     * No. 2265 统计值等于子树平均值的节点数
     *
     * @param root
     * @return
     */
    int count_2265 = 0, res_2265 = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs_2265(root);
        return res_2265;
    }

    public int dfs_2265(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int count = count_2265;
        ++count_2265;
        int sum_left = dfs_2265(root.left);
        int sum_right = dfs_2265(root.right);
        int sum = root.val + sum_left + sum_right;
        if (sum / (count_2265 - count) == root.val) {
            res_2265++;
        }
        return sum;
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
     * No. 2295 替换数组中的元素
     *
     * @param nums
     * @param operations
     * @return
     */
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        int index;
        for (int i = 0; i < operations.length; i++) {
            index = hashMap.get(operations[i][0]);
            nums[index] = operations[i][1];
            hashMap.put(operations[i][1], index);
        }
        return nums;
    }

    /**
     * No. 2299 强密码检验器II
     *
     * @param password
     * @return
     */
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLowerChar = false;
        boolean hasUpperChar = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        char cur;

        for (int i = 0; i < password.length(); i++) {
            cur = password.charAt(i);
            if (cur >= 'a' && cur <= 'z') {
                hasLowerChar = true;
            }
            if (cur >= 'A' && cur <= 'Z') {
                hasUpperChar = true;
            }
            if (cur >= '0' && cur <= '9') {
                hasDigit = true;
            }
            switch (cur) {
                case '!':
                case '@':
                case '#':
                case '$':
                case '%':
                case '^':
                case '&':
                case '*':
                case '(':
                case ')':
                case '-':
                case '+':
                    hasSpecialChar = true;
                    break;
            }
            if (i != password.length() - 1 && password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }
        return hasLowerChar && hasUpperChar && hasDigit && hasSpecialChar;
    }

    /**
     * No. 2301 替换字符后匹配
     *
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
     * No. 2309 兼具大小写的最好英文字母
     * Tips: A -> 65, a -> 97     UpCase: < 92; lowCase: > 96
     *
     * @param s
     * @return
     */
    public String greatestLetter(String s) {
        StringBuilder resStr = new StringBuilder("");
        HashSet<Character> mySet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mySet.contains(ch)) {
                resStr.append(Character.toUpperCase(ch));
            } else {
                if (ch > 96) {
                    mySet.add((char) (ch - 32));
                } else {
                    mySet.add((char) (ch + 32));
                }
            }
        }
        if (resStr.length() == 0) {
            return "";
        }
        char[] chars = resStr.toString().toCharArray();
        sort(chars);
        return String.valueOf(chars[chars.length]);
    }

    /**
     * No. 2325 解密消息
     *
     * @param key
     * @param message
     * @return
     */
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        StringBuilder res = new StringBuilder();
        int index = 0;
        char ch;
        hashMap.put(' ', ' ');
        for (int i = 0; i < key.length() && index < 26; i++) {
            ch = key.charAt(i);
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, (char) ('a' + index++));
            }
        }

        for (int i = 0; i < message.length(); i++) {
            res.append(hashMap.get(message.charAt(i)));
        }
        return res.toString();
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
            fill(res[i], -1);
        }

        int count = 0;
        int restRow = m;
        int restCow = n;
        int reachEnd = 0;

        while (restRow > 0 && restCow > 0 && reachEnd != 1) {
            if (m == n && count == m / 2) {
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
     * No. 2331 计算布尔二叉树的值
     *
     * @param root
     * @return
     */
    public boolean evaluateTree_(TreeNode root) {
        if (root.left == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree_(root.left) || evaluateTree_(root.right);
        } else {
            return evaluateTree_(root.left) && evaluateTree_(root.right);
        }
    }

    public boolean boo1, boo2;

    public boolean evaluateTree(TreeNode root) {
        Stack<Boolean> stack_2331 = new Stack<>();
        dfs_2331(root, stack_2331);
        return stack_2331.pop();
    }

    public void dfs_2331(TreeNode root, Stack<Boolean> stack) {
        if (root == null) {
            return;
        }
        dfs_2331(root.left, stack);
        dfs_2331(root.right, stack);
        if (root.val < 2) {
            switch (root.val) {
                case 0:
                    stack.push(false);
                    break;
                case 1:
                    stack.push(true);
                    break;
            }
        } else {
            boo1 = stack.pop();
            boo2 = stack.pop();
            switch (root.val) {
                case 2:
                    stack.push(boo1 || boo2);
                    break;
                case 3:
                    stack.push(boo1 && boo2);
                    break;
            }
        }
    }

    /**
     * No. 2335 装满被子需要的最短总时长
     * Tips: 数学计算题，分类讨论三个数字的大小情况
     *
     * @param amount
     * @return
     */
    public int fillCups(int[] amount) {
        sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }

    /**
     * No. 2341 数组能形成多少数对
     *
     * @param nums
     * @return
     */
    public int[] numberOfPairs(int[] nums) {
        int count[] = new int[101];
        int pairs = 0, singles = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == 0) {
                count[nums[i]]++;
            } else {
                count[nums[i]] = 0;
                pairs++;
            }
        }
        for (int i = 0; i < 101; i++) {
            if (count[i] != 0) {
                singles++;
            }
        }
        return new int[]{pairs, singles};
    }

    /**
     * No. 2347 最好的扑克手牌
     *
     * @param ranks
     * @param suits
     * @return
     */
    public String bestHand(int[] ranks, char[] suits) {
        int[] count_ranks = new int[13];
        int[] count_suits = new int[4];
        int max_ranks = 0, max_suits = 0;
        for (int i = 0; i < 5; i++) {
            count_ranks[ranks[i] - 1]++;
            count_suits[suits[i] - 'a']++;
            max_ranks = Math.max(max_ranks, count_ranks[ranks[i] - 1]);
            max_suits = Math.max(max_suits, count_suits[suits[i] - 'a']);
        }
        if (max_suits == 5) {
            return "Flush";
        } else if (max_ranks >= 3) {
            return "Three of a Kind";
        } else if (max_ranks == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
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

    /**
     * No. 2352 相等行列对
     *
     * @param grid
     * @return
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        int[][] gridT = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gridT[j][i] = grid[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Arrays.equals(grid[i], gridT[j])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * No. 2357 使数组中所有元素都等于零
     *
     * @param nums
     * @return
     */
    public int minimumOperations(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            hashSet.add(nums[i]);
        }
        return hashSet.size();
    }

    /**
     * No. 2363 合并相似的物品
     *
     * @param items
     * @param items2
     * @return
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int[] v : items1) {
            hashMap.put(v[0], hashMap.getOrDefault(v[0], 0) + v[1]);
        }
        for (int[] v : items2) {
            hashMap.put(v[0], hashMap.getOrDefault(v[0], 0) + v[1]);
        }
        List<List<Integer>> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            List<Integer> pair = new ArrayList<>();
            pair.add(k);
            pair.add(v);
            ret.add(pair);
        }
        Collections.sort(ret, (a, b) -> a.get(0) - b.get(0));
        return ret;
    }

    /**
     * No. 2367 算数三元组的数目
     *
     * @param nums
     * @param diff
     * @return
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            for (int j = i + 1; j < nums.length - 1; ++j) {
                if (nums[j] - nums[i] != diff) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[k] - nums[j] == diff) {
                        ++count;
                    }
                    if (nums[k] - nums[j] > diff) {
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * No. 2373 矩阵中的局部最大值
     *
     * @param grid
     * @return
     */
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ret = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        ret[i][j] = Math.max(ret[i][j], grid[x][y]);
                    }
                }
            }
        }
        return ret;
    }

    /**
     * No. 2379 得到K歌黑块的最少涂色次数
     * Tips: 滑动窗口：用K长度的窗口，滑动遍历整个blocks长度，取窗口内的白色块的最小值
     *
     * @param blocks
     * @param k
     * @return
     */
    public int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= blocks.length() - k; i++) {
            int count = 0;
            for (int j = 0; j < k; j++) {
                if (blocks.charAt(i + j) == 'W') {
                    ++count;
                }
            }
            ans = Math.min(ans, count);
        }
        return ans;
    }

    /**
     * No. 2383 赢得比赛需要的最少训练时长
     *
     * @param initialEnergy
     * @param initialExperience
     * @param energy
     * @param experience
     * @return
     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        for (int i = 0; i < energy.length; i++) {
            initialEnergy -= energy[i];
        }
        int sum = 0;
        for (int i = 0; i < experience.length; i++) {
            if (initialExperience > experience[i]) {
                initialExperience += experience[i];
            } else {
                sum += 1 + (experience[i] - initialExperience);
                initialExperience = 2 * experience[i] + 1;
            }
        }
        if (initialEnergy > 0) {
            return sum;
        } else {
            return Math.abs(initialEnergy) + sum + 1;
        }
    }

    /**
     * No. 2395 和相等的子数组
     *
     * @param nums
     * @return
     */
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum = nums[i] + nums[i + 1];
            if (hashSet.contains(sum)) {
                return true;
            } else {
                hashSet.add(sum);
            }
        }
        return false;
    }

    /**
     * No. 2399 检查相同字母间的距离
     *
     * @param s
     * @param distance
     * @return
     */
    public boolean checkDistances(String s, int[] distance) {
        int[] cmp = new int[26];
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                cmp[ch - 97] = i;
            } else {
                cmp[ch - 97] = i - cmp[ch - 97] - 1;
                if (cmp[ch - 97] != distance[ch - 97]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * No. 2404 出现最频繁的偶数元素
     *
     * @param nums
     * @return
     */
    public int mostFrequentEven(int[] nums) {
        int ans_num = -1, ans_count = -1;
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
            }
        }
        Set<Integer> keys = hashmap.keySet();
        for (int key : keys) {
            int count = hashmap.get(key);
            if (count > ans_count) {
                ans_num = key;
                ans_count = count;
            }
            if (count == ans_count && key < ans_num) {
                ans_num = key;
            }
        }
        return ans_num;
    }

    /**
     * No. 2409 统计共同度过的日子数
     * 日期字符串格式 MM-DD [08-16]
     *
     * @param arriveAlice Alice 到达的时间
     * @param leaveAlice  Alice 离开的时间
     * @param arriveBob   Bob 到达的时间
     * @param leaveBob    Bob 离开的时间
     * @return 返回时间重叠的数量
     */
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int indexAliceArrive = indexCount_2404(arriveAlice), indexAliceLeave = indexCount_2404(leaveAlice);
        int indexBobArrive = indexCount_2404(arriveBob), indexBobLeave = indexCount_2404(leaveBob);

        int left = Math.max(indexAliceArrive, indexBobArrive);
        int right = Math.min(indexAliceLeave, indexBobLeave);

        int ans = right - left + 1;
        return ans > 0 ? ans : 0;
    }

    public int indexCount_2404(String date) {
        int ans = 0;
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");
        int month = Integer.parseInt(split[0]) - 1;
        int day = Integer.parseInt(split[1]);
        for (int i = 0; i < month; i++) {
            ans += months[i];
        }
        return ans + day;
    }

    /**
     * No. 2413 最小偶倍数
     *
     * @param n
     * @return
     */
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }

    /**
     * No. 2418 按身高排序
     *
     * @param names
     * @param heights
     * @return
     */
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        sort(indices, (a, b) -> heights[b] - heights[a]);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[indices[i]];
        }
        return res;
    }

    @Test
    public void tttt() {
        String[] names = new String[]{"Mary", "John", "Emma"};
        int[] heights = new int[]{180, 165, 170};
        String[] strings = sortPeople(names, heights);
        System.out.println(Arrays.toString(strings));
    }


    /**
     * No. 2423 删除字符使频率相同
     */
    public boolean equalFrequency(String word) {
        int[] charCount = new int[26];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            charCount[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                continue;
            }
            charCount[i]--;
            HashSet<Integer> frequency = new HashSet<>();
            for (int f : charCount) {
                if (f > 0) {
                    frequency.add(f);
                }
            }
            if (frequency.size() == 1) {
                return true;
            }
            charCount[i]++;
        }
        return false;
    }

    @Test
    public void test2423() {
        System.out.println(equalFrequency("aazz"));
    }

    /**
     * No. 2427 公因子的数目
     *
     * @param a
     * @param b
     * @return
     */
    public int commonFactors(int a, int b) {
        int min = a > b ? b : a;
        int count = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * No. 2441 与对应负数同时存在的最大正整数
     *
     * @param nums
     * @return
     */
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = -1;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (num > 0) {
                if (set.contains(0 - num)) {
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }

    /**
     * No. 判断两个事件是否存在冲突
     *
     * @param event1
     * @param event2
     * @return
     */
    public boolean haveConflict(String[] event1, String[] event2) {
//        int event1_start = timeStrToInt(event1[0]);
//        int event1_end = timeStrToInt(event1[1]);
//        int event2_start = timeStrToInt(event2[0]);
//        int event2_end = timeStrToInt(event2[1]);
//
//        if (event2_start > event1_end || event1_start > event2_end) {
//            return false;
//        }
//        return true;
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }

    public int timeStrToInt(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);
        return hour * 60 + minutes;
    }

    /**
     * No. 2451 差值数组不同的字符串
     * tips:
     * 0. 将第一个元素转换成数组后，存入集合当中，并假设它不是要找的元素
     * 1. 遍历后面的所有元素，如果这个元素已经存在于集合中，那么直接跳过，如果这个元素不存在集合中，则是目标元素
     *
     * @param words
     * @return
     */
    public String oddString(String[] words) {
        int[] diff0 = getWord2Array(words[0]);
        int[] diff1 = getWord2Array(words[1]);

        if (Arrays.equals(diff0, diff1)) {
            for (int i = 2; i < words.length; i++) {
                if (!Arrays.equals(diff0, getWord2Array(words[i]))) {
                    return words[i];
                }
            }
        }
        return Arrays.equals(diff0, getWord2Array(words[2])) ? words[1] : words[0];
    }

    public int[] getWord2Array(String word) {
        int[] diff = new int[word.length() - 1];
        for (int i = 1; i < word.length(); i++) {
            diff[i - 1] = word.charAt(i) - word.charAt(i - 1);
        }
        return diff;
    }

    /**
     * No. 2455 可被3整除的偶数的平均值
     *
     * @param nums
     * @return
     */
    public int averageValue(int[] nums) {
        int count = 0, sum = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    /**
     * No. 2460 对数组执行操作
     *
     * @param nums
     * @return
     */
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }

        while (left < nums.length) {
            nums[left++] = 0;
        }

        return nums;
    }

    /**
     * No. 2465 不同的平均值数目
     *
     * @param nums
     * @return
     */
    public int distinctAverages(int[] nums) {
        HashSet<Float> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            float ave = ((float) nums[i] + (float) nums[j]) / 2;
            set.add(ave);
        }
        return set.size();
    }

    /**
     * No. 2469 温度转换
     *
     * @param celsius
     * @return
     */
    public double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] = celsius * 1.80 + 32.00;
        return ans;
    }

    /**
     * No. 2475 数组中不等三元组的数目
     * @param nums
     * @return
     */
    public int unequalTriplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[k] != nums[j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * LCP 06. 拿硬币
     *
     * @param coins
     * @return
     */
    public int minCount(int[] coins) {
        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] % 2 == 0) {
                sum += coins[i] / 2;
            } else {
                sum += ((coins[i] / 2) + 1);
            }
        }
        return sum;
    }

    /**
     * No. 2517 礼盒的最大甜蜜度
     * Tips: 局部最小，全局最大。贪心 + 二分查找
     * 对甜度区间进行二分查找，二分查找的判定条件采用贪心算法
     *
     * @param price
     * @param k
     * @return
     */
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check_2517(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check_2517(int[] price, int k, int tastiness) {
        int prev = Integer.MIN_VALUE / 2;
        int cnt = 0;
        for (int p : price) {
            if (p - prev >= tastiness) {
                ++cnt;
                prev = p;
            }
        }
        return cnt >= k;
    }

    /**
     * No. 2559 统计范围内的原因字符串数
     *
     * @param words
     * @param queries
     * @return
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSums = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int value = isVowelString(words[i]) ? 1 : 0;
            prefixSums[i + 1] = prefixSums[i] + value;
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int start = queries[i][0], end = queries[i][1];
            ans[i] = prefixSums[end + 1] - prefixSums[start];
        }

        return ans;
    }

    public boolean isVowelString(String word) {
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));
    }

    public boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /**
     * No. 2611 老鼠和奶酪
     *     贪心法 + 优先队列
     *     第一只老鼠可以吃K个，第二只老鼠可以吃任意一个。使得得分最高。
     *     1. 假设，第二只老鼠吃了所有的奶酪
     *     2. 需要从 所有的奶酪中，找出 K 个 -reward[2] + reward[1] 最大值【即，这k个奶酪，给第一只老鼠吃】
     *     3. 上述的前 K 个最大值，可以使用 优先队列保存
     * @param reward1
     * @param reward2
     * @param k
     * @return
     */
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        int n = reward1.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            pq.offer(reward1[i] - reward2[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }

    /**
     * LCP. 07 传递信息
     * Tips: 深度优先搜索，利用系统栈，不用自己维护栈
     * 广度优先搜索，需要单独维护一个队列，当前队列的 size ，即为一层的宽度（第 k 层，n-1 节点出现的次数即是结果）
     *
     * @param n
     * @param relation
     * @param k
     * @return
     */
    // ways 计算一共有多少种方法
    public int ways_lcp07, n_lcp07, k_lcp07;
    List<List<Integer>> edges_lcp07;

    public int numWays(int n, int[][] relation, int k) {
        ways_lcp07 = 0;
        this.n_lcp07 = n;
        this.k_lcp07 = k;
        edges_lcp07 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            edges_lcp07.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0], des = edge[1];
            edges_lcp07.get(src).add(des);
        }

        dfs_lcp07(0, 0);
        return ways_lcp07;
    }

    public void dfs_lcp07(int index, int steps) {
        if (steps == k_lcp07) {
            if (index == k_lcp07 - 1) {
                ways_lcp07++;
            }
            return;
        }
        // 这里相当于获得了，经过 index 节点可以到达的所有下一个节点，他们分别进栈
        List<Integer> list = edges_lcp07.get(index);
        for (int nextIndex : list) {
            dfs_lcp07(nextIndex, steps + 1);
        }
    }

    // 广度优先搜索
    public int numWays_bfs(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] edge : relation) {
            int src = edge[0];
            int des = edge[1];
            edges.get(src).add(des);
        }

        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edges.get(index);
                for (int nextIndex : list) {
                    queue.offer(nextIndex);
                }
            }
        }
        int ways = 0;
        if (steps == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == n - 1) {
                    ways++;
                }
            }
        }
        return ways;
    }

//    /**
//     * LCP 13. 寻宝
//     * @param maze
//     * @return
//     */
//    public int minimalSteps(String[] maze) {
//
//    }


}


// No. 1575 统计所有可行路径，需要重新逐步推算



















